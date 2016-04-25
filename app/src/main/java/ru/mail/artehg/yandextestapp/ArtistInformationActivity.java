package ru.mail.artehg.yandextestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ArtistInformationActivity extends AppCompatActivity {


    @Bind(R.id.atristIv)
    ImageView mImageView;
    @Bind(R.id.ganreTv)
    TextView mGanreTv;
    @Bind(R.id.albumsTracksTv)
    TextView mAlbumsTracksTv;
    @Bind(R.id.biographyTv)
    TextView mBiographyTv;
    @Bind(R.id.biographyInfo)
    TextView mDescription;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.actionBarTitle)
    TextView actionBarTitle;
    ActionBar mActionBar;

    String name;
    String genre;
    String description;
    String albumsTracks;
    int tracks;
    String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_information);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(false);
        getInformation(getIntent());
        setData();
    }


    private void getInformation(Intent intent) {
        name = intent.getStringExtra(ArtistsInfo.NAME);
        genre = intent.getStringExtra(ArtistsInfo.GENRE);
        description = intent.getStringExtra(ArtistsInfo.DESCRIPTION);
        albumsTracks = intent.getStringExtra(ArtistsInfo.ALBUMS_TRACKS);
        image = intent.getStringExtra(ArtistsInfo.IMAGE);
    }

    private void setData() {
        actionBarTitle.setText(name);
        mGanreTv.setText(genre);
        mDescription.setText(description);
        mAlbumsTracksTv.setText(albumsTracks);
        Picasso.with(getApplicationContext()).load(image).into(mImageView);
    }

}
