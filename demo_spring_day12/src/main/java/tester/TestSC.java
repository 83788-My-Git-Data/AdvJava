package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.PublicSchool;
import dependent.School;

public class TestSC {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean_config.xml")){
			System.out.println("SC up n running");
			School mySchool = ctx.getBean("pub_school",
					PublicSchool.class);			
			mySchool.manageAcademics();
//			PublicSchool mySchool2 = ctx.getBean("pub_school",
//					PublicSchool.class);
//			System.out.println(mySchool==mySchool2);
//			
//			mySchool.manageAcademics();
			mySchool.organizeSportsEvent();
			mySchool.Displaycurentfees();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
