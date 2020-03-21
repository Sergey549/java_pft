package ru.stqa.pft.sandbox;

import org.junit.Assert;
import org.junit.Test;
import ru.stqa.pft.sandbox.Square;

class SquareTests {

    @Test
    public void testArea () {

        Square s = new Square (5);
        assert s.area() == 25;

    }
}
