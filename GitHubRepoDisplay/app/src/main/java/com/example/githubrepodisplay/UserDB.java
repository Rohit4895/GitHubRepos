package com.example.githubrepodisplay;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "UserDB")
public class UserDB {
    @ColumnInfo(name = "score")
    private int score;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "repoUrl")
    private String reposUrl;

    @ColumnInfo(name = "starredUrl")
    private String starredUrl;

    @ColumnInfo(name = "followingUrl")
    private String followingUrl;

    @ColumnInfo(name = "followersUrl")
    private String followersUrl;

    @ColumnInfo(name = "htnlUrl")
    private String htmlUrl;

    @ColumnInfo(name = "url")
    private String url;

    @ColumnInfo(name = "avatarUrl")
    private String avatarUrl;

    @ColumnInfo(name = "nodeId")
    private String nodeId;

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "login")
    private String login;

    public UserDB() {
    }

    public UserDB(int score, String type, String reposUrl, String starredUrl,
                  String followingUrl, String followersUrl, String htmlUrl, String url,
                  String avatarUrl, String nodeId, int id, String login) {
        this.score = score;
        this.type = type;
        this.reposUrl = reposUrl;
        this.starredUrl = starredUrl;
        this.followingUrl = followingUrl;
        this.followersUrl = followersUrl;
        this.htmlUrl = htmlUrl;
        this.url = url;
        this.avatarUrl = avatarUrl;
        this.nodeId = nodeId;
        this.id = id;
        this.login = login;
    }

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
