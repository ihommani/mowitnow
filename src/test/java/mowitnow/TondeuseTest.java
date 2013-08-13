package mowitnow;


import java.util.Map;

import com.google.common.collect.Maps;

import mowitnow.enums.CardinalPoint;
import mowitnow.enums.Movement;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TondeuseTest {

    private final int X_POSITION = 0;
    private final int Y_POSITION = 0;

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
        tondeuse.move(null);
        Assert.assertEquals(tondeuse.getX(), X_POSITION);
        Assert.assertEquals(tondeuse.getY(), Y_POSITION);
    }

    @Test(dataProvider = "movements")
    public void should_move_according_direction(Movement movement, CardinalPoint expectedDirection) {
        Map<CardinalPoint, Map<Movement, CardinalPoint>> map = Maps.newHashMap();
        Map<Movement, CardinalPoint> mc = Maps.newHashMap();
        mc.put(Movement.A, CardinalPoint.N);
        mc.put(Movement.D, CardinalPoint.E);
        mc.put(Movement.G, CardinalPoint.W);
        tondeuse.setField(new Field(X_POSITION, Y_POSITION));
        map.put(CardinalPoint.N, mc);
        Mockito.when(cardinalWithMovement.getMap()).thenReturn(map);
        tondeuse.move(movement);

        Assert.assertEquals(tondeuse.getDirection(), expectedDirection);
    }

    @DataProvider
    public Object[][] movements() {
        return new Object[][]{
                {Movement.A, CardinalPoint.N},
                {Movement.G, CardinalPoint.W},
        };
    }

    //TODO: Complete tests...
}
