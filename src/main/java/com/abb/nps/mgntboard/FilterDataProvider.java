package com.abb.nps.mgntboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.abb.nps.mgntboard.filter.FilterItem;
import com.abb.nps.mgntboard.filter.FilterData;
import com.abb.nps.mgntboard.filter.FlatFilter;
import com.abb.nps.mgntboard.filter.HierarchicalFilter;

@Path("/")
public class FilterDataProvider {
	
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
	
	
	
	private List<Event> events = new ArrayList<Event>();

	public FilterDataProvider() {
		init();
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
		hfC1.getFilterItems().add(createItem("PL", Arrays.asList("City 1", "City 2", "City 3")));
		hfC1.getFilterItems().add(createItem("DE", Arrays.asList("City A", "City B", "City C")));
		hfC1.getFilterItems().add(createItem("UK", Arrays.asList("Ala", "Bela", "Cela", "Gela")));
		this.hierarchicalFilters.add(hfC1);
		
		HierarchicalFilter hfC2 = new HierarchicalFilter();
		hfC2.setName("Devision");
		hfC2.getFilterItems().add(createItem("PL", Arrays.asList("City 1", "City 2", "City 3")));
		hfC2.getFilterItems().add(createItem("DE", Arrays.asList("City A", "City B", "City C")));
		hfC2.getFilterItems().add(createItem("UK", Arrays.asList("Ala", "Bela", "Cela", "Gela")));
		this.hierarchicalFilters.add(hfC2);
		
	}
	
	private FilterItem createItem(String name, List<String> subItems) {
		FilterItem item = new FilterItem();
		
		item.setName(name);
		item.getChildrenNames().addAll(subItems);
		
		return item;
	}

	private void init() {
		Event e1 = createEvent("Wojtek", "logged in");
		Event e2 = createEvent("Stefan", "logged out");
		Event e3 = createEvent("Marian", "waiting...");
		Event e4 = createEvent("Tomek:-)", "doing nothing");

		events.add(e1);
		events.add(e2);
		events.add(e3);
		events.add(e4);
	}
	
	@GET
	@Path("/json/events")
	@Produces(MediaType.APPLICATION_JSON)
	public EventContainer getEventsJson() {
		EventContainer log = new EventContainer();
		log.setEvents(this.events);
		return log;
	}

	@GET
	@Path("/xml/events")
	@Produces(MediaType.APPLICATION_XML)
	public EventContainer getEventsXml() {
		EventContainer log = new EventContainer();
		log.setEvents(this.events);
		return log;
	}

	@POST
	@Path("/addEvent")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void addApplicationEvent(Event event) {
		event.setDate(new Date());
		this.events.add(event);
	}

	
	
	
	private Event createEvent(String user, String desc) {

		Event e = new Event();
		e.setDate(new Date());
		e.setUser(user);
		e.setDescription(desc);

		return e;
	}
}
