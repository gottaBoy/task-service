package net.ibizsys.paas.web.util;

import java.io.File;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;

/**
 * 导出文件处理页面，从用户临时目录中获取文件下载
 * 
 * @author Administrator
 *
 */
public class ExportFilePage3 extends Page {
	public ExportFilePage3() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.web.Page#onInit()
	 */
	@Override
	protected void onInit() throws Exception {
		super.onInit();

		String strFileName = this.getWebContext().getParamValue("FILEID");
		if (StringHelper.isNullOrEmpty(strFileName)) {
			throw new Exception(StringHelper.format("没有指定文件信息"));
		}

		String strTempFilePath = StringHelper.format("%1$s%2$s%3$s%4$s", WebConfig.getCurrent().getTempPath(), this.getWebContext().getSessionId(), File.separator, strFileName);

		ExportFilePage.downloadFile(strTempFilePath, strFileName, this.getResponse());
	}
}
