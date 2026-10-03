package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.ITreeGridModel;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;

/**
 * 树表处理对象
 * 
 * @author lionlau
 *
 */
public abstract class TreeGridHandlerBase extends GridHandlerBase {
	/**
	 * 获取当前的树表格模型
	 * 
	 * @return
	 */
	protected ITreeGridModel getTreeGridModel() {
		return (ITreeGridModel) this.getGridModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getTreeGridModel();
	}

	@Override
	protected void onFillFetchParentCondition(ArrayList<IDEDataSetCond> userConditions) throws Exception {
		super.onFillFetchParentCondition(userConditions);

		// 判断有无指定上级数据
		String strParentKey2 = WebContext.getParentKey2(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strParentKey2)) {
			IDEField iDEFieldModel = this.getDEModel().getDEField(getTreeGridModel().getParentDEField(), false);
			DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
			deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
			deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
			deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
			deDataSetCondImpl.setCondValue(strParentKey2);
			userConditions.add(deDataSetCondImpl);
		}
	}
}
