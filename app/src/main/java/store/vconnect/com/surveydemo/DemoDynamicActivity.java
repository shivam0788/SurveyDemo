package store.vconnect.com.surveydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DemoDynamicActivity extends AppCompatActivity {
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_dynamic);
        final LinearLayout lm = (LinearLayout) findViewById(R.id.linearLayout2);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //Create four

        for(int j=0;j<=4;j++)
        {
            // Create LinearLayout

            ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            // Create TextView
            TextView product = new TextView(this);
            product.setText(" Product"+j+"    ");
            ll.addView(product);

            // Create TextView
            TextView price = new TextView(this);
            price.setText("  $"+j+"     ");
            ll.addView(price);


            //ll.addView(cb);
            // Create Button
           /* final Button btn = new Button(this);
            // Give button an ID
            btn.setId(j+1);
            btn.setText("Add To Cart");
            // set the layoutParams on the button
            btn.setLayoutParams(params);
*/
          /*  final int index = j;
            // Set click listener for button
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Log.i("TAG", "index :" + index);

                    Toast.makeText(getApplicationContext(),
                            "Clicked Button Index :" + index,
                            Toast.LENGTH_LONG).show();

                }
            });*/
            //Add button to LinearLayout
          //  ll.addView(btn);
            //Add button to LinearLayout defined in XML
            lm.addView(ll);
        }
        for(int i = 0; i < 10; i++) {
            CheckBox cb = new CheckBox(this);
            ll.setOrientation(LinearLayout.VERTICAL);
            cb.setText("Dynamic Checkbox " + i);
            cb.setId(i+10);
            //  ll.addView(cb);
            ll.addView(cb);
        }
      //  lm.addView(ll);
    }
}
