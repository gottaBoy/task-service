/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeItemConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Data;

import SA.SRFDA.Ctrl.Data.MsgAccount;
import SA.SRFDA.Ctrl.DataNotify.Model.DataNotifyGroupLogicConfig;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.Vector;

public class DataNotify
extends BaseDataEntity {
    public static final String TIMEUNIT_SECOND = "SECOND";
    public static final String TIMEUNIT_MINUTE = "MINUTE";
    public static final String TIMEUNIT_HOUR = "HOUR";
    public static final String TIMEUNIT_DAY = "DAY";
    public static final int EVENTTYPE_CREATE = 1;
    public static final int EVENTTYPE_UPDATE = 2;
    public static final int EVENTTYPE_CREATEORUPDATE = 3;
    public static final int EVENTTYPE_DELETE = 4;
    public static final String NOTIFYTYPE_TIME = "TIME";
    public static final String NOTIFYTYPE_TIMEEX = "TIMEEX";
    public static final String NOTIFYTYPE_NORMAL = "NORMAL";
    public static final String TIMECOND_BEFORE = "BEFORE";
    public static final String TIMECOND_AFTER = "AFTER";
    public static final String TAG_DATANOTIFYID = "DATANOTIFYID";
    public static final String TAG_DATANOTIFYNAME = "DATANOTIFYNAME";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_NOTIFYTYPE = "NOTIFYTYPE";
    public static final String TAG_DENAME = "DENAME";
    public static final String TAG_DEID = "DEID";
    public static final String TAG_ASYNCMODE = "ASYNCMODE";
    public static final String TAG_TIMEFIELDID = "TIMEFIELDID";
    public static final String TAG_TIMEFIELDNAME = "TIMEFIELDNAME";
    public static final String TAG_TIMEARG = "TIMEARG";
    public static final String TAG_TIMECOND = "TIMECOND";
    public static final String TAG_NOTIFYMODEL = "NOTIFYMODEL";
    public static final String TAG_MSGTEMPLATEID = "MSGTEMPLATEID";
    public static final String TAG_MSGTEMPLATENAME = "MSGTEMPLATENAME";
    public static final String TAG_MSGTYPE = "MSGTYPE";
    public static final String TAG_MSGTO = "MSGTO";
    public static final String TAG_EVENTTYPE = "EVENTTYPE";
    public static final String TAG_RELATEDFIELD = "RELATEDFIELD";
    public static final String TAG_RELATEDFIELD2 = "RELATEDFIELD2";
    public static final String TAG_HELPEROBJECT = "HELPEROBJECT";
    public static final String TAG_TIMEUNIT = "TIMEUNIT";
    protected Vector<MsgAccount> msgAccountList = new Vector();
    protected String strMsgToAccountIds = "";
    protected DataNotifyGroupLogicConfig valueRuleConfig = null;
    protected Vector<String> contextUserList = new Vector();
    protected Vector<String> contextAddressList = new Vector();

    public String getDATANOTIFYID() {
        return this.GetParamStringValue(TAG_DATANOTIFYID, "");
    }

    public void setDATANOTIFYID(String strValue) {
        this.SetParamValue(TAG_DATANOTIFYID, strValue);
    }

    public String getDATANOTIFYNAME() {
        return this.GetParamStringValue(TAG_DATANOTIFYNAME, "");
    }

    public void setDATANOTIFYNAME(String strValue) {
        this.SetParamValue(TAG_DATANOTIFYNAME, strValue);
    }

    public String getCREATEMAN() {
        return this.GetParamStringValue(TAG_CREATEMAN, "");
    }

    public void setCREATEMAN(String strValue) {
        this.SetParamValue(TAG_CREATEMAN, strValue);
    }

    public Date getCREATEDATE() {
        return this.GetParamDateValue(TAG_CREATEDATE, null);
    }

    public void setCREATEDATE(Date strValue) {
        this.SetParamValue(TAG_CREATEDATE, strValue);
    }

    public String getUPDATEMAN() {
        return this.GetParamStringValue(TAG_UPDATEMAN, "");
    }

    public void setUPDATEMAN(String strValue) {
        this.SetParamValue(TAG_UPDATEMAN, strValue);
    }

    public Date getUPDATEDATE() {
        return this.GetParamDateValue(TAG_UPDATEDATE, null);
    }

    public void setUPDATEDATE(Date strValue) {
        this.SetParamValue(TAG_UPDATEDATE, strValue);
    }

    public String getNOTIFYTYPE() {
        return this.GetParamStringValue(TAG_NOTIFYTYPE, "");
    }

    public void setNOTIFYTYPE(String strValue) {
        this.SetParamValue(TAG_NOTIFYTYPE, strValue);
    }

    public String getDENAME() {
        return this.GetParamStringValue(TAG_DENAME, "");
    }

    public void setDENAME(String strValue) {
        this.SetParamValue(TAG_DENAME, strValue);
    }

    public String getDEID() {
        return this.GetParamStringValue(TAG_DEID, "");
    }

    public void setDEID(String strValue) {
        this.SetParamValue(TAG_DEID, strValue);
    }

    public boolean getASYNCMODE() {
        return this.GetParamIntValue(TAG_ASYNCMODE, 0) == 1;
    }

    public void setASYNCMODE(boolean bValue) {
        this.SetParamValue(TAG_ASYNCMODE, bValue ? 1 : 0);
    }

    public String getTIMEFIELDID() {
        return this.GetParamStringValue(TAG_TIMEFIELDID, "");
    }

    public void setTIMEFIELDID(String strValue) {
        this.SetParamValue(TAG_TIMEFIELDID, strValue);
    }

    public String getTIMEFIELDNAME() {
        return this.GetParamStringValue(TAG_TIMEFIELDNAME, "");
    }

    public void setTIMEFIELDNAME(String strValue) {
        this.SetParamValue(TAG_TIMEFIELDNAME, strValue);
    }

    public int getTIMEARG() {
        return this.GetParamIntValue(TAG_TIMEARG, 0);
    }

    public void setTIMEARG(int strValue) {
        this.SetParamValue(TAG_TIMEARG, strValue);
    }

    public String getTIMECOND() {
        return this.GetParamStringValue(TAG_TIMECOND, "");
    }

    public void setTIMECOND(String strValue) {
        this.SetParamValue(TAG_TIMECOND, strValue);
    }

    public String getNOTIFYMODEL() {
        return this.GetParamStringValue(TAG_NOTIFYMODEL, "");
    }

    public void setNOTIFYMODEL(String strValue) {
        this.SetParamValue(TAG_NOTIFYMODEL, strValue);
    }

    public String getMSGTEMPLATEID() {
        return this.GetParamStringValue(TAG_MSGTEMPLATEID, "");
    }

    public void setMSGTEMPLATEID(String strValue) {
        this.SetParamValue(TAG_MSGTEMPLATEID, strValue);
    }

    public String getMSGTEMPLATENAME() {
        return this.GetParamStringValue(TAG_MSGTEMPLATENAME, "");
    }

    public void setMSGTEMPLATENAME(String strValue) {
        this.SetParamValue(TAG_MSGTEMPLATENAME, strValue);
    }

    public int getMSGTYPE() {
        return this.GetParamIntValue(TAG_MSGTYPE, 0);
    }

    public void setMSGTYPE(int strValue) {
        this.SetParamValue(TAG_MSGTYPE, strValue);
    }

    public String getMSGTO() {
        return this.GetParamStringValue(TAG_MSGTO, "");
    }

    public void setMSGTO(String strValue) {
        this.SetParamValue(TAG_MSGTO, strValue);
    }

    public int getEVENTTYPE() {
        return this.GetParamIntValue(TAG_EVENTTYPE, 0);
    }

    public void setEVENTTYPE(int strValue) {
        this.SetParamValue(TAG_EVENTTYPE, strValue);
    }

    public String getRELATEDFIELD() {
        return this.GetParamStringValue(TAG_RELATEDFIELD, "");
    }

    public void setRELATEDFIELD(String strValue) {
        this.SetParamValue(TAG_RELATEDFIELD, strValue);
    }

    public String getRELATEDFIELD2() {
        return this.GetParamStringValue(TAG_RELATEDFIELD2, "");
    }

    public void setRELATEDFIELD2(String strValue) {
        this.SetParamValue(TAG_RELATEDFIELD2, strValue);
    }

    public final boolean isHELPEROBJECTNull() {
        return this.IsParamNull(TAG_HELPEROBJECT);
    }

    public final String getHELPEROBJECT() {
        return this.GetParamStringValue(TAG_HELPEROBJECT, "");
    }

    public final void setHELPEROBJECT(String strValue) {
        this.SetParamValue(TAG_HELPEROBJECT, strValue);
    }

    public final boolean isTIMEUNITNull() {
        return this.IsParamNull(TAG_TIMEUNIT);
    }

    public final String getTIMEUNIT() {
        return this.GetParamStringValue(TAG_TIMEUNIT, "");
    }

    public final void setTIMEUNIT(String strValue) {
        this.SetParamValue(TAG_TIMEUNIT, strValue);
    }

    public void InitDataNotify() {
        CodeItemConfig codeItemConfig;
        int i;
        CodeListConfig contextUsers;
        if (StringHelper.Compare((String)this.getNOTIFYTYPE(), (String)NOTIFYTYPE_NORMAL, (boolean)true) == 0 || StringHelper.Compare((String)this.getNOTIFYTYPE(), (String)NOTIFYTYPE_TIMEEX, (boolean)true) == 0) {
            this.valueRuleConfig = new DataNotifyGroupLogicConfig();
            XMLConfig.LoadFromXML((String)this.getNOTIFYMODEL(), (XMLConfig)this.valueRuleConfig);
        }
        MsgAccount.ParseXML(this.getMSGTO(), this.msgAccountList);
        for (MsgAccount msgAccount : this.msgAccountList) {
            if (!StringHelper.IsNullOrEmpty((String)this.strMsgToAccountIds)) {
                this.strMsgToAccountIds = String.valueOf(this.strMsgToAccountIds) + ";";
            }
            this.strMsgToAccountIds = String.valueOf(this.strMsgToAccountIds) + msgAccount.getMSGACCOUNTID();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getRELATEDFIELD())) {
            contextUsers = new CodeListConfig();
            XMLConfig.LoadFromXML((String)this.getRELATEDFIELD(), (XMLConfig)contextUsers);
            int nCount = contextUsers.getCodeItems().size();
            i = 0;
            while (i < nCount) {
                codeItemConfig = (CodeItemConfig)contextUsers.getCodeItems().get(i);
                this.contextUserList.add(codeItemConfig.getText());
                ++i;
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getRELATEDFIELD2())) {
            contextUsers = new CodeListConfig();
            XMLConfig.LoadFromXML((String)this.getRELATEDFIELD2(), (XMLConfig)contextUsers);
            int nCount = contextUsers.getCodeItems().size();
            i = 0;
            while (i < nCount) {
                codeItemConfig = (CodeItemConfig)contextUsers.getCodeItems().get(i);
                this.contextAddressList.add(codeItemConfig.getText());
                ++i;
            }
        }
    }

    public DataNotifyGroupLogicConfig getValueChangeModelConfig() {
        return this.valueRuleConfig;
    }

    public Vector<MsgAccount> getMsgToList() {
        return this.msgAccountList;
    }

    public Vector<String> getContextUserList() {
        return this.contextUserList;
    }

    public Vector<String> getContextAddressList() {
        return this.contextAddressList;
    }

    public String getMsgToAccountIds() {
        return this.strMsgToAccountIds;
    }
}

