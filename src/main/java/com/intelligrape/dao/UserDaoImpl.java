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

import javax.transaction.Transactional;
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

    public void saveEmployee(User user) {
        persist(user);
    }

    @Transactional
    public void saveEmployeeAndRole(User employee, Role role) {
        saveEmployee(employee);
        getUtilService().saveEntity(new UserRole(employee, role));
    }

    public List<User> findAllUser() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
}
