delimiter //
create procedure sp_addProductToOder(
	in sName varchar(200),
    in sPhone varchar(11),
    in sAddress varchar(200),
	in sIdProduct integer,
    in sQuantity integer,
    in sPrice decimal(10),
    out sMessage varchar(200)
)
begin
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;  -- rollback any changes made in the transaction
    END;
	declare sOrderId integer;
    START TRANSACTION; 
	INSERT INTO `order` (`name`, `phone`, `address`) VALUES (sName, sPhone, sAddress);
    if(not exists (SELECT id FROM product where id = sIdProduct)) then 
		ROLLBACK;
    end if;
    set sOrderId = (SELECT Max(id) as id FROM `order`);
    
    INSERT INTO `orderitem` (`orderid`, `productid`, `quantity`, `price`) VALUES (sOrderId, sIdProduct, sQuantity, sPrice);
	COMMIT;

end;//


delimiter //
create procedure sp_insertWithTransation(
	IN email varchar(100),
    IN name varchar(100)
)
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;  -- rollback any changes made in the transaction
    END;
	START TRANSACTION;  
	INSERT INTO `users` (`email`, `name`) VALUES (email, name);
    INSERT INTO `users` (`email`, `name`) VALUES (email, name);
    COMMIT;
    
    ##INSERT INTO `users` (`email`, `name`) VALUES ("huytruc123", name);
END;