CREATE TABLE room
(
    id           BIGSERIAL PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    floor_number INTEGER      NOT NULL,
    length       FLOAT,
    width        FLOAT,
    height       FLOAT,
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
