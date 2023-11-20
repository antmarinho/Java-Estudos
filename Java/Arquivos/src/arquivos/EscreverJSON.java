package arquivos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class EscreverJSON {
	
	public static void main(String[] args) throws IOException {
		
		Usuario user1 = new Usuario("jose123","123456","11111111111","jose");
		
		Usuario user2 = new Usuario("maria123","123456","2222222222","maria");
		
		List<Usuario> usuario = new ArrayList<>();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		usuario.add(user1);
		usuario.add(user2);
		
		String jsonUser = gson.toJson(usuario);
		
		System.out.println(jsonUser);
		
		FileWriter fw = new FileWriter("H:\\Java\\Arquivos\\src\\arquivos\\filjson.json");
		
		fw.write(jsonUser);
		fw.flush();
		fw.close();
		
		//-------------------------------------------------------------------------
		
		//lendo arquivo json
		
		
		FileReader fr = new FileReader("H:\\Java\\Arquivos\\src\\arquivos\\filjson.json");
		
		JsonArray jsonArray =  (JsonArray) JsonParser.parseReader(fr);

		List<Usuario> listUser = new ArrayList<>();
		
		for(JsonElement jsonElement : jsonArray) {
			
			Usuario user = new Gson().fromJson(jsonElement, Usuario.class);
			
			listUser.add(user);
			
		}
		
		System.out.println("leitura do arquivo json " + listUser);
		
	}

}
