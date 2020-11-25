package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Adapter extends BaseAdapter {

    Context context;
    ArrayList<DataModel> dataModel;

    public Adapter(Context context, ArrayList<DataModel> dataModel){
        this.context = context;
        this.dataModel = dataModel;
    }
    @Override
    public int getCount() {
        return dataModel.size();
    }

    @Override
    public Object getItem(int position) {
        return dataModel.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            if(position==0)
                convertView = LayoutInflater.from(context).inflate(R.layout.first_list_item,parent, false);
            else {
                convertView = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
                TextView assessment_id, assessment_name, assessment_date, assessment_duration, assessment_description;
                Button btn;
                assessment_id = (TextView) convertView.findViewById(R.id.assessment_id);
                assessment_name = (TextView) convertView.findViewById(R.id.assessment_name);
                assessment_date = (TextView) convertView.findViewById(R.id.assessment_date);
                assessment_duration = (TextView) convertView.findViewById(R.id.assessment_time);
                assessment_description = (TextView) convertView.findViewById(R.id.assessment_description);
                btn = (Button)convertView.findViewById(R.id.btn);
                btn.setBackgroundColor(Color.WHITE);

                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
                Date date = new Date();

                assessment_id.setText(dataModel.get(position).getAssessment_id());
                assessment_name.setText(dataModel.get(position).getAssessment_name());
                try {
                    if(date.before(dateFormat.parse(dataModel.get(position).getAssessment_date()))) {
                        assessment_date.setText("Attempt before " + dataModel.get(position).getAssessment_date());
                        btn.setTextColor(Color.BLACK);
                        btn.setText("Start");
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context,StartSolutionPage.class);
                                intent.putExtra("ass_id",dataModel.get(position).getAssessment_id());
                                intent.putExtra("ass_name",dataModel.get(position).getAssessment_name());
                                intent.putExtra("status","test");
                                context.startActivity(intent);
                            }
                        });
                    }
                    else {
                        assessment_date.setText("Expired");
                        btn.setTextColor(Color.RED);
                        btn.setText("Solution");
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context,StartSolutionPage.class);
                                intent.putExtra("ass_id",dataModel.get(position).getAssessment_id());
                                intent.putExtra("ass_name",dataModel.get(position).getAssessment_name());
                                intent.putExtra("status","solution");
                                context.startActivity(intent);
                            }
                        });
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                assessment_duration.setText(dataModel.get(position).getAssesment_duration()+" min");
                assessment_description.setText(dataModel.get(position).getAssessment_description());



            }
        return convertView;
    }
}
