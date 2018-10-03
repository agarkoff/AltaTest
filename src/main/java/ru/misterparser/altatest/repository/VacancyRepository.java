package ru.misterparser.altatest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.misterparser.altatest.domain.Vacancy;

public interface VacancyRepository extends CrudRepository<Vacancy, Integer> {
}
