/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.JIT.Core.IPSJITPortletType;
import SA.SRFDA.PS.Core.JIT.CtrlHandler.IPSJITCtrlHandler;
import SA.SRFDA.PS.Core.JIT.CtrlModel.IPSJITCtrlModel;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Core.Res.IPSSysPortlet;
import SA.SRFDA.PS.Data.PSPortletType;
import SA.SRFDA.PS.Data.PSSysPortlet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSPortletTypeImpl
extends PSObjectImpl
implements IPSPortletType,
IPSJITPortletType {
    protected PSPortletType psPortletType = null;
    private static final Log log = LogFactory.getLog(PSPortletTypeImpl.class);
    private Properties baseClassParams = null;
    private boolean bSysPortlet = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSPortletType psPortletType) throws Exception {
        this.psPortletType = psPortletType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psPortletType.getPSPORTLETTYPEID());
        this.setName(psPortletType.getPSPORTLETTYPENAME());
        this.setPSObjectData(this.psPortletType);
        this.baseClassParams = PropertiesHelper.Load((String)this.psPortletType.getBASECLSPARAMS());
        this.bSysPortlet = !this.psPortletType.isSYSPORTLETFLAGNull() ? this.psPortletType.getSYSPORTLETFLAG() : !StringHelper.isNullOrEmpty((String)this.psPortletType.getPORTLETOBJ());
        this.onInit();
    }

    @Override
    public IPSSysPortlet createPSSysPortlet(PSSysPortlet psSysPortlet) throws Exception {
        return (IPSSysPortlet)ObjectHelper.Create((String)this.psPortletType.getSYSPORTLETOBJ());
    }

    @Override
    public IPSDBPortletPart createPSPortlet() throws Exception {
        return (IPSDBPortletPart)ObjectHelper.Create((String)this.psPortletType.getPORTLETOBJ());
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getBaseClass(String strPSSFStyleId) throws Exception {
        String strBaseClass = PropertiesHelper.GetProperty((Properties)this.baseClassParams, (String)strPSSFStyleId);
        if (StringHelper.isNullOrEmpty((String)strBaseClass) && this.baseClassParams != null) {
            for (Object objKey : this.baseClassParams.keySet()) {
                String strKey = (String)objKey;
                if (strPSSFStyleId.indexOf(strKey) != 0) continue;
                strBaseClass = PropertiesHelper.GetProperty((Properties)this.baseClassParams, (String)strKey);
                break;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)strBaseClass)) {
            strBaseClass = strBaseClass.trim();
        }
        if (StringHelper.isNullOrEmpty((String)strBaseClass)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u95e8\u6237\u90e8\u4ef6\u7c7b\u578b[%1$s]\u670d\u52a1\u6846\u67b6[%2$s]\u57fa\u7c7b", (Object)this.getName(), (Object)strPSSFStyleId));
        }
        return strBaseClass;
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        String strId = StringHelper.format((String)"%1$s.%2$s", (Object)strCodeType, (Object)iPSSysSFPub.getPSSFStyle().getId());
        return this.getBaseClass(strId);
    }

    @Override
    public String getCodeName() {
        return null;
    }

    @Override
    public IPSJITCtrlModel createPSJITCtrlModel(IPSControl iPSControl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psPortletType.getJITMODELOBJ())) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u95e8\u6237[%1$s]\u90e8\u4ef6\u5373\u65f6\u6a21\u578b\u5bf9\u8c61", (Object)this.getId()));
        }
        IPSJITCtrlModel iPSJITCtrlModel = (IPSJITCtrlModel)ObjectHelper.Create((String)this.psPortletType.getJITMODELOBJ());
        return iPSJITCtrlModel;
    }

    @Override
    public IPSJITCtrlHandler createPSJITCtrlHandler(IPSControl iPSControl) throws Exception {
        if (StringHelper.isNullOrEmpty((String)this.psPortletType.getJITCTRLOBJ())) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u95e8\u6237[%1$s]\u90e8\u4ef6\u5373\u65f6\u5904\u7406\u5bf9\u8c61", (Object)this.getId()));
        }
        IPSJITCtrlHandler iPSJITCtrlHandler = (IPSJITCtrlHandler)ObjectHelper.Create((String)this.psPortletType.getJITCTRLOBJ());
        return iPSJITCtrlHandler;
    }

    @Override
    public boolean isSysPortlet() {
        return this.bSysPortlet;
    }
}

