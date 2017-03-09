package utils.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Comment;

import java.io.File;
import java.io.IOException;


public class JsonConverter {

    private final static String baseFile = "user.json";

    public static void toJSON(Comment user) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), user);
        System.out.println("json created!");
        
        
    }

    public static Comment toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Comment.class);
    }
}