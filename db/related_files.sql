-- Table: public.related_files

-- DROP TABLE IF EXISTS public.related_files;

CREATE TABLE IF NOT EXISTS public.related_files
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    identifier character varying(50) COLLATE pg_catalog."default" NOT NULL,
    file_date bytea NOT NULL,
    file_type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp with time zone NOT NULL,
    updated_on timestamp with time zone NOT NULL,
    CONSTRAINT related_files_pkey PRIMARY KEY (identifier)
)

TABLESPACE pg_default;