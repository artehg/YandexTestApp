package ru.mail.artehg.yandextestapp;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by artehg on 24.04.2016.
 */
public class ArtistsInfo implements Parcelable{
    public static final int FST_VALUE = 0;
    public static final int SND_VALUE = 1;
    public static final int THR_VALUE = 2;
    public static final int TRACKS = 0;
    public static final int ALBUMS = 1;
    public static final int LIST_ACTIVITY = 0;
    public static final int ARTIST_INFORMATION_ACTIVITY = 1;

    public static final String GENRE = "ganre";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "biography";
    public static final String ALBUMS_TRACKS = "albumsAndTracks";
    public static final String TRACKSCOUNT = "tracksCount";
    public static final String IMAGE = "image";


    /**
     * id : 1080505
     * name : Tove Lo
     * genres : ["pop","dance","electronics"]
     * tracks : 81
     * albums : 22
     * link : http://www.tove-lo.com/
     * description : С€РІРµРґСЃРєР°СЏ РїРµРІРёС†Р° Рё Р°РІС‚РѕСЂ РїРµСЃРµРЅ. РћРЅР° РїСЂРёРІР»РµРєР»Р° Рє СЃРµР±Рµ РІРЅРёРјР°РЅРёРµ РІ 2013 РіРѕРґСѓ СЃ РІС‹РїСѓСЃРєРѕРј СЃРёРЅРіР»Р° В«HabitsВ», РЅРѕ РЅР°СЃС‚РѕСЏС‰РµРіРѕ СѓСЃРїРµС…Р° РґРѕР±РёР»Р°СЃСЊ СЃ СЂРµРјРёРєСЃРѕРј С…РёРї-С…РѕРї РїСЂРѕРґСЋСЃРµСЂР° Hippie Sabotage РЅР° СЌС‚Сѓ РїРµСЃРЅСЋ, РєРѕС‚РѕСЂС‹Р№ РїРѕР»СѓС‡РёР» РЅР°Р·РІР°РЅРёРµ В«Stay HighВ». 4 РјР°СЂС‚Р° 2014 РіРѕРґР° РІС‹С€РµР» РµС‘ РґРµР±СЋС‚РЅС‹Р№ РјРёРЅРё-Р°Р»СЊР±РѕРј Truth Serum, Р° 24 СЃРµРЅС‚СЏР±СЂСЏ СЌС‚РѕРіРѕ Р¶Рµ РіРѕРґР° РґРµР±СЋС‚РЅС‹Р№ СЃС‚СѓРґРёР№РЅС‹Р№ Р°Р»СЊР±РѕРј Queen of the Clouds. РўСѓРІРµ Р›Сѓ СЏРІР»СЏРµС‚СЃСЏ Р°РІС‚РѕСЂРѕРј РїРµСЃРµРЅ С‚Р°РєРёС… Р°СЂС‚РёСЃС‚РѕРІ, РєР°Рє Icona Pop, Girls Aloud Рё РЁРµСЂ Р›Р»РѕР№Рґ.
     * cover : {"small":"http://avatars.yandex.net/get-music-content/dfc531f5.p.1080505/300x300","big":"http://avatars.yandex.net/get-music-content/dfc531f5.p.1080505/1000x1000"}
     */

    private int id;
    private String name;
    private int tracks;
    private int albums;
    private String link;
    private String description;
    /**
     * small : http://avatars.yandex.net/get-music-content/dfc531f5.p.1080505/300x300
     * big : http://avatars.yandex.net/get-music-content/dfc531f5.p.1080505/1000x1000
     */

    private CoverBean cover;
    private List<String> genres;

    protected ArtistsInfo(Parcel in) {
        id = in.readInt();
        name = in.readString();
        tracks = in.readInt();
        albums = in.readInt();
        link = in.readString();
        description = in.readString();
        genres = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(tracks);
        dest.writeInt(albums);
        dest.writeString(link);
        dest.writeString(description);
        dest.writeStringList(genres);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ArtistsInfo> CREATOR = new Creator<ArtistsInfo>() {
        @Override
        public ArtistsInfo createFromParcel(Parcel in) {
            return new ArtistsInfo(in);
        }

        @Override
        public ArtistsInfo[] newArray(int size) {
            return new ArtistsInfo[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public int getAlbums() {
        return albums;
    }

    public void setAlbums(int albums) {
        this.albums = albums;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CoverBean getCover() {
        return cover;
    }

    public void setCover(CoverBean cover) {
        this.cover = cover;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public static class CoverBean {
        private String small;
        private String big;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getBig() {
            return big;
        }

        public void setBig(String big) {
            this.big = big;
        }
    }

    public String getGenresString(){
        String genresString = "";
        if(genres != null && genres.size() > 0){
            if (genres.size() == 1){
                return genres.get(0);
            }else{
                //if cnt > 1
                for (int i = 0; i < genres.size(); i++) {
                    if (i == 0) {
                        genresString = genres.get(i);
                    }else {
                        genresString += ", " + genres.get(i);
                    }
                }
                return genresString;
            }
        }
        return "";
    }


    //get final string data
    public String getAlbumsAndTracks(Context context, int targetActivity){
        String separator;
        if (targetActivity == LIST_ACTIVITY){
            separator = context.getString(R.string.list_activity_albums_track_separator);
        }else{
            separator = context.getString(R.string.artist_information_activity_albums_track_separator);
        }
        if (albums != 0 && tracks != 0){
            return getTracksAlbumsString(context, ALBUMS, targetActivity) + separator + getTracksAlbumsString(context, TRACKS, targetActivity);
        }else if(albums != 0){
                return getTracksAlbumsString(context, ALBUMS, targetActivity);
        }else if(tracks != 0){
            return getTracksAlbumsString(context, TRACKS, targetActivity);
        }
        return "";
    }


    public String getTracksAlbumsString(Context context, int dataType, int targetActivity){


        String[] values = context.getResources().getStringArray((dataType == ALBUMS)? R.array.albums : R.array.tracks);
        int counter = (dataType == ALBUMS)? albums : tracks;
        switch (getFlag(counter)){
            case FST_VALUE:
                return counter + " " + values[0];
            case SND_VALUE:
                return counter + " " + values[1];
            case THR_VALUE:
                return counter + " " + values[2];
            default:
                return "";
        }
    }


    //determining the word's form and set flag
    public int getFlag(int value){
        int flag = 0;
        if (value != 0) {
            String valueString = String.valueOf(value);
            int count = valueString.length();
            if (count >= 2 && Character.getNumericValue(valueString.charAt(count-2)) == 1) {
                //use default
            } else {
                //get last char and switch
                int lastChar = Character.getNumericValue(valueString.charAt(count - 1));
                if (lastChar == 1) {
                    flag = 1;
                } else if (lastChar > 1 && lastChar < 5) {
                    flag = 2;
                }
            }
            return flag;
        }
        return -1;
    }
}
