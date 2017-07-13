package com.aliona.curscrawler.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course")
public class Curs {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "symbol", nullable = false, length = 6)
    private String symbol;

    @Column(name = "currency_name", nullable = false, length = 20)
    private String name;

    @Column(name = "rate", nullable = false)
    private Double rate;

    @Column(name = "variation", nullable = false)
    private Double variation;

    @Column(name = "percent", nullable = false)
    private Double percent;

    @Column(name = "cource_date", nullable = false)
    @Type(type="date")
    //@Temporal(TemporalType.TIMESTAMP)
    private Date courseDate;

    public Curs() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setTitle(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getVariation() {
        return variation;
    }

    public void setVariation(Double variation) {
        this.variation = variation;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }
}