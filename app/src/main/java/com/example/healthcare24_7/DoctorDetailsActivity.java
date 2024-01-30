package com.example.healthcare24_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Kasibante Julius", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Kusemererwa Willium", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Mulindwa Julius", "Hospital Address : Lugazi", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Muwanguzi Anthony", "Hospital Address : Mukono", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Ameria Kyambadde", "Hospital Address : Kampala", "Exp : 5yrs", "Mobile No : 0761488516","50,000"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Mirembe Julius", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Kusemererwa Willium", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Mulindwa Julius", "Hospital Address : Lugazi", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Muwanguzi Anthony", "Hospital Address : Mukono", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Ameria Kyambadde", "Hospital Address : Kampala", "Exp : 5yrs", "Mobile No : 0761488516","50,000"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Kasibante Julius", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Kusemererwa Willium", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Mulindwa Julius", "Hospital Address : Lugazi", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Muwanguzi Anthony", "Hospital Address : Mukono", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Ameria Kyambadde", "Hospital Address : Kampala", "Exp : 5yrs", "Mobile No : 0761488516","50,000"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Kasibante Julius", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Kusemererwa Willium", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Mulindwa Julius", "Hospital Address : Lugazi", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Muwanguzi Anthony", "Hospital Address : Mukono", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Ameria Kyambadde", "Hospital Address : Kampala", "Exp : 5yrs", "Mobile No : 0761488516","50,000"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Kasibante Julius", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Kusemererwa Willium", "Hospital Address : Hoima", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Mulindwa Julius", "Hospital Address : Lugazi", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Muwanguzi Anthony", "Hospital Address : Mukono", "Exp : 5yrs", "Mobile No : 0761488516","50,000"},
                    {"Doctor Name : Ameria Kyambadde", "Hospital Address : Kampala", "Exp : 5yrs", "Mobile No : 0761488516","50,000"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details =  {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap <String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDtitle);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Family Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Family Surgeon")==0)
            doctor_details = doctor_details4;
        else
        if(title.compareTo("Cardiologist")==0)
            doctor_details = doctor_details5;

        btn = findViewById(R.id.buttonDDBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5","cons_fees"+doctor_details[i][4]+" Shillings");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                 R.layout.multi_items,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst = findViewById(R.id.textViewDD);
        lst.setAdapter(sa);
    }
}