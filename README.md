# Tarea Módulo 2
# 🖥️ Gestor de Usuarios en Java Swing

Aplicación de escritorio en **Java Swing** que muestra un ejemplo de interfaz gráfica usando distintos **layouts**.

---

## ✨ Características
- Ventana dividida con **BorderLayout**:
  - **Norte:** Título.
  - **Oeste:** Menú lateral.
  - **Centro:** Formulario de usuario.
  - **Este:** Pestañas (*Resumen* y *Logs*).
  - **Sur:** Botones de acción.
- Formulario con `GridBagLayout` (Nombre, Email, Rol, Activo, Notas).
- Botones:
  - **Limpiar:** Vacía los campos.
  - **Guardar:** Abre un diálogo de confirmación.

---

## ⚙️ Tecnologías usadas
- **Swing:** `JFrame`, `JPanel`, `JLabel`, `JTextField`, `JTextArea`, `JComboBox`, `JCheckBox`, `JTabbedPane`, `JDialog`, `JButton`.
- **Layouts:** `BorderLayout`, `FlowLayout`, `GridLayout`, `GridBagLayout`.

---

## ▶️ Ejecución
```bash
javac Ejercicio_2/VentanaLayouts.java
java Ejercicio_2.VentanaLayouts
