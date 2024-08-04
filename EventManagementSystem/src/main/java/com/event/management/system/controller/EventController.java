package com.event.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.management.system.dto.ApiResponse;
import com.event.management.system.dto.EventDto;
import com.event.management.system.entity.Event;
import com.event.management.system.service.EventService;

@RestController
@RequestMapping("/api")
public class EventController {

	@Autowired
	private EventService eventServiceImpl;
	
	@PostMapping("/event")
	public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto)
	{
		EventDto event = this.eventServiceImpl.createEvent(eventDto);
		
		return new ResponseEntity<EventDto>(event,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EventDto>> getAllEvents()
	{
		List<EventDto> allEvents = this.eventServiceImpl.getAllEvents();
		
		return new ResponseEntity<List<EventDto>>(allEvents,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{eventId}")
	public ResponseEntity<EventDto> getEventById(@PathVariable Integer eventId)
	{
		EventDto eventById = this.eventServiceImpl.getEventById(eventId);
		
		return new ResponseEntity<EventDto>(eventById,HttpStatus.OK);
	}
	
	@PutMapping("/{eventId}")
	public ResponseEntity<EventDto> updateEvent(@RequestBody EventDto eventDto,@PathVariable Integer eventId)
	{
		EventDto updateEvent = this.eventServiceImpl.updateEvent(eventDto, eventId);
		
		return new ResponseEntity<EventDto>(updateEvent,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{eventId}")
	public ResponseEntity<ApiResponse> deleteEvent(@PathVariable Integer eventId)
	{
		this.eventServiceImpl.deleteEvent(eventId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("event is deleted successfully !!", true), HttpStatus.OK);
	}
	
	
//	@GetMapping("/getByVenue/{venueId}")
//	public ResponseEntity<Event> getEventByVenue(@PathVariable Integer venueId)
//	{
//		
//	}
}
