use master
drop database QL_LV4
create database QL_LV4
use QL_LV4
go

create table TaiKhoan(
	tenTK nvarchar(8) primary key not null,
	matKhau nvarchar(16) not null,
	quyen int not null,
)

create table Khoa(
	maKhoa int primary key identity(1,1) not null,
	tenKhoa nvarchar(50) not null,
	website nvarchar(20),
	sdt varchar(10),
	email varchar(20)
)

create table SinhVien(
	maSV nvarchar(8) primary key not null,
	hoTen nvarchar(50) not null,
	tenTK nvarchar(8) not null,
	gioiTinh bit not null,
	queQuan nvarchar(MAX),
	ngaySinh date,
	maKhoa int not null,  
	foreign key (maKhoa) references Khoa,
	foreign key (tenTK) references TaiKhoan
)

create table GiangVien(
	maGV nvarchar(8) primary key not null,
	hoTen nvarchar(50) not null,
	gioiTinh bit not null,
	maKhoa int not null, 
	sdt nvarchar(10),
	email nvarchar(20),
	foreign key (maKhoa) references Khoa
)

create table HocKy(
	maHK int primary key identity(1,1) not null,
	tenHK nvarchar(16) not null,
)


create table LuanVan(
	maLV int primary key identity(1,1) not null,
	tenLV nvarchar(50) not null,
	soLuongDK int not null,
	maGV nvarchar(8) not null,
	maKhoa int not null, 
	maHK int,
	foreign key (maKhoa) references Khoa,
	foreign key (maGV) references GiangVien,
	foreign key (maHK) references HocKy
)

create table PhieuDangKy(
	maPDK int primary key identity(1,1),
	maLV int not null, 
	maSV nvarchar(8) not null,
	diemTBvong1 float,
	diemTBvong2 float,
	ketQua bit,
	foreign key (maLV) references LuanVan,
	foreign key (maSV) references SinhVien
)

create table LoaiHoiDong(
	maLHD int primary key not null,
	tenLHD nvarchar(20) not null
)
--

create table HoiDong(
	maHD int primary key identity(1,1),
	maLHD int not null,
	ngayLap date,
	foreign key (maLHD) references LoaiHoiDong
)

create table ChiTietHoiDong(
	maHD int not null,
	maGV nvarchar(8) not null,
	primary key (maHD,maGV),
	foreign key (maHD) references HoiDong,
	foreign key (maGV) references GiangVien
)

create table PhanCong(
	maHD int not null,
	maPDK int not null,
	ngayPhanCong date,
	ngayBaoCao date,
	primary key (maHD,maPDK),
	foreign key (maHD) references HoiDong,
	foreign key (maPDK) references PhieuDangKy
)

create table PhieuDiem(
	maPD int primary key identity(1,1),
	maHD int not null,
	maPDK int not null,
	diemTB float,
	ngayNhapDiem date,
	ngayCapNhat date,
	foreign key (maHD,maPDK) references PhanCong
)

create table ChiTietPhieuDiem(
	maPD int,
	maGV nvarchar(8) not null,hh
	maHD int not null,
	diem float,
	primary key(maPD,maGV,maHD),
	foreign key (maPD) references PhieuDiem,
	foreign key (maHD,maGV) references ChiTietHoiDong
)
insert into TaiKhoan values('admin','123',2)
insert into LoaiHoiDong values(1,N'Thẩm định'),(2,N'Báo cáo')
insert into HocKy(tenHK) values(N'HKI-2020/2021')

insert into Khoa(tenKhoa,sdt,email,website) values(N'Công nghệ thông tin','0945139124','fitiuh@iuh.vn','fit.iuh.edu')
--
go
create function xemDSPhanCong_HK_Khoa_LoaiHoiDong(@maHK int,@maKhoa int,@maLHD int)
returns table
as
return(
	select pc.* from PhanCong pc join PhieuDangKy pdk on pc.maPDK = pdk.maPDK
		join LuanVan lv on lv.maLV = pdk.maLV join HoiDong hd on hd.maHD = pc.maHD
	where lv.maHK = @maHK and lv.maKhoa = @maKhoa and hd.maLHD = @maLHD
)
--
go
create function xemDSPhanCong_SV_OR_LuanVan(@tenSV nvarchar(30),@tenLV nvarchar(30))
returns table
as
return(
	select pc.* from PhanCong pc join PhieuDangKy pdk on pc.maPDK = pdk.maPDK
		join LuanVan lv on lv.maLV = pdk.maLV join SinhVien sv on sv.maSV = pdk.maSV
	where sv.hoTen like '%'+cast(@tenSV as nvarchar(30))+'%' or lv.tenLV like '%' + cast(@tenLV as nvarchar(30)) +'%'
)
--
go
create function demHoiDong_PhieuDangKy(@maPDK int,@maLHD int)
returns int
as
begin
	declare @phanCong int
	select @phanCong =count(pc.maHD)
	from PhanCong pc join HoiDong hd on pc.MaHD = hd.maHD
	where pc.maPDK = @maPDK and hd.maLHD = @maLHD
	return @phanCong
end
go


go
create function soLuongDiem(@maHK int,@maKhoa int,@tu float,@den float)
returns int
as
begin
	declare @soLuong int
	select @soLuong = count(pdk.diemTBvong2)
	from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV
	where ( lv.maHK = @maHK and lv.maKhoa = @maKhoa ) and ( diemTBvong2 >= @tu and diemTBvong2 < @den)
	return @soLuong
end

create function soLuongDangKy_TrongHK_Khoa(@maHK int,@maKhoa int)
returns int
as
begin
	declare @soLuong int
	select @soLuong = count(pdk.maPDK)
	from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV
	where lv.maHK = @maHK and lv.maKhoa = @maKhoa 
	return @soLuong
end

go
create function soLuongLV_TrongHK_Khoa(@maHK int,@maKhoa int)
returns int
as
begin
	declare @soLuong int
	select @soLuong = count(maLV)
	from LuanVan
	where maHK = @maHK and maKhoa = @maKhoa 
	return @soLuong
end

go
create function soLuongLV_Dat_TrongHK_Khoa(@maHK int,@maKhoa int)
returns int
as
begin
	declare @soLuong int
	select @soLuong = count(pdk.maPDK)
	from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV
	where lv.maHK = @maHK and lv.maKhoa = @maKhoa and ketQua = 1
	return @soLuong
end

go
create function soLuongLV_KhongDat_TrongHK_Khoa(@maHK int,@maKhoa int)
returns int
as
begin
	declare @soLuong int
	select @soLuong = count(pdk.maPDK)
	from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV
	where lv.maHK = @maHK and lv.maKhoa = @maKhoa and ketQua = 0
	return @soLuong
end

drop function diemTB_TrongHK_Khoa
go
create function diemTB_TrongHK_Khoa(@maHK int,@maKhoa int)
returns float
as
begin
	declare @soLuong float
	select @soLuong = AVG(pdk.diemTBvong2)
	from PhieuDangKy pdk join LuanVan lv on pdk.maLV = lv.maLV
	where lv.maHK = @maHK and lv.maKhoa = @maKhoa
	return @soLuong
end


--Chạy tất cả
--TK: Admin  pass: 123
