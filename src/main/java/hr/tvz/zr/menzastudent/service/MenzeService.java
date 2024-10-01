package hr.tvz.zr.menzastudent.service;

import hr.tvz.zr.menzastudent.model.Menza;

import java.util.List;
import java.util.Optional;

public interface MenzeService {
    List<Menza> getNaziviMenza();
    Optional<Menza> getMenzaByNaziv(String naziv);
    Optional<Double> getPosjecenostMenze(String naziv);
}
