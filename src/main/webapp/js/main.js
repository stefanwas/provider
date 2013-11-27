
var eventDataProvider = 'http\\://localhost\\:8080/filter-data-provider/rest/json/events';
var filterDataProvider = 'http\\://localhost\\:8080/filter-data-provider/rest/json/filterData';

var managementDashboard = angular.module('managementDashboard', ['ngResource']);
var controllers = {};

controllers.FilterController = function($scope, $resource) {
	
	
	$scope.countries = [
	                   {name: "Europe",
						selected: false, 
	                 	items: [
		                    {name: "England", selected: false}, 
	                       	{name: "Spain", selected: false},
							{name: "Germany", selected: false},
	                     	{name: "Poland", selected: false},
							{name: "Portugal", selected: false},
	                     	{name: "Austria", selected: false},
							{name: "Russia", selected: false}]},
							
						{name: "Asia",
						 selected: false,
		                 items: [
							{name: "China", selected: false},
							{name: "Japan", selected: false},
							{name: "India", selected: false},
							{name: "Philipines", selected: false},
							{name: "Vietnam", selected: false}]
						}
	];
	
	$scope.divisions = [
	                    {name: "Power Products",
	                    	selected: false, 
	                    	items: [
	                    	        {name: "Wiring Accessories", selected: false}, 
	                    	        {name: "Low Voltage", selected: false},
	                    	        {name: "Transformers", selected: false}
	                    	 ]
	                    },
	                    {name: "Low Voltage Products",
	                    	selected: false, 
	                    	items: [
	                    	        {name: "High Voltage", selected: false}, 
	                    	        {name: "Medium Voltage", selected: false},
	                    	        {name: "Transformers", selected: false}
	                    	        ]
	                    },
              	        {name: "Process Automation",
           	        	selected: false,
           	        	items: [
        	        	        {name: "Control Technologies", selected: false},
        	        	        {name: "Full Service", selected: false},
        	        	        {name: "Industry Solutions", selected: false},
        	        	        {name: "Marine and Cranes", selected: false},
        	        	        {name: "Measurement Products", selected: false},
        	        	        {name: "Service", selected: false},
        	        	        {name: "Turbocharging", selected: false}
        	        	        ]
               	        }
    ];
	
	

	
	//------------------
	
	console.log('XXXXXXXXXXXXX 1');
	
	var filterDataService = $resource(filterDataProvider);
	console.log('XXXXXXXXXXXX 2');
	
	filterDataService.get(function(result) {
		
//		$scope.flatFilters = result.filterData.flatFilters;
//		$scope.hierarchicalFilters = result.filterData.hierarchicalFilters;
		var flatFilters = result.filterData.flatFilters;
//		var hierarchicalFilters = result.filterData.hierarchicalFilters;
		
		var flatFiltersMap = {};
		for (var i=0; i<flatFilters.length; i++) {
			var filter = flatFilters[i];
			flatFiltersMap[filter.name] = filter.items;
		}
		$scope.flatFiltersMap = flatFiltersMap;
		
		
		console.log('This was the result 1:', result.filterData.flatFilters);
		console.log('This was the result 2:', result.filterData.hierarchicalFilters);

	});	

};

managementDashboard.controller(controllers);

managementDashboard.directive('dashboardFilter', function () {
	
	function link(scope, element, attrs) {
		
		scope.changeMasterSelection = function(selection) {
			angular.forEach(scope.collection, function(group, index) {
				group.selected = selection;
				scope.changeGroupSelection(group);
			});
		};

		scope.changeGroupSelection = function(group) {
			angular.forEach(group.items, function(item, index) {
				item.selected = group.selected;
			});
		};
		
		scope.$watch('collection', function () {
			angular.forEach(scope.collection, function(group, index) {
				if (!group.selected) {
					scope.master = false;
				};
				angular.forEach(group.items, function(item, index) {
					if (!item.selected) {
						group.selected = false;
						scope.master = false;
					}
				});
			});
		}, true);		
	}
	
    return {
        restrict: 'E',
        scope: {collection: '='},
        templateUrl: 'dashboard-filter.html',
        link : link
    };
});




