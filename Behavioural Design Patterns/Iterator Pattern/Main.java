// Client Code
class Main {
    public static void main(String[] args) {
        YoutubePlayList playlist = new YoutubePlayList();
        playlist.addVideo(new Video("Low Level Design"));
        playlist.addVideo(new Video("Iterator Pattern"));

        PlayListIterator iterator = playlist.createIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next().getTitle());
        }

    }
}
