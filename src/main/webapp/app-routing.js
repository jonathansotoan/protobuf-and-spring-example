(function() {
    'use strict';
    
    angular.module('shop').config([
       '$routeProvider',
       routeConfig
   ]);
    
   function routeConfig($routeProvider) {
       $routeProvider.caseInsensitiveMatch = true;
       
       $routeProvider
           .when('/product-details', {
               templateUrl: 'product-details/product-details.html',
               controller: 'ProductDetailsController',
               controllerAs: 'productDetailsCtrl'
           })
           .otherwise('/product-details')
           .when('/create-product', {
               templateUrl: 'create-product/create-product.html',
               controller: 'CreateProductController',
               controllerAs: 'createProductCtrl'
           });
   }
})();