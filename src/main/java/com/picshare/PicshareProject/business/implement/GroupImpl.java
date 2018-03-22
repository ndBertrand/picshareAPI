package com.picshare.PicshareProject.business.implement;

import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import com.picshare.PicshareProject.dao.entities.User;
import com.picshare.PicshareProject.dao.repository.GroupRepository;
import com.picshare.PicshareProject.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picshare.PicshareProject.dao.entities.Group;
import com.picshare.PicshareProject.business.contract.GroupInterface;


@Service
@Transactional
public class GroupImpl implements GroupInterface {

	@Autowired
	GroupRepository groupRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void createGroup(Group group) {
		groupRepository.save(group);
	}

	@Override
	public void deleteGroup(Long id) {
		// TODO Auto-generated method stub
		groupRepository.delete(id);
	}

	@Override
	public Group updateGroup(Long id, Group group) {
		// TODO Auto-generated method stub
		group.setId(id);
		groupRepository.save(group);
		return null;
	}

	@Override
	public Group findOneGroup(Long id) {
		// TODO Auto-generated method stub
		return groupRepository.findOne(id);
	}

	@Override
	public Collection<Group> findAllGroup() {
		// TODO Auto-generated method stub
		return groupRepository.findAll();
	}

	@Override
	public Collection<User> getAllMembers(Group group) {
		return group.getMembers();
	}
}
