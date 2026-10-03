package net.ibizsys.paas.ctrlhandler;

/**
 * 表格后台处理对象扩展
 * （1）不支持父数据条件
 * @author Administrator
 *
 */
public class GridHandlerBase2 extends GridHandlerBase {

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#isEnableParentCondition()
	 */
	@Override
	protected boolean isEnableParentCondition() {
		return false;
	}
}
