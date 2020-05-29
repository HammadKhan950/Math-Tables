package com.example.timestablesudemy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ListView timeListView;
    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent=new ArrayList<String>();
        for (int i=1;i<=20;i++){
            timesTableContent.add(timesTableNumber+"X"+i+"="+ i*timesTableNumber +"");
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);
        timeListView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Math Tables");
        seekBar=(SeekBar)findViewById(R.id.seekBar2);
        timeListView=(ListView)findViewById(R.id.timeListview);

        seekBar.setMax(20);
        seekBar.setProgress(10);
        generateTimesTable(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               int min=1;
               int timesTableNumber;
               if(progress<min){
                   timesTableNumber=min;
                   seekBar.setProgress(min);
               }else{
                   timesTableNumber=progress;
                 generateTimesTable(timesTableNumber);
               }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
