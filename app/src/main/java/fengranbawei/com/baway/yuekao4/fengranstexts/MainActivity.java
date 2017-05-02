package fengranbawei.com.baway.yuekao4.fengranstexts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Mynews mynews;
    private MyAdapter mm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        //设置布局
        //  getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title);
        try {
            getdara();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void getdara() throws IOException {
        InputStream open = getAssets().open("data.txt");
        final String getstr = MyUtils.getstr(open);

        Gson gson = new Gson();
        mynews = gson.fromJson(getstr, Mynews.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mm = new MyAdapter(mynews.getApk(), MainActivity.this);
        recyclerView.setAdapter(mm);
        mm.Onitemlongclick(new MyAdapter.OnItemclick() {
            @Override
            public void getdata(View view, int position) {
                Log.e("ss","!@3");
                mm.remove(position);
            }
        });



    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.result_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()) {
            case R.id.Listview :{
            //   recyclerView.setLayoutManager(new GridLayoutManager(this,2));
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,
                        StaggeredGridLayoutManager.HORIZONTAL));
                mm.notifyDataSetChanged();
                break;
            }
            case R.id.Gridview:{
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                break;
            }
        }


        return true;
    }

}
