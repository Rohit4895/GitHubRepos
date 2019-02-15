package com.example.githubrepodisplay;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("search/users?q=language:java")
    Call<UsersList> getJavaUsersList();

    @GET("search/users?q=language:kotlin")
    Call<UsersList> getKotlinUsersList();

    @GET("search/users?q=language:c")
    Call<UsersList> getCUsersList();

    @GET("search/users?q=language:c++")
    Call<UsersList> getCppUsersList();

    @GET("search/users?q=language:python")
    Call<UsersList> getPythonUsersList();

    @GET("search/users?q=language:swift")
    Call<UsersList> getSwiftUsersList();

    @GET("search/users?q=language:js")
    Call<UsersList> getJsUsersList();

    @GET("search/users?q=language:assembly")
    Call<UsersList> getAssemblyUsersList();
}
