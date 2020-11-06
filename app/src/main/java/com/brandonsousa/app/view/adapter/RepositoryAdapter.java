package com.brandonsousa.app.view.adapter;

/*
 * @created at 22/10/2020 - 10:49
 * @project App
 * @author brand
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brandonsousa.app.R;
import com.brandonsousa.app.model.Repository;
import com.brandonsousa.app.view.viewholder.RepositoryVH;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryVH> implements Filterable {

    private List<Repository> repos;
    private Context context;
    private List<Repository> repositories;

    public RepositoryAdapter(Context context, List<Repository> repos) {
        this.repos = repos;
        this.context = context;
        this.repositories = new ArrayList<>(repos);
    }

    @NonNull
    @Override
    public RepositoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_item, parent, false);
        return new RepositoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryVH holder, int position) {
        holder.repo_name.setText(repos.get(position).getName());
        holder.repo_description.setText(repos.get(position).getDescription());
        holder.repo_forks.setText(String.valueOf(repos.get(position).getForks()));
        holder.repo_star.setText(String.valueOf(repos.get(position).getStargazers_count()));
        holder.owner_name.setText(repos.get(position).getOwner().getLogin());
        holder.full_name.setText(repos.get(position).getFull_name());
        Glide.with(context).load(repos.get(position).getOwner().getAvatar_url()).apply(RequestOptions.circleCropTransform()).into(holder.owner_avatar);
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                List<Repository> filtered = new ArrayList<>();
                if (charSequence.toString().isEmpty()) {
                    filtered.addAll(repositories);
                } else {
                    for (Repository r : repositories) {
                        if (r.getName().contains(charSequence) || r.getOwner().getLogin().contains(charSequence)) {
                            filtered.add(r);
                        }
                    }
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filtered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                repos.clear();
                repos.addAll((Collection<? extends Repository>) results.values);
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
