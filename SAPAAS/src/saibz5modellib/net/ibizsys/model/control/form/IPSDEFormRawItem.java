package net.ibizsys.model.control.form;


/**
 * 实体表单直接内容对象接口
 * @author Administrator
 *
 */
public interface IPSDEFormRawItem extends IPSDEFormDetail
{
	/**
	 * 获取直接内容
	 * @return
	 */
	String getRawContent();
	
	
	/**
	 * 获取直接内容高度
	 * @return
	 */
	double getRawContentHeight();
	
	
	/**
	 * 获取直接内容宽度
	 * @return
	 */
	double getRawContentWidth();
}
