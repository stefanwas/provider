package com.abb.nps.mgntboard.filter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class FlatFilter {

	@XmlElement
	private String name;

	@XmlElement
	private final List<String> items = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String filterName) {
		this.name = filterName;
	}

	public List<String> getItems() {
		return items;
	}

}
