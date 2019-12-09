package com.agmachine.edgestation.controllers;

import com.agmachine.edgestation.models.Machine;
import com.agmachine.edgestation.services.MachineService;
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
public class MachineController {
    private final MachineService machineService;
    private final SensorService sensorService;

    public MachineController(MachineService machineService, SensorService sensorService) {
        this.machineService = machineService;
        this.sensorService = sensorService;
    }

    @RequestMapping("/machine")
    public String manageMachine(Model model) {
        List<Machine> machines = machineService.findAllMachine();
        model.addAttribute("machines", machines);

        return "machine";
    }

    @RequestMapping(value = "/machine_status", method = RequestMethod.GET)
    public String changeMachineStatus(Model model, HttpServletRequest request, @RequestParam String machineId, @RequestParam String status) {
        machineService.changeMachineStatus(machineId, status);
        List<Machine> machines = machineService.findAllMachine();
        model.addAttribute("machines", machines);

        HttpSession session = request.getSession();
        Long countMachine = machineService.countAllMachine();
        Long countRunningMachine = machineService.countRunningMachine();
        session.setAttribute("countMachine", countMachine);
        session.setAttribute("countRunningMachine", countRunningMachine);

        return "machine";
    }

    @RequestMapping("/machine_edit")
    public String editMachine(Model model, @RequestParam String machineId) {
        model.addAttribute("machine",machineService.findById(machineId));
        model.addAttribute("sensors",sensorService.findByMachineId(machineId));
        return "machine_edit";
    }

    @RequestMapping("/machine_init")
    public String createMachine(Model model) {
        model.addAttribute("machine", new Machine());
        return "machine_init";
    }

    @RequestMapping(value = "/machine_update", method = RequestMethod.POST)
    public String updateMachine(Model model, HttpServletRequest request, @ModelAttribute(value = "machine") Machine machine) {
        machineService.update(machine);

        List<Machine> machines = machineService.findAllMachine();
        model.addAttribute("machines", machines);

        HttpSession session = request.getSession();
        Long countMachine = machineService.countAllMachine();
        Long countRunningMachine = machineService.countRunningMachine();
        session.setAttribute("countMachine", countMachine);
        session.setAttribute("countRunningMachine", countRunningMachine);

        return "machine";
    }
}
