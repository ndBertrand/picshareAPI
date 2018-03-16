package com.picshare.PicshareProject.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picshare.PicshareProject.dao.entities.Comment;


public interface CommentRepository extends JpaRepository<Comment,Long> {

}
