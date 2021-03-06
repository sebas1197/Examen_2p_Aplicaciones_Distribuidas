PGDMP         !        	        y            examen    10.17    10.17     ?
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ?
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ?
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            ?
           1262    16549    examen    DATABASE     ?   CREATE DATABASE examen WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE examen;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            ?
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                        0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    16550    gen_agencia    TABLE     ?   CREATE TABLE public.gen_agencia (
    cod_agencia character varying(8) NOT NULL,
    cod_empresa character varying(8),
    nombre character varying(150)
);
    DROP TABLE public.gen_agencia;
       public         postgres    false    3            ?            1259    16555    seg_usuario    TABLE     ?  CREATE TABLE public.seg_usuario (
    cod_usuario character varying(30) NOT NULL,
    nombre character varying(150),
    identificacion character varying(30),
    email character varying(250),
    estado character varying(3),
    nro_intentos_fallidos numeric(5,0),
    fecha_ultima_sesion date,
    CONSTRAINT ckc_estado_seg_usua CHECK (((estado IS NULL) OR ((estado)::text = ANY ((ARRAY['ACT'::character varying, 'DES'::character varying])::text[]))))
);
    DROP TABLE public.seg_usuario;
       public         postgres    false    3            ?            1259    16561    seg_usuario_agencia    TABLE     ?   CREATE TABLE public.seg_usuario_agencia (
    cod_empresa character varying(8) NOT NULL,
    cod_usuario character varying(30),
    cod_agencia character varying(8),
    por_omision character varying(1)
);
 '   DROP TABLE public.seg_usuario_agencia;
       public         postgres    false    3            ?
          0    16550    gen_agencia 
   TABLE DATA               G   COPY public.gen_agencia (cod_agencia, cod_empresa, nombre) FROM stdin;
    public       postgres    false    196   ?       ?
          0    16555    seg_usuario 
   TABLE DATA               ?   COPY public.seg_usuario (cod_usuario, nombre, identificacion, email, estado, nro_intentos_fallidos, fecha_ultima_sesion) FROM stdin;
    public       postgres    false    197   
       ?
          0    16561    seg_usuario_agencia 
   TABLE DATA               a   COPY public.seg_usuario_agencia (cod_empresa, cod_usuario, cod_agencia, por_omision) FROM stdin;
    public       postgres    false    198   w       v
           2606    16554    gen_agencia pk_gen_agencia 
   CONSTRAINT     a   ALTER TABLE ONLY public.gen_agencia
    ADD CONSTRAINT pk_gen_agencia PRIMARY KEY (cod_agencia);
 D   ALTER TABLE ONLY public.gen_agencia DROP CONSTRAINT pk_gen_agencia;
       public         postgres    false    196            x
           2606    16560    seg_usuario pk_seg_usuario 
   CONSTRAINT     a   ALTER TABLE ONLY public.seg_usuario
    ADD CONSTRAINT pk_seg_usuario PRIMARY KEY (cod_usuario);
 D   ALTER TABLE ONLY public.seg_usuario DROP CONSTRAINT pk_seg_usuario;
       public         postgres    false    197            z
           2606    16565 *   seg_usuario_agencia pk_seg_usuario_agencia 
   CONSTRAINT     q   ALTER TABLE ONLY public.seg_usuario_agencia
    ADD CONSTRAINT pk_seg_usuario_agencia PRIMARY KEY (cod_empresa);
 T   ALTER TABLE ONLY public.seg_usuario_agencia DROP CONSTRAINT pk_seg_usuario_agencia;
       public         postgres    false    198            {
           2606    16566 2   seg_usuario_agencia fk_seg_usua_fk_seg_us_gen_agen    FK CONSTRAINT     ?   ALTER TABLE ONLY public.seg_usuario_agencia
    ADD CONSTRAINT fk_seg_usua_fk_seg_us_gen_agen FOREIGN KEY (cod_agencia) REFERENCES public.gen_agencia(cod_agencia) ON UPDATE RESTRICT ON DELETE RESTRICT;
 \   ALTER TABLE ONLY public.seg_usuario_agencia DROP CONSTRAINT fk_seg_usua_fk_seg_us_gen_agen;
       public       postgres    false    198    196    2678            |
           2606    16571 2   seg_usuario_agencia fk_seg_usua_fk_seg_us_seg_usua    FK CONSTRAINT     ?   ALTER TABLE ONLY public.seg_usuario_agencia
    ADD CONSTRAINT fk_seg_usua_fk_seg_us_seg_usua FOREIGN KEY (cod_usuario) REFERENCES public.seg_usuario(cod_usuario) ON UPDATE RESTRICT ON DELETE RESTRICT;
 \   ALTER TABLE ONLY public.seg_usuario_agencia DROP CONSTRAINT fk_seg_usua_fk_seg_us_seg_usua;
       public       postgres    false    197    198    2680            ?
       x?3?4?tLO?K?L4?2?4?q??b???? z?Z      ?
   ]   x?U˱@0???]*w?U6????IC???|Jy?}&u??^???C,?#Q?????ʠ?Ɛ?????Q???n??_??9?????/??|      ?
      x?3?4A.#N4?2?@t? 3?j     