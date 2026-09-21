/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.PF;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPkg;
import SA.SRFDA.PS.Core.PF.IPSPFPkgVer;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSPFPkgVer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Enumeration;

public class PSPFPkgVerProxy
extends PSObjectImpl
implements IPSPFPkgVer {
    private IPSPFPkgVer iPSPFPkgVer = null;
    private int nOrderValue = 0;

    public PSPFPkgVerProxy(IPSPFPkgVer iPSPFPkgVer, int nOrderValue) {
        this.iPSPFPkgVer = iPSPFPkgVer;
        this.nOrderValue = nOrderValue;
    }

    @Override
    public IPSPF getPSPF() {
        return this.iPSPFPkgVer.getPSPF();
    }

    @Override
    public String getId() {
        return this.iPSPFPkgVer.getId();
    }

    @Override
    public String getName() {
        return this.iPSPFPkgVer.getName();
    }

    @Override
    public int getVersion() {
        return this.iPSPFPkgVer.getVersion();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSPFPkgVer.getPSSysModelInstId();
    }

    @Override
    public String getMemo() {
        return this.iPSPFPkgVer.getMemo();
    }

    @Override
    public Object getPSObjectParam(String strKey, Object objDefault) {
        return this.iPSPFPkgVer.getPSObjectParam(strKey, objDefault);
    }

    @Override
    public Object getUserParam(String strParamName) {
        return this.iPSPFPkgVer.getUserParam(strParamName);
    }

    @Override
    public boolean containsUserParam(String strParamName) {
        return this.iPSPFPkgVer.containsUserParam(strParamName);
    }

    @Override
    public String getUserParam(String strParamName, String strDefault) {
        return this.iPSPFPkgVer.getUserParam(strParamName, strDefault);
    }

    @Override
    public boolean getUserParam(String strParamName, boolean bDefault) {
        return this.iPSPFPkgVer.getUserParam(strParamName, bDefault);
    }

    @Override
    public int getUserParam(String strParamName, int nDefault) {
        return this.iPSPFPkgVer.getUserParam(strParamName, nDefault);
    }

    @Override
    public Enumeration<Object> getUserParamNames() {
        return this.iPSPFPkgVer.getUserParamNames();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSPF iPSPF, PSPFPkgVer psSFPkgVer) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public IPSPFPkg getPSPFPkg() {
        return this.iPSPFPkgVer.getPSPFPkg();
    }

    @Override
    public String getVerTag() {
        return this.iPSPFPkgVer.getVerTag();
    }

    @Override
    public String getVerTag2() {
        return this.iPSPFPkgVer.getVerTag2();
    }

    @Override
    public String getVerParam() {
        return this.iPSPFPkgVer.getVerParam();
    }

    @Override
    public String getVerParam2() {
        return this.iPSPFPkgVer.getVerParam2();
    }

    @Override
    public String getVerParam3() {
        return this.iPSPFPkgVer.getVerParam3();
    }

    @Override
    public String getVerParam4() {
        return this.iPSPFPkgVer.getVerParam4();
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.iPSPFPkgVer;
    }
}

