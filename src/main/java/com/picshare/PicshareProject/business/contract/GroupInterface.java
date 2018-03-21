package com.picshare.PicshareProject.business.contract;

import java.util.Collection;

import com.picshare.PicshareProject.dao.entities.Group;

public interface GroupInterface {
	
	public Group createGroup(Group group);
	public void deleteGroup(Long id);
	public Group updateGroup(Long id,Group group);
	public Group findOneGroup(Long id);
	public Collection<Group> findAllGroup();

}
