package dependency;

public class SwimmingCoach implements Coach{
	public SwimmingCoach()
	{
		System.out.println("In constructor:"+getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "swim 1000 meters as a warm up";
	}

}
