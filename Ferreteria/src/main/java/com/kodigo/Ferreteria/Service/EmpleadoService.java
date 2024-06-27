package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.EmpleadoEntity;

import java.time.LocalDate;
import java.util.List;

public interface EmpleadoService {
    public List<EmpleadoEntity> listAllEmpleados();
    public EmpleadoEntity createEmpleado(EmpleadoEntity empleadoEntity);
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleadoEntity);
    public void deleteEmpleado(Integer id);

    List<EmpleadoEntity> findByApellido(String apellido);

    List<EmpleadoEntity> findByDui(String dui);

    List<EmpleadoEntity> findByFechaContratacion(LocalDate fechaContratacion);

    List<EmpleadoEntity> findByCargo(String cargo);
}
