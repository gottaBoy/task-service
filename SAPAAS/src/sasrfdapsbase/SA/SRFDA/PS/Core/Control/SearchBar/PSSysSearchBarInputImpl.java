/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.SearchBar;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSysSearchBarInput;
import SA.SRFDA.PS.Core.Control.SearchBar.PSSysSearchBarItemImplBase;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import net.ibizsys.paas.util.StringHelper;

@PSModelIgnoreMeta
public class PSSysSearchBarInputImpl
extends PSSysSearchBarItemImplBase
implements IPSSysSearchBarInput {
    private String strInputType = null;
    private String strPlaceHolder = null;
    private IPSLanguageRes phPSLanguageRes = null;
    private IPSCodeList iPSCodeList = null;

    @Override
    protected void onInit() throws Exception {
        this.strInputType = this.psSysSearchBarItem.getITEMSUBTYPE().replace("INPUT_", "");
        this.strPlaceHolder = this.psSysSearchBarItem.getPLACEHOLDER();
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPHPSLANRESID())) {
            this.phPSLanguageRes = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSLanguageRes(this.psSysSearchBarItem.getPHPSLANRESID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysSearchBarItem.getPSCODELISTID())) {
            this.iPSCodeList = this.getPSSysSearchBar().getPSAppView().getPSApplication().getPSAppCodeList(this.psSysSearchBarItem.getPSCODELISTID());
            if (this.iPSCodeList == null) {
                this.iPSCodeList = this.getPSSysSearchBar().getPSAppView().getPSSystem().getPSCodeList(this.psSysSearchBarItem.getPSCODELISTID());
            }
        }
        super.onInit();
    }

    @Override
    public String getInputType() {
        return this.strInputType;
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getPHPSLanguageRes() {
        return this.phPSLanguageRes;
    }

    @Override
    public String getPHLanResTag() {
        if (this.getPHPSLanguageRes() == null) {
            return null;
        }
        return this.getPHPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u63d0\u793a\u4fe1\u606f", dump=false)
    public String getPlaceHolder() {
        return this.strPlaceHolder;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", dumpref=true)
    public IPSCodeList getPSCodeList() {
        return this.iPSCodeList;
    }
}

