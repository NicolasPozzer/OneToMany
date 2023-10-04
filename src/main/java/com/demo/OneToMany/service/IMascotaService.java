package com.demo.OneToMany.service;

import com.demo.OneToMany.model.Mascota;


import java.util.List;

public interface IMascotaService {

    /*==============================================================
    *           Declaramos todos los metodos CRUD Abstactos
    *           ya que es una interfaz y Siempre van
    *           metodos abstractos!
    ================================================================*/


        /*Metodo para traer a todas las personas */
        //Lectura
        public List<Mascota> getMascotas();

        /*Metodo para el alta - recibe una persona y la guarda*/
        /*Alta*/
        public void saveMascota(Mascota masco);

        /*Baja*/
        public void deleteMascota(Long id_mascota);

        /*Lectura de un solo objeto - osea busca un solo objeto*/
        public Mascota findMascota(Long id_mascota);


        /*Modificacion - PUT*/  //Declaramos idOriginal para buscar a la persona
        //* y otros parametros en el caso de cambiar la id
        public void editMascota(Long idOriginal, Long id_MascotaNueva,
                                String nuevoNombre ,String nuevaEspecie,
                                String nuevoRaza, String nuevoColor);

}


