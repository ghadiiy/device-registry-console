use device_registry;

-- show all devices
select * from devices;

-- show recent events with device names
select
    device_events.event_id,
    devices.device_name,
    device_events.event_time,
    device_events.event_type
from device_events
         join devices
              on device_events.device_id = devices.device_id
order by device_events.event_time desc;

-- count events for each device
select
    devices.device_id,
    devices.device_name,
    count(device_events.event_id) as event_count
from devices
         left join device_events
                   on devices.device_id = device_events.device_id
group by devices.device_id, devices.device_name;

-- show events within a time range
select *
from device_events
where event_time between '2026-11-23 00:00:00'
          and '2026-11-24 23:59:59';