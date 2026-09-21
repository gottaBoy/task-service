/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.PSDEEditFormItemImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDESearchFormItemImpl;
import SA.SRFDA.PS.Core.Control.Form.PSFormDetailTypeImpl;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFramework.Utility.StringHelper;

public class PSFormItemTypeImpl
extends PSFormDetailTypeImpl {
    @Override
    public IPSDEFormDetail createPSDEFormDetail(PSDEFormDetail psDEFormDetail) throws Exception {
        if (StringHelper.Compare((String)psDEFormDetail.getFORMTYPE(), (String)"EDITFORM", (boolean)true) == 0 || StringHelper.Compare((String)psDEFormDetail.getFORMTYPE(), (String)"FORM", (boolean)true) == 0) {
            return new PSDEEditFormItemImpl();
        }
        if (StringHelper.Compare((String)psDEFormDetail.getFORMTYPE(), (String)"SEARCHFORM", (boolean)true) == 0) {
            return new PSDESearchFormItemImpl();
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8868\u5355\u9879"));
    }
}

