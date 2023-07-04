package com.example.navigationview.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationview.MyApplication;
import com.example.navigationview.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

//注册功能
public class RegisterActivity extends AppCompatActivity {
    Button certain,cancel;
    EditText  re_name,re_password;
    static final int REQUEST_CODE = 0 ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        re_name=findViewById(R.id.re_name);
        re_password=findViewById(R.id.re_password);
        certain=findViewById(R.id.certain);
        cancel=findViewById(R.id.cancel);
        //注册按钮
        certain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String txtre_name=re_name.getText().toString();
                final String txtre_password=re_password.getText().toString();
                //访问API
                String url=new MyApplication().register;
                RequestParams params=new RequestParams(url);
                params.setMultipart(true);
                params.addQueryStringParameter("user",txtre_name);
                params.addQueryStringParameter("password",txtre_password);
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (result.equals("0"))
                        {
                            Toast.makeText(RegisterActivity.this,"注册成功！",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getBaseContext(),LoginActivity.class);
                            startActivityForResult(i,REQUEST_CODE);
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
                
            }
        });
        //取消按钮
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),LoginActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }
}
