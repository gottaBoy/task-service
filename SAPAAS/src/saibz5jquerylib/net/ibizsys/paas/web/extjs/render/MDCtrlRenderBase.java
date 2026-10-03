package net.ibizsys.paas.web.extjs.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.CtrlRenderBase;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;

/**
 * 多数据绘制器
 * 
 * @author Administrator
 *
 */
public abstract class MDCtrlRenderBase extends CtrlRenderBase implements IMDCtrlRender {

	@Override
	public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {

	}

	@Override
	public String getFetchQuickSearch() {
		return null;
	}

}
