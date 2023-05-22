
package trabajadores;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class InterfazTrabajador extends JFrame implements ActionListener {
    private JTextField txtDni, txtNombre, txtTelefono, txtDiasTrabajados;
    private JComboBox<String> cmbPuesto, cmbTipoContrato;
    private JButton btnGuardar, btnCargar, btnCalcularSueldo, btnDespedir, btnCambiarNombre, btnCambiarTelefono, btnCambiarPuesto, btnCambiarTipoContrato, btnCambiarDiasTrabajados;

    public InterfazTrabajador() {
        super("Registro de Trabajador");

        
        
        
        
        
        Color colorFondo = new Color(1, 240, 240);
        Color colorBoton = new Color(60, 160, 220);
        
        
        Font fontTitulo = new Font("Arial", Font.BOLD, 18);
        Font fontEtiqueta = new Font("Arial", Font.PLAIN, 14);
        Font fontBoton = new Font("Arial", Font.BOLD, 12);
        ImageIcon imagenFondo = new ImageIcon("fondo.jpg");
        
        
        
        JLabel lblDni = new JLabel("DNI:");
        lblDni.setFont(fontEtiqueta);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(fontEtiqueta);
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(fontEtiqueta);
        JLabel lblPuesto = new JLabel("Puesto:");
        lblPuesto.setFont(fontEtiqueta);
        JLabel lblTipoContrato = new JLabel("Tipo de Contrato:");
        lblTipoContrato.setFont(fontEtiqueta);
        JLabel lblDiasTrabajados = new JLabel("Días Trabajados:");
        lblDiasTrabajados.setFont(fontEtiqueta);
        JLabel lblFondo = new JLabel(imagenFondo);
        lblFondo.setBounds(0, 0, imagenFondo.getIconWidth(), imagenFondo.getIconHeight());
        
        


        
        txtDni = new JTextField(20);
        txtNombre = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtDiasTrabajados = new JTextField(10);

        
        cmbPuesto = new JComboBox<>(new String[]{"Operario", "Supervisor", "Gerente", "Director de departamento", "Vicepresidente", "Director ejecutivo"});
        cmbTipoContrato = new JComboBox<>(new String[]{"Indefinido", "Definido"});

        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(fontBoton);
        btnGuardar.setBackground(colorBoton);
        btnGuardar.addActionListener(this);

        btnCargar = new JButton("Cargar");
        btnCargar.setFont(fontBoton);
        btnCargar.setBackground(colorBoton);
        btnCargar.addActionListener(this);

        btnCalcularSueldo = new JButton("Calcular Sueldo");
        btnCalcularSueldo.setFont(fontBoton);
        btnCalcularSueldo.setBackground(colorBoton);
        btnCalcularSueldo.addActionListener(this);

        btnDespedir = new JButton("Despedir");
        btnDespedir.setFont(fontBoton);
        btnDespedir.setBackground(colorBoton);
        btnDespedir.addActionListener(this);

        btnCambiarNombre = new JButton("Cambiar");
        btnCambiarNombre.setFont(fontBoton);
        btnCambiarNombre.setBackground(colorBoton);
        btnCambiarNombre.addActionListener(this);

        btnCambiarTelefono = new JButton("Cambiar");
        btnCambiarTelefono.setFont(fontBoton);
        btnCambiarTelefono.setBackground(colorBoton);
        btnCambiarTelefono.addActionListener(this);

        btnCambiarPuesto = new JButton("Cambiar");
        btnCambiarPuesto.setFont(fontBoton);
        btnCambiarPuesto.setBackground(colorBoton);
        btnCambiarPuesto.addActionListener(this);

        btnCambiarTipoContrato = new JButton("Cambiar");
        btnCambiarTipoContrato.setFont(fontBoton);
        btnCambiarTipoContrato.setBackground(colorBoton);
        btnCambiarTipoContrato.addActionListener(this);

        btnCambiarDiasTrabajados = new JButton("Cambiar");
        btnCambiarDiasTrabajados.setFont(fontBoton);
        btnCambiarDiasTrabajados.setBackground(colorBoton);
        btnCambiarDiasTrabajados.addActionListener(this);

        
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(colorFondo);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panelFormulario.add(lblDni, gbc);
        gbc.gridy++;
        panelFormulario.add(lblNombre, gbc);
        gbc.gridy++;
        panelFormulario.add(lblTelefono, gbc);
        gbc.gridy++;
        panelFormulario.add(lblPuesto, gbc);
        gbc.gridy++;
        panelFormulario.add(lblTipoContrato, gbc);
        gbc.gridy++;
        panelFormulario.add(lblDiasTrabajados, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelFormulario.add(txtDni, gbc);
        gbc.gridy++;
        panelFormulario.add(txtNombre, gbc);
        gbc.gridy++;
        panelFormulario.add(txtTelefono, gbc);
        gbc.gridy++;
        panelFormulario.add(cmbPuesto, gbc);
        gbc.gridy++;
        panelFormulario.add(cmbTipoContrato, gbc);
        gbc.gridy++;
        panelFormulario.add(txtDiasTrabajados, gbc);

        
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.setBackground(colorFondo);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCargar);
        panelBotones.add(btnCalcularSueldo);
        panelBotones.add(btnDespedir);

        GridBagConstraints abc = new GridBagConstraints();
        abc.gridx = 2;
        abc.gridy = 1;
        abc.anchor = GridBagConstraints.WEST;
        panelFormulario.add(btnCambiarNombre, abc);
        abc.gridy = 2;
        panelFormulario.add(btnCambiarTelefono, abc);
        abc.gridy = 3;
        panelFormulario.add(btnCambiarPuesto, abc);
        abc.gridy = 4;
        panelFormulario.add(btnCambiarTipoContrato, abc);
        abc.gridy = 5;
        panelFormulario.add(btnCambiarDiasTrabajados, abc);

        JPanel panelContenido = new JPanel(new BorderLayout());
        panelContenido.setBackground(colorFondo);
        panelContenido.add(panelFormulario, BorderLayout.CENTER);
        panelContenido.add(panelBotones, BorderLayout.SOUTH);
        
        
        
    

       
        
        
        
       
        
        
        
        
        add(panelContenido);
        
        
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource()==btnDespedir){
            DespedirTrabajador despedirTrabajador = new DespedirTrabajador();
            despedirTrabajador.setVisible(true);
            dispose();
        }else if (e.getSource() == btnGuardar) {
            dispose();
            String dni = txtDni.getText();
            String nombre = txtNombre.getText();
            String telefono = txtTelefono.getText();
            String puesto = cmbPuesto.getSelectedItem().toString();
            String tipoContrato = cmbTipoContrato.getSelectedItem().toString();
            int diasTrabajados;

            if (tipoContrato.equals("Indefinido")) {
                diasTrabajados = 30;
            } else {
                String diasTrabajadosText = txtDiasTrabajados.getText();
                diasTrabajados = Integer.parseInt(diasTrabajadosText);
            }
            boolean dniRepetido = false;
            boolean telefonoRepetido = false;

            try (BufferedReader reader = new BufferedReader(new FileReader("datos_trabajador.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("DNI:") && line.substring(5).equals(dni)) {
                        dniRepetido = true;
                        break;
                    }
                    if (line.startsWith("Teléfono:") && line.substring(10).equals(telefono)) {
                        telefonoRepetido = true;
                        break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (dniRepetido) {
                JOptionPane.showMessageDialog(this, "El DNI " + dni + " está repetido. No se guardarán los datos del trabajador.");
            } else if (telefonoRepetido) {
                JOptionPane.showMessageDialog(this, "El teléfono " + telefono + " está repetido. No se guardarán los datos del trabajador.");
            } else if(dni.isEmpty()){
                JOptionPane.showMessageDialog(this, "El DNI esta vacio, no se puede guardar al trabajador ");
            }else{

            Trabajador trabajador = new Trabajador(dni, nombre, telefono, puesto, tipoContrato);
            trabajador.setDiasTrabajados(diasTrabajados);

            GuardarDatosTrabajador.guardarDatos(trabajador);
            JOptionPane.showMessageDialog(this, "Los datos del trabajador se han guardado correctamente.");}
            
            InterfazTrabajador interfazTrabajador = new InterfazTrabajador();
            interfazTrabajador.setVisible(true);
        } else if (e.getSource() == btnCargar) {
            
            String dniTrabajador = txtDni.getText();
            Trabajador trabajadorCargado = CargarDatosTrabajador.cargarDatos(dniTrabajador);
            if (trabajadorCargado != null) {
                txtDni.setText(trabajadorCargado.getDni());
                txtNombre.setText(trabajadorCargado.getNombre());
                txtTelefono.setText(trabajadorCargado.getTelefono());
                cmbPuesto.setSelectedItem(trabajadorCargado.getPuesto());
                cmbTipoContrato.setSelectedItem(trabajadorCargado.getTipoContrato());
                txtDiasTrabajados.setText(String.valueOf(trabajadorCargado.getDiasTrabajados()));
                JOptionPane.showMessageDialog(this, "Los datos del trabajador se han cargado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudieron cargar los datos del trabajador.");
            }
            
            
        } else if (e.getSource() == btnCalcularSueldo) {
            
            String dniTrabajador = txtDni.getText();
            double sueldo = 0;
                    try {
                        sueldo = CalcularSueldo.calcularSueldo(dniTrabajador);
                    } catch (IOException ex) {
                        Logger.getLogger(InterfazTrabajador.class.getName()).log(Level.SEVERE, null, ex);
                    }
            JOptionPane.showMessageDialog(this, "El sueldo del trabajador es: " + sueldo + "€");
            
            
        } else if(e.getSource() == btnCambiarTelefono){
            CambiarTelefonoTrabajador cambiarTelefonoTrabajador = new CambiarTelefonoTrabajador();
            cambiarTelefonoTrabajador.setVisible(true);
            dispose();
        }else if(e.getSource() == btnCambiarNombre){
            CambiarNombre cambiarNombre = new CambiarNombre();
            cambiarNombre.setVisible(true);
            dispose();
        }else if(e.getSource() == btnCambiarPuesto){
            CambiarPuesto cambiarPuesto = new CambiarPuesto();
            cambiarPuesto.setVisible(true);
            dispose();
        }else if(e.getSource() == btnCambiarTipoContrato){
            CambiarContrato cambiarContrato = new CambiarContrato();
            cambiarContrato.setVisible(true);
            dispose();
        }else if(e.getSource() == btnCambiarDiasTrabajados){
            CambiarDias cambiarDias = new CambiarDias();
            cambiarDias.setVisible(true);
            dispose();
        }
    }
        }




    
    

   


   
