package test;
import example.RecordExample;
/** Test for {@link RecordExample} */
class RecordExampleTest extends AbstractExampleTest<RecordExample> {
  @Override protected RecordExample constructor(int integer, String string) { return new RecordExample(integer, string); }
}