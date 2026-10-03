package net.ibizsys.paas.ctrlmodel;

/**
 * 图表门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class ChartPortletModelBase extends PortletModelBase {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_CHART;
	}
}
