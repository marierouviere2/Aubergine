package com.example.aubergine;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aubergine.model.AOE;
import com.example.aubergine.model.OnClick;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final OnClick click;
    private Context context;

    private List<AOE> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public TextView txtId;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            //txtId = (TextView) v.findViewById(R.id.thirdLine)
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, AOE item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<AOE> myDataset, Context context, OnClick click) {
        values = myDataset;
        this.click = click;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final AOE selectedAOE = values.get(position);
        final String name = selectedAOE.getName();
        //final String id = selectedAOE.getId();
        /*final String expansion = selectedAOE.getExpansion();
        final String army_type = selectedAOE.getArmy_type();
        final String team_bonus = selectedAOE.getTeam_bonus();*/

        holder.txtHeader.setText(name);

        holder.txtFooter.setText("Civilization :" +name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onClick(selectedAOE);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}