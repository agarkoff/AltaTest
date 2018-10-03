package ru.misterparser.altatest.domain;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="vacancies")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class VacancyList {

    @XmlElement(name="vacancy")
    @Getter
    private List<Vacancy> vacancies = new ArrayList<>();

    public static VacancyList of(List<Vacancy> vacancies) {
        VacancyList vacancyList = new VacancyList();
        vacancyList.vacancies = new ArrayList<>(vacancies);
        return vacancyList;
    }
}
