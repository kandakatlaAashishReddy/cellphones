create table product
(
  productid char(10) primary key,
  productname char(40),
  productdesc char(40),
  isproductavailable boolean,
rating float,
noitemssold int,
noreviews int
)
