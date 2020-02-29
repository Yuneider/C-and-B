package Logica;
public abstract class Perfil {
    
    //ATRIBUTOS
    String nombre;
    String correo;
    String contraseña;
    //fecha nacimiento;
    
    //METODOS
    public abstract void IniciarSesion();
    public abstract void Registrarse();
    public abstract void EliminarCuenta();
    public abstract void CambiarContrasena();
    public abstract void VerInfoPersonal();
    public abstract void RecuperarContrasena();
    
}
