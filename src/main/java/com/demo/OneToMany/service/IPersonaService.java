package com.demo.OneToMany.service;

import com.demo.OneToMany.model.Persona;

import java.util.List;

public interface IPersonaService {

    /*==============================================================
    *           Declaramos todos los metodos CRUD Abstactos
    *           ya que es una interfaz y Siempre van
    *           metodos abstractos!
    ================================================================*/



    /*Metodo para traer a todas las personas */
    //Lectura
    public List <Persona> getPersonas();

    /*Metodo para el alta - recibe una persona y la guarda*/
    /*Alta*/
    public void savePersona(Persona perso);

    /*Baja*/
    public void deletePersona(Long id);

    /*Lectura de un solo objeto - osea busca un solo objeto*/
    public Persona findPersona(Long id);


    /*Modificacion - PUT*/  //Declaramos idOriginal para buscar a la persona
                            //* y otros parametros en el caso de cambiar la id
    public void editPersona(Long idOriginal, Long idNueva,
                            String nuevoNombre,
                            String nuevoApellido, int nuevaEdad);

    void editPersona(Persona per);
}
