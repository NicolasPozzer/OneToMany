package com.demo.OneToOne.service;

import com.demo.OneToOne.model.Persona;
import com.demo.OneToOne.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service /*Hacemos implementar todos los metodos
          * abstractos con Alt+Enter de IPersonaService*/
public class PersonaService implements IPersonaService{

    /*Inyectamos la dependencia*/
    @Autowired
    private IPersonaRepository persoRepo;


    @Override
    public List<Persona> getPersonas() {
        /*Obtener la lista de todas las personas y
        retornarlas al controller cuando haga la consulta*/
        List<Persona> listaPersonas = persoRepo.findAll();

        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        //Alta de persona
        persoRepo.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        /*Hay que crear el objeto ya que como tiene
        * return devuelve algo*/
        //Si no encuentra a la persona devuelve null
        Persona perso = persoRepo.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long nuevaId,
                            String nuevoNombre,
                            String nuevoApellido,
                            int nuevaEdad) {

        //Busco el objeto original primero
                /*Usamos this. ya que de esta clase
                 * usamos el metodo findPersona de arriba*/
        Persona perso = this.findPersona(idOriginal);

        perso.setId(nuevaId);
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setEdad(nuevaEdad);

        /*guardar los cambios (para esto usamos la funcion
         * que ya tenemos arriba-> savePersona)*/
        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }
}
