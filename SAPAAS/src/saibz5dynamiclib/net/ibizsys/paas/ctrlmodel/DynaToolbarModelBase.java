package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarItemsModel;
import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarSeparatorModel;
import net.ibizsys.paas.ctrlmodel.toolbar.DynaToolbarUIActionItemModel;
import net.ibizsys.paas.ctrlmodel.toolbar.IDynaToolbarItemModel;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 动态工具栏模型接口实现基类
 * 
 * @author Administrator
 *
 */
public abstract class DynaToolbarModelBase extends DynaCtrlModelBase implements IDynaToolbarModel {

	private ArrayList<IDynaToolbarItemModel> dynaToolbarItemModelList = new ArrayList<IDynaToolbarItemModel>();

	@Override
	public String getControlType() {
		return ControlTypes.Toolbar;
	}

	protected void registerItemModel(IDynaToolbarItemModel iDynaToolbarItemModel) throws Exception {
		this.dynaToolbarItemModelList.add(iDynaToolbarItemModel);
	}

	@Override
	public Iterator<IDynaToolbarItemModel> getItemModels() {
		if (this.dynaToolbarItemModelList.size() == 0)
			return null;
		return this.dynaToolbarItemModelList.iterator();
	}

	@Override
	protected void onLoadJsonObject(ObjectNode jsonObject) throws Exception {
		this.dynaToolbarItemModelList.clear();

		super.onLoadJsonObject(jsonObject);

		// 加载项集合
		if (true) {
			ArrayNode arrayNode = JsonNodeHelper.getArray(jsonObject, ATTR_ITEMS);
			if (arrayNode != null) {
				int nSize = arrayNode.size();
				for (int i = 0; i < nSize; i++) {
					ObjectNode itemNode = (ObjectNode) arrayNode.get(i);
					this.dynaToolbarItemModelList.add(loadToolbarItemModel(itemNode));
				}
			}
		}
	}

	protected IDynaToolbarItemModel loadToolbarItemModel(ObjectNode tbItemModelNode) throws Exception {
		String strItemType = JsonNodeHelper.getString(tbItemModelNode, IDynaCtrlModel.ATTR_TYPE, null);
		if (StringHelper.isNullOrEmpty(strItemType)) {
			throw new Exception(StringHelper.format("没有指定工具栏类型"));
		}
		IDynaToolbarItemModel iDynaToolbarItemModel = createDynaToolbarItemModel(strItemType);
		iDynaToolbarItemModel.init(this, null, tbItemModelNode);
		return iDynaToolbarItemModel;
	}

	@Override
	public IDynaToolbarItemModel createDynaToolbarItemModel(String strType) throws Exception {
		if (StringHelper.compare(strType, IDynaToolbarItemModel.ITEMTYPE_UIACTION, true) == 0) {
			return new DynaToolbarUIActionItemModel();
		}
		if (StringHelper.compare(strType, IDynaToolbarItemModel.ITEMTYPE_SEPARATOR, true) == 0) {
			return new DynaToolbarSeparatorModel();
		}
		if (StringHelper.compare(strType, IDynaToolbarItemModel.ITEMTYPE_ITEMS, true) == 0) {
			return new DynaToolbarItemsModel();
		}
		throw new Exception(StringHelper.format("无法识别的工具栏项类型[%1$s]", strType));
	}

	@Override
	protected void onFillJsonObject(ObjectNode jo) throws Exception {
		super.onFillJsonObject(jo);
		// 导出成员
		if (this.dynaToolbarItemModelList.size() > 0) {
			ArrayList<ObjectNode> objectNodeList = new ArrayList<ObjectNode>();
			for (IDynaToolbarItemModel iDynaToolbarItemModel : this.dynaToolbarItemModelList) {
				ObjectNode objectNode = iDynaToolbarItemModel.toJsonObject(null);
				objectNodeList.add(objectNode);
			}
			JsonNodeHelper.put(jo, IDynaCtrlModel.ATTR_ITEMS, objectNodeList);
		}
	}
}
