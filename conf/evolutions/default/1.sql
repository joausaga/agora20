# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table idea (
  id                        integer auto_increment not null,
  id_scale                  bigint,
  date                      date,
  title                     varchar(255),
  content                   longtext,
  score                     integer,
  author                    varchar(255),
  constraint pk_idea primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table idea;

SET FOREIGN_KEY_CHECKS=1;

