/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.pscore.srv.dedesign.entity.PSDEFDTCol
 */
package SA.SRFDA.PS.Data;

import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDTCol;

public class PSDEFDTColumn
extends PSDEFDTCol {
    public static final String DBTYPE_MYSQL5 = "MYSQL5";
    public static final String FIELD_PSDEID = "PSDEID";
    private String strPSDEId = "";

    public void set(String strParamName, Object objValue) throws Exception {
        if (StringHelper.Compare((String)FIELD_PSDEID, (String)strParamName, (boolean)true) == 0) {
            this.setPSDEId(DataObject.getStringValue((Object)objValue, (String)""));
            return;
        }
        super.set(strParamName, objValue);
    }

    public String getPSDEId() {
        return this.strPSDEId;
    }

    public void setPSDEId(String strPSDEId) {
        this.strPSDEId = strPSDEId;
    }
}

