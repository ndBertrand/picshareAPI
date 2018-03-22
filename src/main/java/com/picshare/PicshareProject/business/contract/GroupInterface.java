package com.picshare.PicshareProject.business.contract;

import java.util.Collection;

import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.dao.entities.User;

public interface GroupInterface {
	
	public void createGroup(Group group);
	public void deleteGroup(Long id);
	public Group updateGroup(Long id,Group group);
	public Group findOneGroup(Long id);
	public Collection<Group> findAllGroup();
	public Collection<User> getAllMembers(Group group);

}
