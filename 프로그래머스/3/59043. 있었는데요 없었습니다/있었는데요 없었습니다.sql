-- 코드를 입력하세요
# SELECT A.ANIMAL_ID,A.NAME FROM ANIMAL_INS A,ANIMAL_OUTS B WHERE A.DATETIME>B.DATETIME AND A.ANIMAL_ID=B.ANIMAL_ID
# ORDER BY A.DATETIME;

SELECT A.ANIMAL_ID,A.NAME
FROM ANIMAL_INS A JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID=B.ANIMAL_ID
WHERE A.DATETIME>B.DATETIME
ORDER BY A.DATETIME;