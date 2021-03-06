package tree.egova.com.cn.tree.impl;

import egova.com.cn.widget.model.ContactMember;

public class ContactMemberImpl implements ContactMember {
    private final String name;
    private final String phone;

    public ContactMemberImpl(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String phone() {
        return phone;
    }
}
