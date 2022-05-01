package domain;

import constant.Type;
import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class Operation {
    private Date date;
    private Money money;
    private Type type;

}
