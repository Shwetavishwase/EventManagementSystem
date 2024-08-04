package com.event.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.event.management.system.dto.OrganizerDto;
import com.event.management.system.service.OrganizerService;

@RestController
@RequestMapping("/api/organizer")
public class OrganizerController {

	@Autowired
	private OrganizerService organizerServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<OrganizerDto> createOrganizer(@RequestBody OrganizerDto organizerDto)
	{
		OrganizerDto organizer = this.organizerServiceImpl.createOrganizer(organizerDto);
		
		return new ResponseEntity<OrganizerDto>(organizer,HttpStatus.CREATED);
	}
	
	@GetMapping("/{organizerId}")
	public ResponseEntity<OrganizerDto> getOrganizerById(@PathVariable Integer organizerId)
	{
		OrganizerDto organizerDto = this.organizerServiceImpl.getOrganizerById(organizerId);
		
		return new ResponseEntity<OrganizerDto>(organizerDto,HttpStatus.OK);
	}
	
	@PutMapping("/{organizerId}")
	public ResponseEntity<OrganizerDto> updateOrganizer(@RequestBody OrganizerDto organizerDto,@PathVariable Integer organizerid)
	{
		OrganizerDto updateOrganizer = this.organizerServiceImpl.updateOrganizer(organizerDto, organizerid);
		
		return new ResponseEntity<OrganizerDto>(updateOrganizer,HttpStatus.OK);
	}
	
	@DeleteMapping("/{organizerId}")
	public ResponseEntity<ApiResponse> deleteOrganizer(@PathVariable Integer organizerId)
	{
		this.organizerServiceImpl.deleteOrganizer(organizerId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Organizer deleted successfully", true),HttpStatus.OK);
	}
}
