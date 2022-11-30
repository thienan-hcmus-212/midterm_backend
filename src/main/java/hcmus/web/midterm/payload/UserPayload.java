package hcmus.web.midterm.payload;

import hcmus.web.midterm.entity.User;

public class UserPayload {
    private String userEmail;
    private String userLastName;
    private String userFirstName;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public UserPayload(User user) {
        this.userEmail = user.getUserEmail();
        this.userLastName = user.getUserFirstName();
        this.userFirstName = user.getUserLastName();
    }
}
