package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.PublicSchool;
import dependent.School;

public class TestSC {

	public static void main(String[] args) {
//		starting SC,xML based instruction , loaded from runtime class
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("bean_config.xml")) {
			System.out.println("SC up n running !");
			// get public school bean from SC
			School mySchool = ctx.getBean("pub_school",
					PublicSchool.class);
			//invoke B.L method
			mySchool.manageAcademics();
			School mySchool2 = ctx.getBean("pub_school",
					PublicSchool.class);
			System.out.println(mySchool==mySchool2);
		} // JVM - ctx.close() -> SC shutting down -> checks for singletons -> invokes
			// destroy method if added -> GC
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
