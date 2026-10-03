package net.ibizsys.paas.sysmodel;

import java.util.HashMap;
import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * 动态静态代码表模型对象类型
 * @author Administrator
 *
 */
public abstract class DynaStaticCodeListModelBase extends StaticCodeListModelBase implements IDynaCodeListModelContainer {

	private HashMap<String,IDynaCodeListModel> dynaCodeListModelMap = new HashMap<String,IDynaCodeListModel>();
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.IDynaCodeListModelContainer#registerDynaCodeListModel(net.ibizsys.paas.sysmodel.IDynaCodeListModel)
	 */
	@Override
	public void registerDynaCodeListModel(IDynaCodeListModel iDynaCodeListModel) throws Exception {
		String strDynaSysInstId = iDynaCodeListModel.getDynaInstId();
		dynaCodeListModelMap.put(strDynaSysInstId, iDynaCodeListModel);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.IDynaCodeListModelContainer#resetCurrentDynaSysInst()
	 */
	@Override
	public void resetCurrentDynaSysInst() {
		if(WebContext.getCurrent()!=null){
			String strDynaSysInstId = WebContext.getDynaSysInstId(WebContext.getCurrent());
			if(!StringHelper.isNullOrEmpty(strDynaSysInstId)){
				dynaCodeListModelMap.remove(strDynaSysInstId);
			}
		}
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.IDynaCodeListModelContainer#resetAllDynaSysInst()
	 */
	@Override
	public void resetAllDynaSysInst() {
		dynaCodeListModelMap.clear();
	}

	@Override
	public String getCodeListText(String strValue, boolean bRecursion) throws Exception {
		IDynaCodeListModel iDynaCodeListModel = getCurrentDynaCodeListModel();
		if(iDynaCodeListModel!=null)
			return iDynaCodeListModel.getCodeListText(strValue, bRecursion);
		return super.getCodeListText(strValue, bRecursion);
	}

	@Override
	public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
		IDynaCodeListModel iDynaCodeListModel = getCurrentDynaCodeListModel();
		if(iDynaCodeListModel!=null)
			return iDynaCodeListModel.getCodeListText(strValue, bRecursion, activeData, iWebContext);
		return super.getCodeListText(strValue, bRecursion, activeData, iWebContext);
	}

	@Override
	public ICodeItem getCodeItemByText(String strText) throws Exception {
		IDynaCodeListModel iDynaCodeListModel = getCurrentDynaCodeListModel();
		if(iDynaCodeListModel!=null)
			return iDynaCodeListModel.getCodeItemByText(strText);
		return super.getCodeItemByText(strText);
	}

	@Override
	public ICodeItem getCodeItem(String strValue) throws Exception {
		IDynaCodeListModel iDynaCodeListModel = getCurrentDynaCodeListModel();
		if(iDynaCodeListModel!=null)
			return iDynaCodeListModel.getCodeItem(strValue);
		return super.getCodeItem(strValue);
	}

	@Override
	public ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception {
		IDynaCodeListModel iDynaCodeListModel = getCurrentDynaCodeListModel();
		if(iDynaCodeListModel!=null)
			return iDynaCodeListModel.getCodeItemByText(strText, bRecursion);
		return super.getCodeItemByText(strText, bRecursion);
	}

	@Override
	public ICodeItem getCodeItem(String strValue, boolean bRecursion) throws Exception {
		IDynaCodeListModel iDynaCodeListModel = getCurrentDynaCodeListModel();
		if(iDynaCodeListModel!=null)
			return iDynaCodeListModel.getCodeItem(strValue, bRecursion);
		return super.getCodeItem(strValue, bRecursion);
	}
	
	/**
	 * 获取当前的动态流程模型对象
	 * @return
	 */
	protected IDynaCodeListModel getCurrentDynaCodeListModel(){
		if(WebContext.getCurrent()!=null){
			String strDynaSysInstId = WebContext.getDynaSysInstId(WebContext.getCurrent());
			if(!StringHelper.isNullOrEmpty(strDynaSysInstId)){
				return  dynaCodeListModelMap.get(strDynaSysInstId);
			}
		}
		return null;
	}
	
	@Override
	public Iterator<ICodeItem> getCodeItems() throws Exception {
		IDynaCodeListModel iDynaCodeListModel = getCurrentDynaCodeListModel();
		if(iDynaCodeListModel!=null)
			return iDynaCodeListModel.getCodeItems();
		return super.getCodeItems();
	}
	
	
	@Override
	public IDynaCodeListModel createDynaCodeListModel(IEntity iEntity) throws Exception {
		return new DefaultDynaStaticCodeListModel();
	}
}
