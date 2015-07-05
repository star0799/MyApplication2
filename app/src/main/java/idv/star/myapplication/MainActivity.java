package idv.star.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private EditText etHeight;
    private EditText etWeight;
    private Button btSbmit;
    private Button btClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews(){
        etHeight=(EditText)findViewById(R.id.etHeight);
        etWeight=(EditText)findViewById(R.id.etWeight);
        btSbmit=(Button)findViewById(R.id.btSubmit);
        btSbmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,ResultActivity.class);
                Bundle bundle=new Bundle();
                try {
                    double height=Double.parseDouble(etHeight.getText().toString());
                    double weight=Double.parseDouble(etWeight.getText().toString());


                    if(height<=0||weight<=0){
                        throw new Exception();
                    }
                    bundle.putDouble("height",height);
                    bundle.putDouble("weight",weight);



                }
                catch (Exception e){

                    Toast.makeText(MainActivity.this,getString(R.string.inputError),Toast.LENGTH_SHORT).show();

                return;
                }
                intent.putExtras(bundle);
             startActivity(intent);





            }
        });
        btClear=(Button)findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etHeight.setText("");
                etWeight.setText("");
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
