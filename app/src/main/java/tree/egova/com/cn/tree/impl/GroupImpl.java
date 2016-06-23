package tree.egova.com.cn.tree.impl;

import java.util.ArrayList;
import java.util.List;

import egova.com.cn.widget.model.ContactMember;
import egova.com.cn.widget.model.Group;

public class GroupImpl implements Group {
    private final String name;
    private List<ContactMember> members;

    public GroupImpl(String groupName) {
        this.name = groupName;
        members = new ArrayList<>();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public ContactMember member(int childPosition) {
        return childPosition < members.size() ? members.get(childPosition) : null;
    }

    @Override
    public void addMembers(ContactMember member, ContactMember... newMembers) {
        members.add(member);
        for (ContactMember mem : newMembers) {
            members.add(mem);
        }
    }

    @Override
    public int memberCount() {
        return members.size();
    }
}
