// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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