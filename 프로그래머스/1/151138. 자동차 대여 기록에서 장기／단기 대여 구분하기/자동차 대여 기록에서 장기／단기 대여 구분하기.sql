-- 코드를 입력하세요
SELECT HISTORY_ID,CAR_ID,date_format(start_date,"%Y-%m-%d") START_DATE,date_format(end_date,"%Y-%m-%d") END_DATE,CASE WHEN datediff(END_DATE,START_DATE)+1>=30 THEN "장기 대여"
ELSE "단기 대여" END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE YEAR(START_DATE)=2022 AND MONTH(START_DATE)=9
order by history_id desc;