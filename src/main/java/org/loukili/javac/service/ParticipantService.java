package org.loukili.javac.service;

import org.loukili.javac.dao.ActivityDao;
import org.loukili.javac.dao.Idao;
import org.loukili.javac.dao.ParticipantDao;
import org.loukili.javac.entity.Activity;
import org.loukili.javac.entity.Exercise;
import org.loukili.javac.entity.Participant;
import org.loukili.javac.repository.ExerciseRepository;
import org.loukili.javac.repository.IFilterRepository;
import org.loukili.javac.repository.ParticipantRepository;

import java.util.List;

public class ParticipantService implements ICRUDService<Participant>,IFilterService<Participant> {

  private Idao<Participant> participantDao = new ParticipantDao();

  private IFilterRepository<Participant> participantRepository = new ParticipantRepository();

  @Override
  public Participant find(long id) {
    return participantDao.find(id);
  }

  @Override
  public List<Participant> getAll() {
    return participantDao.getAll();
  }

  @Override
  public Participant add(Participant participant) {
    return participantDao.add(participant);
  }

  @Override
  public void update(Participant participant) {
    participantDao.add(participant);
  }

  @Override
  public boolean delete(long id) {
    return participantDao.delete(id);
  }

  @Override
  public Participant getAllAndCount() {
    return null;
  }

  @Override
  public long getCount() {
    return participantRepository.getCount();
  }
}
