import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class VehicleRegistrationForm extends JFrame {
    private JTextField picField;
    private JTextField colorField;
    private JPanel tablePanel;
    private DefaultTableModel tableModel;
    private JTable table;
    private JComboBox<String> transactionTypeComboBox;
    private JTextField rentalDaysField; 
    
    // Clase interna para renderizar botones en la tabla
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Clase interna para editar botones en la tabla
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }
    }

     
    public VehicleRegistrationForm() {
         setTitle("Registro de Vehículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.decode("#010035"));
        headerPanel.setPreferredSize(new Dimension(800, 40));
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        
        JLabel titleLabel = new JLabel("GENERAL MOTORS C.A");
        titleLabel.setFont(new Font("Cambria", Font.PLAIN, 24));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);

        add(headerPanel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBackground(Color.decode("#b6b6b6"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Owner Data
        JLabel ownerTitleLabel = new JLabel("Datos personales");
        ownerTitleLabel.setFont(new Font("Cambria", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        formPanel.add(ownerTitleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        formPanel.add(new JLabel("Nombre:"), gbc);
        JTextField nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Apellido:"), gbc);
        JTextField lastNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Cédula:"), gbc);
        JTextField idField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Teléfono:"), gbc);
        JTextField phoneField = new JTextField(11);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Dirección:"), gbc);
        JTextField addressField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(addressField, gbc);

        // Vehicle Data
        JLabel vehicleTitleLabel = new JLabel("Datos del vehículo");
        vehicleTitleLabel.setFont(new Font("Cambria", Font.PLAIN, 20));
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        formPanel.add(vehicleTitleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        formPanel.add(new JLabel("Placa:"), gbc);
        JTextField plateField = new JTextField(7);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(plateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Año del vehículo:"), gbc);
        JTextField yearField = new JTextField(4);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(yearField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Marca:"), gbc);
        String[] brands = {"Marca1", "Marca2", "Marca3", "Marca4", "Marca5"};
        JComboBox<String> brandComboBox = new JComboBox<>(brands);
        gbc.gridx = 1;
        formPanel.add(brandComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Modelo:"), gbc);
        JComboBox<String> modelComboBox = new JComboBox<>();
        modelComboBox.addItem("Modelo1");
        modelComboBox.addItem("Modelo2");
        gbc.gridx = 1;
        formPanel.add(modelComboBox, gbc);

         gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Color:"), gbc);
        colorField = new JTextField(10);
        colorField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        formPanel.add(colorField, gbc);

        JButton colorButton = new JButton("Elegir Color");
        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(null, "Seleccione un Color", Color.WHITE);
                if (selectedColor != null) {
                    colorField.setBackground(selectedColor);
                    colorField.setText("#" + Integer.toHexString(selectedColor.getRGB()).substring(2).toUpperCase());
                }
            }
        });
        gbc.gridx = 2;
        formPanel.add(colorButton, gbc);

   

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Foto URL:"), gbc);
        picField = new JTextField(10);
        picField.setEditable(false);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        formPanel.add(picField, gbc);

        JButton uploadButton = new JButton("Cargar Foto");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    picField.setText(selectedFile.getAbsolutePath());
                }
            }
        });
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        formPanel.add(uploadButton, gbc);
        
        
        // Tipo de transacción (venta o renta)
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        formPanel.add(new JLabel("Transacción:"), gbc);
        String[] transactionTypes = {"Venta", "Renta"};
        transactionTypeComboBox = new JComboBox<>(transactionTypes);
        transactionTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (transactionTypeComboBox.getSelectedItem().equals("Renta")) {
                    rentalDaysField.setEnabled(true); // Habilita el campo de días de renta
                } else {
                    rentalDaysField.setEnabled(false); // Deshabilita el campo de días de renta
                }
            }
        });
        gbc.gridx = 1;
        formPanel.add(transactionTypeComboBox, gbc);

        // Campo de días de renta
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        formPanel.add(new JLabel("Días de renta:"), gbc);
        rentalDaysField = new JTextField(5);
        rentalDaysField.setEnabled(false); // Por defecto, deshabilitado
        gbc.gridx = 1;
        formPanel.add(rentalDaysField, gbc);
        // Submit Button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        JButton submitButton = new JButton("Registrar");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para procesar el formulario aquí...
                JOptionPane.showMessageDialog(null, "Formulario enviado correctamente");
            }
        });
        formPanel.add(submitButton, gbc);

        add(formPanel, BorderLayout.WEST);

        // Table Panel
        tablePanel = new JPanel();
        tablePanel.setBackground(Color.decode("#b6b6b6"));
        add(tablePanel, BorderLayout.EAST);

        // Inicializar y configurar la tabla
        initializeTable();

        // Empaquetar y hacer visible la ventana
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
     private void initializeTable() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Año");
        tableModel.addColumn("Modelo");
        tableModel.addColumn("Marca");
        tableModel.addColumn("Placa");
        tableModel.addColumn("Acciones");

        table = new JTable(tableModel);

        // Configuración de la columna de acciones
        TableColumn actionsColumn = table.getColumnModel().getColumn(4);
        actionsColumn.setCellRenderer(new ButtonRenderer());
        actionsColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VehicleRegistrationForm());
    }
}
