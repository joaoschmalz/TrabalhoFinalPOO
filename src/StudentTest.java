import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

class StudentTest{

	@Test
	void generateFinalGrades(){
		Student student = new Student("Jhon", 1);
		List<Paper> paperList = new ArrayList<>();

		Paper paper01 = new Paper(5f, 8f);
		paperList.add(paper01);
		Paper paper02 = new Paper(5f, 9f);
		paperList.add(paper02);

		student.setGrades(paperList);
		Assert.assertEquals(8.5f,student.generateFinalGrades());
	}
}