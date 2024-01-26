package vetshop.com.vetshop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vetshop.com.vetshop.DTO.LoginResponseDto;
import vetshop.com.vetshop.DTO.UserDto;
import vetshop.com.vetshop.Entities.User;
import vetshop.com.vetshop.Repositories.IUserRepository;
import vetshop.com.vetshop.infra.security.TokenService;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto userDto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userDto.getLogin(), userDto.getPassword());
        var auth  = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDto   userDto){
        //verifico se o login do usuario já existe e se já existir passo uma exeption
        if(iUserRepository.findByLogin(userDto.getLogin()) != null){
            return ResponseEntity.badRequest().build();
        }

        //transformo a senha em um hash para não salvar ela diretamente ao banco
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());

        //passo a senha encriptografada para o banco
        User newUser = new User(userDto.getLogin(), encryptedPassword, userDto.getRole());

        iUserRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
