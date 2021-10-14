set foreign_key_checks = 0;

truncate table product;
truncate table feedback;


insert into product(`id`, `currency`, `details`, `name`, `price`)
values (2, 'USD', 'black ivory ergonomic luxury desk', 'Luxury Desk', 2000.00),
       (3, 'GHC', 'brown luxury pillow', 'Luxury Pillow', 20.00),
       (4, 'NGN', 'yellow wine glass', 'Wine Glass', 20500.00),
       (5, 'CAD', 'four layer silverware knives set', 'Knife Set', 650.00);

set foreign_key_checks =1;