package com.stefan.mgntboard.filter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Filter {

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
