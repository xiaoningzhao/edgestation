package com.agmachine.edgestation.controllers;

import com.agmachine.edgestation.models.EdgeStation;
import com.agmachine.edgestation.models.Machine;
import com.agmachine.edgestation.models.Sensor;
import com.agmachine.edgestation.models.User;
import com.agmachine.edgestation.services.EdgeStationService;
import com.agmachine.edgestation.services.MachineService;
import com.agmachine.edgestation.services.SensorService;
import com.agmachine.edgestation.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    private final UserService userService;
    private final EdgeStationService edgeStationService;
    private final MachineService machineService;
    private final SensorService sensorService;

    public IndexController(UserService userService, EdgeStationService edgeStationService, MachineService machineService, SensorService sensorService) {
        this.userService = userService;
        this.edgeStationService = edgeStationService;
        this.machineService = machineService;
        this.sensorService = sensorService;
    }

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try{
            if(session.getAttribute("login").equals("true")){
                Long countEdgeStation = edgeStationService.countAllEdgeStation();
                Long countRunningEdgeStation = edgeStationService.countRunningEdgeStation();
                Long countMachine = machineService.countAllMachine();
                Long countRunningMachine = machineService.countRunningMachine();
                Long countSensor = sensorService.countAllSensor();
                Long countRunningSensor = sensorService.countRunningSensor();
                session.setAttribute("countEdgeStation", countEdgeStation);
                session.setAttribute("countRunningEdgeStation", countRunningEdgeStation);
                session.setAttribute("countMachine", countMachine);
                session.setAttribute("countRunningMachine", countRunningMachine);
                session.setAttribute("countSensor", countSensor);
                session.setAttribute("countRunningSensor", countRunningSensor);

                List<EdgeStation> edgeStations = edgeStationService.findAllEdgeStation();
                model.addAttribute("edgeStations", edgeStations);
                List<Machine> machines = machineService.findAllMachine();
                model.addAttribute("machines", machines);
                List<Sensor> sensors = sensorService.findAllSensor();
                model.addAttribute("sensors", sensors);
                return "index";
            }else {
                model.addAttribute("error","Please Login.");
                return "login";
            }
        }catch (Exception e){
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("login","false");
        session.setAttribute("user", null);
        return "login";
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }

    @PostMapping("/")
    public ModelAndView login(ModelAndView modelAndView, User user, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            modelAndView.addObject("error",bindingResult.getFieldError().getDefaultMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if(userService.login(user)){
            HttpSession session = request.getSession();
            session.setAttribute("login","true");
            session.setAttribute("user", user);

            Long countEdgeStation = edgeStationService.countAllEdgeStation();
            Long countRunningEdgeStation = edgeStationService.countRunningEdgeStation();
            Long countMachine = machineService.countAllMachine();
            Long countRunningMachine = machineService.countRunningMachine();
            Long countSensor = sensorService.countAllSensor();
            Long countRunningSensor = sensorService.countRunningSensor();
            session.setAttribute("countEdgeStation", countEdgeStation);
            session.setAttribute("countRunningEdgeStation", countRunningEdgeStation);
            session.setAttribute("countMachine", countMachine);
            session.setAttribute("countRunningMachine", countRunningMachine);
            session.setAttribute("countSensor", countSensor);
            session.setAttribute("countRunningSensor", countRunningSensor);

            List<EdgeStation> edgeStations = edgeStationService.findAllEdgeStation();
            modelAndView.addObject("edgeStations", edgeStations);
            List<Machine> machines = machineService.findAllMachine();
            modelAndView.addObject("machines", machines);
            List<Sensor> sensors = sensorService.findAllSensor();
            modelAndView.addObject("sensors", sensors);

            modelAndView.setViewName("index");
        }else{
            modelAndView.addObject("error","User does not exist, or wrong password.");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
