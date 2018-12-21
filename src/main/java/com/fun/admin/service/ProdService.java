package com.fun.admin.service;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.fun.framework.domain.Pagination;
import com.fun.framework.service.BaseService;
import com.fun.framework.web.dto.QueryDto;
import com.fun.le.service.LotGameInfoService;
import com.fun.le.service.LotLotteryIssueService;
import com.fun.le.service.LotOpenTimeService;
import com.fun.le.service.LotProductInfoService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fun.admin.repository.LotMapper;
import com.fun.framework.support.BusinessException;
import com.fun.framework.utils.CollectionUtils;
import com.fun.framework.utils.DateFormatUtils;
import com.fun.framework.utils.NumberUtils;
import com.fun.framework.utils.StringUtils;
import com.fun.le.entities.LotGameInfo;
import com.fun.le.entities.LotLotteryIssue;
import com.fun.le.entities.LotOpenTime;
import com.fun.le.entities.LotProductInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ProdService extends BaseService {
	@Autowired
	private LotProductInfoService productInfoService;
	@Autowired
	private LotGameInfoService gameInfoService;
	@Autowired
	private LotOpenTimeService openTimeService;
	@Autowired
	private LotLotteryIssueService lotteryIssueService;
	@Autowired
	private LotMapper lotMapper;

	@Cacheable(value = { "cache-prod-code-2-key" }, key = "#product")
	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
	public Integer getProdId(String product) throws BusinessException {
		if (StringUtils.isNotBlank( product)) {
			LotProductInfo productInfo = new LotProductInfo();
			productInfo.setProductAlias(product);
			List<LotProductInfo> list = (List<LotProductInfo>) this.productInfoService.select(0, productInfo);
			if (CollectionUtils.isNotEmpty(list)) {
				Iterator<LotProductInfo> iterator = list.iterator();
				if (iterator.hasNext()) {
					LotProductInfo info = iterator.next();
					return info.getPkId();
				}
			}
		}
		return NumberUtils.toInt(product);
	}

	@Cacheable(value = { "cache-game-code-2-key" }, key = "#game")
	public Integer getGameId(String game) throws BusinessException {
		if (StringUtils.isNotBlank( game)) {
			LotGameInfo gameInfo = new LotGameInfo();
			gameInfo.setGameAlias(game);
			List<LotGameInfo> list = (List<LotGameInfo>) this.gameInfoService.select(0, gameInfo);
			if (CollectionUtils.isNotEmpty(list)) {
				Iterator<LotGameInfo> iterator = list.iterator();
				if (iterator.hasNext()) {
					LotGameInfo info = iterator.next();
					return info.getPkId();
				}
			}
		}
		return NumberUtils.toInt(game);
	}

	@Cacheable(value = { "cache-prod-games-by-code" }, key = "#product")
	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
	public List<LotGameInfo> listGames(String product) throws BusinessException {
		int prodId = getProdId(product);
		if (prodId > 0) {
			PageHelper.orderBy("pk_id ASC");
			LotGameInfo gameInfo = new LotGameInfo();
			gameInfo.setProductId(prodId);
			return (List<LotGameInfo>) this.gameInfoService.select(1, gameInfo);
		}
		return Collections.emptyList();
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, readOnly = false)
	public void saveProduct(Integer userId, Integer prodId, String field, Integer value) throws BusinessException {
		LotProductInfo productInfo = this.getProdById(prodId);
		if (productInfo != null) {
			try {
				Field _field = LotProductInfo.class.getDeclaredField(field);
				_field.setAccessible(true);
				_field.set(productInfo, value);
				this.productInfoService.updateActiveById(userId, productInfo, prodId);
			} catch (Exception e) {
				throw new BusinessException(501, "\u4fdd\u5b58\u5931\u8d25", (Throwable) e);
			}
			this.putCache("cache-prod-prod-by-id", String.valueOf(prodId), (Object) productInfo);
		}
	}

	@Cacheable(value = { "cache-prod-prod-by-id" }, key = "#prodId + ''")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, readOnly = true)
	public LotProductInfo getProdById(Integer prodId) throws BusinessException {
		return this.productInfoService.selectById(0, prodId);
	}

	@Cacheable(value = { "cache-game-game-by-id" }, key = "#gameId + ''")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, readOnly = true)
	public LotGameInfo getGameById(Integer gameId) throws BusinessException {
		return this.gameInfoService.selectById(0, gameId);
	}

	@CacheEvict(value = { "cache-prod-games-by-code" }, allEntries = true)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, readOnly = false)
	public void saveGame(Integer userId, Integer gameId, String field, String value) throws BusinessException {
		LotGameInfo gameInfo = this.gameInfoService.selectById(userId, gameId);
		if (gameInfo != null) {
			try {
				Field _field = LotGameInfo.class.getDeclaredField(field);
				_field.setAccessible(true);
				_field.set(gameInfo, value);
				this.gameInfoService.updateActiveById(userId, gameInfo, gameId);
				this.putCache("cache-game-game-by-id", String.valueOf(gameId), (Object) gameInfo);
			} catch (Exception e) {
				throw new BusinessException(501, "\u4fdd\u5b58\u5931\u8d25", (Throwable) e);
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, readOnly = false)
	public void saveTime(Integer userId, Integer timeId, String field, Date value) throws BusinessException {
		LotOpenTime openTime = this.openTimeService.selectById(userId, timeId);
		if (openTime != null) {
			try {
				Field _field = LotOpenTime.class.getDeclaredField(field);
				_field.setAccessible(true);
				_field.set(openTime, value);
				this.openTimeService.updateActiveById(userId, openTime, timeId);
				String issue = openTime.getIssueSuffix();
				String product = StringUtils.left(String.valueOf(openTime.getProductId()), 2);
				String beginTime = DateFormatUtils.format(openTime.getBgnTime(), "HH:mm:ss");
				String endTime = DateFormatUtils.format(openTime.getEndTime(), "HH:mm:ss");
				String _openTime = DateFormatUtils.format(openTime.getOpenTime(), "HH:mm:ss");
				this.lotMapper.updateLotterIssueTimes(product, issue, beginTime, endTime, _openTime);
			} catch (Exception e) {
				throw new BusinessException(501, "\u4fdd\u5b58\u5931\u8d25", (Throwable) e);
			}
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
	public Pagination<LotLotteryIssue> listIssues(Integer prodId, Date beginDate, Date endDate,QueryDto queryDto)
			throws BusinessException {
        PageHelper.startPage(queryDto.getPage(), queryDto.getRows(), true);
		if (beginDate == null) {
			beginDate =  new DateTime(queryDto.getBeginDate()).withTime(0, 0, 0, 0).toDate();
		}
		if (endDate == null) {
			endDate = new DateTime(queryDto.getEndDate()).withTime(23, 59, 59, 999).toDate();
		}
		if (beginDate != null) {
			beginDate = new DateTime((Object) beginDate).withTime(0, 0, 0, 0).toDate();
		}
		if (endDate != null) {
			endDate = new DateTime((Object) endDate).withTime(23, 59, 59, 999).toDate();
		}
		Page<LotLotteryIssue> page = this.lotMapper.listIssues(prodId, beginDate, endDate);
		return new Pagination<>(page.getTotal(), page.getResult());
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class }, readOnly = false)
	public void uploadIssues(List<LotLotteryIssue> issues) throws BusinessException {
		if (CollectionUtils.isNotEmpty(issues)) {
			this.lotMapper.deleteIssuesByIds(
					StringUtils.join(issues.stream().map(LotLotteryIssue::getPkId).collect(Collectors.toList()), ","));
			List<LotLotteryIssue> list = issues.stream().map(issue -> {
				LotLotteryIssue lotteryIssue = new LotLotteryIssue();
				lotteryIssue.setPkId(issue.getPkId());
				lotteryIssue
						.setProductId(NumberUtils.toInt(StringUtils.left(String.valueOf(issue.getPkId()), 2) + "00"));
				lotteryIssue.setBgnTime(issue.getBgnTime());
				lotteryIssue.setEndTime(issue.getEndTime());
				lotteryIssue.setOpenTime(issue.getOpenTime());
				lotteryIssue.setOpenFlag(0);
				lotteryIssue.setOpenCode("");
				lotteryIssue.setOpenCodeScource(0);
				lotteryIssue.setLotteryIssue(issue.getLotteryIssue());
				lotteryIssue.setOpenFeature1("");
				lotteryIssue.setOpenFeature2("");
				lotteryIssue.setOpenFeature3("");
				lotteryIssue.setOpenFeature4("");
				lotteryIssue.setOpenFeature5("");
				lotteryIssue.setAmount1(0.0);
				lotteryIssue.setAmount2(0.0);
				lotteryIssue.setAmount3(0.0);
				lotteryIssue.setAmount4(0.0);
				return lotteryIssue;
			}).collect(Collectors.toList());
			this.lotteryIssueService.insert(0, list);
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = { Exception.class }, readOnly = true)
	public List<LotProductInfo> listProducts(String product) throws BusinessException {
		LotProductInfo productInfo = new LotProductInfo();
		if (StringUtils.isNotBlank( product)) {
			productInfo.setProductAlias(product);
		}
		List<LotProductInfo> list = (List<LotProductInfo>) this.productInfoService.select(0, productInfo);
		if (CollectionUtils.isNotEmpty(list)) {
			for (LotProductInfo info : list) {
				info.setCreateTime((Date) null);
				info.setUpdateTime((Date) null);
				info.setUpdateTime((Date) null);
				info.setUpdateUser((Integer) null);
				info.setDataVersion((Integer) null);
			}
		}
		return list;
	}
}
