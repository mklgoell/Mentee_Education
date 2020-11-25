package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<DataModel> arrayList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        getJSON();

    }
    public void getJSON(){
        String json;
        try {
            InputStream inputStream = getAssets().open("data.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0 ; i < jsonArray.length() ; i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                DataModel dataModel = new DataModel(jsonObject.getString("assessment_id"),
                        jsonObject.getString("assessment_name"),jsonObject.getString("attempt_date"),
                        jsonObject.getInt("test_duration"),jsonObject.getString("description"));
                arrayList.add(dataModel);
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        Adapter adapter = new Adapter(this,arrayList);
        listView.setAdapter(adapter);
    }
}