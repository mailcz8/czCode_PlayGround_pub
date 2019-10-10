package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commom.RESTHTTPClient;
import commom.SmallXMLReader;

//import com.library.Utils.ExecutionLog;
//import com.restapi.common.RESTHTTPClient;
//import com.restapi.common.SmallXMLReader;

public class RestTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test(groups = { "acceptance" })
	public void test_UpdateDimension_InvalidContentType_send() throws ClientProtocolException, IOException {
		System.out.println("**********************************************************");
		System.out.println("****** test_MetadataSync_Dimension_API_UnsupportedAttachment ***********");
		System.out.println("**********************************************************");

		SoftAssert softAssert = new SoftAssert();

		try {

			// build request xml
			String endPointURL = "https://liveqa81.adaptiveplanning.com/api/v17";
			String adaptiveMethod = "updateDimension";
			String username = "admin@jhcpm.com";
			String password = "changeme";

			String requestXML = buildXMLRequestFile(adaptiveMethod, username, password);
			// InputStream contentFileInputStream =
			// buildInputStreamUpdateDimensionsAttachment(adaptiveMethod,
			// username, password);

			String contentFile = "C:/Users/snalamachu/Documents/Test Data/Transactions.xlsx";

			// Init REST Client
			RESTHTTPClient client = new RESTHTTPClient(endPointURL, "UTF-8", requestXML);

			// set content file
			client.setContentFile(contentFile);

			// Send request
			if (client.executeMultiPartMixedDataXMLFile()) {

				// Get response
				String response = client.getResponseXML();

				System.out
						.println("Response XML:\n" + "----------------------\n" + response + "----------------------");

				// Assert response content type
				String respContentType = client.getResponseContentType().getValue().toString();
				softAssert.assertEquals(respContentType, "text/xml;charset=UTF-8", "Response Content Type:");

				// Assert response status code
				int respStatusCode = client.getResponseStatusCode();
				softAssert.assertEquals(respStatusCode, 200, "Response Status Code:");

				// init small xml reader
				SmallXMLReader reader = new SmallXMLReader(response);

				// Assert xml response success value
				String successValue = reader.getSuccessValue();
				softAssert.assertEquals(successValue, "false", "Success Value:");

				// Assert xml response message
				String message = reader.getMessage();
				softAssert.assertEquals(message, "Unsupported content type \"multipart/mixed\" has been provided.",
						"Response Message:");

				// Assert all
				softAssert.assertAll();
			} else {
				Assert.fail("FAIL:  executeMultiPartFormDataXMLFile failed to execute.");
			}
		} catch (Exception e) {
			System.out.println("Exception test: " + e.getMessage());
		}
	}
	
	//build a file
    public static String buildXMLRequestFile(String companyMethod, String username, String password) throws Exception{
    	String outFileName = "newZZZXMLFileTest.txt";
		File f = new File("test-output");
		File fs = new File(f, outFileName);
		String outFileLoc = fs.getAbsolutePath();
		System.out.println(outFileLoc);
		@SuppressWarnings("unused")
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFileLoc));
		
        StringBuffer contentBuffer = new StringBuffer();
        contentBuffer.append("<?xml version=\'1.0\' encoding=\'UTF-8\'?>\n");
        contentBuffer.append(String.format("<call method=\"%s\" callerName=\"%s\">\n", companyMethod, username));
        contentBuffer.append(String.format("<credentials login=\"%s\" password=\"%s\"/>\n", username, password));
        contentBuffer.append("<valueSet>\n");
        contentBuffer.append("</valueSet>\n");
        contentBuffer.append("</call>\n");
        contentBuffer.append("</newZZZXMLFileTest>");
//        System.out.println(contentBuffer.toString());
        bw.write(contentBuffer.toString());
        bw.close();
        return contentBuffer.toString();  
    }
}
