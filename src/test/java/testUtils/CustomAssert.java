package testUtils;

import org.apache.log4j.Logger;

import java.util.List;

public class CustomAssert {
    private static Logger logger = Logger.getLogger(CustomAssert.class);
    private static String root = "||||| ASSERT : ";

    public static void assertEqual(String comparedObject, int actual, int expected) {
        Integer actualInt = actual;
        Integer expectedInt = expected;
        assertEqual(comparedObject, actualInt, expectedInt);
    }

    public static void assertEqual(String comparedObject, Object actual, Object expected) {
        if(!equalsRegardingNull(expected, actual)) {
            logger.error(root+expected+" (EXPECTED) IS NOT EQUAL TO "+actual+" (ACTUAL)");
            if(expected instanceof String && actual instanceof String) {
                throw new AssertionError(String.format("Expected %s [%s], but [%s] found", comparedObject, expected, actual));
            } else {
                throw new AssertionError(String.format("Expected %s [%s], but [%s] found", comparedObject, expected, actual));
            }
        }else{
            logger.info(root+comparedObject+" AS EXPECTED");
        }
    }

    public static void assertTrue(String comparedObject, boolean actual) {
        if(!actual) {
            logger.error(root+comparedObject+" :: IS INCORRECT");
            throw new AssertionError(String.format("EXPECTED -> '%s', but it's incorrect (result is '%s')", comparedObject, actual));
        }else{
            logger.info(root+comparedObject+" AS EXPECTED");
        }
    }

    public static void assertTrue(String comparedObject, boolean actual, String errors) {
        if(!actual) {
            logger.error(root+comparedObject+" :: IS INCORRECT");
            throw new AssertionError(String.format("EXPECTED -> '%s', but it's incorrect (result is '%s'). \nThe errors are : "+errors, comparedObject, actual));
        }else{
            logger.info(root+comparedObject+" AS EXPECTED");
        }
    }

    public static void assertTrue(String comparedObject, boolean actual, List<String> errors) {
        if(!actual) {
            String errorsFormat = "";
            for(String er : errors){
                errorsFormat = errorsFormat+"\n"+er;
            }
            logger.error(root+comparedObject+" :: IS INCORRECT");
            throw new AssertionError(String.format("EXPECTED -> '%s', but it's incorrect (result is '%s'). \nThe errors are : "+errors, comparedObject, actual));
        }else{
            logger.info(root+comparedObject+" AS EXPECTED");
        }
    }

    public static void assertFalse(String comparedObject, boolean actual) {
        if(actual) {
            logger.error(root+comparedObject+" :: IS INCORRECT");
            throw new AssertionError(String.format("EXPECTED -> '%s', but it's incorrect (result is '%s')", comparedObject, actual));
        }else{
            logger.info(root+comparedObject+" AS EXPECTED");
        }
    }

    //for hascrashed, use the method hasCrashed in generalPageService
    public static void assertCrash(String describedAction, boolean hascrashed) {
        if(hascrashed) {
            logger.error(root+"The App Crashed by "+describedAction);
            throw new AssertionError("!!!!!APP CRASHED!!!!!, by "+describedAction);
        }else{
            logger.info(root+"By "+describedAction+", the app is not crashed AS EXPECTED");
        }
    }

    private static boolean equalsRegardingNull(Object expected, Object actual) {
        return expected == null ? actual == null : expected.equals(actual);
    }
}


