package com.event.management.system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venueId;
	
	private String venuName;
	
	private String venueLocation;
	
	private Long capacity;
	
	@OneToOne
	private Event event;
	
}
