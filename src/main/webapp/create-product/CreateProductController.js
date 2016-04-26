(function() {
    'use strict';
    
    angular.module('shop').controller('CreateProductController', [
        createProductController
    ]);
    
    function createProductController() {
        var builder = dcodeIO.ProtoBuf.loadProtoFile("/protobuf-models/product.proto");
        var com = builder.build("com");
        var Product = com.caletre.shop.model.Product;
        var iceCream = new Product(47, 'Ice cream', '334132');
        var buffer = iceCream.encode();

        console.log(builder);
        console.log(iceCream);
        console.log(buffer);
    }
})();
