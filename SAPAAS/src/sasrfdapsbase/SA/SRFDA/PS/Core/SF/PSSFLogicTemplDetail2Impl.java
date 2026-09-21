/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.Pub.IPSSFLogicPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSSFLogicPartCodePublisher2Impl;
import SA.SRFDA.PS.Core.SF.PSSFLogicTemplDetailImpl;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;

public class PSSFLogicTemplDetail2Impl
extends PSSFLogicTemplDetailImpl {
    @Override
    public IPSSFLogicPartCodePublisher createPSSFLogicPartCodePublisher() throws Exception {
        IPSSFLogicPartCodePublisher iPSSFLogicPartCodePublisher = null;
        if (StringHelper.IsNullOrEmpty((String)this.psSFLogicTemplDetail.getPUBOBJ())) {
            return new PSSFLogicPartCodePublisher2Impl();
        }
        iPSSFLogicPartCodePublisher = (IPSSFLogicPartCodePublisher)ObjectHelper.Create((String)this.psSFLogicTemplDetail.getPUBOBJ());
        return iPSSFLogicPartCodePublisher;
    }
}

