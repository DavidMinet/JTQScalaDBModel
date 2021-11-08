# --- !Ups
create table visitor(
  id BIGINT NOT NULL,
  username VARCHAR(255),
  name VARCHAR(255),
  password VARCHAR(255),
  phoneNumber VARCHAR(255),
  acceptedCommercial BOOL DEFAULT '0',
  acceptedTerms BOOL NOT NULL DEFAULT '0',
  userType BOOL DEFAULT '0',
  CONSTRAINT PK_Visitor PRIMARY KEY(id)
);

create table queue(
  id BIGINT NOT NULL,
  modificationCounter INTEGER,
  name VARCHAR(255),
  logo VARCHAR(255),
  currentNumber VARCHAR(255),
  attentionTime INTEGER,
  minAttentionTime INTEGER NOT NULL DEFAULT '60000',
  active BOOL NOT NULL DEFAULT '1',
  customers INTEGER NOT NULL DEFAULT '0',
  CONSTRAINT PK_DailyQueue PRIMARY KEY(id)
);

CREATE TABLE accesscode(
  id BIGINT NOT NULL,
  modificationCounter INTEGER,
  ticketNumber VARCHAR(5),
  creationTime INTEGER,
  startTime INTEGER,
  endTime INTEGER,
  queueId BIGINT NOT NULL,
  visitorId BIGINT NOT NULL,
  CONSTRAINT PK_AccessCode PRIMARY KEY(id),
  CONSTRAINT FK_AccessCode_queueId FOREIGN KEY(queueId) REFERENCES queue(id),
  CONSTRAINT FK_AccessCode_visitorId FOREIGN KEY(visitorId) REFERENCES visitor(id)
);

create sequence visitor_seq start with 1000;

create sequence queue_seq start with 1000;

create sequence accesscode_seq start with 1000;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

DROP TABLE visitor;
DROP TABLE queue;
DROP TABLE accesscode;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists visitor_seq;

drop sequence if exists queue_seq;

drop sequence if exists accesscode_seq;