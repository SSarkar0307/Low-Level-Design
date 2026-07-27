public class Main{
    public static void main(String[] args) {
        VideoDownloader cachVideoDownloader = new CacheProxyVideoDownloader();
        System.out.println("User 1 - Cache Miss Case");
        String video1= cachVideoDownloader.download("https://videoweb.com");
        System.out.println(video1);
        
        System.out.println("User 2 - Cache Hit Case");
        String video2= cachVideoDownloader.download("https://videoweb.com");
        System.out.println(video2);

    }
}