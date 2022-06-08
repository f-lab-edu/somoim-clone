CREATE SCHEMA IF NOT EXISTS `somoim` DEFAULT CHARACTER SET utf8 ;
USE `somoim` ;

CREATE TABLE IF NOT EXISTS `somoim`.`image`
(
    `id`        BIGINT       NOT NULL AUTO_INCREMENT,
    `path`      VARCHAR(260) NOT NULL,
    `create_at` DATETIME     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`user`
(
    `id`         BIGINT      NOT NULL AUTO_INCREMENT,
    `email`      VARCHAR(45) NOT NULL UNIQUE,
    `password`   VARCHAR(65) NOT NULL,
    `name`       VARCHAR(45),
    `birth`      VARCHAR(45),
    `gender`     enum ('M', 'F'),
    `city_code1` INT,
    `city_code2` INT,
    `image_id`   BIGINT,
    `create_at`  DATETIME    NOT NULL,
    `modify_at`  DATETIME    NOT NULL,
    `disband`    TINYINT,
    PRIMARY KEY (`id`),
    KEY `ix_citycode` (`city_code1`, `city_code2`),
    CONSTRAINT `fk_user_image`
        FOREIGN KEY (`image_id`)
            REFERENCES `somoim`.`image` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`category`
(
    `id`     BIGINT      NOT NULL AUTO_INCREMENT,
    `level`  INT         NOT NULL,
    `parent` INT         NOT NULL,
    `name`   VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`interest`
(
    `id`          BIGINT NOT NULL AUTO_INCREMENT,
    `user_id`     BIGINT NOT NULL,
    `category_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_interest_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `somoim`.`user` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    CONSTRAINT `fk_interest_category`
        FOREIGN KEY (`category_id`)
            REFERENCES `somoim`.`category` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`group`
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT,
    `category_id` BIGINT      NOT NULL,
    `image_id`    BIGINT,
    `city_code1`  INT         NOT NULL,
    `city_code2`  INT         NOT NULL,
    `name`        VARCHAR(45) NOT NULL,
    `detail`      VARCHAR(200),
    `create_at`   DATETIME    NOT NULL,
    `modify_at`   DATETIME    NOT NULL,
    `disband`     TINYINT     NOT NULL,
    PRIMARY KEY (`id`),
    KEY `ix_citycode` (`city_code1`, `city_code2`),
    CONSTRAINT `fk_group_category`
        FOREIGN KEY (`category_id`)
            REFERENCES `somoim`.`category` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_group_image`
        FOREIGN KEY (`image_id`)
            REFERENCES `somoim`.`image` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`favorite`
(
    `id`        BIGINT   NOT NULL AUTO_INCREMENT,
    `group_id`  BIGINT   NOT NULL,
    `user_id`   BIGINT   NOT NULL,
    `create_at` DATETIME NOT NULL,
    PRIMARY KEY (`id`, `group_id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`history`
(
    `id`        BIGINT   NOT NULL AUTO_INCREMENT,
    `group_id`  BIGINT   NOT NULL,
    `user_id`   BIGINT   NOT NULL,
    `create_at` DATETIME NOT NULL,
    PRIMARY KEY (`id`, `group_id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`member`
(
    `id`        BIGINT                     NOT NULL AUTO_INCREMENT,
    `user_id`   BIGINT                     NOT NULL,
    `group_id`  BIGINT                     NOT NULL,
    `role`      enum ('MANAGER', 'MEMBER') NOT NULL,
    `create_at` DATETIME                   NOT NULL,
    `modify_at` DATETIME                   NOT NULL,
    `disband`   TINYINT                    NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_member_user`
        FOREIGN KEY (`user_id`)
            REFERENCES `somoim`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_member_group`
        FOREIGN KEY (`group_id`)
            REFERENCES `somoim`.`group` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`board`
(
    `id`        BIGINT        NOT NULL AUTO_INCREMENT,
    `member_id` BIGINT        NOT NULL,
    `type`      TINYINT       NOT NULL,
    `content`   VARCHAR(1000) NOT NULL,
    `create_at` DATETIME      NOT NULL,
    `modify_at` DATETIME      NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_board_member`
        FOREIGN KEY (`member_id`)
            REFERENCES `somoim`.`member` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`board_image`
(
    `image_id` BIGINT NOT NULL,
    `board_id` BIGINT NOT NULL,
    `order`    INT    NOT NULL,
    CONSTRAINT `fk_board_image_image`
        FOREIGN KEY (`image_id`)
            REFERENCES `somoim`.`image` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_board_image_board`
        FOREIGN KEY (`board_id`)
            REFERENCES `somoim`.`board` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `somoim`.`comment`
(
    `id`        BIGINT        NOT NULL AUTO_INCREMENT,
    `board_id`  BIGINT        NOT NULL,
    `member_id` BIGINT        NOT NULL,
    `content`   VARCHAR(1000) NOT NULL,
    `create_at` DATETIME      NOT NULL,
    `modify_at` DATETIME      NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_comment_board`
        FOREIGN KEY (`board_id`)
            REFERENCES `somoim`.`board` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_comment_member`
        FOREIGN KEY (`member_id`)
            REFERENCES `somoim`.`member` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE = InnoDB;