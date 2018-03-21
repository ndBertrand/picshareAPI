package com.picshare.PicshareProject.business.contract;

import java.util.Collection;

import com.picshare.PicshareProject.dao.entities.Photo;

public interface PhotoInterface {

	public Photo createPhoto(Photo photo);
	public void deletePhoto(Long id);
	public Photo updatePhoto(Long id);
	public Photo findOnePhoto(Long id);
	public Collection<Photo> findAllPhoto();
}
