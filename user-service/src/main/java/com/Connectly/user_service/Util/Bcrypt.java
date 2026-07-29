package com.Connectly.user_service.Util;

import static org.mindrot.jbcrypt.BCrypt.*;

public class Bcrypt {
    public static String hash(String s){
        return hashpw(s, gensalt());
    }

    public static boolean match(String passwordText, String hashedPassword){
        return checkpw(passwordText, hashedPassword);
    }
}
