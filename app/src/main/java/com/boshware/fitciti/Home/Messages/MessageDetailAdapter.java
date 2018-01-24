package com.boshware.fitciti.Home.Messages;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boshware.fitciti.JSONModel.MessageDetailModel;
import com.boshware.fitciti.JSONModel.MessageListModel;
import com.boshware.fitciti.Login.LoginActivity;
import com.boshware.fitciti.R;

import java.util.List;

/**
 * Created by Emre on 23.1.2018.
 */

public class MessageDetailAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<MessageDetailModel> mMessageDetailModels;


    public MessageDetailAdapter(Activity activity, List<MessageDetailModel> messageDetailModels){
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMessageDetailModels = messageDetailModels;

    }
    @Override
    public int getCount() {
        return mMessageDetailModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mMessageDetailModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mMessageDetailModels.get(position).getID();
    }


    private String userID="";
    private boolean isFirst=true;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = mInflater.inflate(R.layout.fragment_message_detail_row,null);
        MessageDetailModel message = mMessageDetailModels.get(position);
        if(isFirst){
            isFirst =false;
            userID = LoginActivity.GetCurrentUser().getUid();
        }

        if(userID.equals( message.getSendSportsmanID())){
            TextView txtViewSend = (TextView) rowView.findViewById(R.id.fmdrSendMessage);
            txtViewSend.setText(message.getMessage());

            TextView txtViewReceive = (TextView) rowView.findViewById(R.id.fmdrReceiveMessage);
            txtViewReceive.setVisibility(View.GONE);
        }
        else{
            TextView txtViewReceive = (TextView) rowView.findViewById(R.id.fmdrReceiveMessage);
            txtViewReceive.setText(message.getMessage());

            TextView txtViewSend = (TextView) rowView.findViewById(R.id.fmdrSendMessage);
            txtViewSend.setVisibility(View.GONE);
        }



        return rowView;
    }
}
