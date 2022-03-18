package fiek.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

public class MovieAdapter extends BaseAdapter {
    Context c;
    public MovieModel dataSource= new MovieModel();
    public MovieAdapter(Context _c){
        c=_c;
    }
    @Override
    public int getCount() {
        return dataSource.getSearch().size();

    }

    @Override
    public Object getItem(int position) {
        return dataSource.getSearch().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieViewHelper viewholder;
        // //
        if(convertView==null){
            convertView = LayoutInflater.from(c).inflate(R.layout.movie_row_layout,parent,false);
            viewholder= new MovieViewHelper(convertView);
            convertView.setTag(viewholder);

        }
        else{
            viewholder=(MovieViewHelper) convertView.getTag();
        }

        viewholder.tvTitle.setText(dataSource.getSearch().get(position).getTitle());
        viewholder.tvYear.setText("Year :"+ dataSource.getSearch().get(position).getYear());
        viewholder.tvImdbId.setText("Imdb :"+ dataSource.getSearch().get(position).getImdbID());
        Picasso.get().load(dataSource.getSearch().get(position).getPoster()).into(viewholder.imgMovie);


        Animation animationUtils=AnimationUtils.loadAnimation(c, android.R.anim.slide_in_left);
        viewholder.tvTitle.setAnimation(animationUtils);



        return convertView;
    }

}
