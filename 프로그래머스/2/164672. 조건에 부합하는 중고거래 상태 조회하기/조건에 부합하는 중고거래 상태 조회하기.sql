-- 코드를 입력하세요
SELECT BOARD_ID,WRITER_ID,TITLE,PRICE,
(CASE status 
    when "DONE" then "거래완료"
    when "SALE" then "판매중"
    when "RESERVED" then "예약중" end) as STATUS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE="2022-10-05"
order by board_id desc;