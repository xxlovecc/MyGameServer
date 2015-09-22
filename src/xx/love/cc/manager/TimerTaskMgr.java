package xx.love.cc.manager;

import java.util.Timer;
import java.util.TimerTask;

import xx.love.cc.Log;
import xx.love.cc.TimeUtil;

public class TimerTaskMgr {
	// 最小时间隔1分钟
//	private static final int MINTIME = 1000 * 60;
	// 最小时间隔1秒
	private static final int SECOND = 1000;
	
	private static Timer scanTimer;
	
	
	private static TimerTask testTask;
	
	
	public static boolean init(){
		if(scanTimer == null){
			scanTimer = new Timer("scanTimer");
		}
		
		long detime = 60 - TimeUtil.getCurrentSecond();//保证整分钟启动
		testTask = new TestTask();
//		scanTimer.schedule(testTask, MINTIME * 0, SECOND * 10);
		scanTimer.schedule(testTask, detime * 1000, SECOND * 60 * 5);
		
		
		
		return true;
	}
	
	
	
}


class TestTask extends TimerTask {
	
	@Override
	public void run() {
		Log.info("test:" + TimeUtil.getDateFormat(TimeUtil.getSysteCurTimeForDate()));
	}
	
	
	
}





