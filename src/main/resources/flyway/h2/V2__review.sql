
create table tbl_review (
    id bigint generated by default as identity,
    created_date timestamp,
    modified_date timestamp,
    author varchar(80) not null,
    call_no varchar(20),
    comment_count integer default 0,
    cover_url varchar(80),
    lib_code varchar(20),
    lib_name varchar(40),
    publisher varchar(80) not null,
    review TEXT,
    title varchar(100) not null,
    writer_id varchar(80),
    writer_name varchar(80),
    primary key (id)
);
create index idx_review_writer_id on tbl_review (writer_id);
create index idx_review_publisher on tbl_review (publisher);
create index idx_review_author on tbl_review (author);
create index idx_review_lib_name on tbl_review (lib_name);


create table tbl_commenet (
    id bigint generated by default as identity,
    comment varchar(1024),
    review_id bigint not null,
    writer_id varchar(80),
    writer_name varchar(80),
    primary key (id)
);

create index idx_comment_review_id on tbl_commenet (review_id);
create index idx_comment_writer_id on tbl_commenet (writer_id);
