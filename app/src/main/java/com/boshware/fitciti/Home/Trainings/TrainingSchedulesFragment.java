package com.boshware.fitciti.Home.Trainings;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.boshware.fitciti.Home.MainActivityFunctionsInterface;
import com.boshware.fitciti.R;
import com.boshware.fitciti.RESTful.IApi;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TrainingSchedulesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TrainingSchedulesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrainingSchedulesFragment extends Fragment  {



    /**
     * Interface Object
     */
    private MainActivityFunctionsInterface activityMainInterface;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TrainingSchedulesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrainingSchedulesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrainingSchedulesFragment newInstance(String param1, String param2) {
        TrainingSchedulesFragment fragment = new TrainingSchedulesFragment();
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
        return inflater.inflate(R.layout.fragment_training_schedules, container, false);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ClickListView();
    }

    /** ListView ilgili antrenmana tıklandığında antrenman (training) id alınıyor */
    private void ClickListView(){
        ListView listView = (ListView) getActivity().findViewById(R.id.listTrainings);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (id < Integer.MIN_VALUE || id > Integer.MAX_VALUE) {
                  Log.e("WorkoutSchedules",id + "cok buyuk");
                }
                activityMainInterface = (MainActivityFunctionsInterface) getActivity();
                activityMainInterface.ChangeFragment( new WorkoutDetailsFragment());

                activityMainInterface.RESTfulGetWorkoutOfSportsman((int) id);

            }
        });
    }





}
