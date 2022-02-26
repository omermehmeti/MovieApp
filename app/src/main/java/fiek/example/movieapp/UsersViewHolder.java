package fiek.example.movieapp;

import android.view.View;
import android.widget.TextView;

public class UsersViewHolder {

    TextView RowTitle,tvusernametitle;

    public TextView getTvusernametitle() {
        return tvusernametitle;
    }

    public TextView getRowTitle() {
        return RowTitle;
    }

    public UsersViewHolder(View view){

        RowTitle=view.findViewById(R.id.RowTitle);
        tvusernametitle=view.findViewById(R.id.tvUsernameSubtitle);

    }
}
