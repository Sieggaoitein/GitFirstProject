package com.xxoo.mycollect.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;

public class MyService extends Service {
	private Looper mServiceLooper;
	private ServiceHandler mServiceHandler;

	private final class ServiceHandler extends Handler {
		public ServiceHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {

			// 通常我们在这里做一些事情，例如下载文件。
			// 这里，我们只让程序睡眠5s
			long endTime = System.currentTimeMillis() + 1 * 1000;
			while (System.currentTimeMillis() < endTime) {
				synchronized (this) {
					try {
						wait(endTime - System.currentTimeMillis());
					} catch (Exception e) {

					}
				}
			}
			// 使用startId停止服务,所以我们在处理其他任务的过程中不会停止该服务.
//			stopSelf(msg.arg1);
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.d("MyService", "onbind");
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("MyService", "oncreate");
		HandlerThread handlerThread = new HandlerThread("MyService",
				Process.THREAD_PRIORITY_BACKGROUND);
		handlerThread.start();
		mServiceLooper = handlerThread.getLooper();
		mServiceHandler = new ServiceHandler(mServiceLooper);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("MyService", "onstartcommand==>" + startId);
		Message msg = mServiceHandler.obtainMessage();
		msg.arg1 = startId;
		mServiceHandler.sendMessage(msg);
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("MyService", "ondestroy");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.d("MyService", "onunbind");
		return super.onUnbind(intent);
	}

}
