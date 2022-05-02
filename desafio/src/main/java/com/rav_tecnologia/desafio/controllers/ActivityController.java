package com.rav_tecnologia.desafio.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.rav_tecnologia.desafio.dtos.ActivityDto;

import com.rav_tecnologia.desafio.models.Activity;
import com.rav_tecnologia.desafio.models.Group;
import com.rav_tecnologia.desafio.services.ActivityService;
import com.rav_tecnologia.desafio.services.GroupService;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/activity")
public class ActivityController {

	final ActivityService activityService; //objeto das requisicoes
	final GroupService groupService;
	
	public ActivityController(ActivityService activityService, GroupService groupService) {
		this.activityService = activityService;
		this.groupService = groupService;
	}
	
	
	
	@PostMapping //metodo POST
	public ResponseEntity<Object> saveActivity(@RequestBody @Valid ActivityDto activityDto){
		Optional<Group> group = groupService.findById(activityDto.getIdGroup());
		if(!group.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group of Activity not found");//buscando o grupo dentro do banco via metodo do GroupDto
		}
		Activity activity = new Activity();
		activity.setNameOfActivity(activityDto.getNameOfActivity());
		activity.setGroup(group.get());
	
		if(activityDto.getDateOfActivity() != null) {
			activity.setDateOfActivity(activityDto.getDateOfActivity());
			activity.setCheckList(false); //vindo por padrao checklist vermelho
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(activityService.save(activity));
	}
	
	@GetMapping
	public ResponseEntity<List<Activity>> getAllActivities(){
		return ResponseEntity.status(HttpStatus.OK).body(activityService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneActivity(@PathVariable(value = "id") Long id){
		Optional<Activity> activityOptional = activityService.findById(id);
		if(!activityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(activityOptional.get());
	}
	
	@DeleteMapping("{id}") //Delete
	public ResponseEntity<Object> deleteActivity(@PathVariable(value = "id") Long id){
		Optional<Activity> activityOptional = activityService.findById(id);
		if(!activityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity not found");
		}
		activityService.delete(activityOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Activity deleted sucessfully");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> uptadeActivity(@PathVariable(value = "id") Long id, @RequestBody	@Valid ActivityDto activityDto){
		Optional<Activity> activityOptional = activityService.findById(id); //consulta no banco
		if(!activityOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Activity not found");
		}
		Activity activity = activityOptional.get();
		if(activityDto.getIdGroup() != null) {
			Optional<Group> groupOptional = groupService.findById(activityDto.getIdGroup()); //buscando no banco
			if(!groupOptional.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Group of Activity not found");
			}
			activity.setGroup(groupOptional.get());
		}
		if(activityDto.getNameOfActivity() != null) {
			activity.setNameOfActivity(activityDto.getNameOfActivity()); //aqui é capaz de ocorrer a mudança na api
		}
		if(activityDto.getDateOfActivity() != null) {
			activity.setDateOfActivity(activityDto.getDateOfActivity());
			activity.setCheckList(false);
		}
		if(activityDto.getChecklist() != null) {
			activity.setCheckList(activityDto.getChecklist());
		}
		 
		
		return ResponseEntity.status(HttpStatus.OK).body(activityService.save(activity));
	}
	
}




