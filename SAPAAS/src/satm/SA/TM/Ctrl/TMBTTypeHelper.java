/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.TM.Ctrl.BaseTMObject;
import SA.TM.Ctrl.Data.TMBTType;
import SA.TM.Ctrl.ITMBTMainTaskInstHelper;
import SA.TM.Ctrl.ITMBTTaskInstHelper;
import SA.TM.Ctrl.ITMBTTypeHelper;

public class TMBTTypeHelper
extends BaseTMObject
implements ITMBTTypeHelper {
    private String strDescription = "";
    private String strObjectHelper = "";
    private String strTaskObject = "";
    private String strTaskObjectParam = "";
    private String strTaskInstObject = "";
    private String strTaskInstObjectParam = "";
    protected TMBTType tmBTType = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, TMBTType tmBTType) throws Exception {
        this.tmBTType = tmBTType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(tmBTType.getTMBTTYPEID());
        this.setName(tmBTType.getTMBTTYPENAME());
        this.InitModel(tmBTType);
        this.OnInit();
    }

    public String getDescription() {
        return this.strDescription;
    }

    protected void setDescription(String strValue) {
        this.strDescription = strValue;
    }

    public String getObjectHelper() {
        return this.strObjectHelper;
    }

    protected void setObjectHelper(String strValue) {
        this.strObjectHelper = strValue;
    }

    public String getTaskObject() {
        return this.strTaskObject;
    }

    protected void setTaskObject(String strValue) {
        this.strTaskObject = strValue;
    }

    public String getTaskObjectParam() {
        return this.strTaskObjectParam;
    }

    protected void setTaskObjectParam(String strValue) {
        this.strTaskObjectParam = strValue;
    }

    public String getTaskInstObject() {
        return this.strTaskInstObject;
    }

    protected void setTaskInstObject(String strValue) {
        this.strTaskInstObject = strValue;
    }

    public String getTaskInstObjectParam() {
        return this.strTaskInstObjectParam;
    }

    protected void setTaskInstObjectParam(String strValue) {
        this.strTaskInstObjectParam = strValue;
    }

    private void InitModel(TMBTType item) {
        if (!item.isDESCRIPTIONNull()) {
            this.setDescription(item.getDESCRIPTION());
        }
        if (!item.isOBJECTHELPERNull()) {
            this.setObjectHelper(item.getOBJECTHELPER());
        }
        if (!item.isTASKOBJECTNull()) {
            this.setTaskObject(item.getTASKOBJECT());
        }
        if (!item.isTASKOBJECTPARAMNull()) {
            this.setTaskObjectParam(item.getTASKOBJECTPARAM());
        }
        if (!item.isTASKINSTOBJECTNull()) {
            this.setTaskInstObject(item.getTASKINSTOBJECT());
        }
        if (!item.isTASKINSTOBJECTPARAMNull()) {
            this.setTaskInstObjectParam(item.getTASKINSTOBJECTPARAM());
        }
    }

    public ITMBTMainTaskInstHelper CreateBTMainTaskInstHelper() throws Exception {
        return (ITMBTMainTaskInstHelper)ObjectHelper.Create((String)this.getTaskInstObject());
    }

    public ITMBTTaskInstHelper CreateBTTaskInstHelper() {
        return (ITMBTTaskInstHelper)ObjectHelper.Create((String)this.getTaskInstObject());
    }
}

