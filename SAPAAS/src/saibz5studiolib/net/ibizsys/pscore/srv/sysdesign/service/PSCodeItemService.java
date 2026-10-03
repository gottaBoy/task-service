/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSCodeItemService
extends PSCodeItemServiceBase {
    private static final Log log = LogFactory.getLog(PSCodeItemService.class);

    @Override
    protected void onInitPSSysImage(PSCodeItem pSCodeItem) throws Exception {
        this.autoGet(pSCodeItem);
        if (!StringHelper.isNullOrEmpty((String)pSCodeItem.getPSSysImageId())) {
            return;
        }
        PSCodeList pSCodeList = pSCodeItem.getPSCodeList();
        if (pSCodeList == null) {
            return;
        }
        if (StringHelper.isNullOrEmpty((String)pSCodeList.getCodeName())) {
            throw new Exception(StringHelper.format((String)"\u4ee3\u7801\u8868\u5bf9\u8c61\u672a\u6307\u5b9a\u4ee3\u7801\u540d\u79f0"));
        }
        if (StringHelper.isNullOrEmpty((String)pSCodeList.getPSSystemId())) {
            throw new Exception(StringHelper.format((String)"\u4ee3\u7801\u8868\u5bf9\u8c61\u672a\u6307\u5b9a\u7cfb\u7edf\u6807\u8bc6"));
        }
        try {
            PSSysImage pSSysImage = new PSSysImage();
            pSSysImage.setSessionFactory(this.getSessionFactory());
            pSSysImage.setPSSystemId(pSCodeList.getPSSystemId());
            pSSysImage.setPSSystemName(pSCodeList.getPSSystemName());
            pSSysImage.setPSSysImageName(StringHelper.format((String)"\u4ee3\u7801\u8868[%1$s]\u9879[%2$s]\u56fe\u6807", (Object)pSCodeList.getPSCodeListName(), (Object)pSCodeItem.getPSCodeItemName()));
            pSSysImage.setImagePath("#");
            pSSysImage.setImagePathX(StringHelper.format((String)"%1$s/icon_%2$s@{0}x.png", (Object)pSCodeList.getCodeName().toLowerCase(), (Object)pSCodeItem.getCodeItemValue().toLowerCase()));
            pSSysImage.create();
            pSCodeItem.setPSSysImageId(pSSysImage.getPSSysImageId());
            pSCodeItem.setPSSysImageName(pSSysImage.getPSSysImageName());
        }
        catch (Exception exception) {
            throw new Exception(StringHelper.format((String)"\u521b\u5efa\u7cfb\u7edf\u56fe\u7247\u8d44\u6e90\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        if (this.isTempData(pSCodeItem)) {
            this.updateTemp(pSCodeItem);
        } else {
            this.update(pSCodeItem);
        }
    }

    @Override
    public String getModelV2Tag(PSCodeItem pSCodeItem) {
        if (!StringHelper.isNullOrEmpty((String)pSCodeItem.getCodeName())) {
            return pSCodeItem.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSCodeItem.getCodeItemValue())) {
            return pSCodeItem.getCodeItemValue();
        }
        return super.getModelV2Tag(pSCodeItem);
    }
}

