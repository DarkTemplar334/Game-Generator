package gr.ict.ihu.GSON;

import com.google.gson.*;

import java.lang.reflect.Type;

public class Adapter implements JsonSerializer, JsonDeserializer {

    private static final String CLASSNAME = "CLASSNAME";
    private static final String DATA = "DATA";

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(CLASSNAME);
        String className = prim.getAsString();
        Class cClass = getObJectClass(className);
        return jsonDeserializationContext.deserialize(jsonObject.get(DATA),cClass);
    }

    private Class getObJectClass(String className) {
        try{
            return Class.forName(className);
        }catch (ClassNotFoundException e){
            throw  new JsonParseException(e.getMessage());
        }
    }

    @Override
    public JsonElement serialize(Object o, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(CLASSNAME,o.getClass().getName());
        jsonObject.add(DATA,jsonSerializationContext.serialize(o));
        return jsonObject;
    }
}
