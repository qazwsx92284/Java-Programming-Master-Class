package com.company;

import java.util.ArrayList;
import java.util.LinkedList;


public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    private Song song;

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;
        songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        //for each, checkSong 이라는 Song의 instant object를 만들고 songs의 값들을
        //하나씩 대입하고 findSong의 parameter로 받은 title과 일치하는지 비교한다.
        for(Song checkedSong: this.songs) {
            if(checkedSong.getTitle().equalsIgnoreCase(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    //songs에 있는 노래를 playList LinkedList에 추가한다.
    //if절:songs에 트랙넘버를 parameter로 필요. 트랙넘버가 0보다 크고 songs의 사이즈보다 작아야함.
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber-1;
        if(index>=0 && index<= songs.size()) {
            playList.add(songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    //trackNumber를 입력받는 게 아니라, title를 변수로 입력받았을 경우를 생각해서
    //method overriding with different parameters,
    // String title and LinkedList<Song> playlist
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title); //checkedSong is the return val of findSong
        if(checkedSong != null) {
            //If checkSong is not null, meaning the parameter title(the song you want
            //to add) exists in the album(ArrayList songs)
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title+ " is not in this album");
        return false;
    }
    public void listSongs() {
        for(int i = 0; i< songs.size(); i++) {
            System.out.println((i+1)+ ". " + songs.get(i).getTitle()+
                    ", "+ songs.get(i).getDuration());
        }
    }



    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public Song getSong() {
        return song;
    }
}
