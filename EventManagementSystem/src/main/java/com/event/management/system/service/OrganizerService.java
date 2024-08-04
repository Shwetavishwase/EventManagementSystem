package com.event.management.system.service;

import com.event.management.system.dto.OrganizerDto;

public interface OrganizerService {

	public OrganizerDto createOrganizer(OrganizerDto organizerDto);
	
	public OrganizerDto getOrganizerById(Integer organizerId);
	
	public OrganizerDto updateOrganizer(OrganizerDto organizerDto,Integer organizerId);
	
	public void deleteOrganizer(Integer organizerId);
}
