package com.stefan.mgntboard.filter;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilterData {

	@XmlElement
	private final List<FlatFilter> flatFilters = new ArrayList<>();
	
	@XmlElement
	private final List<HierarchicalFilter> chierarchicalFilters = new ArrayList<>();

	public List<FlatFilter> getFlatFilters() {
		return flatFilters;
	}

	public List<HierarchicalFilter> getChierarchicalFilters() {
		return chierarchicalFilters;
	}

}
