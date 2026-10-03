package net.ibizsys.paas.view;

import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.JsonNodeHelper;

import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态界面行为模型对象基类
 * @author Administrator
 *
 */
public abstract class DynaUIActionModelBase extends UIActionModelBase implements IDynaUIActionModel{

	private ObjectNode modelJsonObject = null;
	private IDataEntityModel iDataEntityModel = null;
	
	
	@Override
	public void init(IDataEntityModel iDataEntityModel, Object modelObject) throws Exception {
		this.iDataEntityModel = iDataEntityModel;
		if(modelObject !=null ){
			if(modelObject instanceof ObjectNode){
				loadJsonObject((ObjectNode)modelObject);
			}
		}
	}



	

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	

	

	
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
		if(modelJsonObject!=null){
			ObjectNode objectNode = modelJsonObject.deepCopy();
			java.util.Iterator<String> names = objectNode.fieldNames();
			while(names.hasNext()){
				String strName = names.next();
				jo.put(strName,objectNode.get(strName));
			}
		}
	}
}
