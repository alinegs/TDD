import java.awt.Point;


public class Line2d {

private Point a, b;

public Line2d(Point _a, Point _b) throws EqualPointsException {
if(_a.equals(_b)){
throw new EqualPointsException();
}

this.a = _a;
this.b = _b;
}

public Point getA() {
return a;
}

public Point getB() {
return b;
}

public int calcAngularFactor() {
if(this.b.x == this.a.x){
throw new IllegalArgumentException();
}
return ((this.b.y - this.a.y)/(this.b.x - this.a.x));
}

public boolean intersection(Line2d line) {
if(this.a.x == this.b.x)
return !(line.getA().x == line.getB().x && this.a.x != line.getA().x);
else if(line.getA().x == line.getB().x)
return true;
else
return this.calcAngularFactor() != line.calcAngularFactor();
}

}