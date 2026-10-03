package net.ibizsys.paas.ctrlmodel;

/**
 * 网页门户部件模型
 * 
 * @author lionlau
 *
 */
public abstract class HtmlPortletModelBase extends PortletModelBase {
	@Override
	public String getPortletType() {
		return PORTLETTYPE_HTML;
	}
}
