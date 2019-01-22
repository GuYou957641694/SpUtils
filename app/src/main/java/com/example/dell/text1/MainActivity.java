package com.example.dell.text1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.dianji)
    Button dianji;
    @BindView(R.id.lala)
    Button lala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.dianji, R.id.lala})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dianji:
                String mname = name.getText().toString();
                String mpassword = password.getText().toString();
                SpUtils.put("qname", mname);
                SpUtils.put("qpass", mpassword);
                Toast.makeText(this, "用户名" + mname + mpassword, Toast.LENGTH_SHORT).show();
                break;
            case R.id.lala:
                String qname = SpUtils.getString("qname", "");
                String qpass = SpUtils.getString("qpass", "");
                Toast.makeText(this, "用户名" + qname + qpass, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
