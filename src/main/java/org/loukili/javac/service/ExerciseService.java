package org.loukili.javac.service;

import org.loukili.javac.dao.ExerciseDao;
import org.loukili.javac.dao.Idao;
import org.loukili.javac.entity.Activity;
import org.loukili.javac.entity.Exercise;
import org.loukili.javac.repository.ActivityRepository;
import org.loukili.javac.repository.ExerciseRepository;
import org.loukili.javac.repository.IFilterRepository;

import java.util.List;

public class ExerciseService implements ICRUDService<Exercise>,IFilterService<Exercise> {
  private Idao<Exercise> exerciseDao = new ExerciseDao();

  private IFilterRepository<Exercise> exerciseRepository = new ExerciseRepository();


  @Override
  public Exercise find(long id) {
    return exerciseDao.find(id);
  }

  @Override
  public List<Exercise> getAll() {
    return exerciseDao.getAll();
  }

  @Override
  public Exercise add(Exercise exercise) {
    return exerciseDao.add(exercise);
  }

  @Override
  public void update(Exercise exercise) {
    exerciseDao.update(exercise);
  }

  @Override
  public boolean delete(long id) {
    return exerciseDao.delete(id);
  }

  @Override
  public Exercise getAllAndCount() {
    return null;
  }

  @Override
  public long getCount() {
    return exerciseRepository.getCount();
  }
}
