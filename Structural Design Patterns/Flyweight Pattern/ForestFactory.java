import java.util.HashMap;

public class ForestFactory {
    static HashMap<String, TreeType> treeTypeCache = new HashMap<>();

    public static TreeType get(String color, String texture){
        String key = color + "_" + texture;
        if(!treeTypeCache.containsKey(key)){
            treeTypeCache.put(key, new TreeType(color, texture));
        }
        return treeTypeCache.get(key);
    }

}
