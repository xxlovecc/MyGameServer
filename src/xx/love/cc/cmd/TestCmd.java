package xx.love.cc.cmd;

import xx.love.cc.common.Cmd;
import xx.love.cc.common.Command;
import xx.love.cc.protocol.Protocol;

@Cmd(code = Protocol.TEST_1, desc = "测试")
public class TestCmd implements Command {

	@Override
	public void execute() {
		System.out.println("我草，测试！");
	}

}
