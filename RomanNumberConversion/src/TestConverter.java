import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestConverter {

private Converter converter;

@Before
public void setUp(){
converter = new Converter();
}

@Test(expected=IllegalArgumentException.class)
public void testRomanToIntEmptyString() {
converter.romanToInt("");
}

@Test(expected=IllegalArgumentException.class)
public void testRomanToIntNonRomanNumber() {
converter.romanToInt("123");
}

@Test
public void testConvertRomanToIntASimpleNumber(){
assertEquals(10, converter.romanToInt("X"));
assertEquals(1000, converter.romanToInt("M"));
}

@Test
public void testConvertRomanToIntACompoundNumber(){
assertEquals(16, converter.romanToInt("XVI"));
assertEquals(22, converter.romanToInt("XXII"));
}

@Test
public void testConvertRomanToIntASpecialNumber(){
assertEquals(14, converter.romanToInt("XIV"));
assertEquals(4, converter.romanToInt("IV"));
}

@Test(expected=IllegalArgumentException.class)
public void testIntToRomanWithZeroArgument(){
converter.intToRoman(0);
}

@Test(expected=IllegalArgumentException.class)
public void testIntToRomanWithNegativeArgument(){
converter.intToRoman(-5);
}

@Test(expected=IllegalArgumentException.class)
public void testIntToRomanWithHighArgument(){
converter.intToRoman(4000);
}

@Test
public void testConvertIntToRomanASimpleNumber(){
assertEquals("X", converter.intToRoman(10));
}

@Test
public void testConvertIntToRomanACompoundNumber(){
assertEquals("XXI", converter.intToRoman(21));
assertEquals("MDCLXVI", converter.intToRoman(1666));
}

@Test
public void testConvertIntToRomanASpecialNumber(){
assertEquals("XIX", converter.intToRoman(19));
}
}

