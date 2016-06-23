package tree.egova.com.cn.tree;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import egova.com.cn.widget.TreeView;
import tree.egova.com.cn.tree.impl.GroupRepositoryImpl;


public class MainActivity extends ActionBarActivity {
    private TreeView treeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        treeView = (TreeView) findViewById(R.id.tree_view);
        treeView.setHeaderView(getLayoutInflater().inflate(R.layout.list_head_view, treeView,
                false));
        GroupRepository groupRepository = new GroupRepositoryImpl();
        treeView.setAdapter(new TreeViewAdapter(this, treeView, groupRepository));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
