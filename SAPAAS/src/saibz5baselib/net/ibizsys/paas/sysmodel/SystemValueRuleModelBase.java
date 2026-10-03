package net.ibizsys.paas.sysmodel;

import java.util.Properties;

import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 系统值规则模型对象
 * 
 * @author lionlau
 *
 */
public abstract class SystemValueRuleModelBase extends ModelBaseImpl implements ISystemValueRuleModel {

	private ISystemModel iSystemModel = null;
	
	private String strUniqueTag  = null;
	
	protected Properties ruleParams = null;
	
	private String strRuleParams = null;
	
	private String strRuleInfo = null;
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.iSystemModel  = iSystemModel;
		this.onInit();
	}

	@Override
	public ISystemModel getSystemModel() {
		return iSystemModel;
	}
	
	
	
	
	/**
	 * 设置规则参数
	 * @param strRuleParams
	 */
	public void setRuleParams(String strRuleParams){
		this.strRuleParams = strRuleParams;
	}
	
	
	@Override
	protected void onInit() throws Exception {
		this.ruleParams = PropertiesHelper.load(this.strRuleParams);
		super.onInit();
	}
	
	
	/**
	 * 获取规则参数
	 * @return
	 */
	protected Properties getRuleParams(){
		return this.ruleParams;
	}
	
	
	@Override
	public String getRuleType() {
		return RULETYPE_CUSTOM;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.ISystemLogicModel#getUniqueTag()
	 */
	@Override
	public String getUniqueTag() {
		return this.strUniqueTag;
	}

	
	/**
	 * 设置唯一业务标识
	 * @param strUniqueTag
	 */
	public void setUniqueTag(String strUniqueTag){
		this.strUniqueTag = strUniqueTag;
	}
	
	/**
	 * 设置标识
	 * @param strId
	 */
	public void setId(String strId){
		this.strId = strId;
	}
	
	
	/**
	 * 设置名称
	 * @param strName
	 */
	public void setName(String strName){
		this.strName = strName;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IValueRule#getRuleInfo()
	 */
	@Override
	public String getRuleInfo() {
		return strRuleInfo;
	}

	
	/**
	 * 设置规则信息
	 * @param strRuleInfo
	 */
	public void setRuleInfo(String strRuleInfo){
		this.strRuleInfo = strRuleInfo;
	}
	
	/**
	 * 获取本地化内容
	 * @param strResId
	 * @param strDefault
	 * @return
	 */
	protected String getLocalization(String strResId, String strDefault) {
		if(WebContext.getCurrent()!=null)
			return WebContext.getCurrent().getLocalization(strResId, null, strDefault);
		return strDefault;
	}
	
	
	/**
	 * 获取本地化内容
	 * @param strResId
	 * @param params
	 * @param strDefault
	 * @return
	 */
	protected String getLocalization(String strResId,  Object[] params, String strDefault) {
		if(WebContext.getCurrent()!=null)
			return WebContext.getCurrent().getLocalization(strResId, params, strDefault);
		return strDefault;
	}
	
}
