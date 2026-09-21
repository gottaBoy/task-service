/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.action.IPSDEAction
 *  net.ibizsys.model.dataentity.logic.IPSDELogic
 *  net.ibizsys.model.dataentity.logic.IPSDELogicLink
 *  net.ibizsys.model.dataentity.logic.IPSDELogicNodeParam
 *  net.ibizsys.model.dataentity.logic.IPSDELogicParam
 *  net.ibizsys.model.dataentity.wf.IPSDEWF
 *  net.ibizsys.model.wf.IPSWorkflow
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.logic;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.logic.IPSDELogic;
import net.ibizsys.model.dataentity.logic.IPSDELogicLink;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeParam;
import net.ibizsys.model.dataentity.logic.IPSDELogicNodeRuntime;
import net.ibizsys.model.dataentity.logic.IPSDELogicParam;
import net.ibizsys.model.dataentity.logic.PSDELogicLinkImpl;
import net.ibizsys.model.dataentity.logic.PSDELogicNodeParamImpl;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.entity.PSDELogicLink;
import net.ibizsys.model.entity.PSDELogicNode;
import net.ibizsys.model.entity.PSDELogicNodeParam;
import net.ibizsys.model.wf.IPSWorkflow;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDELogicNodeImpl
extends PSObjectImpl
implements IPSDELogicNodeRuntime {
    private static final Log log = LogFactory.getLog(PSDELogicNodeImpl.class);
    protected IPSDELogic iPSDELogic;
    protected PSDELogicNode psDELogicNode;
    protected ArrayList<IPSDELogicLink> psDELogicLinkList = new ArrayList();
    protected ArrayList<IPSDELogicNodeParam> psDELogicNodeParamList = new ArrayList();
    protected IPSDataEntity dstPSDataEntity = null;
    protected IPSDEAction dstPSDEAction = null;
    protected IPSDELogicParam dstLogicParam = null;
    protected IPSDELogicParam srcLogicParam = null;
    private IPSWorkflow iPSWorkflow = null;
    private IPSDEWF iPSDEWF = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDELogic iPSDELogic, PSDELogicNode psDELogicNode) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.iPSDELogic = iPSDELogic;
            this.psDELogicNode = psDELogicNode;
            this.setId(this.psDELogicNode.getPSDELOGICNODEID());
            this.setName(this.psDELogicNode.getPSDELOGICNODENAME());
            this.setPSObjectData(this.psDELogicNode);
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEID())) {
                this.dstPSDataEntity = StringHelper.compare((String)this.psDELogicNode.getDSTPSDEID(), (String)this.iPSDELogic.getPSDataEntity().getId(), (boolean)false) != 0 ? this.iPSDELogic.getPSDataEntity().getPSSystem().getPSDataEntity(this.psDELogicNode.getDSTPSDEID()) : this.iPSDELogic.getPSDataEntity();
                if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDEACTIONID())) {
                    this.dstPSDEAction = this.dstPSDataEntity.getPSDEAction(this.psDELogicNode.getDSTPSDEACTIONID());
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getDSTPSDLPARAMID())) {
                this.dstLogicParam = this.iPSDELogic.getPSDELogicParam(this.psDELogicNode.getDSTPSDLPARAMID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getSRCPSDLPARAMID())) {
                this.srcLogicParam = this.iPSDELogic.getPSDELogicParam(this.psDELogicNode.getSRCPSDLPARAMID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSWORKFLOWID())) {
                this.iPSWorkflow = this.getPSDELogic().getPSDataEntity().getPSSystem().getPSWorkflow(this.psDELogicNode.getPSWORKFLOWID());
                if (!StringHelper.isNullOrEmpty((String)this.psDELogicNode.getPSWFDEID())) {
                    this.iPSDEWF = this.iPSWorkflow.getPSDEWF(this.psDELogicNode.getPSWFDEID());
                }
            }
            this.onInit();
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
            iPSDELogicLink.init(this.getPSModelStorageContext(), this.iPSDELogic, psDELogicLink);
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
            iPSDELogicNodeParam.init(this.getPSModelStorageContext(), this, psDELogicNodeParam);
            this.psDELogicNodeParamList.add(iPSDELogicNodeParam);
        }
    }

    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u8fde\u51fa\u8fde\u63a5\u96c6\u5408")
    public Iterator<IPSDELogicLink> getPSDELogicLinks() {
        if (this.psDELogicLinkList == null || this.psDELogicLinkList.size() == 0) {
            return null;
        }
        return this.psDELogicLinkList.iterator();
    }

    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u7c7b\u578b", codelist="DELogicNodeType")
    public String getLogicNodeType() {
        return this.psDELogicNode.getLOGICNODETYPE();
    }

    public IPSDELogic getPSDELogic() {
        return this.iPSDELogic;
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.psDELogicNode.getCODENAME();
    }

    @PSModelRTMeta(description="\u5e73\u884c\u8f93\u51fa")
    public boolean isParallelOutput() {
        return this.psDELogicNode.getPARALLELOUTPUT();
    }

    @PSModelRTMeta(description="\u903b\u8f91\u8282\u70b9\u53c2\u6570\u96c6\u5408")
    public Iterator<IPSDELogicNodeParam> getPSDELogicNodeParams() {
        if (this.psDELogicNodeParamList == null || this.psDELogicNodeParamList.size() == 0) {
            return null;
        }
        return this.psDELogicNodeParamList.iterator();
    }

    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u5bf9\u8c61", hideempty=true)
    public IPSDataEntity getDstPSDataEntity() throws Exception {
        return this.dstPSDataEntity;
    }

    @PSModelRTMeta(description="\u76ee\u6807\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true)
    public IPSDEAction getDstPSDEAction() throws Exception {
        return this.dstPSDEAction;
    }

    @PSModelRTMeta(description="\u76ee\u6807\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true)
    public IPSDELogicParam getDstPSDELogicParam() throws Exception {
        return this.dstLogicParam;
    }

    @PSModelRTMeta(description="\u6e90\u903b\u8f91\u53c2\u6570\u5bf9\u8c61", hideempty=true)
    public IPSDELogicParam getSrcPSDELogicParam() throws Exception {
        return this.srcLogicParam;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.getPSDELogic());
    }

    public Object getParam(String strParamName, Object objDefault) {
        try {
            Object objValue = this.psDELogicNode.get(strParamName);
            if (objValue == null) {
                return objDefault;
            }
            return objValue;
        }
        catch (Exception e) {
            log.error((Object)e);
            return objDefault;
        }
    }

    @PSModelRTMeta(description="\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true)
    public IPSWorkflow getPSWorkflow() throws Exception {
        return this.iPSWorkflow;
    }

    @PSModelRTMeta(description="\u5b9e\u4f53\u5de5\u4f5c\u6d41\u5bf9\u8c61", hideempty=true)
    public IPSDEWF getPSDEWF() throws Exception {
        return this.iPSDEWF;
    }
}

