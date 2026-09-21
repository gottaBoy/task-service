/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.DataFlow;

import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowLink;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNodeFilter;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlowNodeParam;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowLinkImpl;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowNodeFilterImpl;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.PSDEDataFlowNodeParamImpl;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogicNodeType;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Data.PSDELogicLink;
import SA.SRFDA.PS.Data.PSDELogicNode;
import SA.SRFDA.PS.Data.PSDELogicNodeParam;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEDataFlowNodeImpl
extends PSObjectImpl
implements IPSDEDataFlowNode {
    private static final Log log = LogFactory.getLog(PSDEDataFlowNodeImpl.class);
    protected IPSDEDataFlow iPSDEDataFlow;
    protected PSDELogicNode psDELogicNode;
    protected ArrayList<IPSDEDataFlowLink> psDEDataFlowLinkList = new ArrayList();
    protected ArrayList<IPSDEDataFlowNodeParam> psDEDataFlowNodeParamList = new ArrayList();
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private IPSDELogicNodeType iPSDELogicNodeType = null;
    private IPSDEDataFlowNodeFilter iPSDEDataFlowNodeFilter = null;
    private Properties nodeParams = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataFlow iPSDEDataFlow, PSDELogicNode psDELogicNode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEDataFlow = iPSDEDataFlow;
            this.psDELogicNode = psDELogicNode;
            this.setId(this.psDELogicNode.getPSDELOGICNODEID());
            this.setName(this.psDELogicNode.getPSDELOGICNODENAME());
            this.setPSObjectData(this.psDELogicNode);
            this.iPSDELogicNodeType = this.getPSModelStorage().getPSDELogicNodeType(this.getNodeType());
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getNODEPARAMS())) {
                this.nodeParams = PropertiesHelper.load((String)this.psDELogicNode.getNODEPARAMS());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSysSFPlugin(this.psDELogicNode.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSDEDataFlow().getPSDataEntity().getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
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
        if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPARAM6())) {
            ObjectNode objNode = (ObjectNode)JsonNodeHelper.fromString((String)this.psDELogicNode.getPARAM6());
            PSDEDataFlowNodeFilterImpl psDEDataFlowNodeFilterImpl = new PSDEDataFlowNodeFilterImpl();
            psDEDataFlowNodeFilterImpl.init(this.getDAGlobalHelper(), this, null, objNode);
            this.iPSDEDataFlowNodeFilter = psDEDataFlowNodeFilterImpl;
        }
        this.preparePSDEDataFLowLinks();
        this.preparePSDEDataFLowNodeParams();
    }

    protected void preparePSDEDataFLowLinks() throws Exception {
        this.psDEDataFlowLinkList.clear();
        ArrayList<PSDELogicLink> psDELogicLinkList = this.psDELogicNode.getPSDELogicLinks(false);
        if (psDELogicLinkList == null) {
            return;
        }
        for (PSDELogicLink psDELogicLink : psDELogicLinkList) {
            PSDEDataFlowLinkImpl iPSDEDataFlowLink = new PSDEDataFlowLinkImpl();
            iPSDEDataFlowLink.init(this.getDAGlobalHelper(), this.iPSDEDataFlow, psDELogicLink);
            this.psDEDataFlowLinkList.add(iPSDEDataFlowLink);
        }
    }

    protected void preparePSDEDataFLowNodeParams() throws Exception {
        this.psDEDataFlowNodeParamList.clear();
        ArrayList<PSDELogicNodeParam> psDELogicNodeParamList = this.psDELogicNode.getPSDELogicNodeParams(false);
        if (psDELogicNodeParamList == null) {
            return;
        }
        for (PSDELogicNodeParam psDELogicNodeParam : psDELogicNodeParamList) {
            PSDEDataFlowNodeParamImpl iPSDEDataFlowNodeParam = new PSDEDataFlowNodeParamImpl();
            iPSDEDataFlowNodeParam.init(this.getDAGlobalHelper(), this, psDELogicNodeParam);
            this.psDEDataFlowNodeParamList.add(iPSDEDataFlowNodeParam);
        }
    }

    @PSModelRTMeta(description="\u6570\u636e\u6d41\u8282\u70b9\u8fde\u51fa\u8fde\u63a5\u96c6\u5408", outputdoc="false")
    public Iterator<IPSDEDataFlowLink> getPSDEDataFlowLinks() {
        if (this.psDEDataFlowLinkList == null || this.psDEDataFlowLinkList.size() == 0) {
            return null;
        }
        return this.psDEDataFlowLinkList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6d41\u8282\u70b9\u7c7b\u578b", codelist="DELogicNodeType2", group="\u57fa\u672c", order=125, fields={"LOGICNODETYPE"})
    public String getNodeType() {
        return this.psDELogicNode.getLOGICNODETYPE();
    }

    @Override
    public IPSDEDataFlow getPSDEDataFlow() {
        return this.iPSDEDataFlow;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psDELogicNode.getCODENAME();
    }

    @PSModelRTMeta(description="\u8282\u70b9\u53c2\u6570\u96c6\u5408", child=true)
    public Iterator<IPSDEDataFlowNodeParam> getPSDEDataFlowNodeParams() {
        if (this.psDEDataFlowNodeParamList == null || this.psDEDataFlowNodeParamList.size() == 0) {
            return null;
        }
        return this.psDEDataFlowNodeParamList.iterator();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDEDataFlow().getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u6269\u5c55\u63d2\u4ef6", hideempty=true, ignorepf=true, fields={"PSSYSSFPLUGINID"})
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    public String getModelType() {
        return "PSDEDATAFLOWNODE";
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEDataFlow().getPSDataEntity().getPSSystem());
    }

    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
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
    protected IPSModelObject onGetParentModel() {
        if (this.getPSDEDataFlow() != null) {
            return this.getPSDEDataFlow();
        }
        return super.onGetParentModel();
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSDEDataFlow() != null) {
            return String.format("%1$s/%2$s", this.getPSDEDataFlow().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSDEDataFlow() != null) {
            return String.format("%1$s/%2$s", this.getPSDEDataFlow().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSDEDataFlow().getPSDataEntity().getPSSystem();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u6d41\u8282\u70b9\u8fc7\u6ee4\u5668", child=true)
    public IPSDEDataFlowNodeFilter getPSDEDataFlowNodeFilter() {
        return this.iPSDEDataFlowNodeFilter;
    }

    @Override
    @PSModelRTMeta(description="\u8282\u70b9\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"NODEPARAMS"})
    public Properties getNodeParams() {
        return this.nodeParams;
    }
}

