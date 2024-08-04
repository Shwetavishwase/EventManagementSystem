package com.event.management.system.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.system.Repository.EventRepository;
import com.event.management.system.dto.EventDto;
import com.event.management.system.entity.Event;
import com.event.management.system.entity.Organizer;
import com.event.management.system.entity.Venue;
import com.event.management.system.exception.ResourceNotFoundException;
import com.event.management.system.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EventDto createEvent(EventDto eventDto) {

		Event event = this.dtoToEvent(eventDto);

		Event saveEvent = this.eventRepo.save(event);

		return this.eventToDto(saveEvent);
	}

	@Override
	public List<EventDto> getAllEvents() {

		List<Event> events = this.eventRepo.findAll();

		List<EventDto> eventDtos = events.stream().map(event -> this.eventToDto(event)).collect(Collectors.toList());

		return eventDtos;
	}

	@Override
	public EventDto getEventById(Integer eventId) {

		Event event = this.eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId));

		return this.eventToDto(event);
	}

	@Override
	public EventDto updateEvent(EventDto eventDto, Integer eventId) {

		Event event = this.eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId));

		event.setDescription(eventDto.getDescription());
		event.setEventDate(eventDto.getEventDate());
		event.setEventName(eventDto.getEventName());

		Event updateEvent = this.eventRepo.save(event);
		EventDto eventDto1 = this.eventToDto(updateEvent);

		return eventDto1;
	}

	@Override
	public void deleteEvent(Integer eventId) {
		Event event = this.eventRepo.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId));

		this.eventRepo.delete(event);

	}

	public EventDto getEventByVenue(Venue venue) {

		Event eventByVenue = this.eventRepo.getEventByVenue(venue);

		return this.eventToDto(eventByVenue);
	}

	public EventDto getEventByOrganizer(Organizer organizer) {

		Event eventByOrganizer = this.eventRepo.getEventByOrganizer(organizer);

		return this.eventToDto(eventByOrganizer);
	}

//	-------------------------------------------------------------------------------

	private Event dtoToEvent(EventDto eventDto) {
		Event event = this.modelMapper.map(eventDto, Event.class);

		return event;

	}

	private EventDto eventToDto(Event event) {
		EventDto eventDto = this.modelMapper.map(event, EventDto.class);

		return eventDto;

	}

}
