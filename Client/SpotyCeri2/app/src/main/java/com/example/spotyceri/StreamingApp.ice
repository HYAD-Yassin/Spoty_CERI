module Demo
{
    sequence<byte> Song;
    sequence<string> ListMusic;
    interface StreamingApp
    {
        void printString(string test);
        arrayString getAllSong();
        string playStream(string song);
        bool addSong(string song);
 	 bool deleteSong(string song);
       
    }
}
