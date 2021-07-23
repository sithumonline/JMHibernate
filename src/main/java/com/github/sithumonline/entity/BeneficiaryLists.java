package com.github.sithumonline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BeneficiaryLists {
    private int queryId;
    private String kind;
    private String name;
    private String logic;

    @Id
    @Column(name = "query_id")
    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    @Basic
    @Column(name = "kind")
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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
        BeneficiaryLists that = (BeneficiaryLists) o;
        return queryId == that.queryId && Objects.equals(kind, that.kind) && Objects.equals(name, that.name) && Objects.equals(logic, that.logic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryId, kind, name, logic);
    }
}
