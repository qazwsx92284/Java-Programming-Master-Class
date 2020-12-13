package com.company;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("album example 1", "firstAritist");
        album.addSong("first album-1", 4.2);
        album.addSong("first album-2", 3.2);
        album.addSong("first album-3", 3.6);
        album.addSong("first album-4", 3.2);
        album.addSong("first album-5", 4.25);
        album.addSong("first album-6", 3.22);
        album.addSong("first album-7", 3.21);
        album.addSong("first album-8", 2.58);
        albums.add(album);

        album = new Album("album example 2", "firstAritist");
        //album is different from the above cause we use new keyword again..?
        //creating new object is completely different from the above one
        album.addSong("second album-1", 4.2);
        album.addSong("second album-2", 3.2);
        album.addSong("second album-3", 3.6);
        album.addSong("second album-4", 3.2);
        album.addSong("second album-5", 4.25);
        album.addSong("second album-6", 3.22);
        album.addSong("second album-7", 3.21);
        album.addSong("second album-8", 2.58);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("first album-1",playList);
        albums.get(0).addToPlayList("first album-2",playList);
        albums.get(0).addToPlayList(4,playList);
        albums.get(0).addToPlayList("nonono", playList);
        albums.get(1).addToPlayList("second album-4",playList);
        albums.get(1).addToPlayList(1,playList);
        albums.get(1).addToPlayList(8,playList);

        play(playList);
    }
    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size()==0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("PlayList complete.");
                    quit = true;
                    break;
                case 1: //순방으로 곡 전환
                    if(!forward) {
                        //if forward is false, but 순방으로 가고싶고 다음 곡이 있다면
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    //다음곡이 있다면 다음곡으로 넘기고 제목 출력
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        //다음곡 없으면 forward 를 false로 바꿈
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2: //역방으로 곡전환
                    if(forward) { //forward가 true 면 전의 곡으로 바꾸고 false로 바꿔줌
                        if(listIterator.hasPrevious()){
                             listIterator.previous();
                        }
                        forward = false;
                    }
                    //forward = false이고 이전의 곡이 있는 경우
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing "+listIterator.previous().toString());
                    } else {
                        //forward = false이고 전의 곡이없음(=지금플레이리스트의 가장맨앞에위치하고있음)
                        System.out.println("We are a the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying  " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }

                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() >0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;

            }
        }
    }
    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n"+ "1 - to play next song\n"
        + "2 - to play previous song\n" + "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" + "5 - print available actions"
        + " 6 - delete current song from playlist");
    }
    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        //because we're not going backward and forward, we don't need to use listIterator
        System.out.println("=====================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
            //toString is optional since it is default method.
        }
        System.out.println("=====================================");
    }
}
