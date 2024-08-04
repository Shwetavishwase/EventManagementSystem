package com.event.management.system.service;

import java.util.List;

import com.event.management.system.dto.EventDto;
import com.event.management.system.entity.Organizer;
import com.event.management.system.entity.Venue;

public interface EventService {

	public EventDto createEvent(EventDto eventDto);
	
	public List<EventDto> getAllEvents();
	
	public EventDto getEventById(Integer eventId);
	
	public EventDto updateEvent(EventDto eventDto,Integer eventId);
	
	public void deleteEvent(Integer eventId);
	
	public EventDto getEventByVenue(Venue venue);
	
	public EventDto getEventByOrganizer(Organizer organizer);
}
