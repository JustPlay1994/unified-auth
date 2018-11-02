

/*******************************
模块名
 */
/*=============== DDL ========================*/
create table auth_users(
	account varchar2(50) not null primary key,
	password varchar2(50) not null,
	enabled Number(1) not null,
	phoneNumber varchar2(20) not null,
	id_card varchar2(30) not null,
	real_name varchar2(30) not null
);
comment on TABLE auth_users is '用户信息表';
comment on column auth_users.account is '账号';
comment on column auth_users.password is '密码';
comment on column auth_users.enabled is '是否有效,1有效,0被禁用';
comment on column auth_users.phoneNumber is '手机号';
comment on column auth_users.id_card is '身份证号';
comment on column auth_users.real_name is '真实姓名';

create table auth_user_roles(
	account varchar2(50) not null,
	role varchar2(50) not null
);
comment on TABLE auth_user_roles is '用户-角色表';
comment on column auth_user_roles.account is '账号';
comment on column auth_user_roles.role is '角色名';

create table auth_role_permissions(
	role varchar2(50) not null,
	permission varchar2(200) not null
);
comment on TABLE auth_role_permissions is '角色-权限表';
comment on column auth_role_permissions.role is '角色';
comment on column auth_role_permissions.permission is '权限';

create table auth_role_organization(
	role varchar2(50) not null,
	organization varchar2(200) not null
);
comment on TABLE auth_role_organization is '角色-组织机构表';
comment on column auth_role_organization.role is '角色';
comment on column auth_role_organization.organization is '组织结构';
