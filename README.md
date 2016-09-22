Google API Gmail - Getting Person Info
----------------
### Authorization Scopes
	https://www.googleapis.com/auth/userinfo.email

### To Initial Google API
```JAVA
PlusAPI plusAPI = new PlusAPI(clientId, clientSecret, refreshToken);
```


### Function of Google Plus API
```JAVA
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
```


### To Call Function & Show Result
``` JAVA
	String userid = "123456789012345678901";
	System.out.println(plusAPI.getPeople(userid));
```

### JSON of Response
```json
{
	"circledByCount": 0,
	"displayName": "Lucas",
	"domain": "xxxxx.org",
	"emails": [{
		"type": "account",
		"value": "lucasko.tw@xxxxx.org"
	}],
	"etag": "\"xw0en60W6-NurXn4VBU-CMjSPEw/xxxxxxxxxxxxxxxxxx\"",
	"id": "111111111111111111111",
	"image": {
		"isDefault": false,
		"url": "https://lh6.googleusercontent.com/-wWDP5KLB_Uo/xxxxxxxx/xxxxxxxxxx/1pzUYf0SYb4/photo.jpg?sz=50"
	},
	"isPlusUser": false,
	"kind": "plus#person",
	"name": {
		"familyName": "Ko",
		"givenName": "Lucas"
	},
	"objectType": "person",
	"verified": false
}

```
