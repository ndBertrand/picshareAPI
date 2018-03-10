package com.picshare.PicshareProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picshare.PicshareProject.model.Comment;


public interface CommentRepository extends JpaRepository<Comment,Long> {

}
