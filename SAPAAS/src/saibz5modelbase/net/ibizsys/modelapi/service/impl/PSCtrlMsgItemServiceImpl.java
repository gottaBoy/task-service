/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package net.ibizsys.modelapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import net.ibizsys.modelapi.domain.PSCtrlMsg;
import net.ibizsys.modelapi.domain.PSCtrlMsgItem;
import net.ibizsys.modelapi.dto.PSCtrlMsgDTO;
import net.ibizsys.modelapi.dto.PSCtrlMsgItemDTO;
import net.ibizsys.modelapi.dto.PSLanguageResDTO;
import net.ibizsys.modelapi.service.IPSCtrlMsgItemService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSCtrlMsgItemServiceImpl
extends PSModelServiceImplBase<PSCtrlMsgItem, PSCtrlMsgItemDTO>
implements IPSCtrlMsgItemService {
    private static final Log log = LogFactory.getLog(PSCtrlMsgItemServiceImpl.class);

    @Override
    public List<PSCtrlMsgItem> listByPSCtrlMsg(PSCtrlMsg parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSCtrlMsgItem get(PSCtrlMsg parent, String strKey, boolean bTryMode) throws Exception {
        List<PSCtrlMsgItem> list = this.listByPSCtrlMsg(parent);
        if (list != null) {
            for (PSCtrlMsgItem item : list) {
                String strTag = item.getSrfTag();
                if (!StringUtils.hasLength((String)strTag)) {
                    item.init();
                    strTag = this.getModelTag(item);
                }
                if (strKey.compareTo(strTag) != 0) continue;
                return item;
            }
        }
        if (bTryMode) {
            return null;
        }
        throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\uff0c\u6807\u8bb0\u4e3a[%1$s]", strKey));
    }

    @Override
    public List<PSCtrlMsgItemDTO> listDTOByPSCtrlMsg(String strParentKey) throws Exception {
        PSCtrlMsg psctrlmsg = (PSCtrlMsg)PSModelServiceUtil.getInstance().getPSCtrlMsgService().get(strParentKey);
        List<PSCtrlMsgItem> list = this.listByPSCtrlMsg(psctrlmsg);
        if (list != null) {
            ArrayList<PSCtrlMsgItemDTO> dtoList = new ArrayList<PSCtrlMsgItemDTO>();
            for (PSCtrlMsgItem item : list) {
                PSCtrlMsgItemDTO dto = (PSCtrlMsgItemDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSCtrlMsgItem> onListAll() throws Exception {
        ArrayList<PSCtrlMsgItem> list = new ArrayList<PSCtrlMsgItem>();
        List psctrlmsgs = PSModelServiceUtil.getInstance().getPSCtrlMsgService().listAll();
        if (psctrlmsgs != null) {
            for (PSCtrlMsg parent : psctrlmsgs) {
                List<PSCtrlMsgItem> items = this.listByPSCtrlMsg(parent);
                if (items == null) continue;
                list.addAll(items);
            }
        }
        if (list.size() == 0) {
            return null;
        }
        return list;
    }

    @Override
    protected PSCtrlMsgItem onGet(String strParentKey, String strCurKey) throws Exception {
        PSCtrlMsgItem item;
        PSCtrlMsg psctrlmsg = (PSCtrlMsg)PSModelServiceUtil.getInstance().getPSCtrlMsgService().get(strParentKey, true);
        if (psctrlmsg != null && (item = this.get(psctrlmsg, strCurKey, true)) != null) {
            return item;
        }
        return (PSCtrlMsgItem)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSCtrlMsgItemDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSCtrlMsgId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSCtrlMsgService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSCtrlMsgItem et) throws Exception {
        if (StringUtils.hasLength((String)et.getPSCtrlMsgItemName())) {
            return et.getPSCtrlMsgItemName();
        }
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSCtrlMsgItemDTO dto, PSCtrlMsgItem t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSCtrlMsgItemId(t.getId().replace("/", "."));
        }
        if (t.getContent() != null || !bIgnoreNull) {
            dto.setContent(t.getContent());
        }
        if (t.getContentPSLanResId() != null || !bIgnoreNull) {
            dto.setContentPSLanResId(t.getContentPSLanResId());
        }
        if (t.getContentPSLanResName() != null || !bIgnoreNull) {
            dto.setContentPSLanResName(t.getContentPSLanResName());
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSCtrlMsgId() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgId(t.getPSCtrlMsgId());
        }
        if (t.getPSCtrlMsgItemName() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgItemName(t.getPSCtrlMsgItemName());
        }
        if (t.getPSCtrlMsgName() != null || !bIgnoreNull) {
            dto.setPSCtrlMsgName(t.getPSCtrlMsgName());
        }
        if (t.getTimeout() != null || !bIgnoreNull) {
            dto.setTimeout(t.getTimeout());
        }
        if (t.getUpdateDate() != null || !bIgnoreNull) {
            dto.setUpdateDate(t.getUpdateDate());
        }
        if (t.getUpdateMan() != null || !bIgnoreNull) {
            dto.setUpdateMan(t.getUpdateMan());
        }
        if (t.getUserCat() != null || !bIgnoreNull) {
            dto.setUserCat(t.getUserCat());
        }
        if (t.getUserTag() != null || !bIgnoreNull) {
            dto.setUserTag(t.getUserTag());
        }
        if (t.getUserTag2() != null || !bIgnoreNull) {
            dto.setUserTag2(t.getUserTag2());
        }
        if (t.getUserTag3() != null || !bIgnoreNull) {
            dto.setUserTag3(t.getUserTag3());
        }
        if (t.getUserTag4() != null || !bIgnoreNull) {
            dto.setUserTag4(t.getUserTag4());
        }
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            dto.setContentPSLanResId(this.getRealPSModelId(t, dto.getContentPSLanResId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlMsgId())) {
            dto.setPSCtrlMsgId(this.getRealPSModelId(t, dto.getPSCtrlMsgId()).replace("/", "."));
        }
        if ("PSCTRLMSG".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSCtrlMsgId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getContentPSLanResId())) {
            linkDTO = (PSLanguageResDTO)PSModelServiceUtil.getInstance().getPSLanguageResService().getDTO(dto.getContentPSLanResId());
            dto.setContentPSLanResName(((PSLanguageResDTO)linkDTO).getPSLanguageResName());
        } else {
            dto.setContentPSLanResName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSCtrlMsgId())) {
            linkDTO = (PSCtrlMsgDTO)PSModelServiceUtil.getInstance().getPSCtrlMsgService().getDTO(dto.getPSCtrlMsgId());
            dto.setPSCtrlMsgName(((PSCtrlMsgDTO)linkDTO).getPSCtrlMsgName());
        } else {
            dto.setPSCtrlMsgName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSCTRLMSGITEM";
    }

    @Override
    public PSCtrlMsgItem createDomain() {
        return new PSCtrlMsgItem();
    }

    @Override
    public PSCtrlMsgItemDTO createDTO() {
        return new PSCtrlMsgItemDTO();
    }
}

