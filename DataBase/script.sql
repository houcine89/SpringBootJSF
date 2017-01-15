-- Script init in PosgreSql Data Base

CREATE TABLE public.users
(
    username character varying(45) COLLATE pg_catalog."default" NOT NULL,
    password character varying(45) COLLATE pg_catalog."default" NOT NULL,
    enabled boolean NOT NULL DEFAULT true,
    CONSTRAINT users_pkey PRIMARY KEY (username)
);

CREATE TABLE public.user_roles
(
    user_role_id bigint NOT NULL DEFAULT nextval('user_roles_user_role_id_seq'::regclass),
    username character varying(45) COLLATE pg_catalog."default" NOT NULL,
    role character varying(45) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_roles_pkey PRIMARY KEY (user_role_id),
    CONSTRAINT uni_username_role UNIQUE (role, username),
    CONSTRAINT fk_username FOREIGN KEY (username)
        REFERENCES public.users (username) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

select * from users;
INSERT INTO users(username,password,enabled)
VALUES ('admin','admin', true);
INSERT INTO users(username,password,enabled)
VALUES ('user','user', true);

INSERT INTO user_roles (username, role)
VALUES ('admin', 'USER');
INSERT INTO user_roles (username, role)
VALUES ('admin', 'ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('user', 'USER');