package com.boshware.fitciti.SignUp;


import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.boshware.fitciti.JSONModel.PersonInfoModel;
import com.boshware.fitciti.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Calendar;


//
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PersonInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PersonInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PersonInfoFragment extends Fragment implements DatePickerDialog.OnDateSetListener,DialogInterface.OnCancelListener {



    /**
     * interface object
     */
    SignUpFunctionsInterface signUpFunctionsInterface;

    /**
     * button object
     */
    private Button mPersonInfoNext;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PersonInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PersonInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PersonInfoFragment newInstance(String param1, String param2) {
        PersonInfoFragment fragment = new PersonInfoFragment();
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
        return inflater.inflate(R.layout.fragment_person_info, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        myContext=(FragmentActivity) context;
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
        try{

           ShowDatetimepickerDialog();
            ClickButtonNext();

        }catch (Exception ex){
            Log.e("PersonInfoFragment",ex.getMessage());
        }


    }

    /**
     *
     */
    boolean isValid = true;
    MaterialEditText Weight;
    MaterialEditText Height;
    Spinner Goal;
    Spinner Activity;
    MaterialEditText Birthdate;
    private boolean ClickButtonNext(){

        mPersonInfoNext =(Button) getActivity().findViewById(R.id.fpi_btnNext);
        mPersonInfoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isValid = true;
                PersonInfoModel personInfo = new PersonInfoModel();
                Weight = (MaterialEditText) getActivity().findViewById(R.id.fpiWeight);
                Height = (MaterialEditText) getActivity().findViewById(R.id.fpiHeight);
                Goal = (Spinner) getActivity().findViewById(R.id.fpiSpnGoal);
                Activity = (Spinner) getActivity().findViewById(R.id.fpiSpnActivityFrequences);
                Birthdate = (MaterialEditText) getActivity().findViewById(R.id.fpiBirthdate);



                if(Birthdate !=null && Birthdate.getText().length()>0 && Birthdate.getText().length()<11)
                    personInfo.setBirthdate(Birthdate.getText().toString());
                else
                {
                    isValid = false;
                    Birthdate.setError("Lütfen doğum tarihini seçiniz.");
                }


                if(Activity.getSelectedItem().toString()!=null)
                    personInfo.setDailyActivity(Activity.getSelectedItem().toString());
                else
                    isValid = false;


                if(Goal.getSelectedItem().toString()!=null)
                    personInfo.setGoal(Goal.getSelectedItem().toString());
                else
                    isValid = false;

                if(Height != null && Height.getText().length()>0){
                    int mHeight= Integer.parseInt(Height.getText().toString());
                    if(mHeight>0 && mHeight<256)
                        personInfo.setHeight(mHeight);
                    else{
                        isValid = false;
                        Height.setError("Lütfen boy değerini kontrol ediniz.");
                    }
                }
                else{
                    isValid = false;
                    Height.setError("Lütfen bir değer giriniz.");
                }


                if(Weight != null && Weight.getText().length()>0){
                    int mWeight = Integer.parseInt(Weight.getText().toString());
                    if(mWeight>0 && mWeight<256)
                        personInfo.setWeight(mWeight);
                    else{
                        isValid = false;
                        Weight.setError("Lütfen Kilo değerini kontrol ediniz.");
                    }

                }
                else{
                    Weight.setError("Lütfen bir değer giriniz");
                    isValid = false;
                }





                if(isValid == true){
                    signUpFunctionsInterface = (SignUpFunctionsInterface) getActivity();
                    signUpFunctionsInterface.SignUpSportsman(null,personInfo,null);
                    signUpFunctionsInterface.ChangeFragment(new LocationInfoFragment());
                }
            }
        });
        return true;
    }
    /**
     * We will control all value
     */


    /**
     * Datetimepicker dialog is created
     */

    private void ShowDatetimepickerDialog(){
        Birthdate = (MaterialEditText) getActivity().findViewById(R.id.fpiBirthdate);
        Birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateDatetimepickerDialog();
            }
        });


    }

    private FragmentActivity myContext;

    private int year, month, day;

    private void CreateDatetimepickerDialog(){
        initDatetimeData();
        Calendar cDefault = Calendar.getInstance();
        cDefault.set(year,month,day);
        //Datetimepicker
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                this,
                1995,
                0,
                1);

        Calendar cMin = Calendar.getInstance();
        Calendar cMax = Calendar.getInstance();
        cMin.set(cMin.get(Calendar.YEAR)-99,0,1);
        cMax.set(cMax.get(Calendar.YEAR)-10,11,31);
        datePickerDialog.setMinDate(cMin);
        datePickerDialog.setMaxDate(cMax);

        datePickerDialog.setOnCancelListener(this);
        datePickerDialog.show(myContext.getFragmentManager(), "DatePickerDialog" );


    }

    private void initDatetimeData(){
        if(year == 0 ){
            Calendar c =Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        year = month = day = 0;
    }


    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
        Calendar tDefault = Calendar.getInstance();
        tDefault.set(year, month, day);
        year = i;
        month = i1;
        day = i2;

        String date = (month+1)+"/"+(day)+"/"+year;
        Log.e("Seçilen Tarih",(date));
        Birthdate.setText(date);
    }







}
