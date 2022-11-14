package org.loukili.javac.dao;

import jakarta.persistence.Id;
import org.loukili.javac.entity.Activity;

import java.util.List;

public class ActivityDao implements Idao<Activity> {

  @Override
  public Activity find(long id) {
    return null;
  }

  @Override
  public List<Activity> getAll() {
    return null;
  }

  @Override
  public Activity add(Activity entity) {
    return null;
  }

  @Override
  public void update(Activity entity) {

  }

  @Override
  public boolean delete(long id) {
    return false;
  }
}
