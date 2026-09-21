/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery
 *  net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.Pub.PSPublishContextImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDEDataQueryJoin;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDEDataQueryDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDEDataQueryDataCtrl.class);
    public static final String CUSTOMCALL_GENERATECODE = "GENERATECODE";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        try {
            if (!bInsert) {
                String strLastXML;
                SA.SRFDA.PS.Data.PSDEDataQuery psDEDataQuery = new SA.SRFDA.PS.Data.PSDEDataQuery();
                psDEDataQuery.proxy(dataEntity);
                String strXML = dataEntity.getParamStringValue("DQJOINMODEL", "");
                if (lastDataEntity != null && StringHelper.Compare((String)strXML, (String)(strLastXML = lastDataEntity.getParamStringValue("DQJOINMODEL", "")), (boolean)true) != 0) {
                    HashMap<String, PSDEDataQueryJoin> validMap = new HashMap<String, PSDEDataQueryJoin>();
                    XMLNode xmlNode = XMLNode.LoadFromXML((String)strXML);
                    this.modifyLayoutFromXML(xmlNode, psDEDataQuery, validMap);
                    BaseDataEntity cond = new BaseDataEntity();
                    cond.setParamValue("PSDEDQID", (Object)psDEDataQuery.getPSDEDATAQUERYID());
                    Vector psDEDataQueryJoinList = new Vector();
                    IDEDataCtrl psDEDataQueryJoinDataCtrl = this.GetRelatedDataCtrl("DE2058");
                    callResult = psDEDataQueryJoinDataCtrl.Select(cond, psDEDataQueryJoinList, PSDEDataQueryJoin.class.getName());
                    if (callResult.isError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u67e5\u8be2\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                    for (PSDEDataQueryJoin psDEDataQueryJoin : psDEDataQueryJoinList) {
                        if (validMap.containsKey(psDEDataQueryJoin.getPSDEDQJOINID()) || this.CheckKeyState2(psDEDataQueryJoin) != 1 || !(callResult = psDEDataQueryJoinDataCtrl.Remove((BaseDataEntity)psDEDataQueryJoin)).isError()) continue;
                        throw new Exception(StringHelper.Format((String)"\u5220\u9664\u6570\u636e\u67e5\u8be2\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                    }
                }
                XMLNode xmlNode = this.fillLayoutXMLNode(null, psDEDataQuery);
                StringBuilder sb = new StringBuilder();
                SimpleXMLWriter writer = new SimpleXMLWriter(sb);
                writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
                xmlNode.Save(writer);
                dataEntity.setParamValue("DQJOINMODEL", (Object)sb.toString());
            }
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage(), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }

    protected void modifyLayoutFromXML(XMLNode xmlNode, SA.SRFDA.PS.Data.PSDEDataQuery psDEDataQuery, HashMap<String, PSDEDataQueryJoin> validMap) throws Exception {
        ArrayList xmlNodes = xmlNode.getChildNodes();
        if (xmlNodes == null) {
            return;
        }
        IDEDataCtrl psDEDataQueryJoinDataCtrl = this.GetRelatedDataCtrl("DE2058");
        String strPNodeId = xmlNode.getID();
        int nIndex = 100;
        for (XMLNode childNode : xmlNodes) {
            String strNodeId = childNode.getID();
            nIndex += 10;
            PSDEDataQueryJoin realItem = new PSDEDataQueryJoin();
            realItem.setPSDEDQID(psDEDataQuery.getPSDEDATAQUERYID());
            if (!StringHelper.IsNullOrEmpty((String)strNodeId)) {
                realItem.setPSDEDQJOINID(strNodeId);
            } else {
                String strJoinType = childNode.GetExtValue("JOINTYPE", "").toUpperCase();
                realItem.setPSDEJOINTYPEID(strJoinType);
                String strDEName = childNode.GetExtValue("DENAME", "").toUpperCase();
                PSDataEntity psDataEntity = new PSDataEntity();
                psDataEntity.setPSDATAENTITYID(psDEDataQuery.getPSDEID());
                IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
                CallResult callResult = psDataEntityDataCtrl.Get((BaseDataEntity)psDataEntity);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                String strPSSystemId = psDataEntity.getPSSYSTEMID();
                psDataEntity.Reset();
                psDataEntity.setPSDATAENTITYNAME(strDEName);
                psDataEntity.setPSSYSTEMID(strPSSystemId);
                callResult = psDataEntityDataCtrl.Select((BaseDataEntity)psDataEntity);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4e91\u5b9e\u4f53[%1$s]", (Object)strDEName));
                }
                realItem.setJOINPSDEID(psDataEntity.getPSDATAENTITYID());
                realItem.setJOINPSDENAME(psDataEntity.getPSDATAENTITYNAME());
            }
            if (!StringHelper.IsNullOrEmpty((String)strPNodeId)) {
                realItem.setPPSDEDQJOINID(strPNodeId);
            }
            realItem.setParamValue("ORDERVALUE", nIndex);
            CallResult callResult = psDEDataQueryJoinDataCtrl.Save(StringHelper.IsNullOrEmpty((String)strNodeId), (BaseDataEntity)realItem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u4fee\u6539\u6570\u636e\u67e5\u8be2\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            childNode.setID(realItem.getPSDEDQJOINID());
            validMap.put(realItem.getPSDEDQJOINID(), realItem);
            this.modifyLayoutFromXML(childNode, psDEDataQuery, validMap);
        }
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, SA.SRFDA.PS.Data.PSDEDataQuery psDEDataQuery) throws Exception {
        if (xmlNode == null) {
            xmlNode = new XMLNode();
            xmlNode.setNodeName("DEDATAQUERY");
        }
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSDEDQID", (Object)psDEDataQuery.getPSDEDATAQUERYID());
        Vector psDEDataQueryJoinList = new Vector();
        IDEDataCtrl psDEDataQueryJoinDataCtrl = this.GetRelatedDataCtrl("DE2058");
        CallResult callResult = psDEDataQueryJoinDataCtrl.Select(cond, psDEDataQueryJoinList, PSDEDataQueryJoin.class.getName(), "ORDER BY ORDERVALUE");
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u67e5\u8be2\u8fde\u63a5\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDEDataQueryJoin> psDEDataQueryJoinMap = new HashMap<String, PSDEDataQueryJoin>();
        for (PSDEDataQueryJoin psDEDataQueryJoin : psDEDataQueryJoinList) {
            psDEDataQueryJoinMap.put(psDEDataQueryJoin.getPSDEDQJOINID(), psDEDataQueryJoin);
        }
        for (PSDEDataQueryJoin psDEDataQueryJoin : psDEDataQueryJoinList) {
            if (StringHelper.IsNullOrEmpty((String)psDEDataQueryJoin.getPPSDEDQJOINID())) continue;
            PSDEDataQueryJoin parentPSDEDataQueryJoin = (PSDEDataQueryJoin)((Object)psDEDataQueryJoinMap.get(psDEDataQueryJoin.getPPSDEDQJOINID()));
            parentPSDEDataQueryJoin.getChildPSDEDataQueryJoins(true).add(psDEDataQueryJoin);
        }
        int nValue = 0;
        for (PSDEDataQueryJoin psDEDataQueryJoin : psDEDataQueryJoinList) {
            if (!StringHelper.IsNullOrEmpty((String)psDEDataQueryJoin.getPPSDEDQJOINID())) continue;
            String strOrderString = PSDEDataQueryDataCtrl.getOrderString(++nValue);
            String strOrderString2 = PSDEDataQueryDataCtrl.getFullOrderString(strOrderString, 40);
            psDEDataQueryJoin.setLEVELTAG(strOrderString2);
            psDEDataQueryJoin.setLEVELVALUE(strOrderString.length() / 2 - 1);
            xmlNode.SetExtValue("ORDERTAG", strOrderString);
            psDEDataQueryJoinDataCtrl.Save(false, (BaseDataEntity)psDEDataQueryJoin);
            this.fillLayoutXMLNode(xmlNode, psDEDataQueryJoin);
        }
        return xmlNode;
    }

    protected XMLNode fillLayoutXMLNode(XMLNode xmlNode, PSDEDataQueryJoin psDEDataQueryJoin) throws Exception {
        XMLNode childXmlNode = new XMLNode();
        childXmlNode.setNodeName("DEDQJOIN");
        childXmlNode.SetProperty("ID", psDEDataQueryJoin.getPSDEDQJOINID());
        childXmlNode.SetProperty("NAME", psDEDataQueryJoin.getPSDEDQJOINNAME());
        xmlNode.AddNode(childXmlNode);
        ArrayList<PSDEDataQueryJoin> childPSDEDataQueryJoinList = psDEDataQueryJoin.getChildPSDEDataQueryJoins(false);
        if (childPSDEDataQueryJoinList != null) {
            int nValue = 0;
            IDEDataCtrl psDEDataQueryJoinDataCtrl = this.GetRelatedDataCtrl("DE2058");
            for (PSDEDataQueryJoin childPSDEDataQueryJoin : childPSDEDataQueryJoinList) {
                String strOrderString = String.valueOf(xmlNode.GetExtValue("ORDERTAG", "")) + PSDEDataQueryDataCtrl.getOrderString(++nValue);
                String strOrderString2 = PSDEDataQueryDataCtrl.getFullOrderString(strOrderString, 40);
                childPSDEDataQueryJoin.setLEVELTAG(strOrderString2);
                childPSDEDataQueryJoin.setLEVELVALUE(strOrderString.length() / 2 - 1);
                childXmlNode.SetExtValue("ORDERTAG", strOrderString);
                psDEDataQueryJoinDataCtrl.Save(false, (BaseDataEntity)childPSDEDataQueryJoin);
                this.fillLayoutXMLNode(childXmlNode, childPSDEDataQueryJoin);
            }
        }
        return childXmlNode;
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        SA.SRFDA.PS.Data.PSDEDataQuery psDEDataQuery = new SA.SRFDA.PS.Data.PSDEDataQuery();
        psDEDataQuery.proxy(dataEntity);
        try {
            if (bInsert) {
                PSDEDataQueryJoin psDEDataQueryJoin = new PSDEDataQueryJoin();
                psDEDataQueryJoin.setPSDEDQID(psDEDataQuery.getPSDEDATAQUERYID());
                psDEDataQueryJoin.setPSDEDQNAME(psDEDataQuery.getPSDEDATAQUERYNAME());
                psDEDataQueryJoin.setJOINPSDEID(psDEDataQuery.getPSDEID());
                psDEDataQueryJoin.setJOINPSDENAME(psDEDataQuery.getPSDENAME());
                psDEDataQueryJoin.setMAINFLAG(true);
                psDEDataQueryJoin.setPSDEJOINTYPEID("MAIN");
                IDEDataCtrl psDEDataQueryJoinDataCtrl = this.GetRelatedDataCtrl("DE2058");
                callResult = psDEDataQueryJoinDataCtrl.Save(true, (BaseDataEntity)psDEDataQueryJoin);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u5efa\u7acb\u9ed8\u8ba4\u4e3b\u67e5\u8be2\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GENERATECODE, (boolean)true) == 0) {
            return this.generateCode(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult generateCode(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            SA.SRFDA.PS.Data.PSDEDataQuery psDEDataQuery = new SA.SRFDA.PS.Data.PSDEDataQuery();
            psDEDataQuery.proxy(dataEntity);
            this.onGenerateCode(psDEDataQuery);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u751f\u6210\u67e5\u8be2\u4ee3\u7801\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onGenerateCode(SA.SRFDA.PS.Data.PSDEDataQuery psDEDataQuery) throws Exception {
        IPSDataEntity iPSDataEntity = null;
        IPSDEDataQuery iPSDEDataQuery = null;
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psDEDataQuery.getParamStringValue("PSDEVSLNSYSID", "");
        if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            iPSDataEntity = this.getPSModelStorage().getPSDataEntity(psDEDataQuery.getPSDEID());
            iPSDEDataQuery = iPSDataEntity.getPSDEDataQuery(psDEDataQuery.getPSDEDATAQUERYID());
            iPSSystem = iPSDataEntity.getPSSystem();
        } else {
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            iPSSystem = iPSDevSlnSys.getPSSystem(false);
            PSDEDataQuery psDEDataQuery2 = new PSDEDataQuery();
            psDEDataQuery2.setPSDEDataQueryId(psDEDataQuery.getPSDEDATAQUERYID());
            PSDEDataQueryService psDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
            psDEDataQueryService.get((IEntity)psDEDataQuery2);
            iPSDataEntity = iPSSystem.getPSDataEntity2(psDEDataQuery2.getPSDEId());
            iPSDEDataQuery = iPSDataEntity.getPSDEDataQuery(psDEDataQuery2.getPSDEDataQueryId());
        }
        Iterator<String> dbTypes = iPSSystem.getSupportDBTypes();
        while (dbTypes.hasNext()) {
            String strDBType = dbTypes.next();
            IPSDEDBConfig iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(strDBType);
            if (!iPSDEDBConfig.isValidFlag()) continue;
            PSPublishContextImpl psPublishContextImpl = new PSPublishContextImpl((IDEDataCtrl)this);
            IPSDBType iDBType = this.getPSModelStorage().getPSDBType(strDBType);
            IPSDEDQCodePublisher iPSDEDQCodePublisher = iDBType.getPSDEDQCodePublisher();
            iPSDEDQCodePublisher.generateCode(psPublishContextImpl, iPSDEDataQuery);
            iPSDEDQCodePublisher.close();
        }
    }
}

