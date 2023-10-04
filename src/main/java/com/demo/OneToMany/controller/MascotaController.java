package com.demo.OneToMany.controller;

import com.demo.OneToMany.model.Mascota;
import com.demo.OneToMany.service.IMascotaService;
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
