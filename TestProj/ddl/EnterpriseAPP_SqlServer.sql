CREATE TABLE Register (
  REGISTERID  int ,
  FIRSTNAME  VARCHAR(50),
  LASTNAME  VARCHAR(50) ,
  EMAIL  VARCHAR(50)  ,
  USERNAME VARCHAR(50),
  PASSWORD  VARCHAR(50) ,
  CONFIRMPASSWORD  VARCHAR(50) );

create table Category(
  category_id int primary key identity ,
  category_name varchar(50)
  )

create table SubCategory(
    sub_category_id int identity primary key,
                            sub_category_name varchar(50),
                            fk_category_id int references Category(category_id))
  INSERT INTO [dbo].[Category] ([category_name]) VALUES ('Electronics')
  INSERT INTO [dbo].[Category] ([category_name]) VALUES ('Home Appliances')
  INSERT INTO [dbo].[Category] ([category_name]) VALUES ('Clothing')

create table Products(id int primary key identity,product_name varchar(100),product_brand varchar(50),product_price int,product_quantity int,product_measurement varchar(50),fk_subcat_id int references SubCategory(sub_category_id),fk_cat_id int references Category(category_id));
