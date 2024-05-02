package Model;

public class SignUpModel {
    private String username;
    private int id;
    private String className;
    private String password;
    private String passwordConfirm;

    public SignUpModel(String username, int id, String className, String password, String passwordConfirm) {
        this.username = username;
        this.id = id;
        this.className = className;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
