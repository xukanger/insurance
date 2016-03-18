package cn.annpeter.insurance.services;

import java.util.ArrayList;
import java.util.List;

import cn.annpeter.insurance.daos.UserDao;
import cn.annpeter.insurance.entities.User;
import cn.annpeter.insurance.utils.ExceptionUtils;
import cn.org.rapid_framework.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService extends BaseService{

    @Resource
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public ArrayList<User> list() {
		return (ArrayList<User>) userDao.list();
	}
	
	public ArrayList<User> queryByPage(final String where, final Page<User> page){
		return (ArrayList<User>) userDao.queryByPage(where, page);
	}
	
	public long getCount(String where) {
		return userDao.getCount(where);
	}
	
	public User saveOrUpdate(User newUser) throws ExceptionUtils{
		//使用新的user查找老的user，避免不可改变的区域被新的用户修改
		
		//在这里，用户的用户名，密码，还有注册日期不能被修改
		User oldUser = getUserById(newUser.getId());
		
		if(newUser.getAddr() != null){
			oldUser.setAddr(newUser.getAddr());
		}
		if(newUser.getBirth() != null){
			oldUser.setBirth(newUser.getBirth());
		}
		if(newUser.getHeadImgUrl() != null){
			oldUser.setHeadImgUrl(newUser.getHeadImgUrl());
		}
		if(newUser.getIdNum() != null){
			oldUser.setIdNum(newUser.getIdNum());
		}
		if(newUser.getPhone() != null){
			oldUser.setPhone(newUser.getPhone());
		}
		if(newUser.getQQ() != null){
			oldUser.setQQ(newUser.getQQ());
		}
		if(newUser.getSex() != null){
			oldUser.setSex(newUser.getSex());
		}
		if(newUser.getWeChat() != null){
			oldUser.setWeChat(newUser.getWeChat());
		}
		userDao.saveOrUpdate(oldUser);
		return oldUser;
	}
	
	public User add(User user) throws ExceptionUtils{
		if(user == null){
			throw new ExceptionUtils("添加user出错，user不能为空！");
		}else{
			return userDao.add(user);
		}
	}
	
	public User getUserById(int id) throws ExceptionUtils{
		User user = userDao.getUserById(id);
		if(user == null){
			throw new ExceptionUtils("没有找到id = " + id +"的用户。" );
		}
		return user;
	}
}
