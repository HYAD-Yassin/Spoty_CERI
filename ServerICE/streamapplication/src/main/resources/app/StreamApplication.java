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

public interface StreamApplication extends com.zeroc.Ice.Object
{
    boolean ajoutMusic(Song s, com.zeroc.Ice.Current current);

    boolean suppMusic(String name, com.zeroc.Ice.Current current);

    Song playStream(String nom, com.zeroc.Ice.Current current);

    boolean findByName(String nom, com.zeroc.Ice.Current current);

    Song[] findByAlbum(String album, com.zeroc.Ice.Current current);

    Song[] findByArtist(String artist, com.zeroc.Ice.Current current);

    Song[] findByGenre(String genre, com.zeroc.Ice.Current current);

    Song[] findByYear(String year, com.zeroc.Ice.Current current);

    Song[] getAll(com.zeroc.Ice.Current current);

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Ice::Object",
        "::app::StreamApplication"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::app::StreamApplication";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_ajoutMusic(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        final com.zeroc.IceInternal.Holder<Song> icePP_s = new com.zeroc.IceInternal.Holder<>();
        istr.readValue(v -> icePP_s.value = v, Song.class);
        istr.readPendingValues();
        inS.endReadParams();
        Song iceP_s = icePP_s.value;
        boolean ret = obj.ajoutMusic(iceP_s, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_suppMusic(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        String iceP_name;
        iceP_name = istr.readString();
        inS.endReadParams();
        boolean ret = obj.suppMusic(iceP_name, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_playStream(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        String iceP_nom;
        iceP_nom = istr.readString();
        inS.endReadParams();
        Song ret = obj.playStream(iceP_nom, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeValue(ret);
        ostr.writePendingValues();
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_findByName(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        String iceP_nom;
        iceP_nom = istr.readString();
        inS.endReadParams();
        boolean ret = obj.findByName(iceP_nom, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        ostr.writeBool(ret);
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_findByAlbum(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        String iceP_album;
        iceP_album = istr.readString();
        inS.endReadParams();
        Song[] ret = obj.findByAlbum(iceP_album, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        songListHelper.write(ostr, ret);
        ostr.writePendingValues();
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_findByArtist(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        String iceP_artist;
        iceP_artist = istr.readString();
        inS.endReadParams();
        Song[] ret = obj.findByArtist(iceP_artist, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        songListHelper.write(ostr, ret);
        ostr.writePendingValues();
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_findByGenre(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        String iceP_genre;
        iceP_genre = istr.readString();
        inS.endReadParams();
        Song[] ret = obj.findByGenre(iceP_genre, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        songListHelper.write(ostr, ret);
        ostr.writePendingValues();
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_findByYear(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        String iceP_year;
        iceP_year = istr.readString();
        inS.endReadParams();
        Song[] ret = obj.findByYear(iceP_year, current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        songListHelper.write(ostr, ret);
        ostr.writePendingValues();
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_getAll(StreamApplication obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        Song[] ret = obj.getAll(current);
        com.zeroc.Ice.OutputStream ostr = inS.startWriteParams();
        songListHelper.write(ostr, ret);
        ostr.writePendingValues();
        inS.endWriteParams(ostr);
        return inS.setResult(ostr);
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "ajoutMusic",
        "findByAlbum",
        "findByArtist",
        "findByGenre",
        "findByName",
        "findByYear",
        "getAll",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "playStream",
        "suppMusic"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return _iceD_ajoutMusic(this, in, current);
            }
            case 1:
            {
                return _iceD_findByAlbum(this, in, current);
            }
            case 2:
            {
                return _iceD_findByArtist(this, in, current);
            }
            case 3:
            {
                return _iceD_findByGenre(this, in, current);
            }
            case 4:
            {
                return _iceD_findByName(this, in, current);
            }
            case 5:
            {
                return _iceD_findByYear(this, in, current);
            }
            case 6:
            {
                return _iceD_getAll(this, in, current);
            }
            case 7:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 8:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 9:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 10:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 11:
            {
                return _iceD_playStream(this, in, current);
            }
            case 12:
            {
                return _iceD_suppMusic(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
