package net.ibizsys.paas.data;

import net.ibizsys.paas.core.IDEField;

/**
 * 实体属性值差异项接口
 * 
 * @author Administrator
 *
 */
public interface IDEFieldDiffItem {
	/**
	 * 获取属性对象
	 * 
	 * @return
	 */
	IDEField getDEField();

	/**
	 * 获取新值
	 * 
	 * @return
	 */
	Object getNewValue();

	/**
	 * 获取旧值
	 * 
	 * @return
	 */
	Object getOldValue();

	/**
	 * 获取值变化差异信息
	 * 
	 * @return
	 */
	String getDiffInfo();

	/**
	 * 获取新值文本
	 * 
	 * @return
	 */
	String getNewText();

	/**
	 * 获取旧值文本
	 * 
	 * @return
	 */
	String getOldText();
}
