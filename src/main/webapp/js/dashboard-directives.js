/* Directives */

angular.module('dashboard.directives', [])
	.directive('hierarchicalFilter', function () {
	
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
	        templateUrl: 'templates/hierarchical-filter.tpl.html',
	        link : link
	    };
	})
	.directive('flatFilter', function () {
	
		function link(scope, element, attrs) {
			
			scope.changeMasterSelection = function(selection) {
				angular.forEach(scope.collection, function(item, index) {
					item.selected = selection;
				});
			};
	
			scope.$watch('collection', function () {
				angular.forEach(scope.collection, function(item, index) {
					if (!item.selected) {
						scope.master = false;
					};
				});
			}, true);		
		}
		
	    return {
	        restrict: 'E',
	        scope: {collection: '='},
	        templateUrl: 'templates/flat-filter.tpl.html',
	        link : link
	    };
	}) ;
