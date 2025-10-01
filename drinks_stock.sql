ALTER TABLE drinks
    ADD COLUMN stock INTEGER NOT NULL DEFAULT 0 check (stock >= 0);

UPDATE drinks
SET stock = FLOOR(random() * 101)::int;