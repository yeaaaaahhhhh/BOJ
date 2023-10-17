-- 코드를 입력하세요
SELECT MCDP_CD "진료과코드", COUNT(PT_NO) "5월예약건수"
FROM APPOINTMENT
WHERE APNT_YMD BETWEEN "2022-05-01" AND "2022-05-31"
GROUP BY MCDP_CD
order by 2,1;