package util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pojo.Video;

import java.io.IOException;
import java.util.LinkedHashMap;

/**
 * @description:
 * @author: Andy
 * @time: 2021/9/8 10:43
 */

public class JacksonSerialize extends StdSerializer<Video> {


    public JacksonSerialize() {
        super(Video.class);
    }

    public void serialize(Video value, JsonGenerator Jgen, SerializerProvider provider) throws IOException {
        Jgen.writeStartObject();
        Jgen.writeNumberField("id",value.getId());
        Jgen.writeStringField("Video_Name",value.getVideo_Name());
        Jgen.writeStringField("Cover", value.getCover());
        Jgen.writeStringField("Director", value.getDirector());
        Jgen.writeStringField("Screenwriter", value.getScreenwriter());
        Jgen.writeStringField("Starring", value.getStarring());
        Jgen.writeStringField("Introduce", value.getIntroduce());
        Jgen.writeStringField("Quality", value.getQuality());
        Jgen.writeStringField("label", value.getLabel());
        Jgen.writeStringField("Film_length", value.getFilm_length());

        LinkedHashMap<String,LinkedHashMap<String,String>> linkedHashMap = new LinkedHashMap<String,
                LinkedHashMap<String, String>>();
        ObjectMapper mapper = new ObjectMapper();
        linkedHashMap= mapper.readValue(value.getPlay(), linkedHashMap.getClass());
        Jgen.writeObjectField("play", linkedHashMap);

        Jgen.writeEndObject();
    }
}
