package com.example.bjc.xutils3demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

/**
 * Created by 毕静存 on 2016/11/14.
 */
@ContentView(R.layout.activity_net)
public class NetActivity extends Activity{
    @ViewInject(R.id.pb_h)
    private ProgressBar pb_h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
    @Event(value={R.id.bt_request,R.id.bt_down,R.id.upload})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.bt_request:
                //get请求；
//                netGet();
                netPost();
                break;
            case R.id.bt_down:
                downFile();//下载文件
                break;
            case R.id.upload:
                uploadFile();
                break;

        }
    }

    private void uploadFile() {

        RequestParams params=new RequestParams("http://192.168.17.93:8080/FileUpload/FileUploadServlet");
        params.setMultipart(true);
        params.addBodyParameter("File",new File(Environment.getExternalStorageDirectory()+"/bjc/480.mp4"),null,"bjc.mp4");
        x.http().post(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File file) {
                Log.e("TAG", "onSuccess: "+file.toString());

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "onSuccess: "+ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", "onSuccess: "+cex.getMessage());

            }

            @Override
            public void onFinished() {
                Log.e("TAG", "onSuccess: "+"完成");
            }

            @Override
            public void onWaiting() {
                Log.e("TAG", "onSuccess: "+"等待");

            }

            @Override
            public void onStarted() {
                Log.e("TAG", "onSuccess: "+"开始");

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                pb_h.setMax((int) total);
                pb_h.setProgress((int) current);

            }
        });


    }

    /**
     * 下载文件
     */
    private void downFile() {
        RequestParams params=new RequestParams("http://106.38.238.52/xdispatch/vf1.mtime.cn/Video/2016/09/15/mp4/160915092608935956_480.mp4");
        params.setCancelFast(false);//可以立即取消下载
        params.setAutoRename(false);//自动生成文件的名
        params.setSaveFilePath(Environment.getExternalStorageDirectory()+"/bjc/480.mp4");//设置保存数据
//        params.setExecutor(new PriorityExecutor(3,true));//自定义线程池下载，设置为3时可能阻塞图片加载
        params.setAutoResume(true);
        x.http().get(params, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File file) {
                Log.e("TAG", "onSuccess: "+file.toString());

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "onSuccess: "+ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", "onSuccess: "+cex.getMessage());

            }

            @Override
            public void onFinished() {
                Log.e("TAG", "onSuccess: "+"完成");
            }

            @Override
            public void onWaiting() {
                Log.e("TAG", "onSuccess: "+"等待");

            }

            @Override
            public void onStarted() {
                Log.e("TAG", "onSuccess: "+"开始");

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                pb_h.setMax((int) total);
                pb_h.setProgress((int) current);

            }
        });
    }

    private void netPost() {
        RequestParams params=new RequestParams("http://192.168.12.227/ApiManager02/index.php?act=api&tag=3#info_api_a87ff679a2f3e71d9181a67b7542122c");
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "onSuccess: "+result);
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

    private void netGet() {
        RequestParams params=new RequestParams("http://192.168.12.227/ApiManager02/index.php?act=api&tag=3#info_api_a87ff679a2f3e71d9181a67b7542122c");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "onSuccess: "+result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "onSuccess: "+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e("TAG", "onSuccess: "+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e("TAG", "onFinished:"+"===========================================================");
            }
        });
    }
}
