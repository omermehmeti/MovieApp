package fiek.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieActivity extends AppCompatActivity {
    MovieAdapter movieAdapter;
    ListView lvMovies;
    OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        lvMovies = findViewById(R.id.lvMovies);

        movieAdapter = new MovieAdapter(MovieActivity.this);
         // movieAdapter.dataSource.setResponse("true");
       /* movieAdapter.dataSource.setTotalResults("2");*/
        // https://www.omdbapi.com/?s=Godfather&page=1&apikey=8bc19748

        /*movieAdapter.dataSource.getSearch().add(new Search("title1","viti 2xxx","imdb",
                "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"));
        movieAdapter.dataSource.getSearch().add(new Search("title2","viti 2022","imdb",
                "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"));
*/

        lvMovies.setAdapter(movieAdapter);
        GetGata();
    }
    public void GetGata(){
        Request request = new Request.Builder().url("https://www.omdbapi.com/?s=Godfather&page=1&apikey=8bc19748").get().build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                call.cancel();
                Toast.makeText(MovieActivity.this,"deshtoi",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(response.isSuccessful()){
                    String strResponse = response.body().string();
                    Gson gsonParser = new Gson();
                    // Serializimi
                    MovieModel movieModel =gsonParser.fromJson(strResponse,MovieModel.class);
                    movieAdapter.dataSource=movieModel;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            movieAdapter.notifyDataSetChanged();
                        }
                    });

                }
                else {
                    call.cancel();
                    Toast.makeText(MovieActivity.this,"pergjigja e api deshtoi "+response.code(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}