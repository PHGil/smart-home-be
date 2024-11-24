CREATE TABLE rooms (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    floor_number INTEGER,
    length FLOAT DEFAULT 0,
    width FLOAT DEFAULT 0,
    height FLOAT DEFAULT 0,
    is_inside BOOLEAN,
);

CREATE TABLE devices (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    model VARCHAR(255),
    room_id BIGINT NOT NULL,
    FOREIGN KEY (room_id) REFERENCES rooms (id) ON DELETE CASCADE
);
