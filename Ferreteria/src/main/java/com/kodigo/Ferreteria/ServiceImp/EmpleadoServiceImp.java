package com.kodigo.Ferreteria.ServiceImp;

import com.kodigo.Ferreteria.DAO.DetalleFacturaDao;
import com.kodigo.Ferreteria.DAO.EmpleadoDao;
import com.kodigo.Ferreteria.Service.EmpleadoService;
import com.kodigo.Ferreteria.entity.CategoriaEntity;
import com.kodigo.Ferreteria.entity.EmpleadoEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service

public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    private EmpleadoDao empleadoDao;
    @Override
    public List<EmpleadoEntity> listAllEmpleados() {
        return empleadoDao.findAll();
    }

    @Override
    public EmpleadoEntity createEmpleado(EmpleadoEntity empleadoEntity) {
        return empleadoDao.save(empleadoEntity);
    }

    @Override
    @Transactional
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleadoEntity) {
        Optional<EmpleadoEntity> optionalEmpleado = empleadoDao.findById(Math.toIntExact(empleadoEntity.getId()));
        if (optionalEmpleado.isPresent()) {
            EmpleadoEntity existingEmpleado = optionalEmpleado.get();
            // Actualizar todos los campos relevantes
            existingEmpleado.setNombre(empleadoEntity.getNombre());
            existingEmpleado.setApellido(empleadoEntity.getApellido());
            existingEmpleado.setDireccion(empleadoEntity.getDireccion());
            existingEmpleado.setTelefono(empleadoEntity.getTelefono());
            existingEmpleado.setCorreo(empleadoEntity.getCorreo());
            existingEmpleado.setFechaNacimiento(empleadoEntity.getFechaNacimiento());
            existingEmpleado.setGenero(empleadoEntity.getGenero());
            existingEmpleado.setDui(empleadoEntity.getDui());
            existingEmpleado.setNit(empleadoEntity.getNit());
            existingEmpleado.setNrc(empleadoEntity.getNrc());
            existingEmpleado.setTipoPersona(empleadoEntity.getTipoPersona());
            existingEmpleado.setEstado(empleadoEntity.getEstado());
            existingEmpleado.setSalario(empleadoEntity.getSalario());
            existingEmpleado.setFechaContratacion(empleadoEntity.getFechaContratacion());
            existingEmpleado.setCargo(empleadoEntity.getCargo());
            existingEmpleado.setJefe(empleadoEntity.getJefe());
            existingEmpleado.setPersona(empleadoEntity.getPersona());
            return empleadoDao.save(existingEmpleado);
        } else {
            throw new EntityNotFoundException("El empleado con id " + empleadoEntity.getId() + " no existe.");
        }
    }

    @Override
    public void deleteEmpleado(Integer id) { empleadoDao.deleteById(id);
    }

    @Override
    public List<EmpleadoEntity> findByApellido(String apellido) {
        return empleadoDao.findByApellido(apellido);
    }

    @Override
    public List<EmpleadoEntity> findByDui(String dui) {
        return empleadoDao.findByDui(dui);
    }

    @Override
    public List<EmpleadoEntity> findByFechaContratacion(LocalDate fechaContratacion) {
        return empleadoDao.findByFechaContratacion(fechaContratacion);
    }

    @Override
    public List<EmpleadoEntity> findByCargo(String cargo) {
        return empleadoDao.findByCargo(cargo);
    }
}
