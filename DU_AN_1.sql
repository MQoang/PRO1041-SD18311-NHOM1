CREATE DATABASE DuAn1
GO
USE DuAn1
GO

CREATE TABLE ChiTietPhieuGiaoHang (
	ID VARCHAR(10) PRIMARY KEY NOT NULL,
    MaChiTiet NVARCHAR(50) NOT NULL,
    MaSanPham NVARCHAR(50) NOT NULL,
    SoLuong INT NOT NULL,
    GiaBan DECIMAL(20, 0) NOT NULL,
);
GO

INSERT INTO ChiTietPhieuGiaoHang (ID, MaChiTiet, MaSanPham, SoLuong, GiaBan)
VALUES ('ID1','CT01', 'SP1', 5, 100000);
INSERT INTO ChiTietPhieuGiaoHang (ID, MaChiTiet, MaSanPham, SoLuong, GiaBan)
VALUES ('ID2','CT02', 'SP2', 12, 300000);
INSERT INTO ChiTietPhieuGiaoHang (ID, MaChiTiet, MaSanPham, SoLuong, GiaBan)
VALUES ('ID3','CT03', 'SP3', 4, 500000);
INSERT INTO ChiTietPhieuGiaoHang (ID, MaChiTiet, MaSanPham, SoLuong, GiaBan)
VALUES ('ID4','CT04', 'SP4', 2, 700000);
INSERT INTO ChiTietPhieuGiaoHang (ID, MaChiTiet, MaSanPham, SoLuong, GiaBan)
VALUES ('ID5','CT05', 'SP5', 9, 400000);

CREATE TABLE PhieuGiaoHang (
    MaPhieu NVARCHAR(50) NOT NULL PRIMARY KEY,
	ID VARCHAR(10) NOT NULL,
    MaKhachHang NVARCHAR(50) NOT NULL,
	TenKhachHang NVARCHAR(30) NOT NULL,
	SoDienThoai NVARCHAR(50) NOT NULL,
    NgayGiao DATE NOT NULL,
    DiaChiGiao NVARCHAR(500) NOT NULL,
    GhiChu NVARCHAR(500) NOT NULL,
    TongTien DECIMAL(20, 0) NOT NULL,
	
);
GO

INSERT INTO PhieuGiaoHang (MaPhieu, ID, MaKhachHang, TenKhachHang, SoDienThoai, NgayGiao, DiaChiGiao, GhiChu, TongTien)
VALUES ('MP1', 'ID1', 'KH01', N'Trịnh Duy Khánh', '0976637287', '2023-11-09', N'Hà Nội', N'Giao hàng nhanh', 500000);
INSERT INTO PhieuGiaoHang (MaPhieu, ID, MaKhachHang, TenKhachHang, SoDienThoai, NgayGiao, DiaChiGiao, GhiChu, TongTien)
VALUES ('MP2', 'ID2', 'KH02', N'Trần Tiến Đạt', '0372847384', '2023-11-22', N'Hải Phòng', N'Giao hàng nhanh', 100000);
INSERT INTO PhieuGiaoHang (MaPhieu, ID, MaKhachHang, TenKhachHang, SoDienThoai, NgayGiao, DiaChiGiao, GhiChu, TongTien)
VALUES ('MP3', 'ID3', 'KH03', N'Phan Văn Tuân', '0984628194', '2023-11-11', N'Hà Tĩnh', N'Giao hàng nhanh', 400000);
INSERT INTO PhieuGiaoHang (MaPhieu, ID, MaKhachHang, TenKhachHang, SoDienThoai, NgayGiao, DiaChiGiao, GhiChu, TongTien)
VALUES ('MP4', 'ID4', 'KH04', N'Phạm Văn A', '0976748272', '2023-11-13', N'TP Hồ Chí Minh', N'Giao hàng nhanh', 2200000);
INSERT INTO PhieuGiaoHang (MaPhieu, ID, MaKhachHang, TenKhachHang, SoDienThoai, NgayGiao, DiaChiGiao, GhiChu, TongTien)
VALUES ('MP5', 'ID5', 'KH05', N'Bùi Văn B', '0937276274', '2023-11-09', N'Hà Nội', N'Giao hàng nhanh', 3500000);

SELECT *
FROM PhieuGiaoHang
INNER JOIN ChiTietPhieuGiaoHang ON PhieuGiaoHang.ID = ChiTietPhieuGiaoHang.ID;

SELECT PhieuGiaoHang.MaPhieu,PhieuGiaoHang.ID, PhieuGiaoHang.MaKhachHang,PhieuGiaoHang.TenKhachHang,PhieuGiaoHang.SoDienThoai,PhieuGiaoHang.NgayGiao,
	DiaChiGiaoHang.MaDiaChi,TrangThaiGiaoHang.MaTrangThai,ChiTietPhieuGiaoHang.MaChiTiet,ChiTietPhieuGiaoHang.SoLuong,PhieuGiaoHang.GhiChu,PhieuGiaoHang.TongTien
                     FROM PhieuGiaoHang INNER JOIN ChiTietPhieuGiaoHang ON PhieuGiaoHang.ID=ChiTietPhieuGiaoHang.ID
										INNER JOIN DiaChiGiaoHang ON PhieuGiaoHang.MaDiaChi = DiaChiGiaoHang.MaDiaChi
										INNER JOIN TrangThaiGiaoHang ON PhieuGiaoHang.MaTrangThai = TrangThaiGiaoHang.MaTrangThai

SELECT PhieuGiaoHang.MaPhieu,PhieuGiaoHang.ID, PhieuGiaoHang.MaKhachHang,PhieuGiaoHang.TenKhachHang,PhieuGiaoHang.SoDienThoai,PhieuGiaoHang.NgayGiao,
                                             	PhieuGiaoHang.DiaChiGiao,PhieuGiaoHang.GhiChu,PhieuGiaoHang.TongTien,ChiTietPhieuGiaoHang.MaChiTiet,ChiTietPhieuGiaoHang.SoLuong
                                                                  FROM PhieuGiaoHang INNER JOIN ChiTietPhieuGiaoHang ON PhieuGiaoHang.ID = ChiTietPhieuGiaoHang.ID
CREATE TABLE KhachHang
(	id_ma INT IDENTITY(1,1) PRIMARY KEY ,
	tenKH NVARCHAR(50) NOT NULL, 
	email VARCHAR(50) NOT NULL, 
	soDienThoai VARCHAR(20) NOT NULL, 
	diaChi NVARCHAR(100),
	gioiTinh bit,
	ngaySinh DATE 
	)
GO
INSERT INTO KhachHang(tenKH, email, soDienThoai, diaChi, gioiTinh, ngaySinh)
VALUES 
    ( N'Phạm Tiến Dũng', N'dunghgbq1@gmail.com', N'0345668822', N'Hà Giang', 1, '2004-11-03'),
	(N'Nguyễn Xuân Thành', N'thanhxt@gmail.com', N'0345677777', N'Hà Nội', 1, '2004-10-05'),
	( N'Nguyễn Thúy Hằng', N'hangnt169@gmail.com', N'098234456', N'Hưng Yên', 0, '1999-10-07');


CREATE TABLE PhuongThucThanhToan (
    MaPhuongThuc NVARCHAR(50) PRIMARY KEY NOT NULL,
    TenPhuongThuc NVARCHAR(255) NOT NULL 
);
GO
INSERT INTO PhuongThucThanhToan (MaPhuongThuc, TenPhuongThuc)
VALUES ('SR12', N'Tiền mặt');
INSERT INTO PhuongThucThanhToan (MaPhuongThuc, TenPhuongThuc)
VALUES ('FA13', N'Chuyển khoản');
INSERT INTO PhuongThucThanhToan (MaPhuongThuc, TenPhuongThuc)
VALUES ('FA14', N'Chuyển khoản');
INSERT INTO PhuongThucThanhToan (MaPhuongThuc, TenPhuongThuc)
VALUES ('SM15', N'Chuyển khoản');
INSERT INTO PhuongThucThanhToan (MaPhuongThuc, TenPhuongThuc)
VALUES ('SM16', N'Tiền mặt');

CREATE TABLE DiaChiGiaoHang (
	Id VARCHAR(50) PRIMARY KEY ,
    MaDiaChi NVARCHAR(50) NOT NULL,
    DiaChi NVARCHAR(500) NOT NULL,
    GhiChu NVARCHAR(500) NOT NULL,
);
GO
INSERT INTO DiaChiGiaoHang (Id ,MaDiaChi, DiaChi, GhiChu)
VALUES ('1','MDC1', N'Ngõ 1 Kiều Mai', N'Giao hàng vào buổi sáng');
INSERT INTO DiaChiGiaoHang (Id, MaDiaChi, DiaChi, GhiChu)
VALUES ('2','MDC2', N'16 Lạc Long Quân', N'Giao hàng vào buổi chiều');
INSERT INTO DiaChiGiaoHang (Id, MaDiaChi, DiaChi, GhiChu)
VALUES ('3','MDC3',N'Quận 9 Thủ Đức', N'Giao hàng vào buổi sáng');
INSERT INTO DiaChiGiaoHang (Id, MaDiaChi, DiaChi, GhiChu)
VALUES ('4','MDC4',N'Ngõ 5 Phan Đình Phùng', N'Giao hàng vào buổi sáng');
INSERT INTO DiaChiGiaoHang (Id, MaDiaChi, DiaChi, GhiChu)
VALUES ('5','MDC5', N'123 Main St', N'Giao hàng vào buổi chiều');

CREATE TABLE NguoiNhanHang (
    MaNguoiNhan NVARCHAR(50) PRIMARY KEY NOT NULL,
    Id VARCHAR(50) ,
    HoTen NVARCHAR(255) NOT NULL,
    DienThoai VARCHAR(15) NOT NULL,
    FOREIGN KEY (Id) REFERENCES DiaChiGiaoHang(Id)
);
GO
SELECT NguoiNhanHang.MaNguoiNhan,NguoiNhanHang.Id,NguoiNhanHang.HoTen,NguoiNhanHang.DienThoai,DiaChiGiaoHang.MaDiaChi,DiaChiGiaoHang.DiaChi,DiaChiGiaoHang.GhiChu 
FROM NguoiNhanHang INNER JOIN DiaChiGiaoHang ON NguoiNhanHang.Id = DiaChiGiaoHang.Id

INSERT INTO NguoiNhanHang (MaNguoiNhan, Id, HoTen, DienThoai)
VALUES ('NNH111', '1', N'Trịnh Duy Khánh', '0963647382');
INSERT INTO NguoiNhanHang (MaNguoiNhan, Id, HoTen, DienThoai)
VALUES ('NNH114', '2', N'Trần Tiến Đạt', '0363846295');
INSERT INTO NguoiNhanHang (MaNguoiNhan, Id, HoTen, DienThoai)
VALUES ('NNH115', '3', N'Phan Văn Tuân', '0973627463');
INSERT INTO NguoiNhanHang (MaNguoiNhan, Id, HoTen, DienThoai)
VALUES ('NNH116', '4', N'Nguyễn Văn An', '0384528541');
INSERT INTO NguoiNhanHang (MaNguoiNhan, Id, HoTen, DienThoai)
VALUES ('NNH117', '5', N'Đoàn Trung Thành', '0965847364');

CREATE TABLE TrangThaiGiaoHang (
    MaTrangThai NVARCHAR(50) PRIMARY KEY NOT NULL,
    MaPhieu NVARCHAR(50) NOT NULL,
    ThoiGianCapNhat DATETIME NOT NULL,
    TrangThai VARCHAR(255) NOT NULL,
    FOREIGN KEY (MaPhieu) REFERENCES PhieuGiaoHang(MaPhieu)
);
GO
INSERT INTO TrangThaiGiaoHang (MaTrangThai, MaPhieu, ThoiGianCapNhat, TrangThai)
VALUES ('MTT01', 'MP1', '2023-11-09 08:00:00', 'Đang giao hàng');
INSERT INTO TrangThaiGiaoHang (MaTrangThai, MaPhieu, ThoiGianCapNhat, TrangThai)
VALUES ('MTT02', 'MP2', '2023-11-15 10:00:00', 'Đang giao hàng');
INSERT INTO TrangThaiGiaoHang (MaTrangThai, MaPhieu, ThoiGianCapNhat, TrangThai)
VALUES ('MTT03', 'MP3', '2023-11-17 09:20:00', 'Đang giao hàng');
INSERT INTO TrangThaiGiaoHang (MaTrangThai, MaPhieu, ThoiGianCapNhat, TrangThai)
VALUES ('MTT04', 'MP4', '2023-11-12 10:00:00', 'Đang giao hàng');
INSERT INTO TrangThaiGiaoHang (MaTrangThai, MaPhieu, ThoiGianCapNhat, TrangThai)
VALUES ('MTT05', 'MP5', '2023-11-10 14:30:00', 'Đang giao hàng');

CREATE TABLE HoaDon (
    MaHoaDon NVARCHAR(50) PRIMARY KEY NOT NULL,
    MaPhieu NVARCHAR(50) NOT NULL,
    NgayLap DATE NOT NULL,
    TongTien DECIMAL(20, 0) NOT NULL,
    MaPhuongThuc NVARCHAR(50) NOT NULL,  
	FOREIGN KEY (MaPhieu) REFERENCES PhieuGiaoHang(MaPhieu),
    FOREIGN KEY (MaPhuongThuc) REFERENCES PhuongThucThanhToan(MaPhuongThuc)
);
GO

INSERT INTO HoaDon(MaHoaDon,MaPhieu,NgayLap,TongTien,MaPhuongThuc)
VALUES ('HD11', 'MP1', '2023-11-20', 1000000, 'SR12');
INSERT INTO HoaDon(MaHoaDon,MaPhieu,NgayLap,TongTien,MaPhuongThuc)
VALUES ('HD12', 'MP2', '2023-11-20', 500000, 'SM15');
INSERT INTO HoaDon(MaHoaDon,MaPhieu,NgayLap,TongTien,MaPhuongThuc)
VALUES ('HD13', 'MP3', '2023-11-20', 2000000, 'FA14');


SELECT * FROM PhieuGiaoHang
SELECT * FROM ChiTietPhieuGiaoHang
SELECT * FROM DiaChiGiaoHang
SELECT * FROM HoaDon
SELECT * FROM KhachHang
SELECT * FROM NguoiNhanHang
SELECT * FROM TrangThaiGiaoHang





