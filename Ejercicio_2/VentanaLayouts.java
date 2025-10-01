package Ejercicio_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaLayouts extends JFrame {
    private JPanel rootPanel;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JTextArea txtNotas;
    private JComboBox<String> comboRol;
    private JCheckBox chkActivo;

    public VentanaLayouts() {

        rootPanel = new JPanel(new BorderLayout(10, 10));
        rootPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titulo = new JLabel("Gestor de usuarios");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        panelNorte.add(titulo);
        rootPanel.add(panelNorte, BorderLayout.NORTH);


        JPanel panelOeste = new JPanel(new GridLayout(6, 1, 10, 10));
        String[] menuItems = {"Dashboard", "Usuarios", "Informes", "Ajustes", "Ayuda"};
        for (String item : menuItems) {
            JButton btn = new JButton(item);
            panelOeste.add(btn);
        }
        rootPanel.add(panelOeste, BorderLayout.WEST);


        JPanel panelCentro = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(18);
        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(18);
        JLabel lblRol = new JLabel("Rol:");
        comboRol = new JComboBox<>(new String[]{"Admin", "User", "Invitado"});
        JLabel lblActivo = new JLabel("Activo:");
        chkActivo = new JCheckBox();
        JLabel lblNotas = new JLabel("Notas:");
        txtNotas = new JTextArea(6, 20);
        JScrollPane scrollNotas = new JScrollPane(txtNotas);

        gbc.gridx = 0; gbc.gridy = 0; panelCentro.add(lblNombre, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panelCentro.add(txtNombre, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panelCentro.add(lblEmail, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panelCentro.add(txtEmail, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panelCentro.add(lblRol, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panelCentro.add(comboRol, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panelCentro.add(lblActivo, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panelCentro.add(chkActivo, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panelCentro.add(lblNotas, gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.fill = GridBagConstraints.BOTH; panelCentro.add(scrollNotas, gbc);

        rootPanel.add(panelCentro, BorderLayout.CENTER);


        JTabbedPane tabs = new JTabbedPane();

        JPanel panelResumen = new JPanel(new BorderLayout());
        JTextArea txtResumen = new JTextArea();
        JScrollPane scrollResumen = new JScrollPane(txtResumen);
        panelResumen.add(scrollResumen, BorderLayout.CENTER);

        JPanel panelLogs = new JPanel(new BorderLayout());
        JTextArea txtLogs = new JTextArea("");
        JScrollPane scrollLogs = new JScrollPane(txtLogs);
        panelLogs.add(scrollLogs, BorderLayout.CENTER);

        tabs.addTab("Resumen", panelResumen);
        tabs.addTab("Logs", panelLogs);

        tabs.setPreferredSize(new Dimension(220, 0));
        rootPanel.add(tabs, BorderLayout.EAST);


        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnGuardar = new JButton("Guardar");


        btnLimpiar.addActionListener(e -> limpiarCampos());


        btnGuardar.addActionListener(this::mostrarDialogo);

        panelSur.add(btnCancelar);
        panelSur.add(btnLimpiar);
        panelSur.add(btnGuardar);
        rootPanel.add(panelSur, BorderLayout.SOUTH);


        setContentPane(rootPanel);
        setTitle("Gestor de usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtEmail.setText("");
        txtNotas.setText("");
        comboRol.setSelectedIndex(0);
        chkActivo.setSelected(false);
    }

    private void mostrarDialogo(ActionEvent e) {
        JDialog dialogo = new JDialog(this, "Confirmación", true);
        dialogo.setSize(300,150);
        dialogo.setLayout(new BorderLayout());

        JLabel lbl = new JLabel("¿Desea guardar los datos?", SwingConstants.CENTER);
        dialogo.add(lbl, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(new JButton("Sí"));
        panelBotones.add(new JButton("No"));
        dialogo.add(panelBotones, BorderLayout.SOUTH);

        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VentanaLayouts::new);
    }
}
