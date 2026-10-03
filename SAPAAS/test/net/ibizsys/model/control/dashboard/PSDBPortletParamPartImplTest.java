package net.ibizsys.model.control.dashboard;

import junit.framework.TestCase;

public class PSDBPortletParamPartImplTest extends TestCase {
    public void testMergeSysPortletAndAppMenuParameters() {
        PSDBPortletParamPartImpl target = new PSDBPortletParamPartImpl();
        PSDBPortletParamPartImpl source = new PSDBPortletParamPartImpl();
        source.setPSSysPortletId("sys-portlet");
        source.setPSAppMenuId("app-menu");
        source.setAMListStyle("list");
        source.setAMPSSysPFPluginId("plugin");

        target.merge(source);

        assertEquals("sys-portlet", target.getPSSysPortletId());
        assertEquals("app-menu", target.getPSAppMenuId());
        assertEquals("list", target.getAMListStyle());
        assertEquals("plugin", target.getAMPSSysPFPluginId());

        PSDBPortletParamPartImpl updated = new PSDBPortletParamPartImpl();
        updated.setPSSysPortletId("new-sys-portlet");
        updated.setPSAppMenuId("new-app-menu");
        target.merge(updated);

        assertEquals("new-sys-portlet", target.getPSSysPortletId());
        assertEquals("app-menu", target.getPSAppMenuId());
    }
}
