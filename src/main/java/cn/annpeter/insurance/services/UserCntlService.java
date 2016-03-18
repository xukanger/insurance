package cn.annpeter.insurance.services;

import cn.annpeter.insurance.daos.UserCntlDao;
import cn.annpeter.insurance.entities.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 *
 * Created by annpeter on 3/11/16.
 */
@Service
public class UserCntlService {
    @Resource
	private UserCntlDao userCntlDao;

	public void setUserCntlDao(UserCntlDao userCntlDao) {

        this.userCntlDao = userCntlDao;
	}

	public User login(User user) {
        return userCntlDao.getCheckUserVaild(user);
	}
}
