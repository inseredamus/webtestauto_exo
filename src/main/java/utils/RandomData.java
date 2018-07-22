package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomData {

    public static String getRandomEmail(){
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_-.";
        final int N = alphabet.length();
        String result = "";
        Random r = new Random();
        for (int i = 0; i < 12; i++) {
            result = result + alphabet.charAt(r.nextInt(N));
        }
        return result+"@wegwerfmail.nowhere";
    }

    public static String getRandomHfEmail(){
        String timestamp = String.valueOf(new Date().getTime());
        return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
    }
}
