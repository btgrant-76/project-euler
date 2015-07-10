package net.skeletonjack.projectEuler;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static net.skeletonjack.projectEuler.Eleven.ElevenGroup;
import static org.assertj.core.api.Assertions.assertThat;

public class ElevenTest {

  private static final int NUMBER_OF_HORIZONTAL_AND_VERTICAL_GROUPS = 17 * 20;

  private Eleven eleven;

  @Before
  public void setUp() {
    eleven = new Eleven();
  }

  @Test
  public void elevenConstructionParsesGridStringAsListOfLists() {
    final List<List<Integer>> theGrid = eleven.getGridRows();
    assertThat(theGrid.size()).isEqualTo(20);

    theGrid.stream().forEach(listOfStrings -> assertThat(listOfStrings.size()).isEqualTo(20));

    assertThat(theGrid.get(0))
        .containsSequence(8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8);

    assertThat(theGrid.get(19))
        .containsSequence(1, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67,
                          48);
  }

  @Test
  public void testGenerationOfHorizontalRowGroups() {
    List<List<Integer>> horizontalGroups = eleven.getHorizontalGroups();

    assertThat(horizontalGroups.size()).isEqualTo(NUMBER_OF_HORIZONTAL_AND_VERTICAL_GROUPS);

    assertThat(horizontalGroups.get(0)).containsSequence(8, 2, 22, 97);
    assertThat(horizontalGroups.get(1)).containsSequence(2, 22, 97, 38);
    assertThat(horizontalGroups.get(16)).containsSequence(50, 77, 91, 8);
    assertThat(horizontalGroups.get(horizontalGroups.size() - 1)).containsSequence(89, 19, 67, 48);
  }

  @Test
  public void testGenerationOfVerticalColumnGroups() {
    List<List<Integer>> verticalGroups = eleven.getVerticalGroups();

    assertThat(verticalGroups.size()).isEqualTo(NUMBER_OF_HORIZONTAL_AND_VERTICAL_GROUPS);

    assertThat(verticalGroups.get(0)).containsSequence(8, 49, 81, 52);
    assertThat(verticalGroups.get(1)).containsSequence(2, 49, 49, 70);
    assertThat(verticalGroups.get(19)).containsSequence(8, 0, 65, 91);
    assertThat(verticalGroups.get(verticalGroups.size() - 1)).containsSequence(36, 16, 54, 48);
  }

  @Test
  public void testGenerationOfDiagonalColumnGroups() {
    List<List<Integer>> diagonalGroups = eleven.getDiagonalGroups();

    assertThat(diagonalGroups).isNotNull();
    assertThat(diagonalGroups).isNotEmpty();
    assertThat(diagonalGroups.size()).isEqualTo(578);

    assertThat(diagonalGroups.get(0)).containsSequence(8, 49, 31, 23);
    assertThat(diagonalGroups.get(1)).containsSequence(97, 99, 49, 52);

    assertThat(diagonalGroups.get(576)).containsSequence(40, 4, 5, 48);
    assertThat(diagonalGroups.get(577)).containsSequence(36, 36, 57, 89);
  }

  @Test(expected = AssertionError.class)
  public void elevenGroupMayNotBeConstructedWithNull() {
    new ElevenGroup(null);
  }

  @Test
  public void elevenGroupMustBeConstructedWithCollectionOfFourIntegers() {
    new ElevenGroup(Arrays.asList(1, 2, 3, 4));
  }

  @Test(expected = AssertionError.class)
  public void anElevenGroupConstructedWithACollectionWithFewerThanFourIntegers() {
    new ElevenGroup(Arrays.asList(2, 3, 4));
  }

  @Test(expected = AssertionError.class)
  public void anElevenGroupConstructedWithACollectionWithMoreThanFourIntegers() {
    new ElevenGroup(Arrays.asList(1, 2, 3, 4, 5));
  }

  @Test
  public void elevenGroupProductIsTheProductOfNumbersFromTheConstructor() {
    assertThat(new ElevenGroup(Arrays.asList(2, 3, 4, 5)).getProduct()).isEqualTo(2 * 3 * 4 * 5);
    assertThat(new ElevenGroup(Arrays.asList(2, 0, 4, 5)).getProduct()).isEqualTo(0);
  }

  @Test
  public void elevenGroupsWithTheSameProductAreEqual() {
    ElevenGroup x = new ElevenGroup(Arrays.asList(2, 3, 4, 5));
    ElevenGroup y = new ElevenGroup(Arrays.asList(1, 1, 60, 2));

    assertThat(x).isEqualTo(y);
    assertThat(x.hashCode()).isEqualTo(y.hashCode());
  }

  @Test
  public void elevenGroupsWithDifferentProductsAreNotEqual() {
    ElevenGroup x = new ElevenGroup(Arrays.asList(2, 3, 4, 5));
    ElevenGroup y = new ElevenGroup(Arrays.asList(1, 9, 60, 2));

    assertThat(x).isNotEqualTo(y);
    assertThat(x.hashCode()).isNotEqualTo(y.hashCode());
  }

  @Test
  public void theLargestProductOfGroupsOfFourDigitsIs70_600_674() {
    assertThat(eleven.calculateLargestProduct()).isEqualTo(70_600_674);
  }

}
