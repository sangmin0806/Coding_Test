-- 코드를 입력하세요
SELECT food_type,rest_id,rest_name,favorites from rest_info
 where favorites IN (select max(favorites)  from rest_info group by food_type)
group by food_type HAVING FAVORITES = MAX(FAVORITES)
order by food_type desc