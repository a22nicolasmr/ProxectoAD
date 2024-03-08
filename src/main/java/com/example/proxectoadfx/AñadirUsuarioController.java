package com.example.proxectoadfx;
import dao.UsuarioDAO;
import entities.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Date;

public class AñadirUsuarioController{
    @FXML
    private TextField nombreUsuarioTextField;
    @FXML
    private TextField nombreCompletoTextField;
    @FXML
    private TextField correoTextField;
    @FXML
    private TextField contraseñaTextField;
    @FXML
    private DatePicker datePicker;


    @FXML
    public void añadirUsuario(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String nombreUsuario = nombreUsuarioTextField.getText();
        String nombreCompleto = nombreCompletoTextField.getText();
        String correo = correoTextField.getText();
        String contraseña = contraseñaTextField.getText();
        LocalDate fecha = datePicker.getValue();
        Date fechaDate = java.sql.Date.valueOf(fecha);
        Usuario usuario = new Usuario(nombreUsuario, nombreCompleto, correo, contraseña, fechaDate);

        usuarioDAO.save(usuario);
    }
}
