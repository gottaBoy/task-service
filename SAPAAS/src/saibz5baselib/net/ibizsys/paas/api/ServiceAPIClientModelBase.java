package net.ibizsys.paas.api;

import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.sysmodel.SystemModelObjectBase;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;

/**
 * 服务接口客户端模型对象接口实现基类
 * @author Administrator
 *
 */
public abstract class ServiceAPIClientModelBase extends SystemModelObjectBase implements IServiceAPIClientModel {

	private static final Log log = LogFactory.getLog(ServiceAPIClientModelBase.class);
	private HashMap<String, IServiceAPIAction>  serviceAPIActionMap = new HashMap<String, IServiceAPIAction>();
	
	private String strServicePath = null;
	private String strUniqueTag = null;
	private String strConfigFile = null;
	private String strGrantType = null;
	private String strClientId = null;
	private String strClientSecrect = null;
	private String strAccessTokenUri = null;
	private boolean bOauth = false;
	private String strClientModuleId = null;
	private String strSystemModuleId = null;

	
	private Properties cfg = new Properties(); 
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.setSystemModel(iSystemModel);
		
		if(this.getSystemModel()!=null && this.getSystemModel() instanceof ISystemRuntime) {
			this.strSystemModuleId = ((ISystemRuntime)this.getSystemModel()).getModuleId();
		}
		
		this.onInit();
	}
	
	
	@Override
	protected void onInit() throws Exception {
		
		//获取配置信息
		initConfig();
		
		super.onInit();
	}
	
	/**
	 * 初始化配置信息
	 * @throws Exception
	 */
	protected void initConfig() throws Exception {
		try{
			loadProperties();
			this.strServicePath = PropertiesHelper.getProperty(cfg, "servicepath");
			this.strGrantType = PropertiesHelper.getProperty(cfg, "granttype");
			this.strClientId = PropertiesHelper.getProperty(cfg, "clientid");
			this.strClientSecrect = PropertiesHelper.getProperty(cfg, "clientsecrect");
			this.strAccessTokenUri = PropertiesHelper.getProperty(cfg, "accesstokenuri");
			this.bOauth = PropertiesHelper.getProperty(cfg, "oauth", false);
			this.strClientModuleId = PropertiesHelper.getProperty(cfg, "clientmoduleid",this.strSystemModuleId);
		}
		catch(Exception ex){
			log.error(ex);
		}
		
	}
	
	/**
	 * 加载配置属性
	 * @throws Exception
	 */
	protected void loadProperties()throws Exception{
		String strConfigFile = this.getConfigFile();
		if(StringHelper.isNullOrEmpty(strConfigFile)){
			strConfigFile = StringHelper.format("serviceapi-%1$s.properties", this.getUniqueTag().toLowerCase());
		}
		cfg.load(ServiceAPIClientModelBase.class.getClassLoader().getResourceAsStream(strConfigFile));
	}
	
	/**
	 * 设置服务路径
	 * @param strServicePath
	 */
	protected void setServicePath(String strServicePath){
		this.strServicePath = strServicePath;
	}
	
	/**
	 * 获取配置对象
	 */
	protected Properties getProperties() {
		return cfg ;
	}
	
	/**
	 * 获取服务路径
	 * @return
	 */
	public String getServicePath(){
		return this.strServicePath;
	}
	
	/**
	 * 是否开启OAuth认证方式
	 * @return
	 */
	public boolean isOauth(){
		return this.bOauth ;
	}
	
	/**
	 * 获取认证方式
	 * @return
	 */
	public String getGrantType(){
		return this.strGrantType ;
	}
	
	/**
	 * 获取认证路径
	 * @return
	 */
	public String getAccessTokenUri(){
		return this.strAccessTokenUri ;
	}
	
	/**
	 * 获取client-id
	 * @return
	 */
	public String getClientId(){
		return this.strClientId;
	}
	
	
	/**
	 * 获取client-secrect
	 * @return
	 */
	public String getClientSecrect(){
		return this.strClientSecrect;
	}
	
	
	
	@Override
	public String getUniqueTag() {
		return this.strUniqueTag;
	}
	
	
	/**
	 * 获取配置路径
	 * @return
	 */
	public String getConfigFile(){
		return this.strConfigFile;
	}
	
	
	/**
	 * 设置唯一业务标记
	 * @param strUniqueTag
	 */
	protected void setUniqueTag(String strUniqueTag){
		this.strUniqueTag = strUniqueTag;
	}
	
	/**
	 * 设置配置路径
	 * @param strConfigFile
	 */
	protected void setConfigFile(String strConfigFile){
		this.strConfigFile = strConfigFile;
	}
	
	
	/**
	 * 设置客户端标识
	 * @param strId
	 */
	protected void setId(String strId){
		this.strId = strId;
	}
	
	/**
	 * 设置客户端名称
	 * @param strName
	 */
	protected void setName(String strName){
		this.strName = strName;
	}
	
	
	/**
	 * 获取服务接口操作
	 * @param strActionTag
	 * @return
	 * @throws Exception
	 */
	protected IServiceAPIAction getServiceAPIAction(String strActionTag)throws Exception{
		IServiceAPIAction iServiceAPIAction = serviceAPIActionMap.get(strActionTag);
		if(iServiceAPIAction == null){
			throw new Exception(StringHelper.format("无法获取服务接口操作[%1$s]",strActionTag));
		}
		
		return iServiceAPIAction;
	}
	
	
	
	/**
	 * 注册服务API操作
	 * @param iServiceAPIAction
	 */
	protected void registerServiceAPIAction(IServiceAPIAction iServiceAPIAction){
		serviceAPIActionMap.put(iServiceAPIAction.getId(), iServiceAPIAction);
		if(!StringHelper.isNullOrEmpty(iServiceAPIAction.getUniqueTag())){
			serviceAPIActionMap.put(iServiceAPIAction.getUniqueTag(), iServiceAPIAction);
		}
	}


	/**
	 * 获取服务路径
	 * @param iServiceAPIAction
	 * @param objActionParam
	 * @return
	 * @throws Exception
	 */
	protected String getServicePath(IServiceAPIAction iServiceAPIAction,Object objActionParam)throws Exception{
		if(this.getSystemModel() == null)
			return this.getServicePath();
		return this.getSystemModel().getServicePath(this, iServiceAPIAction, objActionParam);
	}
	
	/**
	 * 获取客户端模块标识
	 * @return
	 */
	public String getClientModuleId() {
		return this.strClientModuleId;
	}
	
	/**
	 * 设置客户端模块标识
	 * @param strClientModuleId
	 */
	protected void setClientModuleId(String strClientModuleId) {
		this.strClientModuleId = strClientModuleId;
	}
	
}
