package net.ibizsys.paas.sysmodel;

import java.lang.annotation.Annotation;
import java.util.HashMap;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 代码表模型基类
 * 
 * @author lionlau
 *
 */
public abstract class CodeListModelBase extends CodeItemModel implements ICodeListModel {
	protected CodeList codeList = null;
	// protected ArrayList<ICodeItem> codeItemList = new ArrayList<ICodeItem>();
	protected HashMap<String, CodeItemModel> codeItemModelMap = new HashMap<String, CodeItemModel>();

	private ThreadLocal<IWebContext> webContext = new ThreadLocal<IWebContext>();
	private SessionFactory sessionFactory = null;
	private String strGlobalId = null;
	private ICodeListHelper iCodeListHelper = null;

	/**
	 * 初始化注解
	 * 
	 * @param c
	 * @throws Exception
	 */
	protected void initAnnotation(Class c) {
		Annotation[] annotations = c.getAnnotations();
		if (annotations != null) {
			for (Annotation annotation : annotations) {
				if (annotation instanceof CodeList) {
					prepareCodeList((CodeList) annotation);
					continue;
				}
			}
		}
	}

	/**
	 * 准备代码表
	 * 
	 * @param codeList
	 */
	protected void prepareCodeList(CodeList codeList) {
		this.codeList = codeList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.ISystemObject#getSystem()
	 */
	@Override
	public ISystem getSystem() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IModelBase#getId()
	 */
	@Override
	public String getId() {
		return this.codeList.id();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IModelBase#getName()
	 */
	@Override
	public String getName() {
		return this.codeList.name();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getCodeListText(java.lang.String, boolean)
	 */
	@Override
	public String getCodeListText(String strValue, boolean bRecursion) throws Exception {
		return getCodeListText(strValue, bRecursion, null, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getCodeListType()
	 */
	@Override
	public String getCodeListType() {
		return this.codeList.type();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getHandler()
	 */
	@Override
	public String getHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#isUserScope()
	 */
	@Override
	public boolean isUserScope() {
		return codeList.userscope();
	}

	/**
	 * 注册代码项模型
	 * 
	 * @param codeItemModel
	 */
	protected void registerCodeItemModel(CodeItemModel codeItemModel) {
		synchronized (codeItemModelMap) {
			codeItemModelMap.put(codeItemModel.getValue(), codeItemModel);
			if (StringHelper.isNullOrEmpty(codeItemModel.getParentValue())) {
				childCodeItemList.add(codeItemModel);
			} else {
				CodeItemModel parentCodeItemModel = codeItemModelMap.get(codeItemModel.getParentValue());
				parentCodeItemModel.registerChildCodeItemModel(codeItemModel);
			}
		}
	}

	/**
	 * 获取指定值代码项模型
	 * 
	 * @param strValue
	 * @return
	 */
	protected CodeItemModel getCodeItemModel(String strValue) {

		synchronized (codeItemModelMap) {
			return codeItemModelMap.get(strValue);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ICodeListModel#fillFetchResult(net.ibizsys.paas.web.MDAjaxActionResult, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public void fillFetchResult(MDAjaxActionResult fetchResult, IWebContext iWebContext) throws Exception {
		this.setWebContext(iWebContext);
		java.util.Iterator<ICodeItem> codeItems = this.getCodeItems();
		if (codeItems == null) return;
		
		String strQuickSearch = null;
		if(iWebContext!=null){
			strQuickSearch = WebContext.getFetchQuickSearch(iWebContext);
			if(!StringHelper.isNullOrEmpty(strQuickSearch)){
				strQuickSearch = strQuickSearch.toUpperCase().trim();
			}
		}
		
		while (codeItems.hasNext()) {
			ICodeItem iCodeItem = codeItems.next();
			if (!StringHelper.isNullOrEmpty(strQuickSearch)) {
				boolean bMatch = false;
				if((!StringHelper.isNullOrEmpty(iCodeItem.getText()))&&(iCodeItem.getText().toUpperCase().indexOf(strQuickSearch)!=-1)){
					bMatch = true;
				}
				if(!bMatch && (!StringHelper.isNullOrEmpty(iCodeItem.getRealText()))&&(iCodeItem.getRealText().toUpperCase().indexOf(strQuickSearch)!=-1)){
					bMatch = true;
				}
				if(!bMatch && (!StringHelper.isNullOrEmpty(iCodeItem.getValue()))&&(iCodeItem.getValue().toUpperCase().indexOf(strQuickSearch)!=-1)){
					bMatch = true;
				}
				if(!bMatch)
					continue;
			}
			JSONObject jo = new JSONObject();
			jo.put("text", JSONObjectHelper.stripQuotes(iCodeItem.getText(),true));
			jo.put("realtext", JSONObjectHelper.stripQuotes(iCodeItem.getRealText(),true));
			jo.put("value", JSONObjectHelper.stripQuotes(iCodeItem.getValue(),true));
			fetchResult.getRows().add(jo);
		}
	}

	/**
	 * 获取上下文对象
	 * 
	 * @return
	 */
	protected IWebContext getWebContext() {
		return webContext.get();
	}

	/**
	 * 设置上下文对象
	 * 
	 * @param value
	 */
	protected void setWebContext(IWebContext value) {
		webContext.set(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getOrMode()
	 */
	@Override
	public String getOrMode() {
		return this.codeList.ormode();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getValueSeparator()
	 */
	@Override
	public String getValueSeparator() {
		return this.codeList.valueseparator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getTextSeparator()
	 */
	@Override
	public String getTextSeparator() {
		return this.codeList.textseparator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getEmptyText()
	 */
	@Override
	public String getEmptyText() {
		return this.codeList.emptytext();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ICodeListModel#setSessionFactory(org.hibernate.SessionFactory)
	 */
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ICodeListModel#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getGlobalId()
	 */
	@Override
	public String getGlobalId() {
		return this.strGlobalId;
	}

	/**
	 * 设置代码表对象全局标识
	 * 
	 * @param strGlobalId
	 */
	public void setGlobalId(String strGlobalId) {
		this.strGlobalId = strGlobalId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeList#getCodeListText(java.lang.String, boolean, java.lang.Object, net.ibizsys.paas.web.IWebContext)
	 */
	@Override
	public String getCodeListText(String strValue, boolean bRecursion, Object activeData, IWebContext iWebContext) throws Exception {
		if (StringHelper.isNullOrEmpty(strValue)) return this.getEmptyText();

		if (StringHelper.compare(this.getOrMode(), ICodeList.ORMODE_STRING, true) == 0) {
			// 字符串
			String strValueSeparator = this.getValueSeparator();
			if (StringHelper.isNullOrEmpty(strValueSeparator)) {
				strValueSeparator = ";";
			}
			String strTextSeparator = this.getTextSeparator();
			if (StringHelper.isNullOrEmpty(strTextSeparator)) {
				strTextSeparator = "、";
			}
			String strTotalText = "";
			String[] values = StringHelper.split(strValue, strValueSeparator);
			for (String strItem : values) {
				ICodeItem iCodeItem = this.getCodeItemModel(strItem);
				if (iCodeItem == null) throw new Exception(StringHelper.format("无法获取值[%1$s]对应的文本信息", strItem));
				if (!StringHelper.isNullOrEmpty(strTotalText)) {
					strTotalText += strTextSeparator;
				}
				strTotalText += iCodeItem.getText();
			}
			return strTotalText;
		}

		if (StringHelper.compare(this.getOrMode(), ICodeList.ORMODE_NUMBER, true) == 0) {
			// 数值
			String strTextSeparator = this.getTextSeparator();
			if (StringHelper.isNullOrEmpty(strTextSeparator)) {
				strTextSeparator = "、";
			}
			int nValue = Integer.parseInt(strValue);
			if (nValue == 0) {
				return this.getEmptyText();
			}
			String strTotalText = "";
			java.util.Iterator<ICodeItem> iCodeItems = this.getCodeItems();
			if (iCodeItems != null) {
				while (iCodeItems.hasNext()) {
					ICodeItem iCodeItem = iCodeItems.next();
					int nValueItem = Integer.parseInt(iCodeItem.getValue());
					if ((nValue & nValueItem) == nValueItem) {
						if (!StringHelper.isNullOrEmpty(strTotalText)) {
							strTotalText += strTextSeparator;
						}
						strTotalText += iCodeItem.getText();
					}
				}
			}
			return strTotalText;
		}

		ICodeItem iCodeItem = this.getCodeItemModel(strValue);
		if (iCodeItem != null) return iCodeItem.getText();

		throw new Exception(StringHelper.format("无法获取值[%1$s]对应的文本信息", strValue));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ICodeListModel#refresh()
	 */
	@Override
	public void refresh() throws Exception {
		onRefresh();
	}

	/**
	 * 重新刷新代码表
	 * 
	 * @throws Exception
	 */
	protected void onRefresh() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.sysmodel.ICodeListModel#from(net.ibizsys.paas.sysmodel.ICodeListModel)
	 */
	@Override
	public void from(ICodeListModel iCodeListModel) throws Exception {

	}

	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.sysmodel.ICodeListModel#setCodeListHelper(net.ibizsys.paas.sysmodel.ICodeListHelper)
	// */
	// @Override
	// public void setCodeListHelper(ICodeListHelper iCodeListHelper) {
	// this.iCodeListHelper = iCodeListHelper;
	// }
	//
	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.sysmodel.ICodeListModel#getCodeListHelper()
	// */
	// @Override
	// public ICodeListHelper getCodeListHelper() {
	// return this.iCodeListHelper;
	// }

}
