package com.tienda.service;

import com.tienda.entity.Pais;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisService {
    public List<Pais> listCountry();
//    public void savePais(Pais pais);
//    public Pais getPaisById(long id);
//    public void delete(long id);
}
