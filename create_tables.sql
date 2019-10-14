CREATE TABLE public.family_members
(
    name character varying(40) NOT NULL,
    id integer NOT NULL,
    surname character varying(40) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.family_members
    OWNER to postgres;
COMMENT ON TABLE public.family_members
    IS 'Table for storing all family members';