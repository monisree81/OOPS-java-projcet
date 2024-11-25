// Source code is decompiled from a .class file using FernFlower decompiler.
package com.crimedata.models;

public class IncidentReport {
   private int reportId;
   private int crimeId;
   private String description;
   private String date;

   public IncidentReport(int reportId, int crimeId, String description, String date) {
      this.reportId = reportId;
      this.crimeId = crimeId;
      this.description = description;
      this.date = date;
   }

   public int getReportId() {
      return this.reportId;
   }

   public void setReportId(int reportId) {
      this.reportId = reportId;
   }

   public int getCrimeId() {
      return this.crimeId;
   }

   public void setCrimeId(int crimeId) {
      this.crimeId = crimeId;
   }

   public String getDescription() {
      return this.description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getDate() {
      return this.date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String toString() {
      return "IncidentReport [reportId=" + this.reportId + ", crimeId=" + this.crimeId + ", description=" + this.description + ", date=" + this.date + "]";
   }
}

