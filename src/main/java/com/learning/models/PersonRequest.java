package com.learning.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class PersonRequest {
    private String name;
    private int age;
}
