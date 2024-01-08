package vetshop.com.vetshop.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vetshop.com.vetshop.Enum.UserRole;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTH")
public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID")
    private UUID id;
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    @Column(name = "ROLE", nullable = false)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("CONSUMER" ));
        }else{
            return List.of(new SimpleGrantedAuthority("CONSUMER"));
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
