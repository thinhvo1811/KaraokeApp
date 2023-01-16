use Sample
Drop Database QLKaraoke
Create Database QLKaraoke
GO
ALTER DATABASE QLKaraoke SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE QLKaraoke SET ANSI_NULLS OFF 
GO
ALTER DATABASE QLKaraoke SET ANSI_PADDING OFF 
GO
ALTER DATABASE QLKaraoke SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE QLKaraoke SET ARITHABORT OFF 
GO
ALTER DATABASE QLKaraoke SET AUTO_CLOSE OFF 
GO
ALTER DATABASE QLKaraoke SET AUTO_SHRINK OFF 
GO
ALTER DATABASE QLKaraoke SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE QLKaraoke SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE QLKaraoke SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE QLKaraoke SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE QLKaraoke SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE QLKaraoke SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE QLKaraoke SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE QLKaraoke SET  DISABLE_BROKER 
GO
ALTER DATABASE QLKaraoke SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE QLKaraoke SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE QLKaraoke SET TRUSTWORTHY OFF 
GO
ALTER DATABASE QLKaraoke SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE QLKaraoke SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE QLKaraoke SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE QLKaraoke SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE QLKaraoke SET RECOVERY FULL 
GO
ALTER DATABASE QLKaraoke SET  MULTI_USER 
GO
ALTER DATABASE QLKaraoke SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE QLKaraoke SET DB_CHAINING OFF 
GO
ALTER DATABASE QLKaraoke SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE QLKaraoke SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QLKaraoke', N'ON'

GO
use QLKaraoke

/*Table: Chức Vụ*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[maChucVu] [nvarchar](10) NOT NULL,
	[tenChucVu] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[maChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Nhân Viên*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](10) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[ngaySinh] [date] NOT NULL,
	[soCMND] [nvarchar](10) NOT NULL,
	[soDT] [nvarchar](20) NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[maChucVu] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Tài Khoản*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenDangNhap] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
	[maNhanVien] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Khách Hàng*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](10) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[soDT] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Loại Dịch Vụ*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiDichVu](
	[maLoai] [nvarchar](10) NOT NULL,
	[tenLoai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiDichVu] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Dịch Vụ*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDichVu] [nvarchar](10) NOT NULL,
	[tenDichVu] [nvarchar](50) NOT NULL,
	[gia] [money] NOT NULL,
	[donViTinh] [nvarchar](10) NOT NULL,
	[soLuong] [int],
	[hanSuDung] [date],
	[trangThaiKD] [bit] NOT NULL,
	[maLoai] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Loại Phòng*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLoai] [nvarchar](10) NOT NULL,
	[tenLoai] [nvarchar](50) NOT NULL,
	[soNguoiToiDa] [int] NOT NULL,
	[giaPhong] [money] NOT NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[maLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Phòng*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [nvarchar](10) NOT NULL,
	[tenPhong] [nvarchar](50) NOT NULL,
	[maLoai] [nvarchar](10) NOT NULL,
	[trangThai] [bit] NOT NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Phiếu Đặt Phòng*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatPhong](
	[maPhieuDatPhong] [nvarchar](10) NOT NULL,
	[ngayDatPhong] [date] NOT NULL,
	[gioDatPhong] [time] (0) NOT NULL,
	[maKhachHang] [nvarchar](10) NOT NULL,
	[maPhong] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_PDP] PRIMARY KEY CLUSTERED 
(
	[maPhieuDatPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Hóa Đơn*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](10) NOT NULL,
	[ngayLapHD] [date] NOT NULL,
	[maNhanVien] [nvarchar](10),
	[maKhachHang] [nvarchar](10) NOT NULL,
	[maPhong] [nvarchar](10) NOT NULL,
	[gioVao] [time] (0) NOT NULL,
	[gioRa] [time] (0),
	[trangThai] [bit] NOT NULL,
CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

/*Table: Khách Hàng*/
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HoaDon](
	[maHoaDon] [nvarchar](10) NOT NULL,
	[maDichVu] [nvarchar](10) NOT NULL,
	[gia] [money] NOT NULL,
	[soLuong] [int] NOT NULL,
	[donViTinh] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_CT_HoaDonBan] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


GO
ALTER TABLE [dbo].[CT_HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CT_HoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CT_HoaDon] CHECK CONSTRAINT [FK_CT_HoaDon_HoaDon]
GO
ALTER TABLE [dbo].[CT_HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_CT_HoaDon_DichVu] FOREIGN KEY([maDichVu])
REFERENCES [dbo].[DichVu] ([maDichVu])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CT_HoaDon] CHECK CONSTRAINT [FK_CT_HoaDon_DichVu]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Phong]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([maChucVu])
REFERENCES [dbo].[ChucVu] ([maChucVu])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[DichVu]  WITH CHECK ADD  CONSTRAINT [FK_DichVu_LoaiDichVu] FOREIGN KEY([maLoai])
REFERENCES [dbo].[LoaiDichVu] ([maLoai])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DichVu] CHECK CONSTRAINT [FK_DichVu_LoaiDichVu]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([maLoai])
REFERENCES [dbo].[LoaiPhong] ([maLoai])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PDP_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PDP_Phong]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PDP_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PDP_KhachHang]


GO
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu]) VALUES (N'CV001', N'NV Quản Lý')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu]) VALUES (N'CV002', N'NV Lễ Tân')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu]) VALUES (N'CV003', N'NV Phục Vụ')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu]) VALUES (N'CV004', N'NV Bảo Vệ')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu]) VALUES (N'CV005', N'NV Kỹ Thuật')
GO
INSERT [dbo].[NhanVien] ([maNhanVien],[tenNhanVien],[gioiTinh],[ngaySinh],[soCMND],[soDT],[diaChi],[maChucVu]) VALUES (N'NV001', N'Tô Thị Minh Hồng', 0, CAST(N'2001-01-01' AS Date), N'123456789', N'0123456789',N'TP. HCM',N'CV001')
INSERT [dbo].[NhanVien] ([maNhanVien],[tenNhanVien],[gioiTinh],[ngaySinh],[soCMND],[soDT],[diaChi],[maChucVu]) VALUES (N'NV002', N'Hoàng Thị Ngọc Như', 0, CAST(N'2002-01-01' AS Date), N'123456789', N'0123456789',N'TP. HCM',N'CV002')
INSERT [dbo].[NhanVien] ([maNhanVien],[tenNhanVien],[gioiTinh],[ngaySinh],[soCMND],[soDT],[diaChi],[maChucVu]) VALUES (N'NV003', N'Võ Quốc Thịnh', 1, CAST(N'2002-11-18' AS Date), N'123456789', N'0123456789',N'Bình Thuận',N'CV003')

delete ChucVu where maChucVu='CV003'

select * from NhanVien where maNhanVien='NV002'

select tenDangNhap, matKhau, tk.maNhanVien from TaiKhoan tk join NhanVien nv on tk.maNhanVien = nv.maNhanVien

select maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, nv.maChucVu, tenChucVu from NhanVien nv join ChucVu cv on nv.maChucVu = cv.maChucVu
select maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, nv.maChucVu, tenChucVu from NhanVien nv join ChucVu cv on nv.maChucVu = cv.maChucVu where ngaySinh = '2002-11-18'
select maNhanVien, tenNhanVien, gioiTinh, ngaySinh, soCMND, soDT, diaChi, nv.maChucVu, tenChucVu from NhanVien nv join ChucVu cv on nv.maChucVu = cv.maChucVu where nv.maChucVu = 'CV001'

select maPhong, tenPhong, trangThai,p.maLoai,tenLoai,giaPhong from Phong p join LoaiPhong lp on p.maLoai = lp.maLoai
select maPhong, tenPhong, trangThai,p.maLoai,tenLoai,giaPhong from Phong p join LoaiPhong lp on p.maLoai = lp.maLoai

select maDichVu, tenDichVu, gia, donViTinh, soLuong, hanSuDung, trangThaiKD, dv.maLoai, tenLoai from DichVu dv join LoaiDichVu ldv on dv.maLoai = ldv.maLoai

insert into DichVu values(N'DV002',N'Trái cây',20000,N'Dĩa',null,null,1,N'LDV001')

SELECT * FROM KhachHang WHERE maKhachHang like '%001%' and tenKhachHang like '%%' and gioiTinh like '%%' and soDT like '%%' 

select maPhong, tenPhong,p.maLoai,tenLoai,giaPhong,trangThai from Phong p join LoaiPhong lp on p.maLoai = lp.maLoai WHERE maPhong like '%%' and tenPhong like '%%' and tenLoai like '%%' and trangThai like '%%' 
 
select maDichVu, tenDichVu, gia, donViTinh, soLuong, hanSuDung, trangThaiKD, dv.maLoai, tenLoai from DichVu dv join LoaiDichVu ldv on dv.maLoai = ldv.maLoai WHERE maDichVu like '%%' and tenDichVu like '%%' and gia like '%%' and donViTinh like '%%' and soLuong is null and hanSuDung is null and trangThaiKD like '%%' and dv.maLoai like '%%'

insert into DichVu values('DV014','Trái cây',20000,'Dĩa',-1,'',1,'LDV003')

SELECT * FROM DichVu

select maPhieuDatPhong, pdp.maKhachHang, tenKhachHang, pdp.maPhong, tenPhong, ngayDatPhong, gioDatPhong from (PhieuDatPhong pdp join KhachHang kh on pdp.maKhachHang = kh.maKhachHang) join Phong p on pdp.maPhong = p.maPhong

insert into PhieuDatPhong values(N'PDP001','2022-10-25','08:10:00',N'KH001',N'P003')

SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong

insert into HoaDon values(N'HD001','2022-10-15',N'NV003',N'KH001',N'P002','08:10:00','00:00:00',0)



delete HoaDon where maHoaDon='HD001'

SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, KhachHang.soDT, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.trangThai FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong


SELECT KhachHang.soDT FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE HoaDon.maHoaDon = 'HD002'
select *  from [dbo].[DichVu] where soLuong <= 60

SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.maLoai, LoaiDichVu.tenLoai FROM DichVu INNER JOIN LoaiDichVu ON DichVu.maLoai = LoaiDichVu.maLoai where tenLoai = ''

SELECT donViTinh FROM     DichVu where tenDichVu = 'Bia 333'

SELECT PhieuDatPhong.maPhieuDatPhong, PhieuDatPhong.ngayDatPhong, PhieuDatPhong.maPhong, Phong.tenPhong
FROM     PhieuDatPhong INNER JOIN
                  Phong ON PhieuDatPhong.maPhong = Phong.maPhong



SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.maLoai,LoaiDichVu.tenLoai FROM DichVu INNER JOIN LoaiDichVu ON DichVu.maLoai = LoaiDichVu.maLoai where tenLoai = N'Bia'

select * from ChucVu

ALTER TABLE HoaDon
ADD tongTienPhong [money];

select * from HoaDon

select * from CT_HoaDon where maHoaDon = 'HD013' and maDichVu = 'DV001'

delete CT_HoaDon where maHoaDon = 'HD014'

SELECT ngayLapHD FROM HoaDon where maHoaDon = 'HD001'

SELECT HoaDon.maKhachHang, KhachHang.tenKhachHang FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang where maHoaDon = 'HD001'

SELECT tongTienPhong FROM HoaDon where maHoaDon = 'HD005'

SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, NhanVien.tenNhanVien, HoaDon.maKhachHang, KhachHang.tenKhachHang, HoaDon.maPhong, Phong.tenPhong, HoaDon.gioVao, HoaDon.gioRa, HoaDon.trangThai, HoaDon.tongTienPhong FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN Phong ON HoaDon.maPhong = Phong.maPhong WHERE ngayLapHD like '2022-11-17'

select * from HoaDon


SELECT * FROM  "HoaDon"  WHERE  "HoaDon"."trangThai"  = 0


select maHoaDon, maNhanVien, maKhachHang, maPhong, tongTien = tongTienPhong from HoaDon

SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, NhanVien.tenNhanVien, KhachHang.tenKhachHang, Phong.tenPhong, tongTien = tongTienPhong+SUM(gia*soLuong)
FROM     CT_HoaDon INNER JOIN
                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN
                  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN
                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN
                  Phong ON HoaDon.maPhong = Phong.maPhong
Group by HoaDon.maHoaDon, HoaDon.ngayLapHD, NhanVien.tenNhanVien, KhachHang.tenKhachHang, Phong.tenPhong, HoaDon.tongTienPhong
UNION
SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, NhanVien.tenNhanVien, KhachHang.tenKhachHang, Phong.tenPhong, tongTien = tongTienPhong
FROM   HoaDon INNER JOIN
                  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN
                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN
                  Phong ON HoaDon.maPhong = Phong.maPhong
where HoaDon.maHoaDon not in (SELECT HoaDon.maHoaDon
FROM     CT_HoaDon INNER JOIN
                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon
Group by HoaDon.maHoaDon, HoaDon.ngayLapHD, HoaDon.maNhanVien, HoaDon.maKhachHang, HoaDon.maPhong, HoaDon.tongTienPhong)

delete HoaDon where tongTienPhong = 0

SELECT HoaDon.maHoaDon, HoaDon.ngayLapHD, CT_HoaDon.maDichVu, NhanVien.maNhanVien, NhanVien.tenNhanVien, KhachHang.maKhachHang, KhachHang.tenKhachHang, Phong.maPhong, Phong.tenPhong
FROM     CT_HoaDon INNER JOIN
                  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN
                  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN
                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN
                  Phong ON HoaDon.maPhong = Phong.maPhong

select * from PhieuDatPhong

select [maPhieuDatPhong],FORMAT ( [ngayDatPhong], 'dd-MM-yyyy') as NgayDP,
convert(varchar,[gioDatPhong] , 108) as G,KhachHang.tenKhachHang, Phong.tenPhong
FROM            KhachHang INNER JOIN
                         PhieuDatPhong ON KhachHang.maKhachHang = PhieuDatPhong.maKhachHang INNER JOIN
                         Phong ON PhieuDatPhong.maPhong = Phong.maPhong

SELECT [maHoaDon], FORMAT ( [ngayLapHD] , 'dd-MM-yyyy') as NLHD,[tenNhanVien],[tenKhachHang],Phong.maPhong,
convert(varchar,[gioVao] , 108) as GV,
	CASE "HoaDon"."trangThai"
			WHEN 1 THEN N'Đã Thanh Toán'
			WHEN 0 THEN N'Chưa Thanh Toán'
		END as trangThai 
	    from   HoaDon INNER JOIN
                         KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN
                         NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN
                         Phong ON HoaDon.maPhong = Phong.maPhong 
		WHERE  "HoaDon"."trangThai"  = 0


SELECT CT_HoaDon.maDichVu, COUNT(CT_HoaDon.maDichVu) AS SOLUONG FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu GROUP BY (CT_HoaDon.maDichVu)
SELECT * FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu

SELECT CT_HoaDon.maDichVu, DichVu.tenDichVu, DichVu.donViTinh, DichVu.gia, soLuongBan = SUM(CT_HoaDon.soLuong), tongDoanhThu=SUM(CT_HoaDon.soLuong)*DichVu.gia 
FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu 
WHERE CT_HoaDon.maDichVu = 'DV002'
GROUP BY CT_HoaDon.maDichVu, DichVu.tenDichVu, DichVu.donViTinh, DichVu.gia
ORDER BY soLuongBan DESC

SELECT tongDoanhThu=SUM(CT_HoaDon.soLuong)*DichVu.gia
FROM CT_HoaDon INNER JOIN DichVu ON CT_HoaDon.maDichVu = DichVu.maDichVu 
WHERE CT_HoaDon.maDichVu = 'DV002'
GROUP BY CT_HoaDon.maDichVu, DichVu.tenDichVu, DichVu.donViTinh, DichVu.gia
HoaDon.maKhachHang, SUM(tongTienPhong) 

SELECT HoaDon.maKhachHang,  HoaDon.maHoaDon, tongTienPhong, SUM(gia*soLuong)
FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang  INNER JOIN CT_HoaDon ON HoaDon.maHoaDon = CT_HoaDon.maHoaDon
GROUP BY HoaDon.maKhachHang,  HoaDon.maHoaDon, tongTienPhong

SELECT *
FROM HoaDon INNER JOIN KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang
WHERE HoaDon.maKhachHang ='KH001'

GO
DROP VIEW TKKH_VIEW
GO
CREATE VIEW TKKH_VIEW AS
	SELECT KhachHang.maKhachHang, KhachHang.tenKhachHang, KhachHang.soDT, HoaDon.trangThai, tongTien = tongTienPhong+SUM(gia*soLuong)
	FROM     CT_HoaDon INNER JOIN
					  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon INNER JOIN
					  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN
					  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN
					  Phong ON HoaDon.maPhong = Phong.maPhong
	Group by KhachHang.maKhachHang, KhachHang.tenKhachHang, KhachHang.soDT, HoaDon.trangThai, tongTienPhong
	UNION
	SELECT KhachHang.maKhachHang, KhachHang.tenKhachHang, KhachHang.soDT, HoaDon.trangThai, tongTien = tongTienPhong
	FROM   HoaDon INNER JOIN
					  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN
					  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien INNER JOIN
					  Phong ON HoaDon.maPhong = Phong.maPhong
	where HoaDon.maHoaDon not in (SELECT HoaDon.maHoaDon
	FROM     CT_HoaDon INNER JOIN
					  HoaDon ON CT_HoaDon.maHoaDon = HoaDon.maHoaDon
	Group by HoaDon.maHoaDon)
SELECT  maKhachHang, tenKhachHang, soDT, trangThai, soLan = COUNT(tenKhachHang), tongHoaDon = SUM(tongTien)
FROM TKKH_VIEW
WHERE trangThai != 0
GROUP BY maKhachHang, tenKhachHang, soDT, trangThai
ORDER BY tongHoaDon DESC

SELECT  tongHoaDon = SUM(tongTien)
FROM TKKH_VIEW
WHERE maKhachHang = 'KH003'