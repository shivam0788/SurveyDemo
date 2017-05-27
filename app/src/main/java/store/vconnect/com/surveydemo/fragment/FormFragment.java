package store.vconnect.com.surveydemo.fragment;


import android.app.DownloadManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import store.vconnect.com.surveydemo.MainActivity;
import store.vconnect.com.surveydemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {


    private static final String TAG = MainActivity.class.getName();
    LinearLayout ll;
    LinearLayout lm;
    Button btnsubmitsurvey;
    private static final int MY_BUTTON = 9000;

    public FormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnsubmitsurvey=(Button)view.findViewById(R.id.btnsubmitsurvey);
        lm = (LinearLayout) view.findViewById(R.id.linearLayout2);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //  getformdata();
        ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);
       /* for(int i = 0; i < 10; i++) {
            CheckBox cb = new CheckBox(getActivity());
            cb.setText("Dynamic Checkbox " + i);
            cb.setId(i+10);
            ll.addView(cb);
        }*/
        // lm.addView(ll);
        btnsubmitsurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  saveAnswers();
                LinearLayout root = (LinearLayout) view.findViewById(R.id.linearLayout1); //or whatever your root control is
               // loopQuestions(root);

            }
        });


        //  private void getformdata() {
        String url = "http://www.json-generator.com/api/json/get/cvlCjgzHEy?indent=2";
        RequestQueue request = Volley.newRequestQueue(getActivity());
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e(TAG, response.toString());
                Toast.makeText(getActivity(), "" + response, Toast.LENGTH_SHORT).show();
                try {
                    JSONArray array = response.getJSONArray("Question");
                    for (int i = 0; i <= array.length(); i++) {
                        JSONObject obj = array.getJSONObject(i);
                        JSONObject obj1 = obj.getJSONObject("Question");
                        String Questionnumber = obj1.getString("id");
                        String Typed = obj1.getString("Type");

                        Toast.makeText(getActivity(), " " + Typed, Toast.LENGTH_SHORT).show();
                        if (Typed.equals("RadioButton"))// == "RadioButton" )//&& Typed != "CheckBox" && Typed != "Text")
                             {
                                 String name = obj1.getString("name");
                                 String option1 = obj1.getString("option1");
                                 String option2 = obj1.getString("option2");
                                 String option3 = obj1.getString("option3");
                                 String option4 = obj1.getString("option4");
                           Toast.makeText(getActivity(), "radioghhghhjgjhgh", Toast.LENGTH_SHORT).show();
                            callradiobutton(Questionnumber, name, option1, option2, option3, option4);
                        } else if (Typed.equals("CheckBox")) {
                            String name = obj1.getString("name");
                            String option1 = obj1.getString("option1");
                            String option2 = obj1.getString("option2");
                            String option3 = obj1.getString("option3");
                            String option4 = obj1.getString("option4");

                            Toast.makeText(getActivity(), "checkbox", Toast.LENGTH_SHORT).show();
                            callCheckbox(Questionnumber, name, option1, option2, option3, option4);
                        } else if(Typed.equals("Text"))
                        {
                            String name = obj1.getString("name");
                          //  String option1 = obj1.getString("option1");
                           // String option2 = obj1.getString("option2");
                          //  String option3 = obj1.getString("option3");
                         //   String option4 = obj1.getString("option4");
                            callTextview(Questionnumber, name);

                            Toast.makeText(getActivity(), "texgfdgfdgdfgt", Toast.LENGTH_SHORT).show();

                        }

                       /* switch (Typed){
                            case "RadioButton":callradiobutton(Questionnumber, name, option1, option2, option3, option4);
                        }*/

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.toString());
            }
        });
        request.add(req);
       /* Button b = new Button(getActivity());
        b.setText("Button added dynamically!");
         // b.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        //b.setId(MY_BUTTON);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast;
                toast = Toast.makeText(getActivity(), "Clicked dynamically added button!", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP, 25, 400);
                toast.show();
                //  saveAnswers();
            }
        });
        ll.addView(b);
        lm.addView(ll);*/
    }

   /* private void loopQuestions(LinearLayout root) {
        for(int i = 0; i < root.getChildCount(); i++) {
            View child = root.getChildAt(i);
            if (child instanceof RadioGroup) {
                //Support for RadioGroups
                RadioGroup radio = (RadioGroup) child;
                storeAnswer(radio.getId(), radio.getCheckedRadioButtonId());
            } else if (child instanceof CheckBox) {
                //Support for Checkboxes
                CheckBox cb = (CheckBox) child;
                int answer = cb.isChecked() ? 1 : 0;
                storeAnswer(cb.getId(), answer);
            } else if (child instanceof EditText) {
                //Support for EditText
                EditText et = (EditText) child;
                Log.w("ANDROID DYNAMIC VIEWS:", "EdiText: " + et.getText());
            }
            *//*else if(child instanceof ToggleButton) {
                //Support for ToggleButton
                ToggleButton tb = (ToggleButton)child;
                Log.w("ANDROID DYNAMIC VIEWS:", "Toggle: " + tb.getText());
            }*//*
            else {
                //Support for other controls
            }

           *//* if (child instanceof ViewGroup) {
                //Nested Q&A
                ViewGroup group = (ViewGroup) child;
                loopQuestions(group);
            }*//*
        }
    }*/

    private void storeAnswer(int question, int answer) {
       // private void storeAnswer(int question, int answer) {
            Log.w("ANDROID DYNAMIC VIEWS:", "Question: " + String.valueOf(question) + " * "+ "Answer: " + String.valueOf(answer) );

            Toast toast = Toast.makeText(getActivity(), String.valueOf(question) + " * "+ "Answer: " + String.valueOf(answer), Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 25, 400);
            toast.show();


        }



    private void callTextview(String questionnumber, String name) {
      //  ll = new LinearLayout(getActivity());
     //   ll.setOrientation(LinearLayout.HORIZONTAL);
        TextView tv = new TextView(getActivity());
        tv.setText(name);
        ll.addView(tv);
        EditText et = new EditText(getActivity());
        et.setText("");
        et.setMinLines(1);
        et.setMaxLines(3);
        ll.addView(et);
      //  lm.addView(ll);
        Toast.makeText(getActivity(), "text", Toast.LENGTH_SHORT).show();
    }

    private void callCheckbox(String questionnumber, String name, String option1, String option2, String option3, String option4) {
        String checkboxarray[] = {option1, option2, option3, option4};
        TextView tv = new TextView(getActivity());
        tv.setText(name);
        ll.addView(tv);
        CheckBox cb = null;
        for(int i = 0; i < checkboxarray.length; i++) {
             cb = new CheckBox(getActivity());
            cb.setText(checkboxarray[i]);
           // cb.setId(i+10);
            ll.addView(cb);
        }
        int answer = cb.isChecked() ? 1 : 0;
        storeAnswer(cb.getId(), answer);

       /* for (int i = 0; i < 10; i++) {
            CheckBox cb = new CheckBox(getActivity());
            cb.setText("Dynamic Checkbox " + i);
            cb.setId(i + 10);
            ll.addView(cb);
        }*/
        Toast.makeText(getActivity(), "checkbox", Toast.LENGTH_SHORT).show();
       // lm.addView(ll);
    }

    private void callradiobutton(String questionnumber, String name, String option1, String option2, String option3, String option4) {
        final RadioButton[] rb = new RadioButton[4];
        ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);
        String radioarray[] = {option1, option2, option3, option4};
        TextView tv = new TextView(getActivity());
        tv.setText(name);
        ll.addView(tv);

        RadioGroup rg = new RadioGroup(getActivity()); //create the RadioGroup
        rg.setOrientation(RadioGroup.VERTICAL);//or RadioGroup.VERTICAL
        for (int i = 0; i < radioarray.length; i++) {
            rb[i] = new RadioButton(getActivity());
            rb[i].setText(radioarray[i]);
            rb[i].setId(i);
            rg.addView(rb[i]); //the RadioButtons are added to the radioGroup instead of the layout
            
        }

        ll.addView(rg);
      //  Toast.makeText(getActivity(), "rbName"+rbName, Toast.LENGTH_SHORT).show();
        lm.addView(ll);
    }

}
