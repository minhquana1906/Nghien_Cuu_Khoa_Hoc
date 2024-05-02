package Model;

public class UserSession {
    private static UserSession instance;
    private Student user;

    private UserSession(Student user) {
        this.user = user;
    }

    public static UserSession getInstance(Student user) {
        if(instance == null) {
            instance = new UserSession(user);
        }
        return instance;
    }

    public Student getUser() {
        return user;
    }

    public void cleanUserSession() {
        user = null;
        instance = null;
    }
}
