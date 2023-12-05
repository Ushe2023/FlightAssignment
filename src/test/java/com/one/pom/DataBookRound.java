package com.one.pom;

import org.testng.annotations.DataProvider;

public class DataBookRound {

	@DataProvider()
	public Object[][] data(){
		
		Object MyData[][]= {{"//p[text()= 'John F. Kennedy International Airport']","New York","//p[text()= 'Suvarnabhumi Airport']",
			"Bangkok","17/01/2024","27/01/2024"},
			/*	{"//p[text()= 'John F. Kennedy International Airport']","New York","//p[text()= 'Suvarnabhumi Airport']",
				"Bangkok","01/01/2024","20/01/2024"},
				{"//p[text()= 'John F. Kennedy International Airport']","New York","//p[text()= 'Suvarnabhumi Airport']",
					"Bangkok","10/01/2024","28/01/2024"},
				{"//p[text()= 'John F. Kennedy International Airport']","New York","//p[text()= 'Suvarnabhumi Airport']",
						"Bangkok","23/12/2023","20/01/2024"},
				{"//p[text()= 'John F. Kennedy International Airport']","New York","//p[text()= 'Suvarnabhumi Airport']",
							"Bangkok","11/01/2024","24/01/2024"}*/
				};
		
		return MyData;
		
	}
}
