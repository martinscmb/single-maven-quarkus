create table example(id int primary key, code varchar) as
    select x, space(10000) from system_range(1, 100);
