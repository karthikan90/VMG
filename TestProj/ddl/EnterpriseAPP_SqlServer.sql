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

  INSERT INTO [dbo].[Category] ([category_name]) VALUES ('Electronics')
  INSERT INTO [dbo].[Category] ([category_name]) VALUES ('Home Appliances')
  INSERT INTO [dbo].[Category] ([category_name]) VALUES ('Clothing')
