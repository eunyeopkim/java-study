	package chapter03;


public class SongApp {
	public static void main(String[] args) {
		Song s = new Song();
		s.setArtist("아이유");
		s.setTitle("좋은날");
		s.setAlbum("Real");
		s.setYear(2010);
		s.setTrack(3);
		s.setComposer("이민수");
		s.show();
		
		System.out.println(Global.globalVar);
		Global.globalTest();
		
		Song song2 = new Song("BLueming", "아이유", null, null, 0, 0);
		song2.show();
		
		Song song3 = new Song("먹구름","윤하");
		song3.show();
		
	
	}
	public static void globalTest() {
		System.out.println(Global.globalVar);
	}
}
