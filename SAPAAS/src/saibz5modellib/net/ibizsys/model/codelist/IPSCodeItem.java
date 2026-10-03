package net.ibizsys.model.codelist;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.codelist.ICodeItem;

/**
 * 代码表项对象接口
 * @author lionlau
 *
 */
public interface IPSCodeItem extends IPSModelObject,ICodeItem,IPSModelJsonExporter
{
	/**
	 * 获取子代码项对象集合
	 * @return
	 */
	java.util.Iterator<IPSCodeItem> getPSCodeItems() throws Exception;
	
	

	/**
	 * 获取代码项样式对象
	 * @return
	 */
	IPSSysCss getPSSysCss();
	

	
	/**
	 * 获取代码项图片资源
	 * @return
	 */
	IPSSysImage getPSSysImage();
	
	
	
	/**
	 * 获取文本语言资源对象
	 * @return
	 */
	IPSLanguageRes getTextPSLanguageRes();
	
	
	/**
	 * 是否使用空白内容显示
	 * @return
	 */
	boolean isShowAsEmtpy();
}
