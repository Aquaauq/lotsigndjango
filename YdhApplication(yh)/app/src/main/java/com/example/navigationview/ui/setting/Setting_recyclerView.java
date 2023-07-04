package com.example.navigationview.ui.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationview.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Setting_recyclerView extends Fragment {
    RecyclerView settingrecyclerview;
    List<Map<String,Object>>mydata2;

    private SettingRecyclerViewViewModel mViewModel;

    private Button cancel;

    public Setting_recyclerView newInstance() {return new Setting_recyclerView();}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_setting_recycler_view, container, false);
        mydata2=getData();
        settingrecyclerview=view.findViewById(R.id.settingrecyclerview);
        settingrecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
//      recyclerView.setLayoutManager(new GridLayoutManager(this,2));
//      recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL));
        settingrecyclerview.setAdapter(new MyAdapter());
        return view;
    }

    // 定义一个RecyclerView专属的数据适配器
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(getContext()).inflate(R.layout.settingitem,parent,false);
            ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final String stitle=(String)mydata2.get(position).get("stitle");
            holder.stitle.setText(stitle);
            //新增代码
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavController navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment2);
                    Bundle bundle=new Bundle();
                    bundle.putString("stitle",stitle);
                    navController.navigate(R.id.nav_slideshow,bundle);
                }
            });
        }
        @Override
        public int getItemCount() {
            return mydata2.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView stitle;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                stitle=itemView.findViewById(R.id.stitle);
            }
        }
    }
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stitle", "账号与安全");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("stitle", "个人中心");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("stitle", "客服");
        list.add(map);
        map = new HashMap<String, Object>();
        map.put("stitle", "关于软件");
        list.add(map);
        return list;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SettingRecyclerViewViewModel.class);
        // TODO: Use the ViewModel
    }

}