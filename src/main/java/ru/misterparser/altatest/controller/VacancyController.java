package ru.misterparser.altatest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.misterparser.altatest.domain.Vacancy;
import ru.misterparser.altatest.domain.VacancyList;
import ru.misterparser.altatest.repository.VacancyRepository;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class VacancyController {

    private final VacancyRepository vacancyRepository;

    public VacancyController(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @PutMapping(consumes = "application/xml")
    public void put(@RequestBody Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @GetMapping(value = "/vacancy", produces = MediaType.APPLICATION_XML_VALUE)
    public VacancyList get() {
        Iterable<Vacancy> vacancies = vacancyRepository.findAll();
        return VacancyList.of(StreamSupport.stream(vacancies.spliterator(), false).sorted(Comparator.comparing(Vacancy::getName)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/vacancy/{vacancyId}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Vacancy> get(@PathVariable int vacancyId) {
        Optional<Vacancy> optional = vacancyRepository.findById(vacancyId);
        return optional.map(vacancy -> new ResponseEntity<>(vacancy, HttpStatus.OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/vacancy/{vacancyId}")
    public void delete(@PathVariable  int vacancyId) {
        vacancyRepository.deleteById(vacancyId);
    }
}
