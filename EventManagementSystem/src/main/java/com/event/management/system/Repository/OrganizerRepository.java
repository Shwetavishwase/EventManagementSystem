package com.event.management.system.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.management.system.entity.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {

}
