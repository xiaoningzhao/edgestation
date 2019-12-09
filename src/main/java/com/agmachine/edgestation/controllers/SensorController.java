package com.agmachine.edgestation.controllers;

import com.agmachine.edgestation.models.Machine;
import com.agmachine.edgestation.models.Sensor;
import com.agmachine.edgestation.services.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SensorController {
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @RequestMapping("/sensor")
    public String manageSensor(Model model) {
        List<Sensor> sensors = sensorService.findAllSensor();
        model.addAttribute("sensors", sensors);

        return "sensor";
    }

    @RequestMapping(value = "/sensor_status", method = RequestMethod.GET)
    public String changeSensorStatus(Model model, HttpServletRequest request, @RequestParam String sensorId, @RequestParam String status) {
        sensorService.changeSensorStatus(sensorId, status);
        List<Sensor> sensors = sensorService.findAllSensor();
        model.addAttribute("sensors", sensors);

        HttpSession session = request.getSession();
        Long countSensor = sensorService.countAllSensor();
        Long countRunningSensor = sensorService.countRunningSensor();
        session.setAttribute("countSensor", countSensor);
        session.setAttribute("countRunningSensor", countRunningSensor);

        return "sensor";
    }

    @RequestMapping("/sensor_edit")
    public String editSensor(Model model, @RequestParam String sensorId) {
        model.addAttribute("sensor",sensorService.findById(sensorId));
        return "sensor_edit";
    }

    @RequestMapping("/sensor_init")
    public String createSensor(Model model) {
        model.addAttribute("sensor", new Sensor());
        return "sensor_init";
    }

    @RequestMapping(value = "/sensor_update", method = RequestMethod.POST)
    public String updateSensor(Model model, HttpServletRequest request, @ModelAttribute(value = "sensor") Sensor sensor) {
        sensorService.update(sensor);

        List<Sensor> sensors = sensorService.findAllSensor();
        model.addAttribute("sensors", sensors);

        HttpSession session = request.getSession();
        Long countSensor = sensorService.countAllSensor();
        Long countRunningSensor = sensorService.countRunningSensor();
        session.setAttribute("countSensor", countSensor);
        session.setAttribute("countRunningSensor", countRunningSensor);

        return "sensor";
    }
}
