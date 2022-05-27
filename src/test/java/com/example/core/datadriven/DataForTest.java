package com.example.core.datadriven;

import com.example.core.helper.JsonHelper;

import org.testng.annotations.DataProvider;

public class DataForTest {
    
    @DataProvider(name = "dataForLoginAccount")    
    public static Object dataLoginAccount(){
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/accountundertest.json");
    };

    @DataProvider(name = "dataForFlightFinder")
    public static Object dataFlightFinder(){
        return JsonHelper.ReadJsonFromFile("src/test/java/com/example/core/resources/flightfinderundertest.json");
    }
}
