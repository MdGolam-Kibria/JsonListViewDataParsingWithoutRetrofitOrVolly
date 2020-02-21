package com.example.jsonlistviewdataparsingtry;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        MyTash myTash = new MyTash();
        myTash.execute();
    }

    public class MyTash extends AsyncTask<String, String, List<DemoStudent>> {
        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        String jsonFile;

        @Override
        protected List<DemoStudent> doInBackground(String... strings) {
            try {
                URL url = new URL("https://api.myjson.com/bins/l0cir");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer stringBuffer = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);
                }
                jsonFile = stringBuffer.toString();
                JSONObject jsonObject = new JSONObject(jsonFile);
                JSONArray jsonArray = jsonObject.getJSONArray("kibriaInfo");
                List<DemoStudent> list = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject arrayObject = jsonArray.getJSONObject(i);
                    DemoStudent demoStudent = new DemoStudent();
                    demoStudent.setName(arrayObject.getString("name"));
                    demoStudent.setDept(arrayObject.getString("year"));
                    demoStudent.setYear(arrayObject.getString("year"));
                    demoStudent.setUniversity(arrayObject.getString("University"));
                    list.add(demoStudent);
                }

                return list;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                httpURLConnection.disconnect();
                ;
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<DemoStudent> s) {
            super.onPostExecute(s);
            CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), R.layout.simple, s);
            listView.setAdapter(customAdapter);

        }
    }

}
