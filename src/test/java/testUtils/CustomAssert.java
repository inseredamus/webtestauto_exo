package testUtils;

import org.apache.log4j.Logger;

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
            logger.error(root+comparedObject+" "+expected+" (EXPECTED) IS NOT EQUAL TO "+actual+" (ACTUAL)");
            if(expected instanceof String && actual instanceof String) {
                throw new AssertionError(String.format("Expected %s [%s], but [%s] found", comparedObject, expected, actual));
            } else {
                throw new AssertionError(String.format("Expected %s [%s], but [%s] found", comparedObject, expected, actual));
            }
        }else{
            logger.info(root+comparedObject+" is "+expected+" AS EXPECTED");
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

    private static boolean equalsRegardingNull(Object expected, Object actual) {
        return expected == null ? actual == null : expected.equals(actual);
    }
}


