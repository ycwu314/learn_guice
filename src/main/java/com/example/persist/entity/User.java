package com.example.persist.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ycwu on 2017/9/21.
 */
@Entity(name = "t_user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private Integer age;

}
