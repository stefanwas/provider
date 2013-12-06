package com.abb.nps.mgntboard.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockDataSource {
	
	private String[] cardTypes = {"Green card", "Red card"};
	private String[] categories = {"Ability to manage complexity", 
			"Complete and timely quotes",
			"Ease of doing business",
            "Engineering / design capability",
            "Environment, Health and Safety",
            "Industry and application knowledge",
            "Issue resolution",
            "Lead time",
            "Commissioning support"};
	
	private String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Dakota", "North Carolina", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
	
	public List<String> getFilterData(String filterName) {
		switch (filterName) {
		case "cardTypes": return Arrays.asList(cardTypes);
		case "categories": return Arrays.asList(categories);
		case "states": return Arrays.asList(states);
		default: return new ArrayList<String>();
		}
	
	
	}


	
}
