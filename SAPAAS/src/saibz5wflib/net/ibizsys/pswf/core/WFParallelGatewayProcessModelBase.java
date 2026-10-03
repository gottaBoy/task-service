package net.ibizsys.pswf.core;

/**
 * 流程并行网关处理对象接口实现基类
 * @author Administrator
 *
 */
public abstract class WFParallelGatewayProcessModelBase extends WFGatewayProcessModelBase implements IWFParallelGatewayProcessModel{
	
	@Override
	public String getWFProcessType() {
		return IWFProcessModel.ParallelGateway;
	}
}
