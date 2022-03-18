package fiek.example.movieapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieViewHelper {
    ImageView imgMovie;
    TextView tvTitle,tvYear,tvImdbId;

    public ImageView getImgMovie() {
        return imgMovie;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvYear() {
        return tvYear;
    }

    public TextView getTvImdbId() {
        return tvImdbId;
    }

    public MovieViewHelper(View view){
        imgMovie=view.findViewById(R.id.imgMovie);
        tvTitle=view.findViewById(R.id.titleMovie);
        tvYear=view.findViewById(R.id.tYear);
        tvImdbId=view.findViewById(R.id.tImbdid);;
    }
}
