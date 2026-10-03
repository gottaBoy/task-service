package net.ibizsys.model.res;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.core.IPSModelObject;


/**
 * 系统图片资源对象接口
 * 
 * @author lionlau
 *
 */
public interface IPSSysImage extends IPSSystemObject,IPSModelObject {
	

	/**
	 * 获取平台图片资源模版标识
	 * 
	 * @return
	 */
	String getPSImageTemplId();

	/**
	 * 获取图标路径
	 * 
	 * @return
	 */
	String getImagePath();

	/**
	 * 获取图标式样
	 * 
	 * @return
	 */
	String getCssClass();

	/**
	 * 获取图标路径显示倍数格式字符串
	 * 
	 * @return
	 */
	String getImagePathX();

	/**
	 * 获取图标式样显示倍数格式字符串
	 * 
	 * @return
	 */
	String getCssClassX();

	/**
	 * 获取字符式样
	 * 
	 * @return
	 */
	String getGlyph();

	/**
	 * 获取指定显示倍数的图标路径
	 * 
	 * @param nX
	 *            显示倍数
	 * @return
	 */
	String getImagePath(int nX);

	/**
	 * 获取指定显示倍数的图标式样
	 * 
	 * @param nX
	 *            显示倍数
	 * @return
	 */
	String getCssClass(int nX);
	
	
	/**
	 * 图片宽度
	 * @return
	 */
	int getWidth();

	/**
	 * 图片高度
	 * @return
	 */
	int getHeight();
}
