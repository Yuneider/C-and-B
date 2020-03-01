package Logica;
public abstract class Perfil {
    
    //ATRIBUTOS
    String nombre;
    String correo;
    String contrasena;
    //fecha nacimiento;
    
    //METODOS
    public void IniciarSesion(){
        //rebvisar q la base de datos (usuarios) no esté vacia, xq si lo está, la unica opcion sera registrarse
        //llamar el entorno grafico
        //contrastar this.nombre y this.contrasena en la base de datos
        
    }
    
    public abstract void Registrarse();
    public abstract void EliminarCuenta();
    public abstract void CambiarContrasena();
    public abstract void VerInfoPersonal();
    public abstract void RecuperarContrasena();
    
}
