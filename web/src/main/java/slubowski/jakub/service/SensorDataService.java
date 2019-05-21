package slubowski.jakub.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slubowski.jakub.model.SensorData;
import slubowski.jakub.repository.DataRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SensorDataService {

    @Autowired
    DataRepository dataRepository;

    private List<SensorData> data;


    // == init ==
    @PostConstruct
    public void init() {
        data = new ArrayList<>();
        for (SensorData s : dataRepository.findAll()) {
            data.add(s);
        }
    }

    // == methods ==
    public List<SensorData> getAll(){
        return data;
    }



    public List<SensorData> getFromTo(int bYear, int bMonth, int bDay, int eYear, int eMonth, int eDay){
        data = new ArrayList<>();
        for(SensorData s: dataRepository.findAll()){
            if((s.getYear() >= bYear) && (s.getMonth() >= bMonth) && (s.getDay() >= bDay)){
                log.info("First if completed");
                if((s.getYear() <= eYear) && (s.getMonth() <= eMonth) && (s.getDay() <= eDay)){
                    data.add(s);
                    log.info("The data is: " + s.toString());
                }
            }
        }
        return data;
    }

    public Integer averageTemp(List<SensorData> data){
        Integer temperature = 0;
        for(SensorData s: data){
            temperature += s.getTemperature();
        }
        log.info(temperature.toString());
        System.out.println(data.size());
        return (temperature/data.size());
    }

    public Integer averageHumidity(List<SensorData> data){
        Integer humidity = 0;
        for(SensorData s: data){
            humidity += s.getHumidity();
        }
        log.info(humidity.toString());
        System.out.println(data.size());
        return (humidity/data.size());
    }

    public Integer averageCo2(List<SensorData> data){
        Integer co2 = 0;
        for(SensorData s: data){
            co2 += s.getCo2();
        }
        log.info(co2.toString());
        System.out.println(data.size());
        return (co2/data.size());
    }

    public Integer averagePressure(List<SensorData> data){
        Integer pressure = 0;
        for(SensorData s: data){
            pressure += s.getPressure();
        }
        log.info(pressure.toString());
        System.out.println(data.size());
        return (pressure/data.size());
    }

}
