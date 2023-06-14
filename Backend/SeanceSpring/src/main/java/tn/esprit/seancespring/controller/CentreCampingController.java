package tn.esprit.seancespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.seancespring.entities.CentreCamping;
import tn.esprit.seancespring.services.ICentreCampingService;

import java.util.List;

@RestController
@RequestMapping("/centres")
public class CentreCampingController {

    @Autowired
    ICentreCampingService iCentreCampingService;

    @GetMapping("")
    public List<CentreCamping> GetAllCenters()
    {
        return iCentreCampingService.GetAllCenters();
    }

    @GetMapping("/{id}")
    public CentreCamping getCenterById(@PathVariable("id") Long id)
    {
        return iCentreCampingService.getCenterById(id);
    }

    @PostMapping("/add")
    public CentreCamping saveCenter(@RequestBody CentreCamping centre)
    {
        return iCentreCampingService.saveCenter(centre);
    }

    @DeleteMapping("/{id}")
    private void deleteCenter(@PathVariable("id") Long id)
    {
        iCentreCampingService.deleteCenter(id);
    }

    @PutMapping("")
    private CentreCamping update(@RequestBody CentreCamping centre)
    {
        return iCentreCampingService.updateCenter(centre);
    }

}
