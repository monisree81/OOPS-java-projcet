// Source code is decompiled from a .class file using FernFlower decompiler.
package com.crimedata.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CrimeData {
   private StringProperty crimeType;
   private StringProperty crimeLocation;
   private StringProperty crimeDate;
   private StringProperty offenderName;
   private StringProperty caseID;
   private StringProperty caseStatus;

   public CrimeData(String crimeType, String crimeLocation, String crimeDate, String offenderName, String caseID, String caseStatus) {
      this.crimeType = new SimpleStringProperty(crimeType);
      this.crimeLocation = new SimpleStringProperty(crimeLocation);
      this.crimeDate = new SimpleStringProperty(crimeDate);
      this.offenderName = new SimpleStringProperty(offenderName);
      this.caseID = new SimpleStringProperty(caseID);
      this.caseStatus = new SimpleStringProperty(caseStatus);
   }

   public String getCrimeType() {
      return (String)this.crimeType.get();
   }

   public String getCrimeLocation() {
      return (String)this.crimeLocation.get();
   }

   public String getCrimeDate() {
      return (String)this.crimeDate.get();
   }

   public String getOffenderName() {
      return (String)this.offenderName.get();
   }

   public String getCaseID() {
      return (String)this.caseID.get();
   }

   public String getCaseStatus() {
      return (String)this.caseStatus.get();
   }

   public StringProperty crimeTypeProperty() {
      return this.crimeType;
   }

   public StringProperty crimeLocationProperty() {
      return this.crimeLocation;
   }

   public StringProperty crimeDateProperty() {
      return this.crimeDate;
   }

   public StringProperty offenderNameProperty() {
      return this.offenderName;
   }

   public StringProperty caseIDProperty() {
      return this.caseID;
   }

   public StringProperty caseStatusProperty() {
      return this.caseStatus;
   }
}
