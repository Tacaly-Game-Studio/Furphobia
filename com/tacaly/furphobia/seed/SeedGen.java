package seed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;


public class SeedGen {

    String sURL = "http://block.lillelink.com/chain/"; //the LL blockchain URL string

    // Connect to the URL using java's native library
    URL url = new URL(sURL);
    URLConnection request = url.openConnection();
    request.connect();

    // Convert to a JSON object to print data
    JsonParser jp = new JsonParser(); //from gson
    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
    JsonObject rootobj = root.getAsJsonObject(); //Maybe an array, may be an object.
    String Seed = rootobj.get("previous_hash").getAsString(); //just grab the hash

}

