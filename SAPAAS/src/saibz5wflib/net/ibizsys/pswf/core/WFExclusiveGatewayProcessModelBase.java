package net.ibizsys.pswf.core;

/**
 * 流程排它网关处理模型接口实现基类
 * @author Administrator
 *
 */
public abstract class WFExclusiveGatewayProcessModelBase  extends WFGatewayProcessModelBase implements IWFExclusiveGatewayProcessModel {

	@Override
	public String getWFProcessType() {
		return IWFProcessModel.ExclusiveGateway;
	}

}
