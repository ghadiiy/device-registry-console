package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DeviceServiceTest {
    @Test
    void shouldRegisterValidDevice() {
DeviceRepository repository = new InMemoryDeviceRepository();
DeviceService service = new DeviceService(repository);
Device device = new Device("RFID-001", "Main Gate Reader", "RFID");

        String result = service.registerDevice(device);

        assertEquals("DEVICE_ADDED", result);
    }
    @Test
    void shouldRejectDeviceWithBlankName() {
        DeviceRepository repository = new InMemoryDeviceRepository();
        DeviceService service = new DeviceService(repository);

        Device device = new Device("RFID-002", "", "RFID");

        String result = service.registerDevice(device);

        assertEquals("EMPTY_FIELD", result);
    }
    @Test
    void shouldRejectDeviceWithUnsupportedType() {
        DeviceRepository repository = new InMemoryDeviceRepository();
        DeviceService service = new DeviceService(repository);

        Device device = new Device("RFID-002", "Test Device", "LAPTOP");

        String result = service.registerDevice(device);

        assertEquals("INVALID_TYPE", result);
    }
    @Test
    void shouldRejectDuplicateDeviceId() {
        DeviceRepository repository = new InMemoryDeviceRepository();
        DeviceService service = new DeviceService(repository);

        Device firstDevice = new Device("RFID-001", "Main Gate Reader", "RFID");
        service.registerDevice(firstDevice);

        Device secDevice = new Device("rfid-001", "Main Gate Reader", "RFID");
        String result = service.registerDevice(secDevice);
        assertEquals("DUPLICATE_ID", result);

    }

}
