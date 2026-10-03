package net.ibizsys.paas.web.util;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;

/**
 * 上传文件页面
 * 
 * @author LionLau
 *
 */
public class UploadFileViewPage extends Page {

	protected String getFileType() {
		return this.getWebContext().getParamValue("FILETYPE");
	}

	protected int getFileCount() {
		String strFileCount = this.getWebContext().getParamValue("FIELCOUNT");
		if (StringHelper.isNullOrEmpty(strFileCount)) return 0;
		return Integer.parseInt(strFileCount);
	}

	// protected String OnGetFileUploadUrl()
	// {
	// this.getWebContext().SetParamValue(SRFDAWebContext.TAG_SRFPAGEMODEL,this.getPageModel());
	// return "../srfpage/uploadfilemodel.jsp?"+this.getWebContext().GetQueryString();
	// }
	//
	//
	//
	//
	// /* (non-Javadoc)
	// * @see SA.SRFDA.Web.Default.BaseMainPage#OnGetPageTitle()
	// */
	// @Override
	// protected String OnGetPageTitle()
	// {
	// return this.GetLocalization("PAGE.HEADER.UPLOADVIEW","上传文件视图");
	// }
}
