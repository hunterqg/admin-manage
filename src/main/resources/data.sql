
alter table mm_tag  auto_increment=10101;
INSERT INTO `mm_managment_console`.`mm_tag` (`code`, `name`, `description`)
 VALUES
 ('COLLAR_1', 'V领', '领型-V领'),
 ('COLLAR_2', '一字领', '领型-一字领'),
 ('COLLAR_3', '高领', '领型-高领'),
 ('COLLAR_4', '圆领', '领型-圆领');

alter table mm_tag  auto_increment=10201;
INSERT INTO `mm_managment_console`.`mm_tag` (`code`, `name`, `description`)
 VALUES
 ('THICKNESS_1','修身', '宽松度-修身'),
 ('THICKNESS_2','常规', '宽松度-常规'),
 ('THICKNESS_3','宽松', '宽松度-宽松');

alter table mm_tag  auto_increment=10301;
INSERT INTO `mm_managment_console`.`mm_tag` (`code`, `name`, `description`)
 VALUES
 ('LOOSENESS_1','薄', '厚薄度-薄'),
 ('LOOSENESS_2','中', '厚薄度-中'),
 ('LOOSENESS_3','厚', '厚薄度-厚');

alter table mm_tag  auto_increment=10401;
INSERT INTO `mm_managment_console`.`mm_tag` (`code`, `name`, `description`)
 VALUES
 ('PATTERN_STRIPE_1','横条纹', '图案-横条纹'),
 ('PATTERN_STRIPE_2','竖条纹', '图案-竖条纹'),
 ('PATTERN_PLAID_1','格子', '图案-格子'),
 ('PATTERN_FLORAL_1','花纹', '图案-花纹'),
 ('PATTERN_GEO_1','几何', '图案-大花纹'),
 ('PATTERN_OTHER','其他', '图案-其他');

alter table mm_tag  auto_increment=10501;
INSERT INTO `mm_managment_console`.`mm_tag` (`code`, `name`, `description`)
 VALUES
 ('COLOR_TEMP_1','冷色', '颜色-色温-冷色'),
 ('COLOR_TEMP_2','暖色', '颜色-色温-暖色'),
 ('COLOR_TEMP_3','中性色', '颜色-色温-中性');

alter table mm_tag  auto_increment=10601;
INSERT INTO `mm_managment_console`.`mm_tag` (`code`, `name`, `description`)
 VALUES
 ('STYLE_1','简约', '风格-简约'),
 ('STYLE_2','甜美', '风格-甜美'),
 ('STYLE_3','街头', '风格-街头'),
 ('STYLE_4','通勤', '风格-通勤'),
 ('STYLE_5','白搭', '风格-白搭'),
 ('STYLE_6','复古', '风格-复古'),
 ('STYLE_7','优雅', '风格-优雅');

alter table mm_tag  auto_increment=10701;
INSERT INTO `mm_managment_console`.`mm_tag` (`code`, `name`, `description`)
 VALUES
 ('UP_CLOTH_TYPE_1','短款', '上装-短款'),
 ('UP_CLOTH_TYPE_2','常规', '上装-常规'),
 ('UP_CLOTH_TYPE_3','中长款', '上装-中长款'),
 ('UP_CLOTH_TYPE_4','长款', '上装-长款');

alter table mm_tag  auto_increment=10801;
INSERT INTO `mm_managment_console`.`mm_tag` (`code`, `name`, `description`)
 VALUES
 ('DOWN_CLOTH_TYPE_1','铅笔裤', '下装-铅笔裤'),
 ('DOWN_CLOTH_TYPE_2','阔腿裤', '下装-阔腿裤'),
 ('DOWN_CLOTH_TYPE_3','直筒裤', '下装-直筒裤'),
 ('DOWN_CLOTH_TYPE_4','微喇裤', '下装-短款'),
 ('DOWN_CLOTH_TYPE_5','短裙', '下装-短裙'),
 ('DOWN_CLOTH_TYPE_6','中裙', '下装-中裙'),
 ('DOWN_CLOTH_TYPE_7','中长裙', '下装-中长裙'),
 ('DOWN_CLOTH_TYPE_8','长裙', '下装-长裙');
