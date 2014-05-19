public class Converter {

private int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

public Converter(){}

private int decodeRomanCharacter(char letter){
switch(letter){
case 'M': return 1000;
case 'D': return 500;
case 'C': return 100;
case 'L': return 50;
case 'X': return 10;
case 'V': return 5;
case 'I': return 1;
default: return 0;
}
}

public int romanToInt(String number) throws IllegalArgumentException{
if(number.length() == 0 || !allCharactersInRange(number))
throw new IllegalArgumentException();

int result=0, i=0, maxSize = number.length();

while(i < maxSize){
if(((i+1) < maxSize) && (decodeRomanCharacter(number.charAt(i+1)) > decodeRomanCharacter(number.charAt(i)))){
result += (decodeRomanCharacter(number.charAt(i+1)) - decodeRomanCharacter(number.charAt(i)));
i+=2;
}else{
result += decodeRomanCharacter(number.charAt(i));
i++;
}

}	

return result;
}

private boolean allCharactersInRange(String number) {
boolean ok;

for(int i=0; i<number.length(); i++){
ok = false;

for(String character_roman : letters){
if(Character.toString(number.charAt(i)).equals(character_roman)) ok = true;
}

if(!ok) return false;
}

return true;
}

public String intToRoman(int number) {
if(number <= 0 || number >= 4000)
throw new IllegalArgumentException();

String result = "";

for(int i=0; i<numbers.length; i++){
while(number >= numbers[i]){
result += letters[i];
number -= numbers[i];
}
}

return result;
}
}