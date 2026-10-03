package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;

/**
 * 树节点获取上下文对象
 * 
 * @author Administrator
 *
 */
public class TreeNodeFetchContext implements ITreeNodeFetchContext {
	private String strNodeFilter = "";
	private boolean bAutoExpand = false;
	private String strRealNodeId = "";
	private boolean bSimpleMode = false;
	private String strCatalog = "";

	public TreeNodeFetchContext() {

	}

	public TreeNodeFetchContext(ITreeNodeFetchContext iTreeNodeFetchContext) {
		this.strNodeFilter = iTreeNodeFetchContext.getNodeFilter();
		this.bAutoExpand = iTreeNodeFetchContext.isAutoExpand();
		this.strRealNodeId = iTreeNodeFetchContext.getRealNodeId();
		this.bSimpleMode = iTreeNodeFetchContext.isSimpleMode();
		this.strCatalog = iTreeNodeFetchContext.getCatalog();
	}

	public TreeNodeFetchContext(IWebContext iWebContext) {
		strCatalog = iWebContext.getPostValue("srfcatalog");
		if (StringHelper.isNullOrEmpty(strCatalog)) {
			strCatalog = "";
		}

		strNodeFilter = iWebContext.getPostValue("srfnodefilter");
		if (StringHelper.isNullOrEmpty(strNodeFilter)) {
			strNodeFilter = "";
		}
		if (!StringHelper.isNullOrEmpty(strNodeFilter)) {
			String strAutoExpand = iWebContext.getPostValue("srfautoexpand");
			if (StringHelper.isNullOrEmpty(strAutoExpand)) strAutoExpand = "";
			bAutoExpand = (StringHelper.compare(strAutoExpand, "TRUE", true) == 0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext#getNodeFilter()
	 */
	@Override
	public String getNodeFilter() {
		return this.strNodeFilter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext#isAutoExpand()
	 */
	@Override
	public boolean isAutoExpand() {
		return this.bAutoExpand;
	}

	/**
	 * 设置是否为实际节点标识
	 * 
	 * @param strRealNodeId
	 */
	public void setRealNodeId(String strRealNodeId) {
		this.strRealNodeId = strRealNodeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext#getRealNodeId()
	 */
	@Override
	public String getRealNodeId() {
		return this.strRealNodeId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext#isSimpleMode()
	 */
	@Override
	public boolean isSimpleMode() {
		return this.bSimpleMode;
	}

	/**
	 * 设置是否为简单模式
	 * 
	 * @param bSimpleMode
	 */
	protected void setSimpleMode(boolean bSimpleMode) {
		this.bSimpleMode = bSimpleMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ITreeNodeFetchContext#getCatalog()
	 */
	@Override
	public String getCatalog() {
		return strCatalog;
	}

}
