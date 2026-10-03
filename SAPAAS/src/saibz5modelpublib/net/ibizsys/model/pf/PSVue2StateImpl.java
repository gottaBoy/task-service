package net.ibizsys.model.pf;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;

/**
 * AngularJS 路由状态项
 * @author Administrator
 *
 */
public class PSVue2StateImpl extends PSObjectImpl implements IPSNGState {

	private IPSNGState parentState = null;
	private int nLevel = 0;
	private ArrayList<IPSNGState> childStateList = new ArrayList<IPSNGState>();
	private String strFullStateName = "";
	private IPSAppView iPSAppView = null;
	private int nIndex = 0;
	private String strCId = "";
	private JSONObject viewParamJO = null;

	/**
	 * 初始�?
	 * @param parentState
	 * @param strName
	 */
	public void init(IPSNGState parentState,String strName){
		this.parentState = parentState;
		strName = strName.toLowerCase();
		this.setName(strName);
		
		if(this.parentState!=null){
			this.strFullStateName  = StringHelper.format("%1$s.%2$s",parentState.getFullStateName(),this.getName());
			this.nLevel = parentState.getLevel()+1;
		}
		else
			this.strFullStateName = strName;
		
	}
	
	@Override
	public String getPSSysModelInstId() {
		return null;
	}

	@Override
	public String getFullStateName() {
		return this.strFullStateName;
	}

	@Override
	public IPSNGState getParentState() {
		return this.parentState ;
	}

	@Override
	public IPSAppView getPSAppView() {
		return this.iPSAppView;
	}
	
	public void setPSAppView(IPSAppView iPSAppView){
		this.iPSAppView = iPSAppView;
	}

	@Override
	public Iterator<IPSNGState> getChildStates() {
		return childStateList.iterator();
	}
	
	/**
	 * 获取子状态列�?
	 * @return
	 */
	public ArrayList<IPSNGState> getChildStateList(){
		return childStateList;
	}

	@Override
	public int getLevel() {
		return nLevel;
	}

	/**
	 * 设置路由状�?�编�?
	 * @param nIndex
	 */
	public void setIndex(int nIndex){
		this.nIndex = nIndex;
		if(this.nIndex==0){
			this.strCId = "";
		}
		else{
			this.strCId = StringHelper.format("C%1$s",this.nIndex);
		}
	}
	
	@Override
	public String getCId() {
		
		return this.strCId;
	}

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.PF.IPSNGState#getViewParamJO()
	 */
	@Override
	public JSONObject getViewParamJO() {
		return this.viewParamJO;
	}

	/**
	 * 设置视图参数Json对象
	 * @param viewParamJO
	 */
	public void setViewParamJO(JSONObject viewParamJO){
		this.viewParamJO  =viewParamJO;
	}

	/* (non-Javadoc)
	 * @see SA.SRFDA.PS.Core.PF.IPSNGState#getViewParamJOString()
	 */
	@Override
	public String getViewParamJOString() {
		if(getViewParamJO()!=null)
			return getViewParamJO().toString();
		return "";
	}
	
	/**
	 * 设置层级
	 * @param level
	 */
	public void setLevel(int level) {
		this.nLevel = level;
	}
	
	
}
