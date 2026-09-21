/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogicNode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicLinkImpl;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDELogicNodeParamImpl;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysLogic;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysUtil;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicNodeImpl
extends PSObjectImpl
implements IPSDELogicNode,
IPSAppDELogicNode {
    private static final Log log = LogFactory.getLog(PSDELogicNodeImpl.class);
    protected IPSDELogic iPSDELogic;
    protected PSDELogicNode psDELogicNode;
    protected ArrayList<IPSDELogicLink> psDELogicLinkList = new ArrayList();
    protected ArrayList<IPSDELogicNodeParam> psDELogicNodeParamList = new ArrayList();
    protected IPSDataEntity dstPSDataEntity = null;
    protected IPSDEAction dstPSDEAction = null;
    protected IPSDELogicParam dstLogicParam = null;
    protected IPSDELogicParam srcLogicParam = null;
    protected IPSDELogicParam retLogicParam = null;
    protected IPSDELogicParam isLogicParam = null;
    protected IPSDELogicParam osLogicParam = null;
    protected IPSDELogicParam optLogicParam = null;
    private IPSWorkflow iPSWorkflow = null;
    private IPSDEWF iPSDEWF = null;
    private IPSSysLogic iPSSysLogic = null;
    private IPSSysUtil iPSSysUtil = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSAppDELogic iPSAppDELogic = null;
    private IPSAppDataEntity dstPSAppDataEntity = null;
    private IPSAppDEAction dstPSAppDEAction = null;
    private IPSAppWF iPSAppWF = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSDELogicNodeType iPSDELogicNodeType = null;
    private Properties nodeParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDELogic iPSDELogic, PSDELogicNode psDELogicNode) throws Exception {
        try {
            IPSAppDELogic iPSAppDELogic;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDELogic = iPSDELogic;
            this.psDELogicNode = psDELogicNode;
            this.setId(this.psDELogicNode.getPSDELOGICNODEID());
            this.setName(this.psDELogicNode.getPSDELOGICNODENAME());
            this.setPSObjectData(this.psDELogicNode);
            if (iPSDELogic instanceof IPSAppDELogic && (iPSAppDELogic = (IPSAppDELogic)iPSDELogic).getPSAppDataEntity() != null) {
                this.iPSAppDELogic = iPSAppDELogic;
            }
            this.iPSDELogicNodeType = this.getPSModelStorage().getPSDELogicNodeType(this.getLogicNodeType());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getNODEPARAMS())) {
                this.nodeParams = PropertiesHelper.load((String)this.psDELogicNode.getNODEPARAMS());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getDSTPSDEID())) {
                this.dstPSDataEntity = SA.SRFramework.Utility.StringHelper.Compare((String)this.psDELogicNode.getDSTPSDEID(), (String)this.iPSDELogic.getPSDataEntity().getId(), (boolean)false) != 0 ? this.iPSDELogic.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDELogicNode.getDSTPSDEID()) : this.iPSDELogic.getPSDataEntity();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getDSTPSDEACTIONID())) {
                    this.dstPSDEAction = this.dstPSDataEntity.getPSDEAction(this.psDELogicNode.getDSTPSDEACTIONID());
                }
                if (this.getPSAppDELogic() != null) {
                    IPSAppDEMethod iPSAppDEMethod;
                    this.dstPSAppDataEntity = this.getPSAppDELogic().getPSAppDataEntity().getPSApplication().getPSAppDataEntity(this.dstPSDataEntity, true);
                    if (this.dstPSAppDataEntity != null && this.dstPSDEAction != null && (iPSAppDEMethod = this.dstPSAppDataEntity.getPSAppDEMethod(this.dstPSDEAction, true)) instanceof IPSAppDEAction) {
                        this.dstPSAppDEAction = (IPSAppDEAction)iPSAppDEMethod;
                    }
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getDSTPSDLPARAMID())) {
                this.dstLogicParam = this.iPSDELogic.getPSDELogicParam(this.psDELogicNode.getDSTPSDLPARAMID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getSRCPSDLPARAMID())) {
                this.srcLogicParam = this.iPSDELogic.getPSDELogicParam(this.psDELogicNode.getSRCPSDLPARAMID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getRETPSDLPARAMID())) {
                this.retLogicParam = this.iPSDELogic.getPSDELogicParam(this.psDELogicNode.getRETPSDLPARAMID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getISPSDLPARAMID())) {
                this.isLogicParam = this.iPSDELogic.getPSDELogicParam(this.psDELogicNode.getISPSDLPARAMID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getOSPSDLPARAMID())) {
                this.osLogicParam = this.iPSDELogic.getPSDELogicParam(this.psDELogicNode.getOSPSDLPARAMID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getOPTPSDLPARAMID())) {
                this.optLogicParam = this.iPSDELogic.getPSDELogicParam(this.psDELogicNode.getOPTPSDLPARAMID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPSWORKFLOWID())) {
                this.iPSWorkflow = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSWorkflow(this.psDELogicNode.getPSWORKFLOWID());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPSWFDEID())) {
                    this.iPSDEWF = this.iPSWorkflow.getPSDEWF(this.psDELogicNode.getPSWFDEID());
                }
                if (this.getPSAppDELogic() != null) {
                    this.iPSAppWF = this.getPSAppDELogic().getPSAppDataEntity().getPSApplication().getPSAppWF(this.iPSWorkflow.getId(), true);
                }
            }
            if (this.getPSAppDELogic() == null) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPSSYSDELOGICNODEID())) {
                    this.iPSSysLogic = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysLogic(this.psDELogicNode.getPSSYSDELOGICNODEID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPSSYSUTILDEID())) {
                    this.iPSSysUtil = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysUtil(this.psDELogicNode.getPSSYSUTILDEID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPSSYSSFPLUGINID())) {
                    this.iPSSysSFPlugin = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDELogicNode.getPSSYSSFPLUGINID());
                }
                if (this.getPSSysSFPlugin() != null) {
                    String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSFId());
                    IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                    if (iPSSysSFPluginTempl != null) {
                        this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                    }
                }
            } else {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPSSYSPFPLUGINID())) {
                    this.iPSSysPFPlugin = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDELogicNode.getPSSYSPFPLUGINID());
                }
                if (this.getPSSysPFPlugin() != null) {
                    String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppDELogic().getPSAppDataEntity().getPSApplication().getPSPF().getId());
                    IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSAppDELogic().getPSAppDataEntity().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                    if (iPSSysPFPluginTempl != null) {
                        HashMap<String, Object> params = new HashMap<String, Object>();
                        params.put("app", this.getPSAppDELogic().getPSAppDataEntity().getPSApplication());
                        this.iPSXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this, params);
                    }
                }
            }
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
    protected void onInit() throws Exception {
        super.onInit();
        this.preparePSDELogicLinks();
        this.preparePSDELogicNodeParams();
    }

    protected void preparePSDELogicLinks() throws Exception {
        this.psDELogicLinkList.clear();
        ArrayList<PSDELogicLink> psDELogicLinkList = this.psDELogicNode.getPSDELogicLinks(false);
        if (psDELogicLinkList == null) {
            return;
        }
        for (PSDELogicLink psDELogicLink : psDELogicLinkList) {
            PSDELogicLinkImpl iPSDELogicLink = new PSDELogicLinkImpl();
            iPSDELogicLink.init(this.getDAGlobalHelper(), this.iPSDELogic, psDELogicLink);
            this.psDELogicLinkList.add(iPSDELogicLink);
        }
    }

    protected void preparePSDELogicNodeParams() throws Exception {
        this.psDELogicNodeParamList.clear();
        ArrayList<PSDELogicNodeParam> psDELogicNodeParamList = this.psDELogicNode.getPSDELogicNodeParams(false);
        if (psDELogicNodeParamList == null) {
            return;
        }
        for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
            PSDELogicNodeParamImpl iPSDELogicNodeParam = new PSDELogicNodeParamImpl();
            iPSDELogicNodeParam.init(this.getDAGlobalHelper(), this, psDELogicNodeParam);
            this.psDELogicNodeParamList.add(iPSDELogicNodeParam);
        }
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u8fde\u51fa\u8fde\u63a5\u96c6\u5408", child=true, rtname="getLinks", outputdoc="false")
    public Iterator<IPSDELogicLink> getPSDELogicLinks() {
        if (this.psDELogicLinkList == null || this.psDELogicLinkList.size() == 0) {
            return null;
        }
        return this.psDELogicLinkList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u7c7b\u578b", codelist="DELogicNodeType2", group="\u57fa\u672c", order=125, fields={"LOGICNODETYPE"})
    public String getLogicNodeType() {
        return this.psDELogicNode.getLOGICNODETYPE();
    }

    @Override
    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDELogicNode.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u5e73\u884c\u8f93\u51fa", ignoredumpvalues="false", fields={"PARALLELOUTPUT"})
    public boolean isParallelOutput() {
        return this.psDELogicNode.getPARALLELOUTPUT();
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u53c2\u6570\u96c6\u5408", child=true)
    public Iterator<IPSDELogicNodeParam> getPSDELogicNodeParams() {
        if (this.psDELogicNodeParamList == null || this.psDELogicNodeParamList.size() == 0) {
            return null;
        }
        return this.psDELogicNodeParamList.iterator();
    }

    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return this.dstPSDataEntity;
    }

    public IPSDEAction getDstPSDEAction() throws Exception {
        return this.dstPSDEAction;
    }

    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return this.dstLogicParam;
    }

    protected void assertDstPSDELogicParam() throws Exception {
        if (this.getDstPSDELogicParam() == null) {
            throw new Exception("\u672a\u6307\u5b9a\u76ee\u6807\u903b\u8f91\u53c2\u6570");
        }
    }

    protected void assertDstPSDELogicParam(String strInfo) throws Exception {
        if (this.getDstPSDELogicParam() == null) {
            throw new Exception(strInfo);
        }
    }

    public IPSDELogicParam getSrcPSDELogicParam() throws Exception {
        return this.srcLogicParam;
    }

    protected void assertSrcPSDELogicParam() throws Exception {
        if (this.getSrcPSDELogicParam() == null) {
            throw new Exception("\u672a\u6307\u5b9a\u6e90\u903b\u8f91\u53c2\u6570");
        }
    }

    protected void assertSrcPSDELogicParam(String strInfo) throws Exception {
        if (this.getSrcPSDELogicParam() == null) {
            throw new Exception(strInfo);
        }
    }

    protected void assertSrcDstPSDELogicParamNotSame() throws Exception {
        this.assertSrcDstPSDELogicParamNotSame("\u6e90\u53c2\u6570\u548c\u76ee\u6807\u53c2\u6570\u4e0d\u80fd\u6307\u5b9a\u540c\u4e00\u4e2a\u903b\u8f91\u53c2\u6570");
    }

    protected void assertSrcDstPSDELogicParamNotSame(String strInfo) throws Exception {
        if (this.getSrcPSDELogicParam() == this.getDstPSDELogicParam()) {
            throw new Exception(strInfo);
        }
    }

    protected void assertPSDELogicNodeParams() throws Exception {
        this.assertPSDELogicNodeParams("\u672a\u6307\u5b9a\u5904\u7406\u903b\u8f91\u8282\u70b9\u53c2\u6570 ");
    }

    protected void assertPSDELogicNodeParams(String strInfo) throws Exception {
        Iterator<IPSDELogicNodeParam> psDELogicNodeParams = this.getPSDELogicNodeParams();
        if (psDELogicNodeParams != null && psDELogicNodeParams.hasNext()) {
            return;
        }
        throw new Exception(strInfo);
    }

    public IPSDELogicParam getRetPSDELogicParam() throws Exception {
        return this.retLogicParam;
    }

    protected void assertRetPSDELogicParam() throws Exception {
        if (this.getRetPSDELogicParam() == null) {
            throw new Exception("\u672a\u6307\u5b9a\u8fd4\u56de\u503c\u7ed1\u5b9a\u53c2\u6570");
        }
    }

    protected void assertRetPSDELogicParam(String strInfo) throws Exception {
        if (this.getRetPSDELogicParam() == null) {
            throw new Exception(strInfo);
        }
    }

    public IPSDELogicParam getISPSDELogicParam() throws Exception {
        return this.isLogicParam;
    }

    public IPSDELogicParam getOSPSDELogicParam() throws Exception {
        return this.osLogicParam;
    }

    public IPSDELogicParam getOptPSDELogicParam() throws Exception {
        return this.optLogicParam;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDELogic().getPSSysModelInstId();
    }

    @Override
    public Object getParam(String strParamName, Object objDefault) {
        Object objValue = this.psDELogicNode.getParamValue(strParamName);
        if (objValue == null) {
            return objDefault;
        }
        return objValue;
    }

    public IPSWorkflow getPSWorkflow() throws Exception {
        return this.iPSWorkflow;
    }

    public IPSDEWF getPSDEWF() throws Exception {
        return this.iPSDEWF;
    }

    public IPSSysLogic getPSSysLogic() throws Exception {
        return this.iPSSysLogic;
    }

    public IPSSysUtil getPSSysUtil() throws Exception {
        return this.iPSSysUtil;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, ignorepf=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDELogic() != null) {
            return "PSAPPDELOGICNODE";
        }
        return "PSDELOGICNODE";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDELogic() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDELogic().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDELogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDELogic getPSAppDELogic() {
        return this.iPSAppDELogic;
    }

    public IPSAppDataEntity getDstPSAppDataEntity() throws Exception {
        return this.dstPSAppDataEntity;
    }

    public IPSAppDEAction getDstPSAppDEAction() throws Exception {
        return this.dstPSAppDEAction;
    }

    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    public IPSAppWF getPSAppWF() {
        return this.iPSAppWF;
    }

    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getLogicHolder() {
        return this.iPSDELogicNodeType.getLogicHolder();
    }

    @Override
    @PSModelRTMeta(description="\u5de6\u4fa7\u4f4d\u7f6e", ignoredumpvalues="0", fields={"LEFTPOS"})
    public int getLeftPos() {
        return this.psDELogicNode.getLEFTPOS();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u4f4d\u7f6e", ignoredumpvalues="0", fields={"TOPPOS"})
    public int getTopPos() {
        return this.psDELogicNode.getTOPPOS();
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", ignoredumpvalues="0")
    public int getWidth() {
        return this.getDefaultWidth();
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", ignoredumpvalues="0")
    public int getHeight() {
        return this.getDefaultHeight();
    }

    protected int getDefaultWidth() {
        return 0;
    }

    protected int getDefaultHeight() {
        return 0;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"NODEPARAMS"})
    public Properties getNodeParams() {
        return this.nodeParams;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDELogic() != null) {
            return this.getPSDELogic();
        }
        return super.onGetParentModel();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSDELogic() != null) {
            return String.format("%1$s/%2$s", this.getPSDELogic().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSDELogic() != null) {
            return String.format("%1$s/%2$s", this.getPSDELogic().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }
}

