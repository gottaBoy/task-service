package net.ibizsys.paas.db;

import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;


/**
 * 查询字段过滤条件
 * @author Administrator
 *
 */
public class SelectFieldFilter extends SelectFilterBase implements ISelectFieldFilter  {

	public final static String ATTR_CONDOP = "cond";
	public final static String ATTR_DEFNAME = "defname";
	public final static String ATTR_CONDVALUE = "condvalue";
	public final static String ATTR_CUSTOMCOND = "customcond";
	public final static String ATTR_DEFIELDEXP = "defexp";
	public final static String ATTR_DATATYPE = "datatype";
	public final static String ATTR_PREDEFINED = "predefined";
	public final static String ATTR_FUNC = "func";
	
	private static Object UnsetCondValue = new Object();
	private Object objCondValue = UnsetCondValue;
	
	@Override
	public String getCondType() {
		return CONDTYPE_DEFIELD;
	}

	
	/**
	 * 设置属性名称
	 * @param strDEFName
	 */
	public void setDEFName(String strDEFName){
		this.strDEFName = strDEFName;
	}
	
	
	
	/**
	 * 设置条件值
	 * @param strCondValue
	 */
	public void setCondValue(String strCondValue){
		this.strCondValue = strCondValue;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.psba.dao.IBASelectFilter#getCondObjectValue()
	 */
	@Override
	public Object getCondObjectValue() throws Exception {
		if(objCondValue == UnsetCondValue){
			return DataTypeHelper.parse(this.getStdDataType(), super.getCondValue());
		}
		else {
			return objCondValue;
		}
	}
	
	@Override
	public String getCondValue() {
		if(objCondValue == UnsetCondValue){
			return super.getCondValue();
		}
		if(objCondValue == null){
			return null;
		}
		else {
			if(objCondValue instanceof String){
				return (String)objCondValue;
			}
			else{
				return objCondValue.toString();
			}
		}
	}
	
	
	/**
	 * 设置条件值（对象形式）
	 * @param objCondValue
	 */
	public void setCondObjectValue(Object objCondValue){
		this.objCondValue = objCondValue;
		
	}
	
	/**
	 * 重置条件值（对象形式）
	 * @param objCondValue
	 */
	public void resetCondObjectValue(){
		this.objCondValue = UnsetCondValue;
	}
	
	

	/**
	 * 设置值函数
	 * @param strValueFunc
	 */
	public void setValueFunc(String strValueFunc) {
		this.strValueFunc = strValueFunc;
	}

	/**
	 * 导出到JSON对象
	 * @param iSelectFieldFilter
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(ISelectFieldFilter iSelectFieldFilter,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		Object objCondValue = iSelectFieldFilter.getCondObjectValue();
		JSONObjectHelper.put(jsonObject, ATTR_CONDVALUE, objCondValue);
		
		if(iSelectFieldFilter instanceof IDEDataQueryCodeCond ){
			IDEDataQueryCodeCond iDEDataQueryCodeCond = (IDEDataQueryCodeCond)iSelectFieldFilter;
			if(iDEDataQueryCodeCond.getCondOp()!=null){
				JSONObjectHelper.put(jsonObject, ATTR_CONDOP, iDEDataQueryCodeCond.getCondOp());
			}
			
//			if(iDEDataQueryCodeCond.getCondValue()!=null){
//				JSONObjectHelper.put(jsonObject, ATTR_CONDVALUE, iDEDataQueryCodeCond.getCondValue());
//			}
			
			if(iDEDataQueryCodeCond.getDEFName()!=null){
				JSONObjectHelper.put(jsonObject, ATTR_DEFNAME, iDEDataQueryCodeCond.getDEFName());
			}
			
//			if(iDEDataQueryCodeCond.getDEFieldExp()!=null){
//				JSONObjectHelper.put(jsonObject, ATTR_DEFIELDEXP, iDEDataQueryCodeCond.getDEFieldExp());
//			}
			
//			if(iDEDataQueryCodeCond.getStdDataType()!=DataTypes.UNKNOWN){
//				JSONObjectHelper.put(jsonObject, ATTR_DATATYPE, iDEDataQueryCodeCond.getStdDataType());
//			}
			
//			if(iDEDataQueryCodeCond.isNotMode()){
//				JSONObjectHelper.put(jsonObject, ATTR_NOT, iDEDataQueryCodeCond.isNotMode());
//			}
//			
//			if(iDEDataQueryCodeCond.getCustomCond()!=null){
//				JSONObjectHelper.put(jsonObject, ATTR_CUSTOMCOND, iDEDataQueryCodeCond.getCustomCond());
//			}
			
			if(iDEDataQueryCodeCond.getValueFunc()!=null){
				JSONObjectHelper.put(jsonObject, ATTR_FUNC, iDEDataQueryCodeCond.getValueFunc());
			}
			
		}
		
		
		
		SelectFilterBase.toJSONObject(iSelectFieldFilter, jsonObject);
		return jsonObject;
	}
	
	/**
	 * 从JSON对象中构建
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static ISelectFieldFilter fromJSONObject(JSONObject jsonObject) throws Exception {
		SelectFieldFilter selectFieldFilter = new SelectFieldFilter();
		
		Object objCondValue = jsonObject.opt(ATTR_CONDVALUE);
		if(objCondValue!=null){
			selectFieldFilter.setCondObjectValue(objCondValue);
		}
		
		String strCondOp = jsonObject.optString(ATTR_CONDOP,null);
		if(strCondOp!=null){
			selectFieldFilter.setCondOp(strCondOp);
		}
		
		String strDEFName = jsonObject.optString(ATTR_DEFNAME,null);
		if(strDEFName!=null){
			selectFieldFilter.setDEFName(strDEFName);
		}
		
		String strFunc = jsonObject.optString(ATTR_FUNC,null);
		if(strFunc!=null){
			selectFieldFilter.setValueFunc(strFunc);
		}

		
		return selectFieldFilter;
	}
}
