package net.ibizsys.paas.demodel;

import java.util.ArrayList;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 代码表的数据结果集
 * 
 * @author lionlau
 *
 */
public abstract class CodeListDEDataSetModelBase extends PredefinedDEDataSetModelBase {
	/**
	 * 获取代码表模型
	 * 
	 * @return
	 */
	protected abstract ICodeList getCodeList() throws Exception;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.PredefinedDEDataSetModelBase#onFillDataRowList(java.util.ArrayList)
	 */
	@Override
	protected void onFillDataRowList(ArrayList<IDataRow> dataRowList) throws Exception {
		IViewController iViewController = ViewController.getCurrent();
		java.util.Iterator<ICodeItem> codeItems = this.getCodeList().getCodeItems();
		while (codeItems.hasNext()) {
			ICodeItem iCodeItem = codeItems.next();
			SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
			simpleDataRowImpl.set("srfmajortext", iCodeItem.getRealText());
			simpleDataRowImpl.set("srfkey", iCodeItem.getValue());
			simpleDataRowImpl.set("srfcolor", iCodeItem.getColor());
			if (iViewController != null) {
				simpleDataRowImpl.set("srficonpath", iViewController.getAppModel().getAppPFHelper().mapImageRealUrl(iCodeItem.getIconPath()));
			} else {
				simpleDataRowImpl.set("srficonpath", iCodeItem.getIconPath());
			}
			simpleDataRowImpl.set("srficoncls", iCodeItem.getIconCls());
			for (int i = 2; i <= 4; i++) {
				if (iViewController != null) {
					simpleDataRowImpl.set(StringHelper.format("srficonpath%1$s", i), iViewController.getAppModel().getAppPFHelper().mapImageRealUrl(iCodeItem.getIconPath(i)));
				} else {
					simpleDataRowImpl.set(StringHelper.format("srficonpath%1$s", i), iCodeItem.getIconPath(i));
				}
				simpleDataRowImpl.set(StringHelper.format("srficoncls%1$s", i), iCodeItem.getIconCls(i));
			}

			simpleDataRowImpl.set("srfmemo", iCodeItem.getMemo());

			// 模拟数据主键
			simpleDataRowImpl.set(this.getDataEntity().getKeyDEField().getName().toLowerCase(), iCodeItem.getValue());
			if(this.getDataEntity().getMajorDEField()!=null){
				simpleDataRowImpl.set(this.getDataEntity().getMajorDEField().getName().toLowerCase(), iCodeItem.getRealText());
			}

			dataRowList.add(simpleDataRowImpl);
		}

	}
	
	
	@Override
	protected boolean testAddDataRow(IDEDataSetFetchContext iDEDataSetFetchContext, IDataRow iDataRow) throws Exception {
		if(iDEDataSetFetchContext.getConditionList().size()>0 &&   WebContext.getCurrent()!=null){
			String strQuery = WebContext.getFetchQuickSearch(WebContext.getCurrent());
			if(!StringHelper.isNullOrEmpty(strQuery)){
				if(iDataRow.contains("srfmajortext")){
					String strText = DataObject.getStringValue(iDataRow.get("srfmajortext"),"");
					if(!StringHelper.isNullOrEmpty(strText)){
						return (strText.toUpperCase().indexOf(strQuery.toUpperCase())!=-1);
					}
				}
			}
		}
		
		return super.testAddDataRow(iDEDataSetFetchContext, iDataRow);
	}
}
