package idv.star.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by STAR on 2015/7/5.
 */
public class ResultActivity extends ActionBarActivity{
    private TextView tvBMI,tvResult;
    private Button btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        findViews();
        showResult();
    }
    private void findViews(){
        tvBMI=(TextView)findViewById(R.id.tvBMI);
        tvResult=(TextView)findViewById(R.id.tvResult);
        btBack=(Button)findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResultActivity.this.finish();
            }
        });
    }
    private void showResult(){
        Bundle bundle = this.getIntent().getExtras();
       double height=bundle.getDouble("height");
        double weight=bundle.getDouble("weight");
        double BMI=weight/((height/100)*(height/100));
        tvBMI.setText("BMI值為:"+BMI);
        if(BMI>=35){
            tvResult.setText("過重,該減肥了!!");
        }
        else if(BMI>=30){
            tvResult.setText("中度肥胖");
        }
        else if(BMI>=27){
            tvResult.setText("輕度肥胖");
        }
        else if(BMI>=24){
            tvResult.setText("過重");
        }
        else if(BMI>=18){
            tvResult.setText("正常");
        }
        else if(BMI<18.5){
            tvResult.setText("體重過輕,多吃一點");
        }







    }

}


