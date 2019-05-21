package slubowski.jakub.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import slubowski.jakub.model.SensorData;
import slubowski.jakub.repository.DataRepository;
import slubowski.jakub.service.SensorDataService;
import slubowski.jakub.util.GraphsViews;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
public class WebController {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private SensorDataService sensorDataService;

    // private final SensorDataList data = new SensorDataList(dataRepository);
    // TO-DO sprobowac zaimplementowac liste w dataRespoitory

    @GetMapping("/all")
    public @ResponseBody Iterable<SensorData> getAll(){
        return sensorDataService.getAll();
    }




    @GetMapping
    public String graqphsTemp(Model model){
        List<SensorData> data = new ArrayList<>(sensorDataService.getAll());
        String s = "Obecna temperatura: " + data.get((data.size()-1)).getTemperature().toString() + " stopni Celsjusza";
        model.addAttribute("currentTemperature", s);
        s = "Obecna wilgotność: " + data.get((data.size()-1)).getHumidity().toString() + "%";
        model.addAttribute("currentHumidity", s);
        s = "Obecne stężenie tlenku węgla: " + data.get((data.size()-1)).getHumidity().toString() + "%";
        model.addAttribute("currentCo2", s);
        s = "Obecne ciśnienie: " + data.get((data.size()-1)).getPressure().toString() + " hPa";
        model.addAttribute("currentPressure", s);


        return GraphsViews.HOME;
    }


}
