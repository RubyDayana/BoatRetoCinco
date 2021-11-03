package com.boat.controller;

import com.boat.model.Boat;
import com.boat.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class BoatController {

    @Autowired
    private BoatService boatService;
    @GetMapping("/all")
    public List<Boat> getAll(){
        return boatService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable int id){
        return boatService.getBoat(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat) {
        return boatService.save(boat);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBoat(@PathVariable int id){
        return boatService.deleteBoat(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat updateBoat(@RequestBody Boat boat){
        return boatService.updateBoat(boat);
    }
}
