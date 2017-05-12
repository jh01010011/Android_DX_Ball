package randomforest.com.dxb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_1=(Button) findViewById(R.id.btn_1);
        Button btn_2=(Button) findViewById(R.id.btn_2);
        Button btn_3=(Button) findViewById(R.id.btn_3);


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GCLoder.class);
                Bundle bundle=new Bundle();
                bundle.putInt("level",1);
                bundle.putInt("row",3);
                bundle.putInt("column",9);
                bundle.putFloat("dx",10);
                bundle.putFloat("dy",-10);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GCLoder.class);
                Bundle bundle=new Bundle();
                bundle.putInt("level",2);
                bundle.putInt("row",6);
                bundle.putInt("column",9);
                bundle.putFloat("dx",19);
                bundle.putFloat("dy",-19);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),GCLoder.class);
                Bundle bundle=new Bundle();
                bundle.putInt("level",3);
                bundle.putInt("row",9);
                bundle.putInt("column",9);
                bundle.putFloat("dx",25);
                bundle.putFloat("dy",-25);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
