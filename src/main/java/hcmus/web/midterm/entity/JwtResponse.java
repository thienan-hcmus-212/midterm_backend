package hcmus.web.midterm.entity;

import hcmus.web.midterm.payload.UserPayload;

public class JwtResponse {

    private UserPayload payload;
    private String jwtToken;

    public JwtResponse(User user, String jwtToken) {
        this.payload = new UserPayload(user);
        this.jwtToken = jwtToken;
    }

    public UserPayload getPayload() {
        return payload;
    }

    public void setPayload(UserPayload payload) {
        this.payload = payload;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
