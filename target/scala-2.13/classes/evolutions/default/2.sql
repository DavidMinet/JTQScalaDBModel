# --- Sample dataset

# --- !Ups

insert into queue (id,name, logo, attentionTime, minAttentionTime, active, customers) values (  1,'Jump The Queue', '', 0, 0, true, 0);

insert into visitor (id,username,name,phoneNumber,password,acceptedCommercial,acceptedTerms,userType) values (  1,'admin','admin','null','password',true,true,true);

insert into accesscode (id,ticketNumber,creationTime,startTime,endTime,queueId,visitorId) values (  1,'NULL',0,0,0,1,1);


# --- !Downs

delete from queue;
delete from visitor;
