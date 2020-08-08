# aigou | 爱购网

> JavaWeb 实训项目 - 爱购网  
> [点我前往演示地址](http://server.jloeve.top:59999/)

![前台首页演示](./images/index-front.jpg)

## 特性

### 概览

- 首页
  - 登录/注册入口（在已登录情况下显示用户名，并提供登出入口）
  - 搜索栏
  - 热搜关键字
  - 根据产品类型快速进行产品搜索的列表
  - 轮播图
  - 广告位
  - 新品榜
  - 销量排行榜
  - 分区
    - 全球进口
    - 服装服饰
    - 护肤美妆
    - 图书学习
- 搜索页
  - 登录/注册入口（在已登录情况下显示用户名，并提供登出入口）
  - 搜索栏
  - 热搜关键字
  - 根据产品类型快速进行产品搜索的列表
  - 指示当前搜索的产品类型名的面包屑导航栏（如果当前搜索结果没有产品，或者产品类型名不唯一则不会显示）
  - 品牌复选区域
    - 当没有提供产品类型查询参数时，将显示所有品牌
    - 当提供了产品类型查询参数时，仅显示与该产品类型一致的品牌
  - 搜索结果显示区域
    - 显示产品图片
    - 显示产品名称
    - 显示产品价格
    - 显示产品销量
- 详情页
  - 登录/注册入口（在已登录情况下显示用户名，并提供登出入口）
  - 搜索栏
  - 热搜关键字
  - 根据产品类型快速进行产品搜索的列表
  - 产品图片
  - 产品名
  - 产品价格
  - 产品订购数量与添加进购物车入口
  - 店家承诺
  - 最终还看
    - 显示产品图片
    - 显示产品名称
    - 显示产品价格
    - 显示产品销量
  - 商品介绍
- 登录页
  - 当验证码错误时自动更新验证码，后端也会使原先的验证码校验信息失效
  - 7 天免登录（通过 Cookie 实现）
- 注册页
  - 在前端校验两次输入密码是否一致
  - 当验证码错误时自动更新验证码，后端也会使原先的验证码校验信息失效

### 补充

- 搜索页接口（`/product/search`）可以接受三个查询参数：`product-type-uuid`，`brands` 和 `keyword`，分别代表了产品类型 UUID，品牌 UUID 和关键字查询参数，其中品牌名 UUID 可以包含多个要匹配的品牌 UUID，其中每一个 UUID 使用 ','（没有空格的英文半角逗号）进行分隔。三个参数可以任意组合，可以全部都使用，也可以全部都不使用，在这种情况下，搜索结果将是所有的产品。

## 工具链

### 开发环境

- Windows 10
- IntelliJ IDEA 2020.1.3 (Ultimate Edition)
- MySQL Workbench 8.0 CE
- Visual Studio Code v1.47.3

### 依赖

本项目使用了 SpringBoot 框架，使用了 mysql 驱动和 mybatis，下表仅列出其它被引入的的第三方库：

| 名称         | 版本  | 作用                           |
| ------------ | ----- | ------------------------------ |
| easy-captcha | 1.6.2 | 提供验证码生成及校验功能       |
| lombok       | -     | 以注解的方式更便捷地定义模型类 |

## 部署

### jar 包

可以在 [release 页面](https://github.com/LonelySteve/aigou/releases) 中直接下载已经打包好的 jar 包，也可以根据下面的指南从源码构建 jar 包。

#### 从源码构建 jar 包

为了从源码构建 jar 包，需要安装 Maven，推荐使用 Maven3，同时还需要有良好的网络。

> [Maven 下载安装](https://maven.apache.org/download.cgi)

获取源码有包括但不限于以下两种方式可供选择：

- 如果本地环境中安装了 git：在命令行中键入 `git clone https://github.com/LonelySteve/aigou.git` 来克隆本仓库
- 如果本地环境没有 git：点击 [此处](https://github.com/LonelySteve/aigou/archive/master.zip) 直接下载仓库主分支存档，或者前往  [release 页面](https://github.com/LonelySteve/aigou/releases) 下载其它版本的存档

在获取源码之后，如果得到的是压缩包，请先解压到某个目录。

在命令行中键入 `cd` 命令切换至源码根目录下。

> 可以使用 `ls`（在 Windows cmd 中为 `dir`）命令列出当前目录下的文件或文件夹以检查是否切换无误

在命令行中键入以下命令开始打包操作：

```shell
mvn clean package -DskipTests
```

第一次构建可能需要花费较多的时间，如果打包成功后就可以在输出日志中看见 `BUILD SUCCESS` 字样，此时就可以在当前工作目录下的 target 文件夹下找到类似 `aigou-x.x.x-SNAPSHOT.jar` 名称的 jar 包文件。

### 静态资源

> 本项目的静态文件中包含的图片资源来源不明，仅供学习使用，如涉及侵权，请及时和我联系。

出于节省空间的考虑，本存储库并不存储静态资源，原本放在 `src/main/resources/static` 路径下的静态资源文件需要额外下载，如果不部署静态资源，会导致访问页面时，无法加载图片和样式等资源。

使用 Nginx 提供静态资源访问服务，具体配置可以见 [nginx.conf](data/nginx.conf)。

#### 下载静态资源文件

> 链接：<https://pan.baidu.com/s/1lwU89XD8YY79pEUYECRhKQ>  
> 提取码：2333

将下载好的压缩包解压至 `data` 文件夹下。

#### 静态资源文件夹文件结构

可以在本文件所在目录下使用 Linux 的 tree 工具查看文件结构：

`tree -L 2 data/static`

```shell
data/static
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

### 配置运行环境

由于本项目使用 nginx 提供静态资源访问服务，使用 mysql 作为数据库，因此还需要安装配置好 nginx 和 mysql 环境，这里推荐使用 mysql8，mysql5 的版本需要修改下面环境变量中 DB_DRIVER_CLASS_NAME 中的值。

> [mysql 下载安装](https://dev.mysql.com/downloads/mysql/) | [nginx 下载安装](http://nginx.org/en/download.html)

#### 环境变量

在运行之前一定要先配置环境变量，在 Windows Powershell 中，使用 `$env:name="value"` 这样的形式即可配置环境变量。

| 环境变量名             | 含义           | 参考值                                            | 备注                                  |
| ---------------------- | -------------- | ------------------------------------------------- | ------------------------------------- |
| `DB_USERNAME`          | 数据库用户名   | `root`                                            |                                       |
| `DB_PASSWORD`          | 数据库密码     | `my-secret-pw`                                    |                                       |
| `DB_DRIVER_CLASS_NAME` | 数据库驱动类名 | `com.mysql.cj.jdbc.Driver`                        | mysql5 请使用 `com.mysql.jdbc.Driver` |
| `DB_URL`               | 数据库 URL     | `jdbc:mysql://localhost/aigou?serverTimezone=UTC` |                                       |

#### 数据库

可以使用 [dump.sql](sql/dump.sql) 文件恢复数据库，如果配置好环境变量，就可以在命令行中输入以下命令重建数据库：

```shell
mysql -uroot -p${DB_PASSWORD} < ./sql/eshop.sql
```

> 在 Windows cmd 下，环境变量的引用方式是使用百分号包含，在这里就是 `%DB_PASSWORD%`

#### 运行

首先在命令行中键入以下命令启动 nginx：

```shell
nginx -c ./data/nginx.conf
```

> 如果你在 Windows 下执行命令，请注意斜杠 `/` 不是 Windows 中的路径分隔符，反斜杠 `\` 才是

然后在命令行中键入以下命令启动服务：

```shell
java -jar ./target/aigou-x.x.x-SNAPSHOT.jar
```

> 注意在执行时替换为正确的版本

如果在输出日志中出现类似于 `Started AigouApplication in 6.485 seconds (JVM running for 7.456)` 的字样表明服务运行成功。

### Docker 支持

> [Docker 下载安装](https://docs.docker.com/get-docker/) | [Docker Compose 下载安装](https://docs.docker.com/compose/install/)

为了免去配置各种环境的烦恼，本项目还支持使用 Docker 部署服务。

> 由于没有 push image 到 Docker 仓库的计划，因此用户需要从源码中自行构建镜像。

在命令行中键入 `cd` 命令以切换到源码根目录下，之后键入以下命令拉取构建镜像并启动服务：

```shell
docker-compose up -d
```

如果要修改更具体的配置（例如环境变量等），需自行修改 [docker-compose.yml](temp/latest/docker-compose.yml) 文件。
