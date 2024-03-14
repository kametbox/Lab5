create table IF NOT EXISTS tpp_ref_account_type
(
    internal_id serial
        primary key,
    value       varchar(255)
);

create table IF NOT EXISTS tpp_ref_product_class
(
    internal_id      serial
        primary key,
    gbi_code         varchar(255),
    gbi_name         varchar(255),
    product_row_code varchar(255),
    product_row_name varchar(255),
    subclass_code    varchar(255),
    subclass_name    varchar(255),
    value            varchar(255)
);

create table IF NOT EXISTS tpp_ref_product_register_type
(
    internal_id        serial
        primary key,
    register_type_name varchar(255),
    value              varchar(255),
    account_type       integer
        constraint fkdrhu6wa6pe1l815exqolmbr9h
            references public.tpp_ref_account_type,
    product_class_code integer
        constraint fkt0q1we2c3qi8rrqxkaj60upfm
            references public.tpp_ref_product_class
);



INSERT INTO tpp_ref_account_type (internal_id, value) VALUES
                                                          (1, 'Клиентский'),
                                                          (2, 'Внутрибанковский');

INSERT INTO tpp_ref_product_class
(internal_id, value, gbi_code, gbi_name, product_row_code, product_row_name, subclass_code, subclass_name)
VALUES
    (1,'3.012.002_47533_ComSoLd','03','Розничный бизнес','012','Драг. металлы','002','Хранение'),
    (2,'3.012.002_47533_ComSoLd','02','Розничный бизнес','001','Сырье','005','Продажа');


INSERT INTO tpp_ref_product_register_type
(internal_id, value, register_type_name, product_class_code, account_type) VALUES
                                                                               (1, '03.012.002_47533_ComSoLd', 'Хранение ДМ.', 1, 1),
                                                                               (2, '02.001.005_45343_CoDowFF', 'Серебро. Выкуп.', 2, 1);