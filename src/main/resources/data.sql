INSERT INTO roles VALUES (1, 'ROLE_USER'),
                         (2, 'ROLE_ADMIN');

INSERT INTO users VALUES (1, 59, 'James', 'Hetfield', '$2a$12$TwPDdJsCQoGKtt7r/3r5Zu93Bwb4WVgkTA/8GuxFTe85VkBd.yXKW', 'hetfield@metallica.com'),
                         (2, 58, 'Lars', 'Ulrich', '$2a$12$kWpjFlmGSQ6w23ryT8n8B.qtW/SJvWuuvzxDZvH3IO/3oZN/rxdiG', 'ulrich@metallica.com'),
                         (3, 59, 'Kirk', 'Hammett', '$2a$12$lAv4jKoAof673BtVaHYzieNV4kGd1R0e0e6vArzHw5S9ksp5ge3FW', 'hammett@metallica.com'),
                         (4, 57, 'Robert', 'Trujillo', '$2a$12$C.JnGRiHuqz7Kg5HShg6nuJbku.eNgZCSK6RnAD6eGu8Kh7Eglx4e', 'trujillo@metallica.com');

INSERT INTO users_roles VALUES (1, 1),
                               (1, 2),
                               (2, 1),
                               (2, 2),
                               (3, 1),
                               (4, 1);