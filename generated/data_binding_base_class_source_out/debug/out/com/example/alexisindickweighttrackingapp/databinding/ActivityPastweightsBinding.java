// Generated by view binder compiler. Do not edit!
package com.example.alexisindickweighttrackingapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.gridlayout.widget.GridLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.alexisindickweighttrackingapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPastweightsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonDeleteRow;

  @NonNull
  public final Button buttonDone;

  @NonNull
  public final Button buttonEditWeight;

  @NonNull
  public final GridLayout editButtonGrid;

  @NonNull
  public final TableLayout editTable;

  private ActivityPastweightsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonDeleteRow, @NonNull Button buttonDone, @NonNull Button buttonEditWeight,
      @NonNull GridLayout editButtonGrid, @NonNull TableLayout editTable) {
    this.rootView = rootView;
    this.buttonDeleteRow = buttonDeleteRow;
    this.buttonDone = buttonDone;
    this.buttonEditWeight = buttonEditWeight;
    this.editButtonGrid = editButtonGrid;
    this.editTable = editTable;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPastweightsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPastweightsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_pastweights, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPastweightsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonDeleteRow;
      Button buttonDeleteRow = ViewBindings.findChildViewById(rootView, id);
      if (buttonDeleteRow == null) {
        break missingId;
      }

      id = R.id.buttonDone;
      Button buttonDone = ViewBindings.findChildViewById(rootView, id);
      if (buttonDone == null) {
        break missingId;
      }

      id = R.id.buttonEditWeight;
      Button buttonEditWeight = ViewBindings.findChildViewById(rootView, id);
      if (buttonEditWeight == null) {
        break missingId;
      }

      id = R.id.edit_button_grid;
      GridLayout editButtonGrid = ViewBindings.findChildViewById(rootView, id);
      if (editButtonGrid == null) {
        break missingId;
      }

      id = R.id.editTable;
      TableLayout editTable = ViewBindings.findChildViewById(rootView, id);
      if (editTable == null) {
        break missingId;
      }

      return new ActivityPastweightsBinding((ConstraintLayout) rootView, buttonDeleteRow,
          buttonDone, buttonEditWeight, editButtonGrid, editTable);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
