package com.example.denish.sqlite_crud_template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create our sqlite helper class
        db = new SQLiteDatabaseHandler(this);
        // create some students
        Student student1 = new Student(1, "Lebron James", "F", "abc");
        Student student2 = new Student(2, "Kevin Durant", "F", "def");
        Student student3 = new Student(3, "Rudy Gobert", "C", "ghi");
        Student student4 = new Student(4, "Rudy Gobert", "C", "ghi");
        Student student5 = new Student(5, "Rudy Gobert", "C", "ghi");
        Student student6 = new Student(6, "Rudy Gobert", "C", "ghi");
        Student student7 = new Student(7, "Rudy Gobert", "C", "ghi");
        Student student8 = new Student(8, "Rudy Gobert", "C", "ghi");
        Student student9 = new Student(9, "Rudy Gobert", "C", "ghi");
        Student student10 = new Student(10, "Rudy Gobert", "C", "ghi");
        Student student11= new Student(11, "Rudy Gobert", "C", "ghi");
        Student student12 = new Student(12, "Rudy Gobert", "C", "ghi");
        Student student13 = new Student(13, "Rudy Gobert", "C", "ghi");
        Student student14 = new Student(14, "Rudy Gobert", "C", "ghi");

        // add them
        db.addPlayer(student1);
        db.addPlayer(student2);
        db.addPlayer(student3);
        db.addPlayer(student4);
        db.addPlayer(student5);
        db.addPlayer(student6);
        db.addPlayer(student7);
        db.addPlayer(student8);
        db.addPlayer(student9);
        db.addPlayer(student10);
        db.addPlayer(student11);
        db.addPlayer(student12);
        db.addPlayer(student13);
        db.addPlayer(student14);
        // list all students
        List<Student> students = db.allPlayers();

        if (students != null) {
            String[] itemsNames = new String[students.size()];

            for (int i = 0; i < students.size(); i++) {
                itemsNames[i] = students.get(i).toString();
            }

            // display like string instances
            ListView list = (ListView) findViewById(R.id.list);
            list.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, itemsNames));

        }

    }
}
