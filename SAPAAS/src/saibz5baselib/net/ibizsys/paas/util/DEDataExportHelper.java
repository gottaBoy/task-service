package net.ibizsys.paas.util;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.ibizsys.paas.control.grid.IGridColumn;
import net.ibizsys.paas.core.IDEDataExportItem;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.IDEDataExportModel;
import net.ibizsys.paas.web.IWebContext;

/**
 * 实体数据导出辅助类
 * 
 * @author Administrator
 *
 */
public class DEDataExportHelper {

	public DEDataExportHelper() {

	}

	/**
	 * 导出数据到指定Excel文件
	 * 
	 * @param strFile
	 * @param dt
	 * @param iGridModel
	 * @param iWebContext
	 * @param bEnableItemPrivilege
	 * @throws Exception
	 */
	public static void output(String strFile, IDataTable dt, IGridModel iGridModel, IWebContext iWebContext, boolean bEnableItemPrivilege) throws Exception {

		java.util.Iterator<IGridColumn> gridColumns = iGridModel.getGridColumns();

		WritableWorkbook workbook = Workbook.createWorkbook(new File(strFile));

		WritableSheet s1 = workbook.createSheet("数据", 0);

		int nRowIndex = 0;

		int nColumnIndex = 0;
		while (gridColumns.hasNext()) {
			IGridColumn iGridColumn = gridColumns.next();
			// DataGridColumnConfig dataGridColumnConfig = (DataGridColumnConfig) dataGridConfig.getDataGridColumnsConfig().getList().get(i);
			// if(this.isEnableItemPrivilege() && (!StringHelper.IsNullOrEmpty(dataGridColumnConfig.getPrivilegeId())))
			// {
			// if(this.webContext.GetUserPrivilegeMgr().TestColumn(webContext, dataGridColumnConfig.getPrivilegeId()) == PrivilegeAbility.NONE)
			// {
			// continue;
			// }
			// }
			Label l = new Label(nColumnIndex, nRowIndex, iGridColumn.getExcelCaption());
			s1.addCell(l);
			s1.setColumnView(nColumnIndex, 30);
			nColumnIndex++;
		}
		nRowIndex++;
		// 输出行数据

		if (dt.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = dt.next();
				if (iDataRow == null) break;
				nColumnIndex = 0;
				gridColumns = iGridModel.getGridColumns();
				while (gridColumns.hasNext()) {
					IGridColumn iGridColumn = gridColumns.next();

					String strCellValue = iGridModel.getColumnExcelText(iGridColumn, iWebContext, iDataRow, bEnableItemPrivilege);
					// 输出内容
					Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
					s1.addCell(l);
					nColumnIndex++;
				}
				nRowIndex++;
			}
		} else {
			int nRows = dt.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = dt.getCachedRow(i);
				nColumnIndex = 0;
				gridColumns = iGridModel.getGridColumns();
				while (gridColumns.hasNext()) {
					IGridColumn iGridColumn = gridColumns.next();
					String strCellValue = iGridModel.getColumnExcelText(iGridColumn, iWebContext, iDataRow, bEnableItemPrivilege);

					// 输出内容
					Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
					s1.addCell(l);
					nColumnIndex++;
				}
				nRowIndex++;
			}
		}

		workbook.write();
		workbook.close();
	}

	/**
	 * 导出数据到指定Excel文件
	 * 
	 * @param strFile
	 * @param dt
	 * @param iDEDataExportModel 数据导出模型
	 * @param iWebContext
	 * @param bEnableItemPrivilege
	 * @throws Exception
	 */
	public static void output(String strFile, IDataTable dt, IDEDataExportModel iDEDataExportModel, IWebContext iWebContext, boolean bEnableItemPrivilege) throws Exception {
		java.util.Iterator<IDEDataExportItem> deDataExportItems = iDEDataExportModel.getDEDataExportItems();

		WritableWorkbook workbook = Workbook.createWorkbook(new File(strFile));

		WritableSheet s1 = workbook.createSheet("数据", 0);

		int nRowIndex = 0;

		int nColumnIndex = 0;
		while (deDataExportItems.hasNext()) {
			IDEDataExportItem iDEDataExportItem = deDataExportItems.next();
			Label l = new Label(nColumnIndex, nRowIndex, iDEDataExportItem.getCaption());
			s1.addCell(l);
			s1.setColumnView(nColumnIndex, 30);
			nColumnIndex++;
		}
		nRowIndex++;
		// 输出行数据

		if (dt.getCachedRowCount() == -1) {
			while (true) {
				IDataRow iDataRow = dt.next();
				if (iDataRow == null) break;
				nColumnIndex = 0;
				deDataExportItems = iDEDataExportModel.getDEDataExportItems();
				while (deDataExportItems.hasNext()) {
					IDEDataExportItem iDEDataExportItem = deDataExportItems.next();
					String strCellValue = iDEDataExportModel.getItemText(iDEDataExportItem, iWebContext, iDataRow, bEnableItemPrivilege);
					// 输出内容
					Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
					s1.addCell(l);
					nColumnIndex++;
				}
				nRowIndex++;
			}
		} else {
			int nRows = dt.getCachedRowCount();
			for (int i = 0; i < nRows; i++) {
				IDataRow iDataRow = dt.getCachedRow(i);
				nColumnIndex = 0;
				deDataExportItems = iDEDataExportModel.getDEDataExportItems();
				while (deDataExportItems.hasNext()) {
					IDEDataExportItem iDEDataExportItem = deDataExportItems.next();
					String strCellValue = iDEDataExportModel.getItemText(iDEDataExportItem, iWebContext, iDataRow, bEnableItemPrivilege);
					// 输出内容
					Label l = new Label(nColumnIndex, nRowIndex, strCellValue);
					s1.addCell(l);
					nColumnIndex++;
				}
				nRowIndex++;
			}
		}

		workbook.write();
		workbook.close();
	}
}
