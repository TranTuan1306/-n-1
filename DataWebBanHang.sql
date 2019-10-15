USE [DatabaseBanHang]
GO
/****** Object:  Table [dbo].[catalog]    Script Date: 10/15/2019 9:04:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[catalog](
	[id] [int] NOT NULL,
	[name] [varchar](128) NULL,
	[parent_id] [int] NULL,
	[sort_oder] [tinyint] NULL,
 CONSTRAINT [PK_catalog] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[oder]    Script Date: 10/15/2019 9:04:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[oder](
	[transaction_id] [int] NULL,
	[id] [int] NOT NULL,
	[product_id] [int] NULL,
	[qty] [int] NULL,
	[amount] [decimal](15, 4) NULL,
	[data] [text] NULL,
	[status] [tinyint] NULL,
 CONSTRAINT [PK_oder] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[product]    Script Date: 10/15/2019 9:04:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] NOT NULL,
	[catalog_id] [int] NULL,
	[name] [varchar](100) NULL,
	[price] [decimal](15, 4) NULL,
	[content] [text] NULL,
	[discount] [int] NULL,
	[image_link] [varchar](50) NULL,
	[image_list] [text] NULL,
	[created] [int] NULL,
	[view] [int] NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[transaction]    Script Date: 10/15/2019 9:04:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transaction](
	[id] [int] NOT NULL,
	[status] [tinyint] NULL,
	[user_id] [int] NULL,
	[user_name] [varchar](50) NULL,
	[user_email] [varchar](50) NULL,
	[user_phone] [varchar](50) NULL,
	[amount] [decimal](15, 4) NULL,
	[payment] [varchar](32) NULL,
	[payment_info] [text] NULL,
	[message] [varchar](255) NULL,
	[security] [varchar](16) NULL,
	[created] [int] NULL,
 CONSTRAINT [PK_transaction] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[userr]    Script Date: 10/15/2019 9:04:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userr](
	[id] [int] NOT NULL,
	[name] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[phone] [varchar](15) NULL,
	[address] [varchar](128) NULL,
	[password] [varchar](40) NULL,
	[created] [int] NULL,
 CONSTRAINT [PK_userr] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[oder]  WITH CHECK ADD  CONSTRAINT [FK_oder_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([id])
GO
ALTER TABLE [dbo].[oder] CHECK CONSTRAINT [FK_oder_product]
GO
ALTER TABLE [dbo].[oder]  WITH CHECK ADD  CONSTRAINT [FK_oder_transaction] FOREIGN KEY([transaction_id])
REFERENCES [dbo].[transaction] ([id])
GO
ALTER TABLE [dbo].[oder] CHECK CONSTRAINT [FK_oder_transaction]
GO
ALTER TABLE [dbo].[product]  WITH CHECK ADD  CONSTRAINT [FK_product_catalog] FOREIGN KEY([catalog_id])
REFERENCES [dbo].[catalog] ([id])
GO
ALTER TABLE [dbo].[product] CHECK CONSTRAINT [FK_product_catalog]
GO
ALTER TABLE [dbo].[transaction]  WITH CHECK ADD  CONSTRAINT [FK_transaction_userr] FOREIGN KEY([user_id])
REFERENCES [dbo].[userr] ([id])
GO
ALTER TABLE [dbo].[transaction] CHECK CONSTRAINT [FK_transaction_userr]
GO
