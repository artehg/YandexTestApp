package ru.mail.artehg.yandextestapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.mail.artehg.yandextestapp.Adapters.ArtistsListAdapter;

public class ListActivity extends AppCompatActivity {
    @Bind(R.id.listActivityRv)
    RecyclerView mListRv;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.progressBar)
    ProgressBar mProgressBar;
    ActionBar mActionBar;
    ArtistsListAdapter mAdapter;
    ArrayList<ArtistsInfo> mArtistsInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        //setup Ab
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowTitleEnabled(false);

        mAdapter = new ArtistsListAdapter(getApplicationContext(), this);
        mListRv.setAdapter(mAdapter);
        mListRv.setLayoutManager(new LinearLayoutManager(this));
        new ParseTask().execute();
    }

    public class ParseTask extends AsyncTask<Void, Void, String>{
        HttpURLConnection mURLConnection = null;
        BufferedReader reader = null;
        String jsonString = "";

        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
                URL url = new URL("http://cache-default05f.cdn.yandex.net/download.cdn.yandex.net/mobilization-2016/artists.json");
                mURLConnection = (HttpURLConnection) url.openConnection();
                mURLConnection.setRequestMethod("GET");
                mURLConnection.connect();

                InputStream inputStream = mURLConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }
                jsonString = buffer.toString();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return jsonString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mProgressBar.setVisibility(View.GONE);
            Type listType = new TypeToken<ArrayList<ArtistsInfo>>(){}.getType();
            ArrayList<ArtistsInfo> infoArrayList = new Gson().fromJson(s, listType);
            mArtistsInfoList = infoArrayList;
            mAdapter.setInfo(mArtistsInfoList);
        }
    }


    public void openDetailInformation(ArtistsInfo info, TextView title, TextView genre, TextView information){
        Intent intent = new Intent(this, ArtistInformationActivity.class);
        intent.putExtra(ArtistsInfo.NAME, info.getName());
        intent.putExtra(ArtistsInfo.GENRE, info.getGenresString());
        intent.putExtra(ArtistsInfo.ALBUMS_TRACKS, info.getAlbumsAndTracks(this, ArtistsInfo.ARTIST_INFORMATION_ACTIVITY));
        intent.putExtra(ArtistsInfo.DESCRIPTION, info.getDescription());
        intent.putExtra(ArtistsInfo.IMAGE, info.getCover().getBig());


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(title, "title"), Pair.create(genre, "genre"), Pair.create(information, "information"));
            startActivity(intent, optionsCompat.toBundle());
        }else{
            startActivity(intent);
        }

    }


}
