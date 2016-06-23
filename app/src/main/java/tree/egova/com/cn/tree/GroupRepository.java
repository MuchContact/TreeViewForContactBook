package tree.egova.com.cn.tree;

import java.util.List;

public interface GroupRepository {
    Group getGroup(int groupPosition);

    List<Group> getGroups();
}
