package datenspeicherung;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Benutzerliste {
    public boolean istGueltig(String pBenutzername, String pPasswort) {
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("TratschServer/benutzerliste.json")), StandardCharsets.UTF_8);
            //assign your JSON String here
            JSONObject obj = new JSONObject(jsonString);

            JSONArray arr = obj.getJSONArray("benutzer"); // notice that `"posts": [...]`
            for (int i = 0; i < arr.length(); i++) {
                String name = arr.getJSONObject(i).getString("benutzername");
                String passwort = arr.getJSONObject(i).getString("passwort");

                if (name.equals(pBenutzername) && passwort.equals(pPasswort)) {
                    return true;
                }
            }

            return false;

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }
}
