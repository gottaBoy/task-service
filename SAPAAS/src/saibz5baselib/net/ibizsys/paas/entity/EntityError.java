/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.entity;

import java.util.ArrayList;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringBuilderEx;

public class EntityError {
    private ArrayList<EntityFieldError> fieldErrorList = new ArrayList();
    private IEntity iEntity = null;
    private Object objUserData = null;

    public void register(EntityFieldError entityFieldError) {
        this.fieldErrorList.add(entityFieldError);
    }

    public void register(String strFieldName, String strCaption, String strCapLanId, int nErrorType, String strErrorInfo) {
        this.register(strFieldName, strCaption, strCapLanId, nErrorType, strErrorInfo, null);
    }

    public void register(String strFieldName, String strCaption, String strCapLanId, int nErrorType, String strErrorInfo, Object objValue) {
        EntityFieldError fieldError = new EntityFieldError();
        fieldError.setFieldLogicName(strCaption);
        fieldError.setFieldName(strFieldName);
        fieldError.setErrorType(nErrorType);
        fieldError.setErrorInfo(strErrorInfo);
        fieldError.setFieldValue(objValue);
        this.fieldErrorList.add(fieldError);
    }

    public ArrayList<EntityFieldError> getEntityFieldErrorList() {
        return this.fieldErrorList;
    }

    public boolean hasError() {
        return this.fieldErrorList.size() > 0;
    }

    public String toString() {
        StringBuilderEx sb = new StringBuilderEx();
        boolean bFirst = true;
        for (EntityFieldError entityFieldError : this.fieldErrorList) {
            if (bFirst) {
                bFirst = false;
            } else {
                sb.append("\r\n");
            }
            sb.append(entityFieldError.toString());
        }
        return sb.toString();
    }

    public IEntity getEntity() {
        return this.iEntity;
    }

    public void setEntity(IEntity iEntity) {
        this.iEntity = iEntity;
    }

    public Object getUserData() {
        return this.objUserData;
    }

    public void setUserData(Object objUserData) {
        this.objUserData = objUserData;
    }
}

