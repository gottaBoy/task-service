package net.ibizsys.paas.core;

import java.util.List;

/**
 * 系统插件列表
 * @author Administrator
 *
 */
public class PluginList {

	protected List<Plugin> list = null;

	/**
	 * 获取插件列表
	 * @return
	 */
	public List<Plugin> getList() {
		return list;
	}

	/**
	 * 设置插件列表
	 * @param list
	 */
	public void setList(List<Plugin> list) {
		this.list = list;
	}
	
	
}
