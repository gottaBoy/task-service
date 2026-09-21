/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSDBValueOP;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDBValueOP;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDBValueOPImpl
extends PSObjectImpl
implements IPSDBValueOP {
    protected PSDBValueOP psDBValueOP = null;
    private static final Log log = LogFactory.getLog(PSDBValueOPImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSDBValueOP psDBValueOP) throws Exception {
        this.psDBValueOP = psDBValueOP;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDBValueOP.getPSDBVALUEOPID());
        this.setName(psDBValueOP.getPSDBVALUEOPNAME());
        this.setPSObjectData(this.psDBValueOP);
        this.onInit();
    }

    @Override
    public String getCaption(boolean bSimpleMode, String strLanguage) {
        if (bSimpleMode) {
            return this.getSimpleName();
        }
        return this.getName();
    }

    @Override
    public String getSimpleName() {
        return this.psDBValueOP.getSIMPLENAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

