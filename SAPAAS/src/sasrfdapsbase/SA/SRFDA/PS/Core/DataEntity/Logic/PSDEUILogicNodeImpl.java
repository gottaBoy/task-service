/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Logic;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicNode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicLink;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNode;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicNodeParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEUILogicParam;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicLinkImpl;
import SA.SRFDA.PS.Core.DataEntity.Logic.PSDEUILogicNodeParamImpl;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUILogicNodeImpl
extends PSObjectImpl
implements IPSDEUILogicNode,
IPSAppDEUILogicNode {
    private static final Log log = LogFactory.getLog(PSDEUILogicNodeImpl.class);
    protected PSDELogicNode psDELogicNode;
    protected IPSDEUILogic iPSDEUILogic;
    protected ArrayList<IPSDEUILogicLink> psDEUILogicLinkList = new ArrayList();
    protected ArrayList<IPSDEUILogicNodeParam> psDEUILogicNodeParamList = new ArrayList();
    protected IPSDataEntity dstPSDataEntity = null;
    protected IPSDEUILogicParam dstLogicParam = null;
    protected IPSDEUILogicParam srcLogicParam = null;
    protected IPSDEUILogicParam retLogicParam = null;
    private IPSAppDEUILogic iPSAppDEUILogic = null;
    protected IPSAppDataEntity dstPSAppDataEntity = null;
    protected IPSAppDEAction dstPSAppDEAction = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEUILogic iPSDEUILogic, PSDELogicNode psDELogicNode) throws Exception {
        try {
            IPSAppDEUILogic iPSAppDEUILogic;
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEUILogic = iPSDEUILogic;
            this.psDELogicNode = psDELogicNode;
            this.setId(this.psDELogicNode.getPSDELOGICNODEID());
            this.setName(this.psDELogicNode.getPSDELOGICNODENAME());
            this.setPSObjectData(this.psDELogicNode);
            if (iPSDEUILogic instanceof IPSAppDEUILogic && (iPSAppDEUILogic = (IPSAppDEUILogic)iPSDEUILogic).getPSAppDataEntity() != null) {
                this.iPSAppDEUILogic = iPSAppDEUILogic;
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getDSTPSDEID())) {
                this.dstPSDataEntity = SA.SRFramework.Utility.StringHelper.Compare((String)this.psDELogicNode.getDSTPSDEID(), (String)this.iPSDEUILogic.getPSDataEntity().getId(), (boolean)false) != 0 ? this.iPSDEUILogic.getPSDataEntity().getPSSystem().getPSDataEntity2(this.psDELogicNode.getDSTPSDEID()) : this.iPSDEUILogic.getPSDataEntity();
                if (this.getPSAppDEUILogic() != null) {
                    this.dstPSAppDataEntity = this.getPSAppDEUILogic().getPSAppDataEntity().getPSApplication().getPSAppDataEntity(this.dstPSDataEntity, true);
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getDSTPSDLPARAMID())) {
                this.dstLogicParam = this.iPSDEUILogic.getPSDEUILogicParam(this.psDELogicNode.getDSTPSDLPARAMID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getSRCPSDLPARAMID())) {
                this.srcLogicParam = this.iPSDEUILogic.getPSDEUILogicParam(this.psDELogicNode.getSRCPSDLPARAMID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getRETPSDLPARAMID())) {
                this.retLogicParam = this.iPSDEUILogic.getPSDEUILogicParam(this.psDELogicNode.getRETPSDLPARAMID());
            }
            if (this.getPSAppDEUILogic() != null) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDELogicNode.getPSSYSPFPLUGINID())) {
                    this.iPSSysPFPlugin = this.iPSDEUILogic.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDELogicNode.getPSSYSPFPLUGINID());
                }
                if (this.getPSSysPFPlugin() != null) {
                    String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSAppDEUILogic().getPSAppDataEntity().getPSApplication().getPSPF().getId());
                    IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSAppDEUILogic().getPSAppDataEntity().getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
                    if (iPSSysPFPluginTempl != null) {
                        HashMap<String, Object> params = new HashMap<String, Object>();
                        params.put("app", this.getPSAppDEUILogic().getPSAppDataEntity().getPSApplication());
                        this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this, params);
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
        this.preparePSDEUILogicLinks();
        this.preparePSDEUILogicNodeParams();
    }

    protected void preparePSDEUILogicLinks() throws Exception {
        this.psDEUILogicLinkList.clear();
        ArrayList<PSDELogicLink> psDEUILogicLinkList = this.psDELogicNode.getPSDELogicLinks(false);
        if (psDEUILogicLinkList == null) {
            return;
        }
        for (PSDELogicLink psDELogicLink : psDEUILogicLinkList) {
            PSDEUILogicLinkImpl iPSDEUILogicLink = new PSDEUILogicLinkImpl();
            iPSDEUILogicLink.init(this.getDAGlobalHelper(), this.iPSDEUILogic, psDELogicLink);
            this.psDEUILogicLinkList.add(iPSDEUILogicLink);
        }
    }

    protected void preparePSDEUILogicNodeParams() throws Exception {
        this.psDEUILogicNodeParamList.clear();
        ArrayList<PSDELogicNodeParam> psDELogicNodeParamList = this.psDELogicNode.getPSDELogicNodeParams(false);
        if (psDELogicNodeParamList == null) {
            return;
        }
        for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
            PSDEUILogicNodeParamImpl iPSDEUILogicNodeParam = new PSDEUILogicNodeParamImpl();
            iPSDEUILogicNodeParam.init(this.getDAGlobalHelper(), this, psDELogicNodeParam);
            this.psDEUILogicNodeParamList.add(iPSDEUILogicNodeParam);
        }
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u8fde\u51fa\u8fde\u63a5\u96c6\u5408", child=true, outputdoc="false")
    public Iterator<IPSDEUILogicLink> getPSDEUILogicLinks() {
        if (this.psDEUILogicLinkList == null || this.psDEUILogicLinkList.size() == 0) {
            return null;
        }
        return this.psDEUILogicLinkList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u7c7b\u578b", codelist="DEUILogicNodeType")
    public String getLogicNodeType() {
        return this.psDELogicNode.getLOGICNODETYPE();
    }

    @Override
    public IPSDEUILogic getPSDEUILogic() {
        return this.iPSDEUILogic;
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
    @PSModelRTMeta(description="\u5de6\u4fa7\u4f4d\u7f6e", ignoredumpvalues="0")
    public int getLeftPos() {
        return this.psDELogicNode.getLEFTPOS();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u65b9\u4f4d\u7f6e", ignoredumpvalues="0")
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
    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u53c2\u6570\u96c6\u5408", child=true)
    public Iterator<IPSDEUILogicNodeParam> getPSDEUILogicNodeParams() {
        if (this.psDEUILogicNodeParamList == null || this.psDEUILogicNodeParamList.size() == 0) {
            return null;
        }
        return this.psDEUILogicNodeParamList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true)
    public IPSDEUILogicParam getDstPSDEUILogicParam() throws Exception {
        return this.dstLogicParam;
    }

    @Override
    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true)
    public IPSDEUILogicParam getSrcPSDEUILogicParam() throws Exception {
        return this.srcLogicParam;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEUILogic().getPSSysModelInstId();
    }

    @Override
    public Object getParam(String strParamName, Object objDefault) {
        Object objValue = this.psDELogicNode.getParamValue(strParamName);
        if (objValue == null) {
            return objDefault;
        }
        return objValue;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDEUILogic() != null) {
            return "PSAPPDEUILOGICNODE";
        }
        return "PSDEUILOGICNODE";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDEUILogic() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDEUILogic().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEUILogic().getPSDataEntity().getPSSystem());
    }

    @Override
    public IPSAppDEUILogic getPSAppDEUILogic() {
        return this.iPSAppDEUILogic;
    }

    public IPSDataEntity getDstPSDataEntity() {
        return this.dstPSDataEntity;
    }

    protected void setDstPSDataEntity(IPSDataEntity dstPSDataEntity) {
        this.dstPSDataEntity = dstPSDataEntity;
    }

    public IPSAppDataEntity getDstPSAppDataEntity() throws Exception {
        return this.dstPSAppDataEntity;
    }

    protected void setDstPSAppDataEntity(IPSAppDataEntity dstPSAppDataEntity) {
        this.dstPSAppDataEntity = dstPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public int getLogicHolder() {
        return 2;
    }

    public IPSDEUILogicParam getRetPSDEUILogicParam() throws Exception {
        return this.retLogicParam;
    }
}

