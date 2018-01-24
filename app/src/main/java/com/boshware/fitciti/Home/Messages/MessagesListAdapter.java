package com.boshware.fitciti.Home.Messages;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boshware.fitciti.FitCiti.Model.Messages.MessagesList;
import com.boshware.fitciti.FitCiti.Model.Training.Training;
import com.boshware.fitciti.JSONModel.MessageListModel;
import com.boshware.fitciti.R;

import java.util.List;

/**
 * Created by Emre on 23.1.2018.
 */

public class MessagesListAdapter  extends BaseAdapter{


    private LayoutInflater mInflater;
    private List<MessageListModel> mMessageListModels;

    public MessagesListAdapter(Activity activity, List<MessageListModel> messagesLists){
        mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMessageListModels = messagesLists;

    }
    @Override
    public int getCount() {
        return mMessageListModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mMessageListModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mMessageListModels.get(position).getMessageID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = mInflater.inflate(R.layout.fragment_message_row,null);
        MessageListModel message = mMessageListModels.get(position);

        TextView txtViewMessage = (TextView) rowView.findViewById(R.id.fmrLastMessage);
        txtViewMessage.setText(message.getMessage());

        TextView txtViewName = (TextView)  rowView.findViewById(R.id.fmrSportsmanName);
        txtViewName.setText(message.getReceiveName());


        return rowView;
    }
}
