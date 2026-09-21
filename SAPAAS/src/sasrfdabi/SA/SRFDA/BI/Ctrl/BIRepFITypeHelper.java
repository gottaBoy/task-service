/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.BI.Ctrl;

import SA.SRFDA.BI.Ctrl.BIRepFIHelper;
import SA.SRFDA.BI.Ctrl.BaseBIObject;
import SA.SRFDA.BI.Ctrl.Data.BIRepFI;
import SA.SRFDA.BI.Ctrl.Data.BIRepFIType;
import SA.SRFDA.BI.Ctrl.IBIRepFIHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFITypeHelper;
import SA.SRFDA.BI.Ctrl.IBIRepFilterHelper;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BIRepFITypeHelper
extends BaseBIObject
implements IBIRepFITypeHelper {
    private static final Log log = LogFactory.getLog(BIRepFITypeHelper.class);
    protected BIRepFIType biRepFIType = null;

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper, BIRepFIType biRepFIType) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.biRepFIType = biRepFIType;
        this.OnInit();
    }

    protected void OnInit() throws Exception {
    }

    @Override
    public IBIRepFIHelper GetBIRepFI(IBIRepFilterHelper iBIRepFilterHelper, BIRepFI biRepFI) throws Exception {
        IBIRepFIHelper iBIRepFIHelper = null;
        if (!StringHelper.IsNullOrEmpty((String)this.biRepFIType.getFIHELPOBJECT())) {
            Object objRepFIObject = ObjectHelper.Create((String)this.biRepFIType.getFIHELPOBJECT());
            if (objRepFIObject == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u8fc7\u6ee4\u5668\u9879\u5bf9\u8c61[%1$s]", (Object)this.biRepFIType.getFIHELPOBJECT()));
            }
            if (!(objRepFIObject instanceof IBIRepFIHelper)) {
                throw new Exception(StringHelper.Format((String)"\u8fc7\u6ee4\u5668\u9879\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.biRepFIType.getFIHELPOBJECT()));
            }
            iBIRepFIHelper = (IBIRepFIHelper)objRepFIObject;
        } else {
            iBIRepFIHelper = new BIRepFIHelper();
        }
        iBIRepFIHelper.Init(this.iDAGlobalHelper, iBIRepFilterHelper, this, biRepFI);
        return iBIRepFIHelper;
    }

    @Override
    public String getCtrlNameSpace() {
        if (StringHelper.IsNullOrEmpty((String)this.biRepFIType.getNAMESPACE())) {
            return "http://schemas.softanywhere.com/2011/xaml/bi";
        }
        return this.biRepFIType.getNAMESPACE();
    }

    @Override
    public String getCtrlObject() {
        return this.biRepFIType.getCTRLOBJECT();
    }
}

