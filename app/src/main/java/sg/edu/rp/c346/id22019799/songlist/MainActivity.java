package sg.edu.rp.c346.id22019799.songlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShowList;
    TextView tvTitle,tvSingers,tvYear,tvStars;
    EditText editTitle,editSingers,editYear;
    ListView lvResults;
    RadioGroup radioGrpStar;
    RadioButton radiobtn1,radiobtn2,radiobtn3,radiobtn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsert);
        btnShowList = findViewById(R.id.buttonShowList);
        tvTitle = findViewById(R.id.textViewTitle);
        tvSingers = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewTitle);
        tvStars = findViewById(R.id.textViewStars);
        lvResults = findViewById(R.id.songList);
        editTitle = findViewById(R.id.editTextTitle);
        editSingers = findViewById(R.id.editTextSinger);
        editYear = findViewById(R.id.editTextYear);
        radioGrpStar = findViewById(R.id.radioGrpStar);
        radiobtn1 = findViewById(R.id.radioButton1);
        radiobtn2 = findViewById(R.id.radioButton2);
        radiobtn3 = findViewById(R.id.radioButton3);
        radiobtn4 = findViewById(R.id.radioButton4);

        DBHelper db = new DBHelper(MainActivity.this);
        ArrayList<Song> data = db.getTasks();
        //ArrayAdapter taskky = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);


        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                //DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                String title= editTitle.getText().toString();
                String singer= editSingers.getText().toString();
                int year = Integer.parseInt(editYear.getText().toString());
                String star = "";
                int checkedradio = radioGrpStar.getCheckedRadioButtonId();
                if(checkedradio==R.id.radioButton1){
                    star="*";
                }else if(checkedradio==R.id.radioButton2){
                    star="**";
                }else if(checkedradio==R.id.radioButton3){
                    star="***";
                }else if(checkedradio==R.id.radioButton4){
                    star="****";
                }else{
                    star="*****";
                }
                db.insertSong(title, singer,year,star);

            }
        });


        btnShowList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context


                Song target = data.get(0);

                Intent i = new Intent(MainActivity.this,
                        RetrieveActivity.class);
                i.putExtra("data", target);
                startActivity(i);

                //old stuff
                //DBHelper db = new DBHelper(MainActivity.this);



                // Insert a task
                //ArrayList<Song> data = db.getTasks();
                //ArrayAdapter taskky = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);
                //lvResults.setAdapter(taskky);
                //db.close();

                //String txt = "";
                //for (int i = 0; i < data.size(); i++) {
                    //Log.d("Database Content", i +". "+data.get(i));
                    //txt += i + ". " + data.get(i) + "\n";

                    //String filterText = lvResults.getText().toString().trim();
                    //if(filterText.length() == 0) {
                        //data.addAll(db.getTasks());
                    //}
                    //else{
                        //taskky.addAll(db.getTasks(filterText));
                    //}

                    //data.add(i,txt);
                    //taskky.notifyDataSetChanged();
                //}
            }
        });
    }
}