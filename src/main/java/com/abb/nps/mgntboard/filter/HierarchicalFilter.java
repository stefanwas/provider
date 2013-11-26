package com.abb.nps.mgntboard.filter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class HierarchicalFilter {

	@XmlElement
	private String name;

	@XmlElement
	private final List<FilterItem> filterItems = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String filterName) {
		this.name = filterName;
	}
	
	public List<FilterItem> getFilterItems() {
		return filterItems;
	}
	
	
}
