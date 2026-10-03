package net.ibizsys.paas.sysmodel.util;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.sysmodel.SystemValueRuleModelBase;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;

/**
 * 数值范围系统值规则模型
 * @author Administrator
 *
 */
public class NumberRangeValueRuleModel extends SystemValueRuleModelBase {

	/**
	 * 参数：最小值
	 */
	public final static String PARAM_MINVALUE = "MINVALUE";
	
	/**
	 * 参数：最大值
	 */
	public final static String PARAM_MAXVALUE = "MAXVALUE";
	
	/**
	 * 参数：包括最小值，默认为true
	 */
	public final static String PARAM_INCMINVALUE = "INCMINVALUE";
	
	/**
	 * 参数：包括最大值，默认为true
	 */
	public final static String PARAM_INCMAXVALUE = "INCMAXVALUE";
	
	
	private Double fMinValue = null;
	private Double fMaxValue = null;
	private boolean bIncMaxValue = true;
	private boolean bIncMinValue = true;

	@Override
	protected void onInit() throws Exception {
		
		super.onInit();
		
		if(!StringHelper.isNullOrEmpty(PropertiesHelper.getProperty(this.getRuleParams(), PARAM_MINVALUE))){
			fMinValue = PropertiesHelper.getProperty(this.getRuleParams(), PARAM_MINVALUE,-1.0);
		}
		
		if(!StringHelper.isNullOrEmpty(PropertiesHelper.getProperty(this.getRuleParams(), PARAM_MAXVALUE))){
			fMaxValue = PropertiesHelper.getProperty(this.getRuleParams(), PARAM_MAXVALUE,-1.0);
		}
		
		if(!StringHelper.isNullOrEmpty(PropertiesHelper.getProperty(this.getRuleParams(), PARAM_INCMINVALUE))){
			bIncMinValue = PropertiesHelper.getProperty(this.getRuleParams(), PARAM_INCMINVALUE,true);
		}
		
		if(!StringHelper.isNullOrEmpty(PropertiesHelper.getProperty(this.getRuleParams(), PARAM_INCMAXVALUE))){
			bIncMaxValue = PropertiesHelper.getProperty(this.getRuleParams(), PARAM_INCMAXVALUE,true);
		}
		
		
		
	}
	
	
	@Override
	public boolean check(IEntity et, String strFieldName, boolean bTempMode, Object objParam, String strRuleInfo, boolean bTryMode) throws Exception {
		
		if (StringHelper.isNullOrEmpty(strRuleInfo)){
			strRuleInfo = this.getLocalization(ServiceBase.MSG_CHECKFIELDVALUERANGERULE_INFO, "数值必须符合值范围规则");
		}

		Object objValue = et.get(strFieldName);
		if (objValue == null) return true;

		double fSrcValue = 0;
		if (objValue instanceof Double) {
			fSrcValue = (Double) objValue;
		} else {
			String strValue = objValue.toString();
			if (StringHelper.isNullOrEmpty(strValue)) return true;
			fSrcValue = Double.parseDouble(objValue.toString());
		}

		if (fMinValue != null) {
			if (bIncMinValue) {
				if (fSrcValue < fMinValue) {
					if (bTryMode) return false;
					throw new Exception(strRuleInfo);
				}
			} else {
				if (fSrcValue <= fMinValue) {
					if (bTryMode) return false;
					throw new Exception(strRuleInfo);
				}
			}
		}

		if (fMaxValue != null) {
			if (bIncMaxValue) {
				if (fSrcValue > fMaxValue) {
					if (bTryMode) return false;
					throw new Exception(strRuleInfo);
				}
			} else {
				if (fSrcValue >= fMaxValue) {
					if (bTryMode) return false;
					throw new Exception(strRuleInfo);
				}
			}
		}

		return true;
	}

}
