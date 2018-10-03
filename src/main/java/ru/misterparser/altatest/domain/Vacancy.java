package ru.misterparser.altatest.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "vacancy")
@XmlRootElement(name = "vacancy")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
public class Vacancy {

    @Id
    @GeneratedValue
    @Column
    @XmlElement
    private int id;

    @Column
    @XmlElement
    private String name;

    @Column
    @XmlElement
    private int salary;

    @Column
    @XmlElement
    private String experience;

    @Column
    @XmlElement
    private String city;
}
