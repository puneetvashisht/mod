package com.mentorondemand.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mentorondemand.entities.Mentor;
import com.mentorondemand.entities.MentorSkills;
import com.mentorondemand.entities.User;

//	@Query("select s from MentorSkills s where s.title=?1")
//	public MentorSkills findSkill(String title);
//}

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRepo extends JpaRepository<Mentor, Integer> {

	Mentor findById(int id);
	Mentor deleteById(int id);
	Mentor findByUser(User user);
}
