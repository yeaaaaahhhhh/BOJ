-- 코드를 작성해주세요

SELECT A.ID,B.FISH_NAME,A.LENGTH
FROM FISH_INFO A JOIN FISH_NAME_INFO B
ON A.FISH_TYPE=B.FISH_TYPE
WHERE (A.LENGTH,A.FISH_TYPE)
IN (SELECT MAX(LENGTH) AS LENGTH, FISH_TYPE 
      FROM FISH_INFO WHERE LENGTH IS NOT NULL
      GROUP BY FISH_TYPE)
ORDER BY A.ID;
