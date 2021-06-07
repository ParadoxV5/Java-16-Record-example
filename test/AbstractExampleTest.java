package test;
import example.Example;
import org.junit.jupiter.api.Test;

/**
  {@link Test} template
  @param <T> the {@link Example} implementation to test
*/
abstract class AbstractExampleTest<T extends Example> extends org.junit.jupiter.api.Assertions {
  /** Common RNG for generating random fields */
  protected static java.util.Random random = new java.util.Random();
  /** The testee object */
  protected T object;
  /** @see {@link Example#integer} */
  protected int integer;
  /** @see {@link Example#string} */
  protected String string;
  
  /** Invoke the constructor with the given fields
    @return the {@code new T(…)}
  */
  protected abstract T constructor(int integer, String string);
  
  /** Test the constructor, populating the fields with random values while it does so */
  @org.junit.jupiter.api.BeforeEach void testConstructor() {
    integer = random.nextInt();
    string = random
      .ints(' ', '~' + 1)
      .limit(random.nextInt(Short.MAX_VALUE))
      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
      .toString()
    ;
    object = java.util.Objects.requireNonNull(constructor(integer, string));
  }
  
  /** Test the Python-style getters {@link Example#integer()} and {@link Example#string()} */
  @Test void testGetters() {
    assertEquals(integer, object.integer());
    assertEquals(string, object.string());
  }
  
  /** Test {@link Example#equals(Object)} (as if specified by {@link Object#equals(Object)}) */
  @Test @SuppressWarnings("unlikely-arg-type") void testEquals() {
    assertTrue(object.equals(object));
    assertTrue(object.equals(constructor(integer, string)));
    
    assertFalse(object.equals(constructor(-integer, string)));
    assertFalse(object.equals(constructor(integer, string + ' ')));
    
    assertFalse(object.equals(null));
    assertFalse(object.equals(Boolean.TRUE));
  }
  /** Test {@link Example#hashCode()} (no test-to-fails becuase it’s not required according to {@link Object#hashCode()}) */
  @Test void testHashCode() {
    int hashCode1 = object.hashCode();
    assertEquals(hashCode1, object.hashCode());
    assertEquals(hashCode1, constructor(integer, string).hashCode());
    System.out.print(hashCode1); // Log
  }
  
  /** Test, and <em>only test</em>, that the {@link Example#toString()} implementation returns non-{@code null} */
  @Test void testToStringNotNull() {
    String toString = object.toString();
    assertNotNull(toString);
    System.out.printf("\"%s\"", toString); // Log
  }
  
  /** New line after Log */
  @org.junit.jupiter.api.AfterAll static void printNewLine() { System.out.println(); }
}