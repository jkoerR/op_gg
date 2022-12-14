package com.example.droi_mvvm.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class CellphoneRoutingCheck {

    public static boolean checkSuperUser(){
//        Logger.loge("디바이스 루팅 체크 =========");
        return (checkRootedFiles() == true || checkSuperUserCommand() == true  || checkSuperUserCommand2() == true ||  checkTags() == true) ? true : false;
    }

    private static boolean checkRootedFiles(){
        final String[] files = {
                "/sbin/su",
                "/system/su",
                "/system/bin/su",
                "/system/sbin/su",
                "/system/xbin/su",
                "/system/xbin/mu",
                "/system/bin/.ext/.su",
                "/system/usr/su-backup",
                "/data/data/com.noshufou.android.su",
                "/system/app/Superuser.apk",
                "/system/app/su.apk",
                "/system/bin/.ext",
                "/system/xbin/.ext",
                "/data/local/xbin/su",
                "/data/local/bin/su",
                "/system/sd/xbin/su",
                "/system/bin/failsafe/su",
                "/data/local/su",
                "/su/bin/su"};

        for(int i = 0; i<files.length; i++){
            File file = new File(files[i]);
            if(null != file && file.exists()){
                Logger.loge("Rooted File : " + file.getAbsolutePath() + " : " + file.getName());
                return true;
            }
        }
        return false;
    }
    /*
    루팅이 된 기기는 일반적으로 Build.TAGS 값이 제조사 키값이 아닌 test 키 값을 가지고 있습니다.
    */
    private static boolean checkTags() {
        String buildTags = android.os.Build.TAGS;
        if (buildTags != null && buildTags.contains("test-keys")) {
        Logger.loge("checkTags" + buildTags);
            return true;
        }
        return false;
    }

    private static boolean checkSuperUserCommand(){
        try {
            Runtime.getRuntime().exec("su");
            Logger.loge("checkSuperUserCommand");
            return true;
        } catch (Error e){

        } catch (Exception e){

        }
        return false;
    }

    private static boolean checkSuperUserCommand2() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[] { "/system/xbin/which", "su" });
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            if (in.readLine() != null){
                Logger.loge("checkSuperUserCommand2  :  ");
                return true;
            }
            return false;
        } catch (Throwable t) {
            return false;
        } finally {
            if (process != null) process.destroy();
        }
    }

}