package test;
import example.ClassExample;
/** Test for {@link ClassExample} */
class ClassExampleTest extends AbstractExampleTest<ClassExample> {
  @Override protected ClassExample constructor(int integer, String string) { return new ClassExample(integer, string); }
}