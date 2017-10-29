package com.developersdelicias.codesmells.comments.bad;

public class CommentedOutCode {


    int x = 0;


    //int y = 12;


    String name = "Rick";



    public Integer age() {

//        return 12;

        return 25;
    }

    public boolean isEnabledLicense() {

        // Uncomment this code to debug in Dev mode

//        return false;

        return LicenseManager.isEnabled();
    }




    // other logic here











    private static class LicenseManager {
        public static boolean isEnabled() {
            return true;
        }
    }
}
