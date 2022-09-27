
/**
	# Tao function don gian
SET GLOBAL log_bin_trust_function_creators = 1;
delimiter //
create function sumAB(a Integer, b Integer)
returns Integer
begin
	#if, else, while....
    #declare
	return a + b;
end //


# Tao procedure them san pham
delimiter //
create procedure sp_insertProduct(
	IN sMaSP char(4),
    IN sTenSP varchar(40),
    IN sDVT varchar(20),
    IN sNuocSX varchar(40),
    IN sGia decimal(10,2),
    OUT sMessage varchar(100)
)
begin
	declare flag boolean;
	set sMessage = "";
    set flag = true;	#Neu flag = true thi insert
	if(exists (SELECT MaSP FROM c6_quanlybanhang.sanpham where MaSP = sMaSP)) then
		set sMessage = "Ma SP da ton tai";
        set flag = false;
	end if;
    
	if(flag = true) then
		insert into sanpham(MaSP, TenSP, DVT, NuocSX, Gia) values (sMaSP, sTenSP, SDVT,sNuocSX, sGia);
        set sMessage = "Them thanh cong";
	end if;
end //
**/

delimiter //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_deposit_c6`(
	IN sFullName varchar(100),
    IN sEmail varchar(50),
    IN sPhone varchar(11),
    IN sAddress varchar(50),
    IN sTransactionAmount decimal(12,0)
)
begin
	declare total decimal(12,0);
    declare sCustomerId integer;
    
    # Kiem tra customer_id co ton tai hay chua
    if(not exists (SELECT `email` FROM `customers` where `email` = sEmail)) then 
		INSERT INTO `customers` (`full_name`, `email`, `phone`, `address`, `balance`, `deleted`) VALUES (sFullName, sEmail, sPhone, sAddress, '0', '0');
    end if;
    
    set sCustomerId = (SELECT id FROM `customers` where `email` = sEmail);
	INSERT INTO `deposits` (`created_at`, `deleted`, `customer_id`, `transaction_amount`) VALUES (now(), '0', sCustomerId, sTransactionAmount);
    
    set total = (SELECT balance from customers where id = sCustomerId);
    set total = total + sTransactionAmount;
    
    UPDATE `c5_banking`.`customers` SET `balance` = total WHERE (`id` = sCustomerId);

end; //





