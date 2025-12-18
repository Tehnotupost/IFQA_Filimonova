package RandM.api.constants;

import lombok.Data;

import java.util.List;
@Data

public class EpisodeConst {
    private Integer id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;
}
