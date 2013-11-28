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
			
			$scope.cardTypes = [
			                    {name: "Green card", selected: false},
			                    {name: "Red card", selected: false}
			                    ];
			
			$scope.categories = [
			                    {name: "Ability to manage complexity", selected: false},
			                    {name: "Complete and timely quotes", selected: false},
			                    {name: "Ease of doing business", selected: false},
			                    {name: "Engineering / design capability", selected: false},
			                    {name: "Environment, Health and Safety", selected: false},
			                    {name: "Industry and application knowledge", selected: false},
			                    {name: "Issue resolution", selected: false},
			                    {name: "Lead time", selected: false},
			                    {name: "Commissioning support", selected: false}
			                    ];
			
			  $scope.selected = undefined;
			  $scope.states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Dakota', 'North Carolina', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];
			
		
	});

