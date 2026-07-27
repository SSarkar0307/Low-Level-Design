public class MainVideoDownloader implements VideoDownloader{
    @Override
    public String download(String URL){
        System.out.println("Downloading Video from URL: " + URL);
        return "The Odyssey - 2026";
    }
}
