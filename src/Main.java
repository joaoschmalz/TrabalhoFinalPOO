import java.util.*;

public class Main{

	static String ANSWER_OPTIONS_MESSAGE = "Answer 1 for YES, 0 for NO";
	static String BREAK_LINE = "----- ----- -----";

	/*Considere que a disciplina pode conter diversos alunos e diversos trabalhos ou provas.
	Cada trabalho ou prova pode conter pesos diferentes na nota final.
	O sistema deve indicar para cada aluno a sua média final.*/

	public static void main(String[] args){

		int idStudents = 1;
		boolean close = false;

		ArrayList<Student> students = new ArrayList<>();

		Scanner scan = new Scanner(System.in);

		while (!close){

			System.out.println("1 - Register new student");
			System.out.println("2 - Register new paper");
			System.out.println("3 - Generate final grades");
			System.out.println("4 - Exit");

			int menuOption = scan.nextInt();
			switch (menuOption){
				case 1 -> {
					System.out.println("Inform Student name");
					Student student = new Student(scan.next(), idStudents);
					students.add(student);
					System.out.println("Student created:");
					System.out.println(student.getId() + " - " + student.getName());
					System.out.println(BREAK_LINE);
					idStudents++;
				}case 2 -> {
					if (!students.isEmpty()){
						System.out.println("Inform student id");
						Student student = searchStudent(students, scan.nextInt());
						if (student != null){
							System.out.println(student.getName() + " is the right one?");
							System.out.println(ANSWER_OPTIONS_MESSAGE);
							if(scan.nextInt() == 1){
								Paper.newPaper(student, student.getGrades());
							}
						}else{
							System.out.println("Student not found!");
						}
					}else{
						System.out.println("First register a new student");
					}
				}case 3 -> {
					if (!students.isEmpty()){
						for (Student student : students){
							if(!student.getGrades().isEmpty()){
								float avg = student.generateFinalGrades();

								System.out.printf("The final average for student " + student.getName()
									+ " is: %.1f%n", avg);
								System.out.println("----- ----- -----");
							}else{
								System.out.println(student.getName() + "Has no grades registered");
							}
						}
					}else{
						System.out.println("First register a new student");
					}
				}
				case 4 -> {
					close = true;
				}
			}
		}
	}

	public static Student searchStudent(List<Student> studentList, int idStudent){
		for (Student student : studentList){
			if (student.getId() == idStudent){
				return student;
			}
		}
		return null;
	}
}