CREATE TABLE IF NOT EXISTS Doc_type (
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL       COMMENT 'Служебное поле hibernate',
    code    VARCHAR(2) NOT NULL    COMMENT 'Код вида документа',
    name    VARCHAR(128) NOT NULL  COMMENT 'Название вида документа',

    UNIQUE (code),
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS Country (
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL       COMMENT 'Служебное поле hibernate',
    code    VARCHAR(3) NOT NULL    COMMENT 'Код страны',
    name    VARCHAR(60) NOT NULL   COMMENT 'Название страны',

    UNIQUE (code),
    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS Position (
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    version INTEGER NOT NULL       COMMENT 'Служебное поле hibernate',
    name    VARCHAR(100) NOT NULL  COMMENT 'Название должности',

    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS Document (
    id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    version       INTEGER NOT NULL               COMMENT 'Служебное поле hibernate',
    number        VARCHAR(50) NOT NULL           COMMENT 'Номер документа',
    date          DATE NOT NULL                  COMMENT 'Дата выдачи документа',
    is_identified BOOLEAN NOT NULL DEFAULT FALSE COMMENT 'Подтверждён ли документ',
    type_id       INTEGER NOT NULL               COMMENT 'Уникальный идентификатор типа документа',

    FOREIGN KEY (type_id) REFERENCES Doc_type (id)
);
CREATE INDEX IX_Document_Type_Id ON Document (type_id);

CREATE TABLE IF NOT EXISTS Organization (
    id        INTEGER PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER NOT NULL       COMMENT 'Служебное поле hibernate',
    name      VARCHAR(50) NOT NULL   COMMENT 'Название организации',
    full_name VARCHAR(255) NOT NULL  COMMENT 'Полное название организации',
    inn       VARCHAR(12) NOT NULL   COMMENT 'ИНН организации',
    kpp       VARCHAR(9) NOT NULL    COMMENT 'Код причины постановки на учёт',
    address   VARCHAR(80) NOT NULL   COMMENT 'Адрес организации',
    phone     VARCHAR(20)            COMMENT 'Телефонный номер организации',
    is_active BOOLEAN DEFAULT FALSE  COMMENT 'Активна ли организация'
);

CREATE TABLE IF NOT EXISTS Office (
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    version     INTEGER NOT NULL      COMMENT 'Служебное поле hibernate',
    name        VARCHAR(50)           COMMENT 'Название',
    address     VARCHAR(80)           COMMENT 'Адрес',
    phone       VARCHAR(20)           COMMENT 'Телефонный номер',
    is_active   BOOLEAN DEFAULT FALSE COMMENT 'Активен ли офис',
    org_id      INTEGER NOT NULL      COMMENT 'Уникальный идентификатор организации',

    FOREIGN KEY (org_id) REFERENCES Organization(id)
);
CREATE INDEX IX_Office_Org_Id ON Office (org_id);

CREATE TABLE IF NOT EXISTS User (
    id            INTEGER PRIMARY KEY AUTO_INCREMENT,
    version       INTEGER NOT NULL             COMMENT 'Служебное поле hibernate',
    first_name    VARCHAR(50) NOT NULL         COMMENT 'Имя',
    second_name   VARCHAR(50)                  COMMENT 'Фамилия',
    middle_name   VARCHAR(50)                  COMMENT 'Отчество',
    phone         VARCHAR(20)                  COMMENT 'Телефонный номер',
    doc_id        INTEGER                      COMMENT 'Уникальный идентификатор документа сотрудника',
    office_id     INTEGER NOT NULL             COMMENT 'Уникальный идентификатор офиса',
    country_id    INTEGER                      COMMENT 'Уникальный идентификатор страны',
    position_id   INTEGER NOT NULL             COMMENT 'Уникальный идентификатор должности сотрудника',

    UNIQUE (doc_id),
    FOREIGN KEY (doc_id) REFERENCES Document(id),
    FOREIGN KEY (office_id) REFERENCES Office(id),
    FOREIGN KEY (country_id) REFERENCES Country(id),
    FOREIGN KEY (position_id) REFERENCES Position(id)
);
CREATE INDEX IX_User_Doc_Id ON User(doc_id);
CREATE INDEX IX_User_Office_Id ON User(office_id);
CREATE INDEX IX_User_Country_Id ON User(country_id);
CREATE INDEX IX_User_Position_Id ON User(position_id);