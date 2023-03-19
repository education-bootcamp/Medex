package com.developersstack.medex.util;


import org.mindrot.BCrypt;

public class PasswordConfig {
    // abc ==> abc
    // abc ==> dsklfjsdfljsdflkjd
    public String encrypt(String text){
        return BCrypt.hashpw(text,BCrypt.gensalt(10));
    }
    public boolean decrypt(String rowPassword, String encryptedPassword){
        return BCrypt.checkpw(rowPassword,encryptedPassword);
    }

}
