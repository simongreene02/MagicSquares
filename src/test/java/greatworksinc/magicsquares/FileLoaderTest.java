package greatworksinc.magicsquares;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


public class FileLoaderTest {
  @Test
  public void fromCSVtoList_positive() {
    assertThat(FileLoader.fromCSVtoList("positiveTest.csv"))
      .containsExactly("2", "7", "6", "5", "9", "1", "4", "3", "8")
      .inOrder();
  }
  @Test
  public void fromCSVtoList_emptyNegative() {
    assertThat(FileLoader.fromCSVtoList("emptyNegativeTest.csv"))
      .isEmpty();
  }
  @Test (expected = IllegalArgumentException.class)
  public void fromCSVtoList_negative() {
    FileLoader.fromCSVtoList("negativeTest.csv");
  }
  @Test
  public void fromCSVtoList_posttive2x2() {
    assertThat(FileLoader.fromCSVtoList("positiveTest2x2.csv"))
      .containsExactly("7", "5", "3", "8")
      .inOrder();
  }
}