package com.example.project.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name="role")
public class Roles extends BaseEntity{
    private long id;
    private String name;
}
