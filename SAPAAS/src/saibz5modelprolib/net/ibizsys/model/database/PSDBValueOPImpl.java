/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.database;

import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.database.IPSDBValueOPRuntime;
import net.ibizsys.model.entity.PSDBValueOP;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDBValueOPImpl
extends PSObjectImpl
implements IPSDBValueOPRuntime {
    protected PSDBValueOP psDBValueOP = null;
    private static final Log log = LogFactory.getLog(PSDBValueOPImpl.class);

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, PSDBValueOP psDBValueOP) throws Exception {
        this.psDBValueOP = psDBValueOP;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.setId(psDBValueOP.getPSDBVALUEOPID());
        this.setName(psDBValueOP.getPSDBVALUEOPNAME());
        this.setPSObjectData(this.psDBValueOP);
        this.onInit();
    }

    public String getCaption(boolean bSimpleMode, String strLanguage) {
        if (bSimpleMode) {
            return this.getSimpleName();
        }
        return this.getName();
    }

    public String getSimpleName() {
        return this.psDBValueOP.getSIMPLENAME();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }
}

