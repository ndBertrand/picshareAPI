package com.picshare.PicshareProject.metier;

import java.util.Collection;

import com.picshare.PicshareProject.dao.entities.Comment;

public interface CommentInterface {

	public Comment createComment(Comment comment);
	public void deleteComment(Long id);
	public Comment UpdateComment(Long id);
	public Comment findOneComment(Long id);
	public Collection<Comment> findAllComment();
}
