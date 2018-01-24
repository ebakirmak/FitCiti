package com.boshware.fitciti.Home.Trainings;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boshware.fitciti.JSONModel.WorkoutOfSportsman;
import com.boshware.fitciti.R;

import java.util.List;

/**
 * Created by Emre on 20.1.2018.
 */

public class WorkoutDetailsAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<WorkoutOfSportsman> mWorkoutOfSportsman;

    public WorkoutDetailsAdapter(Activity activity, List<WorkoutOfSportsman> workoutOfSportsmen){
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mWorkoutOfSportsman = workoutOfSportsmen;

    }

    @Override
    public int getCount() {
        return mWorkoutOfSportsman.size();
    }

    @Override
    public Object getItem(int position) {
        return mWorkoutOfSportsman.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mWorkoutOfSportsman.get(position).getTrainingID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = mInflater.inflate(R.layout.fragment_workout_details_row, null);
        WorkoutOfSportsman workoutOfSportsman = mWorkoutOfSportsman.get(position);

        TextView txtViewName = (TextView) rowView.findViewById(R.id.fwdrTxtViewName);
        txtViewName.setText(workoutOfSportsman.getName());

        TextView txtViewRepetition = (TextView) rowView.findViewById(R.id.fwdrTxtViewRepetition);
        txtViewRepetition.setText(workoutOfSportsman.getRegetition().toString());

        TextView txtViewSet = (TextView) rowView.findViewById(R.id.fwdrTxtViewSet);
        txtViewSet.setText(workoutOfSportsman.getSet().toString());


        return rowView;
    }
}
