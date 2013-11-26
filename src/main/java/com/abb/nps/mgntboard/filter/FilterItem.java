package com.abb.nps.mgntboard.filter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class FilterItem {

	@XmlElement
	private String name;
	
	@XmlElement
	private final List<String> childrenNames = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String itemName) {
		this.name = itemName;
	}

	public List<String> getChildrenNames() {
		return childrenNames;
	}

}
