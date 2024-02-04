SELECT article.*, user.email AS author_email
FROM article
INNER JOIN user ON article.author_id = user.id
ORDER BY id;

SELECT *
FROM article
ORDER BY id
LIMIT 6, 6;

