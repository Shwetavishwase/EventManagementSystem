package com.event.management.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.event.management.system.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Integer> {

}
