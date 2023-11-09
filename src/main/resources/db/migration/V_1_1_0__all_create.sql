create schema IF NOT EXISTS project;

DROP TABLE IF EXISTS project.job CASCADE;

CREATE TABLE project.job
(
    id          numeric      not null primary key,
    name        varchar(150) NOT NULL,
    description varchar
);

create index IF NOT EXISTS job_name_index
    on project.job (name);

DROP TABLE IF EXISTS project.login CASCADE;

CREATE TABLE IF NOT EXISTS project.login
(
    id       numeric      not null primary key,
    username varchar(150) NOT NULL,
    password varchar(25)  NOT NULL
);

DROP TABLE IF EXISTS project.user CASCADE;

CREATE TABLE project.user
(
    id        numeric not null primary key,
    name      varchar(150),
    surname   varchar(150),
    role      varchar(25),
    job_id    numeric
        constraint user_job_id_fkey
            references project.job,
    mentor_id numeric
        constraint user_mentor_id_fkey
            references project.user,
    archive   boolean
);

ALTER TABLE project.user
    ADD FOREIGN KEY (id) REFERENCES project.login (id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE project.login
    ADD FOREIGN KEY (id) REFERENCES project.user (id) DEFERRABLE INITIALLY DEFERRED;

create index IF NOT EXISTS user_name_index
    on project.user (name);

DROP TABLE IF EXISTS project.target CASCADE;

CREATE TABLE project.target
(
    id            numeric not null primary key,
    name          varchar NOT NULL,
    is_hard_skill boolean,
    is_soft_skill boolean,
    level         varchar NOT NULL,
    is_archived   boolean
);

create index IF NOT EXISTS target_name_index
    on project.target (name);

DROP TABLE IF EXISTS project.skill CASCADE;

CREATE TABLE project.skill
(
    id        numeric not null primary key,
    user_id   numeric
        constraint skill_user_id_fkey
            references project.user,
    target_id numeric
        constraint skill_target_id_fkey
            references project.target,
    job_id    numeric
        constraint skill_job_id_fkey
            references project.job,
    level     varchar NOT NULL
);

DROP TABLE IF EXISTS project.material CASCADE;

CREATE TABLE project.material
(
    id     numeric not null primary key,
    job_id numeric
        constraint material_job_id_fkey
            references project.job,
    level  varchar NOT NULL,
    links  jsonb
);

create index IF NOT EXISTS material_level_index
    on project.material (level);

DROP TABLE IF EXISTS project.course CASCADE;

CREATE TABLE project.course
(
    id          numeric      not null primary key,
    name        varchar(150) NOT NULL,
    description varchar
);

DROP TABLE IF EXISTS project.task CASCADE;

CREATE TABLE project.task
(
    id         numeric      not null primary key,
    start_data date         NOT NULL,
    name       varchar(150) NOT NULL,
    course_id  numeric
        constraint task_course_id_fkey
            references project.course,
    end_data   date         NOT NULL,
    file_link  varchar,
    is_done    boolean
);

DROP TABLE IF EXISTS project.user_task CASCADE;

CREATE TABLE project.user_task
(
    user_id numeric
        constraint user_task_user_id_fkey
            references project.user,
    task_id numeric
        constraint user_task_task_id_fkey
            references project.task
);

DROP TABLE IF EXISTS project.job_target CASCADE;

CREATE TABLE project.job_target
(
    job_id    numeric
        constraint job_target_job_id_fkey
            references project.job,
    target_id numeric
        constraint job_target_target_id_fkey
            references project.target
);

DROP TABLE IF EXISTS project.material_course CASCADE;

CREATE TABLE project.material_course
(
    course_id   numeric
        constraint material_course_course_id_fkey
            references project.course,
    material_id numeric
        constraint material_course_material_id_fkey
            references project.material
);

INSERT INTO project.job(id, name, description)
values (1, 'testJob1', 'des1');
INSERT INTO project.job(id, name, description)
values (2, 'testJob1', 'des1');
INSERT INTO project.job(id, name, description)
values (3, 'testJob1', 'des1');

BEGIN;

INSERT INTO project.login(id, username, password)
values (1, 'testName1', '123456');
INSERT INTO project.login(id, username, password)
values (2, 'testName2', '123456');
INSERT INTO project.login(id, username, password)
values (3, 'testName3', '123456');

INSERT INTO project.user(id, name, surname, role, job_id, mentor_id, archive)
values (1, 'testUserName1', 'testSurname1', 'testRole', 1, null, false);
INSERT INTO project.user(id, name, surname, role, job_id, mentor_id, archive)
values (2, 'testUserName2', 'testSurname2', 'testRole', 1, 1, false);
INSERT INTO project.user(id, name, surname, role, job_id, mentor_id, archive)
values (3, 'testUserName3', 'testSurname3', 'testRole', 2, 2, false);

COMMIT;

INSERT INTO project.target(id, name, is_hard_skill, is_soft_skill, level, is_archived)
values (1, 'testTarget1', true, false, 'testLevel', false);
INSERT INTO project.target(id, name, is_hard_skill, is_soft_skill, level, is_archived)
values (2, 'testTarget2', false, true, 'testLevel', false);
INSERT INTO project.target(id, name, is_hard_skill, is_soft_skill, level, is_archived)
values (3, 'testTarget3', true, false, 'testLevel', true);

INSERT INTO project.job_target(job_id, target_id)
values (1, 1);
INSERT INTO project.job_target(job_id, target_id)
values (1, 2);
INSERT INTO project.job_target(job_id, target_id)
values (2, 2);
INSERT INTO project.job_target(job_id, target_id)
values (2, 3);
INSERT INTO project.job_target(job_id, target_id)
values (3, 1);
INSERT INTO project.job_target(job_id, target_id)
values (3, 2);
INSERT INTO project.job_target(job_id, target_id)
values (3, 2);

INSERT INTO project.skill(id, user_id, target_id, job_id, level)
values (1, 1, 1, 1, 'testLevel');
INSERT INTO project.skill(id, user_id, target_id, job_id, level)
values (2, 1, 2, 1, 'testLevel');
INSERT INTO project.skill(id, user_id, target_id, job_id, level)
values (3, 2, 2, 2, 'testLevel');
INSERT INTO project.skill(id, user_id, target_id, job_id, level)
values (4, 2, 3, 2, 'testLevel');
INSERT INTO project.skill(id, user_id, target_id, job_id, level)
values (5, 3, 1, 3, 'testLevel');
INSERT INTO project.skill(id, user_id, target_id, job_id, level)
values (6, 3, 2, 3, 'testLevel');
INSERT INTO project.skill(id, user_id, target_id, job_id, level)
values (7, 3, 3, 3, 'testLevel');

INSERT INTO project.material(id, job_id, level, links)
values (1, 1, 'testLevel', '{
  "a": "1",
  "b": "1"
}');
INSERT INTO project.material(id, job_id, level, links)
values (2, 2, 'testLevel', '{
  "a": "2",
  "b": "2"
}');
INSERT INTO project.material(id, job_id, level, links)
values (3, 3, 'testLevel', '{
  "a": "3",
  "b": "3"
}');

INSERT INTO project.course(id, name, description)
values (1, 'course1', 'des1');
INSERT INTO project.course(id, name, description)
values (2, 'course2', 'des2');
INSERT INTO project.course(id, name, description)
values (3, 'course3', 'des3');

INSERT INTO project.material_course(course_id, material_id)
values (1, 1);
INSERT INTO project.material_course(course_id, material_id)
values (2, 2);
INSERT INTO project.material_course(course_id, material_id)
values (3, 3);

INSERT INTO project.task(id, start_data, name, course_id, end_data, file_link, is_done)
values (1, to_date('01/08/2023', 'dd/mm/yyyy'), 'testName1', 1, to_date('31/08/2023', 'dd/mm/yyyy'), 'C:\TEST1', false);
INSERT INTO project.task(id, start_data, name, course_id, end_data, file_link, is_done)
values (2, to_date('10/09/2023', 'dd/mm/yyyy'), 'testName2', 2, to_date('10/10/2023', 'dd/mm/yyyy'), 'C:\TEST2', false);
INSERT INTO project.task(id, start_data, name, course_id, end_data, file_link, is_done)
values (3, to_date('01/08/2023', 'dd/mm/yyyy'), 'testName3', 3, to_date('25/08/2023', 'dd/mm/yyyy'), 'C:\TEST3', false);
INSERT INTO project.task(id, start_data, name, course_id, end_data, file_link, is_done)
values (4, to_date('12/07/2023', 'dd/mm/yyyy'), 'testName4', 2, to_date('25/09/2023', 'dd/mm/yyyy'), 'C:\TEST4', false);
INSERT INTO project.task(id, start_data, name, course_id, end_data, file_link, is_done)
values (5, to_date('01/11/2023', 'dd/mm/yyyy'), 'testName5', 3, to_date('25/11/2023', 'dd/mm/yyyy'), 'C:\TEST5', false);
INSERT INTO project.task(id, start_data, name, course_id, end_data, file_link, is_done)
values (6, to_date('01/08/2023', 'dd/mm/yyyy'), 'testName6', 1, to_date('25/08/2023', 'dd/mm/yyyy'), 'C:\TEST6', false);

INSERT INTO project.user_task(user_id, task_id)
values (1, 1);
INSERT INTO project.user_task(user_id, task_id)
values (1, 3);
INSERT INTO project.user_task(user_id, task_id)
values (1, 5);
INSERT INTO project.user_task(user_id, task_id)
values (1, 6);
INSERT INTO project.user_task(user_id, task_id)
values (2, 1);
INSERT INTO project.user_task(user_id, task_id)
values (2, 2);
INSERT INTO project.user_task(user_id, task_id)
values (3, 3);
INSERT INTO project.user_task(user_id, task_id)
values (3, 4);