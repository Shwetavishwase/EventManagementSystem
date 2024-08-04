package com.event.management.system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerDto {

	private Integer organizerId;

	private String name;

	private Long contactInfo;
	
	
}

