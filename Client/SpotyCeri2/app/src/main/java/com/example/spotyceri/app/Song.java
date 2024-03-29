//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `StreamApplication.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package app;

public class Song extends com.zeroc.Ice.Value
{
    public Song()
    {
        this.name = "";
        this.path = "";
        this.artist = "";
        this.album = "";
        this.genre = "";
        this.year = "";
    }

    public Song(String name, String path, String artist, String album, String genre, String year)
    {
        this.name = name;
        this.path = path;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
    }

    public String name;

    public String path;

    public String artist;

    public String album;

    public String genre;

    public String year;

    public Song clone()
    {
        return (Song)super.clone();
    }

    public static String ice_staticId()
    {
        return "::app::Song";
    }

    @Override
    public String ice_id()
    {
        return ice_staticId();
    }

    /** @hidden */
    public static final long serialVersionUID = 720078757L;

    /** @hidden */
    @Override
    protected void _iceWriteImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice(ice_staticId(), -1, true);
        ostr_.writeString(name);
        ostr_.writeString(path);
        ostr_.writeString(artist);
        ostr_.writeString(album);
        ostr_.writeString(genre);
        ostr_.writeString(year);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _iceReadImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        name = istr_.readString();
        path = istr_.readString();
        artist = istr_.readString();
        album = istr_.readString();
        genre = istr_.readString();
        year = istr_.readString();
        istr_.endSlice();
    }
}
