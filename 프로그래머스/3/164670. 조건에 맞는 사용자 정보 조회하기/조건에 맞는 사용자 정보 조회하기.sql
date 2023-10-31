-- 코드를 입력하세요
SELECT USER_ID,NICKNAME,CONCAT(city," ",street_address1," ",street_address2) "전체주소",concat(substring(tlno,1,3),"-",substring(tlno,4,4),'-',substring(tlno,8,4)) "전화번호"
FROM USED_GOODS_USER
WHERE USER_ID IN 
(SELECT WRITER_ID FROM USED_GOODS_BOARD
GROUP BY WRITER_ID
HAVING COUNT(BOARD_ID)>2)
order by user_id desc;