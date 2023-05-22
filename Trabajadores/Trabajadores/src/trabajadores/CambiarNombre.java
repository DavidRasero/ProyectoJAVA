
package trabajadores;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CambiarNombre extends JFrame implements ActionListener {
    private JTextField txtDni;
    private JTextField txtNuevoNombre;
    private JButton btnCambiarNombre;

    public CambiarNombre() {
        super("Cambiar Nombre de Trabajador");

        
        JLabel lblDni = new JLabel("DNI:");
        JLabel lblNuevoNombre = new JLabel("Nuevo Nombre:");
        txtDni = new JTextField(20);
        txtNuevoNombre = new JTextField(20);
        btnCambiarNombre = new JButton("Cambiar Nombre");
        btnCambiarNombre.addActionListener(this);

        
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        panelFormulario.add(lblDni);
        panelFormulario.add(txtDni);
        panelFormulario.add(lblNuevoNombre);
        panelFormulario.add(txtNuevoNombre);
        panelFormulario.add(btnCambiarNombre);

        
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
        if (e.getSource() == btnCambiarNombre) {
            String dniTrabajador = txtDni.getText();
            String nuevoNombre = txtNuevoNombre.getText();
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
                        writer.write("Nombre: " + nuevoNombre);
                        writer.newLine();
                        for (int i = 0; i < 1; i++) {
                            reader.readLine();
                        }
                        writer.write(reader.readLine());
                        writer.newLine();
                        
                        
                        
                        
                            
                        
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
                    JOptionPane.showMessageDialog(this, "Se ha cambiado el Nombre del trabajador con DNI " + dniTrabajador + ".");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "No se pudo cambiar el Nombre del trabajador con DNI " + dniTrabajador + ".");
                }
           } else {
                JOptionPane.showMessageDialog(this, "No se encontró al trabajador con DNI " + dniTrabajador + ".");
            }

            
            txtDni.setText("");
            txtNuevoNombre.setText("");
        }
        InterfazTrabajador interfazTrabajador = new InterfazTrabajador();
        interfazTrabajador.setVisible(true);
        dispose();
    }
        
  
}
