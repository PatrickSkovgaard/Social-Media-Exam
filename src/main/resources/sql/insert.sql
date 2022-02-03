INSERT INTO user(age, first_name, last_name, short_description) VALUES (23, 'Hans', 'Højhed', 'Hey der, jeg hedder Hansi-mann');
INSERT INTO user(age, first_name, last_name, short_description) VALUES (55, 'Keld', 'Ling', 'Goddav, jeg er gamle Keld og jeg er i Kina');

INSERT INTO post(post_description, post_title, user_id) VALUES ('min beskrivelse', 'min titel', 1);
INSERT INTO post(post_description, post_title, user_id) VALUES ('elsker kinananer', 'Jeg', 2);

INSERT INTO hashtag(hash_word, post_id) VALUES ('#HansHøjhed', 1);
INSERT INTO hashtag(hash_word, post_id) VALUES ('#KeldLing', 2);
INSERT INTO hashtag(hash_word, post_id) VALUES ('#McDonalds4Life', 2);

Select * from hashtag;