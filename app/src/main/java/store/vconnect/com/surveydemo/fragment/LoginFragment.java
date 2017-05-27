package store.vconnect.com.surveydemo.fragment;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import store.vconnect.com.surveydemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

Button btnlogin;
    TextView tvnoaccount;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);


        LinearLayout.LayoutParams llLP = new LinearLayout.LayoutParams(
                //android:layout_width="match_parent" an in xml
                LinearLayout.LayoutParams.MATCH_PARENT,
                //android:layout_height="wrap_content"
                LinearLayout.LayoutParams.MATCH_PARENT);


        ll.setLayoutParams(llLP);

        TextView tv = new TextView(getActivity());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        tv.setLayoutParams(lp);
        //android:text="@string/c4r"
        tv.setText("DELIVERED");
        //android:padding="@dimen/padding_medium"
        tv.setPadding(8, 8, 8, 8);
        ll.addView(tv);



        btnlogin = (Button)view.findViewById(R.id.btnlogin);
        tvnoaccount=(TextView)view.findViewById(R.id.tvNoaccount);

        tvnoaccount.setPaintFlags(tvnoaccount.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvnoaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistartionFragment fragment= new RegistartionFragment();
                FragmentManager manager= getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.id_container,fragment).addToBackStack(null).commit();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FormFragment fragment= new FormFragment();
                FragmentManager manager= getActivity().getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.id_container,fragment).addToBackStack(null).commit();
            }
        });

    }
}
