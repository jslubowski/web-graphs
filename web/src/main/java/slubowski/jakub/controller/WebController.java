package slubowski.jakub.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import slubowski.jakub.model.SensorData;
import slubowski.jakub.repository.DataRepository;
import slubowski.jakub.service.SensorDataService;
import slubowski.jakub.util.GraphsViews;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Slf4j
@Controller
public class WebController {


    @Autowired
    private SensorDataService sensorDataService;

    private List<SensorData> data;

    private List<SensorData> dataAverage;

    // private final SensorDataList data = new SensorDataList(dataRepository);
    // TO-DO sprobowac zaimplementowac liste w dataRespoitory

    @GetMapping("/all")
    public @ResponseBody Iterable<SensorData> getAll(){
        return sensorDataService.getAll();
    }




    @GetMapping
    public String graqphsTemp(Model model){
        data = new ArrayList<>(sensorDataService.getAll());
        String s = "Obecna temperatura: " + data.get((data.size()-1)).getTemperature().toString() + " stopni Celsjusza";
        model.addAttribute("currentTemperature", s);
        s = "Obecna wilgotność: " + data.get((data.size()-1)).getHumidity().toString() + "%";
        model.addAttribute("currentHumidity", s);
        s = "Obecne stężenie tlenku węgla: " + data.get((data.size()-1)).getHumidity().toString() + "%";
        model.addAttribute("currentCo2", s);
        s = "Obecne ciśnienie: " + data.get((data.size()-1)).getPressure().toString() + " hPa";
        model.addAttribute("currentPressure", s);

        model.addAttribute("data",data);
        return GraphsViews.HOME;
    }

    @PostMapping
    public String showAverage(@RequestParam String bYear, @RequestParam String bMonth, @RequestParam String bDay, @RequestParam String eYear, @RequestParam String eMonth, @RequestParam String eDay, Model model){
        dataAverage = new ArrayList<>(sensorDataService.getFromTo(Integer.parseInt(bYear), Integer.parseInt(bMonth),Integer.parseInt(bDay),Integer.parseInt(eYear),Integer.parseInt(eMonth),Integer.parseInt(eDay)));
        model.addAttribute("data2", dataAverage);
        StringBuffer s = new StringBuffer("The dataAverage size is: " + dataAverage.size());
        log.info(s.toString());
        model.addAttribute("averageTemp", sensorDataService.averageTemp(dataAverage));
        model.addAttribute("averageHumidity", sensorDataService.averageHumidity(dataAverage));
        model.addAttribute("averageCo2", sensorDataService.averageCo2(dataAverage));
        model.addAttribute("averagePressure", sensorDataService.averagePressure(dataAverage));
        return GraphsViews.AVERAGES;
    }


}
