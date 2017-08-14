package net.alhazmy13.wordcloud.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import net.alhazmy13.example.R;
import net.alhazmy13.wordcloud.ColorTemplate;
import net.alhazmy13.wordcloud.WordCloud;
import net.alhazmy13.wordcloud.WordCloudView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    List<WordCloud> list ;
    String text = "one two three four five six seven eight nine ten eleven twelve thirteen fourteen fiveteen sixteen seventeen eighteen nineteen twenty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomText();
    }

    @Override
    protected void onResume() {
        super.onResume();

        WordCloudView wordCloud = (WordCloudView) findViewById(R.id.wordCloud);
        wordCloud.setDataSet(list);
        wordCloud.setColors(ColorTemplate.MATERIAL_COLORS);
        wordCloud.notifyDataSetChanged();
    }



    private void generateRandomText() {
        String[] data = text.split(" ");
        list = new ArrayList<>();
        Random random = new Random();
        list.add(new WordCloud("zero",0));

        int weight = data.length + 12 ;

        for (String s : data) {
            list.add(new WordCloud(s,--weight));
        }
    }
}


