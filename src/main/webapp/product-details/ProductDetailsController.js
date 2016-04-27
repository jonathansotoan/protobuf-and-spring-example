(function() {
	'use strict';
	
	angular.module('shop').controller('ProductDetailsController', [
        '$http',
        productDetailsController
    ]);
	
	function productDetailsController($http) {
		var self = this;
		
		self.jsonProduct = '';
		
		var builder = dcodeIO.ProtoBuf.loadProtoFile("/protobuf-models/product.proto");
		var com = builder.build("com");
		var Product = com.caletre.shop.model.Product;
        
        $http.get('/rest/api/v1/products/25/json').then(function(response) {
            self.jsonProduct = response.data;
        });
        
        $http.get('/rest/api/v1/products/13/protobuf', {
            transformResponse: function(value) {
                return Product.decode64(value);
            }
        }).then(function(response) {
            self.protobufProduct = response.data;
        });
	}
})();