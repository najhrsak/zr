package hr.tvz.zr.menzastudent.controller;

import hr.tvz.zr.menzastudent.database.Database;
import hr.tvz.zr.menzastudent.model.*;
import hr.tvz.zr.menzastudent.service.MenzeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("menze")
public class MenzeController {
    MenzeService menzeService;

    @GetMapping("nazivi")
    public List<Menza> nazivi(){
        return menzeService.getNaziviMenza();
    }

    @GetMapping("menza/{naziv}")
    public ResponseEntity<Menza> menzaByName(@PathVariable String naziv){
        return menzeService.getMenzaByNaziv(naziv).map(Menza -> ResponseEntity.status(HttpStatus.FOUND).body(Menza))
                .orElseGet(()->ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("menza/posjecenost/{naziv}")
    public ResponseEntity<Double> posjecenostMenze(@PathVariable String naziv){
        return menzeService.getPosjecenostMenze(naziv).map(num -> ResponseEntity.status(HttpStatus.FOUND).body(num))
                .orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
