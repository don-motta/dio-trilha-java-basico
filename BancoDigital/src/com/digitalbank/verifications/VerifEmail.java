package com.digitalbank.verifications;

public class VerifEmail {
    private String email;

    public boolean isValidEmail (String email) {
        this.email = email;
        if (this.email.contains("@") && this.email.contains(".")) {
            return true;
        }
        return false;
    }
}
