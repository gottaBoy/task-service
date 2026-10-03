package net.ibizsys.paas.db;

import java.util.Iterator;

import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.sf.json.JSONObject;

/**
 * 选择过滤条件
 * @author Administrator
 *
 */
public abstract class SelectFilterBase extends ModelBaseImpl implements ISelectFilter,IDEDataQueryCodeCond {

	public final static String ATTR_CONDTYPE = "type";

	
	protected String strCondOp = null;
	protected String strDEFName = null;
	protected String strCondValue = null;
	protected String strCustomCond = null;
	protected String strDEFieldExp = null;
	protected int nStdDataType = DataTypes.UNKNOWN;
	protected boolean bNotMode = false;
	protected String strValueFunc = null;
	
	
	@Override
	public String getDEFName() {
		return this.strDEFName;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getCondOp()
	 */
	@Override
	public String getCondOp() {
		return this.strCondOp;
	}
	
	/**
	 * 设置条件操作，值参考  net.ibizsys.paas.logic.ICondition  
	 * @param strCondOp
	 */
	public void setCondOp(String strCondOp){
		this.strCondOp = strCondOp;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEDataQueryCodeCond#getCondValue()
	 */
	@Override
	public String getCondValue() {
		return this.strCondValue;
	}

	@Override
	public String getCustomCond() {
		return this.strCustomCond;
	}

	@Override
	@Deprecated
	public String getPredefindedCond() {
		return null;
	}
	
	

	@Override
	public String getPredefinedCode() {
		return null;
	}


	@Override
	public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
		return null;
	}

	@Override
	public String getDEFieldExp() {
		return this.strDEFieldExp;
	}

	@Override
	public boolean isNotMode() {
		return this.bNotMode;
	}

	@Override
	public int getStdDataType() {
		return this.nStdDataType;
	}


	@Override
	public String getValueFunc() {
		return strValueFunc;
	}
	
	
	/**
	 * 导出到JSON对象
	 * @param iSelectFilter
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	protected static JSONObject toJSONObject(ISelectFilter iSelectFilter,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		JSONObjectHelper.put(jsonObject, ATTR_CONDTYPE, iSelectFilter.getCondType());
		return jsonObject;
	}
	
	/**
	 * 从JSON对象中构建
	 * @param jsonObject
	 * @param selectFilterBase
	 * @return
	 * @throws Exception
	 */
	protected static ISelectFilter fromJSONObject(JSONObject jsonObject,SelectFilterBase selectFilterBase) throws Exception {
		return selectFilterBase;
	}
}
