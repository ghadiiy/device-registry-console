
-- 1. recreate the database
drop database if exists device_registry;
create database device_registry;

use device_registry;

-- 2. create devices table
create table devices (
                         device_id varchar(15) primary key,
                         device_name varchar(25) not null,
                         device_type enum('RFID', 'IO', 'CAMERA') not null);

-- 3. create device_events table
create table device_events (
                               event_id int auto_increment primary key,
                               device_id varchar(15) not null,
                               event_time datetime not null,
                               event_type varchar(50) not null,
                               constraint fk_device_events_device
                                   foreign key (device_id)
                                       references devices(device_id)
);

-- 4. insert sample devices
insert into devices (device_id, device_name, device_type)
values
    ('RFID-001', 'Main Gate Reader', 'RFID'),
    ('IO-001', 'Gate IO Controller', 'IO'),
    ('CAM-001', 'Entry Camera', 'CAMERA');

-- 5. insert sample events
insert into device_events (device_id, event_time, event_type)
values
    ('RFID-001', '2026-11-23 10:00:00', 'CARD_SCAN'),
    ('RFID-001', '2026-11-24 09:30:00', 'CARD_SCAN'),
    ('IO-001', '2026-11-24 11:00:00', 'SENSOR_CHANGE');
