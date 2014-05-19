import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;


public class TestLine2D {

private Line2d line, line2;
private Point a, b, c, d;

@Before
public void setUp(){
a = new Point();
b = new Point();
c = new Point();
d = new Point();
}

@Test(expected=EqualPointsException.class)
public void testLineCreation() throws EqualPointsException {
a.setLocation(1, 2);
b.setLocation(1, 2);
line = new Line2d(a, b);
}

@Test
public void testCalculateAngularFactor() throws EqualPointsException{
a.setLocation(1, 2);
b.setLocation(3, 4);
line = new Line2d(a, b);

assertEquals(1, line.calcAngularFactor());
}

@Test(expected=IllegalArgumentException.class)
public void testCalculateAngularFactorWithDivisionByZero() throws EqualPointsException{
a.setLocation(1, 2);
b.setLocation(1, 4);
line = new Line2d(a, b);

line.calcAngularFactor();
}

@Test
public void testIsIntersection() throws EqualPointsException{
a.setLocation(1, 2);
b.setLocation(3, 4);
line = new Line2d(a, b);

c.setLocation(5, 6);
d.setLocation(7, 8);
line2 = new Line2d(c, d);

assertFalse(line.intersection(line2));

d.setLocation(5, 8);

assertTrue(line.intersection(line2));
}
}