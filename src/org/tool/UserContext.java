package org.tool;
import org.bean.*;
public class UserContext implements AutoCloseable {

    static final ThreadLocal<User> current = new ThreadLocal<User>();

    public UserContext(User user) {
        current.set(user);
    }

    public static User getCurrentUser() {
        return current.get();
    }
    public static void destroy(){
    	current.remove();
    }
    public void close() {
        current.remove();
    }
}
