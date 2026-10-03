package net.ibizsys.paas.db;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 查询过滤组过滤条件
 * @author Administrator
 *
 */
public class SelectGroupFilter extends SelectFilterBase implements ISelectGroupFilter {

	public final static String ATTR_NOT = "not";
	public final static String ATTR_CONDS = "conds";
	
	protected ArrayList<IDEDataQueryCodeCond> list = null; 
	
	public SelectGroupFilter(){
		this.strCondOp = ICondition.CONDOP_AND;
	}
	
	@Override
	public String getCondType() {
		return CONDTYPE_GROUP;
	}
	
	public void setNotMode(boolean bNotMode){
		this.bNotMode = bNotMode;
	}

	@Override
	public ArrayList<IDEDataQueryCodeCond> getSelectFilterList(boolean bCreateIfNotExists) {
		if(list == null && bCreateIfNotExists){
			list = new ArrayList<IDEDataQueryCodeCond>();
		}
		return list;
	}

	@Override
	public Iterator<IDEDataQueryCodeCond> getChildDEDataQueryConds() {
		if(list == null)
			return null;
		return list.iterator();
	}

	/**
	 * 导出到JSON对象
	 * @param iSelectGroupFilter
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(ISelectGroupFilter iSelectGroupFilter,JSONObject jsonObject) throws Exception {
		if(jsonObject==null){
			jsonObject = new JSONObject();
		}
		
		if(iSelectGroupFilter.isNotMode()){
			JSONObjectHelper.put(jsonObject, ATTR_NOT, iSelectGroupFilter.isNotMode());
		}
		
		Iterator<IDEDataQueryCodeCond> deDataQueryCodeConds = iSelectGroupFilter.getChildDEDataQueryConds();
		if(deDataQueryCodeConds!=null){
			ArrayList<JSONObject > joList = new ArrayList<JSONObject > ();
			while(deDataQueryCodeConds.hasNext()){
				IDEDataQueryCodeCond iDEDataQueryCodeCond = deDataQueryCodeConds.next();
				if(iDEDataQueryCodeCond instanceof ISelectGroupFilter){
					joList.add(SelectGroupFilter.toJSONObject((ISelectGroupFilter)iDEDataQueryCodeCond,null));
					continue;
				}
				
				if(iDEDataQueryCodeCond instanceof ISelectFieldFilter){
					joList.add(SelectFieldFilter.toJSONObject((ISelectFieldFilter)iDEDataQueryCodeCond,null));
					continue;
				}
			}
			
			if(joList.size()>0){
				jsonObject.put(ATTR_CONDS, JSONArray.fromCollection(joList));
			}
		}
		
		SelectFilterBase.toJSONObject(iSelectGroupFilter, jsonObject);
		return jsonObject;
	}
	
	/**
	 * 从JSON对象中构建
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	public static ISelectGroupFilter fromJSONObject(JSONObject jsonObject) throws Exception {
		SelectGroupFilter selectGroupFilter = new SelectGroupFilter();
		
		boolean bNotMode = jsonObject.optBoolean(ATTR_NOT,false);
		if(bNotMode){
			selectGroupFilter.setNotMode(bNotMode);
		}
		
		JSONArray condsJA = jsonObject.optJSONArray(ATTR_CONDS);
		if(condsJA!=null){
			for(int i =0;i<condsJA.length();i++){
				JSONObject jo = condsJA.getJSONObject(i);
				String strCondType = jo.optString(ATTR_CONDTYPE);
				if(StringHelper.compare(strCondType, CONDTYPE_GROUP, true) == 0){
					selectGroupFilter.getSelectFilterList(true).add(SelectGroupFilter.fromJSONObject(jo));
					continue;
				}
				
				if(StringHelper.compare(strCondType, CONDTYPE_DEFIELD, true) == 0){
					selectGroupFilter.getSelectFilterList(true).add(SelectFieldFilter.fromJSONObject(jo));
					continue;
				}
			}
		}
		
		return selectGroupFilter;
	}
	
}
