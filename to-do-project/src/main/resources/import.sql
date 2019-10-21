insert into Task (username, category, created_at) values ('david123', 'Fozes', CURRENT_TIMESTAMP());
insert into Task (username, category, created_at) values ('david123', 'Vasarlas', CURRENT_TIMESTAMP());
insert into Task (username, category, created_at) values ('mark123', 'Mosogatas', CURRENT_TIMESTAMP());
insert into Task (username, category, created_at) values ('mark123', 'Vasalas', CURRENT_TIMESTAMP());

insert into Description (text, created_at, task_id) values ('Ne felejts el sot rakni', CURRENT_TIMESTAMP(),1);
insert into Description (text, created_at, task_id) values ('Kenyer es tej', CURRENT_TIMESTAMP(),2);
insert into Description (text, created_at, task_id) values ('Csak az ingeket', CURRENT_TIMESTAMP(),4);
insert into Description (text, created_at, task_id) values ('Vasalot huzd ki miutan vegeztel', CURRENT_TIMESTAMP(),4); 

insert into Family (familyname) values('Miklos');
insert into Family (familyname) values('Bognar');

insert into User (username, password, enabled, role, family_id) values ('david123', 'alma', true, 'ROLE_ADMIN',1);
insert into User (username, password, enabled, role, family_id) values ('mark123', 'korte', true, 'ROLE_USER',2); 
insert into User (username, password, enabled, role, family_id) values ('izu123', 'eper', true, 'ROLE_USER',1); 

insert into task_users (tasks_id, users_id) values (1, 1);
insert into task_users (tasks_id, users_id) values (1, 2);
insert into task_users (tasks_id, users_id) values (1, 3);
insert into task_users (tasks_id, users_id) values (2, 1);
insert into task_users (tasks_id, users_id) values (3, 2);
insert into task_users (tasks_id, users_id) values (4, 3);
