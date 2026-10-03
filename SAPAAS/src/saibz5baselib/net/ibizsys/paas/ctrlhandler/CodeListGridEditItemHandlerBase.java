package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.codelist.IDynamicCodeList;
import net.ibizsys.paas.ctrlmodel.GridEditItemModel;
import net.ibizsys.paas.ctrlmodel.IFormItemModel;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.sf.json.JSONObject;

/**
 * 代码表表格编辑项处理基类
 * 
 * @author lionlau
 *
 */
public abstract class CodeListGridEditItemHandlerBase extends GridEditItemHandlerBase {
	/**
	 * 获取代码表模型
	 * 
	 * @return
	 */
	protected abstract ICodeList getCodeList() throws Exception;

	@Override
	protected AjaxActionResult onItemFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();

		ICodeList iCodeList = this.getCodeList();
		fillFetchResult(mdAjaxActionResult, iCodeList);
		return mdAjaxActionResult;
	}

	/**
	 * 填充数据获取结果
	 * <p>
	 * iCodeList 如未实现接口{@link net.ibizsys.paas.sysmodel.ICodeListModel}，暂未实现
	 * 
	 * @param fetchResult
	 * @param iCodeList
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult, ICodeList iCodeList) throws Exception {
		String strGridEditItem = this.getWebContext().getParamValue("SRFFORMITEMID") ;
		GridEditItemModel gridEditItem = (GridEditItemModel)this.getGridModel().getGridEditItem(strGridEditItem, true) ;
		if(gridEditItem != null) {
			java.util.Iterator<ICodeItem> codeItems = null;
				if (iCodeList instanceof IDynamicCodeList) {
					IDynamicCodeList iDynamicCodeList = (IDynamicCodeList) iCodeList;
					codeItems = iDynamicCodeList.queryCodeItems(this.getWebContext(),null);
				} else
					codeItems = iCodeList.getCodeItems();
				
				while (codeItems.hasNext()) {
					ICodeItem iCodeItem = codeItems.next();
					JSONObject item = new JSONObject();
					item.put("text",JSONObjectHelper.stripQuotes( this.getCodeItemText(this.getWebContext(), iCodeItem)));
					item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue()));
					if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
						item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue()));
					}
					if(iCodeItem.isDisableSelect()){
						item.put("disabled", true);
					}
					if(iCodeItem.getCodeItems()==null || !iCodeItem.getCodeItems().hasNext()){
						item.put("leaf", true);
					}
					else{
						if(gridEditItem.getOutputCodeListConfigMode() == IFormItemModel.OUTPUTCODELISTCONFIGMODE_INCLUDECHILD){
							fillCodeListItems(this.getWebContext(),item,iCodeItem);
						}
					}
					fetchResult.getRows().add(item) ;
				}
			return ;
		}
		
		ICodeListModel iCodeListModel = null;
		if (iCodeList instanceof ICodeListModel) {
			iCodeListModel = (ICodeListModel) iCodeList;
			iCodeListModel.fillFetchResult(fetchResult, this.getWebContext());
		} else {
			// 没有实现
		}
	}
	
	/**
	 * 填充代码表项集合
	 * @param iWebContext 
	 * @param parentItem
	 * @param parentCodeItem
	 * @throws Exception
	 */
	protected void fillCodeListItems(IWebContext iWebContext, JSONObject parentItem,ICodeItem parentCodeItem )throws Exception{
		ArrayList list = new ArrayList();
		Iterator items = parentCodeItem.getCodeItems();
		while(items.hasNext()){
			ICodeItem iCodeItem = (ICodeItem)items.next();
			JSONObject item = new JSONObject();
			item.put("text",JSONObjectHelper.stripQuotes( this.getCodeItemText(iWebContext, iCodeItem)));
			item.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue()));
			if (!StringHelper.isNullOrEmpty(iCodeItem.getParentValue())) {
				item.put("pvalue", JSONObjectHelper.stripQuotes(iCodeItem.getParentValue()));
			}
			if(iCodeItem.isDisableSelect()){
				item.put("disabled", true);
			}
			if(iCodeItem.getCodeItems()==null || !iCodeItem.getCodeItems().hasNext()){
				item.put("leaf", true);
			}
			else{
				fillCodeListItems(iWebContext,item,iCodeItem);
			}
			list.add(item);
		}
		parentItem.put("items",list.toArray());
	}
	
	/**
	 * 获取代码项文本
	 * @param iWebContext
	 * @param iCodeItem
	 * @return
	 */
	protected String getCodeItemText(IWebContext iWebContext,ICodeItem iCodeItem){
		String strText = iCodeItem.getText();
		String strTextLanResTag = iCodeItem.getTextLanResTag();
		if(!StringHelper.isNullOrEmpty(strTextLanResTag)){
			strText = iWebContext.getLocalization(strTextLanResTag, strText);
		}
		return strText;
	}
}
