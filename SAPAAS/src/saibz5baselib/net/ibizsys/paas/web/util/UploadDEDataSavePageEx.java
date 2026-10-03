package net.ibizsys.paas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.ibizsys.paas.codelist.ICodeItem;
import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDERInherit;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.ExcelCellFuncHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.service.FileService;


/**
 * 上传实体数据后台处理页面（使用Apache Commons FileUpload组件）
 * 
 * @author hebao
 * 
 */
public class UploadDEDataSavePageEx extends Page
{
	protected net.ibizsys.paas.util.StringBuilderEx processInfo = new net.ibizsys.paas.util.StringBuilderEx();

	protected String strErrorFileLink = "";

	int nRowIndex2 = 1;

	protected String strPKeyName = "";

	protected Object objPKeyValue = null;

	protected boolean bStopWhenError = true;

	protected String strMultiKeys = "";

	protected String strKeyName = "";

	protected String strInsertMode = "DEFAULT";

	protected String strUpdateMode = "DEFAULT";

	protected String strInsertDataAction = IService.ACTION_CREATE;

	protected String strUpdateDataAction = IService.ACTION_UPDATE;

	protected int nErrorRowIndex = 0;

	private String strPageDataEntityId = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFramework.WebEx.SRFExPage#OnInitComponents()
	 */
	@Override
	protected void onInit() throws Exception
	{
		super.onInit();

		this.strPageDataEntityId = WebContext.getDEId(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strPageDataEntityId))
		{
			throw new Exception(StringHelper.format("没有指定实体编号"));
		}

		this.setDEModel(DEModelGlobal.getDEModel(strPageDataEntityId));

		strKeyName = this.getDEModel().getKeyDEField().getName();// this.getDEModel().GetKeyDEFHelper().getName();

		String strDEDataImport = WebContext.getDEDataImport(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strDEDataImport))
		{
			IDEDataImport iDEDataImport = this.getDEModel().getDEDataImport(strDEDataImport);
			if (iDEDataImport != null)
			{
				// if(!iDEDataImport.isSTOPWHENERRORNull())
				// {
				// bStopWhenError = iDEDataImport.getSTOPWHENERROR();
				// }
				//
				// //判断是否支持多属性
				// if(iDEDataImport.getMultiKeys()!=null &&
				// iDEDataImport.getMultiKeys().size()>0)
				// {
				// for(String strKey : iDEDataImport.getMultiKeys())
				// {
				// if(!StringHelper.isNullOrEmpty(strMultiKeys))
				// strMultiKeys += ";";
				// strMultiKeys+=strKey;
				// }
				// }
				//
				// if(!StringHelper.isNullOrEmpty(iDEDataImport.getINSERTMODE()))
				// {
				// strInsertMode = iDEDataImport.getINSERTMODE();
				// }
				//
				// if(!StringHelper.isNullOrEmpty(iDEDataImport.getUPDATEMODE()))
				// {
				// strUpdateMode = iDEDataImport.getUPDATEMODE();
				// }
				//
				// if(!StringHelper.isNullOrEmpty(iDEDataImport.getINSERTDATAACTION()))
				// {
				// strInsertDataAction = iDEDataImport.getINSERTDATAACTION();
				// }
				//
				// if(!StringHelper.isNullOrEmpty(iDEDataImport.getUPDATEDATAACTION()))
				// {
				// strUpdateDataAction = iDEDataImport.getUPDATEDATAACTION();
				// }

			}
			else
			{
				throw new Exception(StringHelper.format("无法获取实体[%1$s]数据导入模式[%2$s]", this.getDEModel().getId(), strDEDataImport));
			}
		}

		this.fillParentDataEntity();
		this.doDataImport();

	}

	/**
	 * 执行数据导入
	 * 
	 * @throws Exception
	 */
	protected void doDataImport() throws Exception
	{
		// AccessUtil accessUtil = null;
		InputStream in = null;
		try
		{
			String strFileLocalPath = WebConfig.getCurrent().getFilePath();
			String strErrorFileFolder = "";
			strErrorFileFolder += "TEMP";
			strErrorFileFolder += File.separator;
			strErrorFileFolder += StringHelper.format("%1$tY-%1$tm-%1$td", new java.util.Date());
			strErrorFileFolder += File.separator;

			File dir = new File(strFileLocalPath + strErrorFileFolder);
			dir.mkdirs();

			// 判断当前用户对指定数据是否有建立能力

			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			//解决上传文件名的中文乱码
			//upload.setHeaderEncoding("UTF-8"); 
			List<FileItem> list = upload.parseRequest(this.getRequest());
			if(list.size() == 0)
				return;
			
			FileItem fileItem = list.get(0);
			if(fileItem == null)
				return;
			
			boolean bAccess = false;
			String strTempId = KeyValueHelper.genGuidEx();
			String strTempFilePath = "";
			
			String fileName = fileItem.getName();
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
			String fileNameExt = fileName.substring(fileName.lastIndexOf(".")+1);   
			
			if (StringHelper.compare(fileNameExt, "mdb", true) == 0)
			{
				bAccess = true;
			}
			
			if (bAccess)
			{
				nRowIndex2--;
				// 将文件拷贝到指定位置
				strTempFilePath = StringHelper.format("%1$s%2$s.%3$s", WebConfig.getCurrent().getTempPath(), strTempId, fileNameExt);
			}
			else
				strTempFilePath = StringHelper.format("%1$s%2$s.%3$s", WebConfig.getCurrent().getTempPath(), strTempId, fileNameExt);
			File tempFile = new File(strTempFilePath); 
			fileItem.write(tempFile);

			TreeMap<Integer, IDEFieldModel> deFieldMap = new TreeMap<Integer, IDEFieldModel>();
			TreeMap<String, ICodeListModel> codeListMap = new TreeMap<String, ICodeListModel>();
			TreeMap<String, IService> serviceMap = new TreeMap<String, IService>();
			TreeMap<String, String> pickupFieldMap = new TreeMap<String, String>();
			TreeMap<String, IDEFieldModel> deFieldImpMap = new TreeMap<String, IDEFieldModel>();
			Vector<String> importKeyList = new Vector<String>();
			Vector<IEntity> tempList = new Vector<IEntity>();
			String strKeyFieldName = this.getDEModel().getKeyDEField().getName();

			java.util.Iterator<IDEField> deFields = this.getDEModel().getDEFields();
			while (deFields.hasNext())
			{
				IDEFieldModel iDEField = (IDEFieldModel) deFields.next();
				if (iDEField.getImportOrder() == -1)
					continue;

				// if(iDEField.isI.getDEField().getEXCELIMPKEY())
				// importKeyList.add(iDEField.GetDTColumn().GetColumnName());

				deFieldImpMap.put(iDEField.getImportTag().toUpperCase(), iDEField);
			}

			onAfterFillDEFieldImpMap(deFieldImpMap);

			if (bAccess)
			{
				// accessUtil = new AccessUtil();
				// accessUtil.ConnectAccessDB(strTempFilePath);
				// ResultSet rs =
				// accessUtil.ExecuteQuerySql("SELECT * FROM TABLE1");
				//
				// TreeMap<String, Integer> columnIndextable = new
				// TreeMap<String, Integer>(); // 数据列集合
				//
				// ResultSetMetaData rsmd = rs.getMetaData();
				// int numberOfColumns = rsmd.getColumnCount();
				// for (int i = 1; i <= numberOfColumns; i++)
				// {
				// columnIndextable.put(rsmd.getColumnName(i).toUpperCase(), i -
				// 1);
				// }
				//
				// for (String strContent : columnIndextable.keySet())
				// {
				// strContent = strContent.trim();
				// String strColumnName = strContent.toUpperCase();
				//
				// IDEField iDEField = deFieldImpMap.get(strColumnName);
				// if (iDEField == null)
				// {
				// if(StringHelper.compare(strColumnName, "ID",true)==0)
				// continue;
				// processInfo.append("<SPAN class='sx-normaltext-red'>无法获取属性[%1$s]辅助对象</SPAN><BR>",
				// strColumnName);
				// return;
				// }
				//
				// String strCodeListId = iDEField.GetCodeList();
				// if (!StringHelper.isNullOrEmpty(strCodeListId))
				// {
				// if (!codeListMap.containsKey(strCodeListId))
				// {
				// ICodeListModel codeListConfig =
				// this.getWebContext().getGlobalHelper().getCodeListMgr().GetICodeListModel(strCodeListId,
				// this.getLocalization());
				// if (codeListConfig == null)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>无法获取代码表[%1$s]配置</SPAN><BR>",
				// strCodeListId);
				// return;
				// }
				// codeListMap.put(strCodeListId, codeListConfig);
				// }
				//
				// }
				//
				// if (iDEField.isLinkDEField())
				// {
				// IDEFieldModel iLinkDEFHelper = (IDEFieldModel) iDEField;
				// String strDEId =
				// iLinkDEFHelper.getRealDEField().getDEModel().getId();
				// if (!serviceMap.containsKey(strDEId))
				// {
				// IService iService =
				// this.getDAModelStorage().FindDEDataCtrl(strDEId,
				// this.getWebContext());
				// if (iService == null)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>无法获取实体[%1$s]数据操作对象</SPAN><BR>",
				// strDEId);
				// return;
				// }
				// serviceMap.put(strDEId, iService);
				// }
				// }
				//
				// deFieldMap.put(columnIndextable.get(strContent), iDEField);
				// }
				//
				// Vector<IEntity> dataEntities = new Vector<IEntity>();
				//
				// int nRowIndex = -1;
				//
				// while (rs.next())
				// {
				// IEntity dataEntity = new IEntity();
				// for (int j = 0; j < numberOfColumns; j++)
				// {
				// Object objContent = rs.getObject(j+1);
				// if (objContent == null)
				// continue;
				// String strContent = objContent.toString();
				// if (StringHelper.isNullOrEmpty(strContent))
				// continue;
				//
				// strContent = strContent.trim();
				// if (StringHelper.isNullOrEmpty(strContent))
				// continue;
				//
				// // 判断属性类型
				// IDEField iDEField = deFieldMap.get(j);
				// if(iDEField==null)
				// continue;
				//
				// if
				// (StringHelper.compare(iDEField.getDataType(),IDEField.DATATYPE_PICKUPDATA,
				// true) == 0)
				// continue;
				//
				// // 代码表处理
				// String strCodeListId = iDEField.GetCodeList();
				// if (!StringHelper.isNullOrEmpty(strCodeListId))
				// {
				// ICodeListModel codeListConfig =
				// codeListMap.get(strCodeListId);
				//
				// //进一步判断代码项的类型
				// String strDataType = iDEField.getDataType();
				// if((StringHelper.compare(strDataType,IDEField.DATATYPE_NMCODELIST,false)
				// == 0)
				// ||(StringHelper.compare(strDataType,IDEField.DATATYPE_SMCODELIST,false)
				// == 0))
				// {
				// boolean bNumberMode =
				// (StringHelper.compare(strDataType,IDEField.DATATYPE_NMCODELIST,false)
				// == 0);
				// int nRealValue = 0;
				// String strRealValue = "";
				// //数值多选，判断有没有分割符号
				// String strNewContent = strContent;
				// strNewContent = strNewContent.replace("|",";");
				// strNewContent = strNewContent.replace(",",";");
				// strNewContent = strNewContent.replace("，",";");
				// strNewContent = strNewContent.replace("、",";");
				//
				// String[] items = strNewContent.split("[;]");
				// boolean bValueMode = false;
				// for(int l=0;l<items.length;l++)
				// {
				// String strText = items[l];
				// ICodeItem iCodeItem =
				// codeListConfig.FindICodeItemByText(strText, true);
				// if(iCodeItem==null)
				// {
				// //没有办法找到对应的文本
				// bValueMode = true;
				// break;
				// }
				// else
				// {
				// if(bNumberMode)
				// {
				// nRealValue|=Integer.parseInt(iCodeItem.getValue());
				// }
				// else
				// {
				// if(!StringHelper.isNullOrEmpty(strRealValue))
				// strRealValue+=codeListConfig.getSeparator();
				// strRealValue+=iCodeItem.getValue();
				// }
				// }
				// }
				//
				// if(bValueMode)
				// {
				// if(bNumberMode)
				// {
				// nRealValue = Integer.parseInt(strContent);
				// dataEntity.SetParamValue(iDEField.getName(), nRealValue);
				// }
				// else
				// {
				// strRealValue = strNewContent.replace(";",
				// codeListConfig.getSeparator());
				// dataEntity.SetParamValue(iDEField.getName(), strRealValue);
				// }
				// }
				// else
				// {
				// if(bNumberMode)
				// {
				// dataEntity.SetParamValue(iDEField.getName(), nRealValue);
				// }
				// else
				// {
				// dataEntity.SetParamValue(iDEField.getName(), strRealValue);
				// }
				// }
				//
				// }
				// else
				// {
				// ICodeItem iCodeItem =
				// codeListConfig.FindICodeItemByText(strContent, true);
				// if (iCodeItem == null)
				// {
				// iCodeItem = codeListConfig.getCodeItem(strContent, true);
				// if (iCodeItem == null)
				// {
				// // 判断是否为空值
				// if (StringHelper.compare(codeListConfig.getEmptyText(),
				// strContent, true) != 0)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效， 代码表[%2$s]无法识别[%3$s]</SPAN><BR>",
				// SRFCellFuncHelper.getCellSN(j, nRowIndex), strCodeListId,
				// strContent);
				// return;
				// }
				// }
				// }
				//
				// dataEntity.SetParamValue(iDEField.getName(),
				// iDEField.GetDEFValue(iCodeItem.getValue()));
				// }
				// continue;
				// }
				//
				// // 外键处理
				// if (iDEField.isLinkDEField())
				// {
				// IDEFieldModel iLinkDEFHelper = (IDEFieldModel) iDEField;
				// if
				// ((StringHelper.compare(iDEField.getDataType(),IDEField.DATATYPE_PICKUPTEXT,
				// true) == 0)
				// ||
				// ((StringHelper.compare(iDEField.getDataType(),IDEField.DATATYPE_INHERIT,
				// true) == 0) &&
				// (StringHelper.compare(iLinkDEFHelper.GetRelatedDEFHelper()
				// .getDataType(),IDEField.DATATYPE_PICKUPTEXT, true) == 0)))
				// {
				// // 需要判断
				// IDEFieldModel iPickupDEFHelper = null;
				// if
				// (StringHelper.compare(iDEField.getDataType(),IDEField.DATATYPE_PICKUPTEXT,
				// true) == 0)
				// {
				// iPickupDEFHelper
				// =iLinkDEFHelper.getDEModel().FindPickupDEFHelper(iLinkDEFHelper.getDERName());
				// }
				// else
				// {
				// IDEFieldModel iLinkDEFHelper2 = (IDEFieldModel)
				// iLinkDEFHelper.GetRelatedDEFHelper();
				// // 继承
				// iPickupDEFHelper =
				// iLinkDEFHelper.GetRelatedDEFHelper().getDEModel().FindPickupDEFHelper(iLinkDEFHelper2.getDERName());
				// }
				//
				// if (iPickupDEFHelper == null)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，无法获取指定属性[%2$s]相关信息</SPAN><BR>",
				// SRFCellFuncHelper.getCellSN(j, nRowIndex), iLinkDEFHelper
				// .getRealDEField().getDEModel().getLogicName());
				// return;
				// }
				// if (dataEntity.ContainesParam(iPickupDEFHelper.getName()))
				// continue;
				//
				// IService iService =
				// serviceMap.get(iLinkDEFHelper.getRealDEField().getDEModel().getId());
				// Vector<IEntity> dataList = new Vector<IEntity>();
				//
				// CallResult callResult =
				// selectPickupData(iDEField,iLinkDEFHelper,iService,dataEntity,strContent,dataList);
				// if (callResult.isError())
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]查询[%3$s]发生错误，%4$s</SPAN><BR>",
				// SRFCellFuncHelper.getCellSN(j, nRowIndex), iLinkDEFHelper
				// .getRealDEField().getDEModel().getLogicName(), strContent,
				// ex.getMessage());
				// return;
				// }
				//
				// if (dataList.size() == 0)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]</SPAN><BR>",
				// SRFCellFuncHelper.getCellSN(j, nRowIndex),
				// iLinkDEFHelper.getRealDEField()
				// .getDEModel().getLogicName(), strContent);
				// return;
				// }
				//
				// if (dataList.size() != 1)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，有%4$s条记录符合该名称</SPAN><BR>",
				// SRFCellFuncHelper.getCellSN(j,nRowIndex), iLinkDEFHelper
				// .getRealDEField().getDEModel().getLogicName(), strContent,
				// dataList.size());
				// return;
				// }
				//
				// dataEntity.SetParamValue(iPickupDEFHelper.getName(),
				// dataList.get(0).GetParamValue(iPickupDEFHelper.getRealDEField().getName()));
				// }
				// else
				// {
				// Object objValue =
				// iLinkDEFHelper.getRealDEField().GetDEFValue(strContent);
				// if (objValue == null)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！</SPAN><BR>",
				// SRFCellFuncHelper.getCellSN(j, nRowIndex), iDEField
				// .getLogicName(), strContent);
				// return;
				// }
				// dataEntity.SetParamValue(iDEField.getName(), objValue);
				// }
				// continue;
				// }
				//
				// Object objValue = iDEField.GetDEFValue(strContent);
				// if (objValue == null)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！</SPAN><BR>",
				// SRFCellFuncHelper.getCellSN(j, nRowIndex),
				// iDEField.getLogicName(),
				// strContent);
				// return;
				// }
				// dataEntity.SetParamValue(iDEField.getName(), objValue);
				// continue;
				// }
				//
				// //判断是否要计算主键
				// if(!dataEntity.ContainesParam(strKeyFieldName) &&
				// importKeyList.size()>0)
				// {
				// boolean bSelectKey = true;
				// IEntity cond = new IEntity();
				// for(String strKey:importKeyList)
				// {
				// Object objValue = dataEntity.GetParamValue(strKey);
				// if(objValue==null)
				// {
				// bSelectKey = false;
				// break;
				// }
				// cond.SetParamValue(strKey, objValue);
				// }
				// if(bSelectKey)
				// {
				// IService iService = this.GetDEDataCtrl();
				// tempList.clear();
				// CallResult callResult = iService.Select(cond, tempList);
				// if(callResult.isError())
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>行记录[%1$s]无效，查询数据主键发生错误，%2$s</SPAN><BR>",
				// nRowIndex,ex.getMessage());
				// return;
				// }
				//
				// if(tempList.size()>1)
				// {
				// processInfo.append("<SPAN class='sx-normaltext-red'>行记录[%1$s]无效，查询数据主键发生错误，存在多条满足导入识别项的数据。</SPAN><BR>",
				// nRowIndex);
				// return;
				// }
				//
				// if(tempList.size()==1)
				// {
				// dataEntity.SetParamValue(strKeyFieldName,
				// tempList.get(0).GetParamValue(strKeyFieldName));
				// }
				// }
				// }
				//
				// dataEntities.add(dataEntity);
				// if (dataEntities.size() >= 1000)
				// {
				// if (!doSaveData(dataEntities,true))
				// return;
				// dataEntities.clear();
				// }
				// }
				// if (dataEntities.size() > 0)
				// {
				// if (!doSaveData(dataEntities,true))
				// return;
				// dataEntities.clear();
				// }
			}
			else
			{
				Workbook workbook = null;
				HSSFSheet errSheet = null;
				HSSFWorkbook errWorkbook = null;
				String strErrorTempFilePath2 = "";

				if (!this.bStopWhenError)
				{
					strErrorTempFilePath2 = StringHelper.format("%1$s%2$s_E.xls", strErrorFileFolder, strTempId);
					errWorkbook = new HSSFWorkbook();// Workbook.createWorkbook(new
														// File(strFileLocalPath+strErrorTempFilePath2));
					errSheet = errWorkbook.createSheet("错误数据");
				}

				File excleFile = new File(strTempFilePath);
				String strSuffix = UploadDEDataSavePage.getFileSuffixName(excleFile.getName());
				in = new FileInputStream(strTempFilePath);
				FormulaEvaluator eva = null;
				// 加载Excel文件
				if (StringHelper.compare(strSuffix, "xls", true) ==0)
				{
					HSSFWorkbook hssfWorkbook = new HSSFWorkbook(in);
					eva = new HSSFFormulaEvaluator(hssfWorkbook);
					workbook = hssfWorkbook;
				}
				else if (StringHelper.compare(strSuffix, "xlsx", true) ==0)
				{
					XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
					eva = new XSSFFormulaEvaluator(xssfWorkbook);
					workbook = xssfWorkbook;
				}

				if (workbook.getNumberOfSheets() < 1)
				{
					processInfo.append("<SPAN class='sx-normaltext-red'>Excel中没有包含任何数据分页！</SPAN><BR>");
					return;
				}

				Sheet dataSheet = workbook.getSheetAt(0);

				int nCelLIndex = 0;
				int nRowIndex = 0;

				if (true)
				{
					Row row = dataSheet.getRow(nRowIndex);
					int nFirst = row.getFirstCellNum();
					int nLast = row.getLastCellNum();

					for (int i = nFirst; i < nLast; i++)
					{
						String strContent = getCellValue(row.getCell(i), eva);
						if (StringHelper.isNullOrEmpty(strContent))
						{
							processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，必须输入内容</SPAN><BR>", ExcelCellFuncHelper.getCellSN(i, nRowIndex));
							return;
						}

						strContent = strContent.trim();
						String strColumnName = strContent.toUpperCase();

						IDEFieldModel iDEField = deFieldImpMap.get(strColumnName);
						if (iDEField == null)
						{
							processInfo.append("<SPAN class='sx-normaltext-red'>无法获取属性[%1$s]辅助对象</SPAN><BR>", strColumnName);
							return;
						}

						String strCodeListId = iDEField.getCodeListId();
						if (!StringHelper.isNullOrEmpty(strCodeListId))
						{
							if (!codeListMap.containsKey(strCodeListId))
							{
								ICodeListModel codeListConfig = (ICodeListModel) CodeListGlobal.getCodeList(strCodeListId, this.getSessionFactory());// this.getWebContext().getGlobalHelper().getCodeListMgr().GetICodeListModel(strCodeListId,
																																						// this.getLocalization());
								if (codeListConfig == null)
								{
									processInfo.append("<SPAN class='sx-normaltext-red'>无法获取代码表[%1$s]配置</SPAN><BR>", strCodeListId);
									return;
								}
								codeListMap.put(strCodeListId, codeListConfig);
							}

						}

						if (iDEField.isLinkDEField())
						{
							IDERBase iDERBase = this.getDEModel().getSystem().getDER(iDEField.getDERName());
							if(iDERBase instanceof IDER1N){
								if (!serviceMap.containsKey(iDEField.getDERName()))
								{
									String strDEId = iDERBase.getMajorDEId();
									IService iService = DEModelGlobal.getDEModel(strDEId).getService(this.getSessionFactory());// this.getDAModelStorage().FindDEDataCtrl(strDEId,
																																// this.getWebContext());
									if (iService == null)
									{
										processInfo.append("<SPAN class='sx-normaltext-red'>无法获取实体[%1$s]数据操作对象</SPAN><BR>", strDEId);
										return;
									}
									serviceMap.put(iDEField.getDERName(), iService);
								}
							}
							else if(iDERBase instanceof IDERInherit){
								
								IDEField linkDEField = iDEField.getLinkDEField();
								if (linkDEField.isLinkDEField()){
									iDERBase = this.getDEModel().getSystem().getDER(linkDEField.getDERName());
									if(iDERBase instanceof IDER1N){
										
										if (!serviceMap.containsKey(linkDEField.getDERName()))
										{
											String strDEId = iDERBase.getMajorDEId();
											IService iService = DEModelGlobal.getDEModel(strDEId).getService(this.getSessionFactory());
											if (iService == null)
											{
												processInfo.append("<SPAN class='sx-normaltext-red'>无法获取实体[%1$s]数据操作对象</SPAN><BR>", strDEId);
												return;
											}
											serviceMap.put(linkDEField.getDERName(), iService);
										}
									}
								}
							}
						}

						deFieldMap.put(i, iDEField);
					}

					if (!this.bStopWhenError)
					{
						addErrorSheetRow(errSheet, row);
					}
				}

				Vector<IEntity> dataEntities = new Vector<IEntity>();
				int nLastRow = dataSheet.getLastRowNum();
				for (int i = 1; i <= nLastRow; i++)
				{
					boolean bErrorFlag = false;
					IEntity dataEntity = this.getDEModel().createEntity();

					Row row = dataSheet.getRow(i);
					int nFirst = row.getFirstCellNum();
					int nLast = row.getLastCellNum();

					HashMap<String, IEntity> majorEntityMap = new HashMap<String, IEntity>();

					for (int j = nFirst; j <= nLast; j++)
					{
						String strContent = getCellValue(row.getCell(j), eva);

						bErrorFlag = false;
						if (StringHelper.isNullOrEmpty(strContent))
							continue;

						strContent = strContent.trim();
						if (StringHelper.isNullOrEmpty(strContent))
							continue;

						// 判断属性类型
						IDEFieldModel iDEField = deFieldMap.get(j);

						// 代码表处理
						String strCodeListId = iDEField.getCodeListId();
						if (!StringHelper.isNullOrEmpty(strCodeListId))
						{
							ICodeListModel codeListConfig = codeListMap.get(strCodeListId);

							// 进一步判断代码项的类型
							String strDataType = iDEField.getDataType();
							if ((StringHelper.compare(strDataType, IDEField.DATATYPE_NMCODELIST, false) == 0) || (StringHelper.compare(strDataType, IDEField.DATATYPE_SMCODELIST, false) == 0))
							{
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
								for (int l = 0; l < items.length; l++)
								{
									String strText = items[l];
									ICodeItem iCodeItem = codeListConfig.getCodeItemByText(strText, true);
									if (iCodeItem == null)
									{
										// 没有办法找到对应的文本
										bValueMode = true;
										break;
									}
									else
									{
										if (bNumberMode)
										{
											nRealValue |= Integer.parseInt(iCodeItem.getValue());
										}
										else
										{
											if (!StringHelper.isNullOrEmpty(strRealValue))
												strRealValue += codeListConfig.getValueSeparator();
											strRealValue += iCodeItem.getValue();
										}
									}
								}

								if (bValueMode)
								{
									if (bNumberMode)
									{
										nRealValue = Integer.parseInt(strContent);
										dataEntity.set(iDEField.getName(), nRealValue);
									}
									else
									{
										strRealValue = strNewContent.replace(";", codeListConfig.getValueSeparator());
										dataEntity.set(iDEField.getName(), strRealValue);
									}
								}
								else
								{
									if (bNumberMode)
									{
										dataEntity.set(iDEField.getName(), nRealValue);
									}
									else
									{
										dataEntity.set(iDEField.getName(), strRealValue);
									}
								}

							}
							else
							{
								ICodeItem iCodeItem = codeListConfig.getCodeItemByText(strContent, true);
								if (iCodeItem == null)
								{
									iCodeItem = codeListConfig.getCodeItem(strContent, true);
									if (iCodeItem == null)
									{
										// 判断是否为空值
										if (StringHelper.compare(codeListConfig.getEmptyText(), strContent, true) != 0)
										{
											processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效， 代码表[%2$s]无法识别[%3$s]</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), strCodeListId,
													strContent);

											if (!this.bStopWhenError)
											{
												bErrorFlag = true;
												addErrorSheetRow(errSheet, row);
												break;
											}
											else
												return;
										}
									}
								}
								dataEntity.set(iDEField.getName(), DataTypeHelper.parse(iDEField.getStdDataType(), iCodeItem.getValue()));
							}
							continue;
						}

						// 外键处理
						if (iDEField.isLinkDEField())
						{
							if ((StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUPTEXT, true) == 0)
									|| ((StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_INHERIT, true) == 0) && (StringHelper.compare(iDEField.getLinkDEField().getDataType(),
											IDEField.DATATYPE_PICKUPTEXT, true) == 0)))
							{

								// 需要判断
								String strDERName = "";
								IDEFieldModel iPickupDEFHelper = null;
								if (StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUPTEXT, true) == 0)
								{
									iPickupDEFHelper = (IDEFieldModel) iDEField.getDEModel().getPickupDEField(iDEField.getDERName());
									strDERName = iDEField.getDERName();
								}
								else
								{
									IDEFieldModel iLinkDEFHelper2 = (IDEFieldModel) iDEField.getLinkDEField();
									// 继承
									iPickupDEFHelper = (IDEFieldModel) iDEField.getLinkDEField().getDEModel().getPickupDEField(iLinkDEFHelper2.getDERName());
									strDERName = iDEField.getLinkDEField().getDERName();
								}

								if (iPickupDEFHelper == null)
								{
									processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，无法获取指定属性[%2$s]相关信息</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getRealDEField()
											.getDEModel().getLogicName());

									if (!this.bStopWhenError)
									{
										bErrorFlag = true;
										addErrorSheetRow(errSheet, row);
										break;
									}
									else
										return;
								}

								if (dataEntity.contains(iPickupDEFHelper.getName()))
									continue;

								IService iService = serviceMap.get(strDERName);
								IEntity majorEntity = majorEntityMap.get(strDERName);
								if (majorEntity == null)
								{
									majorEntity = iService.getDEModel().createEntity();
									majorEntityMap.put(strDERName, majorEntity);
								}
								majorEntity.set(iDEField.getRealDEField().getName(), strContent);
								pickupFieldMap.put(strDERName, iPickupDEFHelper.getName());
								//
								// try
								// {
								// ArrayList dataList=
								// selectPickupData(iDEField,iService,dataEntity,strContent);
								// if (dataList.size() == 0)
								// {
								// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]</SPAN><BR>",
								// ExcelCellFuncHelper.getCellSN(j, i),
								// iDEField.getRealDEField()
								// .getDEModel().getLogicName(), strContent);
								//
								// if(!this.bStopWhenError)
								// {
								// bErrorFlag = true;
								// addErrorSheetRow(errSheet,row);
								// break;
								// }
								// else
								// return;
								// }
								//
								// if (dataList.size() != 1)
								// {
								// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，有%4$s条记录符合该名称</SPAN><BR>",
								// ExcelCellFuncHelper.getCellSN(j, i), iDEField
								// .getRealDEField().getDEModel().getLogicName(),
								// strContent, dataList.size());
								//
								// if(!this.bStopWhenError)
								// {
								// bErrorFlag = true;
								// addErrorSheetRow(errSheet,row);
								// break;
								// }
								// else
								// return;
								// }
								//
								// dataEntity.set(iPickupDEFHelper.getName(),
								// ((IEntity)
								// dataList.get(0)).get(iPickupDEFHelper.getRealDEField().getName()));
								// }
								// catch(Exception ex)
								// {
								// processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]查询[%3$s]发生错误，%4$s</SPAN><BR>",
								// ExcelCellFuncHelper.getCellSN(j, i),
								// iDEField.getRealDEField().getDEModel().getLogicName(),
								// strContent, ex.getMessage());
								//
								// if(!this.bStopWhenError)
								// {
								// bErrorFlag = true;
								// addErrorSheetRow(errSheet,row);
								// break;
								// }
								// else
								// return;
								// }
							}
							else if ((StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUPDATA, true) == 0)
									|| ((StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_INHERIT, true) == 0) && (StringHelper.compare(iDEField.getLinkDEField().getDataType(),
											IDEField.DATATYPE_PICKUPDATA, true) == 0)))
							{

								// 需要判断
								String strDERName = "";
								IDEFieldModel iPickupDEFHelper = null;
								if (StringHelper.compare(iDEField.getDataType(), IDEField.DATATYPE_PICKUPDATA, true) == 0)
								{
									iPickupDEFHelper = (IDEFieldModel) iDEField.getDEModel().getPickupDEField(iDEField.getDERName());
									strDERName = iDEField.getDERName();
								}
								else
								{
									IDEFieldModel iLinkDEFHelper2 = (IDEFieldModel) iDEField.getLinkDEField();
									// 继承
									iPickupDEFHelper = (IDEFieldModel) iDEField.getLinkDEField().getDEModel().getPickupDEField(iLinkDEFHelper2.getDERName());
									strDERName = iDEField.getLinkDEField().getDERName();
								}

								if (iPickupDEFHelper == null)
								{
									processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，无法获取指定属性[%2$s]相关信息</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getRealDEField()
											.getDEModel().getLogicName());

									if (!this.bStopWhenError)
									{
										bErrorFlag = true;
										addErrorSheetRow(errSheet, row);
										break;
									}
									else
										return;
								}

								if (dataEntity.contains(iPickupDEFHelper.getName()))
									continue;

								IService iService = serviceMap.get(strDERName);
								IEntity majorEntity = majorEntityMap.get(strDERName);
								if (majorEntity == null)
								{
									majorEntity = iService.getDEModel().createEntity();
									majorEntityMap.put(strDERName, majorEntity);
								}
								majorEntity.set(iDEField.getRealDEField().getName(), strContent);
								pickupFieldMap.put(strDERName, iPickupDEFHelper.getName());

							}
							else
							{
								Object objValue = DataTypeHelper.parse(iDEField.getRealDEField().getStdDataType(), strContent);
								if (objValue == null)
								{
									processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i),
											iDEField.getLogicName(), strContent);

									if (!this.bStopWhenError)
									{
										bErrorFlag = true;
										addErrorSheetRow(errSheet, row);
										break;
									}
									else
										return;
								}
								dataEntity.set(iDEField.getName(), objValue);
							}
							continue;
						}

						Object objValue = DataTypeHelper.parse(iDEField.getStdDataType(), strContent);
						if (objValue == null)
						{
							processInfo.append("<SPAN class='sx-normaltext-red'>单元格[%1$s]无效，[%2$s]无法识别[%3$s]，请确认数据类型是否正确！</SPAN><BR>", ExcelCellFuncHelper.getCellSN(j, i), iDEField.getLogicName(),
									strContent);

							if (!this.bStopWhenError)
							{
								bErrorFlag = true;
								addErrorSheetRow(errSheet, row);
								break;
							}
							else
								return;
						}
						dataEntity.set(iDEField.getName(), objValue);
						continue;
					}

					if (bErrorFlag)
					{
						continue;
					}

					// 计算外键
					for (String strDERName : majorEntityMap.keySet())
					{
						IEntity majorEntity = majorEntityMap.get(strDERName);
						IService iService = serviceMap.get(strDERName);
						if (!selectPickupData(iService, majorEntity))
						{
							processInfo.append("<SPAN class='sx-normaltext-red'>行数据[%1$s]无法计算引用数据[%2$s]，%3$s</SPAN><BR>", i + 1, iService.getDEModel().getLogicName(),
									DataObject.toJSONObject(majorEntity, false));
							if (!this.bStopWhenError)
							{
								bErrorFlag = true;
								addErrorSheetRow(errSheet, row);
								break;
							}
							else
								return;
						}
						String strPickupField = pickupFieldMap.get(strDERName);
						dataEntity.set(strPickupField, majorEntity.get(iService.getDEModel().getKeyDEField().getName()));
					}

					// 判断是否要计算主键
					// if(!dataEntity.contains(strKeyFieldName) &&
					// importKeyList.size()>0)
					// {
					// boolean bSelectKey = true;
					// IEntity cond = new IEntity();
					// for(String strKey:importKeyList)
					// {
					// Object objValue = dataEntity.GetParamValue(strKey);
					// if(objValue==null)
					// {
					// bSelectKey = false;
					// break;
					// }
					// cond.SetParamValue(strKey, objValue);
					// }
					// if(bSelectKey)
					// {
					// IService iService = this.GetDEDataCtrl();
					// tempList.clear();
					// CallResult callResult = iService.Select(cond, tempList);
					// if(callResult.isError())
					// {
					// processInfo.append("<SPAN class='sx-normaltext-red'>行记录[%1$s]无效，查询数据主键发生错误，%2$s</SPAN><BR>",
					// nRowIndex,ex.getMessage());
					// if(!this.bStopWhenError)
					// {
					// addErrorSheetRow(errSheet,row);
					// continue;
					// }
					// else
					// return;
					// }
					//
					// if(tempList.size()>1)
					// {
					// processInfo.append("<SPAN class='sx-normaltext-red'>行记录[%1$s]无效，查询数据主键发生错误，存在多条满足导入识别项的数据。</SPAN><BR>",
					// nRowIndex);
					// if(!this.bStopWhenError)
					// {
					// addErrorSheetRow(errSheet,row);
					// continue;
					// }
					// else
					// return;
					// }
					//
					// if(tempList.size()==1)
					// {
					// dataEntity.SetParamValue(strKeyFieldName,
					// tempList.get(0).GetParamValue(strKeyFieldName));
					// }
					// }
					// }

					dataEntities.add(dataEntity);
					if (!this.bStopWhenError)
					{
						if (!doSaveDatas(dataEntities, false))
						{
							addErrorSheetRow(errSheet, row);
						}
						dataEntities.clear();
					}
					else
					{
						if (dataEntities.size() >= 1000)
						{
							if (!doSaveDatas(dataEntities, false))
								return;
							dataEntities.clear();
						}
					}
				}

				if (dataEntities.size() > 0)
				{
					if (!doSaveDatas(dataEntities, false))
						return;
					dataEntities.clear();
				}

				if (!this.bStopWhenError)
				{
					FileOutputStream fOut = new FileOutputStream(strFileLocalPath + strErrorTempFilePath2);
					errWorkbook.write(fOut);
					fOut.flush();
					fOut.close();

					if (nErrorRowIndex > 1)
					{
						// 存在错误
						IService fileDEDataCtrl = ServiceGlobal.getService(FileService.class, this.getSessionFactory());
						// if (fileDEDataCtrl == null)
						// {
						// processInfo.append("<SPAN class='sx-normaltext-red'>无法获取实体[FILE]数据访问对象</SPAN><BR>");
						// return;
						// }
						strErrorTempFilePath2 = StringHelper.format("%1$s%2$s_E.xls", strErrorFileFolder, strTempId);

						net.ibizsys.psrt.srv.common.entity.File saveFile = new net.ibizsys.psrt.srv.common.entity.File();
						saveFile.setFileSize(0);
						saveFile.setFileName("无法导入数据.xls");
						saveFile.setLocalPath(strErrorTempFilePath2);
						saveFile.setFolder("TEMP");

						fileDEDataCtrl.create(saveFile);
						// if (callResult.getRetCode() != Errors.OK)
						// {
						// processInfo.append("<SPAN class='sx-normaltext-red'>保存错误文件出现错误，%1$s</SPAN><BR>",ex.getMessage());
						// }
						// else
						// {
						//
						// }
						strErrorFileLink = StringHelper.format("<A href=\"exportfile.jsp?FILEID=%1$s\" target=\"_blank\">下载导入失败数据文件</a>", saveFile.getFileId());
					}
				}
			}
		}
		catch (Exception ex)
		{
			processInfo.append("<SPAN class='sx-normaltext-red'>导入数据过程中发生错误，%1$s!</SPAN><BR>", ex.getMessage());
			ex.printStackTrace();
		}
		finally
		{
			if(in!=null){
				in.close();
			}		
			// if (accessUtil != null)
			// {
			// try
			// {
			// accessUtil.CloseConnection();
			// }
			// catch (Exception e)
			// {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// accessUtil = null;
			// }
		}
	}

	/**
	 * 进行数据保存，可重写自行进行数据保存
	 * 
	 * @param dataEntities
	 * @param bAccess
	 * @return
	 */
	protected boolean doSaveDatas(Vector<IEntity> dataEntities, boolean bAccess) throws Exception
	{
		IService iService = this.getDEModel().getService(this.getSessionFactory());

		try
		{
			SessionFactoryManager.addRef();

			for (IEntity dataEntity : dataEntities)
			{
				// 判断是否存在键值
				int nCheckState = iService.checkKey(dataEntity);
				if (nCheckState == IService.CHECKKEYSTATE_DELETE)
				{
					SessionFactoryManager.releaseRef(false);
					processInfo.append("<SPAN class='sx-normaltext-red'>行数据[%1$s]无效，%2$s!</SPAN><BR>", nRowIndex2 + 1, "该数据已经被删除!数据无法保存!");
					return false;
				}

				boolean bInsert = (nCheckState == IService.CHECKKEYSTATE_OK);

				// for (IDEField iDEField : this.getDEModel().GetDEFHelpers())
				// {
				// if (!bInsert)
				// {
				// if(iDEField.IsKeyDEField())
				// continue;
				//
				// if (!iDEField.GetFormCtrl().IsEnableFormUpdate())
				// {
				// dataEntity.RemoveParam(iDEField.getName());
				// }
				// }
				// }

				if (bInsert)
				{
					iService.getDraft(dataEntity);

					// for (IDEField iDEField :
					// this.getDEModel().GetDEFHelpers())
					// {
					// if (iDEField.IsKeyDEField())
					// continue;
					//
					// String strDVT =
					// iDEField.GetFormCtrl().GetDefaultValueType();
					// String strDV = iDEField.GetFormCtrl().GetDefaultValue();
					//
					// if (StringHelper.Length(strDVT) == 0 &&
					// StringHelper.Length(strDV) == 0)
					// continue;
					//
					// if (dataEntity.ContainesParam(iDEField.getName()))
					// continue;
					//
					// dataEntity.SetParamValue(iDEField.getName(),
					// DADVHelper.GetDefaultValue(this.getWebContext(), strDVT,
					// strDV, iDEField.GetStdDataType()));
					// }
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
						processInfo.append("<SPAN class='sx-normaltext-red'>行数据[%1$s]保存失败，%2$s!</SPAN><BR>", nRowIndex2 + 1, strErrorInfo);
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
						processInfo.append("<SPAN class='sx-normaltext-red'>行数据[%1$s]保存失败，%2$s!</SPAN><BR>", nRowIndex2 + 1, strErrorInfo);
						return false;
					}

				}

				try
				{
					doSaveData(iService, bInsert?strInsertDataAction:strUpdateDataAction, dataEntity);
					processInfo.append("<SPAN class='sx-normaltext'>行数据[%1$s]保存成功，%2$s!</SPAN><BR>", nRowIndex2 + 1, this.getDEModel().getDataInfo(dataEntity));
				}
				catch (Exception ex)
				{
					SessionFactoryManager.releaseRef(false);
					processInfo.append("<SPAN class='sx-normaltext-red'>行数据[%1$s]保存失败，%2$s!</SPAN><BR>", nRowIndex2 + 1, ex.getMessage());
					return false;
				}
				nRowIndex2++;

				// transactionManager.CommitAndBegin();
			}
			SessionFactoryManager.releaseRef(true);
			return true;
		}
		catch (Exception ex)
		{
			SessionFactoryManager.releaseRef(false);
			// SessionFactoryManager.releaseRef(false);
			processInfo.append("<SPAN class='sx-normaltext-red'>导入数据过程中发生错误，%1$s!</SPAN><BR>", ex.getMessage());
			ex.printStackTrace();
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
		// CallResult callResult = OnTestDataAction(dataEntity,
		// strInsertDataAction);
		// if (callResult.getRetCode() != Errors.OK)
		// return callResult;
		//
		// return this.GetDEDataCtrl().TestDataLock(dataEntity,
		// GetDataLockKey(dataEntity));
	}

	/**
	 * 保存之前触发（更新）
	 * 
	 * @param dataEntity
	 * @return
	 */
	protected void onSaveDataBeforeUpdate(IEntity dataEntity) throws Exception
	{
		// CallResult callResult = OnTestDataAction(dataEntity,
		// strUpdateDataAction);
		// if (callResult.getRetCode() != Errors.OK)
		// return callResult;
		//
		// return this.GetDEDataCtrl().TestDataLock(dataEntity,
		// GetDataLockKey(dataEntity));
	}

	

	/**
	 * 获取处理信息
	 * 
	 * @return
	 */
	public String outputProcessInfo()
	{
		return processInfo.toString();
	}

	/**
	 * 输出错误链接
	 * 
	 * @return
	 */
	public String outputErrorFileLink()
	{
		return this.strErrorFileLink;
	}

	/**
	 * 填充实体的父信息
	 * 
	 * @param dataEntity
	 */
	protected void fillDataEntityParentInfo(IEntity dataEntity) throws Exception
	{
		if (StringHelper.isNullOrEmpty(strPKeyName))
		{
			return;
		}

		Object objValue = dataEntity.get(strPKeyName);
		if (objValue == null)
		{
			dataEntity.set(strPKeyName, objPKeyValue);
		}
	}

	/**
	 * 填充主实体数据
	 * 
	 * @param dataEntity
	 */
	protected void fillParentDataEntity()
	{
		// 填充上下文关系
		String strDERID = WebContext.getDER1NId(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strDERID))
			return;

		// IDEFieldModel pickupDEFHelper =
		// this.getDEModel().FindPickupDEFHelper(strDERID);
		// if(pickupDEFHelper == null )
		// {
		// //没有找到DER关系
		// DER1N der1n = new DER1N();
		// CallResult callResult = getDAModelHelper().GetDER1N(strDERID, der1n);
		// if(callResult.getRetCode()!=Errors.OK)
		// {
		// throw new
		// Exception(StringHelper.format("获取DER1N[%1$s]失败，%2$s",strDERID,ex.getMessage()));
		// return;
		// }
		// //
		// IDEField iDEField =
		// getDEModel().GetDEFHelper(der1n.getMAJORKEYDEFNAME());
		// if(iDEField == null)
		// return ;
		//
		// if(!(iDEField instanceof IDEFieldModel))
		// {
		// if(!(iDEField instanceof IInheritDEFHelper))
		// {
		// return;
		// }
		// else
		// {
		// IInheritDEFHelper inheritDEFHelper = (IInheritDEFHelper)iDEField;
		// if(inheritDEFHelper.GetRelatedDEFHelper() instanceof IDEFieldModel)
		// {
		// pickupDEFHelper =
		// (IDEFieldModel)inheritDEFHelper.GetRelatedDEFHelper();
		// }
		// else
		// return;
		// }
		// }
		// else
		// pickupDEFHelper = (IDEFieldModel)iDEField;
		// strDERID = pickupDEFHelper.getDERName();
		// this.getWebContext().SetParamValue(SRFDAWebContext.TAG_SRFDERID,
		// strDERID);
		// }
		//
		// if(!pickupDEFHelper.getRealDEField().GetDTColumn().IsPKey())
		// return ;
		//
		// //判断URL是否有传入值
		// String strKeyValue =
		// this.getWebContext().GetParamValue(pickupDEFHelper.GetRelatedDEFHelper().getName());
		// //没有传入键值
		// if(StringHelper.isNullOrEmpty(strKeyValue))
		// {
		// if(pickupDEFHelper.getRealDEField().getDEModel().IsIndexDE())
		// {
		// Vector<DERINDEX> list=
		// pickupDEFHelper.getRealDEField().getDEModel().GetDERINDEXs(true);
		// boolean bFind = false;
		// for(DERINDEX dERINDEX:list)
		// {
		// IDEHelper iDEHelper =
		// getDAModelStorage().FindDEHelper(dERINDEX.getDEID());
		// if(iDEHelper == null)
		// {
		// throw new
		// Exception(StringHelper.format("无法获取实体[%1$s]辅助对象",dERINDEX.getDEID()));
		// continue;
		// }
		//
		// strKeyValue =
		// this.getWebContext().GetParamValue(iDEHelper.GetKeyDEFHelper().getName());
		// if(!StringHelper.isNullOrEmpty(strKeyValue)){
		// bFind = true;
		// break;
		// }
		// }
		// if(!bFind)
		// return;
		// }
		// else
		// return;
		// }
		//
		// strPKeyName = pickupDEFHelper.GetFormCtrl().GetFormCtrlId();
		// objPKeyValue = strKeyValue;
	}

	protected void addErrorSheetRow(Sheet s1, Row row) throws Exception
	{
		if (nErrorRowIndex != 0)
			nRowIndex2++;

		int nFirst = row.getFirstCellNum();
		int nLast = row.getLastCellNum();

		Row newRow = s1.createRow(nErrorRowIndex);

		for (int i = nFirst; i < nLast; i++)
		{
			String strContent = getCellValue(row.getCell(i), null);
			// 创建第一个单元格并处理乱码
			Cell hssfcell = newRow.createCell(i);
			hssfcell.setCellValue(strContent);
			hssfcell.setCellType(Cell.CELL_TYPE_STRING);
			if (nErrorRowIndex == 0)
			{
				s1.setColumnWidth(i, 4000);
			}
		}
		nErrorRowIndex++;
	}

	/**
	 * 填充完属性导入Map
	 * 
	 * @param deFieldImpMap
	 */
	protected void onAfterFillDEFieldImpMap(TreeMap<String, IDEFieldModel> deFieldImpMap)
	{

	}

	/**
	 * 选择外键数据
	 * 
	 * @param iDEField
	 * @param iLinkDEFHelper
	 * @param iService
	 * @param dataEntity
	 * @param strContent
	 * @param dataList
	 * @return
	 */
	protected boolean selectPickupData(IService iService, IEntity majorEntity) throws Exception
	{
		return iService.select(majorEntity, true);
		// // 重新查
		// SelectCond selectCond = new SelectCond();
		// selectCond.set(iDEField.getRealDEField().getName(), strContent);
		// return iService.select(selectCond);
	}

	/**
	 * 获取单元格内容
	 * 
	 * @param cell
	 * @return
	 */
	protected String getCellValue(Cell cell, FormulaEvaluator eva)
	{
		if (cell == null)
			return "";

		switch (cell.getCellType())
		{
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case Cell.CELL_TYPE_FORMULA:
			if (eva == null)
				return cell.getCellFormula();
			else
			{
				CellValue cellVal = eva.evaluate(cell);// 获取单元格的值

				if (cellVal.getCellType() == Cell.CELL_TYPE_NUMERIC)
				{
					return String.valueOf(cellVal.getNumberValue());
				}
				else
				{
					return cellVal.getStringValue();
				}
			}

		case Cell.CELL_TYPE_NUMERIC:
		{
			boolean b = HSSFDateUtil.isCellDateFormatted(cell);
			if (b)
			{
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
}
