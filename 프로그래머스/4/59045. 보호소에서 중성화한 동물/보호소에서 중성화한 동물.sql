-- 코드를 입력하세요
SELECT animal_id,animal_type,name
FROM ANIMAL_INS
WHERE ANIMAL_ID IN (SELECT ANIMAL_ID
                                     FROM ANIMAL_OUTS
                                     WHERE SEX_UPON_OUTCOME NOT LIKE 'Intact%')
AND SEX_UPON_INTAKE LIKE 'Intact%';