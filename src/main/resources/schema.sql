
create table if not exists Taco (
  id integer not null,
  name varchar(50) not null,
  ingredient varchar
);

create table if not exists Ingredient (
  id varchar(4) not null,
  name varchar(25) not null,
  type varchar(10) not null
);