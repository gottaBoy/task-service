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

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeItemConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Date;
import java.util.Vector;

public class MsgAccount
extends BaseDataEntity {
    public static final String SELECTMODE_LISTGROUPDETAIL = "LISTGROUPDETAIL";
    public static final String TAG_MSGACCOUNTID = "MSGACCOUNTID";
    public static final String TAG_MSGACCOUNTNAME = "MSGACCOUNTNAME";
    public static final String TAG_ENABLE = "ENABLE";
    public static final String TAG_CREATEMAN = "CREATEMAN";
    public static final String TAG_CREATEDATE = "CREATEDATE";
    public static final String TAG_UPDATEMAN = "UPDATEMAN";
    public static final String TAG_UPDATEDATE = "UPDATEDATE";
    public static final String TAG_FOLDERMODEL = "FOLDERMODEL";
    public static final String TAG_MSGADDRESS = "MSGADDRESS";
    public static final String TAG_MAILADDRESS = "MAILADDRESS";
    public static final String TAG_ISLIST = "ISLIST";
    public static final String TAG_MSNEMAIL = "MSNEMAIL";
    public static final String TAG_MOBILE = "MOBILE";
    public static final String TAG_WECHARADDR = "WECHARADDR";

    public String getMSGACCOUNTID() {
        return this.GetParamStringValue(TAG_MSGACCOUNTID, "");
    }

    public void setMSGACCOUNTID(String strValue) {
        this.SetParamValue(TAG_MSGACCOUNTID, strValue);
    }

    public String getMSGACCOUNTNAME() {
        return this.GetParamStringValue(TAG_MSGACCOUNTNAME, "");
    }

    public void setMSGACCOUNTNAME(String strValue) {
        this.SetParamValue(TAG_MSGACCOUNTNAME, strValue);
    }

    public boolean getENABLE() {
        return this.GetParamIntValue(TAG_ENABLE, 0) == 1;
    }

    public void setENABLE(boolean bValue) {
        this.SetParamValue(TAG_ENABLE, bValue ? 1 : 0);
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

    public String getFOLDERMODEL() {
        return this.GetParamStringValue(TAG_FOLDERMODEL, "");
    }

    public void setFOLDERMODEL(String strValue) {
        this.SetParamValue(TAG_FOLDERMODEL, strValue);
    }

    public String getMSGADDRESS() {
        return this.GetParamStringValue(TAG_MSGADDRESS, "");
    }

    public void setMSGADDRESS(String strValue) {
        this.SetParamValue(TAG_MSGADDRESS, strValue);
    }

    public String getMAILADDRESS() {
        return this.GetParamStringValue(TAG_MAILADDRESS, "");
    }

    public void setMAILADDRESS(String strValue) {
        this.SetParamValue(TAG_MAILADDRESS, strValue);
    }

    public boolean getISLIST() {
        return this.GetParamIntValue(TAG_ISLIST, 0) == 1;
    }

    public void setISLIST(boolean bValue) {
        this.SetParamValue(TAG_ISLIST, bValue ? 1 : 0);
    }

    public String getMSNEMAIL() {
        return this.GetParamStringValue(TAG_MSNEMAIL, "");
    }

    public void setMSNEMAIL(String strValue) {
        this.SetParamValue(TAG_MSNEMAIL, strValue);
    }

    public final boolean isMOBILENull() {
        return this.IsParamNull(TAG_MOBILE);
    }

    public final String getMOBILE() {
        return this.GetParamStringValue(TAG_MOBILE, "");
    }

    public final void setMOBILE(String strValue) {
        this.SetParamValue(TAG_MOBILE, strValue);
    }

    public final boolean isWECHARADDRNull() {
        return this.IsParamNull(TAG_WECHARADDR);
    }

    public final String getWECHARADDR() {
        return this.GetParamStringValue(TAG_WECHARADDR, "");
    }

    public final void setWECHARADDR(String strValue) {
        this.SetParamValue(TAG_WECHARADDR, strValue);
    }

    public static void ParseXML(String strXML, Vector<MsgAccount> list) {
        if (StringHelper.IsNullOrEmpty((String)strXML)) {
            return;
        }
        CodeListConfig temp = new CodeListConfig();
        XMLConfig.LoadFromXML((String)strXML, (XMLConfig)temp);
        int nCount = temp.getCodeItems().size();
        int i = 0;
        while (i < nCount) {
            CodeItemConfig codeItemConfig = (CodeItemConfig)temp.getCodeItems().get(i);
            MsgAccount msgAccount = new MsgAccount();
            msgAccount.setMSGACCOUNTID(codeItemConfig.getValue());
            msgAccount.setMSGACCOUNTNAME(codeItemConfig.getText());
            list.add(msgAccount);
            ++i;
        }
    }
}

