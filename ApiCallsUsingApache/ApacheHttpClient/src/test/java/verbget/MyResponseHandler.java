package verbget;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class MyResponseHandler implements ResponseHandler<String> {

	public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode >=200 && statusCode <300) {
			
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity);
		}
		
		return ""+statusCode;
		
	}

}
