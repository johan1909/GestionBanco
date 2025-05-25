package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
    private String nombre;
    private List<Cliente> clientes;
    private List<Empleado> empleados;
    private List<Cuenta> cuentas;
    private List<Transaccion> transacciones;
    
    
    public Banco(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.transacciones = new ArrayList<>();
    }
    






    // Métodos de gestión de clientes
    public String registrarCliente(Cliente nuevoCliente) {
        if (nuevoCliente.getId() == null || nuevoCliente.getNombre() == null) {
            throw new IllegalArgumentException("Datos del Cliente no pueden ser nulos");
        }
    
        String mensaje = "";
        Cliente clienteEncontrado = buscarClientePorId(nuevoCliente.getId());
    
        if (clienteEncontrado != null) {
            mensaje = "Ya existe";
        } else {
            clientes.add(nuevoCliente);
            mensaje = " se agregó correctamente";
        }
    
        return mensaje;
    }




    public Cliente buscarClientePorId(String id) {
        return clientes.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);
    }




    public String eliminarCliente(String cedula){
        String mensaje="cliente inexistente";
        for (Cliente clienteAux : clientes){
            if(clienteAux.getId().equals(cedula)){
                clientes.remove(clienteAux);
                mensaje=" El registro se elimino correctamente";
                return mensaje;
            }
        }

        return mensaje;
    }

    

    //metodos de empleados
    public String registrarEmpleado(Empleado nuevoEmpleado) {
        if (nuevoEmpleado.getId() == null || nuevoEmpleado.getNombre() == null) {
            throw new IllegalArgumentException("Datos del Empleado no pueden ser nulos");
        }
    
        String mensaje = "";
        Empleado empleadoEncontrado = buscarEmpleadoPorId(nuevoEmpleado.getId());
    
        if (empleadoEncontrado != null) {
            mensaje = "Ya existe";
        } else {
            empleados.add(nuevoEmpleado);
            mensaje = " se agregó correctamente";
        }
    
        return mensaje;
    }



    public Empleado buscarEmpleadoPorId(String id) {
        return empleados.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
    


    public String eliminarEmpleado(String cedula){
        String mensaje="empleado inexistente";
        for (Empleado empleadoAux : empleados){
            if(empleadoAux.getId().equals(cedula)){
                empleados.remove(empleadoAux);
                mensaje=" El registro se elimino correctamente";
                return mensaje;
            }
        }

        return mensaje;
    }







    //metodos de cuentas



    public String registrarCuenta(Cuenta nuevaCuenta) {
        if (nuevaCuenta.getNumero() == null || nuevaCuenta.getCliente()== null) {
            throw new IllegalArgumentException("Datos de la cuenta no pueden ser nulos");
        }
    
        String mensaje = "";
        Cuenta cuentaEncontrada = buscarCuentaPorNumero(nuevaCuenta.getNumero());
    
        if (cuentaEncontrada != null) {
            mensaje = "Ya existe";
        } else {
            cuentas.add(nuevaCuenta);
            nuevaCuenta.getCliente().agregarCuenta(cuentaEncontrada);
            mensaje = " se agregó correctamente";
        }
    
        return mensaje;
    }
    

    public Cuenta buscarCuentaPorNumero(String numero) {
        return cuentas.stream()
            .filter(c -> c.getNumero().equals(numero))
            .findFirst()
            .orElse(null);
    }
    

    public String eliminarCuenta(String numero){
        String mensaje="cuenta inexistente";
        for (Cuenta cuentaAux : cuentas){
            if(cuentaAux.getNumero().equals(numero)){
                cuentas.remove(cuentaAux);
                mensaje=" El registro se elimino correctamente";
                return mensaje;
            }
        }

        return mensaje;
    }




    //metodos transacciones
    



    public String registrarTransaccion(Transaccion nuevaTransaccion) {
        if (nuevaTransaccion.getId() == null ) {
            throw new IllegalArgumentException("Datos de la transaccion no pueden ser nulos");
        }
    
        String mensaje = "";
        Transaccion transaccionEncontrada = buscarTransaccionPorId(nuevaTransaccion.getId());
    
        if (transaccionEncontrada != null) {
            mensaje = "Ya existe";
        } else {
            transacciones.add(nuevaTransaccion);
            mensaje = " se agregó correctamente";
        }
    
        return mensaje;
    }
    



    public  Transaccion buscarTransaccionPorId(String id) {
        return transacciones.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    // Métodos de búsqueda
    
    
    
    





    // Métodos de autenticación
    public Usuario autenticarUsuario(String email, String contraseña) 
            throws AutenticacionFallidaException {


        // Buscar en la lista de los clientes
        Optional<Usuario> usuario = clientes.stream()
            .filter(c -> c.getEmail().equals(email) && c.getContraseña().equals(contraseña))
            .map(c -> (Usuario)c)
            .findFirst();
        

        // En caso de no estar, buscar en empleados
        if (!usuario.isPresent()) {
            usuario = empleados.stream()
                .filter(e -> e.getEmail().equals(email) && e.getContraseña().equals(contraseña))
                .map(e -> (Usuario)e)
                .findFirst();
        }
        
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new AutenticacionFallidaException("Credenciales inválidas");
        }
    }
    
    // Métodos para generar reportes
    public Reporte generarReporteClientes() {
        StringBuilder contenido = new StringBuilder();
        contenido.append("Reporte de Clientes\n");
        contenido.append("Total clientes: ").append(clientes.size()).append("\n");
        contenido.append("Clientes registrados:\n");
        
        clientes.forEach(cliente -> {
            contenido.append("- ").append(cliente.getNombre())
                   .append(" (").append(cliente.getEmail()).append(")")
                   .append(", Cuentas: ").append(cliente.getCuentas().size())
                   .append("\n");
        });
        
        return new Reporte("CLIENTES", contenido.toString(), "SISTEMA");
    }
    
    // Getters
    public String getNombre() { 
        return nombre; 
    }


    public List<Cliente> getClientes() { 
        return clientes; 
    }


    public List<Empleado> getEmpleados() { 
        return empleados; 
    }


    public List<Cuenta> getCuentas() { 
        return cuentas; 
    }


    public List<Transaccion> getTransacciones() { 
        return transacciones; 
    }


}
