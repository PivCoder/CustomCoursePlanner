package com.example.customcourseplanner.jsonClasses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link implements Serializable {
    private Set<String> linkSet;
}
