package com.picshare.PicshareProject.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picshare.PicshareProject.dao.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
