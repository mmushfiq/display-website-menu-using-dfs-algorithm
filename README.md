# Display website menu using DFS algorithm
<br/>

### We have website menu as the same following image:
![blog-menu](http://www.mycertnotes.com/wp-content/uploads/2018/08/Blog-Menu.jpg)
<br/><br/>


### We have to print it such as:
```
MENU
    1 Home
    2 Certification Exam
        2.1 Exam preparation: step by step
        2.2 Exam Topics
        2.3 Exam Experience
    3 Sample questions
        3.1 Oracle
            3.1.1 1Z0-803 (OCA 7)
            3.1.2 1Z0-804 (OCP 7)
            3.1.3 1Z0-805 (Upgrade to Java SE 7)
            3.1.4 1Z0-808 (OCA 8)
            3.1.5 1Z0-809 (OCP 8)
            3.1.6 1Z0-810 (Upgrade SE 7 to 8 OCP)
            3.1.7 1Z0-813 (Upgrade to SE 8 OCP)
    4 My Books
        4.1 My Certification Notes
    5 Articles
    6 News
    7 Mix
    8 Feedbacks
    9 About
```
<br/>

### Information about website menu is kept in DB as the following format:
```sql
CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

id | parent_id | name
--- | --- | ---
0  |	-1 |	MENU
1  |	0  |	Home
2  |	0  |	Certification Exam
3  |	0  |	Sample questions
4  |	0  |	My Books
5  |	0  |	Articles
6  |	0  |	News
7  |	0  |	Mix
8  |	0  |	Feedbacks
9  |	0  |	About
10 |	2  |	Exam preparation: step by step
11 |	2  |	Exam Topics
12 |	2  |	Exam Experience
13 |	3  |	Oracle
14 |	13 |	1Z0-803 (OCA 7)
15 |	13 |	1Z0-804 (OCP 7)
16 |	13 |	1Z0-805 (Upgrade to Java SE 7)
17 |	13 |	1Z0-808 (OCA 8)
18 |	13 |	1Z0-809 (OCP 8)
19 |	13 |	1Z0-810 (Upgrade SE 7 to 8 OCP)
20 |	13 |	1Z0-813 (Upgrade to SE 8 OCP)
21 |	4  |	My Certification Notes
<br/>


### Website menu as the graph format:<br/>
![blog-menu-graph](http://www.mycertnotes.com/wp-content/uploads/2018/08/Blog-Menu-Graph.png)
<br/>
<br/>
### DFS algorithm:<br/>
![dfs-algorithm](http://www.mycertnotes.com/wp-content/uploads/2018/08/DFS-vs-BFS.gif)


