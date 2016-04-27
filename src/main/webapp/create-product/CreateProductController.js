(function() {
    'use strict';
    
    angular.module('shop').controller('CreateProductController', [
        '$http',
        createProductController
    ]);
    
    function createProductController($http) {
        var builder = dcodeIO.ProtoBuf.loadProtoFile("/protobuf-models/product.proto");
        var com = builder.build("com");
        var Product = com.caletre.shop.model.Product;
        var iceCream = new Product(47, 'Ice cream', '334132');
        var buffer = iceCream.encode();

        console.log(builder);
        console.log(iceCream);
        console.log(buffer);
        
        var ProductList = com.caletre.shop.model.ProductList;
        $http.post('/rest/api/v1/products', iceCream, {
            headers: {
                'Accept': 'application/x-protobuf'
            },
            transformResponse: function(value) {
                return ProductList.encode(value);
            }
        }).then(function(response){
            
        });
    }
})();
