package com.example.a1tutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class NavigationFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.navigation_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final NavController controller = Navigation.findNavController(view);
        view.findViewById(R.id.button).setOnClickListener(button ->
                controller.navigate(NavigationFragmentDirections.actionNavigationFragmentToMonitoringFragment()));

        view.findViewById(R.id.button2).setOnClickListener(button ->
                controller.navigate(
                        NavigationFragmentDirections
                            .actionNavigationFragmentToFeedbackFragment("Feedback Data")));
    }
}

