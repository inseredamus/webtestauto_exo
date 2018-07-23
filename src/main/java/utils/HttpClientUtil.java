package utils;


import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by dmasure on 13.06.16.
 */
public class HttpClientUtil {

    private HttpClientUtil() {
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

    public static class RequestResponse {
        private int status;
        private String body;
        private Header[] headers;

        public RequestResponse(int status, String body, Header[] headers) {
            this.status = status;
            this.body = body;
            this.headers = headers;
        }

        public int getStatusInt() {
            return status;
        }

        public String getBody() {
            return body;
        }

        @Override
        public String toString() {
            return "RequestResponse{" + "status=" + status + ", body=" + body + '}';
        }

    }
}
