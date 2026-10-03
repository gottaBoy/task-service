package net.ibizsys.paas.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebConfig;

/**
 * 导出Excel文件处理页面
 * 
 * @author Administrator
 * 
 */
public class ExportExcelPage extends Page {
	public ExportExcelPage() {

	}

	@Override
	protected void onInit() throws Exception {
		super.onInit();

		String strFileName = this.getWebContext().getParamValue("FILEID");
		if (StringHelper.isNullOrEmpty(strFileName)) {
			throw new Exception(StringHelper.format("没有指定文件信息"));
		}

		String strExportType = this.getWebContext().getParamValue("EXPORTTYPE");
		String strFullFileName = "";
		try {
			String strFileSuffix = "";
			if (StringHelper.compare(strExportType, "HTML", true) == 0) {
				strFileSuffix = "htm";
				this.getResponse().setContentType("text/html;charset=GBK");
				this.getResponse().setCharacterEncoding("GBK");
				strFullFileName = StringHelper.format("%1$s%2$s%3$s%4$s.%5$s", WebConfig.getCurrent().getTempPath(), getWebContext().getSessionId(), File.separator, strFileName, strFileSuffix);
				exportGridViewHTML(strFullFileName);
			} else {
				this.getResponse().setContentType("application/vnd.ms-excel;charset=GBK");
				this.getResponse().setCharacterEncoding("GBK");
				strFileSuffix = "xls";
				strFullFileName = StringHelper.format("%1$s%2$s%3$s%4$s.%5$s", WebConfig.getCurrent().getTempPath(), getWebContext().getSessionId(), File.separator, strFileName, strFileSuffix);

				ExportFilePage.downloadFile(strFullFileName, strFileName + "." + strFileSuffix, this.getResponse());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 导出表格视图HTML
	 * 
	 * @param strFullFileName
	 */
	public void exportGridViewHTML(String strFullFileName) {
		FileInputStream fis = null;
		try {
			this.getResponse().getOutputStream().flush();
			fis = new FileInputStream(new File(strFullFileName));
			if (fis == null || fis.available() <= 0) {
				return;
			}
			byte[] bytes = new byte[fis.available()];
			int nCnt = fis.read(bytes);
			this.getResponse().getOutputStream().write(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
