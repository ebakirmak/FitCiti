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

import com.boshware.fitciti.JSONModel.AccountInfoModel;
import com.boshware.fitciti.R;
import com.google.firebase.auth.FirebaseUser;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AccountInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AccountInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountInfoFragment extends Fragment {

    /**
     * Button object
     */
    private Button mAccountInfoNext;



    /**
     * interface object
     */
    SignUpFunctionsInterface signUpFunctionsInterface;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AccountInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountInfoFragment newInstance(String param1, String param2) {
        AccountInfoFragment fragment = new AccountInfoFragment();
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
        return inflater.inflate(R.layout.fragment_account_info, container, false);
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

    MaterialEditText txtName;
    MaterialEditText txtSurname;
    MaterialEditText txtEmail;
    MaterialEditText txtNickname;
    FirebaseUser firebaseUser;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try{
            //EditText bilgilerini doldurma...
            FillViews();

            //Butona tıkladığında..
            ClickButtonNext();


        }catch (Exception ex){
            Log.e("AccountInfoFragment",ex.getMessage());
        }
    }



    private void FillViews(){
        txtName = (MaterialEditText) getActivity().findViewById(R.id.faiName);
        txtSurname = (MaterialEditText) getActivity().findViewById(R.id.faiSurname);
        txtEmail = (MaterialEditText) getActivity().findViewById(R.id.faiEmail);
        signUpFunctionsInterface = (SignUpFunctionsInterface) getActivity();
        ArrayList<String> infos = signUpFunctionsInterface.GetSportsmanAccountInfos();
        txtName.setText(infos.get(0));
        txtSurname.setText(infos.get(1));
        txtEmail.setText(infos.get(2));
    }

    private void ClickButtonNext(){
        mAccountInfoNext = (Button) getActivity().findViewById(R.id.fai_btnNext);
        mAccountInfoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpFunctionsInterface = (SignUpFunctionsInterface) getActivity();

                /** Bilgileri alma */
                txtName = (MaterialEditText) getActivity().findViewById(R.id.faiName);
                txtSurname = (MaterialEditText) getActivity().findViewById(R.id.faiSurname);
                txtEmail = (MaterialEditText) getActivity().findViewById(R.id.faiEmail);
                AccountInfoModel accountInfo = new AccountInfoModel();
                accountInfo.setName(txtName.getText().toString());
                accountInfo.setSurname(txtSurname.getText().toString());
                accountInfo.setEmail(txtEmail.getText().toString());
                //txtNickname = (MaterialEditText) getActivity().findViewById(R.id.faiNickname);
                signUpFunctionsInterface.SignUpSportsman(accountInfo,null,null);


                signUpFunctionsInterface.ChangeFragment(new PersonInfoFragment());
            }
        });
    }


}
