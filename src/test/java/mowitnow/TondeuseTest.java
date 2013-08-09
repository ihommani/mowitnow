package mowitnow;


import mowitnow.enums.CardinalPoint;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TondeuseTest {

    private final int X_POSITION = 0;
    private final int Y_POSITION = 0;

    @Mock
    Field field;

    @Mock
    CardinalWithMovement cardinalWithMovement;

    @InjectMocks
    Tondeuse tondeuse = new Tondeuse(X_POSITION, Y_POSITION, CardinalPoint.N);

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_not_move_when_giving_null_argument() {
        tondeuse.updatePosition(null);
        Assert.assertEquals(tondeuse.getX(), X_POSITION);
        Assert.assertEquals(tondeuse.getY(), Y_POSITION);
    }

    @Test(dataProvider = "movements")
    public void should_not_move(CardinalPoint cp) {
        // when ...
        when(field.isWithinBoundaries(any(int.class), any(int.class))).thenReturn(false);
        tondeuse.updatePosition(cp);

        // then ...
        Assert.assertEquals(tondeuse.getX(), X_POSITION);
        Assert.assertEquals(tondeuse.getY(), Y_POSITION);
    }

    @Test(enabled = false, dataProvider = "movements")
    public void should_move(CardinalPoint cp) {
        when(field.isWithinBoundaries(any(int.class), any(int.class))).thenReturn(true);
        tondeuse.updatePosition(cp);
        Assert.assertNotEquals(tondeuse.getX(), X_POSITION);
        Assert.assertNotEquals(tondeuse.getY(), Y_POSITION);
    }

    @DataProvider
    public Object[][] movements() {
        return new Object[][]{
                {CardinalPoint.N},
                {CardinalPoint.E},
                {CardinalPoint.W},
                {CardinalPoint.S},
        };
    }

    @Test
    public void should_only_move_inside_the_field() {

    }

}
