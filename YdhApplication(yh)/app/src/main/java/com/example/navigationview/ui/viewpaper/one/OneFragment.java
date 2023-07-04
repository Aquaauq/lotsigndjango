package com.example.navigationview.ui.viewpaper.one;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bumptech.glide.Glide;
import com.example.navigationview.MyApplication;
import com.example.navigationview.R;
import com.example.navigationview.SwipeRecyclerView;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OneFragment extends Fragment {

    private OneViewModel mViewModel;

    private SwipeRecyclerView recyclerView;
    private MyRecycleViewAdapter adapter;
    //
    private List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
    private List<HashMap<String, Object>> mData = new ArrayList<HashMap<String, Object>>();
    private int pageSize = 2;
    String url = new MyApplication().testdboneurl;
    //String url = "http://172.16.26.242:8080/androidweb/ListJsonServlet";
    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        recyclerView = (SwipeRecyclerView) view.findViewById(R.id.swipeRecyclerView);
        //set color
        recyclerView.getSwipeRefreshLayout()
                .setColorSchemeColors(getResources().getColor(R.color.colorPrimary));

        recyclerView.getRecyclerView().setLayoutManager(new GridLayoutManager(getActivity(), 1));
        //recyclerView.getRecyclerView().setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter=new MyRecycleViewAdapter();
        recyclerView.setAdapter(adapter);
        //实现分页效果：1.手势上拨，加载更多的数据 2.手势下滑，回到列表最开始的位置
        recyclerView.setOnLoadListener(new SwipeRecyclerView.OnLoadListener() {
            @Override
            public void onRefresh() {
                fetchRData();
            }

            @Override
            public void onLoadMore() {
                fetchMData();
            }
        });



        //设置自动下拉刷新，切记要在recyclerView.setOnLoadListener()之后调用
        //因为在没有设置监听接口的情况下，setRefreshing(true),调用不到OnLoadListener
        recyclerView.setRefreshing(true);
        return view;
        //其他设置
        //禁止下拉刷新
        // recyclerView.setRefreshEnable(false);
        //禁止加载更多
        //recyclerView.setLoadMoreEnable(false);
        //设置emptyView
        /*TextView textView = new TextView(this);
        textView.setText("empty view");
        recyclerView.setEmptyView(textView);*/
        //设置footerView
        //recyclerView.setFooterView(new SimpleFooterView(this));
        //由于SwipeRecyclerView中对GridLayoutManager的SpanSizeLookup做了处理，因此对于使用了
        //GridLayoutManager又要使用SpanSizeLookup的情况，可以这样使用！
        /*recyclerView.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 3;
            }
        });*/
        //设置去除footerView 的分割线
       /* recyclerView.getRecyclerView().addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                paint.setColor(0xFFEECCCC);
                Rect rect = new Rect();
                int left = parent.getPaddingLeft();
                int right = parent.getWidth() - parent.getPaddingRight();
                final int childCount = parent.getChildCount() - 1;
                for (int i = 0; i < childCount; i++) {
                    final View child = parent.getChildAt(i);

                    //获得child的布局信息
                    final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                    final int top = child.getBottom() + params.bottomMargin;
                    final int itemDividerHeight = 1;//px
                    rect.set(left + 50, top, right - 50, top + itemDividerHeight);
                    c.drawRect(rect, paint);
                }
            }
        });*/
        //设置noMore
        // recyclerView.onNoMore("-- end --");
        //设置网络处理
        //recyclerView.onNetChange(true);
        //设置错误信息
        //recyclerView.onError("error");


    }
    //加载更多数据
    public void fetchMData() {
        RequestParams params = new RequestParams(url);
        //get
        params.addQueryStringParameter("offset", String.valueOf(mData.size()));
        params.addQueryStringParameter("pagesize", String.valueOf(pageSize));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                list=JSON.parseObject(result,new TypeReference<List<HashMap<String,Object>>>(){});
                mData.addAll(list);
                recyclerView.complete();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });



    }
    //回到最前面
    public void fetchRData() {
        RequestParams params = new RequestParams(url);
        //get
        params.addQueryStringParameter("offset", String.valueOf(0));
        params.addQueryStringParameter("pagesize", String.valueOf(pageSize));
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                list=JSON.parseObject(result,new TypeReference<List<HashMap<String, Object>>>(){});
                mData.clear();
                mData.addAll(list);
                recyclerView.complete();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });




    }
    class  MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder>
    {
        public  class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView picture;
            public TextView isbn;
            public TextView bookname;
            public TextView publishertime;

            public ViewHolder(View convertView) {
                super(convertView);
                picture = (ImageView)convertView.findViewById(R.id.picture);
                isbn = (TextView)convertView.findViewById(R.id.isbn);
                bookname = (TextView)convertView.findViewById(R.id.bookname);
                publishertime = (TextView)convertView.findViewById(R.id.publishertime);
            }
        }
        @NonNull
        @Override
        public MyRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(getActivity()).inflate(R.layout.item,parent, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyRecycleViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            //picture
//            Glide.with(getActivity()).load(new MyApplication().imagebaseurl+mData.get(position).get("picture").toString()).placeholder(R.mipmap.ic_launcher).into(holder.picture);
            holder.isbn.setText((String)mData.get(position).get("isbn"));
            holder.bookname.setText((String)mData.get(position).get("bookname"));
            holder.publishertime.setText((String)mData.get(position).get("publishertime"));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavController navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);
                    Bundle bundle=new Bundle();
                    bundle.putString("id",(String)mData.get(position).get("id"));
                    navController.navigate(R.id.detail2Fragment,bundle);

                }
            });
        }
        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }
    }
}
