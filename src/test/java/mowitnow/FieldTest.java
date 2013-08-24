package mowitnow;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FieldTest {

    Field field;

    @BeforeTest
    public void setUp() {
        field = new Field(5, 5);
    }

    @Test(dataProvider = "coordonates")
    public void should_tell_if_inside_the_field(int x, int y, boolean expected) {
    	assertThat(field.isWithinBoundaries(x, y)).isEqualTo(expected);
    }

    @DataProvider
    public Object[][] coordonates() {
        return new Object[][]{
                {-1, -1, false},
                {-1, 0, false},
                {0, -1, false},
                {0, 0, true},
                {3, 4, true},
                {5, 5, true},
                {6, 5, false},
                {5, 6, false},
                {6, 6, false},
        };
    }
}
