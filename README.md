# ITSOL > Intern > Ex02 
Bài tập Ex02: Hướng đối tượng trong java

## Cấu trúc project
- main: Thực hiện view chính của chương trình
- bo: Mapping các bảng trong DB và java class
- dto: Class chuyển giao data giữa BO và View
- service: Thực hiện nghiệp vụ chức năng
- utils: Thực hiện các method chung

EXAMPLE

---------- Menu ----------

 1: Create Random 10 Car
 
 2: Create Random 10 Insurance
 
 3: Buy Car and Insurance
 
 4: Show Car
 
 Please select an option!
 
3

NameCar   NumberPlate   YearManufacture   TypeCar   HaveInsurance
Car #(0+1)   39904   1999   MediumCar   1
Car #(1+2)   79835   2011   ModernCar   1
Car #(2+3)   17746   2011   ModernCar   1
Car #(3+4)   84203   2004   MediumCar   0
Car #(4+5)   43321   1991   OldCar   1
Car #(5+6)   17875   2000   MediumCar   0
Car #(6+7)   72067   1984   OldCar   0
Car #(7+8)   26996   2009   ModernCar   0
Car #(8+9)   58008   1996   MediumCar   0
Car #(9+10)   91051   1980   OldCar   0
Car #(10+1)   37136   2007   ModernCar   1
Car #(11+2)   32245   1988   OldCar   1
Car #(12+3)   30391   1991   OldCar   0
Car #(13+4)   83809   2006   ModernCar   0
Car #(14+5)   24528   1987   OldCar   1
Car #(15+6)   22274   1988   OldCar   1
Car #(16+7)   69673   1995   OldCar   1
Car #(17+8)   31691   1999   MediumCar   1
Car #(18+9)   13299   1980   OldCar   1
Car #(19+10)   93306   1992   OldCar   1

Select a Car to Buy by NumberPlate
84203
NameInsurance           TypeInsurance
Insurance Package #(0+1)           C
Insurance Package #(1+2)           B
Insurance Package #(2+3)           C
Insurance Package #(3+4)           B
Insurance Package #(4+5)           B
Insurance Package #(5+6)           B
Insurance Package #(6+7)           C
Insurance Package #(7+8)           A
Insurance Package #(8+9)           B
Insurance Package #(9+10)           B

Please select an Insurance by Name to buy
Insurance Package #(0+1)

Invalid Package!
---------- Menu ----------

 1: Create Random 10 Car
 2: Create Random 10 Insurance
 3: Buy Car and Insurance
 4: Show Car
 Please select an option!
3

NameCar   NumberPlate   YearManufacture   TypeCar   HaveInsurance
Car #(0+1)   39904   1999   MediumCar   1
Car #(1+2)   79835   2011   ModernCar   1
Car #(2+3)   17746   2011   ModernCar   1
Car #(3+4)   84203   2004   MediumCar   0
Car #(4+5)   43321   1991   OldCar   1
Car #(5+6)   17875   2000   MediumCar   0
Car #(6+7)   72067   1984   OldCar   0
Car #(7+8)   26996   2009   ModernCar   0
Car #(8+9)   58008   1996   MediumCar   0
Car #(9+10)   91051   1980   OldCar   0
Car #(10+1)   37136   2007   ModernCar   1
Car #(11+2)   32245   1988   OldCar   1
Car #(12+3)   30391   1991   OldCar   0
Car #(13+4)   83809   2006   ModernCar   0
Car #(14+5)   24528   1987   OldCar   1
Car #(15+6)   22274   1988   OldCar   1
Car #(16+7)   69673   1995   OldCar   1
Car #(17+8)   31691   1999   MediumCar   1
Car #(18+9)   13299   1980   OldCar   1
Car #(19+10)   93306   1992   OldCar   1

Select a Car to Buy by NumberPlate
84203
NameInsurance           TypeInsurance
Insurance Package #(0+1)           C
Insurance Package #(1+2)           B
Insurance Package #(2+3)           C
Insurance Package #(3+4)           B
Insurance Package #(4+5)           B
Insurance Package #(5+6)           B
Insurance Package #(6+7)           C
Insurance Package #(7+8)           A
Insurance Package #(8+9)           B
Insurance Package #(9+10)           B

Please select an Insurance by Name to buy
Insurance Package #(1+2)

Successful Buying
---------- Menu ----------

 1: Create Random 10 Car
 2: Create Random 10 Insurance
 3: Buy Car and Insurance
 4: Show Car
 Please select an option!
Disconnected from the target VM, address: '127.0.0.1:57651', transport: 'socket'

Process finished with exit code 130
