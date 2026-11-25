
package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

/** Form Tambah Karakter */
public class CharacterFormPanel extends JPanel {

    private final CharacterManager manager;
    private final Runnable onAdded;

    private final JTextField nameField = new JTextField(14);

    private final JComboBox<CharacterType> roleBox =
            new JComboBox<>(CharacterType.values());

    private final JSpinner levelSpinner =
            new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));

    private final JLabel messageLabel = new JLabel(" ");

    private final Border nameBorder;
    private final Border levelBorder;

    // Warna pesan
    private static final Color ERROR_COLOR =
            new Color(220, 53, 69);

    private static final Color SUCCESS_COLOR =
            new Color(40, 167, 69);

    public CharacterFormPanel(CharacterManager manager, Runnable onAdded) {

        this.manager = manager;
        this.onAdded = onAdded;

        this.nameBorder = nameField.getBorder();
        this.levelBorder = levelSpinner.getBorder();

        setLayout(new BorderLayout());
        setBackground(AppTheme.BG_MAIN);

        setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 8));

        setPreferredSize(new Dimension(250, 0));

        JLabel title = new JLabel("Tambah Karakter");

        title.setFont(
                AppTheme.FONT_BODY.deriveFont(
                        java.awt.Font.BOLD, 16f
                )
        );

        title.setForeground(AppTheme.TEXT_MAIN);

        messageLabel.setFont(AppTheme.FONT_BODY);

        JButton saveButton = new JButton("Simpan");

        saveButton.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );

        saveButton.addActionListener(e -> onSave());

        nameField.addActionListener(e -> onSave());

        JPanel rows = new JPanel(
                new GridLayout(0, 1, 0, 4)
        );

        rows.setOpaque(false);

        rows.add(title);
        rows.add(makeLabel("Nama:", nameField));
        rows.add(nameField);
        rows.add(makeLabel("Role:", roleBox));
        rows.add(roleBox);
        rows.add(makeLabel("Level:", levelSpinner));
        rows.add(levelSpinner);
        rows.add(messageLabel);
        rows.add(saveButton);

        add(rows, BorderLayout.NORTH);
    }

    private JLabel makeLabel(String text, JComponent target) {

        JLabel label = new JLabel(text);

        label.setFont(AppTheme.FONT_BODY);
        label.setForeground(AppTheme.TEXT_MAIN);
        label.setLabelFor(target);

        return label;
    }

    /** Proses penyimpanan karakter */
    private void onSave() {

        clearMessage();

        String name = nameField.getText().trim();

        String problem = validateName(name);

        if (problem != null) {

            showError(problem, nameField);

            nameField.requestFocusInWindow();

            return;
        }

        try {

            levelSpinner.commitEdit();

        } catch (ParseException ex) {

            showError("Level harus berupa angka", levelSpinner);

            return;
        }

        CharacterType role =
                (CharacterType) roleBox.getSelectedItem();

        int level =
                (Integer) levelSpinner.getValue();

        try {

            manager.addCharacter(
                    new Character(name, role, level)
            );

        } catch (IllegalArgumentException ex) {

            showError(ex.getMessage(), levelSpinner);

            return;
        }

        nameField.setText("");

        roleBox.setSelectedIndex(0);

        levelSpinner.setValue(1);

        showSuccess("Tersimpan: " + name);

        nameField.requestFocusInWindow();

        onAdded.run();
    }

    /** Validasi nama karakter */
    private String validateName(String name) {

        if (name.isEmpty()) {
            return "Nama wajib diisi";
        }

        if (name.length() < 3 || name.length() > 20) {
            return "Nama harus 3-20 karakter";
        }

        if (!name.matches("[A-Za-z ]+")) {
            return "Nama hanya huruf dan spasi";
        }

        if (name.contains("  ")) {
            return "Nama tidak boleh mengandung spasi ganda";
        }

        if (manager.findByName(name) != null) {
            return "Nama sudah dipakai";
        }

        return null;
    }

    /** Menampilkan pesan error */
    private void showError(String text, JComponent source) {

        messageLabel.setText(text);

        messageLabel.setForeground(ERROR_COLOR);

        source.setBorder(
                BorderFactory.createLineBorder(ERROR_COLOR, 2)
        );
    }

    /** Menampilkan pesan berhasil */
    private void showSuccess(String text) {

        messageLabel.setText(text);

        messageLabel.setForeground(SUCCESS_COLOR);
    }

    /** Menghapus pesan dan mengembalikan border */
    private void clearMessage() {

        messageLabel.setText(" ");

        nameField.setBorder(nameBorder);

        levelSpinner.setBorder(levelBorder);
    }
}
