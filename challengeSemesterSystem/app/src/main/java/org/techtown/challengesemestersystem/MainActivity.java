package org.techtown.challengesemestersystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FragmentHome fragmentHome;
    private FragmentArlam fragmentArlam;
    private FragmentMessage fragmentMessage;
    private Button btn_home,btn_message,btn_arlam,btn_menu;

    static final String[] ListMenu={"박소영","mini0u0","pthdud1123"};
    ArrayAdapter arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentHome=new FragmentHome();
        fragmentArlam=new FragmentArlam();
        fragmentMessage=new FragmentMessage();
        btn_home=(Button)findViewById(R.id.button_home);
        btn_arlam=(Button)findViewById(R.id.button_arlam);
        btn_message=(Button)findViewById(R.id.button_message);
        btn_menu=(Button)findViewById(R.id.button_menu);

        /*
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,ListMenu);
        listView=(ListView)findViewById(R.id.listview_1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                String strText=(String)adapterView.getItemAtPosition(i);
            }
        });


         */

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("홈버튼");
                clickMainButton(0);

            }
        });
        btn_arlam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("알람버튼");
                clickMainButton(1);
            }
        });
        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("메세지 버튼");
                clickMainButton(2);

            }
        });


       fragmentTransaction.replace(R.id.fragment_layout,fragmentHome).commitAllowingStateLoss();

    }
    public void clickMainButton(int a){
        fragmentTransaction=fragmentManager.beginTransaction();
        switch (a){
            case 0:
                fragmentTransaction.replace(R.id.fragment_layout,fragmentHome).commitAllowingStateLoss();
                break;
            case 1:
                fragmentTransaction.replace(R.id.fragment_layout,fragmentArlam).commitAllowingStateLoss();
                break;
            case 2:
                fragmentTransaction.replace(R.id.fragment_layout,fragmentMessage).commitAllowingStateLoss();
                break;

        }
    }
}