package net.ibizsys.paas.util;

import java.util.ArrayList;

import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DEFieldDiffItem;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;

/**
 * 实体模型辅助对象
 * 
 * @author Administrator
 *
 */
public class DEModelUtil {

	/**
	 * 获取新旧数据对象差异项
	 * 
	 * @param iDEModel
	 * @param curData
	 * @param oldData
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<IDEFieldDiffItem> getDEDataDiffItems(IDataEntityModel iDEModel, IEntity curData, IEntity oldData) throws Exception {
		return getDEDataDiffItems(iDEModel, curData, oldData, false);
	}

	/**
	 * 获取新旧数据对象差异项
	 * 
	 * @param iDEModel
	 * @param curData
	 * @param oldData
	 * @param bOnlyEnableAudit
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<IDEFieldDiffItem> getDEDataDiffItems(IDataEntityModel iDEModel, IEntity curData, IEntity oldData, boolean bOnlyEnableAudit) throws Exception {
		// HashMap<String, IDEFieldDiffItem> deFieldDiffItemMap = new HashMap<String, IDEFieldDiffItem>();
		ArrayList<IDEFieldDiffItem> deFieldDiffItemList = new ArrayList<IDEFieldDiffItem>();
		java.util.Iterator<IDEField> deFields = iDEModel.getDEFields();
		while (deFields.hasNext()) {
			IDEField iDEField = deFields.next();
			if (!iDEField.isPhisicalDEField()) continue;

			if (bOnlyEnableAudit && !iDEField.isEnableAudit()) {
				continue;
			}

			if ((StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_CREATEDATE, true) == 0)
					|| (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_CREATEMAN, true) == 0)
					|| (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_CREATEMANNAME, true) == 0)
					|| (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_LOGICVALID, true) == 0)
					|| (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEDATE, true) == 0)
					|| (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEMAN, true) == 0)
					|| (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEMANNAME, true) == 0)) {
				continue;
			}

			if (StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUP, true) == 0) continue;

			// 对比两个值
			Object objNewValue = curData.get(iDEField.getName());
			Object objOldValue = oldData.get(iDEField.getName());

			if (objNewValue == null && objOldValue == null) continue;

			if (objNewValue != null && objOldValue != null) {
				if (DataTypeHelper.compare(iDEField.getStdDataType(), objNewValue, objOldValue) == 0) continue;
			}

			String strNewValueText = "";
			String strOldValueText = "";

			ICodeListModel codeListConfig = null;
			String strCodeListId = iDEField.getCodeListId();
			if (!StringHelper.isNullOrEmpty(strCodeListId)) {
				codeListConfig = (ICodeListModel) CodeListGlobal.getCodeList(strCodeListId);
				if (objNewValue != null) {
					if (codeListConfig != null) {
						strNewValueText = codeListConfig.getCodeListText(objNewValue.toString(), true);
					}
				}

				if (objOldValue != null) {
					if (codeListConfig != null) {
						strOldValueText = codeListConfig.getCodeListText(objOldValue.toString(), true);
					}
				}
			} else {
				String strItemFormat = iDEField.getValueFormat();
				if (StringHelper.isNullOrEmpty(strItemFormat)) strItemFormat = "%1$s";
				if (objNewValue != null) strNewValueText = StringHelper.format(strItemFormat, objNewValue);
				if (objOldValue != null) strOldValueText = StringHelper.format(strItemFormat, objOldValue);
			}

			DEFieldDiffItem deFieldDiffItem = new DEFieldDiffItem();
			deFieldDiffItem.setDEField(iDEField);
			deFieldDiffItem.setNewText(strNewValueText);
			deFieldDiffItem.setOldText(strOldValueText);
			deFieldDiffItem.setNewValue(objNewValue);
			deFieldDiffItem.setOldValue(objOldValue);
			deFieldDiffItemList.add(deFieldDiffItem);

		}
		return deFieldDiffItemList;
	}
}
