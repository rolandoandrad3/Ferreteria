package com.kodigo.Ferreteria.Controller;

import com.kodigo.Ferreteria.Service.CategoriaService;
import com.kodigo.Ferreteria.entity.CategoriaEntity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listCategorias") //http://localhost:8080/categoria/listCategorias
    public List<CategoriaEntity> listAllEmpleados(){
        return categoriaService.listCategoria();
    }


    @PostMapping("/addCategoria") //http://localhost:8080/categoria/addCategoria
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaEntity creatCategoria(@RequestBody CategoriaEntity categoria)
    {
        return categoriaService.creatCategoria(categoria);
    }

    @PutMapping("/updateCategoria/{id}") //http://localhost:8080/categoria/7
    public ResponseEntity<CategoriaEntity> updateCategoria(@PathVariable Long id, @RequestBody CategoriaEntity categoriaEntity) {
        categoriaEntity.setId(id);
        try {
            CategoriaEntity updatedCategoria = categoriaService.updateCategoria(categoriaEntity);
            return ResponseEntity.ok(updatedCategoria);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteCategoria/{id}")//http://localhost:8080/categoria/deleteCategoria/6
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoria(@PathVariable Integer id){categoriaService.deleteCategoria(id);}

}
