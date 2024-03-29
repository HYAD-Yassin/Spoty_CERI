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

public interface StreamApplicationPrx extends com.zeroc.Ice.ObjectPrx
{
    default boolean ajoutMusic(Song s)
    {
        return ajoutMusic(s, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean ajoutMusic(Song s, java.util.Map<String, String> context)
    {
        return _iceI_ajoutMusicAsync(s, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> ajoutMusicAsync(Song s)
    {
        return _iceI_ajoutMusicAsync(s, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> ajoutMusicAsync(Song s, java.util.Map<String, String> context)
    {
        return _iceI_ajoutMusicAsync(s, context, false);
    }

    /**
     * @hidden
     * @param iceP_s -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_ajoutMusicAsync(Song iceP_s, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "ajoutMusic", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeValue(iceP_s);
                     ostr.writePendingValues();
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    default boolean suppMusic(String name)
    {
        return suppMusic(name, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean suppMusic(String name, java.util.Map<String, String> context)
    {
        return _iceI_suppMusicAsync(name, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> suppMusicAsync(String name)
    {
        return _iceI_suppMusicAsync(name, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> suppMusicAsync(String name, java.util.Map<String, String> context)
    {
        return _iceI_suppMusicAsync(name, context, false);
    }

    /**
     * @hidden
     * @param iceP_name -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_suppMusicAsync(String iceP_name, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "suppMusic", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_name);
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    default Song playStream(String nom)
    {
        return playStream(nom, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Song playStream(String nom, java.util.Map<String, String> context)
    {
        return _iceI_playStreamAsync(nom, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Song> playStreamAsync(String nom)
    {
        return _iceI_playStreamAsync(nom, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Song> playStreamAsync(String nom, java.util.Map<String, String> context)
    {
        return _iceI_playStreamAsync(nom, context, false);
    }

    /**
     * @hidden
     * @param iceP_nom -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Song> _iceI_playStreamAsync(String iceP_nom, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Song> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "playStream", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_nom);
                 }, istr -> {
                     final com.zeroc.IceInternal.Holder<Song> ret = new com.zeroc.IceInternal.Holder<>();
                     istr.readValue(v -> ret.value = v, Song.class);
                     istr.readPendingValues();
                     return ret.value;
                 });
        return f;
    }

    default boolean findByName(String nom)
    {
        return findByName(nom, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default boolean findByName(String nom, java.util.Map<String, String> context)
    {
        return _iceI_findByNameAsync(nom, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> findByNameAsync(String nom)
    {
        return _iceI_findByNameAsync(nom, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Boolean> findByNameAsync(String nom, java.util.Map<String, String> context)
    {
        return _iceI_findByNameAsync(nom, context, false);
    }

    /**
     * @hidden
     * @param iceP_nom -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> _iceI_findByNameAsync(String iceP_nom, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Boolean> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findByName", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_nom);
                 }, istr -> {
                     boolean ret;
                     ret = istr.readBool();
                     return ret;
                 });
        return f;
    }

    default Song[] findByAlbum(String album)
    {
        return findByAlbum(album, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Song[] findByAlbum(String album, java.util.Map<String, String> context)
    {
        return _iceI_findByAlbumAsync(album, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Song[]> findByAlbumAsync(String album)
    {
        return _iceI_findByAlbumAsync(album, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Song[]> findByAlbumAsync(String album, java.util.Map<String, String> context)
    {
        return _iceI_findByAlbumAsync(album, context, false);
    }

    /**
     * @hidden
     * @param iceP_album -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Song[]> _iceI_findByAlbumAsync(String iceP_album, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Song[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findByAlbum", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_album);
                 }, istr -> {
                     Song[] ret;
                     ret = songListHelper.read(istr);
                     istr.readPendingValues();
                     return ret;
                 });
        return f;
    }

    default Song[] findByArtist(String artist)
    {
        return findByArtist(artist, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Song[] findByArtist(String artist, java.util.Map<String, String> context)
    {
        return _iceI_findByArtistAsync(artist, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Song[]> findByArtistAsync(String artist)
    {
        return _iceI_findByArtistAsync(artist, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Song[]> findByArtistAsync(String artist, java.util.Map<String, String> context)
    {
        return _iceI_findByArtistAsync(artist, context, false);
    }

    /**
     * @hidden
     * @param iceP_artist -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Song[]> _iceI_findByArtistAsync(String iceP_artist, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Song[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findByArtist", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_artist);
                 }, istr -> {
                     Song[] ret;
                     ret = songListHelper.read(istr);
                     istr.readPendingValues();
                     return ret;
                 });
        return f;
    }

    default Song[] findByGenre(String genre)
    {
        return findByGenre(genre, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Song[] findByGenre(String genre, java.util.Map<String, String> context)
    {
        return _iceI_findByGenreAsync(genre, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Song[]> findByGenreAsync(String genre)
    {
        return _iceI_findByGenreAsync(genre, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Song[]> findByGenreAsync(String genre, java.util.Map<String, String> context)
    {
        return _iceI_findByGenreAsync(genre, context, false);
    }

    /**
     * @hidden
     * @param iceP_genre -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Song[]> _iceI_findByGenreAsync(String iceP_genre, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Song[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findByGenre", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_genre);
                 }, istr -> {
                     Song[] ret;
                     ret = songListHelper.read(istr);
                     istr.readPendingValues();
                     return ret;
                 });
        return f;
    }

    default Song[] findByYear(String year)
    {
        return findByYear(year, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Song[] findByYear(String year, java.util.Map<String, String> context)
    {
        return _iceI_findByYearAsync(year, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Song[]> findByYearAsync(String year)
    {
        return _iceI_findByYearAsync(year, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Song[]> findByYearAsync(String year, java.util.Map<String, String> context)
    {
        return _iceI_findByYearAsync(year, context, false);
    }

    /**
     * @hidden
     * @param iceP_year -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Song[]> _iceI_findByYearAsync(String iceP_year, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Song[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "findByYear", null, sync, null);
        f.invoke(true, context, null, ostr -> {
                     ostr.writeString(iceP_year);
                 }, istr -> {
                     Song[] ret;
                     ret = songListHelper.read(istr);
                     istr.readPendingValues();
                     return ret;
                 });
        return f;
    }

    default Song[] getAll()
    {
        return getAll(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Song[] getAll(java.util.Map<String, String> context)
    {
        return _iceI_getAllAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Song[]> getAllAsync()
    {
        return _iceI_getAllAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Song[]> getAllAsync(java.util.Map<String, String> context)
    {
        return _iceI_getAllAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Song[]> _iceI_getAllAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Song[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getAll", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Song[] ret;
                     ret = songListHelper.read(istr);
                     istr.readPendingValues();
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static StreamApplicationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), StreamApplicationPrx.class, _StreamApplicationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static StreamApplicationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), StreamApplicationPrx.class, _StreamApplicationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static StreamApplicationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), StreamApplicationPrx.class, _StreamApplicationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static StreamApplicationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), StreamApplicationPrx.class, _StreamApplicationPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static StreamApplicationPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, StreamApplicationPrx.class, _StreamApplicationPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static StreamApplicationPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, StreamApplicationPrx.class, _StreamApplicationPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default StreamApplicationPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (StreamApplicationPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default StreamApplicationPrx ice_adapterId(String newAdapterId)
    {
        return (StreamApplicationPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default StreamApplicationPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (StreamApplicationPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default StreamApplicationPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (StreamApplicationPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default StreamApplicationPrx ice_invocationTimeout(int newTimeout)
    {
        return (StreamApplicationPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default StreamApplicationPrx ice_connectionCached(boolean newCache)
    {
        return (StreamApplicationPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default StreamApplicationPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (StreamApplicationPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default StreamApplicationPrx ice_secure(boolean b)
    {
        return (StreamApplicationPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default StreamApplicationPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (StreamApplicationPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default StreamApplicationPrx ice_preferSecure(boolean b)
    {
        return (StreamApplicationPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default StreamApplicationPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (StreamApplicationPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default StreamApplicationPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (StreamApplicationPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default StreamApplicationPrx ice_collocationOptimized(boolean b)
    {
        return (StreamApplicationPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default StreamApplicationPrx ice_twoway()
    {
        return (StreamApplicationPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default StreamApplicationPrx ice_oneway()
    {
        return (StreamApplicationPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default StreamApplicationPrx ice_batchOneway()
    {
        return (StreamApplicationPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default StreamApplicationPrx ice_datagram()
    {
        return (StreamApplicationPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default StreamApplicationPrx ice_batchDatagram()
    {
        return (StreamApplicationPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default StreamApplicationPrx ice_compress(boolean co)
    {
        return (StreamApplicationPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default StreamApplicationPrx ice_timeout(int t)
    {
        return (StreamApplicationPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default StreamApplicationPrx ice_connectionId(String connectionId)
    {
        return (StreamApplicationPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default StreamApplicationPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (StreamApplicationPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::app::StreamApplication";
    }
}
