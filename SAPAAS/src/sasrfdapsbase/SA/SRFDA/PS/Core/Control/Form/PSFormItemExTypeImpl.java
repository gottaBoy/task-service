/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.PSDEEditFormItemExImpl;
import SA.SRFDA.PS.Core.Control.Form.PSDESearchFormItemExImpl;
import SA.SRFDA.PS.Core.Control.Form.PSFormDetailTypeImpl;
import SA.SRFDA.PS.Data.PSDEFormDetail;
import SA.SRFramework.Utility.StringHelper;

public class PSFormItemExTypeImpl
extends PSFormDetailTypeImpl {
    @Override
    public IPSDEFormDetail createPSDEFormDetail(PSDEFormDetail psDEFormDetail) throws Exception {
        if (StringHelper.Compare((String)psDEFormDetail.getFORMTYPE(), (String)"EDITFORM", (boolean)true) == 0 || StringHelper.Compare((String)psDEFormDetail.getFORMTYPE(), (String)"FORM", (boolean)true) == 0) {
            return new PSDEEditFormItemExImpl();
        }
        if (StringHelper.Compare((String)psDEFormDetail.getFORMTYPE(), (String)"SEARCHFORM", (boolean)true) == 0) {
            return new PSDESearchFormItemExImpl();
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8868\u5355\u9879"));
    }
}

