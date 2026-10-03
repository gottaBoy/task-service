package net.ibizsys.paas.ctrlmodel;

/**
 * 动态网页门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class DynaHtmlPortletModelBase extends DynaPortletModelBase {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_HTML;
	}
}
