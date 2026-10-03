package net.ibizsys.paas.web.util;

import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.util.DEDataImportTemplateHelper;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebContext;

/**
 * 上传实体数据Excel表格页面
 * 
 * @author LionLau
 *
 */
public class UploadDEDataViewPage extends Page {

	protected String strUpdateDataActionPath = "uploaddedata.jsp";
	protected String strTemplDownloadPath = "exportexcel.jsp";

	@Override
	protected void onInit() throws Exception {
		super.onInit();

		String strDEId = WebContext.getDEId(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strDEId)) {
			throw new Exception(StringHelper.format("没有指定实体编号"));
		} 

		IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(strDEId);
		this.setDEModel(iDataEntityModel);

		String strDEDataImport = WebContext.getDEDataImport(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strDEDataImport)) {
			// DEDataImport deDataImport = this.getDEHelper().GetDataImport(strDEDataImport);
			// if(deDataImport!=null)
			// {
			// if(!StringHelper.isNullOrEmpty(deDataImport.getIMPORTACTION()))
			// {
			// strUpdateDataActionPath = deDataImport.getIMPORTACTION();
			// }
			//
			// }
			// else
			// {
			// throw new Exception(StringHelper.format("无法获取实体[%1$s]数据导入模式[%2$s]",
			// this.getDEHelper().getId(),strDEDataImport));
			// }
		}

		String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new java.util.Date());
		String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");

		DEDataImportTemplateHelper.output(this.getDEModel(), strTempFilePath);

		strTemplDownloadPath = WebUtility.appendURLSeperator(strTemplDownloadPath);
		strTemplDownloadPath = StringHelper.format("%1$sFILEID=%2$s", strTemplDownloadPath, WebUtility.encodeURLParamValue(strTempFileName));

		strUpdateDataActionPath = WebUtility.appendURLSeperator(strUpdateDataActionPath);
		strUpdateDataActionPath += this.getWebContext().getQueryString();// StringHelper.format("SRFDEID=%1$s",this.getDEHelper().getId());

	}

	/**
	 * 输出实体逻辑名称
	 * 
	 * @return
	 */
	public String outputDELogicName() {
		return this.getDEModel().getLogicName(this.getLocalization());
	}

	/**
	 * 输出后台数据提交页面
	 * 
	 * @return
	 */
	public String outputDataActionPath() {
		return strUpdateDataActionPath;
	}

	/**
	 * 输出模板文件下载路径
	 * 
	 * @return
	 */
	public String outputTemplPath() {
		return strTemplDownloadPath;
	}
}
