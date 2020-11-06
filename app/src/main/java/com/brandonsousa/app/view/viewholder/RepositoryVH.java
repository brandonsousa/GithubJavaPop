package com.brandonsousa.app.view.viewholder;

/*
 * @created at 22/10/2020 - 10:34
 * @project App
 * @author brand
 */

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brandonsousa.app.R;

public class RepositoryVH extends RecyclerView.ViewHolder {

    public TextView repo_name, repo_description, repo_forks, repo_star, owner_name, full_name;
    public ImageView owner_avatar;

    public RepositoryVH(@NonNull View itemView) {
        super(itemView);
        repo_name = itemView.findViewById(R.id.tv_repo_item_name);
        repo_description = itemView.findViewById(R.id.tv_repo_item_description);
        repo_forks = itemView.findViewById(R.id.tv_repo_item_forks);
        repo_star = itemView.findViewById(R.id.tv_repo_item_stars);
        owner_name = itemView.findViewById(R.id.tv_repo_item_owner_name);
        full_name = itemView.findViewById(R.id.tv_repo_item_full_name);
        owner_avatar = itemView.findViewById(R.id.iv_repo_item_owner_avatar);
    }
}
