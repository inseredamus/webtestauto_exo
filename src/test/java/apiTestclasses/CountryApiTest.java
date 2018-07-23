package apiTestclasses;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import testUtils.BackendTestUtils;
import testUtils.CustomAssert;
import utils.CountryObject;
import utils.HttpClientUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CountryApiTest extends BackendTestUtils {

    private static List<String> iso2Codes = new ArrayList<>();

    /**
     * For the 2 following tests :
     *
     * Get all countries and validate that US, DE and GB were returned in the response
     * @throws IOException
     */

    @Test
    public void are_all_countries_responses_code_200_Test() throws IOException {
        int responseAllCountriesCodeStatus = 0;
        HttpClientUtil.RequestResponse response = HttpClientUtil.get(webserviceAll,new Header[]{});
        if (response != null) {
            responseAllCountriesCodeStatus = response.getStatusInt();
        }
        CustomAssert.assertTrue("The response of webservice for all countries is not null",response!=null);
        CustomAssert.assertEqual("The response code status for the webservice for all countries",responseAllCountriesCodeStatus,200);
    }

    @Test
    public void check_if_US_DE_GB_present_in_webservice_response_all_countries_Test() throws IOException {
        List<String> isoToCheck = new ArrayList<>();
        isoToCheck.add("DE");
        isoToCheck.add("GB");
        isoToCheck.add("US");

        if(iso2Codes.size()==0){
            getIso2CodeList();
        }
        testlogger.info("The found iso2Codes in the all-countries webservice are :");
        for(String iso : iso2Codes){
            testlogger.info(iso);
            Iterator<String> iter = isoToCheck.iterator();
            while (iter.hasNext()) {
                String str = iter.next();
                if (str.equals(iso))
                    iter.remove();
            }
        }

        for (String iso : isoToCheck){
            testlogger.error(iso+" is not visible in the iso2codes list");
        }

        CustomAssert.assertTrue("US, DE and GB are visible in the Iso2Code list",iso2Codes.contains("DE") && iso2Codes.contains("US") && iso2Codes.contains("GB"));
    }

    /**
     * for the 3 following tests :
     *
     * Get each country (US, DE and GB) individually and validate the response
     * @throws IOException
     */
    @Test
    public void is_US_response_code_200_Test() throws IOException {
        getResponseCodeIndividualCountry("US");
    }

    @Test
    public void is_DE_response_code_200_Test() throws IOException {
        getResponseCodeIndividualCountry("DE");
    }

    @Test
    public void is_GB_response_code_200_Test() throws IOException {
        getResponseCodeIndividualCountry("GB");
    }

    /**
     * Try to get information for inexistent countries and validate the response
     * @throws IOException
     */
    @Test
    public void check_response_data_for_each_country_Test() throws IOException {
        if(iso2Codes.size()==0){
            getIso2CodeList();
        }
        testlogger.info("The called url is : "+webserviceFormat);
        for(String iso : iso2Codes){
            testlogger.info("--------------------------------------------------------------------------------");
            testlogger.info("The iso2code injected in the url is             : "+iso);
            CountryObject data = getIndividualCountryResult(iso);
            testlogger.info("The matching message is                         : "+data.info);
            testlogger.info("The name of the country is                      : "+data.name);
            testlogger.info("The alpha2code of the country is                : "+data.alpha2code);
            testlogger.info("The alpha3code of the country is                : "+data.alpha3code);
            CustomAssert.assertEqual("The content of messages","Country found matching code ["+iso+"].",data.info);
            CustomAssert.assertTrue("The country name is consistent > 3 letters",data.name.matches(".*([A-Za-z]){3}.*"));
            CustomAssert.assertEqual("The alpha2code found is the same as the Iso2code injected in url",data.alpha2code,iso);
            CustomAssert.assertTrue("The alpha3code is built from iso2code + another letter",data.alpha3code.matches("([A-Z]){3}"));
        }
    }

    /**
     * This API has not a POST method at the moment, but it is being developed. Write a test that would validate new country addition using POST(it will not work now, but no worries).
     * Example of json body for POST is below:
     * {
     * name: "Test Country",
     * alpha2_code: "TC",
     * alpha3_code: "TCY"
     * }
     *
     * That's the reason why I have "@Ignore"d the test until the api exists.
     *
     * @throws IOException
     */

    @Ignore
    @Test
    public void check_individual_country_TestCountry_Test() throws IOException {
        CountryObject data = new CountryObject("Country found matching code [TC].","Test Country","TC","TCY");
        String injected = webserviceFormat.replace("COUNTRY_ISO2CODE",data.alpha2code);
        HttpClientUtil.RequestResponse response = HttpClientUtil.post(injected,"","",new Header[]{});
        CustomAssert.assertTrue("The response of webservice for "+data.alpha2code+" is not null",response!=null);
        CustomAssert.assertEqual("The response code status for the webservice for "+data.alpha2code,response.getStatusInt(),200);
        CountryObject data2 = getIndividualCountryResult(data.alpha2code);
        testlogger.info("The matching message is                         : "+data.info);
        testlogger.info("The name of the country is                      : "+data.name);
        testlogger.info("The alpha2code of the country is                : "+data.alpha2code);
        testlogger.info("The alpha3code of the country is                : "+data.alpha3code);
        CustomAssert.assertEqual("The content of messages",data2.info,"Country found matching code ["+data.alpha2code+"].");
        CustomAssert.assertEqual("The country name",data2.name,data.name);
        CustomAssert.assertEqual("The alpha2code",data2.alpha2code,data.alpha2code);
        CustomAssert.assertEqual("The alpha3code",data2.alpha3code,data.alpha3code);
    }



    private CountryObject getIndividualCountryResult(String iso2code) throws IOException {
        String injected = webserviceFormat.replace("COUNTRY_ISO2CODE",iso2code);
        HttpClientUtil.RequestResponse response = HttpClientUtil.get(injected,new Header[]{});
        CountryObject data = null;
        String info = "";
        if(response!=null){
            JSONObject bodyObj = new JSONObject((response.getBody()));
            JSONObject restResponse = bodyObj.getJSONObject("RestResponse");
            JSONArray messages = restResponse.getJSONArray("messages");
            assertTrue("Messages Array should have a size = 1",messages.length()==1);
            for (int i = 0; i < messages.length(); i++) {
                info = messages.get(i).toString();
            }
            JSONObject result = restResponse.getJSONObject("result");
            data = new CountryObject(info,result.get("name").toString(),result.get("alpha2_code").toString(),result.get("alpha3_code").toString());
        }
        return data;
    }

    private void getIso2CodeList() throws IOException {
        HttpClientUtil.RequestResponse response = HttpClientUtil.get(webserviceAll,new Header[]{});
        if(response!=null){
            JSONObject bodyObj = new JSONObject((response.getBody()));
            JSONObject restResponse = bodyObj.getJSONObject("RestResponse");
            JSONArray result = restResponse.getJSONArray("result");
            for (int i = 0; i < result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                iso2Codes.add(jo.get("alpha2_code").toString());
            }
        }
    }

    /**
     * You can notice in this method there are intern asserts for checking that the response is not null and the code status = 200.
     * @param iso2code
     * @throws IOException
     */

    private void getResponseCodeIndividualCountry(String iso2code) throws IOException {
        String injected = webserviceFormat.replace("COUNTRY_ISO2CODE",iso2code);
        HttpClientUtil.RequestResponse response = HttpClientUtil.get(injected,new Header[]{});
        CustomAssert.assertTrue("The response of webservice for "+iso2code.toUpperCase()+" is not null",response!=null);
        CustomAssert.assertEqual("The response code status for the webservice for "+iso2code.toUpperCase(),response.getStatusInt(),200);
    }
}
