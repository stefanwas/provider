package com.stefan.mgntboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.stefan.mgntboard.data.MockDataSource;
import org.apache.commons.lang.StringUtils;

import com.stefan.mgntboard.filter.Filter;
import com.stefan.mgntboard.filter.FilterData;
import com.stefan.mgntboard.filter.FilterItem;
import com.stefan.mgntboard.filter.FlatFilter;
import com.stefan.mgntboard.filter.HierarchicalFilter;

@Path("/")
public class FilterDataProvider {

	private static final String ACCESS_CONTROL = "Access-Control-Allow-Origin";

	private MockDataSource dataSource;

	@GET
	@Path("/filter/{filterName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Filter getFilterDataJson(@Context HttpServletResponse response, @PathParam("filterName") String filterName,
									@QueryParam("query") String query) {
		response.addHeader(ACCESS_CONTROL, "*");

		System.out.println(">>> REQ : [filterName=" + filterName + ",query=" + query + "]");

		return createFilter(filterName, query);
	}

	private Filter createFilter(String name, String query) {

		Filter filter = new Filter();
		filter.setName(name);
		
		List<String> items = this.dataSource.getFilterData(name);
		
		if (StringUtils.isNotBlank(query)) {
			items = filterByQueryText(items, query);
		}
		
		filter.getItems().addAll(items);

		return filter;
	}

	private List<String> filterByQueryText(List<String> items, String query) {
		List<String> result = new ArrayList<>();
		
		for (String item : items) {
			if (item.toLowerCase().contains(query.toLowerCase())) result.add(item);
		}
		return result;
	}

	
	// experiments below
	private List<FlatFilter> flatFilters = new ArrayList<>();
	private List<HierarchicalFilter> hierarchicalFilters = new ArrayList<>();

	@GET
	@Path("/json/filterData")
	@Produces(MediaType.APPLICATION_JSON)
	public FilterData getFlatFilterDataJson() {

		FilterData fData = new FilterData();
		fData.getFlatFilters().addAll(flatFilters);
		fData.getChierarchicalFilters().addAll(hierarchicalFilters);

		return fData;
	}

	@GET
	@Path("/xml/filterData")
	@Produces(MediaType.APPLICATION_XML)
	public FilterData getFlatFilterDataXml() {

		FilterData fData = new FilterData();
		fData.getFlatFilters().addAll(flatFilters);
		fData.getChierarchicalFilters().addAll(hierarchicalFilters);

		return fData;
	}

	public FilterDataProvider() {
		initFlatFilterContent();
		initHierarchicalFilterContent();
		System.out.println(">>>EventProviderStarted!");
	}

	private void initFlatFilterContent() {
		FlatFilter ffC1 = new FlatFilter();
		ffC1.setName("Action Type");
		ffC1.getItems().add("Create");
		ffC1.getItems().add("Update");
		ffC1.getItems().add("Read");
		ffC1.getItems().add("Delete");
		this.flatFilters.add(ffC1);

		FlatFilter ffC2 = new FlatFilter();
		ffC2.setName("Operation Mode");
		ffC2.getItems().add("Normal");
		ffC2.getItems().add("Stopped");
		ffC2.getItems().add("Running fast");
		ffC2.getItems().add("None");
		this.flatFilters.add(ffC2);

	}

	private void initHierarchicalFilterContent() {
		HierarchicalFilter hfC1 = new HierarchicalFilter();
		hfC1.setName("Country");
		hfC1.getFilterItems().add(
				createItem("PL", Arrays.asList("City 1", "City 2", "City 3")));
		hfC1.getFilterItems().add(
				createItem("DE", Arrays.asList("City A", "City B", "City C")));
		hfC1.getFilterItems().add(
				createItem("UK", Arrays.asList("Ala", "Bela", "Cela", "Gela")));
		this.hierarchicalFilters.add(hfC1);

		HierarchicalFilter hfC2 = new HierarchicalFilter();
		hfC2.setName("Devision");
		hfC2.getFilterItems().add(
				createItem("PL", Arrays.asList("City 1", "City 2", "City 3")));
		hfC2.getFilterItems().add(
				createItem("DE", Arrays.asList("City A", "City B", "City C")));
		hfC2.getFilterItems().add(
				createItem("UK", Arrays.asList("Ala", "Bela", "Cela", "Gela")));
		this.hierarchicalFilters.add(hfC2);

	}

	private FilterItem createItem(String name, List<String> subItems) {
		FilterItem item = new FilterItem();

		item.setName(name);
		item.getChildrenNames().addAll(subItems);

		return item;
	}

	public void setDataSource(MockDataSource dataSource) {
		this.dataSource = dataSource;
	}

}
