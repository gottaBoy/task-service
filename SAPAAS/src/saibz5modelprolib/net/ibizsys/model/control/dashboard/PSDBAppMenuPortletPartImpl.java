/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBAppMenuPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDBAppMenuPortletPartParam
 *  net.ibizsys.model.control.menu.IPSAppMenu
 *  net.ibizsys.model.res.IPSPortletType
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.dashboard;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.dashboard.IPSDBAppMenuPortletPart;
import net.ibizsys.model.control.dashboard.IPSDBAppMenuPortletPartParam;
import net.ibizsys.model.control.dashboard.PSDBPortletPartImpl;
import net.ibizsys.model.control.menu.IPSAppMenu;
import net.ibizsys.model.control.menu.PSAppMenuParamImpl;
import net.ibizsys.model.res.IPSPortletType;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBAppMenuPortletPartImpl
extends PSDBPortletPartImpl
implements IPSDBAppMenuPortletPart {
    private static final Log log = LogFactory.getLog(PSDBAppMenuPortletPartImpl.class);
    protected IPSAppMenu iPSAppMenu = null;
    private IPSDBAppMenuPortletPartParam iPSDBAppMenuPortletPartParam = null;
    private static final String APPMENU = "_appmenu";
    private IPSPortletType iPSPortletType;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDBAppMenuPortletPartParam = (IPSDBAppMenuPortletPartParam)iPSControlParam;
            this.setId(this.iPSDBAppMenuPortletPartParam.getPSAppMenuId());
            this.setName(strName);
            PSAppMenuParamImpl psAppMenuParamImpl = new PSAppMenuParamImpl();
            psAppMenuParamImpl.setPSAppMenuId(this.iPSDBAppMenuPortletPartParam.getPSAppMenuId());
            this.iPSAppMenu = (IPSAppMenu)this.registerPSControl(String.valueOf(this.getName()) + APPMENU, "APPMENU", psAppMenuParamImpl);
            this.iPSPortletType = this.getPSModelStorageContext().getPSPortletType(this.getPortletType());
            super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public IPSControl getContentPSControl() {
        return this.getPSAppMenu();
    }

    public String getPortletType() {
        return "APPMENU";
    }

    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u5bf9\u8c61")
    public IPSAppMenu getPSAppMenu() {
        return this.iPSAppMenu;
    }

    @PSModelRTMeta(description="\u5e94\u7528\u83dc\u5355\u5217\u8868\u6837\u5f0f", hideempty2=true)
    public String getAMListStyle() {
        return this.iPSDBAppMenuPortletPartParam.getAMListStyle();
    }

    @Override
    @PSModelRTMeta(description="\u62ac\u5934")
    public String getTitle() {
        if (StringHelper.isNullOrEmpty((String)super.getTitle())) {
            return this.getPSAppMenu().getName();
        }
        return super.getTitle();
    }

    @Override
    public IPSPortletType getPSPortetType() {
        return this.iPSPortletType;
    }
}

