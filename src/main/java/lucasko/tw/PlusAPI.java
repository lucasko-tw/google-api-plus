package lucasko.tw;

import java.io.IOException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.model.Person;

public class PlusAPI {
	private Plus PLUS;

	private static HttpTransport HTTP_TRANSPORT;
	private Credential CREDENTIAL;
	private final JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private String APPLICATION_NAME = "GOOGLE-API-GMAIL";
	 

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	public PlusAPI(String clientId, String clientSecret, String refreshToken) {

		CREDENTIAL = new GoogleCredential.Builder().setTransport(HTTP_TRANSPORT).setJsonFactory(JSON_FACTORY)
				.setClientSecrets(clientId, clientSecret).build();
		CREDENTIAL.setRefreshToken(refreshToken);
	 
		PLUS = new Plus.Builder(HTTP_TRANSPORT, JSON_FACTORY, CREDENTIAL).setApplicationName(APPLICATION_NAME)
				.build();
	}
	
	
	public PlusAPI(Plus plus) {
		this.PLUS = plus;
	}

	public Person getPeople(String userid) {
		Person persion = new Person();
		try {
			persion = PLUS.people().get(userid).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persion;
	}

}
