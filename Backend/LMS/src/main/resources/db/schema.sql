CREATE TABLE `book_loans` (
                              `due_date` date NOT NULL,
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `issue_date_time` datetime(6) DEFAULT NULL,
                              `user_id` bigint NOT NULL,
                              `version` bigint DEFAULT NULL,
                              `book_isbn` varchar(255) NOT NULL,
                              `status` enum('AVAILABLE','NOT_RETURNED') NOT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `books` (
                         `book_copies` int NOT NULL,
                         `created_at` datetime(6) DEFAULT NULL,
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `isbn` varchar(20) NOT NULL,
                         `author` varchar(50) NOT NULL,
                         `category` varchar(50) NOT NULL,
                         `name` varchar(50) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `UKkibbepcitr0a3cpk3rfr7nihn` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
                         `created_at` datetime(6) DEFAULT NULL,
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `phone` varchar(10) NOT NULL,
                         `first_name` varchar(50) NOT NULL,
                         `last_name` varchar(50) NOT NULL,
                         `email` varchar(255) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;