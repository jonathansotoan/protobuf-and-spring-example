(function(){
	'use strict';
	
	angular.module('shop').controller('ProductList', [productListController]);
	
	function productListController() {
		var self = this;
		
		self.message = 'hello world';
	}
});