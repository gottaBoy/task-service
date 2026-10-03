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
import net.ibizsys.modelapi.domain.PSDENotify;
import net.ibizsys.modelapi.domain.PSDENotifyTarget;
import net.ibizsys.modelapi.dto.PSDEFieldDTO;
import net.ibizsys.modelapi.dto.PSDENotifyDTO;
import net.ibizsys.modelapi.dto.PSDENotifyTargetDTO;
import net.ibizsys.modelapi.dto.PSSysMsgTargetDTO;
import net.ibizsys.modelapi.service.IPSDENotifyTargetService;
import net.ibizsys.modelapi.util.IPSModel;
import net.ibizsys.modelapi.util.PSModelDTOBase;
import net.ibizsys.modelapi.util.PSModelServiceImplBase;
import net.ibizsys.modelapi.util.PSModelServiceUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSDENotifyTargetServiceImpl
extends PSModelServiceImplBase<PSDENotifyTarget, PSDENotifyTargetDTO>
implements IPSDENotifyTargetService {
    private static final Log log = LogFactory.getLog(PSDENotifyTargetServiceImpl.class);

    @Override
    public List<PSDENotifyTarget> listByPSDENotify(PSDENotify parent) throws Exception {
        return this.listAll(parent, true, true);
    }

    @Override
    public PSDENotifyTarget get(PSDENotify parent, String strKey, boolean bTryMode) throws Exception {
        List<PSDENotifyTarget> list = this.listByPSDENotify(parent);
        if (list != null) {
            for (PSDENotifyTarget item : list) {
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
    public List<PSDENotifyTargetDTO> listDTOByPSDENotify(String strParentKey) throws Exception {
        PSDENotify psdenotify = (PSDENotify)PSModelServiceUtil.getInstance().getPSDENotifyService().get(strParentKey);
        List<PSDENotifyTarget> list = this.listByPSDENotify(psdenotify);
        if (list != null) {
            ArrayList<PSDENotifyTargetDTO> dtoList = new ArrayList<PSDENotifyTargetDTO>();
            for (PSDENotifyTarget item : list) {
                PSDENotifyTargetDTO dto = (PSDENotifyTargetDTO)this.toDTO(item);
                dtoList.add(dto);
            }
            return dtoList;
        }
        return null;
    }

    @Override
    protected List<PSDENotifyTarget> onListAll() throws Exception {
        ArrayList<PSDENotifyTarget> list = new ArrayList<PSDENotifyTarget>();
        List<PSDENotify> psdenotifies = PSModelServiceUtil.getInstance().getPSDENotifyService().listAll();
        if (psdenotifies != null) {
            for (PSDENotify parent : psdenotifies) {
                List<PSDENotifyTarget> items = this.listByPSDENotify(parent);
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
    protected PSDENotifyTarget onGet(String strParentKey, String strCurKey) throws Exception {
        PSDENotifyTarget item;
        PSDENotify psdenotify = (PSDENotify)PSModelServiceUtil.getInstance().getPSDENotifyService().get(strParentKey, true);
        if (psdenotify != null && (item = this.get(psdenotify, strCurKey, true)) != null) {
            return item;
        }
        return (PSDENotifyTarget)super.onGet(strParentKey, strCurKey);
    }

    @Override
    public IPSModel getParentModel(PSDENotifyTargetDTO dto) throws Exception {
        String strPickupValue = null;
        strPickupValue = dto.getPSDENotifyId();
        if (StringUtils.hasLength((String)strPickupValue)) {
            return PSModelServiceUtil.getInstance().getPSDENotifyService().get(strPickupValue, false);
        }
        return super.getParentModel(dto);
    }

    @Override
    public String getModelTag(PSDENotifyTarget et) throws Exception {
        return super.getModelTag(et);
    }

    @Override
    protected void onFillDTO(PSDENotifyTargetDTO dto, PSDENotifyTarget t, boolean bIgnoreNull) throws Exception {
        PSModelDTOBase linkDTO;
        if (StringUtils.hasLength((String)t.getId())) {
            dto.setPSDENotifyTargetId(t.getId().replace("/", "."));
        }
        if (t.getCreateDate() != null || !bIgnoreNull) {
            dto.setCreateDate(t.getCreateDate());
        }
        if (t.getCreateMan() != null || !bIgnoreNull) {
            dto.setCreateMan(t.getCreateMan());
        }
        if (t.getFilter() != null || !bIgnoreNull) {
            dto.setFilter(t.getFilter());
        }
        if (t.getMemo() != null || !bIgnoreNull) {
            dto.setMemo(t.getMemo());
        }
        if (t.getPSDEId() != null || !bIgnoreNull) {
            dto.setPSDEId(t.getPSDEId());
        }
        if (t.getPSDENotifyId() != null || !bIgnoreNull) {
            dto.setPSDENotifyId(t.getPSDENotifyId());
        }
        if (t.getPSDENotifyName() != null || !bIgnoreNull) {
            dto.setPSDENotifyName(t.getPSDENotifyName());
        }
        if (t.getPSDENotifyTargetName() != null || !bIgnoreNull) {
            dto.setPSDENotifyTargetName(t.getPSDENotifyTargetName());
        }
        if (t.getPSSysMsgTargetId() != null || !bIgnoreNull) {
            dto.setPSSysMsgTargetId(t.getPSSysMsgTargetId());
        }
        if (t.getPSSysMsgTargetName() != null || !bIgnoreNull) {
            dto.setPSSysMsgTargetName(t.getPSSysMsgTargetName());
        }
        if (t.getTargetPSDEFId() != null || !bIgnoreNull) {
            dto.setTargetPSDEFId(t.getTargetPSDEFId());
        }
        if (t.getTargetPSDEFName() != null || !bIgnoreNull) {
            dto.setTargetPSDEFName(t.getTargetPSDEFName());
        }
        if (t.getTargetType() != null || !bIgnoreNull) {
            dto.setTargetType(t.getTargetType());
        }
        if (t.getTargetTypePSDEFId() != null || !bIgnoreNull) {
            dto.setTargetTypePSDEFId(t.getTargetTypePSDEFId());
        }
        if (t.getTargetTypePSDEFName() != null || !bIgnoreNull) {
            dto.setTargetTypePSDEFName(t.getTargetTypePSDEFName());
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
        if (t.getValidFlag() != null || !bIgnoreNull) {
            dto.setValidFlag(t.getValidFlag());
        }
        if (StringUtils.hasLength((String)dto.getPSDENotifyId())) {
            dto.setPSDENotifyId(this.getRealPSModelId(t, dto.getPSDENotifyId()).replace("/", "."));
        }
        if ("PSDENOTIFY".compareTo(t.getSrfParent().getSrfType()) == 0 && StringUtils.hasLength((String)t.getSrfParent().getId())) {
            dto.setPSDENotifyId(t.getSrfParent().getId().replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTargetId())) {
            dto.setPSSysMsgTargetId(this.getRealPSModelId(t, dto.getPSSysMsgTargetId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTargetPSDEFId())) {
            dto.setTargetPSDEFId(this.getRealPSModelId(t, dto.getTargetPSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getTargetTypePSDEFId())) {
            dto.setTargetTypePSDEFId(this.getRealPSModelId(t, dto.getTargetTypePSDEFId()).replace("/", "."));
        }
        if (StringUtils.hasLength((String)dto.getPSDENotifyId())) {
            linkDTO = (PSDENotifyDTO)PSModelServiceUtil.getInstance().getPSDENotifyService().getDTO(dto.getPSDENotifyId());
            dto.setPSDEId(((PSDENotifyDTO)linkDTO).getPSDEId());
            dto.setPSDENotifyName(((PSDENotifyDTO)linkDTO).getPSDENotifyName());
        } else {
            dto.setPSDEId(null);
            dto.setPSDENotifyName(null);
        }
        if (StringUtils.hasLength((String)dto.getPSSysMsgTargetId())) {
            linkDTO = (PSSysMsgTargetDTO)PSModelServiceUtil.getInstance().getPSSysMsgTargetService().getDTO(dto.getPSSysMsgTargetId());
            dto.setPSSysMsgTargetName(((PSSysMsgTargetDTO)linkDTO).getPSSysMsgTargetName());
        } else {
            dto.setPSSysMsgTargetName(null);
        }
        if (StringUtils.hasLength((String)dto.getTargetPSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTargetPSDEFId());
            dto.setTargetPSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTargetPSDEFName(null);
        }
        if (StringUtils.hasLength((String)dto.getTargetTypePSDEFId())) {
            linkDTO = (PSDEFieldDTO)PSModelServiceUtil.getInstance().getPSDEFieldService().getDTO(dto.getTargetTypePSDEFId());
            dto.setTargetTypePSDEFName(((PSDEFieldDTO)linkDTO).getPSDEFieldName());
        } else {
            dto.setTargetTypePSDEFName(null);
        }
        super.onFillDTO(dto, t, bIgnoreNull);
    }

    @Override
    protected boolean isEnableTempData() {
        return true;
    }

    @Override
    public String getModelName() {
        return "PSDENOTIFYTARGET";
    }

    @Override
    public PSDENotifyTarget createDomain() {
        return new PSDENotifyTarget();
    }

    @Override
    public PSDENotifyTargetDTO createDTO() {
        return new PSDENotifyTargetDTO();
    }
}

