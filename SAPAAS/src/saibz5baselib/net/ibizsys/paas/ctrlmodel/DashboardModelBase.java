package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.Iterator;

import net.ibizsys.paas.control.ControlTypes;
import net.ibizsys.paas.control.dashboard.IPortlet;

/**
 * 门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DashboardModelBase extends CtrlModelBase implements IDashboardModel {
	private double[] columnModels = null;
	private ArrayList<IPortlet> portletList = new ArrayList<IPortlet>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.dashboard.IDashboard#getColumnModels()
	 */
	@Override
	public double[] getColumnModels() {
		return this.columnModels;
	}

	/**
	 * 设置列布局模型
	 * 
	 * @param columnModels
	 */
	protected void setColumnModels(double[] columnModels) {
		this.columnModels = columnModels;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.dashboard.IDashboard#getPortlets()
	 */
	@Override
	public Iterator<IPortlet> getPortlets() {
		return this.portletList.iterator();
	}

	/**
	 * 注册部件模型
	 * 
	 * @param iPortlet
	 */
	protected void registerPortletModel(IPortletModel iPortlet) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.control.IControl#getControlType()
	 */
	@Override
	public String getControlType() {
		return ControlTypes.Dashboard;
	}

}
