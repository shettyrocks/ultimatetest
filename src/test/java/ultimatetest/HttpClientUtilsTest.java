package ultimatetest;

import java.net.http.HttpHeaders;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpClientUtils;

public class HttpClientUtilsTest {

    private final String GET_URL = "https://jsonplaceholder.typicode.com/posts/1";  // Example GET URL
    private final String POST_URL = "https://jsonplaceholder.typicode.com/posts"; // Example POST URL
    private final String POST_JSON = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

    // Test GET request
    @Test
    public void testSendGetRequest() {
        try {
            String response = HttpClientUtils.sendGetRequest(GET_URL);
            Assert.assertNotNull(response, "Response should not be null");
            Assert.assertTrue(response.contains("userId"), "Response should contain userId");
        } catch (Exception e) {
            Assert.fail("Exception occurred while sending GET request: " + e.getMessage());
        }
    }

    // Test POST request
    @Test
    public void testSendPostRequest() {
        try {
            String response = HttpClientUtils.sendPostRequest(POST_URL, POST_JSON);
            Assert.assertNotNull(response, "Response should not be null");
            Assert.assertTrue(response.contains("id"), "Response should contain an id field after POST");
        } catch (Exception e) {
            Assert.fail("Exception occurred while sending POST request: " + e.getMessage());
        }
    }

    // Test for HTTP headers
    @Test
    public void testGetHeaders() {
        try {
            HttpHeaders headers = HttpClientUtils.getHeaders(GET_URL);
            Assert.assertNotNull(headers, "Headers should not be null");
            Assert.assertTrue(headers.map().containsKey("Content-Type"), "Response headers should contain Content-Type");
        } catch (Exception e) {
            Assert.fail("Exception occurred while getting headers: " + e.getMessage());
        }
    }
}