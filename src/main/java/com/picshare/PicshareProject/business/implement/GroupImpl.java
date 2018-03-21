package com.picshare.PicshareProject.business.implement;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.business.contract.GroupInterface;


@Service
@Transactional
public class GroupImpl implements GroupInterface {

	@Override
	public Group createGroup(Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGroup(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Group updateGroup(Long id, Group group) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group findOneGroup(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Group> findAllGroup() {
		// TODO Auto-generated method stub
		return null;
	}

}
