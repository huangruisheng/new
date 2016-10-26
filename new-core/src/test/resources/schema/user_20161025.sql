create table t_core_city (
  id int(12) auto_increment comment 'id',
  code int(5) comment '编号',
  name varchar(32)  comment '名字',
  pinyin varchar(32) comment '拼音',
  status varchar(8) comment '状态',
  create_dt datetime comment '创建时间',
  update_dt datetime comment '修改时间',
  operator varchar(50) comment '操作者',
  primary key (id)
);