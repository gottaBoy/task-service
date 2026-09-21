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

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETree;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNode;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRS;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSNavContext;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSNavParam;
import SA.SRFDA.PS.Core.Control.Tree.IPSDETreeNodeRSParam;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeRSNavContextImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeRSNavParamImpl;
import SA.SRFDA.PS.Core.Control.Tree.PSDETreeNodeRSParamImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDETreeNodeRS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETreeNodeRSImpl
extends PSObjectImpl
implements IPSDETreeNodeRS {
    private static final Log log = LogFactory.getLog(PSDETreeNodeRSImpl.class);
    private IPSDETree iPSDETree = null;
    protected PSDETreeNodeRS psDETreeNodeRS = null;
    private IPSDEAction iPSDEAction = null;
    private int bSearchMode = 3;
    private int nPValueLevel = 1;
    private IPSDER1N pValuePSDER1N = null;
    private String strParentFilter = null;
    private Map<String, IPSDETreeNodeRSNavContext> psDETreeNodeRSNavContextMap = null;
    private Map<String, IPSDETreeNodeRSNavParam> psDETreeNodeRSNavParamMap = null;
    private Map<String, IPSDETreeNodeRSParam> psDETreeNodeRSParamMap = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDETree iPSDETree, PSDETreeNodeRS psDETreeNodeRS) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDETree(iPSDETree);
            this.psDETreeNodeRS = psDETreeNodeRS;
            this.setId(this.psDETreeNodeRS.getPSDETREENODERSID());
            this.setName(this.psDETreeNodeRS.getPSDETREENODERSNAME());
            this.setPSObjectData(psDETreeNodeRS);
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNodeRS.getPSDEACTIONID())) {
                this.iPSDEAction = this.getPSDETree().getPSDataEntity().getPSDEAction(this.psDETreeNodeRS.getPSDEACTIONID());
            }
            if (!psDETreeNodeRS.isSEARCHMODENull()) {
                this.bSearchMode = psDETreeNodeRS.getSEARCHMODE();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNodeRS.getPSDERID())) {
                IPSDERBase iPSDERBase = this.getPSDETree().getPSAppView().getPSSystem().getPSDER(this.psDETreeNodeRS.getPSDERID());
                if (!(iPSDERBase instanceof IPSDER1N)) {
                    throw new Exception(StringHelper.format((String)"\u6307\u5b9a\u7236\u503c\u5173\u7cfb[%1$s]\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a1:N\u62161:1\u5173\u7cfb", (Object)iPSDERBase.getName()));
                }
                this.pValuePSDER1N = (IPSDER1N)iPSDERBase;
                if (!this.psDETreeNodeRS.isPVALUELEVELNull()) {
                    this.nPValueLevel = this.psDETreeNodeRS.getPVALUELEVEL();
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDETreeNodeRS.getCHILDFILTER())) {
                this.strParentFilter = this.psDETreeNodeRS.getCHILDFILTER();
            }
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
        this.onPrepareProcessParams();
        super.onInit();
    }

    protected void onPrepareProcessParams() throws Exception {
        Properties processparams;
        if (!StringHelper.isNullOrEmpty((String)this.psDETreeNodeRS.getPROCESSPARAM()) && (processparams = PropertiesHelper.load((String)this.psDETreeNodeRS.getPROCESSPARAM())) != null) {
            Enumeration<Object> keys = processparams.keys();
            while (keys.hasMoreElements()) {
                String strKey = keys.nextElement().toString();
                String strValue = PropertiesHelper.getProperty((Properties)processparams, (String)strKey);
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    boolean bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSDETreeNodeRSNavContextImpl PSDETreeNodeRSNavContextImpl2 = new PSDETreeNodeRSNavContextImpl();
                    PSDETreeNodeRSNavContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psDETreeNodeRSNavContextMap == null) {
                        this.psDETreeNodeRSNavContextMap = new LinkedHashMap<String, IPSDETreeNodeRSNavContext>();
                    }
                    this.psDETreeNodeRSNavContextMap.put(strTag, PSDETreeNodeRSNavContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    boolean bRawValue = true;
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSDETreeNodeRSNavParamImpl PSDETreeNodeRSNavParamImpl2 = new PSDETreeNodeRSNavParamImpl();
                    PSDETreeNodeRSNavParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psDETreeNodeRSNavParamMap == null) {
                        this.psDETreeNodeRSNavParamMap = new LinkedHashMap<String, IPSDETreeNodeRSNavParam>();
                    }
                    this.psDETreeNodeRSNavParamMap.put(strTag, PSDETreeNodeRSNavParamImpl2);
                    continue;
                }
                PSDETreeNodeRSParamImpl PSDETreeNodeRSParamImpl2 = new PSDETreeNodeRSParamImpl();
                PSDETreeNodeRSParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null);
                if (this.psDETreeNodeRSParamMap == null) {
                    this.psDETreeNodeRSParamMap = new LinkedHashMap<String, IPSDETreeNodeRSParam>();
                }
                this.psDETreeNodeRSParamMap.put(strTag, PSDETreeNodeRSParamImpl2);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u6811\u89c6\u56fe\u5bf9\u8c61")
    public IPSDETree getPSDETree() {
        return this.iPSDETree;
    }

    protected void setPSDETree(IPSDETree iPSDETree) {
        this.iPSDETree = iPSDETree;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDETree.getPSSysModelInstId();
    }

    @Override
    public String getPPSTreeNodeId() {
        return this.psDETreeNodeRS.getPPSDETREENODEID();
    }

    @Override
    public String getCPSTreeNodeId() {
        return this.psDETreeNodeRS.getCPSDETREENODEID();
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", dump=false)
    public int getOrderValue() {
        return this.psDETreeNodeRS.getORDERVALUE();
    }

    public String getParentTreeNodeId() {
        return this.getPPSTreeNodeId();
    }

    public String getChildTreeNodeId() {
        return this.getCPSTreeNodeId();
    }

    @Override
    @PSModelRTMeta(description="\u8fc7\u6ee4\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u7ea7\u8282\u70b9\u5bf9\u8c61", dumpref=true, from="IPSDETree", fields={"PPSDETREENODEID"})
    public IPSDETreeNode getParentPSDETreeNode() throws Exception {
        return this.getPSDETree().getPSDETreeNode(this.getPPSTreeNodeId());
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u7ea7\u8282\u70b9\u5bf9\u8c61", dumpref=true, from="IPSDETree", fields={"CPSDETREENODEID"})
    public IPSDETreeNode getChildPSDETreeNode() throws Exception {
        return this.getPSDETree().getPSDETreeNode(this.getCPSTreeNodeId());
    }

    public String getDEActionName() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().getName();
        }
        return null;
    }

    @Override
    public String getModelType() {
        return "PSDETREENODERS";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDETree().getPSAppView().getPSSystem());
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDETree().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getModelName() {
        try {
            return StringHelper.format((String)"%1$s-%2$s", (Object)this.getParentPSDETreeNode().getModelName(), (Object)this.getChildPSDETreeNode().getModelName());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return super.getModelName();
        }
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u6a21\u5f0f", codelist="TreeNodeRSSearchModes", fields={"SEARCHMODE"})
    public int getSearchMode() {
        return this.bSearchMode;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u5173\u7cfb", child=true)
    public IPSDER1N getParentPSDER1N() {
        return this.pValuePSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u7ea7\u522b", codelist="DETreeNodeRSPValueLevel", fields={"PVALUELEVEL"})
    public int getParentValueLevel() {
        return this.nPValueLevel;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u8fc7\u6ee4\u9879", fields={"CHILDFILTER"})
    public String getParentFilter() {
        return this.strParentFilter;
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDETree();
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true)
    public Iterator<IPSDETreeNodeRSParam> getPSDETreeNodeRSParams() throws Exception {
        if (this.psDETreeNodeRSParamMap == null || this.psDETreeNodeRSParamMap.size() == 0) {
            return null;
        }
        return this.psDETreeNodeRSParamMap.values().iterator();
    }

    @Override
    public Iterator<IPSDETreeNodeRSNavParam> getPSDETreeNodeRSNavParams() throws Exception {
        if (this.psDETreeNodeRSNavParamMap == null || this.psDETreeNodeRSNavParamMap.size() == 0) {
            return null;
        }
        return this.psDETreeNodeRSNavParamMap.values().iterator();
    }

    @Override
    public Iterator<IPSDETreeNodeRSNavContext> getPSDETreeNodeRSNavContexts() throws Exception {
        if (this.psDETreeNodeRSNavContextMap == null || this.psDETreeNodeRSNavContextMap.size() == 0) {
            return null;
        }
        return this.psDETreeNodeRSNavContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        return this.getPSDETreeNodeRSNavParams();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        return this.getPSDETreeNodeRSNavContexts();
    }

    @Override
    public String getFullModelName() {
        if (this.getOwnedPSControl() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getOwnedPSControl().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    @Override
    @PSModelRTMeta(description="\u7236\u5173\u7cfb\u8fde\u63a5\u5c5e\u6027", dumpref=true, from="__self__", from_method="getChildPSDETreeNodeMust().getPSAppDataEntityMust().getPSAppDEField")
    public IPSAppDEField getParentPSAppDEField() throws Exception {
        if (this.getParentPSDER1N() == null || this.getParentPSDER1N().getPSPickupDEField() == null) {
            return null;
        }
        if (this.getChildPSDETreeNode() == null || this.getChildPSDETreeNode().getPSAppDataEntity() == null) {
            return null;
        }
        return this.getChildPSDETreeNode().getPSAppDataEntity().getPSAppDEField(this.getParentPSDER1N().getPSPickupDEField().getName(), true);
    }

    @Override
    public String getModelRefId() {
        return null;
    }
}

