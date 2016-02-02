package com.intelligrape.dao;

import com.intelligrape.model.User;
import com.intelligrape.model.UserRole;
import com.intelligrape.service.UtilService;
import com.intelligrape.util.enums.Role;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDao")
@Component
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Autowired
    public ApplicationContext applicationContext;


    public UtilService getUtilService() {
        return (UtilService) applicationContext.getBean("utilService");
    }

    public User findById(int id) {
        return getByKey(id);
    }

    public User saveEmployee(User user) {
        return (User) save(user);
    }

    @Transactional
    public User saveEmployeeAndRole(User employee, String role) {
        User user = saveEmployee(employee);
        getSession().save(new UserRole(employee, role));
        return user;
    }

    public List<User> findAllUser() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
}
