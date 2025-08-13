package com.nav.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TouristData {
private Integer id;
private String name;
private String packageType;
private Double budget;
}
