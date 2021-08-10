/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     09/08/2021 21:19:57                          */
/*==============================================================*/


drop table GEN_AGENCIA;

drop table SEG_USUARIO;

drop table SEG_USUARIO_AGENCIA;

/*==============================================================*/
/* Table: GEN_AGENCIA                                           */
/*==============================================================*/
create table GEN_AGENCIA (
   COD_AGENCIA          VARCHAR(8)           not null,
   COD_EMPRESA          VARCHAR(8)           null,
   NOMBRE               VARCHAR(150)         null,
   constraint PK_GEN_AGENCIA primary key (COD_AGENCIA)
);

/*==============================================================*/
/* Table: SEG_USUARIO                                           */
/*==============================================================*/
create table SEG_USUARIO (
   COD_USUARIO          VARCHAR(30)          not null,
   NOMBRE               VARCHAR(150)         null,
   IDENTIFICACION       VARCHAR(30)          null,
   EMAIL                VARCHAR(250)         null,
   ESTADO               VARCHAR(3)           null
      constraint CKC_ESTADO_SEG_USUA check (ESTADO is null or (ESTADO in ('ACT','DES'))),
   NRO_INTENTOS_FALLIDOS NUMERIC(5)           null,
   FECHA_ULTIMA_SESION  DATE                 null,
   constraint PK_SEG_USUARIO primary key (COD_USUARIO)
);

/*==============================================================*/
/* Table: SEG_USUARIO_AGENCIA                                   */
/*==============================================================*/
create table SEG_USUARIO_AGENCIA (
   COD_EMPRESA          VARCHAR(8)           not null,
   COD_USUARIO          VARCHAR(30)          null,
   COD_AGENCIA          VARCHAR(8)           null,
   POR_OMISION          VARCHAR(1)           null,
   constraint PK_SEG_USUARIO_AGENCIA primary key (COD_EMPRESA)
);

alter table SEG_USUARIO_AGENCIA
   add constraint FK_SEG_USUA_FK_SEG_US_GEN_AGEN foreign key (COD_AGENCIA)
      references GEN_AGENCIA (COD_AGENCIA)
      on delete restrict on update restrict;

alter table SEG_USUARIO_AGENCIA
   add constraint FK_SEG_USUA_FK_SEG_US_SEG_USUA foreign key (COD_USUARIO)
      references SEG_USUARIO (COD_USUARIO)
      on delete restrict on update restrict;

