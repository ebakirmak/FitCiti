package com.boshware.fitciti.Home.Trainings;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boshware.fitciti.FitCiti.Model.Training.Training;
import com.boshware.fitciti.JSONModel.TrainingOfSportsman;
import com.boshware.fitciti.R;

import java.util.List;

/**
 * Created by Emre on 20.1.2018.
 */

public class TrainingSchedulesAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Training> mTrainingOfSportsmanList;

    public TrainingSchedulesAdapter(Activity activity, List<Training> trainingOfSportsmanList){
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mTrainingOfSportsmanList = trainingOfSportsmanList;

    }

    @Override
    public int getCount() {
        return mTrainingOfSportsmanList.size();
    }

    @Override
    public Object getItem(int position) {
     return mTrainingOfSportsmanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mTrainingOfSportsmanList.get(position).getTrainingID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View rowView;
        rowView = mInflater.inflate(R.layout.fragment_training_schedules_row, null);
        Training trainingOfSportsman = mTrainingOfSportsmanList.get(position);

        TextView txtViewName = (TextView) rowView.findViewById(R.id.fwsrtxtViewWorkoutName);
        txtViewName.setText(trainingOfSportsman.getTrainingName());


        return rowView;
    }
}
