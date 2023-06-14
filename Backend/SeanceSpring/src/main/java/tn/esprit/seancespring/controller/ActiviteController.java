package tn.esprit.seancespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.seancespring.entities.Activite;
import tn.esprit.seancespring.services.IActiviteService;

import java.util.List;

@RestController
@RequestMapping("/activites")
public class ActiviteController {
    @Autowired
    IActiviteService iActiviteService;

    @GetMapping("")
    public List<Activite> GetAllActivites()
    {
        return iActiviteService.GetAllActivites();
    }

    @GetMapping("/{id}")
    public Activite getActById(@PathVariable("id") Long id)
    {
        return iActiviteService.getActById(id);
    }

    @PostMapping("/add")
    public Activite saveActivite(@RequestBody Activite act)
    {
        return iActiviteService.saveActivite(act);
    }

    @DeleteMapping("/{id}")
    private void deleteActivite(@PathVariable("id") Long id)
    {
        iActiviteService.deleteActivite(id);
    }

    @PutMapping("")
    private Activite updateActivite(@RequestBody Activite act)
    {
        return iActiviteService.updateActivite(act);
    }
}
