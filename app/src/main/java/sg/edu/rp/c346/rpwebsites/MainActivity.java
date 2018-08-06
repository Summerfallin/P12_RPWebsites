package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    Spinner spn1;
    Spinner spn2;
    int pos1;
    int pos2;
    ArrayList<String> alPages;
    ArrayAdapter<String> aaPages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGo=findViewById(R.id.buttonGo);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);

        alPages = new ArrayList<>();

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        alPages.clear();
                        String[] strNumbers = getResources().getStringArray(R.array.rppage);
                        alPages.addAll(Arrays.asList(strNumbers));

                        break;
                    case 1:
                        alPages.clear();
                        String[] strNumbers1 = getResources().getStringArray(R.array.soipage);
                        alPages.addAll(Arrays.asList(strNumbers1));

                        break;
                }
                pos1 = i;
                aaPages = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,alPages);
                spn2.setAdapter(aaPages);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pos2 = spn2.getSelectedItemPosition();
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),website.class);
                if(spn2.getSelectedItemPosition()==0 && spn1.getSelectedItemPosition()==0){
                    intent.putExtra("url","https://www.rp.edu.sg/");
                }else if(spn2.getSelectedItemPosition()==1 && spn1.getSelectedItemPosition()==0){
                    intent.putExtra("url","https://www.rp.edu.sg/student-life");
                }else if (spn2.getSelectedItemPosition()==0 && spn1.getSelectedItemPosition()==1){
                    intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r47");
                }else if(spn2.getSelectedItemPosition()==1 && spn1.getSelectedItemPosition()==1){
                    intent.putExtra("url","https://www.rp.edu.sg/soi/full-time-diplomas/details/r12");
                }

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        spn1.setSelection(pos1);
        spn2.setSelection(pos2);
        super.onResume();
    }
}
