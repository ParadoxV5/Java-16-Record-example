package example;
/** Contract {@code interface} */
public interface Example {
  // Python-style getters
  int integer();
  String string();
  
  // Object identity
  @Override boolean equals(Object obj);
  @Override int hashCode();
  @Override String toString();
}