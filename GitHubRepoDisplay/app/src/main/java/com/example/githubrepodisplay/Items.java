package com.example.githubrepodisplay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Items {
    @Expose
    @SerializedName("score")
    private int score;
    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("repos_url")
    private String reposUrl;
    @Expose
    @SerializedName("starred_url")
    private String starredUrl;
    @Expose
    @SerializedName("following_url")
    private String followingUrl;
    @Expose
    @SerializedName("followers_url")
    private String followersUrl;
    @Expose
    @SerializedName("html_url")
    private String htmlUrl;
    @Expose
    @SerializedName("url")
    private String url;
    @Expose
    @SerializedName("avatar_url")
    private String avatarUrl;
    @Expose
    @SerializedName("node_id")
    private String nodeId;
    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("login")
    private String login;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
