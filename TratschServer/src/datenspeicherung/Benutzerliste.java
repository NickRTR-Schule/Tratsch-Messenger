package datenspeicherung;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.*;

public class Benutzerliste {
	public boolean istGueltig(String pBenutzername, String pPasswort) {
		String jsonString = null;
		try {
			jsonString = new String(Files.readAllBytes(Paths.get("file")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}; //assign your JSON String here
		JSONObject obj = new JSONObject(jsonString);

		JSONArray arr = obj.getJSONArray("benutzer"); // notice that `"posts": [...]`
		for (int i = 0; i < arr.length(); i++)
		{
		    String name = arr.getJSONObject(i).getString("benutzername");
		    String passwort = arr.getJSONObject(i).getString("passwort");
		    
		    if (name == pBenutzername && passwort == pPasswort) return true;
		    return false;
		}
		
		return false;
		
	}
}
