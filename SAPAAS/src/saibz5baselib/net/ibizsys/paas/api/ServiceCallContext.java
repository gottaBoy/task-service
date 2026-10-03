package net.ibizsys.paas.api;

import net.sf.json.JSONObject;

/**
 * 服务调用上下文对象接口实现
 * @author Administrator
 *
 */
public class ServiceCallContext implements IServiceCallContext {

	private String strResultRaw = null;
	private JSONObject joResult = null;
	@Override
	public String getResultRaw() {
		return this.strResultRaw;
	}

	@Override
	public JSONObject getResultJO() {
		return this.joResult;
	}

	@Override
	public void setResultRaw(String strResultRaw) {
		this.strResultRaw = strResultRaw;
	}

	@Override
	public void setResultJO(JSONObject resultJO) {
		this.joResult = resultJO;
	}

}
