package net.ibizsys.pscoreux.srv.plugin;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.ibizsys.paas.core.IPlugin;
import net.ibizsys.paas.core.PluginActionResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServicePluginBase;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;

public class PSDEFieldServicePlugin extends ServicePluginBase {
	
	@Override
	public PluginActionResult doCheckEntity(IService iService, int nActionPos, IEntity et, boolean bCreate, boolean bTempMode, EntityError entityError, Object objParam) throws Exception {
		if(nActionPos == IPlugin.ACTIONPOS_ACTION) {
			EntityFieldError entityFieldError = null;
			//检查属性 逻辑属性
	        entityFieldError = onCheckField_FormulaFields(iService,(PSDEField)et, bCreate, bTempMode);
	        if(entityFieldError!=null) {
	            entityError.register(entityFieldError);
	        }
	        //检查属性 长度
	        entityFieldError = onCheckField_Length(iService,(PSDEField)et, bCreate, bTempMode);
	        if(entityFieldError!=null){
	        	entityError.register(entityFieldError);
	        }
	        //检查属性 浮点精度
	        entityFieldError = onCheckField_FloatAccuracy(iService,(PSDEField)et, bCreate, bTempMode);
	        if(entityFieldError!=null) {
	            entityError.register(entityFieldError);
	        }
	        //检查属性 逻辑字段格式
	        entityFieldError = onCheckField_FormulaFormat(iService,(PSDEField)et, bCreate, bTempMode);
	        if(entityFieldError!=null){
	        	entityError.register(entityFieldError);
	        }
			return PluginActionResult.Continue;
		}
		return super.doCheckEntity(iService, nActionPos, et, bCreate, bTempMode, entityError, objParam);
	}
	
	private EntityFieldError onCheckField_FormulaFormat(IService iService, PSDEField et, boolean bCreate, boolean bTempMode) {
		String strRuleInfo = "";
		String strFormulaFormat=et.getFormulaFormat();
		if(!StringHelper.isNullOrEmpty(strFormulaFormat)){
			int number=-1;
			int nMaxNum = this.getStringFormatMaxIndex(strFormulaFormat);
			int nFormularFieldCount = 0;
			if(!StringHelper.isNullOrEmpty(et.getFormulaFields())){
				String strFormulaFields = et.getFormulaFields().toUpperCase();
				//设置截取字符串
		        Pattern pattern = Pattern.compile("[;|]+");
		        String[] formulaFields = pattern.split(strFormulaFields);
		        nFormularFieldCount = formulaFields.length;
			}
	        System.out.println("onCheckField_FormulaFormat ------"+nMaxNum+"------"+nFormularFieldCount);
			if(nFormularFieldCount < nMaxNum){
				strRuleInfo="逻辑字段格式与逻辑属性参数个数不匹配";
				EntityFieldError entityFieldError = new EntityFieldError();
	            entityFieldError.setFieldName(PSDEField.FIELD_FORMULAFIELDS);
	            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
	            entityFieldError.setErrorInfo(strRuleInfo);
	            return entityFieldError;
			}
			/*for(int i=1;i<=nMaxNum;i++){
				int num = formulaFormat.indexOf("%"+i+"$s");
				if(num>=0 || (i==1 && num==0)){
					if(number!=-1 && num-number!=5){
						strRuleInfo="逻辑字段格式中间值缺省";
						EntityFieldError entityFieldError = new EntityFieldError();
			            entityFieldError.setFieldName(PSDEField.FIELD_FORMULAFORMAT);
			            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
			            entityFieldError.setErrorInfo(strRuleInfo);
			            return entityFieldError;
					}
					if(i==maxNum && formulaFormat.length()-num!=4){
						strRuleInfo="逻辑字段格式不正确";
						EntityFieldError entityFieldError = new EntityFieldError();
			            entityFieldError.setFieldName(PSDEField.FIELD_FORMULAFORMAT);
			            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
			            entityFieldError.setErrorInfo(strRuleInfo);
			            return entityFieldError;
					}
					number = num;
					continue;
				}else{
					strRuleInfo="逻辑字段格式不正确";
					EntityFieldError entityFieldError = new EntityFieldError();
		            entityFieldError.setFieldName(PSDEField.FIELD_FORMULAFORMAT);
		            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
		            entityFieldError.setErrorInfo(strRuleInfo);
		            return entityFieldError;
				}
			}*/
		}
		return null;
	}

	private EntityFieldError onCheckField_FloatAccuracy(IService iService, PSDEField et, boolean bCreate, boolean bTempMode) throws Exception {
		String strRuleInfo = "";
		//类型为数值
		if(StringHelper.compare(et.getPSDataTypeId(), "DECIMAL", true) == 0){
			int nLength = 0;
			int nPrecision = 0;
			if(et.getLength() != null)
				nLength = et.getLength().intValue();
			if(et.getPrecision2() != null)
				nPrecision = et.getPrecision2().intValue();
			else
				return null;
			
			if(nPrecision>nLength){
				strRuleInfo = "浮点精度范围不能大于长度！";
				EntityFieldError entityFieldError = new EntityFieldError();
				entityFieldError.setFieldName(PSDEField.FIELD_PRECISION2);
				entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
				entityFieldError.setErrorInfo(strRuleInfo);
				return entityFieldError;
			}
			if(nPrecision<1 || nPrecision>30){
				strRuleInfo = "浮点精度范围不能小于1或者大于30";
				EntityFieldError entityFieldError = new EntityFieldError();
				entityFieldError.setFieldName(PSDEField.FIELD_PRECISION2);
				entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
				entityFieldError.setErrorInfo(strRuleInfo);
				return entityFieldError;
			}
		}
		
		
		return null;
	}
	
	private EntityFieldError onCheckField_FormulaFields(IService iService,PSDEField et, boolean bCreate, boolean bTempMode) throws Exception {
		PSDEFieldService psdeFieldService = (PSDEFieldService) ServiceGlobal.getService(PSDEFieldService.class, iService.getSessionFactory());
		
		String strRuleInfo  = null;
		
		if(!StringHelper.isNullOrEmpty(et.getFormulaFields())) {
			String value = et.getFormulaFields().toUpperCase();
	        //设置正则表达式
	        Pattern pattern = Pattern.compile("^[ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_|;]*$");
	        
	        //检查值规则[默认规则]
	        Matcher matcher = pattern.matcher(value);
	        if(!matcher.find()) {
	        	strRuleInfo = "逻辑属性参数只允许使用;或|分隔。";
	        	EntityFieldError entityFieldError = new EntityFieldError();
	            entityFieldError.setFieldName(PSDEField.FIELD_FORMULAFIELDS);
	            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
	            entityFieldError.setErrorInfo(strRuleInfo);
	            return entityFieldError;
	        }	
	        //当前属性所属实体下所有属性
	        ArrayList<PSDEField> psdeFieldList = psdeFieldService.selectByDataEntity(et.getPSDEId());
	        ArrayList<String> strList = new ArrayList<>();
	        for (PSDEField psdeField : psdeFieldList) {
	        	strList.add(psdeField.getPSDEFieldName());
			}
	        //设置截取字符串正则
	        Pattern pattern3 = Pattern.compile("[;|]+");
	        String[] strGroup = pattern3.split(value);
	        StringBuilderEx strError = new StringBuilderEx();
	        for (String string : strGroup) {
		        if(!strList.contains(string)) {
		        	strError.append(string+";");
		        }
			}
	        
	        if(!StringHelper.isNullOrEmpty(strError.toString())) {
	        	strRuleInfo = "逻辑属性参数所设置属性必须在当前实体下.("+strError.toString()+")未在当前实体下。";
	        	EntityFieldError entityFieldError = new EntityFieldError();
	            entityFieldError.setFieldName(PSDEField.FIELD_FORMULAFIELDS);
	            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
	            entityFieldError.setErrorInfo(strRuleInfo);
	            return entityFieldError;
	        }
		}
		
        return null;
    }
	
	private EntityFieldError onCheckField_Length(IService iService, PSDEField et, boolean bCreate,
			boolean bTempMode) throws Exception {
		String strRuleInfo  = null;
		if(!StringHelper.isNullOrEmpty(et.getLength())){
			int length=et.getLength().intValue();
			String number = length+"";
			//判断Length的值中是否有"."
			if(number.indexOf(".") != -1){
				strRuleInfo="输入值数据类型不正确";
				EntityFieldError entityFieldError = new EntityFieldError();
	            entityFieldError.setFieldName(PSDEField.FIELD_FORMULAFIELDS);
	            entityFieldError.setErrorType(EntityFieldError.ERROR_DATATYPE);
	            entityFieldError.setErrorInfo(strRuleInfo);
	            return entityFieldError;
			}
			if(StringHelper.compare(et.getPSDataTypeId(), "LONGTEXT_1000", true) == 0 || StringHelper.compare(et.getPSDataTypeId(), "TEXT", true) == 0){
				if(length <1  ||  length >4000){
					strRuleInfo="文本，可指定长度类型,输入值长度应在1至4000之间";
					EntityFieldError entityFieldError = new EntityFieldError();
		            entityFieldError.setFieldName(PSDEField.FIELD_LENGTH);
		            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
		            entityFieldError.setErrorInfo(strRuleInfo);
		            return entityFieldError;
				}
			}
			if(StringHelper.compare(et.getPSDataTypeId(), "FLOAT", true) == 0){
				if(length <1 || length >38){
					strRuleInfo="浮点类型,输入值长度应在1至38之间";
					EntityFieldError entityFieldError = new EntityFieldError();
		            entityFieldError.setFieldName(PSDEField.FIELD_LENGTH);
		            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
		            entityFieldError.setErrorInfo(strRuleInfo);
		            return entityFieldError;
				}
			}
			if(StringHelper.compare(et.getPSDataTypeId(), "DECIMAL", true) == 0){
				if(length <1 || length >65){
					strRuleInfo="数值类型,输入值输入值长度应在1至65之间";
					EntityFieldError entityFieldError = new EntityFieldError();
		            entityFieldError.setFieldName(PSDEField.FIELD_LENGTH);
		            entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
		            entityFieldError.setErrorInfo(strRuleInfo);
		            return entityFieldError;
				}
			}
			
		}
		return null;
	}
	
	/**
	 * 获取字符串格式参数最大索引值
	 * @param strValue
	 * @return
	 */
	protected int getStringFormatMaxIndex(String strValue){
		int nMaxNum = 0;
		//设置正则表达式
        Pattern pattern = Pattern.compile("%([0-9]+?)\\$");
        
        //检查值规则[默认规则]
        Matcher matcher = pattern.matcher(strValue);
        while(matcher.find()) {
        	if(matcher.groupCount()>0){
        		int nTemp = Integer.parseInt(matcher.group(1));
        		if(nTemp > nMaxNum)
        			nMaxNum = nTemp;
        	}
        }
        return nMaxNum;
	}
}
