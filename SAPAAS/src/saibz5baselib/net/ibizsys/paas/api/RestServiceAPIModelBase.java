package net.ibizsys.paas.api;

/**
 * Rest 服务API模型
 * @author Administrator
 *
 */
public abstract class RestServiceAPIModelBase extends ServiceAPIModelBase {

	@Override
	public String getAPIType() {
		return IServiceAPI.APITYPE_RESTFUL;
	}

}
