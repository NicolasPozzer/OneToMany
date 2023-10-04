package com.demo.OneToMany.service;

import com.demo.OneToMany.model.Mascota;
import com.demo.OneToMany.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 /*Hacemos implementar todos los metodos
          * abstractos con Alt+Enter de IPersonaService*/
 @Service
public class MascotaService implements IMascotaService{

    /*Inyeccion de dependencia a mano!*/
    @Autowired
    private IMascotaRepository repoMasco;


        @Override
        public List<Mascota> getMascotas() {
        /*Obtener la lista de todas las personas y
        retornarlas al controller cuando haga la consulta*/
            List<Mascota> listaMascotas = repoMasco.findAll();

            return listaMascotas;
        }

        @Override
        public void saveMascota(Mascota masco) {
            //Alta de Mascota
            repoMasco.save(masco);
        }

        @Override
        public void deleteMascota(Long id_mascota) {
            repoMasco.deleteById(id_mascota);
        }

        @Override
        public Mascota findMascota(Long id_mascota) {
            /*Hay que crear el objeto ya que como tiene
             * return devuelve algo*/
            //Si no encuentra a la persona devuelve null
            Mascota masco = repoMasco.findById(id_mascota).orElse(null);
            return masco;
        }

        @Override
        public void editMascota(Long idOriginal, Long id_MascotaNueva, String nuevoNombre,
                                String nuevaEspecie, String nuevoRaza, String nuevoColor) {

            //Busco el objeto original primero
            /*Usamos this. ya que de esta clase
             * usamos el metodo findPersona de arriba*/
            Mascota masco = this.findMascota(idOriginal);

            masco.setId_mascota(id_MascotaNueva);
            masco.setNombre(nuevoNombre);
            masco.setEspecie(nuevaEspecie);
            masco.setRaza(nuevoRaza);
            masco.setColor(nuevoColor);

            /*guardar los cambios (para esto usamos la funcion
             * que ya tenemos arriba-> savePersona)*/
            this.saveMascota(masco);




        }
}
