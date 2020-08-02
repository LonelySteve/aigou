# aigou | 爱购网

> JavaWeb 实训项目 - 爱购网

## 截图

### 前台首页

![前台首页效果](./images/index-front.jpg)

## 配置

> 更多配置请到 [application.yaml](src/main/resources/application.yaml) 和 [mybatis-config.xml](src/main/resources/mybatis-config.xml) 中直接进行修改

### 数据库

- [eshop.sql](sql/eshop.sql)

### 环境变量

- DB_PASSWORD：数据库密码

### nginx 和静态资源

出于节省空间的考虑，本存储库并不存储静态资源，原本放在 `src/main/resources/static` 路径下的静态资源文件需要额外下载。

使用 Nginx 提供静态资源访问服务，具体配置可以见 [nginx.conf](./nginx.conf)

#### 下载静态资源文件

> 链接：https://pan.baidu.com/s/1lwU89XD8YY79pEUYECRhKQ  
> 提取码：2333

将下载好的压缩包解压至本文件的所在目录下。

#### 静态资源文件夹文件结构

在本文件所在目录下使用 Linux 的 tree 工具查看文件结构：

`tree -L 2 ./static`

```shell
./static
├── css
│   ├── buyerTrade.css
│   ├── classify.css
│   ├── classify2.css
│   ├── deliverAddress.css
│   ├── font-awesome-4.7.0
│   ├── footer.css
│   ├── goodsDetail.css
│   ├── hp-base.css
│   ├── index.css
│   ├── login.css
│   ├── reset.css
│   ├── shoppingCart.css
│   └── top.css
├── iconfont
│   ├── demo.css
│   ├── demo_fontclass.html
│   ├── demo_symbol.html
│   ├── demo_unicode.html
│   ├── iconfont.css
│   ├── iconfont.eot
│   ├── iconfont.js
│   ├── iconfont.svg
│   ├── iconfont.ttf
│   └── iconfont.woff
├── img
│   ├── banner01.jpg
│   ├── banner02.jpg
│   ├── banner03.jpg
│   ├── banner04.jpg
│   ├── banner05.jpg
│   ├── bg1.jpg
│   ├── bg2.jpg
│   ├── bg3.jpg
│   ├── book01.jpg
│   ├── book02.jpg
│   ├── book03.jpg
│   ├── book04.jpg
│   ├── book05.jpg
│   ├── book06.jpg
│   ├── book07.jpg
│   ├── book08.jpg
│   ├── book09.jpg
│   ├── book10.jpg
│   ├── book11.jpg
│   ├── book12.jpg
│   ├── choose.PNG
│   ├── classify
│   ├── cloth01.jpg
│   ├── cloth02.jpg
│   ├── cloth03.jpg
│   ├── cloth04.jpg
│   ├── cloth05.jpg
│   ├── cloth06.jpg
│   ├── cloth07.jpg
│   ├── cloth08.jpg
│   ├── cloth09.jpg
│   ├── cloth10.jpg
│   ├── cloth11.jpg
│   ├── cloth12.jpg
│   ├── code.jpg
│   ├── detail
│   ├── global01.jpg
│   ├── global02.jpg
│   ├── global03.jpg
│   ├── global04.jpg
│   ├── global05.jpg
│   ├── group_bg.png
│   ├── indexbody_sprite.png
│   ├── login-bg.jpg
│   ├── login-icon.png
│   ├── logo.png
│   ├── mod01.jpg
│   ├── mod02.jpg
│   ├── mod03.jpg
│   ├── mod04.jpg
│   ├── mod05.jpg
│   ├── new.jpg
│   ├── new01.jpg
│   ├── new02.jpg
│   ├── new03.jpg
│   ├── new04.jpg
│   ├── new05.jpg
│   ├── new06.jpg
│   ├── rank01.jpg
│   ├── rank02.jpg
│   ├── rank03.jpg
│   ├── rank04.jpg
│   ├── rank05.jpg
│   ├── rank06.jpg
│   └── title-icon.jpg
├── js
│   ├── area.js
│   ├── banner.js
│   ├── base
│   ├── index
│   └── shop_cart
├── plugs
│   ├── jquery.js
│   ├── jqueryPagination
│   └── layer
└── upload
    ├── eshop
    └── img
```

可以用 [7z](https://www.7-zip.org/) 提供的数据校验功能校验 static.7z 压缩包和解压后的 static 文件夹：

##### static.7z

- SHA256 数据校验值：`D7B91A8768BDAD4F5D1DD2C8C669BE8A5ECA93BCF6F9B4022D6C833FBFAD522E`

##### static 文件夹

- SHA256 数据校验值：`6C32CA98B58F6F7227A102B432B08C3A94E5F2788B57AEA37BD6F3E39F7C7155`
- SHA256 数据及文件名校验值：`102BFF111BFB539C4BA0C6DD5BD09F7E039F888191283A2FDB04E2C3219B53F6`

## 启动

### 启动 nginx 服务

在本文件所处目录执行以下命令：

`nginx -c nginx.conf`

<!-- WIP 未完工 -->
