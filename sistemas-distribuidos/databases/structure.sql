CREATE TABLE [dbo].[Products](
	[idProduct] [int] NOT NULL,
	[nameProduct] [varchar](50) NULL,
	[stockProduct] [int] NULL,
	[imgProduct] [varchar](max) NULL,
	[priceProduct] [int] NULL,
	[idCategory] [int] NULL, 

    CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
    (
        [idProduct] ASC
    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
