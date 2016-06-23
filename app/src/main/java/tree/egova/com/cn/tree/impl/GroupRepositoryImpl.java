package tree.egova.com.cn.tree.impl;

import java.util.ArrayList;
import java.util.List;

import tree.egova.com.cn.tree.Group;
import tree.egova.com.cn.tree.GroupRepository;

public class GroupRepositoryImpl implements GroupRepository {
    private List<Group> groups;

    public GroupRepositoryImpl() {
        this.groups = new ArrayList<>();
        Group group1 = new GroupImpl("局领导");
        group1.addMembers(new ContactMemberImpl("张良勖", "87463739"), new ContactMemberImpl("李存浩", "76353674"));
        Group group2 = new GroupImpl("办公室");
        group2.addMembers(new ContactMemberImpl("张良勖", "87463739"), new ContactMemberImpl("李存浩", "76353674"));
        groups.add(group1);
        groups.add(group2);
    }

    @Override
    public Group getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public List<Group> getGroups() {
        return groups;
    }
}
