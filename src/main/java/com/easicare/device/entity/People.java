package com.easicare.device.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author df
 * @since 2019-08-07
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class People implements Serializable {

    private Integer id;

    private String pname;

    private Integer teamId;


   /* public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "People{" +
        "id=" + id +
        ", pname=" + pname +
        ", teamId=" + teamId +
        "}";
    }*/
}
