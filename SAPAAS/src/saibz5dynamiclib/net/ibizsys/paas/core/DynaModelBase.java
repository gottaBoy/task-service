package net.ibizsys.paas.core;

import net.ibizsys.paas.util.JsonNodeHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态模型基类
 * @author Administrator
 *
 */
public abstract class DynaModelBase extends ModelBase3Impl implements IDynaModel {

	private ObjectNode modelJsonObject = null;
	
	/**
	 * 加载Json模型
	 * @param jsonObject
	 * @throws Exception
	 */
	public void loadJsonObject(ObjectNode jsonObject) throws Exception {
		this.modelJsonObject = jsonObject;
		onLoadJsonObject(jsonObject);
	}
	
	
	
	/**
	 * 加载Json对象模型
	 * @param jsonObject
	 * @throws Exception
	 */
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		
	}

	
	/**
	 * 获取最后导入的模型对象（json）
	 * @return
	 */
	protected ObjectNode getModelJsonObject(){
		return this.modelJsonObject;
	}
	
	
	/**
	 * 导出到Json对象
	 * @param jo
	 * @return
	 * @throws Exception
	 */
	public ObjectNode toJsonObject(ObjectNode jo) throws Exception {
		if(jo==null)
		{
			jo = JsonNodeHelper.createObjectNode();
		}
		onFillJsonObject(jo);
		return jo;
	}
	

	/**
	 * 填充JSON对象
	 * @param jo
	 * @throws Exception
	 */
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		
	}

}
