package net.ibizsys.paas.web.jquery.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;

/**
 * JQuery Bootstrap 表格绘制器基类
 * 
 * @author Administrator
 *
 */
public abstract class BootstrapTableRenderBase extends CtrlRenderBase implements ICtrlRender, IMDCtrlRender {

	@Override
	public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		IWebContext iWebContext = WebContext.getCurrent();
		if (iWebContext == null) {
			return;

		}

		String strSort = iWebContext.getPostOrParamValue("sort");
		String strOrder = iWebContext.getPostOrParamValue("order");
		String strLimit = iWebContext.getPostOrParamValue("limit");
		String strOffset = iWebContext.getPostOrParamValue("offset");

		if (!StringHelper.isNullOrEmpty(strSort)) {
			deDataSetFetchContextImpl.setSort(strSort);
			deDataSetFetchContextImpl.setSortDir(strOrder);
		}

		int nStartRow = 0;
		if (!StringHelper.isNullOrEmpty(strOffset)) {
			nStartRow = Integer.parseInt(strOffset);
		}

		int nSize = 25;
		if (!StringHelper.isNullOrEmpty(strLimit)) {
			nSize = Integer.parseInt(strLimit);
		}

		deDataSetFetchContextImpl.setStartRow(nStartRow);
		deDataSetFetchContextImpl.setPageSize(nSize);

	}

	@Override
	public String getFetchQuickSearch() {
		IWebContext iWebContext = WebContext.getCurrent();
		if (iWebContext == null) {
			return null;

		}
		return iWebContext.getPostOrParamValue("search");
	}

}
