package net.ibizsys.paas.control.menu;

import java.util.ArrayList;

import net.sf.json.JSONObject;

/**
 * 菜单项填充器
 * @author Administrator
 *
 */
public interface IMenuItemFiller {
	
	/**
	 * 输出到JSON对象集合
	 * @param iMenuItem
	 * @return
	 * @throws Exception
	 */
	ArrayList<JSONObject> toJSONObjects(IMenuItem iMenuItem) throws Exception;
}
