package com.event.management.system.dto;

import java.util.Date;

import com.event.management.system.entity.Venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

	private String eventName;

	private Date eventDate;

	private String description;
	
//	private Venue venue;
	
}
