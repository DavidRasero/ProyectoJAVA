
package trabajadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DespedirTrabajador extends JFrame implements ActionListener {
    private JTextField txtDni;
    private JButton btnDespedir;

    public DespedirTrabajador() {
        super("Despedir Trabajador");

        
        JLabel lblDni = new JLabel("DNI:");
        txtDni = new JTextField(20);
        btnDespedir = new JButton("Despedir");
        btnDespedir.addActionListener(this);

        
        JPanel panelFormulario = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelFormulario.add(lblDni);
        panelFormulario.add(txtDni);
        panelFormulario.add(btnDespedir);

        
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
        
        if (e.getSource() == btnDespedir) {
            dispose();
            String dniTrabajador = txtDni.getText();
            boolean trabajadorEncontrado = false;
            File original = new File("datos_trabajador.txt");
            File temporal = new File("temp_trabajador.txt");

            try (BufferedReader reader = new BufferedReader(new FileReader(original));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(temporal))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("DNI:") && line.substring(5).equals(dniTrabajador)) {
                        trabajadorEncontrado = true;
                        for (int i = 0; i < 6; i++) {
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
                Path source = temporal.toPath();
                Path destination = original.toPath();

                try {
                Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(this, "El trabajador con DNI " + dniTrabajador + " ha sido despedido.");
                }catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "No se puede despedir al trabajador con el DNI " + dniTrabajador);
                }
                   
                
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró al trabajador con DNI " + dniTrabajador + ".");
            }

            txtDni.setText("");
            
            
        }
        
        InterfazTrabajador interfazTrabajador = new InterfazTrabajador();
        interfazTrabajador.setVisible(true);
        dispose();
    }
    

    
}
