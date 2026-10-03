package net.ibizsys.pswf.core;

/**
 * 流程包容网关处理对象接口实现基类
 * @author Administrator
 *
 */
public abstract class WFInclusiveGatewayProcessModelBase extends WFGatewayProcessModelBase implements IWFInclusiveGatewayProcessModel {

	@Override
	public String getWFProcessType() {
		return IWFProcessModel.InclusiveGateway;
	}

}
