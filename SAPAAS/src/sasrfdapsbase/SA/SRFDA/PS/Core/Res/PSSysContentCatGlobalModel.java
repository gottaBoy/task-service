/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSSystemGlobalModelBase;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.PSSysContentCatImpl;
import SA.SRFDA.PS.Data.PSSysContentCat;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysContentCatGlobalModel
extends PSSystemGlobalModelBase<String, PSSysContentCat, IPSSysContentCat> {
    private static final Log log = LogFactory.getLog(PSSysContentCatGlobalModel.class);
    private IPSSysContentCat iPSSysContentCat = null;
    private ArrayList<IPSSysContentCat> allPSSysContentCatList = null;

    public CallResult Init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSysContentCat iPSSysContentCat) {
        this.iPSSysContentCat = iPSSysContentCat;
        return super.Init(iDAGlobalHelper, this.getPSSysContentCat().getPSSystem());
    }

    public IPSSysContentCat getPSSysContentCat() {
        return this.iPSSysContentCat;
    }

    @Override
    protected PSSysContentCat GetObject(String strPSSysContentCatId) {
        if (this.isPrepareModels()) {
            return null;
        }
        PSSysContentCat psSysContentCat = new PSSysContentCat();
        CallResult callResult = this.iPSModelHelper.getPSSysContentCat(strPSSysContentCatId, psSysContentCat);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u5185\u5bb9\u5206\u7c7b[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSSysContentCatId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psSysContentCat;
    }

    @Override
    protected IPSSysContentCat OnCreateModelHelper(PSSysContentCat vt) throws Exception {
        PSSysContentCatImpl iPSSysContentCat = new PSSysContentCatImpl();
        iPSSysContentCat.init(this.iDAGlobalHelper, this.getPSSystem(), this.getPSSysContentCat(), vt);
        return iPSSysContentCat;
    }

    @Override
    protected Boolean TestObjectRenew(PSSysContentCat obj) {
        return false;
    }

    @Override
    protected IPSSysContentCat registerModel(PSSysContentCat vt) throws Exception {
        IPSSysContentCat iPSSysContentCat = (IPSSysContentCat)this.InternalGetModelHelper(vt.getPSSYSCONTENTCATID());
        if (iPSSysContentCat != null) {
            return iPSSysContentCat;
        }
        this.setModel(vt.getPSSYSCONTENTCATID(), vt, null);
        iPSSysContentCat = (IPSSysContentCat)this.FindModelHelper(vt.getPSSYSCONTENTCATID());
        return iPSSysContentCat;
    }

    @Override
    protected void onPreloadModels() {
        try {
            Iterator iterator = this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected void fillAllPSSysContentCats(IPSSysContentCat iPSSysContentCat, ArrayList<IPSSysContentCat> psSysContentCatList) throws Exception {
        psSysContentCatList.add(iPSSysContentCat);
        Iterator<IPSSysContentCat> psSysContentCats = iPSSysContentCat.getPSSysContentCats();
        if (psSysContentCats != null) {
            while (psSysContentCats.hasNext()) {
                IPSSysContentCat iPSSysContentCat2 = psSysContentCats.next();
                this.fillAllPSSysContentCats(iPSSysContentCat2, psSysContentCatList);
            }
        }
    }

    @Override
    protected Vector<PSSysContentCat> getAllModels() throws Exception {
        Vector<PSSysContentCat> list = new Vector<PSSysContentCat>();
        if (this.getPSSysContentCat() == null) {
            CallResult callResult = this.iPSModelHelper.getAllPSSysContentCats(this.getPSSystem().getId(), list);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5168\u90e8\u5185\u5bb9\u5206\u7c7b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
        } else {
            CallResult callResult = this.iPSModelHelper.getPSSysContentCats(this.getPSSysContentCat().getId(), list);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5185\u5bb9\u5206\u7c7b\u5168\u90e8\u5b50\u5206\u7c7b\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
            }
        }
        return list;
    }

    @Override
    protected String getObjectId(PSSysContentCat vt) {
        return vt.getPSSYSCONTENTCATID();
    }

    @Override
    protected boolean isEnableObjectAlias() {
        return true;
    }

    protected String[] getObjectAliases(PSSysContentCat vt) {
        if (!net.ibizsys.paas.util.StringHelper.isNullOrEmpty((String)vt.getCODENAME())) {
            return new String[]{vt.getCODENAME().toUpperCase()};
        }
        return (String[])super.getObjectAliases(vt);
    }

    public Iterator<IPSSysContentCat> getAllPSSysContentCats() throws Exception {
        Iterator psSysContentCats;
        if (this.getPSSysContentCat() != null) {
            return null;
        }
        if (this.allPSSysContentCatList == null && (psSysContentCats = this.getAllModelHelpers()) != null) {
            ArrayList<IPSSysContentCat> psSysContentCatList = new ArrayList<IPSSysContentCat>();
            while (psSysContentCats.hasNext()) {
                IPSSysContentCat iPSSysContentCat = (IPSSysContentCat)psSysContentCats.next();
                this.fillAllPSSysContentCats(iPSSysContentCat, psSysContentCatList);
            }
            this.allPSSysContentCatList = psSysContentCatList;
        }
        if (this.allPSSysContentCatList == null || this.allPSSysContentCatList.size() == 0) {
            return null;
        }
        return this.allPSSysContentCatList.iterator();
    }
}

