package com.event.management.system.dto;

import com.event.management.system.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDto {

	private Integer venueId;

	private String venueName;

	private String venueLocation;

	private Long capacity;

	private Event event;

}
