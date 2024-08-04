package com.event.management.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.management.system.entity.Event;
import com.event.management.system.entity.Organizer;
import com.event.management.system.entity.Venue;

public interface EventRepository extends JpaRepository<Event, Integer>{

	public Event getEventByVenue(Venue venue);
	
	public Event getEventByOrganizer(Organizer organizer);
}
