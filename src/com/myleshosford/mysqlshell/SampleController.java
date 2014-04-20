/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myleshosford.mysqlshell;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author Myles Hosford
 */

public class SampleController implements Initializable {
    
    @FXML
    ToggleButton startbutton;
    
    @FXML
    ListView listview;
    
    @FXML
    ProgressBar progress;
    
    @FXML 
     TableView tableview;
    
    ObservableList<String> items;
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    
    @FXML
    private void handleStartButtonAction(ActionEvent event) {
        startbutton =(ToggleButton)event.getSource(); 
        if (startbutton.isSelected()){
            startbutton.setText("Stop");
            MySqlTask task = new MySqlTask();
            progress.progressProperty().bind(task.progressProperty());
            threadPool.execute(task);
        } else {
            startbutton.setText("Start");
//            items.add("myles");
        }     
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // items = FXCollections.observableArrayList ("MySQL Authentication","SSH Authentication");
        //listview.setItems(items);
         tableview.setEditable(true);
 
        TableColumn idCol = new TableColumn("ID");
        TableColumn dateTimeCol = new TableColumn("Time stamp");
        TableColumn pluginCol = new TableColumn("Plugin");
        TableColumn userCol = new TableColumn("User");
        TableColumn passwordCol = new TableColumn("Password");
        TableColumn hostCol = new TableColumn("Host");
        tableview.getColumns().addAll(idCol, dateTimeCol, pluginCol, userCol, passwordCol, hostCol);
    
    }    
}
