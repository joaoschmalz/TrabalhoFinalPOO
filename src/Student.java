import java.util.ArrayList;
import java.util.List;

public class Student
{
	private String name;

	private int id;

	private List<Paper> grades = new ArrayList<>();

	public Student(String name, int id)
	{
		this.name = name;
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public List<Paper> getGrades()
	{
		return grades;
	}

	public void setGrades(List<Paper> grades)
	{
		this.grades = grades;
	}

	public float generateFinalGrades(){

		List<Paper> papers = this.getGrades();
		float totalPoints = 0;
		float totalWeight = 0;
		for (Paper paper : papers){
			totalPoints += paper.getWeight() * paper.getScore();
			totalWeight += paper.getWeight();
		}
		return totalPoints / totalWeight;
	}
}
