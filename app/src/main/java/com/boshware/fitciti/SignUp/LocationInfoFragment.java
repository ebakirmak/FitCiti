package com.boshware.fitciti.SignUp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.boshware.fitciti.JSONModel.LocationInfoModel;
import com.boshware.fitciti.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LocationInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LocationInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LocationInfoFragment extends Fragment {

    /**
     * interface object
     */
    SignUpFunctionsInterface signUpFunctionsInterface;

    /**
     * button object
     */
    private Button mBtnLocationNext;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public LocationInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LocationInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LocationInfoFragment newInstance(String param1, String param2) {
        LocationInfoFragment fragment = new LocationInfoFragment();
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
        return inflater.inflate(R.layout.fragment_location_info, container, false);
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




        mBtnLocationNext = (Button) getActivity().findViewById(R.id.fliBtnNext);
        mBtnLocationNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LocationInfoModel locationInfo = new LocationInfoModel();
                Spinner Country = (Spinner) getActivity().findViewById(R.id.fliCountry);
                Spinner Province = (Spinner) getActivity().findViewById(R.id.fliProvince);
                // MaterialEditText Town = (MaterialEditText) getActivity().findViewById(R.id.fliTown);

                if (Country.getSelectedItemId() < Integer.MIN_VALUE || Country.getSelectedItemId() > Integer.MAX_VALUE) {
                    Log.e("WorkoutSchedules",Country.getSelectedItemId() + "cok buyuk");
                }
                else
                    locationInfo.setCountry((int)Country.getSelectedItemId());

                if (Country.getSelectedItemId() < Integer.MIN_VALUE || Country.getSelectedItemId() > Integer.MAX_VALUE) {
                    Log.e("WorkoutSchedules",Country.getSelectedItemId() + "cok buyuk");
                }
                else
                    locationInfo.setProvince((int)Province.getSelectedItemId());
                //locationInfo.setTown(Town.getText().toString());

                signUpFunctionsInterface = (SignUpFunctionsInterface) getActivity();
                signUpFunctionsInterface.SignUpSportsman(null,null,locationInfo);

                //signUpFunctionsInterface.ChangeActivity(new Intent(getContext(),MainActivity.class));
            }
        });


    }

}
