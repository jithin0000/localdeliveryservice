# Local Delivery Service
## Requirements
### Functional Requirements
- user can able to query availability of items, deliverable in one hour
- customer should be able to order multiple items in same time
### Non Functional Requirements
* should be fast < 100 milliseconds
* consistent no two user can purchase same product
* system should be able to handle 10k Delivery Centers and 100K items in catalogue
* order volume will be , 10million orders per day ( 1 core / day)

## Core Entities
* Item
* Inventory
* Distribution Center
* Order
* Order Item

## API
### Get Item Availability
```GET /v1/item/availability?lat=LAT&long=LONG&keyword={}&page=1&size=10```
``` {
  "items": [
    {
        "name": "Item1",
        "quantity": 10
    }
  ],
  "page": 1,
  "size": 10,
  "total_items": 100
```
### Post Order
``` POST /v1/order
{
    "lat": "LAT", 
    "long": "LONG",
    "items":["item1", "item2"]
}
RETURNS -> ORDER or FAILURE
```

## HIGH LEVEL DESIGN
1)  Customer should be able to query availability of items by location
   - Find all DC's Close enough which are in service
   - Search Item in that DC, search in the inventory and return union of them
   - it should be fast < 100 ms
2) Customer can create Order and reduce quantity 

## Deep Dive
### Read path
```
user send request -> API GATEWAY -> AvailabilityService -> 
find all DC near radius -> Elastic search ( excels @ read querie and 
aggregaration queries ) 
----------------------- ------------------------------------

Elastic search -> return sku_ids in the inventory -> featch item details from 
Catelogue service


```











