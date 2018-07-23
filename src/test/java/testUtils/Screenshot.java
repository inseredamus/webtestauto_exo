package testUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

class Screenshot {

    static void clearScreenshotDirectory(){
        if(new File("screenshots").exists()) {
            try {
                FileUtils.cleanDirectory(new File("screenshots"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getScreenshotName(String testname){
        String timeFormat = new SimpleDateFormat("HH-mm-ss.SSS").format(new Date());
        return testname+"_"+timeFormat+".png";
    }
}
