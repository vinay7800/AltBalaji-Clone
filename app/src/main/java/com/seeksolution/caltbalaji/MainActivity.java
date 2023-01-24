package com.seeksolution.caltbalaji;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.seeksolution.caltbalaji.Adapters.OriginalAdapter;
import com.seeksolution.caltbalaji.Adapters.TrendingAdapter;
import com.seeksolution.caltbalaji.Adapters.WebAdapter;
import com.seeksolution.caltbalaji.Models.OriginalModel;
import com.seeksolution.caltbalaji.Models.TrendingModel;
import com.seeksolution.caltbalaji.Models.WebModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private String[] ImageUrls = {
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1327/441327-v"
    };
    private String[] ImageUrls1 = {
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1327/441327-v"
    };
    private String[] ImageUrls2 = {
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1327/441327-v"
    };

    ArrayList<TrendingModel> modelArrayList;
    ArrayList<WebModel> webModelArrayList;
    ArrayList<OriginalModel> originalModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView) findViewById(R.id.rc_view_trending_list);
        recyclerView1=(RecyclerView)findViewById(R.id.rc_view_web_list);
       recyclerView2=(RecyclerView)findViewById(R.id.rc_view_original_list);
        //Layout Manager=>Horizontal


        modelArrayList=new ArrayList<TrendingModel>();
        for(int i=0;i<ImageUrls.length;i++){
        modelArrayList.add(new TrendingModel(ImageUrls[i]));
        }
        TrendingAdapter adapter=new TrendingAdapter(getApplicationContext(),modelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);


        webModelArrayList=new ArrayList<WebModel>();
        for(int i=0;i<ImageUrls1.length;i++){
            webModelArrayList.add(new WebModel(ImageUrls1[i]));
        }
        WebAdapter adapter1=new WebAdapter(getApplicationContext(),webModelArrayList);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView1.setAdapter(adapter1);

        originalModelArrayList=new ArrayList<OriginalModel>();
        for(int i=0;i<ImageUrls2.length;i++){
            originalModelArrayList.add(new OriginalModel(ImageUrls2[i]));
        }
        OriginalAdapter adapter2=new OriginalAdapter(getApplicationContext(),originalModelArrayList);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView2.setAdapter(adapter2);

    }
}