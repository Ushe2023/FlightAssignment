package sagar;


import org.testng.annotations.DataProvider;

public class DataProviderConcept {
		//@DataProvider(parallel=true)
		@DataProvider
		public Object[][] pleaseProvideTheData()
		{
			Object[][] mydata= {{"New York","Bangkok","//span[@id='31/12/2023']"},
				/*	{"New York","Bangkok","//span[@id='20/12/2023']"},
					{"New York","Bangkok","//span[@id='30/12/2023']"},
					{"New York","Bangkok","//span[@id='20/01/2024']"},
					{"New York","Bangkok","//span[@id='12/01/2024']"}*/};
			return mydata;
		}	
}
