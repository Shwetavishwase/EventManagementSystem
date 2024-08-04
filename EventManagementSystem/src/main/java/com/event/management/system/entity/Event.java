package com.event.management.system.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eventId;
	
	private String eventName;
	
	@Temporal(TemporalType.DATE)
	private Date eventDate;
	
	private String description;
	
	@OneToOne
	private Venue venue;
	
	@ManyToOne
	@JoinColumn(name = "event")
	private Organizer organizer;
}
