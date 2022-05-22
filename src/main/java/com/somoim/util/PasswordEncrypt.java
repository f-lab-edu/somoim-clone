package com.somoim.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypt {
    public String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean comparePassword(String org, String hashed) {
        return BCrypt.checkpw(org, hashed);
    }
}
