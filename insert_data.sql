INSERT INTO public.product(
	id, name)
	VALUES 
    (1, 'mleko'),
    (2, 'chleb'),
	(3, 'szynka'),
	(4, 'ser'),
	(5, 'woda'),
	(6, 'mąka'),
    (7, 'cukier'),
    (8, 'kefir');

INSERT INTO public.family_member(
	id, name, surname)
	VALUES
	(1, 'Jan', 'Dudek'),
	(2, 'Hanna', 'Dudek'),
	(3, 'Tomek', 'Dudek'),
	(4, 'Ola', 'Dudek');

INSERT INTO public.shopping_list(
	product_id, amount)
	VALUES
	(2, 2),
	(4, 1),
	(6, 2),
	(5, 3);

INSERT INTO public.purchase(
	product_id, price, date, family_member, amount, settled)
	VALUES 
	(1, 4.20, NOW() - interval '1 day 3 hours', 2, 3, false),
	(2, 2.85, NOW() - interval '10 day 3 hours', 1, 2, true),
	(7, 6.99, NOW() - interval '0 day 7 hours', 2, 1, false),
    (4, 3.99, NOW() - interval '2 day 0 hours', 3, 1, false),
    (4, 3.99, NOW() - interval '1 day 5 hours', 3, 2, false);


