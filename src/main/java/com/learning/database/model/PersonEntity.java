package com.learning.database.model;

import lombok.Data;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.util.Assert;

import java.util.UUID;

@Data
@Table("People")
public class PersonEntity {

    @PrimaryKey
    private final String id;

    @Column
    private String name;

    @Column
    private int age;

    @PersistenceConstructor
    public PersonEntity(String id, String name, int age) {
        Assert.hasText(id,"Id must be set");
        Assert.hasText(name,"Name must be set");

        this.id = id;
        this.name = name;
        this.age = validateAge(age);
    }

    private int validateAge(int age) {
        Assert.isTrue((age > 0) && (age < 100), "age must be greater than 0");
        return age;
    }

    public static PersonEntity createPerson(String name, int age){
        return createPerson(UUID.randomUUID().toString(),name, age);
    }

    private static PersonEntity createPerson(String id, String name, int age) {
        return new PersonEntity(id, name, age);
    }


}
