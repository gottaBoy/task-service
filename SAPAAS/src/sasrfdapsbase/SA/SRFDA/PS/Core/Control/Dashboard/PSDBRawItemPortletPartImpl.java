/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBRawItemPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBRawItemPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSRawItemBase;
import SA.SRFDA.PS.Core.Control.IPSRawItemContainer;
import SA.SRFDA.PS.Core.Control.IPSRawItemParam;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysResource;
import SA.SRFDA.PS.Core.Util.PSRawItemHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"RAWITEM"})
public class PSDBRawItemPortletPartImpl
extends PSDBPortletPartImpl
implements IPSDBRawItemPortletPart,
IPSRawItemContainer {
    private static final Log log = LogFactory.getLog(PSDBRawItemPortletPartImpl.class);
    private IPSDBRawItemPortletPartParam iPSDBRawItemPortletPartParam = null;
    private IPSPortletType iPSPortletType;
    private IPSSysResource iPSSysResource = null;
    private Properties rawItemParams = null;
    private IPSRawItemBase iPSRawItemBase = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDBRawItemPortletPartParam = (IPSDBRawItemPortletPartParam)iPSControlParam;
            this.setName(strName);
            this.iPSPortletType = this.getPSModelStorage().getPSPortletType(this.getPortletType());
            super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDBRawItemPortletPartParam.getPSSysResourceId())) {
            this.iPSSysResource = this.getPSSystem().getPSSysResource(this.iPSDBRawItemPortletPartParam.getPSSysResourceId());
        }
        super.onInit();
    }

    @Override
    public IPSControl getContentPSControl() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType3")
    public String getPortletType() {
        return "RAWITEM";
    }

    @Override
    public IPSPortletType getPSPortetType() {
        return this.iPSPortletType;
    }

    @Override
    public boolean isAjaxCtrl() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u7c7b\u578b", ignorert=3, codelist="ContentType")
    public String getContentType() {
        return this.iPSDBRawItemPortletPartParam.getContentType();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u7247\u5185\u5bb9", ignorert=3)
    public IPSSysImage getPSSysImage() {
        return super.getPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="Html\u5185\u5bb9", ignorert=3)
    public String getHtmlContent() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getOriHtmlContent())) {
            return this.getOriHtmlContent();
        }
        if (this.getPSSysResource() != null) {
            return this.getPSSysResource().getContent();
        }
        return "";
    }

    @Override
    public String getOriHtmlContent() {
        return this.iPSDBRawItemPortletPartParam.getHtmlContent();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9", ignorert=3)
    public String getRawContent() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getOriRawContent())) {
            return this.getOriRawContent();
        }
        if (this.getPSSysResource() != null) {
            return this.getPSSysResource().getContent();
        }
        return "";
    }

    @Override
    public String getOriRawContent() {
        return this.iPSDBRawItemPortletPartParam.getRawContent();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u8d44\u6e90")
    public IPSSysResource getPSSysResource() {
        return this.iPSSysResource;
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u9879\u9ad8\u5ea6", ignorert=3, ignoredumpvalues="0.0")
    public double getRawItemHeight() {
        return this.getHeight();
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u9879\u5bbd\u5ea6", ignorert=3, ignoredumpvalues="0.0")
    public double getRawItemWidth() {
        return this.getWidth();
    }

    @Override
    public Properties getRawItemParams() {
        return this.rawItemParams;
    }

    @Override
    public int getRawItemParam(String strRawItemParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)strRawItemParam, (int)nDefault);
    }

    @Override
    public String getRawItemParam(String strRawItemParam, String strDefault) {
        String strValue = PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)strRawItemParam, (String)strDefault);
        return strValue;
    }

    @Override
    public double getRawItemParam(String strRawItemParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)strRawItemParam, (double)fDefault);
    }

    @Override
    public boolean getRawItemParam(String strRawItemParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getRawItemParams(), (String)strRawItemParam, (boolean)bDefault);
    }

    @Override
    @PSModelRTMeta(description="\u76f4\u63a5\u5185\u5bb9\u5bf9\u8c61", child=true)
    public IPSRawItemBase getPSRawItem() throws Exception {
        if (this.iPSRawItemBase == null) {
            this.iPSRawItemBase = PSRawItemHelper.createPSRawItemBase(this.getDAGlobalHelper(), this, null);
        }
        return this.iPSRawItemBase;
    }

    @Override
    public String getRawItemName() {
        return this.getName();
    }

    @Override
    public String getCaption() {
        return null;
    }

    @Override
    public String getContent() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getOriRawContent())) {
            return this.getOriRawContent();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getOriHtmlContent())) {
            return this.getOriHtmlContent();
        }
        return null;
    }

    @Override
    public String getRawItemStyle() {
        return null;
    }

    @Override
    public String getRawItemCssStyle() {
        return null;
    }

    @Override
    public String getRawItemDynaClass() {
        return null;
    }

    @Override
    public String getPredefinedType() {
        return null;
    }

    @Override
    public String getRenderMode() {
        return null;
    }

    @Override
    public boolean isTemplateMode() {
        return false;
    }

    @Override
    public Iterator<? extends IPSRawItemParam> getPSRawItemParams() {
        return null;
    }

    @Override
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return null;
    }

    @Override
    public String getTooltip() {
        return null;
    }
}

