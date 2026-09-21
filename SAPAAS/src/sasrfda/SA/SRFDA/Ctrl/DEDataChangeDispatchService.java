/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.SelectResult2
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.XML.XMLNode
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.BaseService;
import SA.SRFDA.Ctrl.Data.DEDataChg;
import SA.SRFDA.Ctrl.Data.DEDataChg2;
import SA.SRFDA.Ctrl.Data.DEDataChgDisp;
import SA.SRFDA.Ctrl.DefaultDEDataChangeDispatchParam;
import SA.SRFDA.Ctrl.IDEDataChangeDispatch;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.SelectResult2;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.XML.XMLNode;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DEDataChangeDispatchService
extends BaseService {
    private static Log log = LogFactory.getLog(DEDataChangeDispatchService.class);
    public static final String PARAM_POLLTIMER = "POLLTIMER";
    public static final String PARAM_QUERYSQL = "QUERYSQL";
    private int nPollTimer = 15000;
    private Timer pollTimer = null;
    protected Vector<IDEDataChangeDispatch> dataChangeDispatchs = new Vector();
    protected String strQuerySQL = "select t1.* from T_SRFDEDATACHG T1 ORDER BY t1.CREATEDATE ";

    @Override
    protected CallResult OnInit() {
        CallResult callResult = super.OnInit();
        if (callResult.IsError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnStart() {
        CallResult callResult = super.OnStart();
        if (callResult.IsError()) {
            return callResult;
        }
        this.nPollTimer = Integer.parseInt(this.GetServiceParam(PARAM_POLLTIMER, "15000"));
        this.strQuerySQL = this.GetServiceParam(PARAM_QUERYSQL, this.strQuerySQL);
        Vector<DEDataChgDisp> deDataChgDisps = new Vector<DEDataChgDisp>();
        callResult = this.getGlobalHelper().getDAModelHelper().GetValidDEDataChgDisps(deDataChgDisps);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        for (DEDataChgDisp deDataChgDisp : deDataChgDisps) {
            try {
                Object objDEDataChgDisp = ObjectHelper.Create((String)deDataChgDisp.getENGINEOBJECT());
                if (objDEDataChgDisp == null) {
                    throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u5bf9\u8c61[%1$s]", (Object)deDataChgDisp.getENGINEOBJECT()));
                }
                IDEDataChangeDispatch iDEDataChangeDispatch = null;
                if (!(objDEDataChgDisp instanceof IDEDataChangeDispatch)) {
                    throw new Exception(StringHelper.Format((String)"\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)deDataChgDisp.getENGINEOBJECT()));
                }
                iDEDataChangeDispatch = (IDEDataChangeDispatch)objDEDataChgDisp;
                iDEDataChangeDispatch.Init(this.getGlobalHelper(), deDataChgDisp);
                this.dataChangeDispatchs.add(iDEDataChangeDispatch);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u5bf9\u8c61[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        if (this.pollTimer == null) {
            this.pollTimer = new Timer("DEDATACHANGEDISPATCH");
            this.pollTimer.schedule((TimerTask)this, this.nPollTimer, (long)this.nPollTimer);
        }
        log.info((Object)StringHelper.Format((String)"DEDataChangeDispatchService Start"));
        return callResult;
    }

    protected void PrepareDEDataChangeDispatch() throws Exception {
        this.dataChangeDispatchs.clear();
        Vector<DEDataChgDisp> deDataChgDisps = new Vector<DEDataChgDisp>();
        CallResult callResult = this.getGlobalHelper().getDAModelHelper().GetValidDEDataChgDisps(deDataChgDisps);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u542f\u7528\u7684\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u6d3e\u53d1\u5f15\u64ce\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DEDataChgDisp deDataChgDisp : deDataChgDisps) {
            Object deDataChgDispObj = ObjectHelper.Create((String)deDataChgDisp.getENGINEOBJECT());
            if (deDataChgDispObj == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5f15\u64ce\u5bf9\u8c61[%1$s]", (Object)deDataChgDisp.getENGINEOBJECT()));
                continue;
            }
            if (!(deDataChgDispObj instanceof IDEDataChangeDispatch)) {
                log.error((Object)StringHelper.Format((String)"\u5f15\u64ce\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)deDataChgDisp.getENGINEOBJECT()));
                continue;
            }
            try {
                IDEDataChangeDispatch iDEDataChangeDispatch = (IDEDataChangeDispatch)deDataChgDispObj;
                iDEDataChangeDispatch.Init(this.getGlobalHelper(), deDataChgDisp);
                this.dataChangeDispatchs.add(iDEDataChangeDispatch);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5f15\u64ce\u5bf9\u8c61[%1$s]\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)deDataChgDisp.getENGINEOBJECT(), (Object)ex.getMessage()));
            }
        }
    }

    @Override
    protected CallResult OnStop() {
        log.info((Object)StringHelper.Format((String)"DEDataChangeDispatchService Stop"));
        if (this.pollTimer != null) {
            this.pollTimer.cancel();
            this.pollTimer = null;
        }
        this.dataChangeDispatchs.clear();
        return super.OnStop();
    }

    @Override
    protected void OnRun() throws Exception {
        Vector<DEDataChg> deDataChanges;
        block25: {
            SelectResult2 selectResult = BaseDEDataCtrl.SelectMultiExReturnRS(this.iDAGlobalHelper, null, "", this.strQuerySQL, null);
            if (selectResult == null || selectResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6570\u636e\u53d1\u751f\u9519\u8bef\uff0c%1$s\r\n%2$s", (Object)(selectResult == null ? "\u672a\u77e5\u9519\u8bef" : selectResult.getErrorInfo()), (Object)this.strQuerySQL));
                return;
            }
            deDataChanges = new Vector<DEDataChg>();
            try {
                try {
                    int PAGESIZE = 500;
                    int nReadSize = selectResult.getMainTable().ReadRows(PAGESIZE);
                    int i = 0;
                    while (i < selectResult.getMainTable().GetRowCount()) {
                        DEDataChg deDataChg = new DEDataChg();
                        DataRow dr = selectResult.getMainTable().GetRow(i);
                        deDataChg.FromDataRow(dr, true);
                        deDataChanges.add(deDataChg);
                        ++i;
                    }
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                    selectResult.Close();
                    break block25;
                }
            }
            catch (Throwable throwable) {
                selectResult.Close();
                throw throwable;
            }
            selectResult.Close();
        }
        if (deDataChanges.size() == 0) {
            return;
        }
        IDEDataCtrl deDataChgDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0223", "SA.SRFDA.Ctrl.DEDataChangeDispatchService");
        IDEDataCtrl deDataChg2DataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0224", "SA.SRFDA.Ctrl.DEDataChangeDispatchService");
        Hashtable<String, IDEHelper> deHelperMap = new Hashtable<String, IDEHelper>();
        for (DEDataChg deDataChg : deDataChanges) {
            CallResult callResult;
            String strDispError = "";
            DEDataChg2 deDataChg2 = new DEDataChg2();
            deDataChg.CopyTo(deDataChg2, false);
            deDataChg2.setDEDATACHG2ID(deDataChg.getDEDATACHGID());
            deDataChg2.setDEDATACHG2NAME(deDataChg.getDEDATACHGNAME());
            BaseDEDataCtrl.SetCallParamCheckKey(deDataChg2, false);
            BaseDEDataCtrl.SetCallParamDALog(deDataChg2, false);
            BaseDEDataCtrl.SetCallParamRetData(deDataChg2, false);
            try {
                DefaultDEDataChangeDispatchParam dataChangeDispatchParam = new DefaultDEDataChangeDispatchParam();
                dataChangeDispatchParam.setDEDataChg(deDataChg);
                IDEHelper iDEHelper = null;
                if (!deHelperMap.containsKey(deDataChg.getDEID())) {
                    iDEHelper = this.getGlobalHelper().getDAModelStorage().FindDEHelper2(deDataChg.getDEID());
                    deHelperMap.put(deDataChg.getDEID(), iDEHelper);
                } else {
                    iDEHelper = (IDEHelper)deHelperMap.get(deDataChg.getDEID());
                }
                dataChangeDispatchParam.setDEHelper(iDEHelper);
                if (deDataChg.getEVENTTYPE() != 4 && deDataChg.isDATANull()) {
                    IDEDataCtrl iDEDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl(deDataChg.getDEID(), "SA.SRFDA.Ctrl.DEDataChangeDispatchService");
                    BaseDataEntity dataEntity = new BaseDataEntity();
                    dataEntity.SetParamValue(iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().getName(), iDEDataCtrl.GetDEHelper().GetKeyDEFHelper().GetDEFValue(deDataChg.getDATAKEY()));
                    XMLNode rootNode = new XMLNode();
                    rootNode.setNodeName("SRFDAXMLEXPORTS");
                    CallResult callResult2 = iDEDataCtrl.Get(dataEntity);
                    if (callResult2.IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53[%1$s]\u6570\u636e[%2$s]\u53d1\u751f\u9519\u8bef\uff0c%3$s", (Object)iDEDataCtrl.GetDEHelper().getId(), (Object)deDataChg.getDATAKEY(), (Object)callResult2.getErrorInfo()));
                    }
                    if (iDEDataCtrl.GetDEHelper().GetDataChangeLogMode() == 5) {
                        Vector<XMLNode> exportXMLNodes = new Vector<XMLNode>();
                        callResult2 = iDEDataCtrl.Export(dataEntity, exportXMLNodes, false, false);
                        if (callResult2.IsError()) {
                            throw new Exception(StringHelper.Format((String)"\u5bfc\u51fa\u5b9e\u4f53[%1$s]\u6570\u636e\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)iDEDataCtrl.GetDEHelper().getId(), (Object)callResult2.getErrorInfo()));
                        }
                        for (XMLNode xmlNode : exportXMLNodes) {
                            xmlNode.setNodeName("SRFDAXMLEXPORT");
                            rootNode.AddNode(xmlNode);
                        }
                    } else {
                        XMLNode xmlNode = new XMLNode();
                        xmlNode.setNodeName("SRFDAXMLEXPORT");
                        xmlNode.SetValue("SRFDEID", iDEDataCtrl.GetDEHelper().getId());
                        xmlNode.SetValue("SRFVALUE", BaseDataEntity.ToString((BaseDataEntity)dataEntity, (boolean)iDEDataCtrl.GetDEHelper().IsExportIncEmpty()));
                        rootNode.AddNode(xmlNode);
                    }
                    String strXML = XMLNode.Export((XMLNode)rootNode);
                    deDataChg.setDATA(strXML);
                    deDataChg2.setDATA(strXML);
                    deDataChg.setLOGICDATA(BaseDataEntity.ToString((BaseDataEntity)dataEntity));
                    deDataChg2.setLOGICDATA(deDataChg.getLOGICDATA());
                    dataChangeDispatchParam.setExportNode(rootNode);
                }
                for (IDEDataChangeDispatch deDataChangeDispatch : this.dataChangeDispatchs) {
                    try {
                        deDataChangeDispatch.Dispatch(dataChangeDispatchParam);
                    }
                    catch (Exception ex) {
                        log.error((Object)StringHelper.Format((String)"\u5904\u7406\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u3010%1$s\u3011\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)deDataChangeDispatch.getName(), (Object)ex.getMessage()), (Throwable)ex);
                        if (!StringHelper.IsNullOrEmpty((String)strDispError)) {
                            strDispError = String.valueOf(strDispError) + "\r\n";
                        }
                        strDispError = String.valueOf(strDispError) + StringHelper.Format((String)"\u5904\u7406\u6570\u636e\u53d8\u66f4\u5206\u53d1\u5f15\u64ce\u3010%1$s\u3011\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)deDataChangeDispatch.getName(), (Object)ex.getMessage());
                    }
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u5904\u7406\u6570\u636e\u53d8\u66f4\u5206\u53d1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                deDataChg2.setERROR(StringHelper.Format((String)"\u5904\u7406\u6570\u636e\u53d8\u66f4\u5206\u53d1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            }
            if (!StringHelper.IsNullOrEmpty((String)strDispError)) {
                deDataChg2.setDISPERROR(strDispError);
            }
            if ((callResult = deDataChgDataCtrl.Remove(deDataChg)).IsError()) {
                log.error((Object)StringHelper.Format((String)"\u79fb\u9664\u5df2\u5904\u7406\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u53d1\u751f\u9519\u8bef\uff0c%1$", (Object)callResult.getErrorInfo()));
                continue;
            }
            callResult = deDataChg2DataCtrl.Save(true, deDataChg2);
            if (!callResult.IsError()) continue;
            log.error((Object)StringHelper.Format((String)"\u4fdd\u5b58\u5df2\u5904\u7406\u5b9e\u4f53\u6570\u636e\u53d8\u66f4\u53d1\u751f\u9519\u8bef\uff0c%1$", (Object)callResult.getErrorInfo()));
        }
    }
}

