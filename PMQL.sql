use master
go

create database PMQL
go

use PMQL
go

create table sanpham
(masp varchar(10) primary key not null,
tensp nvarchar(30) null,
mota nvarchar(max) null
)
go

create table dungtich
(madt varchar(10) primary key not null,
thetich nvarchar(30) null
)
go


create table chamsoc
(macs varchar(10) primary key not null,
theloai nvarchar(30) null
)
go

create table ctsanpham
(mactsp int identity(1,1) primary key not null,
soluong int null,
gia float null,
ketcau nvarchar(30) null,
madt varchar(10) not null,
macs varchar(10) not null,
masp varchar(10) not null,
constraint fk_dungtich_ctsanpham foreign key (madt) references dungtich(madt),
constraint fk_chamsoc_ctsanpham foreign key (macs) references chamsoc(macs),
constraint fk_sanpham_ctsanpham foreign key (masp) references sanpham(masp)
)
go

create table nhanvien
(manv varchar(10) primary key not null,
hoten nvarchar(30) not null,
tuoi int not null,
diachi nvarchar(30) not null,
sdt varchar(13) not null,
gioitinh bit not null,
email varchar(30) not null,
roles bit not null,
matkhau nvarchar(30) null
)
go

drop database PMQL
go

insert into sanpham(masp,tensp,mota) values('SP01',N'Sữa rửa mặt',N'yếu'),
('SP02',N'dầu gội',N'tốt'),('SP03',N'Kem nền',N'Tốt'),('SP04',N'che khuyết điểm',N'Khá'),('SP05',N'Tẩy trang',N'Tốt')
insert into ctsanpham(soluong,gia,ketcau,masp) values(1,1000,N'kem','SP01'),
(12,2000,N'lỏng','SP02'),(12,4000,N'lỏng','SP03'),(2,23000,N'Kem','SP04'),(9,9000,N'lỏng','SP05')

insert into chamsoc(macs,theloai ) values ('03',N'Môi')

insert into dungtich(madt,thetich ) values ('03',450)

insert into ctsanpham(soluong,gia,ketcau,madt,macs) values (1,1000,N'kem','01','02')

select * from dungtich

select * from sanpham


select * from ctsanpham

select ctsanpham.masp,tensp,soluong,gia,ketcau,thetich,theloai,mota from sanpham join ctsanpham on sanpham.masp=ctsanpham.masp join dungtich on dungtich.madt=ctsanpham.madt join chamsoc on chamsoc.macs=ctsanpham.macs 

select * from nhanvien