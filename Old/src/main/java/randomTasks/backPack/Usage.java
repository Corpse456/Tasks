package randomTasks.backPack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Usage {

    private int id;

    private int size;

    @ToString.Exclude
    private Status status;

    @ToString.Exclude
    private Room room;

    public Usage(final int id, final int size) {
        this.id = id;
        this.size = size;
        status = Status.CREATED;
    }
}
