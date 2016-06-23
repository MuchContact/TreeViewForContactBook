package egova.com.cn.widget.model;

import java.util.List;

public interface GroupRepository {
    Group getGroup(int groupPosition);

    List<Group> getGroups();
}
