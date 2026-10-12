
package com.iset.web;

import com.iset.dao.OffreRepository;
import com.iset.entities.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Offres")
public class RestOffres {

    @Autowired
    OffreRepository offreRepository;

    @GetMapping
    public List<Offre> getAll() {
        return offreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Offre getById(@PathVariable Long id) {
        return offreRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Offre create(@RequestBody Offre offre) {
        return offreRepository.save(offre);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        offreRepository.deleteById(id);
    }
}
