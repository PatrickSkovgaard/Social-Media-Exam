INSERT INTO user(age, user_name, short_description) VALUES (23, 'Hansi-Master53', 'Hey der, jeg hedder Hansi-mann');
INSERT INTO user(age, user_name, short_description) VALUES (55, 'Keld-Ling73', 'Goddav, jeg er gamle Keld og jeg er i Kina');

INSERT INTO post(post_title, post_content, date_created, user_id) VALUES ('TITEL', 'SE HER!!!','2022-02-04', 1);
INSERT INTO post(post_title, post_content, date_created,  user_id) VALUES ('Love', 'elsker bananer', '2022-01-15', 2);

INSERT INTO hashtag(hash_word, post_id) VALUES ('#HansHøjhed', 1);
INSERT INTO hashtag(hash_word, post_id) VALUES ('#Keld-Ling', 2);
INSERT INTO hashtag(hash_word, post_id) VALUES ('#McDonalds4Life', 2);

Select * from post;