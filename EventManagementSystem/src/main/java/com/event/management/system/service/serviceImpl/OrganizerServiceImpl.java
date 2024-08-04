package com.event.management.system.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.system.Repository.OrganizerRepository;
import com.event.management.system.dto.OrganizerDto;
import com.event.management.system.entity.Organizer;
import com.event.management.system.exception.ResourceNotFoundException;
import com.event.management.system.service.OrganizerService;

@Service
public class OrganizerServiceImpl implements OrganizerService {

	@Autowired
	private OrganizerRepository organizerRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrganizerDto createOrganizer(OrganizerDto organizerDto) {

		Organizer organizer = this.dtoToOrganizer(organizerDto);

		Organizer saveOrganizer = this.organizerRepo.save(organizer);

		return this.organizerToDto(saveOrganizer);
	}

	@Override
	public OrganizerDto getOrganizerById(Integer organizerId) {

		Organizer organizer = this.organizerRepo.findById(organizerId)
				.orElseThrow(() -> new ResourceNotFoundException("Organizer", "organizerId", organizerId));

		return this.organizerToDto(organizer);
	}

	@Override
	public OrganizerDto updateOrganizer(OrganizerDto organizerDto, Integer organizerId) {
		
		Organizer organizer = this.organizerRepo.findById(organizerId)
				.orElseThrow(() -> new ResourceNotFoundException("Organizer", "organizerId", organizerId));

		organizer.setContactInfo(organizerDto.getContactInfo());
		organizer.setName(organizerDto.getName());
		
		Organizer updateOrganizer=this.organizerRepo.save(organizer);
		OrganizerDto organizerDto1=this.organizerToDto(updateOrganizer);
		
		return organizerDto1;
	}

	@Override
	public void deleteOrganizer(Integer organizerId) {
		
		Organizer organizer = this.organizerRepo.findById(organizerId)
				.orElseThrow(() -> new ResourceNotFoundException("Organizer", "organizerId", organizerId));

		this.organizerRepo.delete(organizer);
	}

//	------------------------------------------------------------------------

	private Organizer dtoToOrganizer(OrganizerDto organizerDto) {
		Organizer organizer = this.modelMapper.map(organizerDto, Organizer.class);

		return organizer;

	}

	private OrganizerDto organizerToDto(Organizer organizer) {
		OrganizerDto organizerDto = this.modelMapper.map(organizer, OrganizerDto.class);

		return organizerDto;
	}

}
