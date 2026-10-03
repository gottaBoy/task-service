package net.ibizsys.paas.ctrlmodel.toolbar;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.ctrlmodel.IDynaCtrlModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态工具栏项集合模型对象基类
 * 
 * @author Administrator
 *
 */
public class DynaToolbarItemsModel extends DynaToolbarItemModelBase implements IDynaToolbarItemsModel {

	protected ArrayList<IDynaToolbarItemModel> toolbarItemModelList = new ArrayList<IDynaToolbarItemModel>();

	@Override
	public String getItemType() {
		return IDynaToolbarItemModel.ITEMTYPE_ITEMS;
	}

	@Override
	public Iterator<IDynaToolbarItemModel> getItemModels() {
		if (toolbarItemModelList.size() == 0)
			return null;
		return toolbarItemModelList.iterator();
	}

	/**
	 * 注册工具栏项模型
	 * 
	 * @param iDynaToolbarItemModel
	 * @throws Exception
	 */
	public void registerItemModel(IDynaToolbarItemModel iDynaToolbarItemModel) throws Exception {
		this.toolbarItemModelList.add(iDynaToolbarItemModel);
	}

	@Override
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		super.onLoadJsonObject(jsonObject);

		ArrayNode itemsNode = JsonNodeHelper.getArray(jsonObject, IDynaCtrlModel.ATTR_ITEMS);
		if (itemsNode != null) {
			int nSize = itemsNode.size();
			for (int i = 0; i < nSize; i++) {
				ObjectNode itemNode = (ObjectNode) itemsNode.get(i);
				this.toolbarItemModelList.add(loadToolbarItemModel(itemNode));
			}
		}
	}

	protected IDynaToolbarItemModel loadToolbarItemModel(ObjectNode tbItemModelNode) throws Exception {
		String strItemType = JsonNodeHelper.getString(tbItemModelNode, IDynaCtrlModel.ATTR_TYPE, null);
		if (StringHelper.isNullOrEmpty(strItemType)) {
			throw new Exception(StringHelper.format("没有指定工具栏类型"));
		}
		IDynaToolbarItemModel iDynaToolbarItemModel = this.getDynaToolbarModel().createDynaToolbarItemModel(strItemType);
		iDynaToolbarItemModel.init(this.getDynaToolbarModel(), this, tbItemModelNode);
		return iDynaToolbarItemModel;
	}

	@Override
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		super.onFillJsonObject(jo);
		// 导出成员
		if (this.toolbarItemModelList.size() > 0) {
			ArrayList<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
			for (IDynaToolbarItemModel iDynaToolbarItemModel : this.toolbarItemModelList) {
				ObjectNode objectNode = iDynaToolbarItemModel.toJsonObject(null);
				objectNodeList.add(objectNode);
			}
			JsonNodeHelper.put(jo, IDynaCtrlModel.ATTR_ITEMS, objectNodeList);
		}
	}
}
