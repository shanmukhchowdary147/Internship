package com.example.internship;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.internship.Entity.RoomModel;
import com.example.internship.Models.LangModel;
import com.example.internship.Models.Model1;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Shannu";
    RecyclerView recyclerView;
    Button del;
    SearchView searchView;
    ArrayList<String> List=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.rv);
        del=(Button)findViewById(R.id.del);

        Toast.makeText(this, "Wait for 5 sec to display", Toast.LENGTH_SHORT).show();

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseClass.getDatabase(getApplicationContext()).getDao().delete();
                recyclerView.setAdapter(new AdapterClass(DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData(),MainActivity.this));
            }
        });

        Methods methods=RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<List<Model1>> call= methods.getAllDAta();
        call.enqueue(new Callback<List<Model1>>() {
            @Override
            public void onResponse(Call<List<Model1>> call, Response<List<Model1>> response) {

                Log.e(TAG, "onResponse: " + response.code());
                Log.e(TAG, "onResponse: " + response.body().size());

                if(DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData().size()==0) {
                    for (int i = 0; i < response.body().size(); i++) {
                        RoomModel roomModel=new RoomModel();
                        roomModel.setName(response.body().get(i).getName());
                        List.add(response.body().get(i).getName());
                        roomModel.setCapital(response.body().get(i).getCapital());
                        roomModel.setRegion(response.body().get(i).getRegion());
                        roomModel.setSubregion(response.body().get(i).getSubregion());
                        roomModel.setPopulation(response.body().get(i).getPopulation());
                        roomModel.setLanguages(response.body().get(i).getLanguages().get(0).getName());
                        roomModel.setBorders(response.body().get(i).getBorders());
                        roomModel.setFlag(response.body().get(i).getFlag());
                        Log.e(TAG, response.body().get(i).getFlag());
                        DatabaseClass.getDatabase(getApplicationContext()).getDao().insertAllData(roomModel);
                    }

                }
                recyclerView.setAdapter(new AdapterClass(DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData(),MainActivity.this));

            }

            @Override
            public void onFailure(Call<List<Model1>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage() );
                recyclerView.setAdapter(new AdapterClass(DatabaseClass.getDatabase(getApplicationContext()).getDao().getAllData(),MainActivity.this
                ));

            }
        });


    }
}