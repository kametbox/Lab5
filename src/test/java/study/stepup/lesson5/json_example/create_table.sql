CREATE TABLE IF NOT EXISTS tpp_ref_account_type
(
    internal_id INT PRIMARY KEY,
    value VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS tpp_ref_product_class
(
    internal_id INT PRIMARY KEY,
    value VARCHAR(200),
    gbl_code VARCHAR(200),
    gbl_name VARCHAR(200),
    product_row_code VARCHAR(200),
    product_row_name VARCHAR(200),
    subclass_code VARCHAR(200),
    subclass_name VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS tpp_ref_product_register_type
(
    internal_id INT PRIMARY KEY,
    value VARCHAR(200),
    register_type_name VARCHAR(200),
    product_class_code INT REFERENCES tpp_ref_product_class (internal_id),
    account_type INT REFERENCES tpp_ref_account_type (internal_id)
);


INSERT INTO tpp_ref_account_type (internal_id, value) VALUES
                                                          (1, 'Клиентский'),
                                                          (2, 'Внутрибанковский');

INSERT INTO tpp_ref_product_class
(internal_id, value, gbi_code, gbi_name, product_row_code, product_row_name, subclass_code, subclass_name)
VALUES
    (1,'03.012.002','03','Розничный бизнес','012','Драг. металлы','002','Хранение'),
    (2,'02.001.005','02','Розничный бизнес','001','Сырье','005','Продажа');


INSERT INTO tpp_ref_product_register_type
(internal_id, value, register_type_name, product_class_code, account_type) VALUES
                                                                               (1, '03.012.002_47533_ComSoLd', 'Хранение ДМ.', 1, 1),
                                                                               (2, '02.001.005_45343_CoDowFF', 'Серебро. Выкуп.', 2, 1);


CREATE TABLE IF NOT EXISTS tpp_product
(
    id serial PRIMARY KEY,
    product_code_id INT,
    client_id INT,
    type VARCHAR(200),
    number VARCHAR(200),
    priority INT,
    date_of_conclusion TIMESTAMP,
    start_date_time TIMESTAMP,
    end_date_time TIMESTAMP,
    days INT,
    penalty_rate FLOAT,
    nso FLOAT,
    threshold_amount FLOAT,
    requisite_type VARCHAR(200),
    interest_rate_type VARCHAR(200),
    tax_rate FLOAT,
    reason_close VARCHAR(200),
    state VARCHAR(200)
);


CREATE TABLE IF NOT EXISTS agreements
(
    id serial PRIMARY KEY,
    product_id INT REFERENCES tpp_product (id),
    generalAgreementId VARCHAR(200),
    supplementaryAgreementId VARCHAR(200),
    arrangementType VARCHAR(200),
    shedulerJobId INT,
    number VARCHAR(200),
    openingDate DATE,
    closingDate DATE,
    cancelDate DATE,
    validityDuration INT,
    cancellationReason VARCHAR(200),
    status VARCHAR(200),
    interestCalculationDate DATE,
    interestRate DECIMAL,
    coefficient DECIMAL,
    coefficientAction VARCHAR(1),
    minimumInterestRate DECIMAL,
    minimumInterestRateCoefficient VARCHAR(200),
    minimumInterestRateCoefficientAction VARCHAR(1),
    maximalnterestRate DECIMAL,
    maximalnterestRateCoefficient DECIMAL,
    maximalnterestRateCoefficientAction VARCHAR(1)
);


CREATE TABLE IF NOT EXISTS tpp_product_register
(
    id serial PRIMARY KEY,
    product_id INT REFERENCES tpp_product (id),
    type INT REFERENCES tpp_ref_product_register_type (internal_id),
    account_id INT,
    currency_code VARCHAR(200),
    state VARCHAR(200),
    account_number VARCHAR(200)
);

INSERT INTO account_pool
(id, branch_code, currency_code, mdm_code, priority_code, registry_type_code)
VALUES
    (105,'81','643','12541213','00','03.012.002_47533_ComSoLd'),
    (106,'81','643','125213','00','03.012.002_47533_ComSoLd');

INSERT INTO account
(id, account_number, account_pool_id)
VALUES
    (5,'40702810500000000001',105),
    (7,'40702810500000000002',106);

select prt1_0.internal_id
from tpp_ref_product_register_type prt1_0
    left join tpp_ref_product_class pcc1_0
        on pcc1_0.internal_id=prt1_0.product_class_code
    left join tpp_ref_account_type at1_0
        on at1_0.internal_id=prt1_0.account_type
where pcc1_0.value='3.012.002_47533_ComSoLd'
  and at1_0.value='Клиентский'
fetch first 1 rows only

select * from tpp_ref_product_class