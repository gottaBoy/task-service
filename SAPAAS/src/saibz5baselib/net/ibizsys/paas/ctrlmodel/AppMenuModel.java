package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;

import net.ibizsys.paas.control.menu.AppMenuItem;
import net.ibizsys.paas.control.menu.IAppMenuItem;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 默认应用菜单模型
 * 
 * @author Administrator
 *
 */
public class AppMenuModel extends AppMenuModelBase {

	public JSONArray toJSONArray() throws Exception {
		ArrayList<JSONObject> items = new ArrayList<JSONObject>();

		for (IAppMenuItem iAppMenuItem : getRootItem().getItems()) {
			if (iAppMenuItem.getFiller() != null) {
				ArrayList<JSONObject> list = iAppMenuItem.getFiller().toJSONObjects(iAppMenuItem);
				if (list != null) {
					items.addAll(list);
				}
			} else {
				JSONObject jo = AppMenuItem.toJSONObject(iAppMenuItem, null);
				if (jo == null) continue;
				items.add(jo);
			}
		}

		return JSONArray.fromArray(items.toArray());
	}
}
