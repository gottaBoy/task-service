package net.ibizsys.paas.sysmodel;

import java.util.Locale;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.IModelBase3;

/**
 * 代码表项模型对象接口
 * @author Administrator
 *
 */
public interface ICodeItemModel extends ICodeItem,IModelBase3 {

	
	/**
	 * 获取文本
	 * @param locale
	 * @return
	 */
	String getText(Locale locale);
	
	

	/**
	 * 获取实际文本
	 * @param locale
	 * @return
	 */
	String getRealText(Locale locale);
}
