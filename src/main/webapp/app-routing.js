(function() {
    'use strict';
    
    angular.module('shop').config([
       '$routeProvider',
       routeConfig
   ]);
    
   function routeConfig($routeProvider) {
       $routeProvider.caseInsensitiveMatch = true;
       
       $routeProvider.when('/product-list', {
           templateUrl: 'product-list/product-list.html',
           controller: 'ProductListController',
           controllerAs: 'productListCtrl'
       }).otherwise('/product-list');
       
       $routeProvider.when('/create-product', {
           templateUrl: 'create-product/create-product.html',
           controller: 'CreateProductController',
           controllerAs: 'createProductCtrl'
       })
   }
})();