package com.example.spoticeri;

import com.zeroc.Ice.Current;

public class StreamingAppI implements com.example.spoticeri.Demo.StreamingApp{
    @Override
    public void printString(String s, Current current) {

    }

    @Override
    public boolean addSong(String song, Current current) {
        return false;
    }

    @Override
    public boolean deleteSong(String song, Current current) {
        return false;
    }

    @Override
    public String[] getAllSong(Current current) {
        return new String[0];
    }

    @Override
    public String playStream(String song, Current current) {
        return null;
    }
}
