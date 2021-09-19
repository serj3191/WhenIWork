package com.whenIWork.step_definitions;

import com.whenIWork.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
