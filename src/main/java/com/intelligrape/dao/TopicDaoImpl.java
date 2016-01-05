package com.intelligrape.dao;


import com.intelligrape.model.Topic;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("topicDao")
@Component
public class TopicDaoImpl extends AbstractDao<Integer, Topic> implements TopicDao {

    public Topic findById(int id) {
        return getByKey(id);
    }

    public void saveTopic(Topic topic) {
        persist(topic);
    }

    public List<Topic> findAllTopic() {
        Criteria criteria = createEntityCriteria();
        return (List<Topic>) criteria.list();
    }


}
