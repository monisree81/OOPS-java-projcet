// Source code is decompiled from a .class file using FernFlower decompiler.
package com.crimedata.utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher {
   public SceneSwitcher() {
   }

   public static void switchTo(String fxmlFile, String title) {
      try {
         Parent root = (Parent)FXMLLoader.load(SceneSwitcher.class.getResource(fxmlFile));
         Stage stage = new Stage();
         stage.setTitle(title);
         stage.setScene(new Scene(root));
         stage.show();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }
}

