-- 코드를 입력하세요
SELECT substring(product_code,1,2) CATEGORY,count(product_id) products
from product
group by substring(product_code,1,2)