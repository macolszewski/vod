package com.macolszewski.vod;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadFromJSON {

    static void loadFromDataBase(){
        LoadFromJSON obj = new LoadFromJSON();
        obj.run();
    }

    private void run() {
        ObjectMapper mapper = new ObjectMapper();

        try {

            // Convert JSON string from file to Object
            Uzytkownik.listaUzytkownikow = mapper.readValue(new File("database/users.json"), new TypeReference<List<Uzytkownik>>(){});
            Film.filmList = mapper.readValue(new File("database/movies.json"), new TypeReference<List<Film>>(){});

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
