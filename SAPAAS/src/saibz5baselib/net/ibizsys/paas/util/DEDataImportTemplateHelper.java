package net.ibizsys.paas.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.demodel.IDataEntityModel;

/**
 * 实体数据导入模板辅助类
 * 
 * @author Administrator
 *
 */
public class DEDataImportTemplateHelper {
	/**
	 * 输出导入数据模板格式到指定文件
	 * 
	 * @param iDEModel
	 * @param strFile
	 * @throws Exception
	 */
	public static void output(IDataEntityModel iDEModel, String strFile) throws Exception {
		
		WritableWorkbook workbook = Workbook.createWorkbook(new File(strFile));

		WritableSheet s1 = workbook.createSheet(StringHelper.format("[%1$s]导入格式", iDEModel.getLogicName()), 0);
		WritableSheet s2 = workbook.createSheet("属性说明", 1);


		ArrayList<IDEField> list = new ArrayList<IDEField>();
		if (true) {
			int nRowIndex = 0;
			int nCellIndex = 0;

			// 排序
			java.util.Iterator<IDEField> deFields = iDEModel.getDEFields();
			while (deFields.hasNext()) {
				IDEField iDEField = deFields.next();
				if (iDEField.getImportOrder() == -1) continue;
				list.add(iDEField);
			}

			Collections.sort(list, new java.util.Comparator<IDEField>() {

				@Override
				public int compare(IDEField o1, IDEField o2) {
					return o1.getImportOrder() - o2.getImportOrder();
				}
			});

			for (IDEField iDEField : list) {
				Label l = new Label(nCellIndex, nRowIndex, StringHelper.format("%1$s", iDEField.getImportTag()));
				s1.addCell(l);
				s1.setColumnView(nCellIndex, 20);
				nCellIndex++;
			}
		}

		if (true) {
			int nRowIndex = 0;
			if (true) {
				Label l = new Label(0, nRowIndex, "导入名称");
				s2.addCell(l);
				s2.setColumnView(0, 20);

				Label l2 = new Label(1, nRowIndex, "数据类型");
				s2.addCell(l2);
				s2.setColumnView(2, 40);

				Label l3 = new Label(2, nRowIndex, "说明");
				s2.addCell(l3);
				s2.setColumnView(3, 40);
			}

			nRowIndex = 1;
			for (IDEField iDEField : list) {

				Label l = new Label(0, nRowIndex, iDEField.getImportTag());
				s2.addCell(l);

				String strDataType = DataTypeHelper.getTypeName(iDEField.getStdDataType());
				Label l2 = new Label(1, nRowIndex, strDataType);
				s2.addCell(l2);

				String strDescription = iDEField.getMemo();
				if (StringHelper.isNullOrEmpty(strDescription)) {
					strDescription = iDEField.getLogicName();
				}
				Label l3 = new Label(2, nRowIndex, strDescription);
				s2.addCell(l3);

				nRowIndex++;
			}
		}

		workbook.write();
		workbook.close();

	}
}
