CREATE TABLE room
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    floor_number INTEGER      NOT NULL,
    length       FLOAT        NOT NULL DEFAULT 0,
    width        FLOAT        NOT NULL DEFAULT 0,
    height       FLOAT        NOT NULL DEFAULT 0,
    is_inside    BOOLEAN
);

CREATE TABLE device
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255),
    model     VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    room_id   BIGINT  NOT NULL,
    FOREIGN KEY (room_id) REFERENCES room (id) ON DELETE CASCADE
);
