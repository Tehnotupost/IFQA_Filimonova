package RandM.api.constants;

import lombok.Data;
import java.util.List;
@Data

public class CharacterConst {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private LocationConst location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
}
