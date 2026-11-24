# Device Registry Console

## Project Description

A Java console application designed to organize and manage device records

## Features
- Add new device
- Search for device
- List all devices
- Exit the application
- Validate device information and prevent duplicate IDs

## Requirements
- JDK 21
- Maven

## How to Build
Open a terminal in the project directory and run:

```bash
mvn clean package
```

## How to Run
Run the `Main` class from your Java IDE

## Data Storage
Device records are stored in memory and are not saved after the application exits

## Project Status
The application is completed and tested

## Merge Conflict Exercise
A merge conflict occurred when two branches modified the same line in the README file

To resolve the conflict, I manually edited the file and combined the two descriptions into one final description

After resolving the conflict, I used git add and git commit to save the changes

The merge conflict was successfully resolved

## Design Decisions
Primary Keys:
We used 'device_id' and 'event_id' as primary keys to uniquely identify each device and each event, preventing duplicate IDs and ensuring every record can be identified

Foreign Key – device_id:
We used 'device_id' as a foreign key in the 'device_events' table to link each event to its device and ensure that every event belongs to an existing device

ENUM – device_type:
We used 'ENUM' to restrict device types to the allowed values: 'RFID', 'IO', and 'CAMERA'
This prevents unsupported device types from being inserted

NOT NULL Constraints:
We used 'NOT NULL' to ensure that required fields contain values and cannot be left empty
This keeps the database records complete


## Database Testing Results

### Sample Data
- 3 devices were inserted
- 3 events were inserted
- RFID-001 reported 2 events
- IO-001 reported 1 event
- CAM-001 reported 0 events

### SQL Queries
The following queries were tested successfully:
1. Display all devices
2. Display recent events with device names, newest first
3. Count events for every device, including devices with zero events
4. Display events within a specific time range

### Constraint Testing
- Duplicate device ID was rejected (Error 1062)
- Event referencing a nonexistent device was rejected (Error 1452)

### Transaction Testing
- COMMIT: Inserted a test device and its first event successfully
- ROLLBACK: Inserted another test device and event, then rolled back both successfully

## Repository Link

[Device Registry Console – GitHub](https://github.com/ghadiiy/device-registry-console)

## Latest Commit

875de2c

