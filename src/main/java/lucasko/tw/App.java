package lucasko.tw;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String clientId = "xxxxxxxxxx";
		String clientSecret = "yyyyyyyyy";
		String refreshToken = "zzzzzzzzzzzz";
		
		PlusAPI plusAPI = new PlusAPI(clientId, clientSecret, refreshToken);
		
		String userid = "123456789012345678901";
						 
		System.out.println(plusAPI.getPeople(userid));

	}
}
