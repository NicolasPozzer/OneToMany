package com.demo.OneToOne.controller;

import com.demo.OneToOne.model.Mascota;
import com.demo.OneToOne.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {

    @Autowired //Primero de todo Hacemos que el Controller llame -> Service
    private IMascotaService mascoServ;

    /*EndPoints*/
    @PostMapping    ("/mascotas/crear")
    public String savePersona (@RequestBody Mascota masco){
        mascoServ.saveMascota(masco);

        return "La mascota fue agregada correctamente";
    }

}
