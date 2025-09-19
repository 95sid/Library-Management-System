INSERT INTO users (first_name, last_name, phone, email, created_at) VALUES
                                                                        ('John', 'Doe', '1234567890', 'john.doe@example.com', NOW()),
                                                                        ('Jane', 'Smith', '0987654321', 'jane.smith@example.com', NOW()),
                                                                        ('Peter', 'Jones', '5551112222', 'peter.jones@example.com', NOW()),
                                                                        ('Mary', 'Brown', '3334445555', 'mary.brown@example.com', NOW()),
                                                                        ('Robert', 'Wilson', '6667778888', 'robert.wilson@example.com', NOW());

INSERT INTO books (name, author, category, isbn, book_copies) VALUES
                                                                  ('Clean Code', 'Robert C. Martin', 'Programming', 'ISBN100001', 5),
                                                                  ('Effective Java', 'Joshua Bloch', 'Programming', 'ISBN100002', 4),
                                                                  ('Design Patterns', 'Erich Gamma', 'Programming', 'ISBN100003', 6),
                                                                  ('Spring in Action', 'Craig Walls', 'Programming', 'ISBN100004', 7),
                                                                  ('Java Concurrency in Practice', 'Brian Goetz', 'Programming', 'ISBN100005', 3),

                                                                  ('The Pragmatic Programmer', 'Andrew Hunt', 'Programming', 'ISBN100006', 5),
                                                                  ('Head First Design Patterns', 'Eric Freeman', 'Programming', 'ISBN100007', 8),
                                                                  ('Algorithms', 'Robert Sedgewick', 'Computer Science', 'ISBN100008', 6),
                                                                  ('Introduction to Algorithms', 'Thomas H. Cormen', 'Computer Science', 'ISBN100009', 9),
                                                                  ('Artificial Intelligence', 'Stuart Russell', 'Computer Science', 'ISBN100010', 4),

                                                                  ('Database System Concepts', 'Abraham Silberschatz', 'Database', 'ISBN100011', 5),
                                                                  ('Operating System Concepts', 'Abraham Silberschatz', 'Operating Systems', 'ISBN100012', 7),
                                                                  ('Computer Networks', 'Andrew S. Tanenbaum', 'Networking', 'ISBN100013', 6),
                                                                  ('Modern Operating Systems', 'Andrew S. Tanenbaum', 'Operating Systems', 'ISBN100014', 8),
                                                                  ('Deep Learning', 'Ian Goodfellow', 'Machine Learning', 'ISBN100015', 5),

                                                                  ('Pattern Recognition and ML', 'Christopher Bishop', 'Machine Learning', 'ISBN100016', 4),
                                                                  ('Python Crash Course', 'Eric Matthes', 'Programming', 'ISBN100017', 10),
                                                                  ('You Don’t Know JS', 'Kyle Simpson', 'Programming', 'ISBN100018', 7),
                                                                  ('Learning SQL', 'Alan Beaulieu', 'Database', 'ISBN100019', 6),
                                                                  ('HTML & CSS: Design and Build Websites', 'Jon Duckett', 'Web Development', 'ISBN100020', 8);
