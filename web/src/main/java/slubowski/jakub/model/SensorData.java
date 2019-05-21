package slubowski.jakub.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Slf4j
@Component
@Data
@Entity
@Table(name = "SensorData")
public class SensorData {

    // == fields from SQL ==
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer year;

    @Column
    private Integer month;

    @Column
    private Integer day;

    @Column
    private Integer hour;

    @Column
    private Integer minute;

    @Column
    private Integer second;

    @Column
    private Integer temperature;

    @Column
    private Integer humidity;

    @Column
    private Integer co2;

    @Column
    private Integer pressure;


    // == constructor ==


    public SensorData(Integer id, Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second, Integer temperature, Integer humidity, Integer co2, Integer pressure) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.temperature = temperature;
        this.humidity = humidity;
        this.co2 = co2;
        this.pressure = pressure;
    }

    public SensorData(){};

}
