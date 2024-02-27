-- 코드를 입력하세요
SELECT b.AUTHOR_ID,b.AUTHOR_NAME,a.CATEGORY,sum(a.price*c.sales) as TOTAL_SALES from book a
join author b on a.author_id = b.author_id
join book_sales c on a.book_id = c.book_id
where Year(SALES_DATE)=2022
                   and Month(SALES_DATE)=01
# where a.book_id in (select book_id from book_sales
#                            where Year(SALES_DATE)=2022
#                    and Month(SALES_DATE)=01)
group by a.author_id,a.category
order by a.author_id,a.category desc