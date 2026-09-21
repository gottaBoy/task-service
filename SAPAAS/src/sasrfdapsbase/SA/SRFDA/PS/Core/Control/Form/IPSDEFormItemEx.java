/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.control.form.IFormItemEx
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDEFormDetail;
import SA.SRFDA.PS.Core.Control.Form.IPSDEFormItem;
import SA.SRFDA.PS.Core.PSModelExtendMeta;
import SA.SRFDA.PS.Core.PSModelInterfaceMeta;
import java.util.Iterator;
import net.ibizsys.paas.control.form.IFormItemEx;

@PSModelExtendMeta(typevalue={"FORMITEMEX"})
@PSModelInterfaceMeta(title="\u5b9e\u4f53\u8868\u5355\u590d\u5408\u8868\u5355\u9879\u6210\u5458\u6a21\u578b\u5bf9\u8c61\u63a5\u53e3", implement="PSDEEditFormItemExImpl")
public interface IPSDEFormItemEx
extends IPSDEFormDetail,
IPSDEFormItem,
IFormItemEx {
    public Iterator<IPSDEFormItem> getPSDEFormItems();
}

