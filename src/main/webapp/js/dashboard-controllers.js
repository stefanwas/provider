/* Controllers */

angular.module('dashboard.controllers', ['ngResource'])
	.controller('FilterController', function($scope, $resource) {

		$scope.countries = [
			                   {name: "Europe",
								selected: true, 
			                 	items: [
				                    {name: "England", selected: true}, 
			                       	{name: "Spain", selected: true},
									{name: "Germany", selected: true},
			                     	{name: "Poland", selected: true},
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
		
	});

