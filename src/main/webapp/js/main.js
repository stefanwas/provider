
var eventDataProvider = 'http\\://localhost\\:8080/filter-data-provider/rest/json/events';
var filterDataProvider = 'http\\://localhost\\:8080/filter-data-provider/rest/json/filterData';

var managementDashboard = angular.module('managementDashboard', ['ngResource']);
var controllers = {};

controllers.FilterController = function($scope, $resource) {
	
	
	$scope.countries = [
	                   {groupName: "Europe",
						selected: false, 
	                 	subitems: [
		                    {name: "England", selected: false}, 
	                       	{name: "Spain", selected: false},
							{name: "Germany", selected: false},
	                     	{name: "Poland", selected: false},
							{name: "Portugal", selected: false},
	                     	{name: "Austria", selected: false},
							{name: "Russia", selected: false}]},
							
						{groupName: "Asia",
						 selected: false,
		                 subitems: [
							{name: "China", selected: false},
							{name: "Japan", selected: false},
							{name: "India", selected: false},
							{name: "Philipines", selected: false},
							{name: "Vietnam", selected: false}]
						}
						];
	
	$scope.changeMasterSelection = function(selection) {
		angular.forEach($scope.countries, function(group, index) {
			group.selected = selection;
			$scope.changeGroupSelection(group);
		});
	};

	$scope.changeGroupSelection = function(group) {
		angular.forEach(group.subitems, function(item, index) {
			item.selected = group.selected;
		});
	};
	
	$scope.$watch('countries', function () {
		angular.forEach($scope.countries, function(group, index) {
			if (!group.selected) {
				$scope.master = false;
			};
			angular.forEach(group.subitems, function(item, index) {
				if (!item.selected) {
					group.selected = false;
					$scope.master = false;
				}
			});
		});
	}, true);
	
	//------------------
	
	
	
	var filterDataService = $resource(filterDataProvider);
	
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

managementDashboard.directive('combo', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            scope.$watch(attr.myFocus, function (n, o) {
                if (n != 0 && n) {
                    element[0].focus();
                }
            });
        }
    };
});

managementDashboard.controller(controllers);

