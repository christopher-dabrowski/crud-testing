CREATE TABLE public.family_members
(
    id integer NOT NULL,
    name character varying(40) NOT NULL,
    surname character varying(40) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.family_members
    OWNER to postgres;
COMMENT ON TABLE public.family_members
    IS 'Table for storing all family members';

