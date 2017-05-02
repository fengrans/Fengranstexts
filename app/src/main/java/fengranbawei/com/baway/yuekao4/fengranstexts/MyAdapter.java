package fengranbawei.com.baway.yuekao4.fengranstexts;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;
/**
 * Created by Administrator on 2017/5/2.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {
    private List<Mynews.ApkBean>list;
    private Context context;

    public MyAdapter(List<Mynews.ApkBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Myholder holder = new Myholder(LayoutInflater.from(
                context).inflate(R.layout.item_recy, parent,
                false));
        return holder;
    }
    @Override
    public void onBindViewHolder(final Myholder holder, final int position) {
        //  Glide.with(context).load(list.get(position).getIconUrl()).into(head);
        ImageLoader.getInstance().displayImage(list.get(position).getIconUrl(),holder.head); //
        holder.title.setText(list.get(position).getName());

        //设置长按事件
        //拿到条目的长按事件
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //将数据通过条目的长按事件传递过去
                lisntner.getdata(v,holder.getLayoutPosition());
                return true;
            }
        });


        //移除数据
    }


    public void remove(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Myholder extends RecyclerView.ViewHolder{
        CardView cards;
        ImageView head;
        TextView title;
        public Myholder(View itemView) {
            super(itemView);
            head= (ImageView) itemView.findViewById(R.id.head);
            cards= (CardView) itemView.findViewById(R.id.cards);
            title= (TextView) itemView.findViewById(R.id.title);


        }
    }
    OnItemclick lisntner;
    public interface  OnItemclick{
        void getdata(View view,int position);


    }
    public void  Onitemlongclick(OnItemclick lisntner){
        this.lisntner=lisntner;
    }
}
