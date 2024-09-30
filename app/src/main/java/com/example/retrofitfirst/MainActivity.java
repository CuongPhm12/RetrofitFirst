package com.example.retrofitfirst;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.retrofitfirst.api.ApiService;
import com.example.retrofitfirst.model.Joke;
import com.example.retrofitfirst.model.Post;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView txtType, txtSetup, txtPostResult;
    Button btnCallAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtType = findViewById(R.id.txtType);
        txtSetup = findViewById(R.id.txtSetup);
        txtPostResult = findViewById(R.id.txtPostResult);
        btnCallAPI = findViewById(R.id.btnCallAPI);
        btnCallAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                clickCallAPI();
                sendPost();
            }
        });
    }

    private void clickCallAPI() {
        ApiService.apiService.jokeInformation().enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                Toast.makeText(MainActivity.this, "Call API Success", Toast.LENGTH_SHORT).show();
                Joke joke = response.body();
                if (joke != null) {
                    txtType.setText(joke.getType());
                    txtSetup.setText(joke.getSetup());

                }
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call API Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
Post post =new Post(10,101,"Cuong", "Purple");
    private void sendPost(){
        ApiService.apiService.sendPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Toast.makeText(MainActivity.this, "Call Api Success",Toast.LENGTH_SHORT).show();
                Post postResult = response.body();
                if(postResult != null){
                    txtPostResult.setText(postResult.toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
Toast.makeText(MainActivity.this, "Call Api Error",Toast.LENGTH_SHORT).show();
            }
        });
    }
}