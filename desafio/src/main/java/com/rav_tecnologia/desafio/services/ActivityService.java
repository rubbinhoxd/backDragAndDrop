package com.rav_tecnologia.desafio.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rav_tecnologia.desafio.models.Activity;
import com.rav_tecnologia.desafio.repositories.ActivityRepository;

@Service
public class ActivityService {

	// injentando depencia para criacao do bin
	final ActivityRepository activityRepository;

	public ActivityService(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	@Transactional
	public Activity save(Activity activity) {
		// TODO Auto-generated method stub
		return activityRepository.save(activity);
	}

	// Métodos criados
	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return activityRepository.findAll();
	}

	public Optional<Activity> findById(Long id) {
		// TODO Auto-generated method stub
		return activityRepository.findById(id);
	}

	@Transactional
	public void delete(Activity activity) {
		// TODO Auto-generated method stub
		activityRepository.delete(activity);
	}
}
