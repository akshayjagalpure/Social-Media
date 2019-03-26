-- init data

-- User Data
INSERT INTO `T_USER` (username, password, email, activated, date_created, bio, roles) VALUES ('admin', '$2a$10$HiaJpKERbSfcZcuG5vcvlOZDG6Y/5SkDKi9RvKsSK3t3Spl9.7u6u', 'admin@admin.com', 1, '2017-11-02', 'admin bio', 'ADMIN,USER');
INSERT INTO `T_USER` (username, password, email, activated, date_created, bio, roles) VALUES ('user', '$2a$10$Dr2lvPjmjiMuWf3mcMlyQeSbxFHI5LDLudHIB/fK/uygI1pnKk/3m', 'user@user.com', 1, '2017-11-02', 'user bio', 'USER');
INSERT INTO `T_USER` (username, password, email, activated, date_created, bio, roles) VALUES ('universityadmin', '$2a$10$HiaJpKERbSfcZcuG5vcvlOZDG6Y/5SkDKi9RvKsSK3t3Spl9.7u6u', 'university@admin.com', 1, '2017-11-02', 'admin bio', 'ADMIN,USER');
INSERT INTO `T_USER` (username, password, email, activated, date_created, bio, roles) VALUES ('collageadmin', '$2a$10$HiaJpKERbSfcZcuG5vcvlOZDG6Y/5SkDKi9RvKsSK3t3Spl9.7u6u', 'collage@admin.com', 1, '2017-11-02', 'admin bio', 'ADMIN,USER');

-- Category Data
INSERT INTO `T_CATEGORY` (name, weight, display_name, username, date_created) VALUES ('java', 1, 'Java', 'admin', '2017-11-02');
INSERT INTO `T_CATEGORY` (name, weight, display_name, username, date_created) VALUES ('python', 2, 'Python', 'user', '2017-11-02');
INSERT INTO `T_CATEGORY` (name, weight, display_name, username, date_created) VALUES ('job-hunting', 3, 'Job hunting', 'user', '2017-11-02');

-- Post Data
INSERT INTO `T_POST` (title, body, date_created, user_id, category_id) VALUES (
'Lorem ipsum dolor sit amet, consectetur adipiscing elit',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sed turpis sem. Maecenas varius mauris sit amet sem dignissim, in vehicula sem lacinia. Sed eget mauris sit amet urna aliquam cursus. Vivamus malesuada vel erat vitae faucibus. Pellentesque varius turpis a urna auctor semper. Phasellus vulputate magna at interdum iaculis. Suspendisse blandit, ipsum nec aliquet eleifend, libero lectus pretium tellus, nec maximus ante felis vitae quam. Morbi placerat consequat eros, eget convallis libero feugiat lobortis. Pellentesque quis auctor ligula.',
'2017-10-01 23:23:23', 2, 1);

INSERT INTO `T_POST` (title, body, date_created, user_id, category_id) VALUES (
'In hac habitasse platea dictumst.',
'In hac habitasse platea dictumst. Etiam ultricies justo ante, ac sollicitudin dolor commodo id. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam sapien justo, consequat eu lacus ut, elementum congue magna. Praesent ultrices ex tellus, in ornare tellus cursus in. In ultrices odio et leo scelerisque tincidunt. Cras tempus, nulla et porttitor cursus, nunc ex molestie turpis, et fermentum neque arcu vitae arcu. Cras fringilla viverra dolor. Mauris tortor augue, tempor varius purus ut, auctor aliquam ante. Integer non est lectus. Nulla vitae sodales felis, lacinia sodales enim. Nam feugiat finibus sapien ac placerat. Vivamus et mi vestibulum, lacinia nulla a, convallis mi. Phasellus lacus dui, accumsan id feugiat sit amet, pulvinar vel est. Aenean sed metus at nunc sagittis rutrum eu ut risus. Maecenas faucibus egestas nunc, eu blandit nunc viverra eget.',
'2017-10-02 23:23:23', 1, 2);

INSERT INTO `T_POST` (title, body, date_created, user_id, category_id) VALUES (
'Praesent nec iaculis velit',
'Praesent nec iaculis velit. Vestibulum hendrerit, dolor vitae tincidunt pellentesque, ex mauris lobortis quam, vel ornare dolor lacus nec sem. Praesent auctor libero in ligula dapibus euismod. Sed pharetra laoreet arcu, ut imperdiet mi porta et. Vestibulum a tempor augue, sed tincidunt ex. Vestibulum eleifend diam lacus, eget vestibulum risus aliquam eget. Morbi eu ultrices magna, eu tristique risus. Nulla tincidunt aliquam lacus id elementum. Donec efficitur suscipit elementum. Phasellus sed accumsan dui. Nulla vel bibendum velit. Praesent hendrerit mauris ut nunc iaculis mollis. Morbi luctus porttitor diam quis tincidunt.',
'2017-10-03 23:23:23', 1, 3);

INSERT INTO `T_POST` (title, body, date_created, user_id, category_id) VALUES (
'Proin vel diam augue',
'Proin vel diam augue. Sed sed aliquet quam. Sed a lacus turpis. Ut dapibus odio quam, a ultrices nunc imperdiet ut. Nulla et eros leo. Aenean dictum, elit nec facilisis blandit, lectus risus tincidunt lacus, non lobortis odio leo vitae nisl. Maecenas ac urna at purus laoreet ullamcorper vitae nec turpis.',
'2017-10-04 23:23:23', 2, 1);

INSERT INTO `T_POST` (title, body, date_created, user_id, category_id) VALUES (
'Lorem ipsum dolor sit amet',
'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam lobortis malesuada tellus, sed imperdiet urna bibendum ut. Maecenas non ultrices sem. Fusce eleifend ultrices diam, sed laoreet turpis scelerisque ac. Ut consectetur, diam sed lobortis consectetur, urna orci mattis elit, ac tincidunt tortor erat eu risus. Sed enim sapien, vulputate at venenatis vitae, cursus sed arcu. Morbi quis purus congue, aliquet risus eget, placerat erat. Donec placerat, purus ac consectetur semper, ligula metus congue nisl, quis fermentum mi elit sit amet orci. Sed ut felis ac quam vestibulum lacinia sagittis fringilla magna. Ut id pretium orci, eget fermentum eros. Morbi rutrum arcu vitae purus vulputate fermentum. Morbi ultricies, est id faucibus varius, leo eros ullamcorper leo, id malesuada est dui ac ex.',
'2017-10-05 23:23:23', 1, 2);

INSERT INTO `T_POST` (title, body, date_created, user_id, category_id) VALUES (
'Suspendisse sodales ante eget malesuada finibus',
'Suspendisse sodales ante eget malesuada finibus. Maecenas convallis viverra massa ac interdum. Duis pretium suscipit dolor. Praesent eu neque vitae ex tristique vulputate ut quis turpis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin in nibh malesuada, molestie erat quis, pharetra mauris. Pellentesque vulputate vitae sem eu bibendum.',
'2017-10-06 23:23:23', 1, 1);

INSERT INTO `T_POST` (title, body, date_created, user_id, category_id) VALUES (
'Maecenas dignissim, nunc et volutpat ultrices, quam arcu varius justo, ut sollicitudin justo velit at orci',
'Maecenas dignissim, nunc et volutpat ultrices, quam arcu varius justo, ut sollicitudin justo velit at orci. Ut at mauris blandit, efficitur elit ac, finibus ante. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Maecenas aliquet, tellus non lobortis pulvinar, neque risus tincidunt augue, sit amet pharetra urna diam nec odio. Morbi at consequat diam. Aliquam erat volutpat. Curabitur tristique eleifend arcu. Cras consequat felis a enim vestibulum, nec sagittis odio aliquet. Duis ultricies sem a erat rhoncus, id suscipit urna ornare. Sed non ex volutpat, venenatis sem et, elementum nibh. Maecenas interdum efficitur pellentesque. Vivamus consequat convallis tellus, nec sagittis ipsum scelerisque in. Vestibulum vel dui pellentesque, dictum neque in, tincidunt sem.',
'2017-10-07 23:23:23', 1, 2);



-- comments data
INSERT INTO `T_COMMENT` (post_id, user_id, body, date_created) VALUES (
52, 1, "Reply content 1", '2017-11-23 23:23:23');

INSERT INTO `T_COMMENT` (post_id, user_id, body, date_created) VALUES (
52, 2, "Reply content 2", '2017-11-24 23:23:23');

INSERT INTO `T_COMMENT` (post_id, user_id, body, date_created) VALUES (
52, 2, "Reply content 3", '2017-11-25 23:23:23');

INSERT INTO `T_COMMENT` (post_id, user_id, body, date_created) VALUES (
51, 1, "Reply content 4", '2017-11-26 23:23:23');

INSERT INTO `T_COMMENT` (post_id, user_id, body, date_created) VALUES (
51, 1, "Reply content 5", '2017-11-27 23:23:23');


