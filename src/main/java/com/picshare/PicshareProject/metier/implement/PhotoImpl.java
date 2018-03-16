package com.picshare.PicshareProject.metier.implement;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.picshare.PicshareProject.dao.entities.Photo;
import com.picshare.PicshareProject.metier.PhotoInterface;

@Service
@Transactional
public class PhotoImpl implements PhotoInterface {

	@Override
	public Photo createPhoto(Photo photo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePhoto(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Photo updatePhoto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Photo findOnePhoto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Photo> findAllPhoto() {
		// TODO Auto-generated method stub
		return null;
	}

}
