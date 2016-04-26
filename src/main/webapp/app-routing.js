(function() {
    'use strict';
    
    angular.module('shop').config([
       '$routeProvider',
       routeConfig
   ]);
    
   function routeConfig($routeProvider) {
       $routeProvider.when('/product-list', {
           templateUrl: 'product-list/product-list.html',
           controller: 'ProductListController'
       }).otherwise('/product-list');
   }
});