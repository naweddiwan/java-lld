# APIs
## Search APIs
### Food Item Search API
#### Request
Food Item Name, filter...
#### Response
List\<FoodItem>

### Restaurant Search API
#### Request
Restaurant Name, filter...
#### Response
List\<Restaurant>


### GetRestaurantById
#### Request
Id
#### Response
Restaurant

### GetFoodItemById
#### Request
Id
#### Response
Food Item

### AddToCartAPI

#### Request
UserToken(for auth), fooditemid
#### Response
void

### PlaceOrderAPI

#### Request
UserToken(for auth), Cart, PaymentDetails
#### Response
Order

### Update Order API

#### Request
Token(Admin, User, Delivery), order_id, status 
#### Response
Void



