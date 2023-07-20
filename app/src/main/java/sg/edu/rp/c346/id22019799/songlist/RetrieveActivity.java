package sg.edu.rp.c346.id22019799.songlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class RetrieveActivity extends AppCompatActivity {

    Button btnShowStar;
    ListView lvSong;
   // Spinner starspinner;
    //Song song;
    ArrayList<Song> data;
    //ArrayAdapter<Song> taskky;
    CustomAdapter taskky;



    //ArrayList<Song> c = db.getTasks();
    //ArrayAdapter taskky = new ArrayAdapter(RetrieveActivity.this,android.R.layout.simple_list_item_1,songs);
        //lvSong.setAdapter(taskky);//
        //db.close();//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);


        btnShowStar=findViewById(R.id.btnSortStar);
        lvSong=findViewById(R.id.lvSong);
        data = new ArrayList<>();
        taskky = new CustomAdapter(this, R.layout.row, data);
        //taskky = new ArrayAdapter<>(RetrieveActivity.this,
                //android.R.layout.simple_list_item_1, data);
        lvSong.setAdapter(taskky);
        //starspinner=findViewById(R.id.spinnerSortStar);
        DBHelper db = new DBHelper(RetrieveActivity.this);
        data=db.getTasks();
        db.close();

        data.add(new Song(0,"Home","Kit Chan",1998,"*****"));
        data.add(new Song(2,"We Will Get There","Stefanie Sun",2002,"*****"));
        data.add(new Song(3,"Our Singapore","JJ Lin/Dick Lee",2015,"*****"));

        ArrayAdapter taskky = new ArrayAdapter(RetrieveActivity.this,android.R.layout.simple_list_item_1,data);
        lvSong.setAdapter(taskky);


        //Intent i = getIntent();
        //song = (Song) i.getSerializableExtra("data");

        //db.close();

        //String txt = "";
        //for (int i = 0; i < data.size(); i++) {
        //Log.d("Database Content", i +". "+data.get(i));
        //txt += i + ". " + data.get(i) + "\n";
    }


}