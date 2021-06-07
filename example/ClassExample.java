package example;
import java.util.Objects;
/** Conventional {@link Class class} implementation */
public class ClassExample implements Example {
  private final int integer;
  private final String string;
  
  /** Python-style getter
    @return {@link #integer}
  */
  @Override public int integer() { return integer; }
  /** Convenience method, get {@link Object} form of {@link #integer}
    @return {@link Integer#valueOf(int) Integer.valueOf(integer)}
  */
  protected Integer integerObject() { return Integer.valueOf(integer); }
  
  /** Python-style getter
    @return {@link #string}
  */
  @Override public String string() { return string; }
  
  /** Standard constructor 
    @param integer {@link #integer}
    @param string {@link #string}
  */
  public ClassExample(int integer, String string) {
    this.integer = integer;
    this.string = string;
  }
  
  /** Standard {@code equals} implementation */
  @Override public boolean equals(Object obj) {
    return (this == obj) || (
      obj instanceof ClassExample &&
      integer == ((ClassExample)obj).integer &&
      Objects.equals(string, ((ClassExample)obj).string)
    );
  }
  /** {@code hashcode} implementation using {@link Objects#hash} */
  @Override public int hashCode() {
    return Objects.hash(integerObject(), string);
  }

  /** {@code toString} implementation using {@link String#format} */
  @Override public String toString() {
    return String.format("ClassExample [integer=%s, string=%s]", integerObject(), string);
  }
}