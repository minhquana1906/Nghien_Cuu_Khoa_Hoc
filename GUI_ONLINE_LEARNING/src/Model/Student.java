package Model;

public class Student {
    private int id;
    private String userName;
    private String  className;
    private String imagePath;
    private String password;

    public Student(int id, String userName, String className, String imagePath, String password) {
        this.id = id;
        this.userName = userName;
        this.className = className;
        this.imagePath = imagePath;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
