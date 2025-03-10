package com.automation.utils;

import java.util.Random;

public class RandomDataUtils {

    private static final Random random = new Random();
    //Required data for sign up,
    // Generate Random Username
    public static String getUsername() {
        return "user" + random.nextInt(10000);
    }

    // Generate Random Password
    public static String getPassword() {
        return "Pass@" + random.nextInt(10000);
    }

    // Generate Random Email
    public static String getEmail() {
        return "user" + random.nextInt(10000) + "@test.com" ;
        }
        
     // Required Data for Contact Form
        public static String getContactName() {
            return "Contact" + random.nextInt(10000);
        }

        public static String getContactEmail() {
            return "contact" + random.nextInt(10000) + "@test.com";
        }

        public static String getContactMessage() {
            return "This is an automated test message " + random.nextInt(1000);
        }
        
        
    }

