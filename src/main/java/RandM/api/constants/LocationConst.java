package RandM.api.constants;

import lombok.Data;
import java.util.List;

@Data

public class LocationConst {
    private Integer id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private String created;
}

