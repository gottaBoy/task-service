package net.ibizsys.paas.db;

import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 查询字段实现对象
 * 
 * @author Administrator
 *
 */
public class SelectField implements ISelectField {

	/**
	 * 属性：名称
	 */
	public final static String ATTR_NAME = "name";
	
	/**
	 * 属性：别名
	 */
	public final static String ATTR_ALIAS = "alias";
	
	/**
	 * 属性：别名
	 */
	public final static String ATTR_FUNC = "func";
	
	
	private String strName = null;
	private String strAlias = null;
	private String strFunc = null;
	
	public SelectField(){
		
	}
	


	@Override
	public String getName() {
		return this.strName;
	}

	@Override
	public String getAlias() {
		return this.strAlias;
	}

	@Override
	public String getFunc() {
		return this.strFunc;
	}

	/**
	 * 获取字段名称，多个使用分号[,]分隔
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 设置查询别名
	 * 
	 * @param strAlias
	 */
	public void setAlias(String strAlias) {
		this.strAlias = strAlias;
	}

	/**
	 * 设置函数名称
	 * 
	 * @param strFunc
	 */
	public void setFunc(String strFunc) {
		this.strFunc = strFunc;
	}


	
	/**
	 * 导出到JSON对象
	 * @param iSelectField
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(ISelectField iSelectField) throws Exception {
		return toJSONObject(iSelectField,null);
	}
	
	/**
	 * 导出到JSON对象
	 * @param iSelectField
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(ISelectField iSelectField,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		if(iSelectField.getName()!=null){
			JSONObjectHelper.put(jsonObject, ATTR_NAME, iSelectField.getName());
		}
		
		if(iSelectField.getAlias()!=null){
			JSONObjectHelper.put(jsonObject, ATTR_ALIAS, iSelectField.getAlias());
		}
		
		if(iSelectField.getFunc()!=null){
			JSONObjectHelper.put(jsonObject, ATTR_FUNC, iSelectField.getFunc());
		}
		
		return jsonObject;
	}
	
	
	/**
	 * 从JSON对象中构造
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static ISelectField fromJSONObject(JSONObject jsonObject) throws Exception {
		SelectField selectField = new SelectField();
		selectField.setName(jsonObject.optString(ATTR_NAME));
		selectField.setAlias(jsonObject.optString(ATTR_ALIAS));
		selectField.setFunc(jsonObject.optString(ATTR_FUNC));
		return selectField;
	}
	
	
	/**
	 * 创建选择字段对象
	 * @param strName
	 * @return
	 */
	public static ISelectField create(String strName){
		SelectField selectField = new SelectField();
		selectField.setName(strName);
		return selectField;
	}
	
	
	/**
	 * 创建选择字段对象
	 * @param strName
	 * @param strAlias 
	 * @return
	 */
	public static ISelectField create(String strName,String strAlias){
		SelectField selectField = new SelectField();
		selectField.setName(strName);
		selectField.setAlias(strAlias);
		return selectField;
	}
	
	
	/**
	 * 创建选择字段对象
	 * @param strName
	 * @param strAlias 
	 * @param strFunc
	 * @return
	 */
	public static ISelectField create(String strName,String strAlias,String strFunc){
		SelectField selectField = new SelectField();
		selectField.setName(strName);
		selectField.setAlias(strAlias);
		selectField.setFunc(strFunc);
		return selectField;
	}
}
