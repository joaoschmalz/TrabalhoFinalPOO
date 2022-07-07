import java.util.List;
import java.util.Scanner;

public class Paper
{

	private float weight;

	private float score;

	private int idStudent;

	public Paper(Float weight, Float score)
	{
		this.weight = weight;
		this.score = score;
	}

	public float getWeight()
	{
		return weight;
	}

	public void setWeight(float weight)
	{
		this.weight = weight;
	}

	public float getScore()
	{
		return score;
	}

	public void setScore(float score)
	{
		this.score = score;
	}

	public static void newPaper(Student student, List<Paper> grades){

		Scanner scan = new Scanner(System.in);

		System.out.println("Inform paper weight");
		float weight = scan.nextFloat();
		System.out.println("Inform paper score:");
		float score = scan.nextFloat();

		Paper paper = new Paper(weight, score);
		grades.add(paper);
		System.out.println("----- ----- -----");
		System.out.println("ADD new paper?");
		System.out.println("Answer 1 for YES, 0 for NO");

		if (scan.nextInt() == 1){
			newPaper(student, grades);
		}else{
			student.setGrades(grades);
		}
	}
}