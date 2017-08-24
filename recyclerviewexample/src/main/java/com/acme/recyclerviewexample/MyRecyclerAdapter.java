package com.acme.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.acme.recyclerviewexample.databinding.StateListItemBinding;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<State> states;

    MyRecyclerAdapter(List<State> states) {
        this.states = states;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        StateListItemBinding stateListItemBinding =
                StateListItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(stateListItemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        State item = states.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private StateListItemBinding stateListItemBinding;

        ViewHolder(StateListItemBinding stateListItemBinding) {
            super(stateListItemBinding.getRoot());
            this.stateListItemBinding = stateListItemBinding;
        }

        void bind(State state) {
            stateListItemBinding.setState(state);
            stateListItemBinding.executePendingBindings();
        }
    }

}
