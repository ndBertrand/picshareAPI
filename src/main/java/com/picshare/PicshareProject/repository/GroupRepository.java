package com.picshare.PicshareProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picshare.PicshareProject.model.Group;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long>{

}
