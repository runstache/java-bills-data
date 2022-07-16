-- Table: public.bills

-- DROP TABLE IF EXISTS public.bills;

CREATE TABLE IF NOT EXISTS public.bills
(
    identifier character varying(50) COLLATE pg_catalog."default" NOT NULL,
    title text COLLATE pg_catalog."default",
    description text COLLATE pg_catalog."default",
    url character varying(255) COLLATE pg_catalog."default" NOT NULL,
    published_date timestamp with time zone NOT NULL,
    prime_sponsor character varying(500) COLLATE pg_catalog."default",
    co_sponsors character varying(5000) COLLATE pg_catalog."default",
    last_action character varying(1000) COLLATE pg_catalog."default",
    enacted boolean NOT NULL,
    passed_house boolean NOT NULL,
    passed_senate boolean NOT NULL,
    created_on timestamp with time zone NOT NULL,
    updated_on timestamp with time zone NOT NULL,
    CONSTRAINT bills_pkey PRIMARY KEY (identifier)
)

TABLESPACE pg_default;
