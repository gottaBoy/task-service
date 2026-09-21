/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.demodel;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.demodel.DEDataQueryCodeModel;
import net.ibizsys.paas.util.StringHelper;

public abstract class DEDataQueryModelBase
extends ModelBase3Impl
implements IDEDataQuery {
    private static HashMap<String, String> dbCompatibleMap = new HashMap();
    private IDataEntity iDataEntity = null;
    private DEDataQuery deDataQuery = null;
    protected HashMap<String, IDEDataQueryCode> deDataQueryCodeMap = new HashMap();

    static {
        dbCompatibleMap.put("HANA", "ORACLE");
        dbCompatibleMap.put("DM", "ORACLE");
        dbCompatibleMap.put("SQLITE", "MYSQL5");
    }

    @Override
    public void init(IDataEntity iDataEntity) throws Exception {
        this.setDataEntity(iDataEntity);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
    }

    protected void initAnnotation(Class c) {
        Annotation[] annotations = c.getAnnotations();
        if (annotations != null) {
            Annotation[] annotationArray = annotations;
            int n = annotations.length;
            int n2 = 0;
            while (n2 < n) {
                Annotation annotation = annotationArray[n2];
                if (annotation instanceof DEDataQuery) {
                    this.setDEDataQueryAnno((DEDataQuery)annotation);
                } else if (annotation instanceof DEDataQueryCodes) {
                    this.setDEDataQueryCodesAnno((DEDataQueryCodes)annotation);
                }
                ++n2;
            }
        }
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.iDataEntity;
    }

    protected void setDataEntity(IDataEntity iDataEntity) {
        this.iDataEntity = iDataEntity;
    }

    protected DEDataQuery getDEDataQueryAnno() {
        return this.deDataQuery;
    }

    protected void setDEDataQueryAnno(DEDataQuery deDataQuery) {
        this.deDataQuery = deDataQuery;
    }

    protected void setDEDataQueryCodesAnno(DEDataQueryCodes deDataQueryCodes) {
        DEDataQueryCode[] dEDataQueryCodeArray = deDataQueryCodes.value();
        int n = dEDataQueryCodeArray.length;
        int n2 = 0;
        while (n2 < n) {
            DEDataQueryCode deDataQueryCode = dEDataQueryCodeArray[n2];
            IDEDataQueryCode iDEDataQueryCode = this.createDEDataQueryCode(deDataQueryCode);
            this.deDataQueryCodeMap.put(iDEDataQueryCode.getDBType(), iDEDataQueryCode);
            ++n2;
        }
    }

    protected IDEDataQueryCode createDEDataQueryCode(DEDataQueryCode deDataQueryCode) {
        DEDataQueryCodeModel deDataQueryCodeModel = new DEDataQueryCodeModel(this, deDataQueryCode);
        return deDataQueryCodeModel;
    }

    @Override
    public String getId() {
        return this.getDEDataQueryAnno().id();
    }

    @Override
    public String getName() {
        return this.getDEDataQueryAnno().name();
    }

    @Override
    public IDEDataQueryCode getDEDataQueryCode(String strDBType) throws Exception {
        IDEDataQueryCode iDEDataQueryCode = this.deDataQueryCodeMap.get(strDBType);
        if (iDEDataQueryCode == null) {
            String strDBType2 = dbCompatibleMap.get(strDBType);
            if (!StringHelper.isNullOrEmpty(strDBType2)) {
                iDEDataQueryCode = this.deDataQueryCodeMap.get(strDBType2);
            }
            if (iDEDataQueryCode == null) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5e93[%1$s]\u4ee3\u7801", strDBType));
            }
        }
        return iDEDataQueryCode;
    }

    @Override
    public boolean isDefaultMode() {
        return this.getDEDataQueryAnno().defaultmode();
    }

    @Override
    public int getViewLevel() {
        return this.getDEDataQueryAnno().viewlevel();
    }
}

