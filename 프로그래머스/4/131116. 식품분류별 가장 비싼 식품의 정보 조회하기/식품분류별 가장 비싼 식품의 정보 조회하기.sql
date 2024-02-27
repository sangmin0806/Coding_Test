-- 코드를 입력하세요
SELECT CATEGORY,max(price) as MAX_PRICE,PRODUCT_NAME from FOOD_PRODUCT 
where PRICE in(select max(price)  from food_product group by CATEGORY)
and category in ('과자','국','김치','식용유')
group by category
order by max_price desc
