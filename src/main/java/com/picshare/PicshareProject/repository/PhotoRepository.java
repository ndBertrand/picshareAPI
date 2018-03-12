package com.picshare.PicshareProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picshare.PicshareProject.model.Group;
import com.picshare.PicshareProject.model.Photo;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository  extends JpaRepository<Photo,Long> {
	
	

}
