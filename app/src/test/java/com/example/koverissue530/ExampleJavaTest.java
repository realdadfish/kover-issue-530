package com.example.koverissue530;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ExampleJavaTest {
    @Test
    public void subtraction_isCorrect() {
        assertEquals(4, Example.subtract(9, 5));
    }
}
