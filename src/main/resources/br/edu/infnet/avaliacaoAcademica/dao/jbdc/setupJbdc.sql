DROP SEQUENCE IF EXISTS question_seq CASCADE;

DROP TABLE IF EXISTS question;

CREATE SEQUENCE question_seq INCREMENT BY 1 NO MINVALUE NO MAXVALUE;

CREATE TABLE question(
        id integer NOT NULL,
        student_id integer NOT NULL,
        question_number integer NOT NULL,
        value integer NOT NULL
);

ALTER TABLE question ADD CONSTRAINT question_id_pk PRIMARY KEY (id);

ALTER TABLE question ADD CONSTRAINT student_fk FOREIGN KEY (student_id) REFERENCES student (id) ON DELETE CASCADE;