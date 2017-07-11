package com.aliona.curscrawler.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "course")
public class Curs {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "symbol", nullable = false, length = 3)
    private String symbol;

    @Column(name = "currency name", nullable = false, length = 20)
    private String name;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @Column(name = "variation", nullable = false)
    private Integer variation;

    @Column(name = "percent", nullable = false)
    private Integer percent;

    @Column(name = "cource_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date courseDate;

    public Curs(){
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
    public Integer getRate() {
        return rate;
    }
    public void setRate(Integer rate) {
        this.rate = rate;
    }
    public Integer getVariation() {
        return variation;
    }
    public void setVariation(Integer variation) {
        this.variation = variation;
    }
    public Integer getPercent() {
        return percent;
    }
    public void setPercent(Integer percent) {
        this.percent = percent;
    }
    public Date getCourseDateDate() {
        return courseDate;
    }

    public void setCourseDateDate(Date courseDate) {
        this.courseDate = courseDate;
    }
}
