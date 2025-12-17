package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class LocationEntity{
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long Id;
  private String name;
  private Double latitude;
  private Double longitude;
  public Long getId(){
    return Id;
  }
  public void setId(Long Id){
    this.Id = Id;
  }
  
}