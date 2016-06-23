package tree.egova.com.cn.tree;

public interface Group {
    String name();

    ContactMember member(int childPosition);

    void addMembers(ContactMember member, ContactMember ...newMembers);

    int memberCount();
}
