/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.demodel.demodel.dataentity.uiaction;

import net.ibizsys.paas.demodel.DEUIActionModelBase;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class DataEntityInitAllUIActionModelBase
extends DEUIActionModelBase<DataEntity> {
    private static final Log log = LogFactory.getLog(DataEntityInitAllUIActionModelBase.class);

    public DataEntityInitAllUIActionModelBase() {
        this.setId("F0D30EC1-2C41-409E-B8AC-7E0F983C5127");
        this.setName("InitAll");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitAll");
        this.setSuccessMsg("\u521d\u59cb\u5316\u5b9e\u4f53\u76f8\u5173\u914d\u7f6e\u5b8c\u6210\uff01");
    }
}

