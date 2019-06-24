package JAVAThree.JAVACollection.Map;

/**
 * Create by czq
 * time on 2019/6/21  9:28
 */
public class User {
    public String username;
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

//    @Override
//    public int hashCode() {
//        int result = username.hashCode();
//        result = 31 * result + password.hashCode();
//        return result;
//    }
}
