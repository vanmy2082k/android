package com.example.vanmy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vanmy.api.API;
import com.example.vanmy.model.Count;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activity_Count extends AppCompatActivity {

    private TextView tvCount;
    private Button btnAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        tvCount = findViewById(R.id.tvCount);
        btnAPI = findViewById(R.id.btnAPI);
        btnAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCallAPI();
            }
        });
    }
    private void clickCallAPI() {
        API.api.sendCount("counter_online").enqueue(new Callback<Count>() {
            @Override
            public void onResponse(Call<Count> call, Response<Count> response) {
               Toast.makeText( Activity_Count.this, "Thành công", Toast.LENGTH_SHORT).show();

               Count action = response.body();
               if(action !=null){
                   tvCount.setText(action.getAction());
               }
            }

            @Override
            public void onFailure(Call<Count> call, Throwable t) {
                Toast.makeText( Activity_Count.this, "Thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }

}