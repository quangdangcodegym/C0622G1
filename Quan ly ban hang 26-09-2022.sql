/**
# IN: trong 1 tap danh sach, hoac trong 1 cau select
SELECT MASP, TenSP
FROM sanpham
where NuocSX in (SELECT distinct NuocSX
from sanpham
where NuocSX = "Viet Nam" or NuocSX = "Trung Quoc") and (Gia >= 2000 and Gia <= 30000);

# tư khoa distint: Loại bỏ các giá trị trùng lặp. Sử dụng: sau từ khóa select
SELECT distinct NuocSX
from sanpham
where NuocSX = "Viet Nam" or NuocSX = "Trung Quoc" ;

# In ra danh sách các san pham ma khách hàng đã mua hàng trong ngày 1/1/2007.
select kh.MaKH, kh.HoTen, sp.TenSP, sp.Gia
from khachhang kh inner join hoadon hd on kh.MaKH = hd.MaKH
join cthd ct on ct.SoHD = hd.SoHoaDon join sanpham sp on sp.MaSP = ct.MaSP
where hd.NgayMuaHang = '2007-01-01';



#9. In ra danh sách các sản phẩm (MASP,TENSP) được khách hàng có tên “Nguyễn Văn A” mua trong háng 10/200
-- SELECT s.MASP, s.TENSP FROM SANPHAM s
-- JOIN CTHD ct ON s.MASP = ct.MASP
-- JOIN HOADON hd ON hd.SoHoaDon = ct.SoHD
-- JOIN KHACHHANG kh ON kh.MaKH  = hd.MaKH
-- WHERE kh.HOTEN = 'Nguyen Van A' AND hd.NgayMuaHang like '2006-10-%';

**/

#20. Trị giá trung bình của tất cả các hóa đơn được bán ra trong năm 2006 là bao nhiêu?
-- select round(avg(TriGia))
-- from hoadon
-- where NgayMuaHang like '2006-%-%' ;

#26. In ra danh sách các sản phẩm (MASP, TENSP) do “Trung Quốc” sản xuất 
#có giá bằng 1 trong 3 mức giá thấp nhất (của tất cả các sản phẩm).

select sp.MaSP, sp.TenSP, sp.Gia
from sanpham sp join (select * from sanpham 
group by Gia
order by Gia asc limit 0,3) as spmin on sp.Gia = spmin.Gia
where sp.NuocSX = 'Trung Quoc';



















