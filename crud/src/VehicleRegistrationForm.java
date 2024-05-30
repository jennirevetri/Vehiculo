import javax.swing.*;
import java.awt.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VehicleRegistrationForm extends JFrame {
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private JTextField picField;
    private JTextField colorField;
    private JPanel tablePanel;
    private DefaultTableModel tableModel;
    private JTable table;
    private JComboBox<String> transactionTypeComboBox;
    private JTextField rentalDaysField;

    private JTextField nameField;
    private JTextField lastNameField;
    private JTextField idField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField plateField;
    private JTextField yearField;
    private JComboBox<String> brandComboBox;
    private JComboBox<String> modelComboBox;
    private JButton submitButton;
    private JButton saveChangesButton; 

    

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
        nameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Apellido:"), gbc);
        lastNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Cédula:"), gbc);
        idField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Teléfono:"), gbc);
        phoneField = new JTextField(11);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Dirección:"), gbc);
        addressField = new JTextField(20);
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
        plateField = new JTextField(7);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(plateField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        formPanel.add(new JLabel("Año del vehículo:"), gbc);
        yearField = new JTextField(4);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        formPanel.add(yearField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Marca:"), gbc);
        String[] brands = {"Marca1", "Marca2", "Marca3", "Marca4", "Marca5"};
        brandComboBox = new JComboBox<>(brands);
        gbc.gridx = 1;
        formPanel.add(brandComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(new JLabel("Modelo:"), gbc);
        modelComboBox = new JComboBox<>();
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
        colorButton.setBackground(Color.decode("#010035"));
        colorButton.setForeground(Color.WHITE);
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
        uploadButton.setBackground(Color.decode("#010035"));
        uploadButton.setForeground(Color.WHITE);
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
        submitButton = new JButton("Registrar");
        submitButton.setBackground(Color.decode("#010035"));
        submitButton.setForeground(Color.WHITE);
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(submitButton, gbc);
        
        // Botón para guardar cambios
        saveChangesButton = new JButton("Guardar Cambios");
        saveChangesButton.setBackground(Color.decode("#010035"));
        saveChangesButton.setForeground(Color.WHITE);
        saveChangesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        saveChangesButton.setVisible(false); // Inicialmente no visible
        formPanel.add(saveChangesButton, gbc);
        
        

        // Acción para el botón "Guardar Cambios"
        saveChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el índice de la fila seleccionada en la tabla
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Obtener el vehículo seleccionado
                    Vehiculo vehiculo = vehiculos.get(selectedRow);

                    // Actualizar los datos del vehículo con los datos del formulario
                    vehiculo.setOwnerName(nameField.getText());
                    vehiculo.setOwnerLastname(lastNameField.getText());
                    vehiculo.setOwnerId(idField.getText());
                    vehiculo.setOwnerPhone(phoneField.getText());
                    vehiculo.setOwnerAddress(addressField.getText());
                    vehiculo.setVehiclePlate(plateField.getText());
                    vehiculo.setVehicleBrand((String) brandComboBox.getSelectedItem());
                    vehiculo.setVehicleModel((String) modelComboBox.getSelectedItem());
                    vehiculo.setVehicleYear(Integer.parseInt(yearField.getText()));
                    vehiculo.setVehicleColor(colorField.getText());
                    vehiculo.setVehiclePic(picField.getText());

                    // Renderizar la tabla con los vehículos actualizados
                    renderTable();

                    // Limpiar los campos del formulario después de editar el vehículo
                    clearForm();

                    // Desactivar el botón "Guardar Cambios" y activar el botón "Registrar"
                    saveChangesButton.setVisible(false);
                    submitButton.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un vehículo para editar.");
                }
            }
        });

        add(formPanel, BorderLayout.WEST); // Añadir formPanel al JFrame

        // Table Panel
        tablePanel = new JPanel();
        tablePanel.setBackground(Color.decode("#b6b6b6"));
        tablePanel.setLayout(new BorderLayout()); // Asegurar el layout del panel

        // Configuración de la tabla
        String[] columnNames = {"Año", "Marca", "Modelo", "Placa", "Ver", "Editar", "Eliminar"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Configuración de los renderizadores y editores de botones
        table.getColumn("Ver").setCellRenderer(new ButtonRenderer("Ver"));
        table.getColumn("Ver").setCellEditor(new ButtonEditor("Ver"));
        table.getColumn("Editar").setCellRenderer(new ButtonRenderer("Editar"));
        table.getColumn("Editar").setCellEditor(new ButtonEditor("Editar"));
        table.getColumn("Eliminar").setCellRenderer(new ButtonRenderer("Eliminar"));
        table.getColumn("Eliminar").setCellEditor(new ButtonEditor("Eliminar"));

        // Añadir la tabla a un JScrollPane y agregarlo al JFrame
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear un nuevo objeto Vehiculo con los valores del formulario
                Vehiculo vehiculo = new Vehiculo(
                        nameField.getText(),
                        lastNameField.getText(),
                        idField.getText(),
                        phoneField.getText(),
                        addressField.getText(),
                        plateField.getText(),
                        (String) brandComboBox.getSelectedItem(),
                        (String) modelComboBox.getSelectedItem(),
                        Integer.parseInt(yearField.getText()),
                        colorField.getText(),
                        picField.getText()
                );

                // Agregar el vehículo a la lista
                vehiculos.add(vehiculo);

                // Renderizar la tabla con los vehículos actualizados
                renderTable();

                // Limpiar los campos del formulario después de agregar el vehículo
                clearForm();
            }
        });

        // Inicialmente renderiza la tabla
        renderTable();

        // Ajustar el tamaño del JFrame
        setSize(1000, 600);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    // Método para renderizar la tabla con los vehículos almacenados en la lista
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer(String text) {
            super(text);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Clase interna para editar botones en la tabla
    class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
        private final JButton button;
        private final String label;
        private int editingRow;

        public ButtonEditor(String text) {
            button = new JButton(text);
            label = text;

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (label.equals("Editar")) {
                        // Al hacer clic en el botón de editar, cargar los datos en el formulario
                        loadFormData(editingRow);
                    } else if (label.equals("Eliminar")) {
                        // Eliminar la fila correspondiente cuando se hace clic en el botón de eliminar
                        vehiculos.remove(editingRow);
                        renderTable();
                    } else if (label.equals("Ver")) {
                        // Mostrar los datos del vehículo en una ventana emergente
                        showVehicleDetails(editingRow);
                    }
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            editingRow = row;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return label;
        }
    }

    // Método para cargar los datos del vehículo en el formulario de edición
    private void loadFormData(int row) {
        Vehiculo vehiculo = vehiculos.get(row);
        // Asignar los datos del vehículo a los campos del formulario
        nameField.setText(vehiculo.getOwnerName());
        lastNameField.setText(vehiculo.getOwnerLastname());
        idField.setText(vehiculo.getOwnerId());
        phoneField.setText(vehiculo.getOwnerPhone());
        addressField.setText(vehiculo.getOwnerAddress());
        plateField.setText(vehiculo.getVehiclePlate());
        yearField.setText(Integer.toString(vehiculo.getVehicleYear()));
        brandComboBox.setSelectedItem(vehiculo.getVehicleBrand());
        modelComboBox.setSelectedItem(vehiculo.getVehicleModel());
        colorField.setText(vehiculo.getVehicleColor());
        picField.setText(vehiculo.getVehiclePic());

        // Mostrar el botón "Guardar Cambios" y ocultar el botón "Registrar"
        saveChangesButton.setVisible(true);
        submitButton.setVisible(false);
    }
    
     private void showVehicleDetails(int row) {
        Vehiculo vehiculo = vehiculos.get(row);

        // Construir el mensaje con todos los detalles del vehículo
        StringBuilder message = new StringBuilder();
        message.append("Nombre del propietario: ").append(vehiculo.getOwnerName()).append("\n");
        message.append("Apellido del propietario: ").append(vehiculo.getOwnerLastname()).append("\n");
        message.append("Cédula del propietario: ").append(vehiculo.getOwnerId()).append("\n");
        message.append("Teléfono del propietario: ").append(vehiculo.getOwnerPhone()).append("\n");
        message.append("Dirección del propietario: ").append(vehiculo.getOwnerAddress()).append("\n");
        message.append("Placa del vehículo: ").append(vehiculo.getVehiclePlate()).append("\n");
        message.append("Año del vehículo: ").append(vehiculo.getVehicleYear()).append("\n");
        message.append("Marca del vehículo: ").append(vehiculo.getVehicleBrand()).append("\n");
        message.append("Modelo del vehículo: ").append(vehiculo.getVehicleModel()).append("\n");
        message.append("Color del vehículo: ").append(vehiculo.getVehicleColor()).append("\n");
        message.append("Tipo de transacción: ").append(transactionTypeComboBox.getSelectedItem()).append("\n");

        // Mostrar la ventana emergente con los detalles del vehículo
        JOptionPane.showMessageDialog(null, message.toString(), "Detalles del Vehículo", JOptionPane.INFORMATION_MESSAGE);
    }


    // Método para renderizar la tabla con los vehículos almacenados en la lista
    private void renderTable() {
        // Limpiar la tabla existente
        tableModel.setRowCount(0);

        // Iterar sobre la lista de vehículos y agregarlos a la tabla
        for (Vehiculo vehiculo : vehiculos) {
            tableModel.addRow(new Object[]{
                    vehiculo.getVehicleYear(),
                    vehiculo.getVehicleBrand(),
                    vehiculo.getVehicleModel(),
                    vehiculo.getVehiclePlate(),
                    "Ver",
                    "Editar",
                    "Eliminar"
            });
        }
    }

    // Método para limpiar los campos del formulario
    private void clearForm() {
        nameField.setText("");
        lastNameField.setText("");
        idField.setText("");
        phoneField.setText("");
        addressField.setText("");
        plateField.setText("");
        yearField.setText("");
        brandComboBox.setSelectedIndex(0);
        modelComboBox.setSelectedIndex(0);
        colorField.setText("");
        colorField.setBackground(Color.WHITE);
        picField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VehicleRegistrationForm form = new VehicleRegistrationForm();
            form.setVisible(true);
        });
    }
}