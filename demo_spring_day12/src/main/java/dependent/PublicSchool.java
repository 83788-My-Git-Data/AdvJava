package dependent;

import dependency.Teacher;
import dependency.Coach;

public class PublicSchool implements School{

	private Teacher subjectTeacher;
	private Coach sportsCoach;
	private long fees;
	
	public PublicSchool(long fees,Teacher myTeacher)
	{
		this.fees=fees;
		this.subjectTeacher=myTeacher;
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher);
	}
	
	public void setSportsCoach(Coach sportsCoach) {
		this.sportsCoach = sportsCoach;
		System.out.println("in set sports coach ");
	}
//	B.L.
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();
		
	}
	public void organizeSportsEvent() {
		System.out.println("organizing sports event here.....");
		System.out.println(sportsCoach.getDailyWorkout());// depnt obj is using depcy !
	}
	
	public void Displaycurentfees() {
		System.out.println("current fees"+fees);
		
	}

	public static PublicSchool myFactoryMethod(long schoolFees, Teacher myTeacher, Coach sportsTrainer) {
		System.out.println("in factory method"); // SC
		PublicSchool school = new PublicSchool(schoolFees, myTeacher);
		school.sportsCoach = sportsTrainer;
		return school;
	}
	
//	custom destroy method
	public void anyInit() {
		System.out.println("in init"+ subjectTeacher);
	}
	
	public void anyDestroy()
	{
		System.out.println("in destroy " + subjectTeacher);
	}
}
