package com.myleshosford.mysqlshell;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.concurrent.Task;

/**
 *
 * @author Myles Hosford
 */
public class MySqlTask extends Task<String> {

    @Override
    protected String call() throws Exception {
        updateProgress(0.1, 10);
        for (int i=0;i<=10;i++) { 
            if (isCancelled()) {
                break;
            }
           // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "*******");
            Thread.sleep(1000);
            System.out.println(i);
            updateProgress(i, 10);  
        }  
        return "Complete";      
    }


}
