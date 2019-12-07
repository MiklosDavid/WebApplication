insert into Task (username, category, status, created_at, updated_at) values ('david', 'Fozes', 'NEW', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into Task (username, category, status, created_at, updated_at) values ('david', 'Vasarlas', 'INPROGRESS', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into Task (username, category, status, created_at, updated_at) values ('mark', 'Mosogatas', 'INPROGRESS', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());
insert into Task (username, category, status, created_at, updated_at) values ('mark', 'Vasalas', 'RESOLVED', CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP());

insert into Description (text, created_at, task_id, updated_at) values ('Ne felejts el sot rakni', CURRENT_TIMESTAMP(),1,  CURRENT_TIMESTAMP());
insert into Description (text, created_at, task_id, updated_at) values ('Kenyer es tej', CURRENT_TIMESTAMP(),2,  CURRENT_TIMESTAMP());
insert into Description (text, created_at, task_id, updated_at) values ('Csak az ingeket', CURRENT_TIMESTAMP(),4,  CURRENT_TIMESTAMP());
insert into Description (text, created_at, task_id, updated_at) values ('Vasalot huzd ki miutan vegeztel', CURRENT_TIMESTAMP(),4,  CURRENT_TIMESTAMP()); 

insert into Family (familyname) values('Miklos');
insert into Family (familyname) values('Bognar');

insert into User (username, password, enabled, role, family_id) values ('david', '$2a$04$cemjD7I4gSNjYIgVOkwhNOdId1AZeIH9lBPJVMVYbC3/8u3dM7i6S', true, 'ROLE_ADMIN',1);
insert into User (username, password, enabled, role, family_id) values ('mark', '$2a$04$cemjD7I4gSNjYIgVOkwhNOdId1AZeIH9lBPJVMVYbC3/8u3dM7i6S', true, 'ROLE_USER',2); 
insert into User (username, password, enabled, role, family_id) values ('izu', '$2a$04$cemjD7I4gSNjYIgVOkwhNOdId1AZeIH9lBPJVMVYbC3/8u3dM7i6S', true, 'ROLE_USER',1); 

insert into task_users (tasks_id, users_id) values (1, 1);
insert into task_users (tasks_id, users_id) values (1, 2);
insert into task_users (tasks_id, users_id) values (1, 3);
insert into task_users (tasks_id, users_id) values (2, 1);
insert into task_users (tasks_id, users_id) values (3, 2);
insert into task_users (tasks_id, users_id) values (4, 3);
