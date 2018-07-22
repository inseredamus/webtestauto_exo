package testUtils;

import org.apache.log4j.Logger;
import utils.LoadProperties;

public class BackendTestUtils {
    private static Logger logger;
    protected Logger testlogger = Logger.getLogger(BackendTestUtils.class);
    private LoadProperties api = new LoadProperties("application.properties");
    protected String webserviceAll = api.getPropValue("webservice.all.url");
    protected final String webserviceFormat = api.getPropValue("webservice.format.url");

    public String getWebserviceUrlWithIso2Code(String iso2Code){
        return webserviceFormat.replace("COUNTRY_ISO2CODE",iso2Code);
    }
}
