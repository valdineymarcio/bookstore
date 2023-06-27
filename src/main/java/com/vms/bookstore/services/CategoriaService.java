package com.vms.bookstore.services;

import com.vms.bookstore.models.Categoria;
import com.vms.bookstore.repositories.CategoriaRepository;
import com.vms.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoria;
    public Categoria findById(Integer id){
        Optional<Categoria>obj= categoria.findById(id);
        //função anonima ou lambda
        return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"+ id+",tipo"+ Categoria.class.getName()));
    }

    public List<Categoria>findAll(){
        return categoria.findAll();
    }
}
