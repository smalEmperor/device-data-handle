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
public class Team implements Serializable {

    private Integer id;

    private String tname;


    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Team{" +
        "id=" + id +
        ", tname=" + tname +
        "}";
    }*/
}
