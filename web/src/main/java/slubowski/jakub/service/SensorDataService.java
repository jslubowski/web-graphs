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

}
