package com.example.firstapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.firstapplication.model.Prayer;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // The edit text and buttons from Home fragment..
    private EditText editTextFajr;
    private EditText editTextDhuhr;
    private EditText editTextAsr;
    private EditText editTextMaghrib;
    private EditText editTextIsha;
    private Button buttonSave;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        /** Button to add into database */
        buttonSave = view.findViewById(R.id.buttonSave);
        /** Edit texts */
        editTextFajr = view.findViewById(R.id.editTextFajr);
        editTextDhuhr = view.findViewById(R.id.editTextDhuhr);
        editTextAsr = view.findViewById(R.id.editTextAsr);
        editTextMaghrib = view.findViewById(R.id.editTextMaghrib);
        editTextIsha = view.findViewById(R.id.editTextIsha);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Prayer prayer = new Prayer();
                prayer.setId(1);
                if (!TextUtils.isEmpty(editTextFajr.getText()))
                    prayer.setFajr(Integer.parseInt(editTextFajr.getText().toString()));
                if (!TextUtils.isEmpty(editTextDhuhr.getText()))
                    prayer.setDhuhr(Integer.parseInt(editTextDhuhr.getText().toString()));
                if (!TextUtils.isEmpty(editTextAsr.getText()))
                    prayer.setAsr(Integer.parseInt(editTextAsr.getText().toString()));
                if (!TextUtils.isEmpty(editTextMaghrib.getText()))
                    prayer.setMaghrib(Integer.parseInt(editTextMaghrib.getText().toString()));
                if (!TextUtils.isEmpty(editTextIsha.getText()))
                    prayer.setIsha(Integer.parseInt(editTextIsha.getText().toString()));


                /** At first we should control the table
                 * - If the row exists in the table then we should update the row;
                 * - If the row does not exist then we should insert;
                 */

                if (MainActivity.appDatabase.prayerDao().findAll().size() == 0) {

                    // Inserting into Prayer table
                    MainActivity.appDatabase.prayerDao().add(prayer);

                    Toast.makeText(getActivity(), "Added successfully", Toast.LENGTH_SHORT).show();

                } else {

                    // TODO: If edit text is empty then don't update the column

                    for (Prayer prayerDb: MainActivity.appDatabase.prayerDao().findAll()) {
                        prayer.setFajr(prayerDb.getFajr() + prayer.getFajr());
                        prayer.setDhuhr(prayerDb.getDhuhr() + prayer.getDhuhr());
                        prayer.setAsr(prayerDb.getAsr() + prayer.getAsr());
                        prayer.setMaghrib(prayerDb.getMaghrib() + prayer.getMaghrib());
                        prayer.setIsha(prayerDb.getIsha() + prayer.getIsha());
                    }

                    MainActivity.appDatabase.prayerDao().update(prayer);

                    Toast.makeText(getActivity(), "Modified successfully", Toast.LENGTH_SHORT).show();
                }

                editTextFajr.setText("");
                editTextDhuhr.setText("");
                editTextAsr.setText("");
                editTextMaghrib.setText("");
                editTextIsha.setText("");
            }
        });

        /*buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(editTextName.getText().toString(), "k@k.co");

                MainActivity.userDatabase.userDao().addUser(user);

                Toast.makeText(getActivity(), "User added successfully", Toast.LENGTH_SHORT).show();

                editTextName.setText("");
            }
        });*/

        return view;
    }
}
