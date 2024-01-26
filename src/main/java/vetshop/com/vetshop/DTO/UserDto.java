package vetshop.com.vetshop.DTO;

import lombok.Getter;
import lombok.Setter;
import vetshop.com.vetshop.Entities.User;
import vetshop.com.vetshop.Enum.UserRole;

@Getter
@Setter
public class UserDto {
    private String login;
    private String password;

    private UserRole role;

    public UserDto(){}

    public UserDto(User user){
        this.login = user.getLogin();
        this.password = user.getLogin();
        this.role = user.getRole();
    }
}
