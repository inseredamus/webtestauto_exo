package utils;


import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by dmasure on 13.06.16.
 */
public class HttpClientUtil {

    private HttpClientUtil() {
    }

    public static RequestResponse get(String url, String[]... params) throws IOException {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("Url is null or empty");
        } else {
            HttpGet httpget;
            if (params != null && params.length > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append('?');
                for (String[] param : params) {
                    if (param.length > 1) {
                        sb.append(URLEncoder.encode(param[0], "utf-8")).append('=')
                                .append(URLEncoder.encode(param[1], "utf-8")).append('&');
                    }
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
                httpget = new HttpGet(url + sb.toString());
            } else {
                httpget = new HttpGet(url);
            }
            return executeRequest(httpget);
        }
    }

    public static RequestResponse get(String url, Header[] headers, String[]... params) throws IOException {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("Url is null or empty");
        } else {
            HttpGet httpget;
            if (params != null && params.length > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append('?');
                for (String[] param : params) {
                    if (param.length > 1) {
                        sb.append(URLEncoder.encode(param[0], "utf-8")).append('=')
                                .append(URLEncoder.encode(param[1], "utf-8")).append('&');
                    }
                }
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
                httpget = new HttpGet(url + sb.toString());
            } else {
                httpget = new HttpGet(url);
            }
            httpget.setHeaders(headers);
            return executeRequest(httpget);
        }
    }

    public static RequestResponse post(String url, String contentType, String body) throws IOException {

        System.out.println(body);
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("Url is null or empty");
        } else if (contentType == null || contentType.isEmpty()) {
            throw new IllegalArgumentException("Content type is null or empty");
        } else {
            HttpPost httppost = new HttpPost(url);
            StringEntity input = new StringEntity(body, "utf-8");
            input.setContentType(contentType);
            httppost.setEntity(input);
            return executeRequest(httppost);
        }
    }

    public static RequestResponse post(String url, String contentType, String body, Header[] headers) throws IOException {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("Url is null or empty");
        } else if (contentType == null || contentType.isEmpty()) {
            throw new IllegalArgumentException("Content type is null or empty");
        } else {
            HttpPost httppost = new HttpPost(url);
            httppost.setHeaders(headers);
            StringEntity input = new StringEntity(body, "utf-8");
            input.setContentType(contentType);
            httppost.setEntity(input);
            return executeRequest(httppost);
        }
    }

    public static RequestResponse executeRequest(HttpUriRequest request) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            ResponseHandler<RequestResponse> responseHandler = new ResponseHandler<RequestResponse>() {

                @Override
                public RequestResponse handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {
                    return new RequestResponse(response.getStatusLine().getStatusCode(),
                            EntityUtils.toString(response.getEntity()),
                            response.getAllHeaders());
                }

            };
            return httpclient.execute(request, responseHandler);
        }
    }

    public static Header getAuthenticationHeader(String login, String password) {
        //String auth = Base64.getEncoder().encodeToString((login+":"+password).getBytes()); in java8
        String auth = DatatypeConverter.printBase64Binary((login + ":" + password).getBytes());
        return new HeaderImpl("Authorization", "Basic " + auth);
    }

    /*
    public static Header getAppDomainHeader(enums.Country country){
        return new HeaderImpl("x-appdomain", Integer.toString(country.getAppDomain()));
    }

    public static Header getDevicePlatformHeader(DeviceType type){
        return new HeaderImpl("x-device-platform", Integer.toString(type.getId()));
    }*/

    public static String toUrlParams(String[]... params) throws UnsupportedEncodingException {
        if (params != null && params.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String[] param : params) {
                if (param.length > 1) {
                    sb.append(URLEncoder.encode(param[0], "utf-8")).append('=')
                            .append(URLEncoder.encode(param[1], "utf-8")).append('&');
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        }
        return "";
    }

    public static String toFormParams(String[]... params) throws UnsupportedEncodingException {
        if (params != null && params.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String[] param : params) {
                if (param.length > 1) {
                    sb.append(URLEncoder.encode(param[0], "utf-8")).append('=')
                            .append(URLEncoder.encode(param[1], "utf-8")).append('&');
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        }
        return "";
    }

    public static String toJson(String[]... params) throws UnsupportedEncodingException {
        if (params != null && params.length > 0) {
            StringBuilder sb = new StringBuilder("{ ");
            for (String[] param : params) {
                if (param.length > 1) {
                    sb.append('"').append(StringEscapeUtils.escapeJson(param[0])).append("\": \"")
                            .append(StringEscapeUtils.escapeJson(param[1])).append("\", ");
                }
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 2);
            }
            sb.append(" }");
            return sb.toString();
        }
        return "";
    }


    public static class HeaderImpl implements Header {

        private final String name;
        private final String value;

        public HeaderImpl(String name, String value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public HeaderElement[] getElements() throws ParseException {
            return null;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "HeaderImpl{" + "name=" + name + ", value=" + value + '}';
        }

    }

    public static class RequestResponse {
        private int status;
        private String body;
        private Header[] headers;

        public RequestResponse() {
        }

        public RequestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        public RequestResponse(int status, String body, Header[] headers) {
            this.status = status;
            this.body = body;
            this.headers = headers;
        }

        public int getStatusInt() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public Header[] getHeaders() {
            return headers;
        }

        public void setHeaders(Header[] headers) {
            this.headers = headers;
        }

        @Override
        public String toString() {
            return "RequestResponse{" + "status=" + status + ", body=" + body + '}';
        }

    }
}
