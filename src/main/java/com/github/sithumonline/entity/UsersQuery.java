package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UsersQuery {
    private Long id;
    private int queryId;
    private String name;
    private String logic;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "query_id")
    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
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
