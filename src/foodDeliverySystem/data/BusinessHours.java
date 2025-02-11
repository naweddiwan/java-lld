package foodDeliverySystem.data;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BusinessHours {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public BusinessHours(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
