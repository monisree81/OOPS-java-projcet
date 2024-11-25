// Source code is decompiled from a .class file using FernFlower decompiler.
package com.crimedata.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class MainController {
   @FXML
   private Pane contentPane;

   public MainController() {
   }

   private void loadPage(String fxmlFile) {
      try {
         FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/crimedata/views/" + fxmlFile));
         Parent root = (Parent)loader.load();
         this.contentPane.getChildren().clear();
         this.contentPane.getChildren().add(root);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @FXML
   private void handleDashboard() {
      this.loadPage("Dashboard.fxml");
   }

   @FXML
   private void handleCrimeRecords() {
      this.loadPage("CrimeRecords.fxml");
   }

   @FXML
   private void handleOffenderProfiles() {
      this.loadPage("OffenderProfiles.fxml");
   }

   @FXML
   private void handleIncidentReports() {
      this.loadPage("IncidentReports.fxml");
   }

   @FXML
   private void handleAnalytics() {
      this.loadPage("Analytics.fxml");
   }
}
