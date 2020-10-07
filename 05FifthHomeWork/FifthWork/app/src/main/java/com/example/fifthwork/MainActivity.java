package com.example.fifthwork;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPersons();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter(personList);
        recyclerView.setAdapter(adapter);
    }

    private void initPersons() {
        for (int i = 0; i < 2; i++) {
            Person mj = new Person(getRandomLengthName("迈克尔乔丹"), R.drawable.mj_pic);
            personList.add(mj);
            Person sc = new Person(getRandomLengthName("斯蒂芬库里"), R.drawable.sc_pic);
            personList.add(sc);
            Person kb = new Person(getRandomLengthName("科比布莱恩特"), R.drawable.kb_pic);
            personList.add(kb);
            Person kd = new Person(getRandomLengthName("凯文杜兰特"), R.drawable.kd_pic);
            personList.add(kd);
            Person ael = new Person(getRandomLengthName("阿伦艾弗森"), R.drawable.ale_pic);
            personList.add(ael);
            Person kl = new Person(getRandomLengthName("凯里欧文"), R.drawable.kl_pic);
            personList.add(kl);
            Person lj = new Person(getRandomLengthName("勒布朗詹姆斯"), R.drawable.lj_pic);
            personList.add(lj);
            Person so = new Person(getRandomLengthName("沙奎尔奥尼尔"), R.drawable.so_pic);
            personList.add(so);
            Person wc = new Person(getRandomLengthName("威尔特张伯伦"), R.drawable.wc_pic);
            personList.add(wc);
            Person jh = new Person(getRandomLengthName("詹姆斯哈登"), R.drawable.jh_pic);
            personList.add(jh);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }

}
