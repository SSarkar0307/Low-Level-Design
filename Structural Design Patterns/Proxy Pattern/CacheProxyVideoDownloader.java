import java.util.HashMap;

public class CacheProxyVideoDownloader implements VideoDownloader{
    HashMap<String, String> cache = new HashMap<>();

    @Override
    public String download(String URL){
        if(cache.containsKey(URL)){
            System.out.println("Video found in Cache");
            return cache.get(URL);
        }
        else{
            System.out.println("Cache Miss");
            VideoDownloader downloader = new MainVideoDownloader();
            String video = downloader.download(URL);
            cache.put(URL, video);
            return video;  
        }
    }
}
