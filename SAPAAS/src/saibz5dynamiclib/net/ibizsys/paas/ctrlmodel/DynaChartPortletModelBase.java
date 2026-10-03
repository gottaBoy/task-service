package net.ibizsys.paas.ctrlmodel;

/**
 * 动态图表门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DynaChartPortletModelBase extends DynaPortletModelBase {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_CHART;
	}
}
