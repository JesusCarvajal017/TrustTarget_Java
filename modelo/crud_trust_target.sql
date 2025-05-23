PGDMP      ;                }            trustTarget    16.4    16.4 B    D           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            E           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            F           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            G           1262    20990    trustTarget    DATABASE     �   CREATE DATABASE "trustTarget" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE "trustTarget";
                postgres    false            �            1259    20992    city    TABLE     �   CREATE TABLE public.city (
    city_id integer NOT NULL,
    city_code character varying(50) NOT NULL,
    city_name character varying(100) NOT NULL
);
    DROP TABLE public.city;
       public         heap    postgres    false            �            1259    20991    city_city_id_seq    SEQUENCE     �   ALTER TABLE public.city ALTER COLUMN city_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.city_city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    20998    company    TABLE     �   CREATE TABLE public.company (
    com_id integer NOT NULL,
    com_code integer NOT NULL,
    com_name character varying(100) NOT NULL
);
    DROP TABLE public.company;
       public         heap    postgres    false            �            1259    20997    company_com_id_seq    SEQUENCE     �   ALTER TABLE public.company ALTER COLUMN com_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.company_com_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218            �            1259    21004    country    TABLE     q   CREATE TABLE public.country (
    nation_id integer NOT NULL,
    nation_name character varying(100) NOT NULL
);
    DROP TABLE public.country;
       public         heap    postgres    false            �            1259    21003    country_nation_id_seq    SEQUENCE     �   ALTER TABLE public.country ALTER COLUMN nation_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.country_nation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220            �            1259    21010    identification_type    TABLE     �   CREATE TABLE public.identification_type (
    ident_id integer NOT NULL,
    ident_acronym character varying(3) NOT NULL,
    ident_name character varying(100) NOT NULL
);
 '   DROP TABLE public.identification_type;
       public         heap    postgres    false            �            1259    21009     identification_type_ident_id_seq    SEQUENCE     �   ALTER TABLE public.identification_type ALTER COLUMN ident_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.identification_type_ident_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    222            �            1259    21016 
   profession    TABLE     p   CREATE TABLE public.profession (
    prof_id integer NOT NULL,
    prof_name character varying(100) NOT NULL
);
    DROP TABLE public.profession;
       public         heap    postgres    false            �            1259    21015    profession_prof_id_seq    SEQUENCE     �   ALTER TABLE public.profession ALTER COLUMN prof_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.profession_prof_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224            �            1259    21022    rating    TABLE     �   CREATE TABLE public.rating (
    rat_id integer NOT NULL,
    rat_comment character varying(100) NOT NULL,
    rat_create_date character varying(30) NOT NULL,
    rat_score integer NOT NULL,
    com_id integer NOT NULL,
    target_id integer NOT NULL
);
    DROP TABLE public.rating;
       public         heap    postgres    false            �            1259    21021    rating_rat_id_seq    SEQUENCE     �   ALTER TABLE public.rating ALTER COLUMN rat_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.rating_rat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    226            �            1259    21028    region    TABLE     �   CREATE TABLE public.region (
    reg_id integer NOT NULL,
    reg_code character varying(10) NOT NULL,
    reg_name character varying(100) NOT NULL
);
    DROP TABLE public.region;
       public         heap    postgres    false            �            1259    21027    region_reg_id_seq    SEQUENCE     �   ALTER TABLE public.region ALTER COLUMN reg_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.region_reg_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    228            �            1259    21034    trust_nivels    TABLE     s   CREATE TABLE public.trust_nivels (
    nivel_id integer NOT NULL,
    nivel_name character varying(30) NOT NULL
);
     DROP TABLE public.trust_nivels;
       public         heap    postgres    false            �            1259    21033    trust_nivels_nivel_id_seq    SEQUENCE     �   ALTER TABLE public.trust_nivels ALTER COLUMN nivel_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.trust_nivels_nivel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    230            �            1259    21040    trust_target    TABLE     �   CREATE TABLE public.trust_target (
    target_id integer NOT NULL,
    target_create_date character varying(30) NOT NULL,
    nivel_id integer,
    user_id bigint NOT NULL
);
     DROP TABLE public.trust_target;
       public         heap    postgres    false            �            1259    21039    trust_target_target_id_seq    SEQUENCE     �   ALTER TABLE public.trust_target ALTER COLUMN target_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.trust_target_target_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    232            �            1259    21061    user_set    TABLE     �  CREATE TABLE public.user_set (
    user_id bigint NOT NULL,
    user_first_surname character varying(150) NOT NULL,
    user_names character varying(150) NOT NULL,
    user_num_ident integer NOT NULL,
    user_second_surname character varying(150),
    city_id integer NOT NULL,
    nation_id integer NOT NULL,
    ident_id integer NOT NULL,
    prof_id integer NOT NULL,
    reg_id integer NOT NULL,
    target_id integer
);
    DROP TABLE public.user_set;
       public         heap    postgres    false            �            1259    21060    user_set_user_id_seq    SEQUENCE     �   ALTER TABLE public.user_set ALTER COLUMN user_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.user_set_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    234            /          0    20992    city 
   TABLE DATA           =   COPY public.city (city_id, city_code, city_name) FROM stdin;
    public          postgres    false    216   �O       1          0    20998    company 
   TABLE DATA           =   COPY public.company (com_id, com_code, com_name) FROM stdin;
    public          postgres    false    218   P       3          0    21004    country 
   TABLE DATA           9   COPY public.country (nation_id, nation_name) FROM stdin;
    public          postgres    false    220   OP       5          0    21010    identification_type 
   TABLE DATA           R   COPY public.identification_type (ident_id, ident_acronym, ident_name) FROM stdin;
    public          postgres    false    222   �P       7          0    21016 
   profession 
   TABLE DATA           8   COPY public.profession (prof_id, prof_name) FROM stdin;
    public          postgres    false    224   �P       9          0    21022    rating 
   TABLE DATA           d   COPY public.rating (rat_id, rat_comment, rat_create_date, rat_score, com_id, target_id) FROM stdin;
    public          postgres    false    226   2Q       ;          0    21028    region 
   TABLE DATA           <   COPY public.region (reg_id, reg_code, reg_name) FROM stdin;
    public          postgres    false    228   OQ       =          0    21034    trust_nivels 
   TABLE DATA           <   COPY public.trust_nivels (nivel_id, nivel_name) FROM stdin;
    public          postgres    false    230   �Q       ?          0    21040    trust_target 
   TABLE DATA           X   COPY public.trust_target (target_id, target_create_date, nivel_id, user_id) FROM stdin;
    public          postgres    false    232   �Q       A          0    21061    user_set 
   TABLE DATA           �   COPY public.user_set (user_id, user_first_surname, user_names, user_num_ident, user_second_surname, city_id, nation_id, ident_id, prof_id, reg_id, target_id) FROM stdin;
    public          postgres    false    234   R       H           0    0    city_city_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.city_city_id_seq', 13, true);
          public          postgres    false    215            I           0    0    company_com_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.company_com_id_seq', 4, true);
          public          postgres    false    217            J           0    0    country_nation_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.country_nation_id_seq', 15, true);
          public          postgres    false    219            K           0    0     identification_type_ident_id_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.identification_type_ident_id_seq', 33, true);
          public          postgres    false    221            L           0    0    profession_prof_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.profession_prof_id_seq', 4, true);
          public          postgres    false    223            M           0    0    rating_rat_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.rating_rat_id_seq', 1, false);
          public          postgres    false    225            N           0    0    region_reg_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.region_reg_id_seq', 3, true);
          public          postgres    false    227            O           0    0    trust_nivels_nivel_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.trust_nivels_nivel_id_seq', 4, true);
          public          postgres    false    229            P           0    0    trust_target_target_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.trust_target_target_id_seq', 4, true);
          public          postgres    false    231            Q           0    0    user_set_user_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.user_set_user_id_seq', 5, true);
          public          postgres    false    233            ~           2606    20996    city city_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (city_id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public            postgres    false    216            �           2606    21002    company company_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (com_id);
 >   ALTER TABLE ONLY public.company DROP CONSTRAINT company_pkey;
       public            postgres    false    218            �           2606    21008    country country_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.country
    ADD CONSTRAINT country_pkey PRIMARY KEY (nation_id);
 >   ALTER TABLE ONLY public.country DROP CONSTRAINT country_pkey;
       public            postgres    false    220            �           2606    21014 ,   identification_type identification_type_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY public.identification_type
    ADD CONSTRAINT identification_type_pkey PRIMARY KEY (ident_id);
 V   ALTER TABLE ONLY public.identification_type DROP CONSTRAINT identification_type_pkey;
       public            postgres    false    222            �           2606    21020    profession profession_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.profession
    ADD CONSTRAINT profession_pkey PRIMARY KEY (prof_id);
 D   ALTER TABLE ONLY public.profession DROP CONSTRAINT profession_pkey;
       public            postgres    false    224            �           2606    21026    rating rating_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.rating
    ADD CONSTRAINT rating_pkey PRIMARY KEY (rat_id);
 <   ALTER TABLE ONLY public.rating DROP CONSTRAINT rating_pkey;
       public            postgres    false    226            �           2606    21032    region region_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.region
    ADD CONSTRAINT region_pkey PRIMARY KEY (reg_id);
 <   ALTER TABLE ONLY public.region DROP CONSTRAINT region_pkey;
       public            postgres    false    228            �           2606    21038    trust_nivels trust_nivels_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.trust_nivels
    ADD CONSTRAINT trust_nivels_pkey PRIMARY KEY (nivel_id);
 H   ALTER TABLE ONLY public.trust_nivels DROP CONSTRAINT trust_nivels_pkey;
       public            postgres    false    230            �           2606    21044    trust_target trust_target_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.trust_target
    ADD CONSTRAINT trust_target_pkey PRIMARY KEY (target_id);
 H   ALTER TABLE ONLY public.trust_target DROP CONSTRAINT trust_target_pkey;
       public            postgres    false    232            �           2606    21067 $   user_set uklcfxmyk598t0dnwdilyy8qda4 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_set
    ADD CONSTRAINT uklcfxmyk598t0dnwdilyy8qda4 UNIQUE (target_id);
 N   ALTER TABLE ONLY public.user_set DROP CONSTRAINT uklcfxmyk598t0dnwdilyy8qda4;
       public            postgres    false    234            �           2606    21323 (   trust_target ukry4gqm5ersjl2emc0j4j2so5f 
   CONSTRAINT     f   ALTER TABLE ONLY public.trust_target
    ADD CONSTRAINT ukry4gqm5ersjl2emc0j4j2so5f UNIQUE (user_id);
 R   ALTER TABLE ONLY public.trust_target DROP CONSTRAINT ukry4gqm5ersjl2emc0j4j2so5f;
       public            postgres    false    232            �           2606    21065    user_set user_set_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.user_set
    ADD CONSTRAINT user_set_pkey PRIMARY KEY (user_id);
 @   ALTER TABLE ONLY public.user_set DROP CONSTRAINT user_set_pkey;
       public            postgres    false    234            �           2606    21088 $   user_set fk1468cp1c7888tb5dln4gb5xru    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_set
    ADD CONSTRAINT fk1468cp1c7888tb5dln4gb5xru FOREIGN KEY (reg_id) REFERENCES public.region(reg_id);
 N   ALTER TABLE ONLY public.user_set DROP CONSTRAINT fk1468cp1c7888tb5dln4gb5xru;
       public          postgres    false    234    4746    228            �           2606    21093 $   user_set fk1679qd4vmk5b0opy4xg42uem0    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_set
    ADD CONSTRAINT fk1679qd4vmk5b0opy4xg42uem0 FOREIGN KEY (target_id) REFERENCES public.trust_target(target_id);
 N   ALTER TABLE ONLY public.user_set DROP CONSTRAINT fk1679qd4vmk5b0opy4xg42uem0;
       public          postgres    false    4750    232    234            �           2606    21045 "   rating fk7l8skfrcq6xt4ciqv76gn4xda    FK CONSTRAINT     �   ALTER TABLE ONLY public.rating
    ADD CONSTRAINT fk7l8skfrcq6xt4ciqv76gn4xda FOREIGN KEY (com_id) REFERENCES public.company(com_id);
 L   ALTER TABLE ONLY public.rating DROP CONSTRAINT fk7l8skfrcq6xt4ciqv76gn4xda;
       public          postgres    false    226    4736    218            �           2606    21324 (   trust_target fk89f3yggnpdwrd92v3l086o4q8    FK CONSTRAINT     �   ALTER TABLE ONLY public.trust_target
    ADD CONSTRAINT fk89f3yggnpdwrd92v3l086o4q8 FOREIGN KEY (user_id) REFERENCES public.user_set(user_id);
 R   ALTER TABLE ONLY public.trust_target DROP CONSTRAINT fk89f3yggnpdwrd92v3l086o4q8;
       public          postgres    false    4756    234    232            �           2606    21078 $   user_set fkbphmbjmt8iceigt40k8wgjwsb    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_set
    ADD CONSTRAINT fkbphmbjmt8iceigt40k8wgjwsb FOREIGN KEY (ident_id) REFERENCES public.identification_type(ident_id);
 N   ALTER TABLE ONLY public.user_set DROP CONSTRAINT fkbphmbjmt8iceigt40k8wgjwsb;
       public          postgres    false    222    234    4740            �           2606    21073 $   user_set fkfluhmyfdpvhmgtcigir4vppor    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_set
    ADD CONSTRAINT fkfluhmyfdpvhmgtcigir4vppor FOREIGN KEY (nation_id) REFERENCES public.country(nation_id);
 N   ALTER TABLE ONLY public.user_set DROP CONSTRAINT fkfluhmyfdpvhmgtcigir4vppor;
       public          postgres    false    234    4738    220            �           2606    21050 "   rating fkfymx1i5raussyglakmn8ixc5c    FK CONSTRAINT     �   ALTER TABLE ONLY public.rating
    ADD CONSTRAINT fkfymx1i5raussyglakmn8ixc5c FOREIGN KEY (target_id) REFERENCES public.trust_target(target_id);
 L   ALTER TABLE ONLY public.rating DROP CONSTRAINT fkfymx1i5raussyglakmn8ixc5c;
       public          postgres    false    226    4750    232            �           2606    21055 (   trust_target fkmohgdmw696cic5ggyocq7flo7    FK CONSTRAINT     �   ALTER TABLE ONLY public.trust_target
    ADD CONSTRAINT fkmohgdmw696cic5ggyocq7flo7 FOREIGN KEY (nivel_id) REFERENCES public.trust_nivels(nivel_id);
 R   ALTER TABLE ONLY public.trust_target DROP CONSTRAINT fkmohgdmw696cic5ggyocq7flo7;
       public          postgres    false    230    232    4748            �           2606    21083 $   user_set fkp9r7giyvgddu7slan8uwv1bu0    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_set
    ADD CONSTRAINT fkp9r7giyvgddu7slan8uwv1bu0 FOREIGN KEY (prof_id) REFERENCES public.profession(prof_id);
 N   ALTER TABLE ONLY public.user_set DROP CONSTRAINT fkp9r7giyvgddu7slan8uwv1bu0;
       public          postgres    false    224    4742    234            �           2606    21068 $   user_set fkrg69a0dwad9mu5o7rwcp5mfd7    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_set
    ADD CONSTRAINT fkrg69a0dwad9mu5o7rwcp5mfd7 FOREIGN KEY (city_id) REFERENCES public.city(city_id);
 N   ALTER TABLE ONLY public.user_set DROP CONSTRAINT fkrg69a0dwad9mu5o7rwcp5mfd7;
       public          postgres    false    4734    216    234            /   /   x�34�4��011�t�O�/IL�24�461��MMI��������� �i	d      1   .   x�3�4��/H�S�tT(�K�+�2�42���L.�/�O+����� �*	�      3   9   x�3�t-.H<�1��И�9?'?7)�6���K�I,I-*�L9sRs�21z\\\ ʱ�      5   >   x�3�t�s�tNM)�ITHIUH.�LILI��L�22����I,JO-Kf��敀�b���� !��      7   <   x�3��LO��L-�WHIU(�,.I�M,�2B�O+)O,J�2�t,*,�,IM.������ ���      9      x������ � �      ;   <   x�3�LI-N.*(�����(��ILL�2�t�O�/ITp�s�t.�K��K�M,JN����� �*L      =   #   x�3�L�)��2�tJ���2��MM������� c�      ?   )   x�3�42�50�520�0���4�2�42���\1z\\\ ���      A   7   x�3���M����/N�471�t�)��K�44�44�4�4�4���2&NY� ^��     