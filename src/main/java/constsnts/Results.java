package constsnts;

import lombok.Data;
import java.util.List;
import java.util.Date;
@Data

public class Results {
    int id;
    String name;
    String status;
    String species;
    String type;
    String gender;
    Origin origin;
    Location location;
    String image;
    List<String> episode;
    Date url;
    Date created;
}
