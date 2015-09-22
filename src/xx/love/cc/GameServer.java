package xx.love.cc;

import xx.love.cc.common.ServerType;
import xx.love.cc.manager.TimerTaskMgr;


public final class GameServer extends BaseServer{

	private static GameServer gameServer;
//	private static String path;
	
	public static GameServer getInstance(){
		if(gameServer == null){
			gameServer = new GameServer(ServerType.GAME_SERVER);
		}
		return gameServer;
	}
	
	private GameServer(){
		
	}
	
	private GameServer(short serverType){
		BaseServer.serverType = serverType;
	}
	
	/**
	 * 初始化
	 */
	public boolean init(){
		if(!super.init()){
			return false;
		}
		if(!initBase()){
			return false;
		}
		return true;
	}
	
	public boolean initBase(){
		if(!initComponent(initMina(Config.getInt("server.port")), "Mina框架")){
			return false;
		}
		if(!initComponent(TimerTaskMgr.init(), "定时任务")){
			return false;
		}
		return true;
	}
	
	/**
	 * GameServer启动
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("请传入参数");
		}
		configPath = args[0];
//		System.out.println(configPath);
		BaseServer server = GameServer.getInstance();
		server.start();
	}

}
