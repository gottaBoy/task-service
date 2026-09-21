/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DynaSys;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppDynaDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDETempl;
import SA.SRFDA.PS.Core.DynaSys.IPSDynaDEViewTempl;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDynaDEViewTempl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDynaDEViewTemplImpl
extends PSObjectImpl
implements IPSDynaDEViewTempl {
    private static final Log log = LogFactory.getLog(PSDynaDEViewTemplImpl.class);
    protected PSDynaDEViewTempl psDynaDEViewTempl = null;
    private IPSDynaDETempl iPSDynaDETempl = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDynaDETempl iPSDynaDETempl, PSDynaDEViewTempl psDynaDEViewTempl) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDynaDETempl = iPSDynaDETempl;
            this.psDynaDEViewTempl = psDynaDEViewTempl;
            this.setId(this.psDynaDEViewTempl.getPSDYNADEVIEWTEMPLID());
            this.setName(this.psDynaDEViewTempl.getPSDYNADEVIEWTEMPLNAME());
            this.setPSObjectData(this.psDynaDEViewTempl);
            this.onInit();
        }
        catch (Exception ex) {
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
    public IPSDynaDETempl getPSDynaDETempl() {
        return this.iPSDynaDETempl;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDynaDETempl().getPSSysModelInstId();
    }

    @Override
    public Iterator<IPSAppDynaDEView> getPSAppDynaDEViews() throws Exception {
        ArrayList<IPSAppDynaDEView> list = new ArrayList<IPSAppDynaDEView>();
        Iterator<IPSApplication> psApplications = this.getPSDynaDETempl().getPSSystem().getAllPSApps();
        while (psApplications.hasNext()) {
            String strPSAppDynaDEViewId;
            IPSApplication iPSApplication = psApplications.next();
            IPSAppView iPSAppView = iPSApplication.getPSAppView(strPSAppDynaDEViewId = KeyValueHelper.genUniqueId((String)iPSApplication.getId(), (String)this.getId()), true);
            if (iPSAppView == null || !(iPSAppView instanceof IPSAppDynaDEView)) continue;
            list.add((IPSAppDynaDEView)iPSAppView);
        }
        return list.iterator();
    }

    @Override
    public String getModelType() {
        return "PSDYNADEVIEWTEMPL";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDynaDETempl().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDynaDETempl().getPSSystem());
    }
}

