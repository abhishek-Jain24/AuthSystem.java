package service;

import model.Token;
import model.User;

public class SessionManager {

    //Inner Class
    public class Session {
        private final User user;
        private final Token token;
        private final long loginTime;

        public Session(User user) {
            this.user = user;
            this.token = new Token();
            this.loginTime = System.currentTimeMillis();
        }

        public User getUser() { return user; }
        public Token getToken() { return token; }
        public long getLoginTime() { return loginTime; }

        public void show() {
            System.out.println("Session for " + user.getUsername()
                    + " | Token: " + token.getValue());
        }

        public boolean isValid() {
            return !token.isExpired();
        }
    }


    public Session createSession(User user) {
        return new Session(user);
    }
}