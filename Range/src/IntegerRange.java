public class IntegerRange {

private int minimum, maximum;

public IntegerRange(int minimum, int maximum){
this.minimum = minimum;
this.maximum = maximum;
}

public int getMinimum() {
return minimum;
}

public int getMaximum() {
return maximum;
}

public boolean inRange(int number) {
if(number >= this.minimum && number <= this.maximum)
return true;
else
return false;
}

public boolean existIntersection(IntegerRange range2) {
for(int i = this.minimum; i<= this.maximum; i++){
for(int j = range2.getMinimum(); j<= range2.getMaximum(); j++){
if(i == j)
return true;
}
}
return false;
}

public IntegerRange intersectionWith(IntegerRange range2) throws RangeNullException {
if(!this.existIntersection(range2))
throw new RangeNullException();

IntegerRange result;
int min = this.maximum, max = this.minimum;

for(int i=this.minimum; i<=this.maximum; i++){
for(int j=range2.getMinimum(); j<=range2.getMaximum(); j++){
if(i == j){
if(i < min)
min = i;
if(i > max)
max = i;
}

}
}

result = new IntegerRange(min, max);

return result;
}


}