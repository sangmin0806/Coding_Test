-- 코드를 입력하세요
SELECT MONTH(start_date) as MONTH,CAR_ID,count(*)as RECORDS from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date between '2022-08-01' and '2022-10-31'
and car_id in (select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
               where start_date between '2022-08-01' and '2022-10-31'
              group by car_id having count(*)>=5)
group by MONTH,car_id having records>0
order by MONTH, car_id desc