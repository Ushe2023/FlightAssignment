package com.one.pom;

import org.testng.annotations.DataProvider;

public class DataOne {

	@DataProvider()
	public Object[][] Data()
	{
		Object MyData[][]={
//				{"//span[text()= 'New Delhi(DEL)']","Del","//span[text()= 'Hyderabad(HYD)']","Hyd","17/12/2023"},
				           {"//span[text()= 'New Delhi(DEL)']","Del","//span[text()= 'Hyderabad(HYD)']","Hyd","22/12/2023"}};
//		                   {"//span[text()= 'New Delhi(DEL)']","Del","//span[text()= 'Hyderabad(HYD)']","Hyd","15/12/2023"},
//		                   {"//span[text()= 'New Delhi(DEL)']","Del","//span[text()= 'Hyderabad(HYD)']","Hyd","26/12/2023"},
//		                   {"//span[text()= 'New Delhi(DEL)']","Del","//span[text()= 'Hyderabad(HYD)']","Hyd","27/12/2023"}};
		return MyData;
	}
}