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

    private List<SensorData> dataAverage;


    // == init ==
    @PostConstruct
    public void init() {
        data = new ArrayList<>();
        for (SensorData s : dataRepository.getFromTable()) {
            data.add(s);
        }
    }

    // == methods ==
    public List<SensorData> getAll(){
        init();
        return data;
    }



    public List<SensorData> getFromTo(int bYear, int bMonth, int bDay, int eYear, int eMonth, int eDay){
        dataAverage = new ArrayList<>();
        for(SensorData s: dataRepository.getFromTable()){
            if(s.getYear() == bYear ){
                if(s.getMonth() == bMonth ){
                    if(s.getDay() >= bDay ) dataAverage.add(s);
                }
                if(bMonth > s.getMonth()) dataAverage.add(s);
            }
            if(s.getYear() > bYear ){
                if(s.getYear() == eYear){
                    if(s.getMonth() == eMonth ){
                        if(s.getDay() <= eDay ) dataAverage.add(s);
                    }
                    if(bMonth < s.getMonth()) dataAverage.add(s);
                }
            }
        }
        return dataAverage;
    }

    public Integer averageTemp(List<SensorData> data){
        Integer temperature = 0;
        for(SensorData s: data){
            temperature += s.getTemperature();
        }
        return (temperature/data.size());
    }

    public Integer averageHumidity(List<SensorData> data){
        Integer humidity = 0;
        for(SensorData s: data){
            humidity += s.getHumidity();
        }
        return (humidity/data.size());
    }

    public Integer averageCo2(List<SensorData> data){
        Integer co2 = 0;
        for(SensorData s: data){
            co2 += s.getCo2();
        }
        return (co2/data.size());
    }

    public Integer averagePressure(List<SensorData> data){
        Integer pressure = 0;
        for(SensorData s: data){
            pressure += s.getPressure();
        }
        return (pressure/data.size());
    }

}
