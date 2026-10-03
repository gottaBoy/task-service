package net.ibizsys.paas.api;

/**
 * Rest 服务接口行为对象接口 
 * @author Administrator
 *
 */
public interface IRestServiceAPIAction extends IServiceAPIAction {

	/**
     *  GET，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String REQUESTMETHOD_GET = "GET";
    /**
     *  HEAD，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String REQUESTMETHOD_HEAD = "HEAD";
    /**
     *  POST，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String REQUESTMETHOD_POST = "POST";
    /**
     *  PUT，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String REQUESTMETHOD_PUT = "PUT";
    /**
     *  PATCH，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String REQUESTMETHOD_PATCH = "PATCH";
    /**
     *  DELETE，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String REQUESTMETHOD_DELETE = "DELETE";
    /**
     *  OPTIONS，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String REQUESTMETHOD_OPTIONS = "OPTIONS";
    /**
     *  TRACE，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String REQUESTMETHOD_TRACE = "TRACE";
	
	/**
	 * 获取操作的路径
	 * @return
	 */
	String getActionPath();
	
	
	/**
	 * 获取请求的方式
	 * @return
	 */
	String getRequestMethod();
	
	
	/**
	 * 获取主键属性
	 * @return
	 */
	String getKeyField();
}
