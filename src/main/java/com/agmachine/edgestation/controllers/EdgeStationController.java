package com.agmachine.edgestation.controllers;

import com.agmachine.edgestation.models.EdgeStation;
import com.agmachine.edgestation.services.EdgeStationService;
import com.agmachine.edgestation.services.MachineService;
import com.agmachine.edgestation.services.SensorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EdgeStationController {
    private final EdgeStationService edgeStationService;
    private final MachineService machineService;
    private final SensorService sensorService;

    public EdgeStationController(EdgeStationService edgeStationService, MachineService machineService, SensorService sensorService) {
        this.edgeStationService = edgeStationService;
        this.machineService = machineService;
        this.sensorService = sensorService;
    }

    @RequestMapping("/edgestation")
    public String manageEdgeStation(Model model) {
        List<EdgeStation> edgeStations = edgeStationService.findAllEdgeStation();
        model.addAttribute("edgeStations", edgeStations);
        return "edgestation";
    }

    @RequestMapping(value = "/edgestation_status", method = RequestMethod.GET)
    public String changeEdgeStationStatus(Model model, HttpServletRequest request, @RequestParam String edgeStationId, @RequestParam String status) {
        edgeStationService.changeEdgeStationStatus(edgeStationId, status);
        List<EdgeStation> edgeStations = edgeStationService.findAllEdgeStation();
        model.addAttribute("edgeStations", edgeStations);

        HttpSession session = request.getSession();
        Long countEdgeStation = edgeStationService.countAllEdgeStation();
        Long countRunningEdgeStation = edgeStationService.countRunningEdgeStation();
        session.setAttribute("countEdgeStation", countEdgeStation);
        session.setAttribute("countRunningEdgeStation", countRunningEdgeStation);

        return "edgestation";
    }

    @RequestMapping("/edgestation_edit")
    public String editEdgeStation(Model model, @RequestParam String edgeStationId) {
        model.addAttribute("edgeStation",edgeStationService.findById(edgeStationId));
        model.addAttribute("machines",machineService.findByEdgeStationId(edgeStationId));
        model.addAttribute("sensors",sensorService.findByEdgeStationId(edgeStationId));
        return "edgestation_edit";
    }

    @RequestMapping("/edgestation_init")
    public String createEdgeStation(Model model) {
        model.addAttribute("edgeStation", new EdgeStation());
        return "edgestation_init";
    }

    @RequestMapping(value = "/edgestation_update", method = RequestMethod.POST)
    public String updateEdgeStation(Model model, HttpServletRequest request, @ModelAttribute(value = "edgeStation") EdgeStation edgeStation) {

        edgeStationService.update(edgeStation);

        List<EdgeStation> edgeStations = edgeStationService.findAllEdgeStation();
        model.addAttribute("edgeStations", edgeStations);

        HttpSession session = request.getSession();
        Long countEdgeStation = edgeStationService.countAllEdgeStation();
        Long countRunningEdgeStation = edgeStationService.countRunningEdgeStation();
        session.setAttribute("countEdgeStation", countEdgeStation);
        session.setAttribute("countRunningEdgeStation", countRunningEdgeStation);

        return "edgestation";
    }
}
