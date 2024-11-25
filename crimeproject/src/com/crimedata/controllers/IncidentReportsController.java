package com.crimedata.controllers;

import com.crimedata.models.IncidentReport;
import com.crimedata.utils.DatabaseUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IncidentReportsController {

    @FXML
    private TableView<IncidentReport> incidentReportsTable;

    @FXML
    private TableColumn<IncidentReport, Integer> reportIdColumn;
    @FXML
    private TableColumn<IncidentReport, Integer> crimeIdColumn;
    @FXML
    private TableColumn<IncidentReport, String> reportDescriptionColumn;
    @FXML
    private TableColumn<IncidentReport, String> reportDateColumn;

    @FXML
    private TextField reportIdField;
    @FXML
    private TextField crimeIdField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField dateField;

    private List<IncidentReport> reportsList = new ArrayList<>();

    @FXML
    public void initialize() {
        // Set up TableView columns to bind to IncidentReport properties
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("report_Id"));
        crimeIdColumn.setCellValueFactory(new PropertyValueFactory<>("crime_Id"));
        reportDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("report_notes"));
        reportDateColumn.setCellValueFactory(new PropertyValueFactory<>("report_date"));

        // Load incident reports from the database
        loadReports();
    }

    @FXML
    private void handleSubmitReport() {
        try {
            // Validate and parse input values
            int reportId = Integer.parseInt(reportIdField.getText());
            int crimeId = Integer.parseInt(crimeIdField.getText());
            String description = descriptionField.getText();
            String date = dateField.getText();

            // Insert the new report into the database
            addReportToDatabase(reportId, crimeId, description, date);

            // Clear the input fields after submission
            reportIdField.clear();
            crimeIdField.clear();
            descriptionField.clear();
            dateField.clear();

            // Reload reports from the database
            loadReports();

            // Show success message
            showAlert(Alert.AlertType.INFORMATION, "Report Submitted", "Incident Report Added",
                    "The incident report has been successfully added.");
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric for ID fields)
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Input Error",
                    "Please enter valid numbers for Report ID and Crime ID.");
        }
    }

    private void addReportToDatabase(int reportId, int crimeId, String description, String date) {
        String query = "INSERT INTO incidentreports (report_id, crime_id, report_notes, report_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, reportId);
            stmt.setInt(2, crimeId);
            stmt.setString(3, description);
            stmt.setString(4, date);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Error Adding Report",
                    "There was an error adding the incident report to the database.");
        }
    }

    private void loadReports() {
        reportsList.clear(); // Clear the list before adding updated data
        String query = "SELECT * FROM incidentreports";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Populate the reports list from the result set
            while (rs.next()) {
                IncidentReport report = new IncidentReport(
                        rs.getInt("report_id"),
                        rs.getInt("crime_id"),
                        rs.getString("report_notes"),
                        rs.getString("report_date")
                );
                reportsList.add(report);
            }

            // Bind the list to the TableView
            incidentReportsTable.getItems().setAll(reportsList);

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Database Error", "Error Loading Reports",
                    "There was an error loading the incident reports from the database.");
        }
    }

    private void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
