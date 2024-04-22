# AbstractRoutingDataSource

### Post 요청 (Master)
curl -X POST http://localhost:8889/writeProduct \
-H "Content-Type: application/json" \
-d '{
    "productName": "Example Product",
    "productPrice": 500
}'

### Get 요청 (Slave)
curl -X GET http://localhost:8889/getProductList