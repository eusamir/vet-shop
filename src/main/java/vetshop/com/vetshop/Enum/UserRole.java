package vetshop.com.vetshop.Enum;

public enum UserRole {
    ADMIN("admin"),
    CONSUMER("cliente"),
    EMPLOYEE("funcionario");

    private String role;
    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
