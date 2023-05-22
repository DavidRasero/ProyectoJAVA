
package trabajadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CambiarTelefonoTrabajador extends JFrame implements ActionListener {
    private JTextField txtDni;
    private JTextField txtNuevoTelefono;
    private JButton btnCambiarTelefono;

    public CambiarTelefonoTrabajador() {
        super("Cambiar Teléfono de Trabajador");

        
        JLabel lblDni = new JLabel("DNI:");
        JLabel lblNuevoTelefono = new JLabel("Nuevo Teléfono:");
        txtDni = new JTextField(20);
        txtNuevoTelefono = new JTextField(20);
        btnCambiarTelefono = new JButton("Cambiar Teléfono");
        btnCambiarTelefono.addActionListener(this);

        
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        panelFormulario.add(lblDni);
        panelFormulario.add(txtDni);
        panelFormulario.add(lblNuevoTelefono);
        panelFormulario.add(txtNuevoTelefono);
        panelFormulario.add(btnCambiarTelefono);

        
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panelFormulario, BorderLayout.CENTER);

        
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCambiarTelefono) {
            String dniTrabajador = txtDni.getText();
            String nuevoTelefono = txtNuevoTelefono.getText();
            boolean trabajadorEncontrado = false;
            File original = new File("datos_trabajador.txt");
            File nuevo = new File("temp_trabajador.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(original));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(nuevo))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("DNI:") && line.substring(5).equals(dniTrabajador)) {
                        trabajadorEncontrado = true;

                        writer.write("DNI: " + dniTrabajador);
                        writer.newLine();
                        writer.write(reader.readLine());
                        writer.newLine();
                        writer.write("Teléfono: " + nuevoTelefono);
                        writer.newLine();
                        for (int i = 0; i < 1; i++) {
                            reader.readLine();
                        }
                        
                            
                        
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if (trabajadorEncontrado) {
                try {
                   Files.move(nuevo.toPath(), original.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(this, "Se ha cambiado el teléfono del trabajador con DNI " + dniTrabajador + ".");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "No se pudo cambiar el teléfono del trabajador con DNI " + dniTrabajador + ".");
                }
           } else {
                JOptionPane.showMessageDialog(this, "No se encontró al trabajador con DNI " + dniTrabajador + ".");
            }

            
            txtDni.setText("");
            txtNuevoTelefono.setText("");
        }
        InterfazTrabajador interfazTrabajador = new InterfazTrabajador();
        interfazTrabajador.setVisible(true);
        dispose();
    }
        
  
}


