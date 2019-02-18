package com.example.githubrepodisplay;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity implements VerticalAdapter.IMethodCaller, HorizontalAdapter.CallDifferentUserLists {
    RecyclerView horiRecyclerView, verRecyclerView;
    LinearLayoutManager linearLayoutManager;
    HorizontalAdapter horizontalAdapter;
    VerticalAdapter verticalAdapter;
    Button addToCart;
    TextView textView;
    int count=0;
    long result;
    ImageView cart;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ApiInterface apiInterface;
    UsersList user;
    List<Items> usersLists, databaseList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.onActivityCreateSetTheme(this);

        setContentView(R.layout.activity_main);

        apiInterface = Api.getClient();

        textView = findViewById(R.id.notification);

        List<String> list1 = new ArrayList<String>();
        list1.add("JAVA");
        list1.add("PYTHON");
        list1.add("C++");
        list1.add("KOTLIN");
        list1.add("ASSEMBLY");
        list1.add("SWIFT");
        list1.add("JAVASCRIPT");
        list1.add("C");



        horiRecyclerView = findViewById(R.id.horiRecyclerView);
        verRecyclerView = findViewById(R.id.verRecyclerView);

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        horiRecyclerView.setLayoutManager(linearLayoutManager);
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(this,list1);
        horiRecyclerView.setAdapter(horizontalAdapter);

        /*verRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        VerticalAdapter verticalAdapter = new VerticalAdapter(this,list);
        verRecyclerView.setAdapter(verticalAdapter);*/

        cart = findViewById(R.id.cartIcon);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = (MainActivity.this).getPreferences(Context.MODE_PRIVATE);
                int status = sharedPreferences.getInt("status",0);
                Log.d("statusRohit",status+"");
                if (status == 1){
                    Utils.changeTheme(MainActivity.this, Utils.THEME_DEFAULT);
                }else if (status == 2){
                    Utils.changeTheme(MainActivity.this, Utils.THEME_BLACK);
                }




            }
        });

    }

    public void insertData(){
        AppExecutor.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                UserDBClient.getInstance(getApplicationContext())
                        .getUserDBDatabase().userDBDao().deleteAll();

                for (int i=0; i<usersLists.size(); i++){
                    UserDB userDB = new UserDB();
                    userDB.setLogin(usersLists.get(i).getLogin());
                    userDB.setScore(usersLists.get(i).getScore());
                    userDB.setType(usersLists.get(i).getType());
                    userDB.setAvatarUrl(usersLists.get(i).getAvatarUrl());
                    userDB.setFollowersUrl(usersLists.get(i).getFollowersUrl());
                    userDB.setFollowingUrl(usersLists.get(i).getFollowingUrl());
                    userDB.setHtmlUrl(usersLists.get(i).getHtmlUrl());
                    userDB.setNodeId(usersLists.get(i).getNodeId());
                    userDB.setId(usersLists.get(i).getId());
                    userDB.setReposUrl(usersLists.get(i).getReposUrl());
                    userDB.setStarredUrl(usersLists.get(i).getStarredUrl());
                    userDB.setUrl(usersLists.get(i).getUrl());

                   result = UserDBClient.getInstance(getApplicationContext()).getUserDBDatabase()
                            .userDBDao()
                            .insert(userDB);
                   Log.d("rohi",String.valueOf(result));

                   AppExecutor.getInstance().getMainThread().execute(new Runnable() {
                       @Override
                       public void run() {
                           getAllData();
                       }
                   });


                }
            }
        });

    }

    public void getAllData(){
        AppExecutor.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {
                databaseList = UserDBClient.getInstance(getApplicationContext())
                        .getUserDBDatabase().userDBDao().getAll();


                AppExecutor.getInstance().getMainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        setDataInVerticalRecyclerView(databaseList);
                    }
                });
            }
        });
    }

    public void deleteAllData(){
        AppExecutor.getInstance().getDiskIO().execute(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

    public void setDataInVerticalRecyclerView(List<Items> itList){
        verRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        VerticalAdapter verticalAdapter = new VerticalAdapter(this, itList);
        verRecyclerView.setAdapter(verticalAdapter);
    }

    public void getJavaUsersList(String string){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait Sometime...");
        progressDialog.show();

        apiInterface.getJavaUsersList(string).enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {
                user = response.body();
                usersLists = user.getItems();
                insertData();
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("roh",t.toString());
                progressDialog.dismiss();
            }
        });

    }

    /*public void getJsUsersList(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait Sometime...");
        progressDialog.show();

        apiInterface.getJsUsersList().enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                user = response.body();
                usersLists = user.getItems();
                insertData();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("roh",t.toString());
                progressDialog.dismiss();
            }
        });

    }

    public void getKotlinUsersList(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait Sometime...");
        progressDialog.show();

        apiInterface.getKotlinUsersList().enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                user = response.body();
                usersLists = user.getItems();
                insertData();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("roh",t.toString());
                progressDialog.dismiss();
            }
        });

    }

    public void getSwiftUsersList(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait Sometime...");
        progressDialog.show();

        apiInterface.getSwiftUsersList().enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                user = response.body();
                usersLists = user.getItems();
                insertData();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("roh",t.toString());
                progressDialog.dismiss();
            }
        });

    }

    public void getPythonUsersList(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait Sometime...");
        progressDialog.show();

        apiInterface.getPythonUsersList().enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                user = response.body();
                usersLists = user.getItems();
                insertData();
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("roh",t.toString());
                progressDialog.dismiss();
            }
        });

    }

    public void getCUsersList(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait Sometime...");
        progressDialog.show();

        apiInterface.getCUsersList().enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                user = response.body();
                usersLists = user.getItems();
                insertData();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("roh",t.toString());
                progressDialog.dismiss();
            }
        });

    }

    public void getCppUsersList(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait Sometime...");
        progressDialog.show();

        apiInterface.getCppUsersList().enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                user = response.body();
                usersLists = user.getItems();
                insertData();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("roh",t.toString());
                progressDialog.dismiss();
            }
        });

    }

    public void getAssemblyUsersList(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please Wait Sometime...");
        progressDialog.show();

        apiInterface.getAssemblyUsersList().enqueue(new Callback<UsersList>() {
            @Override
            public void onResponse(Call<UsersList> call, Response<UsersList> response) {

                user = response.body();
                usersLists = user.getItems();
                insertData();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<UsersList> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
                Log.e("roh",t.toString());
                progressDialog.dismiss();
            }
        });

    }*/


    @Override
    public void onClickNotify() {
        count++;
        textView.setText(String.valueOf(count));
    }

    @Override
    public void onClickJavaList() {
        Toast.makeText(getApplicationContext(),"Java",Toast.LENGTH_SHORT).show();
        getJavaUsersList("language:java");
    }

    @Override
    public void onClickJsList() {
        Toast.makeText(getApplicationContext(),"JavaScript",Toast.LENGTH_SHORT).show();
        getJavaUsersList("language:js");
    }

    @Override
    public void onClickKotlinList() {
        Toast.makeText(getApplicationContext(),"Kotlin",Toast.LENGTH_SHORT).show();
        getJavaUsersList("language:kotlin");
    }

    @Override
    public void onClickSwiftList() {
        Toast.makeText(getApplicationContext(),"Swift",Toast.LENGTH_SHORT).show();
        getJavaUsersList("language:swift");
    }

    @Override
    public void onClickPythonList() {
        Toast.makeText(getApplicationContext(),"Python",Toast.LENGTH_SHORT).show();
        getJavaUsersList("language:python");
    }

    @Override
    public void onClickCList() {
        Toast.makeText(getApplicationContext(),"C",Toast.LENGTH_SHORT).show();
        getJavaUsersList("language:c");
    }

    @Override
    public void onClickCppList() {
        Toast.makeText(getApplicationContext(),"Cpp",Toast.LENGTH_SHORT).show();
        getJavaUsersList("language:cpp");
    }

    @Override
    public void onClickAssemblyList() {
        Toast.makeText(getApplicationContext(),"Assembly",Toast.LENGTH_SHORT).show();
        getJavaUsersList("language:assembly");
    }
}
