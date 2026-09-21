/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.DataTypeHelper
 */
package SA.SRFDA.PS.Core.Help;

import SA.SRFDA.PS.Core.DEField.IPSPickupDEField;
import SA.SRFDA.PS.Core.Help.PSHelpSectionImpl;
import SA.SRFDA.PS.Core.IPSModel;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.util.DataTypeHelper;

public class PSDEFDescHelpSectionImpl
extends PSHelpSectionImpl {
    @Override
    protected void onInit() throws Exception {
        if (this.getPSDEField() != null) {
            if (StringHelper.IsNullOrEmpty((String)this.psHelpSection.getHEADERCONTENT())) {
                String strTypeName = DataTypeHelper.getTypeName((int)this.getPSDEField().getStdDataType());
                if (StringHelper.Compare((String)this.getPSDEField().getDataType(), (String)"PICKUP", (boolean)false) == 0) {
                    IPSPickupDEField iPSPickupDEField = (IPSPickupDEField)this.getPSDEField();
                    IPSModel iPSModel = this.getPSModelStorage().getPSModel(iPSPickupDEField.getRealPSDEField().getPSDataEntity().getName(), true);
                    strTypeName = iPSModel != null && !StringHelper.IsNullOrEmpty((String)iPSModel.getHelpArticleUrl()) ? String.valueOf(strTypeName) + StringHelper.Format((String)"\uff0c\u5f15\u7528\u6a21\u578b[<a href=\"%2$s\">%1$s</a>]", (Object)iPSPickupDEField.getRealPSDEField().getPSDataEntity().getLogicName(), (Object)iPSModel.getHelpArticleUrl()) : String.valueOf(strTypeName) + StringHelper.Format((String)"\uff0c\u5f15\u7528\u6a21\u578b[%1$s]", (Object)iPSPickupDEField.getRealPSDEField().getPSDataEntity().getLogicName());
                }
                this.psHelpSection.setHEADERCONTENT(strTypeName);
            }
            if (StringHelper.IsNullOrEmpty((String)this.psHelpSection.getCONTENT())) {
                if (this.getPSDEField().getDefaultPSDEFInputTip() != null) {
                    this.psHelpSection.setCONTENT(this.getPSDEField().getDefaultPSDEFInputTip().getContent());
                } else {
                    this.psHelpSection.setCONTENT(this.getPSDEField().getMemo());
                }
            }
        }
        super.onInit();
    }
}

