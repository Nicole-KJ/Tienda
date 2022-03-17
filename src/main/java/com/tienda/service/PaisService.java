package com.tienda.service;

import com.tienda.entity.Pais;
import com.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaisService implements IPaisService{
    @Autowired
    private PaisRepository paisRepository;
    
    @Override
    public List<Pais> listCountry() {
        return (List<Pais>)paisRepository.findAll();
    }

//    @Override
//    public void savePais(Pais pais) {
//        paisRepository.save(pais);
//    }
//
//    @Override
//    public Pais getPaisById(long id) {
//        return paisRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public void delete(long id) {
//        paisRepository.deleteById(id);
//    }

   
    
}

