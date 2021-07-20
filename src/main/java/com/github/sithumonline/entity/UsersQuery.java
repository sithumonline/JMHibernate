package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UsersQuery {
    private int queryId;
    private String name;
    private String logic;

    public UsersQuery(String queryId, String name, String logic) {
        this.queryId = Integer.parseInt(queryId);
        this.name = name;
        this.logic = logic;
    }

    public UsersQuery(String name, String logic) {
        this.name = name;
        this.logic = logic;
    }

    public UsersQuery() {

    }

    @Id
    @Column(name = "query_id")
    public String getQueryId() {
        return Integer.toString(queryId);
    }

    public void setQueryId(String queryId) {
        this.queryId = Integer.parseInt(queryId);
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "logic")
    public String getLogic() {
        return logic;
    }

    public void setLogic(String logic) {
        this.logic = logic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersQuery that = (UsersQuery) o;
        return queryId == that.queryId && Objects.equals(name, that.name) && Objects.equals(logic, that.logic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryId, name, logic);
    }
}
