package com.brandonsousa.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * @created at 21/10/2020 - 19:05
 * @project App
 * @author brand
 */
@JsonIgnoreProperties({
        "id",
        "node_id",
        "gravatar_id",
        "url",
        "html_url",
        "followers_url",
        "following_url",
        "gists_url",
        "starred_url",
        "subscriptions_url",
        "organizations_url",
        "repos_url",
        "events_url",
        "received_events_url",
        "type",
        "site_admin"})
public class Owner {

    private String login;
    private String avatar_url;

    public Owner() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
