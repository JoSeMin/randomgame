package kr.hs.emrirm.a9767tklp.monchicken;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mName;
    Button nButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = (EditText)findViewById(R.id.name);
        nButton = (Button)findViewById(R.id.btn_show_me_the_chicken);
        nButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mName.setText("");
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        String name = mName.getText().toString();
//        if (name == null){
//            Toast.makeText(this, "이름을 입력해 주세요!", Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(this, name+"씨, 배고파요!", Toast.LENGTH_LONG).show();
//            Intent intent=new Intent(this,ResultActivity.class);  /*result엑티비티로 넘어가는 클래스만 만듬*/
//            startActivity(intent);  /*intent넘겨주기*/
//        }

        try{
            Toast.makeText(this, name+"씨, 배고파요!", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,ResultActivity.class);  /*result엑티비티로 넘어가는 클래스만 만듬*/
            intent.putExtra("name", name); /*적은 데이터만 넘겨야 함*/
            intent.putExtra("age", 10);
            startActivity(intent);  /*intent넘겨주기*/
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }catch(NullPointerException e){
            Toast.makeText(this, "이름을 입력해 주세요!", Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(this, "뭔지 모르지만 잘 안되네요!", Toast.LENGTH_LONG).show();
        }
    }
}