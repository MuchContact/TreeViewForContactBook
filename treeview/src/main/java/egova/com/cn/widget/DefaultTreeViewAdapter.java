package egova.com.cn.widget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import egova.com.cn.widget.model.ContactMember;
import egova.com.cn.widget.model.GroupRepository;

/**
 * TreeView demo adapter
 *
 * @author markmjw
 * @date 2014-01-04
 */
public class DefaultTreeViewAdapter extends BaseTreeViewAdapter {
    private LayoutInflater mInflater;
    private GroupRepository groupRepository;

    public DefaultTreeViewAdapter(Context context, TreeView treeView, GroupRepository groupRepository) {
        super(treeView);

        mInflater = LayoutInflater.from(context);
        this.groupRepository = groupRepository;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupRepository.getGroup(groupPosition).member(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupRepository.getGroup(groupPosition).memberCount();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupRepository.getGroup(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return groupRepository.getGroups().size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_view, null);
        }

        ChildHolder holder = getChildHolder(convertView);
        final ContactMember contactMember = (ContactMember) getChild(groupPosition, childPosition);
        holder.name.setText(contactMember.name());
        holder.state.setText(contactMember.phone());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse(String.format("tel:%s", contactMember.phone()));
                Intent callIntent = new Intent(Intent.ACTION_CALL, number);
                v.getContext().startActivity(callIntent);
            }
        });
        return convertView;
    }

    private ChildHolder getChildHolder(final View view) {
        ChildHolder holder = (ChildHolder) view.getTag();
        if (null == holder) {
            holder = new ChildHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    private class ChildHolder {
        TextView name;
        TextView state;

        public ChildHolder(View view) {
            name = (TextView) view.findViewById(R.id.contact_list_item_name);
            state = (TextView) view.findViewById(R.id.cpntact_list_item_state);
        }
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_group_view, null);
        }

        GroupHolder holder = getGroupHolder(convertView);

        holder.name.setText(groupRepository.getGroup(groupPosition).name());
        holder.onlineNum.setText(getChildrenCount(groupPosition) + "");
        if (isExpanded) {
            holder.indicator.setImageResource(R.drawable.indicator_expanded);
        } else {
            holder.indicator.setImageResource(R.drawable.indicator_unexpanded);
        }

        return convertView;
    }

    private GroupHolder getGroupHolder(final View view) {
        GroupHolder holder = (GroupHolder) view.getTag();
        if (null == holder) {
            holder = new GroupHolder(view);
            view.setTag(holder);
        }
        return holder;
    }

    private class GroupHolder {
        TextView name;
        ImageView indicator;
        TextView onlineNum;

        public GroupHolder(View view) {
            name = (TextView) view.findViewById(R.id.group_name);
            indicator = (ImageView) view.findViewById(R.id.group_indicator);
            onlineNum = (TextView) view.findViewById(R.id.online_count);
        }
    }

    @Override
    public void updateHeader(View header, int groupPosition, int childPosition, int alpha) {
        ((TextView) header.findViewById(R.id.group_name)).setText(groupRepository.getGroup(groupPosition).name());
        ((TextView) header.findViewById(R.id.online_count)).setText(getChildrenCount
                (groupPosition) + "/" + getChildrenCount(groupPosition));
        header.setAlpha(alpha);
    }
}
