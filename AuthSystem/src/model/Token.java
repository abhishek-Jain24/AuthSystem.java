package model;

import java.util.UUID;

public final class Token {

    //Immutable fields
    private final String value;
    private final long createdAt;
    private final long expiresAt;

    // Auto-generate --> No need to pass any data
    //Constructor1:-30 min default
    public Token() {
        this.value = UUID.randomUUID().toString();                //Unique token value
        this.createdAt = System.currentTimeMillis();             //Current time
        this.expiresAt = this.createdAt + (30 * 60 * 1000);     // 30 min = 1,800,000 ms
    }

    //Constructor 2 :  Custom expiry
    public Token(long validityMillis) {
        this.value = UUID.randomUUID().toString();
        this.createdAt = System.currentTimeMillis();
        this.expiresAt = this.createdAt + validityMillis;
    }

    // Getters
    public String getValue() { return value; }
    public long getCreatedAt() { return createdAt; }
    public long getExpiresAt() { return expiresAt; }


    //Check token is expired or not
    public boolean isExpired() {
        return System.currentTimeMillis() > expiresAt;
    }

    @Override
    public String toString() {
        long remaining = (expiresAt - System.currentTimeMillis()) / 1000;
        return "Token[" + value + ", expires in "
                + remaining + "s left]";
    }
}