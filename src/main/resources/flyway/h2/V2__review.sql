
create table tbl_review (
    id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    author varchar(80) not null,
    call_no varchar(20),
    content TEXT,
    cover_url varchar(80),
    lib_code varchar(20),
    lib_name varchar(40),
    publisher varchar(80) not null,
    title varchar(100) not null,
    writer_id varchar(80),
    writer_name varchar(80),
    primary key (id)
);