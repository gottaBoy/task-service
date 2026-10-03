package net.ibizsys.paas.web.util;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.psrt.srv.common.service.FileService;
import net.ibizsys.psrt.srv.web.WebContext;

/**
 * 上传文件视图
 * 
 * @author LionLau
 *
 */
public class UploadFileSavePage2 extends Page {
	protected String strProcessInfo = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFramework.WebEx.SRFExPage#OnInitComponents()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		String strFileId = this.getWebContext().getParamValue("FILEID");
		String strFileLocalPath = WebConfig.getCurrent().getFilePath();
		if (StringHelper.isNullOrEmpty(strFileLocalPath)) {
			strProcessInfo = "alert('系统没有配置文件存储路径');";
			return;
		}

		SmartUpload su = createSmartUpload();
		su.upload();

		int nCount = su.getFiles().getCount();
		if (nCount == 0) {
			strProcessInfo = "alert('没有任何上传文件');";
			return;
		}

		String strFileFolder = StringHelper.format("%1$tY-%1$tm-%1$td", new java.util.Date());
		strFileFolder += File.separator;
		strFileFolder += KeyValueHelper.genGuidEx();
		strFileFolder += File.separator;

		File dir = new File(strFileLocalPath + strFileFolder);
		dir.mkdirs();

		String strFilename = "";
		String strFilePathName = strFileLocalPath + strFileFolder;
		int nFileSize = 0;
		for (int i = 0; i < nCount; i++) {
			SmartFile file = su.getFiles().getFile(i);
			nFileSize = file.getSize();
			strFilename = file.getFileName();
			if (StringHelper.isNullOrEmpty(strFilename)) continue;
			strFilename = getRealFileName(strFilename);
			strFilePathName += strFilename;
			file.saveAs(strFilePathName);
			break;
		}

		net.ibizsys.psrt.srv.common.entity.File file = new net.ibizsys.psrt.srv.common.entity.File();
		if (!StringHelper.isNullOrEmpty(strFileId)) file.setFileId(strFileId);
		file.setFileSize(nFileSize);
		file.setFileName(strFilename);
		file.setLocalPath(strFileFolder + strFilename);

		FileService fileService = (FileService) ServiceGlobal.getService(FileService.class, this.getSessionFactory());

		if (!StringHelper.isNullOrEmpty(WebContext.getParentDEId(this.getWebContext()))) {
			//
			// IDEHelper iMajorDEHelper = this.getDAModelStorage().FindDEHelper(this.getWebContext().getSRFPDEID());
			// if(iMajorDEHelper == null)
			// {
			// strProcessInfo = StringHelper.format("alert('无法获取实体[%1$s]辅助对象');",this.getWebContext().getSRFPDEID());
			// return ;
			// }
			//
			// String strKeyValue = this.getWebContext().GetParamValue(iMajorDEHelper.GetKeyDEFHelper().getName());
			// if(!StringHelper.isNullOrEmpty(strKeyValue)){
			// file.setOWNERTYPE(iMajorDEHelper.getId());
			// file.setOWNERID(strKeyValue);
			// }
		}
		onBeforeSaveFile(file);
		if (StringHelper.isNullOrEmpty(strFileId)) {
			fileService.create(file);
		} else {
			fileService.update(file);
		}
		onAfterSaveFile(file);
		strProcessInfo = file.getFileId();
		this.getResponse().getWriter().write(strProcessInfo);
	}

	/**
	 * 保存文件前调用
	 * 
	 * @param file
	 * @return
	 */
	protected void onBeforeSaveFile(net.ibizsys.psrt.srv.common.entity.File file) throws Exception {

	}

	/**
	 * 保存文件后调用
	 * 
	 * @param file
	 * @return
	 */
	protected void onAfterSaveFile(net.ibizsys.psrt.srv.common.entity.File file) throws Exception {

	}

	public String getFileId() {
		return strProcessInfo;
	}

	/**
	 * 获取实际的文件名称
	 * 
	 * @param strFilename
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected String getRealFileName(String strFilename) throws UnsupportedEncodingException {
		return strFilename;
	}

	/**
	 * 建立上传控件
	 * 
	 * @return
	 * @throws ServletException
	 */
	protected SmartUpload createSmartUpload() throws ServletException {
		SmartUpload su = new SmartUpload();
		su.initialize(this.getPageContext());
		return su;
	}

}
