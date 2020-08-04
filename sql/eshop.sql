/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - eshop
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE = ''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;
/*Table structure for table `s_brand` */

/*Table structure for table `s_product_type` */

DROP TABLE IF EXISTS `s_product_type`;

CREATE TABLE `s_product_type`
(
    `uuid`            binary(16)   NOT NULL COMMENT 'UUID',
    `name`            varchar(50)  NOT NULL COMMENT '分类名称',
    `desc`            varchar(500) DEFAULT NULL COMMENT '分类描述',
    `icon_class_name` varchar(100) NOT NULL COMMENT '分类图标',
    PRIMARY KEY (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_product_type` */

insert into `s_product_type`
values (UUID_TO_BIN('09c6fb444219476089a9d179682e423e'), '服装服饰', '时尚服装', 'icon-businesscard'),
       (UUID_TO_BIN('0ea5f6206acc4eac91e7ceae7a627279'), '旅游摄影', '旅游摄相机，无人机摄像', 'icon-video_fill'),
       (UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'), '国产食品', '国产食品', 'icon-headlines_fill'),
       (UUID_TO_BIN('29feb3d0ad4d4b86aabcaa80e435e29b'), '全球进口', '全球进口', 'icon-flag_fill'),
       (UUID_TO_BIN('2f95f6b82bf54b0bb065b3ac1463c6a8'), '家居用品', '家居用品', 'icon-qianniudaidise'),
       (UUID_TO_BIN('62b2dfbbd46648c49b194da5d3f305bf'), '文具', '学习用的文具，铅笔，钢笔。。。', 'icon-brush'),
       (UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'), '图书学习', '图书学习', 'icon-createtask_fill'),
       (UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'), '护肤美妆', '护肤美妆', 'icon-group_fill'),
       (UUID_TO_BIN('874668661dee4525845abd221bc3d6c7'), '教育', '学校教育', 'icon-remind'),
       (UUID_TO_BIN('b63db1becc614da598442d5a71994a49'), '现代科技', '现代科技电子产品', 'icon-customerservice_fill'),
       (UUID_TO_BIN('c341708f957d431a9707a8214235f9d2'), '亲子', '亲子类型产品', 'icon-group'),
       (UUID_TO_BIN('cde6ec051ed7492e85ebcc1132b69729'), '医疗健康', '医疗健康产品', 'icon-like_fill');

DROP TABLE IF EXISTS `s_brand`;

CREATE TABLE `s_brand`
(
    `uuid`            binary(16)  NOT NULL COMMENT 'uuid',
    `name`            varchar(50) NOT NULL COMMENT '名称',
    `type_uuid`       binary(16)  NOT NULL COMMENT '所属分类，即产品类型 uuid',
    `image_file_name` text        NOT NULL COMMENT '品牌图片文件名',
    PRIMARY KEY (`uuid`),
    FOREIGN KEY (`type_uuid`) REFERENCES `s_product_type` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_brand` */

insert into `s_brand`
values (UUID_TO_BIN('00760bcdda1145969338d6fe39181e9c'), '国产粮食', UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'),
        '2ed2579ebc584849975b78bcb5dc8f0d1a8e287a835c49119c50ed85488faade.jpg'),
       (UUID_TO_BIN('02b6fdb869534de3b1e5d0793c4f3640'), '粮食', UUID_TO_BIN('29feb3d0ad4d4b86aabcaa80e435e29b'),
        'f17d5bff1dea49dabe2dc3e7514e19db.jpg'),
       (UUID_TO_BIN('08d641c99ebc4eb0ac25a7969938c3b9'), '潘婷', UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        'd291113b7a884f5fa4c38118d3818e69.jpg'),
       (UUID_TO_BIN('0f49bbb6bde640f384529d0eee1f0291'), '柯达', UUID_TO_BIN('0ea5f6206acc4eac91e7ceae7a627279'),
        '5eef2904cce04c93aef1b7e2cdecc643.jpg'),
       (UUID_TO_BIN('1607d1e8d96c431694726d176cc50a4c'), '测试数据6', UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '1cfa558ba339411087fdfe127da62729d.jpg'),
       (UUID_TO_BIN('432a20b160de4fa4a2821812666a2860'), '蓝山咖啡', UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'),
        '50bed53ee180439b9d2680404a8087745a2234649c3145aa86ae0783a0cca28e.jpg'),
       (UUID_TO_BIN('4e47266bc70a49b6900f5d8ce7fd020e'), '文学', UUID_TO_BIN('874668661dee4525845abd221bc3d6c7'),
        '7f72145b18f249b7abc50affeadf245c73f5d6d3e07047708dc808260d8af56b.jpg'),
       (UUID_TO_BIN('4fc866a5443d4868870fc1bc2496388b'), '雅诗兰黛', UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        'd939e33d3c284ed2a66122ba9bffc83e5f61d24ee6914832a5d5b1a8b70c689b.jpg'),
       (UUID_TO_BIN('50e5c6a2e46f417582b2bbe915cda417'), '启航', UUID_TO_BIN('c341708f957d431a9707a8214235f9d2'),
        'f85e2aa60dca4da5a4ae93d1d6c195a10cba9212ead148589f1986d94ee8018f.jpg'),
       (UUID_TO_BIN('612d96a54b3a4f6f9a3ba8ee51c324a3'), '测试数据2', UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '01789a99773349faa01b67795605b432gyy3.jpg'),
       (UUID_TO_BIN('62367ebe78464b98bbf1c2b0068b57c2'), '生命水', UUID_TO_BIN('cde6ec051ed7492e85ebcc1132b69729'),
        '9e8a36fa65564126ac377c3542add38f1cea6a7ef6c64786a56cdc0edf5af1f6.jpg'),
       (UUID_TO_BIN('834b468b686e46f8bed20c4064176d8d'), 'vue', UUID_TO_BIN('b63db1becc614da598442d5a71994a49'),
        '47d50af2a70a4661a7e1a4448ab2e18152ebfdcbd1c9455488a51189f2dc82cc.jpg'),
       (UUID_TO_BIN('8c6ecae3a1924c0d91a1643ce415ba59'), '韩式', UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        '43b8120f6ad548f180537db6e19d823f5ba7c073797541698f99e9de86cd6eb0.jpg'),
       (UUID_TO_BIN('aa681539e2604fcd9e916f7ef89bdb89'), 'java', UUID_TO_BIN('b63db1becc614da598442d5a71994a49'),
        '5976a042b8c14938a31789fbe37a79e4.jpg'),
       (UUID_TO_BIN('acd708e41c204f00bd1c96fc82c5c6c5'), '资生堂', UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        'fef46917f8d5434e90fd42d177acf43d5ba7c073797541698f99e9de86cd6eb0.jpg'),
       (UUID_TO_BIN('af19a7af18a24be0b9d4685cd6bcf0b2'), 'html5', UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        'ac21b0d722e24f90be23eda0ca060dc27bd2902c8d8e4fbab36af9db946d866b.jpg'),
       (UUID_TO_BIN('b8eaceed7b7244e8bfabcb46601399a8'), '两只松鼠', UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'),
        'b82f3ee1c3914a5681f53c10faa11be0ecd219921ba041ca86e8bb752dbb2998.jpg'),
       (UUID_TO_BIN('c5513193ba984fc7a37ed6178c52628f'), '编程', UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '0878ea67aebc48f580adee7c912fd53dc741aa1e52394929975a07fa8b4b69f3.jpg'),
       (UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2'), '卫龙', UUID_TO_BIN('b0a1877ba5f84cd89a25e507fb7612d8'),
        'df24ec5f44244f14aa4fbbd808285262.jpg'),
       (UUID_TO_BIN('e00d9e4db25c43f597f8596ea3fbc5c6'), '维达', UUID_TO_BIN('2f95f6b82bf54b0bb065b3ac1463c6a8'),
        '38e9e11cc9d444298098f1871dd37a781a9b2fae788844fdb1453ee7c3018ab3.jpg');

/*Table structure for table `s_carousel` */

DROP TABLE IF EXISTS `s_carousel`;

CREATE TABLE `s_carousel`
(
    `uuid`            binary(16) NOT NULL COMMENT 'UUID',
    `image_file_name` text       NOT NULL COMMENT '地址',
    `sequence_num`    int        NOT NULL COMMENT '序号',
    PRIMARY KEY (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_carousel` */

insert into `s_carousel`(`uuid`, `image_file_name`, `sequence_num`)
values (UUID_TO_BIN('04528a6e14d944a094f869ddcbe9198e'), 'c218defd6569413ead4f0171391ebe53.jpg', 2),
       (UUID_TO_BIN('24e36a828f3244c097320fb0c2faec03'), 'a70ef77467c6472ca0096e9e3f205060.jpg', 3),
       (UUID_TO_BIN('c571c621c35b4a89b8ece1174679272c'), 'c82fb3a177f54606a913f9f62806b00c.jpg', 1);


/*Table structure for table `s_user` */

DROP TABLE IF EXISTS `s_user`;

CREATE TABLE `s_user`
(
    `uuid`     binary(16)  NOT NULL COMMENT 'UUID',
    `username` varchar(50) NOT NULL COMMENT '用户名',
    `password` binary(16)  NOT NULL COMMENT '密码',
    `type_id`  int(1)      NOT NULL COMMENT '用户类型：0、后台用户；1、前台用户',
    PRIMARY KEY (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_user` */

insert into `s_user`
values (UUID_TO_BIN('a11439ccd60c11eaadab58fb845fce30'), 'admin', UUID_TO_BIN('e10adc3949ba59abbe56e057f20f883e'), 0),
       (UUID_TO_BIN('0874b0ef4bc842a98378e57891fc8aaf'), 'huahao', UUID_TO_BIN('e10adc3949ba59abbe56e057f20f883e'), 0),
       (UUID_TO_BIN('0de620a059c44b2ba3fd959207b457e9'), '和珅', UUID_TO_BIN('eccbc87e4b5ce2fe28308fd9f2a7baf3'), 1),
       (UUID_TO_BIN('1294cf871f9d48a0b4c64bf069aa087e'), '曹操', UUID_TO_BIN('eccbc87e4b5ce2fe28308fd9f2a7baf3'), 0),
       (UUID_TO_BIN('23325c81ca614097ba883dab7b0bf5f6'), '123444', UUID_TO_BIN('eccbc87e4b5ce2fe28308fd9f2a7baf3'), 0),
       (UUID_TO_BIN('432ab81f72694caba2ae6a4418779175'), 'huangjinjin', UUID_TO_BIN('202cb962ac59075b964b07152d234b70'),
        1),
       (UUID_TO_BIN('53732cf62d784e7d9d045df124f95cd7'), '孔明', UUID_TO_BIN('e10adc3949ba59abbe56e057f20f883e'), 0),
       (UUID_TO_BIN('5595d7cc9f9c4cdfab37738d28daee26'), 'egaeqg', UUID_TO_BIN('7846f3af63c807c5c6a252c1f0e5c54f'), 0),
       (UUID_TO_BIN('794248ad767c48408ceaff6ea12a8d06'), 'wudi', UUID_TO_BIN('e10adc3949ba59abbe56e057f20f883e'), 0),
       (UUID_TO_BIN('97de5b681c7a4e358ad0e1c812014929'), 'aaa1', UUID_TO_BIN('eccbc87e4b5ce2fe28308fd9f2a7baf3'), 0),
       (UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8'), '大王', UUID_TO_BIN('eccbc87e4b5ce2fe28308fd9f2a7baf3'), 1),
       (UUID_TO_BIN('a5b010ba20994224a4e0584bc0ddd8ad'), '小王', UUID_TO_BIN('eccbc87e4b5ce2fe28308fd9f2a7baf3'), 1),
       (UUID_TO_BIN('ac144d77b7274e1099b0017facfb49fa'), 'zhangsan', UUID_TO_BIN('e10adc3949ba59abbe56e057f20f883e'),
        1),
       (UUID_TO_BIN('d02d13aa10cc4bfe8bd86c3cbc1e01af'), 'egqewgq', UUID_TO_BIN('9b2ec22cb5f994e6af93c403e33df448'), 0),
       (UUID_TO_BIN('deb66d3a8c4b4c8a8aea2e5be622f9a3'), 'dagega', UUID_TO_BIN('45535f0617ab2b78006373a9aa3e0de1'), 0),
       (UUID_TO_BIN('e888e30e355445a8a55f97f0320ed7a2'), 'wudi', UUID_TO_BIN('e10adc3949ba59abbe56e057f20f883e'), 1),
       (UUID_TO_BIN('fe58db3a26ba4f50a676bbff054bf90c'), 'eeqqt', UUID_TO_BIN('27ea45a9ce0d2883a27bc3973d87bfed'), 0);

/*Table structure for table `s_receiving_address` */

DROP TABLE IF EXISTS `s_receiving_address`;

CREATE TABLE `s_receiving_address`
(
    `uuid`                  binary(16)  NOT NULL COMMENT 'UUID',
    `address`               binary(16)  NOT NULL COMMENT '收货地址',
    `receiving_person_name` varchar(50) NOT NULL COMMENT '收件人姓名',
    `mobile_phone`          bigint(20)  NOT NULL COMMENT '手机号',
    `user_uuid`             binary(16)  NOT NULL COMMENT '此接收地址所属用户 UUID',
    `is_default`            boolean     NOT NULL COMMENT '默认收货地址',
    PRIMARY KEY (`uuid`),
    FOREIGN KEY (`user_uuid`) REFERENCES `s_user` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


/*Data for the table `s_receiving_address` */

insert into `s_receiving_address`
values (UUID_TO_BIN('e8b46e74d60e11eaa79958fb845fce30'), '地球中国', '曹操', 1122335442,
        UUID_TO_BIN('432ab81f72694caba2ae6a4418779175'), 1),
       (UUID_TO_BIN('2418e70759fc4cd9b947bb43c5f5602c'), '福建省漳州市龙海市龙海市一条龙街', '中国龙', 1554862202,
        UUID_TO_BIN('a0ca9ba65d644d858e3886a4f428b447'),
        0),
       (UUID_TO_BIN('3698187a25d14cc7955d41bd1427dc2f'), '内蒙古自治区赤峰市元宝山区赤峰元宝人', '二宝', 125588522,
        UUID_TO_BIN('a5b010ba20994224a4e0584bc0ddd8ad'),
        1),
       (UUID_TO_BIN('3fe8b0070f9749ad822cf8b0865c687e'), '吉林省吉林市龙潭区吉林小街道2', '小草2', 144552211002,
        UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8'),
        0),
       (UUID_TO_BIN('4e6435d8f89a47b7ab7464e51fd7a296'), '天津天津市河西区天津狗不理包子铺', '王小二', 15648913113,
        UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8'),
        0),
       (UUID_TO_BIN('801565444dda4520b9424e3d81baa3db'), '湖北省武汉市洪山区曙光星城B区5栋', '华浩', 17688561711,
        UUID_TO_BIN('432ab81f72694caba2ae6a4418779175'),
        0),
       (UUID_TO_BIN('9012cff375f549e7a154127df44605d7'), '黑龙江省哈尔滨市松北区松花江上', '庞龙', 18956234586,
        UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8'),
        0),
       (UUID_TO_BIN('bc09c265c8004a41afca70309880b5af'), '浙江省温州市瓯海区浙江温州皮革厂', '表哥', 1554885222,
        UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8'),
        1),
       (UUID_TO_BIN('e6362835e76443809f589804c5079168'), '湖北省武汉市洪山区武汉洪山区的扛把子', '扛把子', 1488965223,
        UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8'),
        0);


/*Table structure for table `s_order` */

DROP TABLE IF EXISTS `s_order`;

CREATE TABLE `s_order`
(
    `uuid`                   binary(16) NOT NULL COMMENT 'UUID',
    `create_time`            datetime   NOT NULL COMMENT '订单创建时间',
    `receiving_address_uuid` binary(16) NOT NULL COMMENT '收货地址 UUID',
    `user_uuid`              binary(16) NOT NULL COMMENT '用户 UUID',
    PRIMARY KEY (`uuid`),
    FOREIGN KEY (`receiving_address_uuid`) REFERENCES `s_receiving_address` (`uuid`),
    FOREIGN KEY (`user_uuid`) REFERENCES `s_user` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_order` */

insert into `s_order`
values (UUID_TO_BIN('1e95a164883244d7aa8fd67c8cfddee5'), '2020-05-22 17:26:43',
        UUID_TO_BIN('3fe8b0070f9749ad822cf8b0865c687e'),
        UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8')),
       (UUID_TO_BIN('5eb6d29f7c0346b7bbda08777d623548'), '2020-05-22 17:26:32',
        UUID_TO_BIN('3fe8b0070f9749ad822cf8b0865c687e'),
        UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8')),
       (UUID_TO_BIN('ce910b490c84432b867a68407b0f69e7'), '2020-05-22 17:26:06',
        UUID_TO_BIN('3fe8b0070f9749ad822cf8b0865c687e'),
        UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8')),
       (UUID_TO_BIN('e7605b5e4b504bff8cae5f2c25a36160'), '2020-05-22 17:25:31',
        UUID_TO_BIN('3698187a25d14cc7955d41bd1427dc2f'),
        UUID_TO_BIN('a5b010ba20994224a4e0584bc0ddd8ad')),
       (UUID_TO_BIN('fe39168f3b8c4a7a992ad7293f0b5b97'), '2020-05-22 17:01:20',
        UUID_TO_BIN('3698187a25d14cc7955d41bd1427dc2f'),
        UUID_TO_BIN('a5b010ba20994224a4e0584bc0ddd8ad'));


/*Table structure for table `s_product` */

DROP TABLE IF EXISTS `s_product`;

CREATE TABLE `s_product`
(
    `uuid`            binary(16)   NOT NULL COMMENT 'UUID',
    `name`            varchar(100) NOT NULL COMMENT '商品名称',
    `image_file_name` text         NOT NULL COMMENT '商品图片',
    `price`           double       NOT NULL COMMENT '价格',
    `type_uuid`       binary(16)   NOT NULL COMMENT '所属分类 UUID',
    `desc`            text         NOT NULL COMMENT '商品详情',
    `create_time`     datetime     NOT NULL COMMENT '创建时间',
    `brand_uuid`      binary(16)   NOT NULL COMMENT '商品品牌 UUID',
    PRIMARY KEY (`uuid`),
    FOREIGN KEY (`type_uuid`) REFERENCES `s_product_type` (`uuid`),
    FOREIGN KEY (`brand_uuid`) REFERENCES `s_brand` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_product` */

insert into `s_product`
values (UUID_TO_BIN('03250d3b10f44f9a910cdd0bfe2ee7e7'), '测试数据11', '220e54585e524e7a9c6b8cc609ea08b71.jpg', 100,
        UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'), '7ed89b5e9c4740318613b29f9ce2e55e2.jpg', '2020-05-18 15:13:00',
        UUID_TO_BIN('00760bcdda1145969338d6fe39181e9c')),
       (UUID_TO_BIN('07bbb107374a4093a6084d71138004bf'), '2018秋季新款韩版高腰阔腿裤拖地西装长裤休闲裤女直筒显瘦时尚垂',
        'a5dc55c353a6436ea2e63110674fbb05.jpg',
        380, UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        '93dd8f457723441797abe4e8a66c463a.jpg,3b0b3d1dd88043728cb19c061eccdf0c.jpg,7f30e7a64ca64c2b90f6bdc6bd2e81c2.jpg,f2ede232098c4cb5a147676f3d99212a.jpg,fd1ac200bb2b4dd48b4610cd24c1f854.jpg,2b10b9122b324e079b33573483e447e0.jpg,37f9c6d68d1249bd957b71050a98ffd3.jpg',
        '2018-09-19 18:25:06', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('0b50b6781c1e453e93b0cb2def378158'), '进口粮油米面-满99减50',
        'ab7cc63e4c704c48b3d65ba33d8edbd3ea0f2476a750436e8187de4665441c3e.jpg', 98,
        UUID_TO_BIN('29feb3d0ad4d4b86aabcaa80e435e29b'),
        '2e79cd65216749e7b522f3fcb2e42e0eea0f2476a750436e8187de4665441c3e.jpg', '2018-09-19 18:55:46',
        UUID_TO_BIN('02b6fdb869534de3b1e5d0793c4f3640')),
       (UUID_TO_BIN('0f25438ffe7f40d485e3798449a4b765'), '粮油米面会场', '9977798b8ed3419b89bd47b3356b5420.jpg', 130,
        UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'),
        'ea0f2476a750436e8187de4665441c3e.jpg,35a6b9604cac4b1da06be0761f3ca348.jpg',
        '2018-09-19 16:13:24', UUID_TO_BIN('02b6fdb869534de3b1e5d0793c4f3640')),
       (UUID_TO_BIN('0ff9e1da2b324a28b71e8f0f15bbaf2e'), '进口水饮冲调-满99减50', '166e55691aaa4202b750e35e2046c960.jpg', 233,
        UUID_TO_BIN('29feb3d0ad4d4b86aabcaa80e435e29b'),
        '303200f2278c4592b2e329314c21215a.jpg,7ee6bafbb3cd4bf28dcc91a567570e99.jpg',
        '2018-09-19 18:56:12', UUID_TO_BIN('02b6fdb869534de3b1e5d0793c4f3640')),
       (UUID_TO_BIN('1151d7d1b1224c4a8387b41ae3f98766'), '旗袍外搭外套 开衫 小披肩女夏[逸红颜 楚菲儿]新款配旗袍的外套',
        '9dbbdf0167944f75acfb45334e1f81fe.jpg',
        180, UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        'ffabbb4ec03546719a718b6363a54baf.jpg,cbf4ca7a95e841f998364b8f21ab37fc.jpg,9ac30395b5e144f986637c2c61d4a5b3.jpg',
        '2018-09-19 18:24:23', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('119eedc1c9b54ec595aa79e5eb26ca46'), '洗发护发会场', '06494a0bea4848fa885f03c6729a4fa4.jpg', 111,
        UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        'cbf5ba10ac7147df887ec3288350d22d.jpg,ee8fd90bb0e94986bad48501a5ad9a18.jpg',
        '2018-09-19 16:07:13', UUID_TO_BIN('08d641c99ebc4eb0ac25a7969938c3b9')),
       (UUID_TO_BIN('2ab37130708c4dd994dd62f8105d27dc'), '核桃', '79da98dbe9384e0cb8aa3e56579abc0d核桃.jpg', 25,
        UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'),
        '068586e3cb8c4d2ea08da35671a51af6核桃详情.jpg,4b585328db644052b920749ffa437bd3核桃详情2.jpg', '2020-05-07 09:27:00',
        UUID_TO_BIN('b8eaceed7b7244e8bfabcb46601399a8')),
       (UUID_TO_BIN('2ae73ed2026a4f4cb0805f98d8b716a9'),
        'javascript高级程序设计+JavaScript权威指南 全2册  javascript入门基础 网页设计 编程艺术',
        '548b0c745c674cb483f67bbc5f59dadf8a1be2846b6b4d02a42cda64b54c5395.jpg', 166,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '768b86fc122743b0a8a164cda419348f.jpg,98b5c2cba0914013ad1515594e1ba2d6c741aa1e52394929975a07fa8b4b69f3.jpg',
        '2018-09-19 19:01:29', UUID_TO_BIN('c5513193ba984fc7a37ed6178c52628f')),
       (UUID_TO_BIN('2b7ff5cb00bb44a591988ff370fe0f5d'), 'Benefit贝玲妃完美无瑕粉饼/你好无暇遮瑕蜜粉防晒控油',
        '512321d8538b463bb9a913b6b3141c2c620a5878a3344ebfb642eb2fce763254.jpg', 233.9,
        UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        '510e4e6d61834c53944f093fec33563f.jpg,ef2401a6fe77484c89614b48ba6cc7efab885a51159840e79144fcfabf921faf.jpg',
        '2018-09-19 18:58:27', UUID_TO_BIN('4fc866a5443d4868870fc1bc2496388b')),
       (UUID_TO_BIN('352526e0ace24c68b3827f957282e91a'), '编程思想第4版中文版thinking in ',
        '999c51c566374dedaeadecbbf52d463b1b674f1483df4483abe3f26e341faa07.jpg', 86,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '1b674f1483df4483abe3f26e341faa07.jpg,4899fd8b78354abfb0b4ad5468a8f656a2d7fc2236f341b58647b78c2d1afb53.jpg',
        '2018-09-19 19:02:30', UUID_TO_BIN('c5513193ba984fc7a37ed6178c52628f')),
       (UUID_TO_BIN('35a7aac43008421aa247f17fa5943f3b'), '2018秋冬新款女装减龄慵懒风V领毛衣女宽松套头显瘦长袖针织衫潮',
        '942383aa01e84ee4981d6ad12b072fbe067dbf5675214567916e4a08d7d978bb.jpg', 300,
        UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        '067dbf5675214567916e4a08d7d978bb.jpg,4cb271fad0a6453794b3fb924fc0f494067dbf5675214567916e4a08d7d978bb.jpg',
        '2018-09-19 18:14:32', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('3c064409f23043d69b93329951352b08'), '✅✅西游记朝花夕拾鲁迅包邮正版初中生白洋淀纪事猎人笔记镜花缘湘行散记原著正七年级指定阅读课外书中学生必读的名著读物书籍套',
        'b1934a8d183f43029c42a22354a1b22581e9805a69b64009b827539a35505ac9.jpg', 57.8,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        'ac31844f5c724a5fb7f82ba5d01086a0.jpg,e8191391d4d441c697a780dd3843ee2581e9805a69b64009b827539a35505ac9.jpg',
        '2018-09-19 18:16:47', UUID_TO_BIN('4e47266bc70a49b6900f5d8ce7fd020e')),
       (UUID_TO_BIN('46c5e62a9d854bcd951ee9446b7fdab7'), '裤子女2018新款潮宽松长袖拼接polo领工装裤假两件收腰西装连体裤',
        '8a60f44d94354d23a4edb2a4c1bdfd64b05ecdd220794885bb868d9d6f6353d4.jpg', 147,
        UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        'd6940d91ad1e4f51a4bb5e363227b343.jpg,4e8515fe4d564e8a8c975889e465449df7560404eda44ab0b6fcc0c09ae4f73c.jpg',
        '2018-09-19 18:25:26', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('555dd67d48c649e0b60d4eddc49150ca'), '直邮韩国代购TONYMOLY魔法森林shocking lip超持久不掉色纹身唇彩',
        '19b93ae2cec4461092b05ba95c72b3205f61d24ee6914832a5d5b1a8b70c689b.jpg', 98,
        UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        '1f57374532d74de28d2e21cc8dbfe220.jpg,64b88fbb405449daac490068c512ce485f61d24ee6914832a5d5b1a8b70c689b.jpg',
        '2018-09-19 18:57:41', UUID_TO_BIN('8c6ecae3a1924c0d91a1643ce415ba59')),
       (UUID_TO_BIN('55fd5fb1ceb24f00a1dc55a5f1e1830c'), '平凡的世界(共3册)全三册3册 完整版 路遥原著 全套全集 茅盾文学奖经典文学小说书籍 畅销书排行榜 八年级下册书籍',
        '83b9634da41946bba54394a032f6c17078e66ef1eea14f7ea18c7212f113d839.jpg', 47.5,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '754b2baf653748af99522f8483053196.jpg,d41764860627432bbca46a7c04af317278e66ef1eea14f7ea18c7212f113d839.jpg',
        '2018-09-19 19:00:44', UUID_TO_BIN('4e47266bc70a49b6900f5d8ce7fd020e')),
       (UUID_TO_BIN('58da3e11448d4748bbadc4f7b5618f7a'), '家庭实用抽纸',
        'bfed277d605e4ec9bc0b3199ff81f48f3ab44e9bbc664b95b827ac6bdbff00e5.jpg', 45,
        UUID_TO_BIN('2f95f6b82bf54b0bb065b3ac1463c6a8'),
        '5bbbc60eda6143518be305094a4559f0.jpg,b57fe341eeea402d8b749530ad769a103ab44e9bbc664b95b827ac6bdbff00e5.jpg',
        '2018-09-19 16:08:29', UUID_TO_BIN('e00d9e4db25c43f597f8596ea3fbc5c6')),
       (UUID_TO_BIN('5a047f2898404e3686e03cf721dcfb29'), '商商sunny私人定制887226',
        '7cba6502bb8b4564a52b79fb1a40740d9fa2a9457927425d8029d817b225534b.jpg', 980,
        UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        '90f668bcbed34de09dbd091627bd0ac2.jpg,1177938f38c445a294118ffa3224aabc54c638aa160c4bc785449d93ae897dbf.jpg',
        '2018-09-19 18:27:03', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('69e862bd9d6247ab9ce1f0d1002938da'), '奶粉大牌',
        '55ef2f4034e2450bb925b8336a4bdb7c3a1ec6caaa1742b48e7f36c10cac99ad.jpg', 300,
        UUID_TO_BIN('c341708f957d431a9707a8214235f9d2'),
        'c74e26eadcf74518b3604d2409100254.jpg,299099baf5664f78bdb72b9f438e003a3a1ec6caaa1742b48e7f36c10cac99ad.jpg',
        '2018-09-19 16:14:08', UUID_TO_BIN('50e5c6a2e46f417582b2bbe915cda417')),
       (UUID_TO_BIN('732507590eb6454eb307d5591f0958ab'), '日本代购直邮 SUQQU 2014春季 双色腮红新色 2色选',
        '4ca6103aed0f4ea8b567a3ee54b512a367ad17b2abfe496e9c7ada2758959445.jpg', 432.3,
        UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        '9dfde6e14d344043a6068c262e298907.jpg,01dc07c52a8f444491682a896f1a0f4267ad17b2abfe496e9c7ada2758959445.jpg',
        '2018-09-19 18:58:03', UUID_TO_BIN('4fc866a5443d4868870fc1bc2496388b')),
       (UUID_TO_BIN('78cbc00d67b14255911adb1c8d4f264b'), '日本代购资生堂CPB肌肤之钥新双生玫瑰口红润唇膏4g带壳直邮包邮',
        'f5b2084b95634050b1cdec1e926a1201b9a6dc309b7e4deb976c4c38f2ed05ea.jpg', 390,
        UUID_TO_BIN('8409f4cacd18457cb153f8fe8741d122'),
        'ab885a51159840e79144fcfabf921faf.jpg,19ba0ac3ae85454394730aeee3440c50ab885a51159840e79144fcfabf921faf.jpg',
        '2018-09-19 18:21:06', UUID_TO_BIN('acd708e41c204f00bd1c96fc82c5c6c5')),
       (UUID_TO_BIN('7b403e32f9384c50b874d3508a41f83a'), '维达纸巾 超大袋装 16小包',
        '476f70f26ac243148c7efa47c00ff6595bbbc60eda6143518be305094a4559f0.jpg', 99,
        UUID_TO_BIN('2f95f6b82bf54b0bb065b3ac1463c6a8'),
        '793915bd0eb2450d8c00584f90a1ea13.jpg,1995fd23aacf4a0bbbddfad2eca9157b5bbbc60eda6143518be305094a4559f0.jpg',
        '2018-09-20 17:15:03', UUID_TO_BIN('e00d9e4db25c43f597f8596ea3fbc5c6')),
       (UUID_TO_BIN('7eb591e0c0ab44cd890186edae5f36ef'), 'UCC-满99减50',
        'fa18f9f88041479281861e4d1d0246038e00d2bde6674ad2bf2be5a97fb0ad85.jpg', 1180.3,
        UUID_TO_BIN('29feb3d0ad4d4b86aabcaa80e435e29b'),
        '22ef085e38624966a58b4369912ef8fb.jpg,753c4bc423e4438bbbbd9e09bbfcd9bd8e00d2bde6674ad2bf2be5a97fb0ad85.jpg',
        '2018-09-19 18:18:51', UUID_TO_BIN('02b6fdb869534de3b1e5d0793c4f3640')),
       (UUID_TO_BIN('81df4c6850284c0ba35cdd568c6ec9c3'), '身体沐浴会场',
        'ccab0769fe534b4dad6892c5627dd41dfbd87360371045b689bf8f0c68256973.jpg', 40,
        UUID_TO_BIN('2f95f6b82bf54b0bb065b3ac1463c6a8'),
        '28a0eb6908ae404dac2a0f9cb62ef49b.jpg,cf24eac0b10749168f2f210cf9b6511ffbd87360371045b689bf8f0c68256973.jpg',
        '2018-09-19 16:30:32', UUID_TO_BIN('8c6ecae3a1924c0d91a1643ce415ba59')),
       (UUID_TO_BIN('855d967653cc495ea0f0d90dd5e9183d'), '进口休闲零食-满99减50',
        '3bdc688344714f6fb9dea0d7c8bc64eccad586e6a62a4e9e8ac975606accc9e2.jpg', 66,
        UUID_TO_BIN('29feb3d0ad4d4b86aabcaa80e435e29b'),
        'e8a9a0b3d7224e65b4f7ab57c8536ac5.jpg,d9077f3853d24d4d8b357dcabe9c4926cad586e6a62a4e9e8ac975606accc9e2.jpg',
        '2018-09-19 18:56:47', UUID_TO_BIN('02b6fdb869534de3b1e5d0793c4f3640')),
       (UUID_TO_BIN('89c96d4be598473b94f892d47cd24395'),
        '全套4本 米小圈上学记第一辑 小学一年级课外书注音版 二年级必读小学生课外阅读书籍 儿童读物7-10岁故事书 6-12周岁拼音老师推荐',
        '438e3ca152254e86bb7d09f0ebf3aab63a8fdc4931b749c0b304594689474039.jpg', 54,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '7fc06869ed354a398a0e6ee6d19ea954.jpg', '2018-09-19 19:02:14', UUID_TO_BIN('4e47266bc70a49b6900f5d8ce7fd020e')),
       (UUID_TO_BIN('8d0489443a6c4b809674c3447969bf94'), '柚子', 'bc866126df544c8a8f2a8efb983481fd柚子.jpg', 0,
        UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'),
        '63c404c12fe543bc9624c92bc5216195柚子详情1.jpg,e94bbe61564e4bd4840220872b4c4eef柚子详情2.jpg', '2020-05-07 09:30:44',
        UUID_TO_BIN('b8eaceed7b7244e8bfabcb46601399a8')),
       (UUID_TO_BIN('8d0860d8aaea486b9448067f73963cf9'), '正版包邮 HTML5权威指南 弗里曼 html5+css3 从入门到精通  网页源码 web应用开发 ',
        '05ce6745a846409e9c74eab89b340dd63a8fdc4931b749c0b304594689474039.jpg', 87.6,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '3a8fdc4931b749c0b304594689474039.jpg,2249b83f6c7b4ce8bdb0a050a66ef1db3a8fdc4931b749c0b304594689474039.jpg',
        '2018-09-19 19:01:09', UUID_TO_BIN('c5513193ba984fc7a37ed6178c52628f')),
       (UUID_TO_BIN('9178e14b48aa45768310a1fab555b8ec'), '国产零食会场',
        '90f71bb2bf5e48758f6014ee4a94afafecd219921ba041ca86e8bb752dbb2998.jpg', 23,
        UUID_TO_BIN('0eba44a141d54156b0f0c16475c084ac'),
        '80fab5a3d2f44c3f977cfad7edd76376.jpg,de8a69b1b8694756b65528799e9f4d26ecd219921ba041ca86e8bb752dbb2998.jpg',
        '2018-09-19 16:09:01', UUID_TO_BIN('00760bcdda1145969338d6fe39181e9c')),
       (UUID_TO_BIN('91a523ec1d1142b2ab8d9f2e85ffc183'), ' 曹文轩系列全套7册',
        '196fea7d3e404c6cb7dbcde40a7bbd3e1b7d25989146438598a58eefe31559ef.jpg', 78,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '7a5bd1e8e5c64e5b83395f4f1792fe56.jpg,3498b4228b004c5e89675f6830dda2f91b7d25989146438598a58eefe31559ef.jpg',
        '2018-09-19 19:01:57', UUID_TO_BIN('4e47266bc70a49b6900f5d8ce7fd020e')),
       (UUID_TO_BIN('97e154ff07d84e3f981a4463f9a437ae'), '孕妇坚果-满99减50',
        'efa4375fc5074b2994b0323ead280b24ecd219921ba041ca86e8bb752dbb2998.jpg', 78,
        UUID_TO_BIN('29feb3d0ad4d4b86aabcaa80e435e29b'),
        'ecd219921ba041ca86e8bb752dbb2998.jpg,af1ab5834ccf44e0a1f11322bd5f8982ecd219921ba041ca86e8bb752dbb2998.jpg',
        '2018-09-19 18:56:32', UUID_TO_BIN('b8eaceed7b7244e8bfabcb46601399a8')),
       (UUID_TO_BIN('9bcc7d3fc6684907a63c7c79cefb0958'), '时尚套装2018秋季新款长袖针织衫毛衣套装女洋气百搭牛仔裤两件套',
        'ba8987dcfac2449680c6c951e4918849b05ecdd220794885bb868d9d6f6353d4.jpg', 239,
        UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        'b846a379125c4963adf355259d51ea0c.jpg,5fefe404aaf04be5982407681e1f4da3b05ecdd220794885bb868d9d6f6353d4.jpg',
        '2018-09-19 18:26:40', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('9de787791f0f44fa9b6b344368f14c17'), '朗读者董卿正版书籍全套(1-3辑)全3册现当代文学随笔中国诗词大会见字如面平凡的世界畅销书籍排行榜正版',
        'add3e627da534746aa7c17ce3c541fa728c56c6193d7416da98b3d2fc9334a40.jpg', 88,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        'afa8d1788f3b48c28d521891184a4300.jpg,a579703eb5254c6395862956df4a225bafa8d1788f3b48c28d521891184a4300.jpg',
        '2018-09-19 18:59:59', UUID_TO_BIN('4e47266bc70a49b6900f5d8ce7fd020e')),
       (UUID_TO_BIN('aa73228fadae485bb08cf4a13500144f'), 'Vue.js实战尤雨溪作序 马骥 站长大漠 在线回',
        'c62e8ad1bb4a48ce9b735b9149582a4c6d1d563c31fb48bb8e4018b03fe418fd.jpg', 99,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '52ebfdcbd1c9455488a51189f2dc82cc.jpg,514f7dae434e447fbc8382fcdf71e2666d1d563c31fb48bb8e4018b03fe418fd.jpg',
        '2018-09-19 19:02:45', UUID_TO_BIN('c5513193ba984fc7a37ed6178c52628f')),
       (UUID_TO_BIN('c88d602b4910414f990fc9c3e96d0cdf'),
        '全5册 城南旧事正版包邮 林海音 小学生版五六年级 呼兰河传 萧红著 骆驼祥子老舍初中必读原著阅读的课外书 繁星春水冰心课外书籍',
        'd981dec6f51c48ab98121971c3ffcf505bb2a327aad14050b0ea1d606b442119.jpg', 39.9,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        '73f5d6d3e07047708dc808260d8af56b.jpg,60d5c238eadc415f954723b0c83d0d1a5bb2a327aad14050b0ea1d606b442119.jpg',
        '2018-09-19 19:00:21', UUID_TO_BIN('4e47266bc70a49b6900f5d8ce7fd020e')),
       (UUID_TO_BIN('ceb78f5e4543496294d93c5b8774fcb3'), '复古名媛秋装新款女装2018波点长袖高腰裙子修身拼接中长款连衣裙',
        '4e9a3fdc233e48e1a501873b3624c4d23af6f28baef64ef0a0f0ed7393346963.jpg', 298,
        UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        '1946f6235ea745dfb6bf731933f091a9.jpg,0960e6a21e86422b950a906a932b93a03af6f28baef64ef0a0f0ed7393346963.jpg',
        '2018-09-19 18:26:26', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('d3740e27ffef46c3a59735f6b1430893'), '早秋装卫衣女2018新款chic上衣慵懒春原宿风长袖韩版宽松松垮垮薄',
        '549b9f385c5a48409231448a220001af9fa2a9457927425d8029d817b225534b.jpg', 870,
        UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        '54c638aa160c4bc785449d93ae897dbf.jpg,fee44eb4261c4c6798b49317a98cafd01a9b2fae788844fdb1453ee7c3018ab3.jpg,eab4c9c8bc464915a013ebcfcc7b00749fa2a9457927425d8029d817b225534b.jpg',
        '2018-09-19 18:15:25', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('d3efb3d891904e528abb214d9ab5bcd0'), '【OSL高端定制】600070双面尼',
        '330d330f62e24976a841c6d06acb5f89620a5878a3344ebfb642eb2fce763254.jpg', 580,
        UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        'dbdc5532f5ca4813806ddb01203b4d0a.jpg,b58779087098492fb7a6130d399d2a5e9dfde6e14d344043a6068c262e298907.jpg',
        '2018-09-19 18:15:01', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2')),
       (UUID_TO_BIN('dd31d79d9b2f4524be351934e6adb7f3'), '龙应台人生三书：目送+亲爱的安德烈+孩子你慢慢来 全3册经典套装 龙应台的书籍 畅销',
        '43971e79abfa4c959e2fa6fb7e6a6fdff374288be4be4dd9a9275bedffac5da0.jpg', 59.8,
        UUID_TO_BIN('758afbf0a4d1474e8b53043c6697a9f7'),
        'f374288be4be4dd9a9275bedffac5da0.jpg,4261ef3f7af943c3ab7afcdbd55bae19e74e39d02f014c2abfdbdfec08360d2a.jpg',
        '2018-09-19 18:59:35', UUID_TO_BIN('4e47266bc70a49b6900f5d8ce7fd020e')),
       (UUID_TO_BIN('fa4be2eb9d284df788ea60aeb6ef9e77'), '早秋卫衣少女2018新款chic慵懒bf风韩版宽松长袖怪味春秋装薄上衣',
        '481a7eac83594b96906bfed0c580ff035b765e0a18b8493897a5ed42d91b4bd3.jpg', 880,
        UUID_TO_BIN('09c6fb444219476089a9d179682e423e'),
        '252e8daee2bd44098dba149250a7eb6f.jpg,f5bc0ab37050429c85945f421a120c535b765e0a18b8493897a5ed42d91b4bd3.jpg',
        '2018-09-19 18:25:44', UUID_TO_BIN('cedc50a5125c4987affc1d238a6520c2'));


/*Table structure for table `s_order_product` */

DROP TABLE IF EXISTS `s_order_product`;

CREATE TABLE `s_order_product`
(
    `uuid`          binary(16) NOT NULL COMMENT 'uuid',
    `order_uuid`    binary(16) NOT NULL COMMENT '订单 UUID',
    `product_uuid`  binary(16) NOT NULL COMMENT '商品 UUID',
    `product_count` int(6)     NOT NULL COMMENT '商品数量',
    PRIMARY KEY (`uuid`),
    FOREIGN KEY (`order_uuid`) REFERENCES `s_order` (`uuid`),
    FOREIGN KEY (`product_uuid`) REFERENCES `s_product` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_order_product` */

insert into `s_order_product`
values (UUID_TO_BIN('0c1f62ef996b41e4a663eab1227c24b7'), UUID_TO_BIN('e7605b5e4b504bff8cae5f2c25a36160'),
        UUID_TO_BIN('2ab37130708c4dd994dd62f8105d27dc'), 2),
       (UUID_TO_BIN('1c4bf92d5bb7497f8eade827bbfda888'), UUID_TO_BIN('ce910b490c84432b867a68407b0f69e7'),
        UUID_TO_BIN('97e154ff07d84e3f981a4463f9a437ae'), 1),
       (UUID_TO_BIN('2b285f63cd814dd29db27d9578415e95'), UUID_TO_BIN('5eb6d29f7c0346b7bbda08777d623548'),
        UUID_TO_BIN('555dd67d48c649e0b60d4eddc49150ca'), 1),
       (UUID_TO_BIN('78cca0f33ec04098844be90f95a69b6a'), UUID_TO_BIN('ce910b490c84432b867a68407b0f69e7'),
        UUID_TO_BIN('855d967653cc495ea0f0d90dd5e9183d'), 1),
       (UUID_TO_BIN('7a5b7873ff9544f9aacb1b395508d9b6'), UUID_TO_BIN('fe39168f3b8c4a7a992ad7293f0b5b97'),
        UUID_TO_BIN('0ff9e1da2b324a28b71e8f0f15bbaf2e'), 1),
       (UUID_TO_BIN('a1323433ac504d5484abec5e99b8e500'), UUID_TO_BIN('fe39168f3b8c4a7a992ad7293f0b5b97'),
        UUID_TO_BIN('8d0489443a6c4b809674c3447969bf94'), 4),
       (UUID_TO_BIN('b0205a673ddf4f2ca6710820da63e316'), UUID_TO_BIN('1e95a164883244d7aa8fd67c8cfddee5'),
        UUID_TO_BIN('3c064409f23043d69b93329951352b08'), 1),
       (UUID_TO_BIN('e9cd17db1f3b4035bc2c59ad8766d935'), UUID_TO_BIN('e7605b5e4b504bff8cae5f2c25a36160'),
        UUID_TO_BIN('855d967653cc495ea0f0d90dd5e9183d'), 15);

/*Table structure for table `s_search_history` */

DROP TABLE IF EXISTS `s_search_history`;

CREATE TABLE `s_search_history`
(
    `uuid`               binary(16)   NOT NULL COMMENT 'UUID',
    `keyword`            varchar(100) NOT NULL COMMENT '搜索词',
    `count`              int(11)      NOT NULL COMMENT '次数',
    `latest_search_time` datetime     NOT NULL COMMENT '搜索时间',
    PRIMARY KEY (`uuid`),
    UNIQUE KEY (`keyword`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_search_history` */

insert into `s_search_history`
values (UUID_TO_BIN('0b33855e59ec421c869a4996d3fda01c'), '柚子', 14, '2020-05-10 22:28:41'),
       (UUID_TO_BIN('0fb71bb180e74306800e8d3a410c0314'), '华为', 1, '2018-09-21 10:19:33'),
       (UUID_TO_BIN('10b9e34b96614143917ec5cb86809e54'), '牛奶', 10, '2018-09-21 10:19:08'),
       (UUID_TO_BIN('189efd31a40b4d2888d7e8f9c2caccac'), 'f', 1, '2018-10-11 09:39:59'),
       (UUID_TO_BIN('26c3b0fada3b400db837d7d4700acf01'), '洗衣粉', 1, '2018-10-11 09:43:31'),
       (UUID_TO_BIN('2b4972d84de34109932618e2da648820'), '牛奶1', 1, '2020-05-16 17:42:11'),
       (UUID_TO_BIN('449aa4873e284afa8a81384144725248'), '车载手机架', 1, '2018-09-21 10:20:04'),
       (UUID_TO_BIN('44e6d2fb19594475b08a6ba113427e43'), '核桃', 1, '2020-05-12 15:07:29'),
       (UUID_TO_BIN('4d681b0b89f84deaa81024aa44249665'), '图书', 1, '2018-09-21 10:17:02'),
       (UUID_TO_BIN('51607181080c4326a47aa55e0e62589c'), '旗袍', 1, '2018-09-26 09:23:21'),
       (UUID_TO_BIN('59f88af287634ff58313335f79ac9eda'), '哈哈', 1, '2020-05-07 14:35:12'),
       (UUID_TO_BIN('67ae96e5438a4da0b36c5343a72b0863'), '空调', 1, '2018-09-21 10:17:57'),
       (UUID_TO_BIN('6aee5b8350b94c389d1ed69469d2a17b'), 'd', 1, '2018-10-11 09:00:17'),
       (UUID_TO_BIN('7e8a4c8c35624af5989719dc1f9cecd3'), '苹果', 1, '2018-10-11 09:42:44'),
       (UUID_TO_BIN('87dbcc86efb442a8b906a370501420b7'), '洗衣机', 5, '2018-09-21 10:18:02'),
       (UUID_TO_BIN('9153109e15a64957930d865acda1bc21'), 's', 2, '2018-10-11 09:40:09'),
       (UUID_TO_BIN('9527ecac49554c98bbbaabcc4fa40912'), 'java', 6, '2018-09-21 10:35:14'),
       (UUID_TO_BIN('9eb6dfeb1eff4c51897d25b4313cc9ed'), '电脑', 3, '2018-09-21 10:19:23'),
       (UUID_TO_BIN('bb875a19ef81470296183b3660e9d897'), '洗发水', 1, '2018-09-21 10:17:37'),
       (UUID_TO_BIN('c0e04159a64c4688a78442e2355eb4a6'), '小米', 9, '2018-09-21 10:19:28'),
       (UUID_TO_BIN('e1515da09fb040a3a48bd017f9d4cabd'), '牛奶3', 1, '2020-05-16 17:43:24'),
       (UUID_TO_BIN('ecb3f4a0e5064d68b1ec2a1110ca206e'), '进口', 15, '2018-09-26 09:23:15'),
       (UUID_TO_BIN('ecc9f97e56cd44f69a6e44cb732e52c0'), '维达', 4, '2018-09-21 10:17:22'),
       (UUID_TO_BIN('ff9641ef36364995bc031fbd4036b940'), '潘婷', 1, '2020-05-12 14:50:40');

/*Table structure for table `s_shop_cart` */

DROP TABLE IF EXISTS `s_shop_cart`;

CREATE TABLE `s_shop_cart`
(
    `uuid`      binary(16) NOT NULL COMMENT 'UUID',
    `user_uuid` binary(16) NOT NULL COMMENT '用户 UUID',
    PRIMARY KEY (`uuid`),
    FOREIGN KEY (`user_uuid`) REFERENCES `s_user` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_shop_cart` */

insert into `s_shop_cart`
values (UUID_TO_BIN('615cbb18b1024796a881693975d23f7f'), UUID_TO_BIN('a5b010ba20994224a4e0584bc0ddd8ad')),
       (UUID_TO_BIN('647d07e7be99406690e75844677e26ab'), UUID_TO_BIN('a433b84c42134643901c3466f69dd7a8'));

/*Table structure for table `s_shop_cart_product` */

DROP TABLE IF EXISTS `s_shop_cart_product`;

CREATE TABLE `s_shop_cart_product`
(
    `uuid`           binary(16) NOT NULL COMMENT 'UUID',
    `shop_cart_uuid` binary(16) NOT NULL COMMENT '购物车 UUID',
    `product_uuid`   binary(16) NOT NULL COMMENT '商品 UUID',
    `product_count`  int(6)     NOT NULL COMMENT '商品数量',
    PRIMARY KEY (`uuid`),
    FOREIGN KEY (`shop_cart_uuid`) REFERENCES `s_shop_cart` (`uuid`),
    FOREIGN KEY (`product_uuid`) REFERENCES `s_product` (`uuid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*Data for the table `s_shop_cart_product` */

insert into `s_shop_cart_product`
values (UUID_TO_BIN('c061333b99ea4f9f8e2f092cb0539dfc'), UUID_TO_BIN('647d07e7be99406690e75844677e26ab'),
        UUID_TO_BIN('8d0489443a6c4b809674c3447969bf94'), 1),
       (UUID_TO_BIN('de6a060863ae4efdbfad2c0e4e6dd5a2'), UUID_TO_BIN('615cbb18b1024796a881693975d23f7f'),
        UUID_TO_BIN('07bbb107374a4093a6084d71138004bf'), 4);


/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;
