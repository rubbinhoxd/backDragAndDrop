package com.rav_tecnologia.desafio.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rav_tecnologia.desafio.dtos.GroupDto;
import com.rav_tecnologia.desafio.models.Group;
import com.rav_tecnologia.desafio.services.GroupService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/group")
public class GroupController {

	final GroupService groupService; //objeto das requisicoes
	
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}
	
	@PostMapping //metodo POST
	public ResponseEntity<Object> saveGroup(@RequestBody @Valid GroupDto groupDto){
		Group group = new Group();
		BeanUtils.copyProperties(groupDto, group);//convertendo dto para model
		return ResponseEntity.status(HttpStatus.CREATED).body(groupService.save(group));
	}
	
	@GetMapping
	public ResponseEntity<List<Group>> getAllGroups(){
		return ResponseEntity.status(HttpStatus.OK).body(groupService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneGroup(@PathVariable(value = "id") Long id){
		Optional<Group> groupOptional = groupService.findById(id);
		if(!groupOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(groupOptional.get());
	}
	
	@DeleteMapping("{id}") //Delete
	public ResponseEntity<Object> deleteGroup(@PathVariable(value = "id") Long id){
		Optional<Group> groupOptional = groupService.findById(id);
		if(!groupOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group not found");
		}
		groupService.delete(groupOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Group deleted sucessfully");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> uptadeGroup(@PathVariable(value = "id") Long id, @RequestBody	@Valid GroupDto groupDto){
		Optional<Group> groupOptional = groupService.findById(id);
		if(!groupOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group not found");
		}
		 
		Group group = groupOptional.get();
		group.setNameOfGroup(groupDto.getNameOfGroup()); //aqui é capaz de ocorrer a mudança na api
		return ResponseEntity.status(HttpStatus.OK).body(groupService.save(group));
	}
	
}
