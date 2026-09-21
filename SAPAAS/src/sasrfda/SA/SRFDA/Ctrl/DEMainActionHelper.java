/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.DEMAFieldHelper;
import SA.SRFDA.Ctrl.Data.DEMAField;
import SA.SRFDA.Ctrl.Data.DEMainAction;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMAFieldHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Vector;

public class DEMainActionHelper
extends BaseDAObjectHelper
implements IDEMainActionHelper {
    private String strLogicName = "";
    private boolean bUpdateFlag = false;
    private String strDEBehaviorId = "";
    private String strMemo = "";
    private String strFormId = "";
    private boolean bSystemReserver = false;
    private String strActionType = "";
    private String strActionMode = "";
    private String strDataAccessAction = "";
    private DEMainAction deMainAction = null;
    private Hashtable<String, IDEMAFieldHelper> deMAFieldHelperMap = new Hashtable();

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, IDEHelper iDEHelper, DEMainAction deMainAction) throws Exception {
        this.setId(deMainAction.getDEMAINACTIONID());
        this.setName(deMainAction.getDEMAINACTIONNAME());
        this.setDEHelper(iDEHelper);
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.deMainAction = deMainAction;
        this.InitModel(deMainAction);
        Vector<DEMAField> deMAFields = new Vector<DEMAField>();
        CallResult callResult = this.getDAModelHelper().GetDEMAFields(this.getId(), deMAFields);
        if (callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u5c5e\u6027\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        for (DEMAField deMAField : deMAFields) {
            DEMAFieldHelper deMAFieldHelper = new DEMAFieldHelper();
            deMAFieldHelper.Init(iDAGlobalHelper, this, deMAField);
            this.deMAFieldHelperMap.put(deMAFieldHelper.getDEFId(), deMAFieldHelper);
        }
        this.OnInit();
    }

    private void InitModel(DEMainAction item) {
        if (!item.isLOGICNAMENull()) {
            this.setLogicName(item.getLOGICNAME());
        }
        if (!item.isDEBEHAVIORIDNull()) {
            this.setDEBehaviorId(item.getDEBEHAVIORID());
        }
        if (!item.isMEMONull()) {
            this.setMemo(item.getMEMO());
        }
        if (!item.isFORMIDNull()) {
            this.setFormId(item.getFORMID());
        }
        if (!item.isACTIONTYPENull()) {
            this.setActionType(item.getACTIONTYPE());
        }
        if (StringHelper.Compare((String)this.getActionType(), (String)"CREATE", (boolean)true) == 0 || StringHelper.Compare((String)this.getActionType(), (String)"UPDATE", (boolean)true) == 0 || StringHelper.Compare((String)this.getActionType(), (String)"DELETE", (boolean)true) == 0) {
            this.setSystemReserver(true);
        } else {
            this.setSystemReserver(false);
        }
        if (!item.isACTIONMODENull()) {
            this.setActionMode(item.getACTIONMODE());
        }
        this.strDataAccessAction = this.OnCalcDataAccessAction();
    }

    @Override
    public String getLogicName(String strLanguage) {
        return this.strLogicName;
    }

    protected void setLogicName(String strValue) {
        this.strLogicName = strValue;
    }

    @Override
    public String getDEBehaviorId() {
        return this.strDEBehaviorId;
    }

    protected void setDEBehaviorId(String strValue) {
        this.strDEBehaviorId = strValue;
    }

    @Override
    public String getMemo() {
        return this.strMemo;
    }

    protected void setMemo(String strValue) {
        this.strMemo = strValue;
    }

    @Override
    public String getFormId() {
        return this.strFormId;
    }

    protected void setFormId(String strValue) {
        this.strFormId = strValue;
    }

    @Override
    public IDEMAFieldHelper FindDEMAField(String strDEFId) {
        return this.deMAFieldHelperMap.get(strDEFId);
    }

    @Override
    public boolean isUpdateMAFOnly() {
        if (!this.deMainAction.isUPDATEMAFONLYNull()) {
            return this.deMainAction.getUPDATEMAFONLY();
        }
        return false;
    }

    @Override
    public final String getActionType() {
        return this.strActionType;
    }

    protected final void setActionType(String strValue) {
        this.strActionType = strValue;
    }

    @Override
    public boolean isSystemReserver() {
        return this.bSystemReserver;
    }

    protected void setSystemReserver(boolean bSystemReserver) {
        this.bSystemReserver = bSystemReserver;
    }

    @Override
    public final String getActionMode() {
        return this.strActionMode;
    }

    protected final void setActionMode(String strValue) {
        this.strActionMode = strValue;
    }

    @Override
    public String getDataAccessAction() {
        return this.strDataAccessAction;
    }

    protected String OnCalcDataAccessAction() {
        if (this.deMainAction.isDATAACCACTIONNull()) {
            if (StringHelper.Compare((String)this.getActionMode(), (String)"DEFAULT", (boolean)true) == 0) {
                if (StringHelper.Compare((String)this.getActionType(), (String)"INSERT", (boolean)true) == 0) {
                    return "CREATE";
                }
                if (StringHelper.Compare((String)this.getActionType(), (String)"UPDATE", (boolean)true) == 0) {
                    return "UPDATE";
                }
                if (StringHelper.Compare((String)this.getActionType(), (String)"DELETE", (boolean)true) == 0) {
                    return "DELETE";
                }
            }
            return this.getName();
        }
        return this.deMainAction.getDATAACCACTION();
    }
}

