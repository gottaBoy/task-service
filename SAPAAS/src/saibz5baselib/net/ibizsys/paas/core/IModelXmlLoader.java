package net.ibizsys.paas.core;

import net.ibizsys.paas.util.IGlobalContext;
import net.ibizsys.paas.xml.XmlNode;

/**
 * 模型XML加载器接口
 * 
 * @author Administrator
 *
 */
public interface IModelXmlLoader {
	/**
	 * 初始化
	 * 
	 * @param iDAGlobalHelper
	 * @param xmlConfig
	 * @throws Exception
	 */
	void initFromXml(IGlobalContext iGlobalContext, Object objParent, XmlNode xmlConfig) throws Exception;
}
