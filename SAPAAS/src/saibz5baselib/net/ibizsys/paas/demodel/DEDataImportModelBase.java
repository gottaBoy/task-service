package net.ibizsys.paas.demodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataImportResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDataImportItem;
import net.ibizsys.paas.core.IDEDataImportResult;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDERInherit;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.ExcelCellFuncHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * 实体数据导入模型对象基类
 * 
 * @author lionlau
 *
 */
public abstract class DEDataImportModelBase extends ModelBase3Impl implements IDEDataImportModel {
	
	private static final Log log = LogFactory.getLog(DEDataImportModelBase.class);

	private IDataEntity iDataEntity = null;
	protected ArrayList<IDEDataImportItem> deDataImportItemList = new ArrayList<IDEDataImportItem>();
	protected ArrayList<IDEDataImportItem> deDataImportKeyItemList = new ArrayList<IDEDataImportItem>();
	private boolean bIgnoreError = false;
	private String strCreateDEActionName = null;
	private String strUpdateDEActionName = null;
	private String strUpdateDataAccessAction = DataAccessActions.UPDATE;
	private String strCreateDataAccessAction = DataAccessActions.CREATE;
	
	private boolean bDefault = false;
	
	private final static String ROWNUM = "_SRFROWNUM_";

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEACMode#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return the iDataEntity
	 */
	public IDataEntity getDataEntity() {
		return iDataEntity;
	}

	/**
	 * 设置实体模型对象
	 * 
	 * @param iDataEntity the iDataEntity to set
	 */
	protected void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.impl.ControlImpl#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		prepareDEDataImportItemModels();

	}

	/**
	 * 准备导入项模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDataImportItemModels() throws Exception {

	}

	/**
	 * 建立导入项
	 * 
	 * @param strName
	 * @return
	 */
	protected IDEDataImportItem createDEDataImportItem(String strName) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataImport#getDEDataImportItems()
	 */
	@Override
	public Iterator<IDEDataImportItem> getDEDataImportItems() {
		return deDataImportItemList.iterator();
	}

	/**
	 * 注册导入项对象
	 * 
	 * @param iDEDataImportItem
	 */
	protected void registerDEDataImportItem(IDEDataImportItem iDEDataImportItem) {
		this.deDataImportItemList.add(iDEDataImportItem);
		if (iDEDataImportItem.isUniqueItem()) {
			this.deDataImportKeyItemList.add(iDEDataImportItem);
		}
	}

	@Override
	public boolean isIgnoreError() {
		return this.bIgnoreError;
	}

	@Override
	public String getCreateDEActionName() {
		return this.strCreateDEActionName;
	}

	@Override
	public String getUpdateDEActionName() {
		return this.strUpdateDEActionName;
	}

	/**
	 * 设置是否忽略导入错误
	 * 
	 * @param bIgnoreError
	 */
	public void setIgnoreError(boolean bIgnoreError) {
		this.bIgnoreError = bIgnoreError;
	}

	/**
	 * 设置建立数据的实体行为名称
	 * 
	 * @param strCreateDEActionName
	 */
	public void setCreateDEActionName(String strCreateDEActionName) {
		this.strCreateDEActionName = strCreateDEActionName;
	}

	/**
	 * 设置更新数据的实体行为名称
	 * 
	 * @param strUpdateDEActionName
	 */
	public void setUpdateDEActionName(String strUpdateDEActionName) {
		this.strUpdateDEActionName = strUpdateDEActionName;
	}
	
	
	

	@Override
	public String getCreateDataAccessAction() {
		return this.strCreateDataAccessAction;
	}

	@Override
	public String getUpdateDataAccessAction() {
		return this.strUpdateDataAccessAction;
	}

	@Override
	public boolean isDefault() {
		return this.bDefault;
	}

	/**
	 * 设置是否为默认的数据导入处理
	 * 
	 * @param bDefault
	 */
	public void setDefault(boolean bDefault) {
		this.bDefault = bDefault;
	}

	@Override
	public IDataEntityModel getDEModel() {
		return (IDataEntityModel) this.getDataEntity();
	}

	@Override
	public boolean importFile(File importFile, String strFileType, ArrayList<IDEDataImportResult> importResultList) throws Exception {
		return importFile(importFile, strFileType, null, importResultList);
	}

	@Override
	public boolean importFile(File importFile, String strFileType, SessionFactory sessionFactory, ArrayList<IDEDataImportResult> importResultList) throws Exception {

		Map<Integer, IDEFieldModel> deFieldMap = new TreeMap<Integer, IDEFieldModel>();
		Map<String, ICodeListModel> codeListMap = new TreeMap<String, ICodeListModel>();
		Map<String, IService> serviceMap = new TreeMap<String, IService>();
		Map<String, String> pickupFieldMap = new TreeMap<String, String>();
		Map<String, IDEFieldModel> deFieldImpMap = new TreeMap<String, IDEFieldModel>();
		String strKeyFieldName = this.getDEModel().getKeyDEField().getName();
		IService majorService = this.getDEModel().getService(sessionFactory);
		
		IWebContext iWebContext = WebContext.getCurrent();

		java.util.Iterator<IDEDataImportItem> deDataImportItems = this.getDEDataImportItems();
		while (deDataImportItems.hasNext()) {
			IDEDataImportItem iDEDataImportItem = deDataImportItems.next();
			String strImportTag = null;
			if (StringHelper.isNullOrEmpty(iDEDataImportItem.getCapLanResTag())) {
				strImportTag = iDEDataImportItem.getCaption();
			} else {
				strImportTag = iWebContext.getLocalization(iDEDataImportItem.getCapLanResTag(), iDEDataImportItem.getCaption());
			}
			strImportTag = strImportTag.toUpperCase();
			if (deFieldImpMap.containsKey(strImportTag)) {
				throw new Exception(StringHelper.format("出现重复的导入标识[%1$s]", strImportTag));
			}

			deFieldImpMap.put(strImportTag, (IDEFieldModel) iDEDataImportItem.getDEField());
		}

		onAfterFillDEFieldImpMap(deFieldImpMap);

		if (StringHelper.compare(strFileType, IDEDataImportModel.FILETYPE_EXCEL, false) == 0) {
			Workbook workbook = null;


			InputStream in = new FileInputStream(importFile);
			FormulaEvaluator eva = null;
			// 加载Excel文件
			if (importFile.getName().endsWith(".xls")) {
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(in);
				eva = new HSSFFormulaEvaluator(hssfWorkbook);
				workbook = hssfWorkbook;
			} else if (importFile.getName().endsWith(".xlsx")) {
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
				eva = new XSSFFormulaEvaluator(xssfWorkbook);
				workbook = xssfWorkbook;
			}

			if (workbook.getNumberOfSheets() < 1) {
				return true;
			}

			Sheet dataSheet = workbook.getSheetAt(0);

			int nCelLIndex = 0;
			int nRowIndex = 0;

			if (true) {
				Row row = dataSheet.getRow(nRowIndex);
				int nFirst = row.getFirstCellNum();
				int nLast = row.getLastCellNum();

				for (int i = nFirst; i < nLast; i++) {
					String strContent = getCellValue(row.getCell(i), eva);
					if (StringHelper.isNullOrEmpty(strContent)) {
						throw new Exception(StringHelper.format("单元格[%1$s]无效，必须输入内容", ExcelCellFuncHelper.getCellSN(i, nRowIndex)));
					}

					strContent = strContent.trim();
					String strColumnName = strContent.toUpperCase();

					IDEFieldModel iDEField = deFieldImpMap.get(strColumnName);
					if (iDEField == null) {
						throw new Exception(StringHelper.format("无法获取属性[%1$s]辅助对象", strColumnName));
					}

					String strCodeListId = iDEField.getCodeListId();
					if (!StringHelper.isNullOrEmpty(strCodeListId)) {
						if (!codeListMap.containsKey(strCodeListId)) {
							ICodeListModel codeListConfig = (ICodeListModel) CodeListGlobal.getCodeList(strCodeListId, sessionFactory);
							if (codeListConfig == null) {
								throw new Exception(StringHelper.format("无法获取代码表[%1$s]配置", strCodeListId));
							}
							codeListMap.put(strCodeListId, codeListConfig);
						}

					}

					if (iDEField.isLinkDEField()) {
						IDERBase iDERBase = this.getDEModel().getSystem().getDER(iDEField.getDERName());
						if (iDERBase instanceof IDER1N) {
							if (!serviceMap.containsKey(iDEField.getDERName())) {
								String strDEId = iDERBase.getMajorDEId();
								IService iService = DEModelGlobal.getDEModel(strDEId).getService(sessionFactory);
								if (iService == null) {
									throw new Exception(StringHelper.format("无法获取实体[%1$s]数据服务对象", strDEId));
								}
								serviceMap.put(iDEField.getDERName(), iService);
							}
						} else if (iDERBase instanceof IDERInherit) {

							IDEField linkDEField = iDEField.getLinkDEField();
							if (linkDEField.isLinkDEField()) {
								iDERBase = this.getDEModel().getSystem().getDER(linkDEField.getDERName());
								if (iDERBase instanceof IDER1N) {

									if (!serviceMap.containsKey(linkDEField.getDERName())) {
										String strDEId = iDERBase.getMajorDEId();
										IService iService = DEModelGlobal.getDEModel(strDEId).getService(sessionFactory);
										if (iService == null) {
											throw new Exception(StringHelper.format("无法获取实体[%1$s]数据服务对象", strDEId));
										}
										serviceMap.put(linkDEField.getDERName(), iService);
									}
								}
							}
						}
					}

					deFieldMap.put(i, iDEField);
				}

				// if (this.isIgnoreError())
				// {
				// //addErrorSheetRow(errSheet, row);
				// }
			}

			ArrayList<IEntity> dataEntities = new ArrayList<IEntity>();
			int nLastRow = dataSheet.getLastRowNum();
			for (int i = 1; i <= nLastRow; i++) {
				boolean bErrorFlag = false;
				IEntity dataEntity = this.getDEModel().createEntity();

				Row row = dataSheet.getRow(i);
				int nFirst = row.getFirstCellNum();
				int nLast = row.getLastCellNum();

				HashMap<String, IEntity> majorEntityMap = new HashMap<String, IEntity>();

				for (int j = nFirst; j <= nLast; j++) {
					String strContent = getCellValue(row.getCell(j), eva);

					bErrorFlag = false;
					if (StringHelper.isNullOrEmpty(strContent)) continue;

					strContent = strContent.trim();
					if (StringHelper.isNullOrEmpty(strContent)) continue;

					// 判断属性类型
					IDEFieldModel iDEField = deFieldMap.get(j);

					// 代码表处理
					String strCodeListId = iDEField.getCodeListId();
					if (!StringHelper.isNullOrEmpty(strCodeListId)) {
						ICodeListModel codeListConfig = codeListMap.get(strCodeListId);

						// 进一步判断代码项的类型
						String strDataType = iDEField.getDataType();
						if ((StringHelper.compare(strDataType, IDEField.DATATYPE_NMCODELIST, false) == 0) || (StringHelper.compare(strDataType, IDEField.DATATYPE_SMCODELIST, false) == 0)) {
							boolean bNumberMode = (StringHelper.compare(strDataType, IDEField.DATATYPE_NMCODELIST, false) == 0);
							int nRealValue = 0;
							String strRealValue = "";
							// 数值多选，判断有没有分割符号
							String strNewContent = strContent;
							strNewContent = strNewContent.replace("|", ";");
							strNewContent = strNewContent.replace(",", ";");
							strNewContent = strNewContent.replace("，", ";");
							strNewContent = strNewContent.replace("、", ";");

							String[] items = strNewContent.split("[;]");
							boolean bValueMode = false;
							for (int l = 0; l < items.length; l++) {
								String strText = items[l];
								ICodeItem iCodeItem = codeListConfig.getCodeItemByText(strText, true);
								if (iCodeItem == null) {
									// 没有办法找到对应的文本
									bValueMode = true;
									break;
								} else {
									if (bNumberMode) {
										nRealValue |= Integer.parseInt(iCodeItem.getValue());
									} else {
										if (!StringHelper.isNullOrEmpty(strRealValue)) strRealValue += codeListConfig.getValueSeparator();
										strRealValue += iCodeItem.getValue();
									}
								}
							}

							if (bValueMode) {
								if (bNumberMode) {
									nRealValue = Integer.parseInt(strContent);
									dataEntity.set(iDEField.getName(), nRealValue);
								} else {
									strRealValue = strNewContent.replace(";", codeListConfig.getValueSeparator());
									dataEntity.set(iDEField.getName(), strRealValue);
								}
							} else {
								if (bNumberMode) {
									dataEntity.set(iDEField.getName(), nRealValue);
								} else {
									dataEntity.set(iDEField.getName(), strRealValue);
								}
							}

						} else {
							ICodeItem iCodeItem = codeListConfig.getCodeItemByText(strContent, true);
							if (iCodeItem == null) {
								iCodeItem = codeListConfig.getCodeItem(strContent, true);
								if (iCodeItem == null) {
									// 判断是否为空值
									if (StringHelper.compare(codeListConfig.getEmptyText(), strContent, true) != 0) {
										DEDataImportResult deDataImportResult = new DEDataImportResult();
										deDataImportResult.setRetCode(Errors.INPUTERROR);
										deDataImportResult.setRetInfo(StringHelper.format("单元格[%1$s]无效， 代码表[%2$s]无法识别[%3$s]", ExcelCellFuncHelper.getCellSN(j, i), strCodeListId));
										importResultList.add(deDataImportResult);

										if (this.isIgnoreError()) {
											bErrorFlag = true;
											break;
										} else
											return false;
									}
								}
							}
							dataEntity.set(iDEField.getName(), DataTypeHelper.parse(iDEField.getStdDataType(), iCodeItem.getValue()));
						}
						continue;
					}

					// 外键处理
					if (iDEField.isLinkDEField()) {
						if ((StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUPTEXT, true) == 0) || ((StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_INHERIT, true) == 0) && (StringHelper.compare(iDEField.getLinkDEField().getDataType(), IDEField.DATATYPE_PICKUPTEXT, true) == 0))) {

							// 需要判断
							String strDERName = "";
							IDEFieldModel iPickupDEFHelper = null;
							if (StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUPTEXT, true) == 0) {
								iPickupDEFHelper = (IDEFieldModel) iDEField.getDEModel().getPickupDEField(iDEField.getDERName());
								strDERName = iDEField.getDERName();
							} else {
								IDEFieldModel iLinkDEFHelper2 = (IDEFieldModel) iDEField.getLinkDEField();
								// 继承
								iPickupDEFHelper = (IDEFieldModel) iDEField.getLinkDEField().getDEModel().getPickupDEField(iLinkDEFHelper2.getDERName());
								strDERName = iDEField.getLinkDEField().getDERName();
							}

							if (iPickupDEFHelper == null) {
								DEDataImportResult deDataImportResult = new DEDataImportResult();
								deDataImportResult.setRetCode(Errors.INPUTERROR);
								deDataImportResult.setRetInfo(StringHelper.format("单元格[%1$s]无效，无法获取指定属性[%2$s]相关信息", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getRealDEField().getDEModel().getLogicName()));
								deDataImportResult.setRowSN(row.getRowNum());
								importResultList.add(deDataImportResult);
								if (this.isIgnoreError()) {
									bErrorFlag = true;
									break;
								} else
									return false;
							}

							if (dataEntity.contains(iPickupDEFHelper.getName())) continue;

							IService iService = serviceMap.get(strDERName);
							IEntity majorEntity = majorEntityMap.get(strDERName);
							if (majorEntity == null) {
								majorEntity = iService.getDEModel().createEntity();
								majorEntityMap.put(strDERName, majorEntity);
							}
							majorEntity.set(iDEField.getRealDEField().getName(), strContent);
							pickupFieldMap.put(strDERName, iPickupDEFHelper.getName());

						} else if ((StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUPDATA, true) == 0) || ((StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_INHERIT, true) == 0) && (StringHelper.compare(iDEField.getLinkDEField().getDataType(), IDEField.DATATYPE_PICKUPDATA, true) == 0))) {
							// 需要判断
							String strDERName = "";
							IDEFieldModel iPickupDEFHelper = null;
							if (StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUPDATA, true) == 0) {
								iPickupDEFHelper = (IDEFieldModel) iDEField.getDEModel().getPickupDEField(iDEField.getDERName());
								strDERName = iDEField.getDERName();
							} else {
								IDEFieldModel iLinkDEFHelper2 = (IDEFieldModel) iDEField.getLinkDEField();
								// 继承
								iPickupDEFHelper = (IDEFieldModel) iDEField.getLinkDEField().getDEModel().getPickupDEField(iLinkDEFHelper2.getDERName());
								strDERName = iDEField.getLinkDEField().getDERName();
							}

							if (iPickupDEFHelper == null) {
								DEDataImportResult deDataImportResult = new DEDataImportResult();
								deDataImportResult.setRetCode(Errors.INPUTERROR);
								deDataImportResult.setRetInfo(StringHelper.format("单元格[%1$s]无效，无法获取指定属性[%2$s]相关信息", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getRealDEField().getDEModel().getLogicName()));
								deDataImportResult.setRowSN(row.getRowNum());
								importResultList.add(deDataImportResult);
								if (this.isIgnoreError()) {
									bErrorFlag = true;
									break;
								} else
									return false;
							}

							if (dataEntity.contains(iPickupDEFHelper.getName())) continue;

							IService iService = serviceMap.get(strDERName);
							IEntity majorEntity = majorEntityMap.get(strDERName);
							if (majorEntity == null) {
								majorEntity = iService.getDEModel().createEntity();
								majorEntityMap.put(strDERName, majorEntity);
							}
							majorEntity.set(iDEField.getRealDEField().getName(), strContent);
							pickupFieldMap.put(strDERName, iPickupDEFHelper.getName());

						} else {
							Object objValue = DataTypeHelper.parse(iDEField.getRealDEField().getStdDataType(), strContent);
							if (objValue == null) {
								DEDataImportResult deDataImportResult = new DEDataImportResult();
								deDataImportResult.setRetCode(Errors.INPUTERROR);
								deDataImportResult.setRetInfo(StringHelper.format("单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getLogicName(), strContent));
								deDataImportResult.setRowSN(row.getRowNum());
								importResultList.add(deDataImportResult);
								if (this.isIgnoreError()) {
									bErrorFlag = true;
									break;
								} else
									return false;
							}
							dataEntity.set(iDEField.getName(), objValue);
						}
						continue;
					}

					Object objValue = DataTypeHelper.parse(iDEField.getStdDataType(), strContent);
					if (objValue == null) {
						DEDataImportResult deDataImportResult = new DEDataImportResult();
						deDataImportResult.setRetCode(Errors.INPUTERROR);
						deDataImportResult.setRetInfo(StringHelper.format("单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getLogicName(), strContent));
						deDataImportResult.setRowSN(row.getRowNum());
						importResultList.add(deDataImportResult);
						if (this.isIgnoreError()) {
							bErrorFlag = true;
							break;
						} else
							return false;
					}
					dataEntity.set(iDEField.getName(), objValue);
					continue;
				}

				if (bErrorFlag) {
					continue;
				}

				// 计算外键
				for (String strDERName : majorEntityMap.keySet()) {
					IEntity majorEntity = majorEntityMap.get(strDERName);
					IService iService = serviceMap.get(strDERName);
					if (!selectPickupData(iService, majorEntity)) {
						DEDataImportResult deDataImportResult = new DEDataImportResult();
						deDataImportResult.setRetCode(Errors.INPUTERROR);
						deDataImportResult.setRetInfo(StringHelper.format("行数据[%1$s]无法计算引用数据[%2$s]，%3$s", i + 1, iService.getDEModel().getLogicName(), DataObject.toJSONObject(majorEntity, false)));
						deDataImportResult.setRowSN(row.getRowNum());
						importResultList.add(deDataImportResult);
						if (this.isIgnoreError()) {
							bErrorFlag = true;
							break;
						} else
							return false;
					}
					String strPickupField = pickupFieldMap.get(strDERName);
					dataEntity.set(strPickupField, majorEntity.get(iService.getDEModel().getKeyDEField().getName()));
				}

				// 判断是否要计算主键
				if (!dataEntity.contains(strKeyFieldName) && this.deDataImportKeyItemList.size() > 0) {
					boolean bSelectKey = true;
					SelectCond selectCond = new SelectCond();
					for (IDEDataImportItem iDEDataImportItem:this.deDataImportKeyItemList) {
						Object objValue = dataEntity.get(iDEDataImportItem.getDEField().getName());
						if (objValue == null) {
							bSelectKey = false;
							break;
						}
						selectCond.set(iDEDataImportItem.getDEField().getName(), objValue);
					}
					if (bSelectKey) {
						ArrayList  tempList =  majorService.select(selectCond);
						if (tempList.size() > 1) {
							DEDataImportResult deDataImportResult = new DEDataImportResult();
							deDataImportResult.setRetCode(Errors.INPUTERROR);
							deDataImportResult.setRetInfo(StringHelper.format("行记录[%1$s]无效，查询数据主键发生错误，存在多条满足导入识别项的数据。", nRowIndex));
							deDataImportResult.setRowSN(row.getRowNum());
							importResultList.add(deDataImportResult);
							if(this.isIgnoreError()) {
								continue;
							} else
								return false;
						}

						if (tempList.size() == 1) {
							IEntity iEntity = (IEntity)tempList.get(0);
							dataEntity.set(strKeyFieldName, iEntity.get(strKeyFieldName));
						}
					}
				}
				dataEntity.set(ROWNUM, row.getRowNum());
				dataEntities.add(dataEntity);
				if (this.isIgnoreError()) {
					if (!doSaveDatas(majorService,dataEntities, importResultList)) {
					}
					dataEntities.clear();
				} else {
					if (dataEntities.size() >= 1000) {
						if (!doSaveDatas(majorService,dataEntities, importResultList)) {
							return false;
						}
						dataEntities.clear();
					}
				}
			}

			if (dataEntities.size() > 0) {
				if (!doSaveDatas(majorService,dataEntities, importResultList)){
					return false;
				}
				dataEntities.clear();
			}

//			if (this.isIgnoreError()) {
//				FileOutputStream fOut = new FileOutputStream(strFileLocalPath + strErrorTempFilePath2);
//				errWorkbook.write(fOut);
//				fOut.flush();
//				fOut.close();
//
//				if (nErrorRowIndex > 1) {
//					// 存在错误
//					IService fileDEDataCtrl = ServiceGlobal.getService(FileService.class, sessionFactory);
//					// if (fileDEDataCtrl == null)
//					// {
//					// processInfo.append("<SPAN class='sx-normaltext-red'>无法获取实体[FILE]数据访问对象</SPAN><BR>");
//					// return;
//					// }
//					strErrorTempFilePath2 = StringHelper.format("%1$s%2$s_E.xls", strErrorFileFolder, strTempId);
//
//					net.ibizsys.psrt.srv.common.entity.File saveFile = new net.ibizsys.psrt.srv.common.entity.File();
//					saveFile.setFileSize(0);
//					saveFile.setFileName("无法导入数据.xls");
//					saveFile.setLocalPath(strErrorTempFilePath2);
//					saveFile.setFolder("TEMP");
//
//					fileDEDataCtrl.create(saveFile);
//					// if (callResult.getRetCode() != Errors.OK)
//					// {
//					// processInfo.append("<SPAN class='sx-normaltext-red'>保存错误文件出现错误，%1$s</SPAN><BR>",ex.getMessage());
//					// }
//					// else
//					// {
//					//
//					// }
//					strErrorFileLink = StringHelper.format("<A href=\"exportfile.jsp?FILEID=%1$s\" target=\"_blank\">下载导入失败数据文件</a>", saveFile.getFileId());
//				}
//			}

		} else {
			throw new Exception("没有实现");
		}

		return true;

	}

	/**
	 * 获取单元格内容
	 * @param cell
	 * @param eva
	 * @return
	 */
	protected String getCellValue(Cell cell, FormulaEvaluator eva) {
		if (cell == null) return "";

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_FORMULA:
			if (eva == null)
				return cell.getCellFormula();
			else {
				CellValue cellVal = eva.evaluate(cell);// 获取单元格的值

				if (cellVal.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					return String.valueOf(cellVal.getNumberValue());
				} else {
					return cellVal.getStringValue();
				}
			}

		case Cell.CELL_TYPE_NUMERIC: {
			boolean b = HSSFDateUtil.isCellDateFormatted(cell);
			if (b) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return df.format(date);
			}

			cell.setCellType(Cell.CELL_TYPE_STRING);
			return cell.getStringCellValue();
			// return String.valueOf(cell.getNumericCellValue());
		}
		default:
			return "";
		}
	}

	/**
	 * 填充完属性导入Map
	 * 
	 * @param deFieldImpMap
	 */
	protected void onAfterFillDEFieldImpMap(Map<String, IDEFieldModel> deFieldImpMap) {

	}

	/**
	 * 查询外键数据
	 * 
	 * @param iService
	 * @param majorEntity
	 * @return
	 * @throws Exception
	 */
	protected boolean selectPickupData(IService iService, IEntity majorEntity) throws Exception {
		return iService.select(majorEntity, true);
	}

	
	/**
	 * 进行数据保存，可重写自行进行数据保存
	 * @param majorService
	 * @param dataEntities
	 * @return
	 */
	protected boolean doSaveDatas(IService majorService, ArrayList<IEntity> dataEntities,ArrayList<IDEDataImportResult> importResultList) throws Exception
	{
		int nRowNum = 1;
		try
		{
			SessionFactoryManager.addRef();
			for (IEntity dataEntity : dataEntities)
			{
				nRowNum = DataObject.getIntegerValue(dataEntity,ROWNUM,1);
				
				// 判断是否存在键值
				int nCheckState = majorService.checkKey(dataEntity);
				if (nCheckState == IService.CHECKKEYSTATE_DELETE)
				{
					SessionFactoryManager.releaseRef(false);
					
					DEDataImportResult deDataImportResult = new DEDataImportResult();
					deDataImportResult.setRetCode(Errors.INPUTERROR);
					deDataImportResult.setRetInfo(StringHelper.format("行记录[%1$s]无效，查询数据主键发生错误，存在多条满足导入识别项的数据。", nRowNum));
					deDataImportResult.setRowSN(nRowNum);
					importResultList.add(deDataImportResult);
					return false;
				}

				boolean bInsert = (nCheckState == IService.CHECKKEYSTATE_OK);
				if (bInsert)
				{
					majorService.getDraft(dataEntity);
				}

				if (bInsert)
				{
					// 新建时，判断是否填入父数据
					fillDataEntityParentInfo(dataEntity);

					// 进行数据插入
					try
					{
						onSaveDataBeforeInsert(dataEntity);
					}
					catch (Exception ex)
					{
						// String strErrorFormat =
						// getPage().GetLocalization(SRFDALanguageRes.CTRL_FORMAH_DATASAVEFAILED,
						// "数据无法保存，%1$s");
						String strErrorFormat = "数据无法保存，%1$s";
						String strErrorInfo = StringHelper.format(strErrorFormat, ex.getMessage());

						SessionFactoryManager.releaseRef(false);
						
						DEDataImportResult deDataImportResult = new DEDataImportResult();
						deDataImportResult.setRetCode(Errors.INPUTERROR);
						deDataImportResult.setRetInfo(StringHelper.format("行数据[%1$s]保存失败，%2$s!", nRowNum,strErrorInfo));
						deDataImportResult.setRowSN(nRowNum);
						importResultList.add(deDataImportResult);
						return false;
					}

				}
				else
				{
					try
					{
						onSaveDataBeforeUpdate(dataEntity);

					}
					catch (Exception ex)
					{
						String strErrorFormat = "数据无法保存，%1$s";
						// String strErrorFormat =
						// getPage().GetLocalization(SRFDALanguageRes.CTRL_FORMAH_DATASAVEFAILED,
						// "数据无法保存，%1$s");
						String strErrorInfo = StringHelper.format(strErrorFormat, ex.getMessage());

						SessionFactoryManager.releaseRef(false);
						
						DEDataImportResult deDataImportResult = new DEDataImportResult();
						deDataImportResult.setRetCode(Errors.INPUTERROR);
						deDataImportResult.setRetInfo(StringHelper.format("行数据[%1$s]保存失败，%2$s!", nRowNum,strErrorInfo));
						deDataImportResult.setRowSN(nRowNum);
						importResultList.add(deDataImportResult);
						return false;
					}
				}

				try
				{
					doSaveData(majorService, bInsert?this.getCreateDEActionName():this.getUpdateDEActionName(), dataEntity);
					
					DEDataImportResult deDataImportResult = new DEDataImportResult();
					deDataImportResult.setRetCode(Errors.OK);
					deDataImportResult.setRetInfo(StringHelper.format("行数据[%1$s]保存成功，%2$s!", nRowNum,this.getDEModel().getDataInfo(dataEntity)));
					deDataImportResult.setRowSN(nRowNum);
					
					importResultList.add(deDataImportResult);
				}
				catch (Exception ex)
				{
					SessionFactoryManager.releaseRef(false);
					
					DEDataImportResult deDataImportResult = new DEDataImportResult();
					deDataImportResult.setRetCode(Errors.INPUTERROR);
					deDataImportResult.setRetInfo(StringHelper.format("行数据[%1$s]保存失败，%2$s!", nRowNum,ex.getMessage()));
					deDataImportResult.setRowSN(nRowNum);
					importResultList.add(deDataImportResult);
					
					return false;
				}
			}
			SessionFactoryManager.releaseRef(true);
			return true;
		}
		catch (Exception ex)
		{
			SessionFactoryManager.releaseRef(false);
			
			DEDataImportResult deDataImportResult = new DEDataImportResult();
			deDataImportResult.setRetCode(Errors.INPUTERROR);
			deDataImportResult.setRetInfo(StringHelper.format("导入数据过程中发生错误，%1$s!", ex.getMessage()));
			deDataImportResult.setRowSN(nRowNum);
			importResultList.add(deDataImportResult);
			log.error(ex);
			return false;
		}
	}
	
	
	/**
	 * 进行数据保存
	 * 
	 * @param iService
	 * @param strActionMode
	 * @param dataEntity
	 * @return
	 */
	protected void doSaveData(IService iService, String strActionMode, IEntity dataEntity) throws Exception
	{
		iService.executeAction(strActionMode, dataEntity);
	}

	/**
	 * 保存之前触发（新建）
	 * 
	 * @param dataEntity
	 * @return
	 */
	protected void onSaveDataBeforeInsert(IEntity dataEntity) throws Exception
	{
		CallResult callResult = this.getDEModel().getDEDataAccMgr().test(WebContext.getCurrent(), dataEntity, this.getCreateDataAccessAction());
		if(callResult.isError()){
			throw new ErrorException(callResult.getRetCode(), callResult.getErrorInfo());
		}
	}

	/**
	 * 保存之前触发（更新）
	 * 
	 * @param dataEntity
	 * @return
	 */
	protected void onSaveDataBeforeUpdate(IEntity dataEntity) throws Exception
	{
		CallResult callResult = this.getDEModel().getDEDataAccMgr().test(WebContext.getCurrent(), dataEntity, this.getUpdateDataAccessAction());
		if(callResult.isError()){
			throw new ErrorException(callResult.getRetCode(), callResult.getErrorInfo());
		}
	}
	
	/**
	 * 填充实体的父信息
	 * 
	 * @param dataEntity
	 */
	protected void fillDataEntityParentInfo(IEntity dataEntity) throws Exception
	{
		
	}
}