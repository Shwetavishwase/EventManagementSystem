package com.event.management.system.service;

import com.event.management.system.dto.VenueDto;

public interface VenueService {

	public VenueDto createVenue(VenueDto venueDto);
	
	public VenueDto getVenueById(Integer venueId);
	
	public VenueDto updateVenue(VenueDto venueDto,Integer venueId);
	
	public void deleteVenue(Integer venueId);
}
