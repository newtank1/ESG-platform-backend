package com.platform.esgplatformbackend.service.impl;

import com.platform.esgplatformbackend.dao.*;
import com.platform.esgplatformbackend.model.po.*;
import com.platform.esgplatformbackend.model.vo.*;
import com.platform.esgplatformbackend.service.AdminService;
import com.platform.esgplatformbackend.util.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private CorporationBasicMapper corporationBasicMapper;
    @Resource
    private CorporationESGMapper corporationESGMapper;
    @Resource
    private CorporationOpinionMapper corporationOpinionMapper;
    @Resource
    private CorporationStockMapper corporationStockMapper;
    @Resource
    private CorporationEventMapper corporationEventMapper;
    @Resource
    private CorporationESGScoreMapper corporationESGScoreMapper;
    @Resource
    private CorporationHistoryMapper corporationHistoryMapper;
    @Override
    public ResultVO<CorporationBasicVo> addCorporation(CorporationBasicVo corp) {
        CorporationBasicPo po = corporationBasicMapper.getCorporationByName(corp.getName());
        if(po!=null) return new ResultVO<>(Constant.REQUEST_FAIL, "公司已创建",new CorporationBasicVo(po));
        po=new CorporationBasicPo(corp);
        if (po.getIntroduction() == null) {
            po.setIntroduction("null");
        }
        int insert = corporationBasicMapper.insert(po);
        if(insert==1) return new ResultVO<>(Constant.REQUEST_SUCCESS,"创建公司成功", new CorporationBasicVo(po));
        else return new ResultVO<>(Constant.REQUEST_FAIL, "创建公司失败");
    }

    @Override
    public ResultVO<CorporationBasicVo> updateCorporationBasic(CorporationBasicVo corp) {
        int corporation_id = corp.getCorporation_id();
        String name = corp.getName();
        int stoke = corp.getStoke();
        String industry = corp.getIndustry();
        String location = corp.getLocation();
        String introduction=corp.getIntroduction();
        if (introduction == null) {
            introduction="null";
        }
        int update = corporationBasicMapper.update(name,stoke,industry,location,corporation_id,introduction);

        if(update==1) return new ResultVO<>(Constant.REQUEST_SUCCESS, "更新公司基本信息成功", corp);
        else return new ResultVO<>(Constant.REQUEST_FAIL, "更新公司基本信息失败");
    }

    @Override
    public ResultVO<CorporationESGVo> addESG(CorporationESGVo vo) {
        CorporationESGPo po=corporationESGMapper.getESGByCorporationId(vo.getCorporation_id());
        if (po != null) {
            return new ResultVO<>(Constant.REQUEST_FAIL, "公司ESG信息已存在",new CorporationESGVo(po));
        }
        po=new CorporationESGPo(vo);
        int insert=corporationESGMapper.insert(po);
        if(insert==1) return new ResultVO<>(Constant.REQUEST_SUCCESS,"成功",new CorporationESGVo(po));
        return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
    }

    @Override
    public ResultVO<CorporationESGVo> updateESG(CorporationESGVo vo) {
        int update=corporationESGMapper.update(vo.getRecord_id(), vo.getCorporation_id());
        if(update==1) return new ResultVO<>(Constant.REQUEST_SUCCESS,"成功",vo);
        return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
    }

    @Override
    public ResultVO<CorporationESGHistoryVo> submitESGHistory(CorporationESGHistoryVo vo) {
        int update=corporationHistoryMapper.update(new CorporationESGHistoryPo(vo));
        if(update==1) return new ResultVO<>(Constant.REQUEST_SUCCESS,"成功",vo);
        return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
    }

    @Override
    public ResultVO<CorporationESGHistoryVo> addESGHistory(CorporationESGHistoryVo vo) {
        CorporationESGHistoryPo po=new CorporationESGHistoryPo(vo);
        int insert=corporationHistoryMapper.insert(po);
        if(insert==1) return new ResultVO<>(Constant.REQUEST_SUCCESS,"成功",new CorporationESGHistoryVo(po));
        return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
    }

    @Override
    public ResultVO<CorporationESGScoreVo> submitScore(CorporationESGScoreVo vo) {
        CorporationESGScorePo po=new CorporationESGScorePo(vo);
        int insert=corporationESGScoreMapper.insert(po);
        if(insert==1) return new ResultVO<>(Constant.REQUEST_SUCCESS,"成功",new CorporationESGScoreVo(po));
        return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
    }


    @Override
    public ResultVO<CorporationOpinionVo> submitOpinion(CorporationOpinionVo vo) {
        int line = corporationOpinionMapper.insert(new CorporationOpinionPo(vo));
        if(line==1){
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "成功", vo);
        }else{
            return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
        }
    }

    @Override
    public ResultVO<CorporationEventVo> submitEvent(CorporationEventVo vo) {
        int line = corporationEventMapper.insert(new CorporationEventPo(vo));
        if(line==1){
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "成功", vo);
        }else{
            return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
        }
    }

    @Override
    public ResultVO<CorporationStockVo> submitStock(CorporationStockVo vo) {
        int line = corporationStockMapper.insert(new CorporationStockPo(vo));
        if(line==1){
            return new ResultVO<>(Constant.REQUEST_SUCCESS, "成功", vo);
        }else{
            return new ResultVO<>(Constant.REQUEST_FAIL, "失败");
        }
    }

    @Override
    public ResultVO<List<CorporationESGScoreVo>> getESGScore(Integer corporation_id) {
        List<CorporationESGScorePo> pos = corporationESGScoreMapper.getByCorporationId(corporation_id);
        List<CorporationESGScoreVo> res=new ArrayList<>();
        for (CorporationESGScorePo po : pos) {
            res.add(new CorporationESGScoreVo(po));
        }
        return new ResultVO<>(Constant.REQUEST_SUCCESS,"success",res);
    }
}
