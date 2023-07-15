CREATE TABLE photo(
  id SERIAL PRIMARY KEY,
  content OID NOT NULL,
  created_at date DEFAULT NOW()
);
