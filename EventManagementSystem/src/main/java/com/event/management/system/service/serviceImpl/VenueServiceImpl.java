package com.event.management.system.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.system.Repository.VenueRepository;
import com.event.management.system.dto.VenueDto;
import com.event.management.system.entity.Venue;
import com.event.management.system.exception.ResourceNotFoundException;
import com.event.management.system.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	private VenueRepository venueRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public VenueDto createVenue(VenueDto venueDto) {

		Venue venue = this.dtoToVenue(venueDto);

		Venue saveVenue = this.venueRepo.save(venue);

		return this.venueToDto(saveVenue);
	}

	@Override
	public VenueDto getVenueById(Integer venueId) {

		Venue venue = this.venueRepo.findById(venueId)
				.orElseThrow(() -> new ResourceNotFoundException("Venue", "venueId", venueId));

		return this.venueToDto(venue);
	}

	@Override
	public VenueDto updateVenue(VenueDto venueDto, Integer venueId) {
		
		Venue venue = this.venueRepo.findById(venueId)
				.orElseThrow(() -> new ResourceNotFoundException("Venue", "venueId", venueId));

		venue.setCapacity(venueDto.getCapacity());
		venue.setVenueLocation(venueDto.getVenueLocation());
		venue.setVenuName(venueDto.getVenueName());
		
		Venue updateVenue=this.venueRepo.save(venue);
		VenueDto venueDto1=this.venueToDto(updateVenue);
		
		return venueDto1;
	}

	@Override
	public void deleteVenue(Integer venueId) {
		Venue venue = this.venueRepo.findById(venueId)
				.orElseThrow(() -> new ResourceNotFoundException("Venue", "venueId", venueId));

		this.venueRepo.delete(venue);
	}
//-----------------Venue to Dto -----------AND-----------------Dto To Venue-------------------------------------------------------
	private Venue dtoToVenue(VenueDto venueDto) {
		Venue venue = this.modelMapper.map(venueDto, Venue.class);

		return venue;
	}

	private VenueDto venueToDto(Venue venue) {
		VenueDto venueDto = this.modelMapper.map(venue, VenueDto.class);

		return venueDto;
	}

}
