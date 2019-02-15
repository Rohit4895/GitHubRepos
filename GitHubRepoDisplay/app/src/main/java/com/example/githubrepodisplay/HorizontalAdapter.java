package com.example.githubrepodisplay;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {
    Context context;
    List<String> chairTypesList;

    public HorizontalAdapter(Context context, List<String> chairTypesList) {
        this.context = context;
        this.chairTypesList = chairTypesList;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(context).inflate(R.layout.horizontal_recycler_view,viewGroup,false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder horizontalViewHolder, final int position) {
        horizontalViewHolder.button.setText(chairTypesList.get(position));
        horizontalViewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        ((CallDifferentUserLists)context).onClickJavaList();
                        break;
                    case 1:
                        ((CallDifferentUserLists)context).onClickCList();
                        break;
                    case 2:
                        ((CallDifferentUserLists)context).onClickCppList();
                        break;
                    case 3:
                        ((CallDifferentUserLists)context).onClickKotlinList();
                        break;
                    case 4:
                        ((CallDifferentUserLists)context).onClickAssemblyList();
                        break;
                    case 5:
                        ((CallDifferentUserLists)context).onClickPythonList();
                        break;
                    case 6:
                        ((CallDifferentUserLists)context).onClickJsList();
                        break;
                    case 7:
                        ((CallDifferentUserLists)context).onClickSwiftList();
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return chairTypesList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        Button button;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.horiButton);
        }
    }

    public interface CallDifferentUserLists{
        public void onClickJavaList();
        public void onClickJsList();
        public void onClickKotlinList();
        public void onClickSwiftList();
        public void onClickPythonList();
        public void onClickCList();
        public void onClickCppList();
        public void onClickAssemblyList();
    }
}
