INSERT INTO permission
    (NAME)
VALUES ('ADD_MOVIE'),
       ('EDIT_MOVIE'),
       ('DELETE_MOVIE'),
       ('VIEW_MOVIE');

INSERT INTO role (NAME)
VALUES ('ROLE_ADMIN'),
       ('ROLE_USER');
INSERT
INTO permission_role(PERMISSION_ID, ROLE_ID)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (4, 2);
INSERT INTO user (id, username, password, email, enabled, account_non_expired, credentials_non_expired,
                  account_non_locked)
VALUES ('1', 'admin', '$2y$12$sYFxHiJItCLTrHQ1oIwufeiaS5GZYRQdzu85BV8XmYlJZeSSS9396', 'admin', '1', '1', '1', '1');
insert into user (id, username, password, email, enabled, account_non_expired, credentials_non_expired,
                  account_non_locked)
VALUES ('2', 'test', '$2y$12$JE74cPcY11j8lahrmnftB.pTpi91h.qV4Uf2bpL3jtZaiOjbd5FTG', 'user', '1',
        '1', '1', '1');
INSERT INTO role_user(ROLE_ID, USER_ID)
VALUES (1, 1),
       (2, 2);
INSERT INTO url_permission(id,role_id,title,icon,link) VALUES (1,1,'Dashboard','home-outline','/user/dashboard');
INSERT INTO url_permission(id,role_id,title,icon,link) VALUES (2,1,'Movies','people-outline','/user/movies');
INSERT INTO url_permission(id,role_id,title,icon,link) VALUES (3,1,'Tickets','file-text-outline','/user/tickets');
INSERT INTO url_permission(id,role_id,title,icon,link) VALUES (4,1,'Booking History','archive-outline','/user/history');
INSERT INTO url_permission(id,role_id,title,icon,link) VALUES (5,1,'Payment Methods','credit-card-outline','/user/payments');

INSERT INTO url_permission(id,role_id,title,icon,link) VALUES (6,2,'Bookings','lock-outline','/user/bookings');
INSERT INTO url_permission(id,role_id,title,icon,link) VALUES (7,2,'User Booking History','briefcase-outline','/user/userHistory');
