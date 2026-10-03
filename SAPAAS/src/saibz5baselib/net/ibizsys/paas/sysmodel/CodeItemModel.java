package net.ibizsys.paas.sysmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 代码项模型
 * 
 * @author lionlau
 *
 */
public class CodeItemModel extends ModelBase3Impl implements ICodeItemModel {
	protected ArrayList<ICodeItem> childCodeItemList = new ArrayList<ICodeItem>();
	protected ICodeList iCodeList;
	protected ICodeItem parentCodeItem;
	private String strText = "";
	private String strValue;
	private String strRealText = "";
	private String strParentValue = "";
	private String strColor = "";
	private String strIconPath = "";
	private String strIconCls = "";
	private String strTextCls = "";
	private String strIconPathX = "";
	private String strIconClsX = "";
	private String strMemo = "";
	private String strUserData = "";
	private String strUserData2 = "";
	private boolean bDisableSelect = false;
	private String strTextLanResTag = "";
	

	/**
	 * 初始化
	 * 
	 * @param iCodeList
	 * @param parentCodeItem
	 * @param codeItem
	 */
	public void init(ICodeList iCodeList, ICodeItem parentCodeItem, CodeItem codeItem) {
		this.iCodeList = iCodeList;
		this.parentCodeItem = parentCodeItem;
		// this.codeItem = codeItem;
		if (codeItem != null) {
			this.setRealText(codeItem.realtext());
			this.setText(codeItem.text());
			this.setValue(codeItem.value());
			this.setParentValue(codeItem.parentvalue());
			this.setTextLanResTag(codeItem.textlanrestag());
			this.setTextCls(codeItem.textcls());
			this.setIconCls(codeItem.iconcls());
			this.setIconClsX(codeItem.iconclsx());
			this.setIconPath(codeItem.iconpath());
			this.setIconPathX(codeItem.iconpathx());
			this.setUserData(codeItem.userdata());
			this.setUserData2(codeItem.userdata2());
			this.setDisableSelect(codeItem.disableselect());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getCodeList()
	 */
	@Override
	public ICodeList getCodeList() {
		return this.iCodeList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getParentCodeItem()
	 */
	@Override
	public ICodeItem getParentCodeItem() {
		return this.parentCodeItem;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getCodeItems()
	 */
	@Override
	public Iterator<ICodeItem> getCodeItems() throws Exception {
		return childCodeItemList.iterator();
	}

	/**
	 * 注册子代码项模型
	 * 
	 * @param codeItemModel
	 */
	public void registerChildCodeItemModel(CodeItemModel codeItemModel) {
		this.childCodeItemList.add(codeItemModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getText()
	 */
	@Override
	public String getText() {
		return strText;
	}

	/**
	 * 设置代码项文本
	 * 
	 * @param strText the strText to set
	 */
	public void setText(String strText) {
		this.strText = strText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getValue()
	 */
	@Override
	public String getValue() {
		return strValue;
	}

	/**
	 * 设置代码项值
	 * 
	 * @param strValue the strValue to set
	 */
	public void setValue(String strValue) {
		this.strValue = strValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getRealText()
	 */
	public String getRealText() {
		if (StringHelper.isNullOrEmpty(strRealText)) return this.getText();
		return strRealText;
	}

	/**
	 * 设置代码项实际文本
	 * 
	 * @param strRealText the strRealText to set
	 */
	public void setRealText(String strRealText) {
		this.strRealText = strRealText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getParentValue()
	 */
	@Override
	public String getParentValue() {
		return strParentValue;
	}

	/**
	 * 设置代码项父值
	 * 
	 * @param strParentValue the strParentValue to set
	 */
	public void setParentValue(String strParentValue) {
		this.strParentValue = strParentValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getColor()
	 */
	@Override
	public String getColor() {
		return strColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getIconPath()
	 */
	@Override
	public String getIconPath() {
		return this.strIconPath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getIconPathX()
	 */
	@Override
	public String getIconPathX() {
		return this.strIconPathX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getMemo()
	 */
	@Override
	public String getMemo() {
		return this.strMemo;
	}

	/**
	 * 设置代码项颜色
	 * 
	 * @param strColor the strColor to set
	 */
	public void setColor(String strColor) {
		this.strColor = strColor;
	}

	/**
	 * 设置代码项图标路径
	 * 
	 * @param strIconPath the strIconPath to set
	 */
	public void setIconPath(String strIconPath) {
		this.strIconPath = strIconPath;
	}

	/**
	 * 设置代码项图标路径显示倍数格式化串
	 * 
	 * @param strIconPathX the strIconPathX to set
	 */
	public void setIconPathX(String strIconPathX) {
		this.strIconPathX = strIconPathX;
	}

	/**
	 * 设置代码项备注
	 * 
	 * @param strMemo the strMemo to set
	 */
	public void setMemo(String strMemo) {
		this.strMemo = strMemo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getIconCls()
	 */
	@Override
	public String getIconCls() {
		return strIconCls;
	}

	/**
	 * 设置代码项图标样式
	 * 
	 * @param strIconCls the strIconCls to set
	 */
	public void setIconCls(String strIconCls) {
		this.strIconCls = strIconCls;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getIconClsX()
	 */
	@Override
	public String getIconClsX() {
		return strIconClsX;
	}

	/**
	 * 设置代码项图标样式
	 * 
	 * @param strIconClsX the strIconClsX to set
	 */
	public void setIconClsX(String strIconClsX) {
		this.strIconClsX = strIconClsX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getTextCls()
	 */
	@Override
	public String getTextCls() {
		return strTextCls;
	}

	/**
	 * 设置代码项文本样式
	 * 
	 * @param strTextCls the strTextCls to set
	 */
	public void setTextCls(String strTextCls) {
		this.strTextCls = strTextCls;
	}

	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.codelist.ICodeItem#getCodeItemByText(java.lang.String)
	 */
	@Override
	public ICodeItem getCodeItemByText(String strText) throws Exception {
		return getCodeItemByText(strText,true);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.codelist.ICodeItem#getCodeItem(java.lang.String)
	 */
	@Override
	public ICodeItem getCodeItem(String strValue) throws Exception {
		return getCodeItem(strValue,true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getCodeItemByText(java.lang.String, boolean)
	 */
	@Override
	public ICodeItem getCodeItemByText(String strText, boolean bRecursion) throws Exception {
		for (ICodeItem iCodeItem : childCodeItemList) {
			if (StringHelper.compare(iCodeItem.getText(), strText, false) == 0) return iCodeItem;
		}
		if (bRecursion) {
			for (ICodeItem iCodeItem : childCodeItemList) {
				ICodeItem childItem = iCodeItem.getCodeItemByText(strText, bRecursion);
				if (childItem != null) return childItem;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getCodeItem(java.lang.String, boolean)
	 */
	@Override
	public ICodeItem getCodeItem(String strValue, boolean bRecursion) throws Exception {
		for (ICodeItem iCodeItem : childCodeItemList) {
			if (StringHelper.compare(iCodeItem.getValue(), strValue, false) == 0) return iCodeItem;
		}
		if (bRecursion) {
			for (ICodeItem iCodeItem : childCodeItemList) {
				ICodeItem childItem = iCodeItem.getCodeItem(strValue, bRecursion);
				if (childItem != null) return childItem;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getUserData()
	 */
	@Override
	public String getUserData() {
		return this.strUserData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getUserData2()
	 */
	@Override
	public String getUserData2() {
		return this.strUserData2;
	}

	/**
	 * 设置用户数据
	 * 
	 * @param strUserData
	 */
	public void setUserData(String strUserData) {
		this.strUserData = strUserData;
	}

	/**
	 * 设置用户数据2
	 * 
	 * @param strUserData2
	 */
	public void setUserData2(String strUserData2) {
		this.strUserData2 = strUserData2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getIconPath(int)
	 */
	@Override
	public String getIconPath(int nX) {
		if (nX == 1) {
			return this.getIconPath();
		}

		if (StringHelper.isNullOrEmpty(this.getIconPathX())) {
			return this.getIconPath();
		}

		return this.getIconPathX().replace("{0}", StringHelper.format("%1$s", nX));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#getIconCls(int)
	 */
	@Override
	public String getIconCls(int nX) {
		if (nX == 1) {
			return this.getIconCls();
		}

		if (StringHelper.isNullOrEmpty(this.getIconClsX())) {
			return this.getIconCls();
		}

		return this.getIconClsX().replace("{0}", StringHelper.format("%1$s", nX));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.codelist.ICodeItem#isDisableSelect()
	 */
	@Override
	public boolean isDisableSelect() {
		return this.bDisableSelect;
	}

	/**
	 * 设置是否禁止选中
	 * 
	 * @param bDisableSelect
	 */
	public void setDisableSelect(boolean bDisableSelect) {
		this.bDisableSelect = bDisableSelect;
	}

	@Override
	public String getTextLanResTag() {
		return this.strTextLanResTag;
	}
	
	/**
	 * 设置文本语言资源标识
	 * @param strTextLanResTag
	 */
	public void setTextLanResTag(String strTextLanResTag) {
		this.strTextLanResTag = strTextLanResTag;
	}

	@Override
	public String getText(Locale locale) {
		if(!StringHelper.isNullOrEmpty(getTextLanResTag())&&WebContext.getCurrent()!=null)
		{
			return WebContext.getCurrent().getLocalization(getTextLanResTag(), getText(),locale);
		}
		return getText();			
	}

	
	@Override
	public String getRealText(Locale locale) {
		return getRealText();
	}

	
	
}
