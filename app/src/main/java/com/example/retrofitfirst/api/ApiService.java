package com.example.retrofitfirst.api;

import com.example.retrofitfirst.model.Joke;
import com.example.retrofitfirst.model.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    //Api url:https://official-joke-api.appspot.com/random_joke
    //https://jsonplaceholder.typicode.com/posts
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
@GET("random_joke")
    Call<Joke> jokeInformation();


@POST("posts")
Call<Post> sendPost(@Body Post post);


//Link API: https://official-joke-api.appspot.com/random_joke/users/list
//@GET("random_joke/users/list")
//Call<Joke> getListUser();
////Link API: https://official-joke-api.appspot.com/random_joke/users/list?sort=desc
//@GET("random_joke/users/list")
//Call<Joke> getListUser(@Query("sort") String sort);
////Link API: https://official-joke-api.appspot.com/random_joke/group/1/users
//@GET("random_joke/group/{id}/users")
//    Call<Joke>getListUserFromGroup(@Path("id") int groupId);
////Link API: https://official-joke-api.appspot.com/random_joke/group/1/users?sort=desc
//    @GET("random_joke/group/{id}/users")
//Call<Joke> getListUserFromGroup2(@Path("id") int groupId, @Query("sort") String sort);
}
