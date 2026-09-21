/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.Data.SOAService;
import SA.SRFDA.Ctrl.ISOAServiceHelper;
import SA.SRFDA.Ctrl.SOAResult;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public class BaseSOAServiceHelper
implements ISOAServiceHelper {
    private String strId = "";
    private String strName = "";
    private int nVersion = 0;
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected SOAService soaService = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, SOAService soaService) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.soaService = soaService;
        this.setId(soaService.getSOASERVICEID());
        this.setName(soaService.getSOASERVICENAME());
        this.setVersion(soaService.getVERSION());
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public boolean getValidFlag() {
        return false;
    }

    @Override
    public SOAResult Call(String strArg, String strPersonId) throws Exception {
        return null;
    }

    public final String getId() {
        return this.strId;
    }

    public final String getName() {
        return this.strName;
    }

    @Override
    public final int getVersion() {
        return this.nVersion;
    }

    protected final void setId(String strId) {
        this.strId = strId;
    }

    protected final void setName(String strName) {
        this.strName = strName;
    }

    protected final void setVersion(int nVersion) {
        this.nVersion = nVersion;
    }

    public final ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    protected final void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }
}

