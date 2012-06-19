# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table extra_info (
  id                        integer auto_increment not null,
  title                     varchar(255),
  content                   longtext,
  idea_id                   integer,
  constraint pk_extra_info primary key (id))
;

create table idea (
  id                        integer auto_increment not null,
  id_scale                  bigint,
  date                      date,
  title                     varchar(255),
  content                   longtext,
  score                     integer,
  author                    varchar(255),
  registered                tinyint(1) default 0,
  constraint pk_idea primary key (id))
;

alter table extra_info add constraint fk_extra_info_idea_1 foreign key (idea_id) references idea (id) on delete restrict on update restrict;
create index ix_extra_info_idea_1 on extra_info (idea_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table extra_info;

drop table idea;

SET FOREIGN_KEY_CHECKS=1;

