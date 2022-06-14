package com.example.crashlytics.crashapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.crashlytics.crashapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

  private FragmentFirstBinding binding;

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {

    binding = FragmentFirstBinding.inflate(inflater, container, false);
    return binding.getRoot();

  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    binding.btnCrashMainThread.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new CrashyClass().throwRuntimeException(() -> {
          throw new RuntimeException("Clicked Main Thread Crash ");});
      }});

    binding.btnCrashBackgroundThread.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new CrashyClass().throwBackgroundException("Clicked BG throw", 1000L);
      }});
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

}