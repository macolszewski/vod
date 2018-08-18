package com.macolszewski.vod;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SaveToJSON <T> {

    static void saveToDataBase(){
        SaveToJSON obj = new SaveToJSON();
        obj.run("database/users.json",Uzytkownik.listaUzytkownikow);
        obj.run("database/movies.json",Film.filmList);
    }

    public void run(String filename, T object) {
        ObjectMapper mapper = new ObjectMapper();

        T usersDataBase = object;

        try {
            // Convert object to JSON string and save into a file directly
            mapper.writeValue(new File(filename), usersDataBase);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
