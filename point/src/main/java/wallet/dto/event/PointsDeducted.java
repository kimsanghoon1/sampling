package wallet.dto.event;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PointsDeducted extends AbstractEvent {

    private Long id;
    private String holder;
    private Long amount;

    public PointsDeducted(){
        super();
    }
}