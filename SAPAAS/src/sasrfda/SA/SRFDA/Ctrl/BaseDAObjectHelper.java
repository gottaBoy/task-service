/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDAObjectHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Properties;

public abstract class BaseDAObjectHelper
implements IDAObjectHelper {
    private String strId = "";
    private String strName = "";
    private int nVersion = 0;
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private IDEHelper iDEHelper = null;
    private IDAModelStorage iDAModelStorage = null;
    private Properties properties = null;

    protected void OnInit() throws Exception {
    }

    @Override
    public final String getId() {
        return this.strId;
    }

    @Override
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
        this.iDAModelStorage = this.iDAGlobalHelper != null ? this.iDAGlobalHelper.getDAModelStorage() : null;
    }

    protected final IDAModelHelper getDAModelHelper() {
        return this.iDAGlobalHelper.getDAModelHelper();
    }

    public final int getDEVersion() throws Exception {
        return this.getDEHelper().getVersion();
    }

    @Override
    public final IDEHelper getDEHelper() throws Exception {
        if (this.iDEHelper == null) {
            throw new Exception("\u5b9e\u4f53\u5bf9\u8c61\u65e0\u6548");
        }
        return this.iDEHelper;
    }

    public final void setDEHelper(IDEHelper iDEHelper) {
        this.iDEHelper = iDEHelper;
    }

    @Override
    public final boolean isExpired() {
        return this.OnTestExpired();
    }

    protected boolean OnTestExpired() {
        return false;
    }

    public final IDAModelStorage getDAModelStorage() {
        return this.iDAModelStorage;
    }

    @Override
    public final Properties getParams() {
        return this.properties;
    }

    protected void setParams(Properties properties) {
        this.properties = properties;
    }
}

