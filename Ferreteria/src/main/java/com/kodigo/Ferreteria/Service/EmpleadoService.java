package com.kodigo.Ferreteria.Service;

import com.kodigo.Ferreteria.entity.EmpleadoEntity;

import java.util.List;

public interface EmpleadoService {
    public List<EmpleadoEntity> listAllEmpleados();
    public EmpleadoEntity createEmpleado(EmpleadoEntity empleadoEntity);
    public EmpleadoEntity updateEmpleado(EmpleadoEntity empleadoEntity);
    public void deleteEmpleado(Integer id);
}
