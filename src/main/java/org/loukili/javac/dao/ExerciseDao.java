package org.loukili.javac.dao;

import org.loukili.javac.entity.Exercise;

import java.util.List;

public class ExerciseDao  implements Idao<Exercise>{
  @Override
  public Exercise find(long id) {
    return null;
  }

  @Override
  public List<Exercise> getAll() {
    return null;
  }

  @Override
  public Exercise add(Exercise entity) {
    return null;
  }

  @Override
  public void update(Exercise entity) {

  }

  @Override
  public boolean delete(long id) {
    return false;
  }
}
