select customer_id 
from Customer
group by customer_id
having Count(Distinct product_key )= (
    select Count(*)
    from product
)