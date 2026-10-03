package net.ibizsys.paas.demodel;

import java.util.ArrayList;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.impl.SimpleDataRowImpl;
import net.ibizsys.paas.util.StringHelper;

/**
 * 索引实体关系数据结果集对象
 * 
 * @author lionlau
 *
 */
public abstract class IndexDERDEDataSetModelBase extends PredefinedDEDataSetModelBase {
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
//		java.util.Iterator<ICodeItem> codeItems = this.getCodeList().getCodeItems();
//		while (codeItems.hasNext()) {
//			ICodeItem iCodeItem = codeItems.next();
//			SimpleDataRowImpl simpleDataRowImpl = new SimpleDataRowImpl();
//			simpleDataRowImpl.set("srfmajortext", iCodeItem.getRealText());
//			simpleDataRowImpl.set("srfkey", iCodeItem.getValue());
//			simpleDataRowImpl.set("srfcolor", iCodeItem.getColor());
//			simpleDataRowImpl.set("srficonpath", iCodeItem.getIconPath());
//			simpleDataRowImpl.set("srfmemo", iCodeItem.getMemo());
//
//			// 模拟数据主键
//			simpleDataRowImpl.set(this.getDataEntity().getKeyDEField().getName().toLowerCase(), iCodeItem.getValue());
//			simpleDataRowImpl.set(this.getDataEntity().getMajorDEField().getName().toLowerCase(), iCodeItem.getRealText());
//
//			// simpleDataRowImpl.set("srficon", iCodeItem.get());
//			dataRowList.add(simpleDataRowImpl);
//		}
		
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
}
