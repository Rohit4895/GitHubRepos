package com.example.githubrepodisplay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersList {
        @Expose
        @SerializedName("items")
        private List<Items> items;
        @Expose
        @SerializedName("incomplete_results")
        private boolean incompleteResults;
        @Expose
        @SerializedName("total_count")
        private int totalCount;

        public List<Items> getItems() {
            return items;
        }

        public void setItems(List<Items> items) {
            this.items = items;
        }

        public boolean getIncompleteResults() {
            return incompleteResults;
        }

        public void setIncompleteResults(boolean incompleteResults) {
            this.incompleteResults = incompleteResults;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
    }