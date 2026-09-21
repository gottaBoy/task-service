/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsg;
import SA.SRFDA.PS.Core.Res.IPSCtrlMsgItem;
import SA.SRFDA.PS.Core.Res.PSCtrlMsgItemImpl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSCtrlMsg;
import SA.SRFDA.PS.Data.PSCtrlMsgItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSCtrlMsgImpl
extends PSSystemObjectImpl
implements IPSCtrlMsg {
    private static final Log log = LogFactory.getLog(PSCtrlMsgImpl.class);
    protected PSCtrlMsg psCtrlMsg = null;
    private IPSSystemModule iPSSystemModule = null;
    private List<IPSCtrlMsgItem> psCtrlMsgItemList = new ArrayList<IPSCtrlMsgItem>();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSCtrlMsg psCtrlMsg) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psCtrlMsg = psCtrlMsg;
            this.setId(this.psCtrlMsg.getPSCTRLMSGID());
            this.setName(this.psCtrlMsg.getPSCTRLMSGNAME());
            this.setPSObjectData(this.psCtrlMsg);
            if (!StringHelper.isNullOrEmpty((String)this.psCtrlMsg.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psCtrlMsg.getPSMODULEID());
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
        this.onPreparePSCtrlMsgItems();
    }

    protected void onPreparePSCtrlMsgItems() throws Exception {
        this.psCtrlMsgItemList.clear();
        Vector<PSCtrlMsgItem> psCtrlMsgItemList = new Vector<PSCtrlMsgItem>();
        CallResult callResult = this.getPSModelHelper().getPSCtrlMsgItems(this.getId(), psCtrlMsgItemList);
        if (callResult.isError()) {
            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u90e8\u4ef6\u6d88\u606f\u9879\u96c6\u5408\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        for (PSCtrlMsgItem psCtrlMsgItem : psCtrlMsgItemList) {
            PSCtrlMsgItemImpl iPSCtrlMsgItem = new PSCtrlMsgItemImpl();
            iPSCtrlMsgItem.init(this.getDAGlobalHelper(), this, psCtrlMsgItem);
            this.psCtrlMsgItemList.add(iPSCtrlMsgItem);
        }
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u6d88\u606f\u9879\u96c6\u5408", child=true)
    public Iterator<IPSCtrlMsgItem> getPSCtrlMsgItems() {
        if (this.psCtrlMsgItemList == null || this.psCtrlMsgItemList.size() == 0) {
            return null;
        }
        return this.psCtrlMsgItemList.iterator();
    }

    @Override
    public String getModelType() {
        return "PSCTRLMSG";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.psCtrlMsg.getCODENAME();
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u6d88\u606f\u914d\u7f6e")
    public String getMsgModel() {
        return this.psCtrlMsg.getMSGMODEL();
    }
}

