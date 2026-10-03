package net.ibizsys.paas.sysmodel.util;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import net.ibizsys.paas.core.IScriptValueRule;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.SystemValueRuleModelBase;

/**
 * 脚本值规则模型对象
 * @author Administrator
 *
 */
public  class ScriptValueRuleModel extends SystemValueRuleModelBase implements IScriptValueRule {

	/**
	 * 脚本值规则上下文对象
	 * @author Administrator
	 *
	 */
	private class ScriptValueRuleContext{
		
		private ThreadLocal<IEntity> et = new ThreadLocal<IEntity>();
		private ThreadLocal<String> strFieldName = new ThreadLocal<String>();
		private ThreadLocal<Boolean> bTempMode = new ThreadLocal<Boolean>();
		private ThreadLocal<Object> value = new ThreadLocal<Object>();
		
		public void setEntity(IEntity et){
			this.et.set(et);
		}
		
		public IEntity getEntity(){
			return this.et.get();
		}
		
		public void setField(String strFieldName){
			this.strFieldName.set(strFieldName);
		}
		
		public String getField(){
			return this.strFieldName.get();
		}
		
		public void setTempMode(boolean bTempMode){
			this.bTempMode.set(bTempMode);
		}
		
		public boolean isTempMode(){
			if(this.bTempMode.get()==null)
				return false;
			return this.bTempMode.get();
		}
		
		public Object getValue(){
			return value.get();
		}
		
		public void setValue(Object objValue){
			this.value.set(objValue);
		}
		
		public void reset(){
			this.et.set(null);
			this.strFieldName.set(null);
			this.bTempMode.set(null);
			this.value.set(null);
		}
		
		
	}
	
	private String strCode = null;

	private ScriptValueRuleContext scriptValueRuleContext = new ScriptValueRuleContext();
	
	private Invocable  invocable  = null;
	
	@Override
	protected void onInit() throws Exception {
		
		ScriptEngineManager manager = new ScriptEngineManager();  
	    ScriptEngine engine = manager.getEngineByName("JavaScript");  
	    String strJSCode = "function main(value,ctx){";
	    strJSCode += this.getCode();
	    strJSCode += "}";
	    engine.eval(strJSCode);
	    
	    invocable = (Invocable)engine;
	    
		super.onInit();
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IValueRule#getRuleType()
	 */
	@Override
	public String getRuleType() {
		return RULETYPE_SCRIPT;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IScriptValueRule#getCode()
	 */
	@Override
	public String getCode() {
		return this.strCode;
	}

	
	/**
	 * 设置脚本代码
	 * @param strCode
	 */
	public void setCode(String strCode){
		this.strCode = strCode;
	}

	@Override
	public boolean check(IEntity et, String strFieldName, boolean bTempMode, Object objParam, String strRuleInfo, boolean bTryMode) throws Exception {
	
		if (!et.contains(strFieldName)){
			return true;
		}
		
		Object objValue = et.get(strFieldName);
		if(objValue == null)
			return true;
			
		try{
			scriptValueRuleContext.reset();
			scriptValueRuleContext.setEntity(et);
			scriptValueRuleContext.setField(strFieldName);
			scriptValueRuleContext.setTempMode(bTempMode);
			scriptValueRuleContext.setValue(objValue);
		
			Object objRet = invocable.invokeFunction("main",objValue,scriptValueRuleContext);
			boolean bRet = false;
			if(objRet != null && objRet instanceof Boolean){
				bRet = (Boolean)objRet;
			}
			scriptValueRuleContext.reset();
			if (!bRet) {
				if (bTryMode) return false;

				throw new Exception(strRuleInfo);
			}
			return true;
			
		}
		catch(Exception ex){
			scriptValueRuleContext.reset();
			throw ex;
		}
	}
	
	
	
}
