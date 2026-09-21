/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Tree;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRV;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDETreeNodeRV;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeNodeRVImpl
extends PSObjectImpl
implements IPSDETreeNodeRV {
    private static final Log log = LogFactory.getLog(PSDETreeNodeRVImpl.class);
    private IPSDETreeNode iPSDETreeNode = null;
    protected PSDETreeNodeRV psDETreeNodeRV = null;
    private String strPSDEViewBaseId = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    protected IPSAppView refPSAppView = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDETreeNode iPSDETreeNode, PSDETreeNodeRV psDETreeNodeRV) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDETreeNode(iPSDETreeNode);
            this.psDETreeNodeRV = psDETreeNodeRV;
            this.setId(this.psDETreeNodeRV.getPSDETREENODERVID());
            this.setName(this.psDETreeNodeRV.getPSDETREENODERVNAME());
            this.strPSDEViewBaseId = this.psDETreeNodeRV.getPSDEVIEWBASEID();
            this.setPSObjectData(this.psDETreeNodeRV);
            this.onInit();
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
        this.onFillViewParamJO();
        super.onInit();
    }

    protected void onFillViewParamJO() throws Exception {
        Properties viewParams;
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNodeRV.getVIEWPARAMS()) && (viewParams = PropertiesHelper.load((String)this.psDETreeNodeRV.getVIEWPARAMS())) != null) {
            for (Object objKey : viewParams.keySet()) {
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)viewParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                boolean bRawValue = true;
                if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") != 0) continue;
                strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                PSNavigateParamImpl PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6811\u8282\u70b9\u5bf9\u8c61")
    public IPSDETreeNode getPSDETreeNode() {
        return this.iPSDETreeNode;
    }

    protected void setPSDETreeNode(IPSDETreeNode iPSDETreeNode) {
        this.iPSDETreeNode = iPSDETreeNode;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDETreeNode().getPSSysModelInstId();
    }

    @Override
    public String getPSDEViewBaseId() {
        return this.strPSDEViewBaseId;
    }

    @Override
    public String getViewParam() {
        return this.psDETreeNodeRV.getVIEWPARAMS();
    }

    @Override
    public String getModelType() {
        return "PSDETREENODERV";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDETreeNode().getPSDETree().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDETreeNode().getPSDETree().getModelId(), (Object)super.getModelId());
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe", dumpref=true, fields={"PSDEVIEWBASEID"})
    public IPSAppView getRefPSAppView() throws Exception {
        try {
            if (this.refPSAppView == null) {
                String strMinorPSDEViewId = this.getPSDEViewBaseId();
                boolean bTryMode = true;
                this.refPSAppView = this.getPSDETreeNode().getPSDETree().getPSAppView().getPSApplication().getPSAppViewByDEViewId(strMinorPSDEViewId, bTryMode);
            }
            return this.refPSAppView;
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u8ba1\u7b97\u5f15\u7528\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            throw ex;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }
}

