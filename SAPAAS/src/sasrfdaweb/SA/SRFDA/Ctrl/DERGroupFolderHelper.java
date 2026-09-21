/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.BaseDAObjectHelper
 *  SA.SRFDA.Ctrl.Data.DERGroupFolder
 *  SA.SRFDA.Ctrl.IDERGroupFolderHelper
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAObjectHelper;
import SA.SRFDA.Ctrl.Data.DERGroupFolder;
import SA.SRFDA.Ctrl.IDERGroupFolderHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class DERGroupFolderHelper
extends BaseDAObjectHelper
implements IDERGroupFolderHelper {
    private String strSmallIcon = "";
    private boolean bCollapse = false;
    private String strMemo = "";
    private int nShowOrder = 1000;
    protected DERGroupFolder derGroupFolder = null;

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, DERGroupFolder derGroupFolder) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.derGroupFolder = derGroupFolder;
        this.setId(derGroupFolder.getDERGROUPFOLDERID());
        this.setName(derGroupFolder.getDERGROUPFOLDERNAME());
        this.InitModel(this.derGroupFolder);
        this.OnInit();
    }

    public String getSmallIcon() {
        return this.strSmallIcon;
    }

    protected void setSmallIcon(String strValue) {
        this.strSmallIcon = strValue;
    }

    public boolean isCollapse() {
        return this.bCollapse;
    }

    protected void setCollapse(boolean bValue) {
        this.bCollapse = bValue;
    }

    public String getMemo() {
        return this.strMemo;
    }

    protected void setMemo(String strValue) {
        this.strMemo = strValue;
    }

    public int getShowOrder() {
        return this.nShowOrder;
    }

    protected void setShowOrder(int nValue) {
        this.nShowOrder = nValue;
    }

    protected void InitModel(DERGroupFolder item) {
        this.setSmallIcon(item.getSMALLICON());
        this.setCollapse(item.getISCOLLAPSE());
        this.setMemo(item.getMEMO());
        if (!item.isSHOWORDERNull()) {
            this.setShowOrder(item.getSHOWORDER());
        }
    }

    public String getCaption(String strLanguage) {
        return this.getName();
    }
}

