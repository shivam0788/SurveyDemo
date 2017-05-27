package store.vconnect.com.surveydemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import store.vconnect.com.surveydemo.fragment.LoginFragment;

public class MainActivity extends AppCompatActivity {
   // FrameLayout id_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   id_container=(FrameLayout)findViewById(R.id.id_container);

        LoginFragment fragment =new LoginFragment();

        FragmentManager manager= getSupportFragmentManager();
        manager.beginTransaction().add(R.id.id_container,fragment,null).commit();
    }
}
