/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Jesse Johnson
 */

package ucf.assignments;

import javafx.scene.control.CheckBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TableviewListTest
{
    // Make new TodoviewList with parameters
    // Make new TodoviewList without parameters

    // Test get/set status
    // Test get/set Description
    // Test get/set duedate

    @Test
    public void testTempListWithParameters()
    {
        TableviewList tempListWithParameters = new TableviewList("Hello tester", "2021-11-15");
        tempListWithParameters.setStatus("true");

        CheckBox tempCheckBox = new CheckBox();

        tempCheckBox.setSelected(true);

        Assertions.assertEquals(tempListWithParameters.getStatus().isSelected(), tempCheckBox.isSelected());
        Assertions.assertEquals(tempListWithParameters.getDescription(), "Hello tester");
        Assertions.assertEquals(tempListWithParameters.getDueDate(), "2021-11-15");

    }

    @Test
    void testTempListWithNoParameters()
    {
        TableviewList tempListNoParameters = new TableviewList();

        assertNull(tempListNoParameters.getStatus());
        assertNull(tempListNoParameters.getDescription());
        assertNull(tempListNoParameters.getDueDate());
    }
}
