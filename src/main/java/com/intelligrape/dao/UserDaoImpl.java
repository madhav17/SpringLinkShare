package com.intelligrape.dao;

import com.intelligrape.model.User;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
@Component
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao  {

    public User findById(int id) {
        return getByKey(id);
    }

    public void saveEmployee(User user) {
        persist(user);
    }

    public List<User> findAllUser() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
}
