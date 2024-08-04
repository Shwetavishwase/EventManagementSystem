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
import com.event.management.system.dto.VenueDto;
import com.event.management.system.service.VenueService;

@RestController
@RequestMapping("/api/venue")
public class VenueController {

	@Autowired
	private VenueService venueServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<VenueDto> createVenue(@RequestBody VenueDto venueDto)
	{
		VenueDto venue = this.venueServiceImpl.createVenue(venueDto);
		
		return new ResponseEntity<VenueDto>(venue,HttpStatus.CREATED);
	}
	
	@GetMapping("/{venueId}")
	public ResponseEntity<VenueDto> getVenueById(@PathVariable Integer VenueId)
	{
		VenueDto venueDto = this.venueServiceImpl.getVenueById(VenueId);
		
		return new ResponseEntity<VenueDto>(venueDto,HttpStatus.OK);
	}
	
	@PutMapping("/{venueId}")
	public ResponseEntity<VenueDto> updateVenue(@RequestBody VenueDto venueDto,@PathVariable Integer venueId)
	{
		VenueDto updateVenue = this.venueServiceImpl.updateVenue(venueDto, venueId);
		
		return new ResponseEntity<VenueDto>(updateVenue,HttpStatus.OK);
	}
	
	@DeleteMapping("/{venueId}")
	public ResponseEntity<ApiResponse> deleteVenue(@PathVariable Integer venueId)
	{
		this.venueServiceImpl.deleteVenue(venueId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Venue deleted successfully", true),HttpStatus.OK);
	}
}
