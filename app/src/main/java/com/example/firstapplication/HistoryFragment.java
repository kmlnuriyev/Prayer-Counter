package com.example.firstapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.firstapplication.model.Prayer;
import com.example.firstapplication.utils.NumberUtils;

import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView textViewPrayerInfo;

    private TextView textViewFajrDb;
    private TextView textViewDhuhrDb;
    private TextView textViewAsrDb;
    private TextView textViewMaghribDb;
    private TextView textViewIshaDb;
//    private TextView textViewTotal;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        int dayCount;

        textViewFajrDb = view.findViewById(R.id.textViewFajrDb);
        textViewDhuhrDb = view.findViewById(R.id.textViewDhuhrDb);
        textViewAsrDb = view.findViewById(R.id.textViewAsrDb);
        textViewMaghribDb = view.findViewById(R.id.textViewMaghribDb);
        textViewIshaDb = view.findViewById(R.id.textViewIshaDb);
//        textViewTotal = view.findViewById(R.id.textViewTotal);

        for (Prayer prayer:MainActivity.appDatabase.prayerDao().findAll()) {

            textViewFajrDb.setText(String.valueOf(prayer.getFajr()));
            textViewDhuhrDb.setText(String.valueOf(prayer.getDhuhr()));
            textViewAsrDb.setText(String.valueOf(prayer.getAsr()));
            textViewMaghribDb.setText(String.valueOf(prayer.getMaghrib()));
            textViewIshaDb.setText(String.valueOf(prayer.getIsha()));

            /*dayCount = NumberUtils.findSmallestNumber(Arrays.asList(prayer.getFajr(),
                    prayer.getDhuhr(),
                    prayer.getAsr(),
                    prayer.getMaghrib(),
                    prayer.getIsha()));

            textViewTotal.setText(dayCount + " days completed");*/

        }

        return view;
    }
}
