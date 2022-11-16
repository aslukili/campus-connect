package org.loukili.javac.service;

import org.loukili.javac.dao.ActivityDao;
import org.loukili.javac.dao.ExerciseDao;
import org.loukili.javac.dao.Idao;
import org.loukili.javac.entity.Activity;
import org.loukili.javac.entity.Exercise;
import org.loukili.javac.repository.ActivityRepository;
import org.loukili.javac.repository.IFilterRepository;

import java.util.List;

public class ActivityService implements ICRUDService<Activity>,IFilterService<Activity> {

  private Idao<Activity> activityDao = new ActivityDao();
  private IFilterRepository<Activity> activityRepository = new ActivityRepository();

  @Override
  public Activity find(long id) {
    return activityDao.find(id);
  }

  @Override
  public List<Activity> getAll() {
    return activityDao.getAll();
  }

  @Override
  public Activity add(Activity activity) {
    return activityDao.add(activity);
  }

  @Override
  public void update(Activity activity) {
    activityDao.update(activity);
  }

  @Override
  public boolean delete(long id) {
    return activityDao.delete(id);
  }

  @Override
  public Activity getAllAndCount() {
    return activityRepository.getAllAndCount();
  }

  @Override
  public long getCount() {
    return activityRepository.getCount();
  }
}
