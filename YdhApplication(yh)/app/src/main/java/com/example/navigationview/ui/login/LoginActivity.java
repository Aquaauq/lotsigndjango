package com.example.navigationview.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationview.MainActivity;
import com.example.navigationview.MyApplication;
import com.example.navigationview.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

//登录功能
public class LoginActivity extends AppCompatActivity {
    private EditText name,password;
    private Button login,newh;
    static final int REQUEST_CODE = 0 ;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        name=findViewById(R.id.nameText);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        newh=findViewById(R.id.newh);
        //login监听
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String log="lhs";
//                String pass="123456";
                String strname=name.getText().toString().trim();
                String strpassword=password.getText().toString().trim();
                String url=new MyApplication().login;
                RequestParams params =new RequestParams(url);
                params.setMultipart(true);
                params.addQueryStringParameter("user",strname);//post打包数据，user对应数据库中的参数，strname是自己输入的
                params.addQueryStringParameter("password",strpassword);
                //post方法
                //调用xutils框架中的http后获取到HttpManager
                x.http().get(params, new Callback.CommonCallback<String>() {
                    //响应回收
                    @Override
                    public void onSuccess(String result) {
                        if(result.equals("0"))
                        {
                            Toast.makeText(LoginActivity.this,"欢迎回来！",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getBaseContext(), MainActivity.class);
                            startActivityForResult(i,REQUEST_CODE);
                        }
                        else if(result.equals("1"))
                        {Toast.makeText(LoginActivity.this,"密码错误！",Toast.LENGTH_LONG).show();}
                        else if(result.equals("2"))
                        {
                            Toast.makeText(LoginActivity.this,"请输入账号密码！",Toast.LENGTH_LONG).show();
                        }
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
                Log.i("test", String.valueOf(params));
            }
        });

        //注册监听
        newh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),RegisterActivity.class);
                startActivityForResult(i,REQUEST_CODE);
            }
        });
    }

}
