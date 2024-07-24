package com.example.my_school2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class fragment_dashboard extends Fragment {

    public CardView cardWork, cardEducation, cardSettings, cardStartup, cardProfile, cardInformation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Initialize the CardViews
        cardWork = view.findViewById(R.id.cardWork);
        cardEducation = view.findViewById(R.id.cardEducation);
        cardSettings = view.findViewById(R.id.cardSettings);
        cardStartup = view.findViewById(R.id.cardStartup);
        cardProfile = view.findViewById(R.id.cardProfile);
        cardInformation = view.findViewById(R.id.cardInformation);

        // Set click listeners for each CardView
        cardWork.setOnClickListener(v -> Toast.makeText(getActivity(), "Assignments", Toast.LENGTH_SHORT).show());
        cardEducation.setOnClickListener(v -> Toast.makeText(getActivity(), "Exams", Toast.LENGTH_SHORT).show());
        cardSettings.setOnClickListener(v -> Toast.makeText(getActivity(), "Results", Toast.LENGTH_SHORT).show());
        cardStartup.setOnClickListener(v -> Toast.makeText(getActivity(), "Study Material", Toast.LENGTH_SHORT).show());
        cardProfile.setOnClickListener(v -> Toast.makeText(getActivity(), "Lecture Scheduling", Toast.LENGTH_SHORT).show());
        cardInformation.setOnClickListener(v -> Toast.makeText(getActivity(), "Attendance", Toast.LENGTH_SHORT).show());

        return view;
    }
}
