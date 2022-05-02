package com.rav_tecnologia.desafio.services;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import com.rav_tecnologia.desafio.models.Group;
import com.rav_tecnologia.desafio.repositories.GroupRepository;



@Service
public class GroupService {
	
	//injentando depencia para criacao do bin
	final GroupRepository groupRepository;
	
	public GroupService(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}

	
	@Transactional
	public Group save(Group group) {
		// TODO Auto-generated method stub
		return groupRepository.save(group);
	}

	//Métodos criados 
	public List<Group> findAll() {
		// TODO Auto-generated method stub
		return groupRepository.findAll();
	}


	public Optional<Group> findById(Long id) {
		// TODO Auto-generated method stub
		return groupRepository.findById(id);
	}

	@Transactional
	public void delete(Group group) {
		// TODO Auto-generated method stub
		groupRepository.delete(group);
	}
}
