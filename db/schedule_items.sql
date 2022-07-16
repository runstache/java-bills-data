-- Table: public.schedule_items

-- DROP TABLE IF EXISTS public.schedule_items;

CREATE TABLE IF NOT EXISTS public.schedule_items
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    identifier character varying(50) COLLATE pg_catalog."default" NOT NULL,
    schedule_date timestamp with time zone NOT NULL,
    schedule_type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp with time zone NOT NULL,
    updated_on timestamp with time zone NOT NULL,
    CONSTRAINT schedule_items_pkey PRIMARY KEY (identifier)
)

TABLESPACE pg_default;
