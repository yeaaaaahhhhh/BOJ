-- 코드를 입력하세요
SELECT CAR_ID, A.CAR_TYPE,ROUND(DAILY_FEE*(100-PERC)*0.3) FEE
FROM CAR_RENTAL_COMPANY_CAR A 
JOIN (SELECT CAR_TYPE,IFNULL(DISCOUNT_RATE,0) PERC 
                                    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN WHERE DURATION_TYPE="30일 이상") B
ON A.CAR_TYPE=B.CAR_TYPE
WHERE ROUND(DAILY_FEE*(100-PERC)*0.3) BETWEEN 500000 AND 2000000
AND CAR_ID NOT IN (SELECT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE<= "2022-11-30" AND END_DATE >= "2022-11-01")
AND A.CAR_TYPE IN ('세단','SUV')
ORDER BY 3 DESC, 2, 1 DESC;

# SELECT *
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE START_DATE<= "2022-11-30" AND END_DATE >= "2022-11-01"