package net.ibizsys.paas.sysmodel.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.ibizsys.paas.core.IRegExValueRule;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.sysmodel.SystemValueRuleModelBase;
import net.ibizsys.paas.util.StringHelper;

/**
 * 正则式值规则模型对象
 * @author Administrator
 *
 */
public  class RegExValueRuleModel extends SystemValueRuleModelBase implements IRegExValueRule {

	private String strExpression = null;
	private Pattern p = null;
	
	@Override
	protected void onInit() throws Exception {
		p = Pattern.compile(strExpression);
		super.onInit();
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IValueRule#getRuleType()
	 */
	@Override
	public String getRuleType() {
		return RULETYPE_REGEX;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IScriptValueRule#getExpression()
	 */
	@Override
	public String getExpression() {
		return this.strExpression;
	}

	
	/**
	 * 设置脚本代码
	 * @param strExpression
	 */
	public void setExpression(String strExpression){
		this.strExpression = strExpression;
	}

	@Override
	public boolean check(IEntity et, String strFieldName, boolean bTempMode, Object objParam, String strRuleInfo, boolean bTryMode) throws Exception {
		if (!et.contains(strFieldName)){
			return true;
		}
		String strValue = "";
		Object objValue = et.get(strFieldName);
		if (objValue != null) {
			if (!(objValue instanceof String)) {
				throw new Exception(this.getLocalization(ServiceBase.MSG_CHECKFIELDREGEXRULE_INVALIDVALUE , new Object[]{strFieldName},StringHelper.format("属性[%1$s]值不是字符类型",strFieldName)));
			}

			strValue = (String) objValue;
		}

		if (StringHelper.isNullOrEmpty(strValue)) return true;

		
		Matcher m = p.matcher(strValue);
		boolean b = m.matches();
		if (!b) {
			if (bTryMode) return false;

			throw new Exception(strRuleInfo);
		}
		return true;
	}
	
	
	
}
