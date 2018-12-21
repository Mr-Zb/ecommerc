package com.fun.le.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.framework.support.BusinessException;
import com.fun.le.entities.SchSchemeOffer;
import com.fun.le.repository.SchSchemeOfferMapper;

@Service
public class SchSchemeOfferService  {

	@Autowired
	private SchSchemeOfferMapper schSchemeOfferMapper;

	public Integer insert(Integer userId, SchSchemeOffer schSchemeOffer) throws BusinessException {
		schSchemeOffer.setCreateTime(new Date());
		schSchemeOffer.setCreateUser(userId);
		schSchemeOffer.setUpdateTime(new Date());
		schSchemeOffer.setUpdateUser(userId);
		schSchemeOffer.setDataVersion(Integer.valueOf(1));
		return this.schSchemeOfferMapper.insert(schSchemeOffer);
	}

	public Integer insert(Integer userId, List<SchSchemeOffer> schSchemeOffers) throws BusinessException {
		for (SchSchemeOffer schSchemeOffer : schSchemeOffers) {
			schSchemeOffer.setCreateTime(new Date());
			schSchemeOffer.setCreateUser(userId);
			schSchemeOffer.setUpdateTime(new Date());
			schSchemeOffer.setUpdateUser(userId);
			schSchemeOffer.setDataVersion(Integer.valueOf(1));
		}
		return this.schSchemeOfferMapper.insertBatch(schSchemeOffers);
	}

	public Integer update(Integer userId, SchSchemeOffer schSchemeOffer, SchSchemeOffer where)
			throws BusinessException {
		schSchemeOffer.setUpdateTime(new Date());
		schSchemeOffer.setUpdateUser(userId);
		return this.schSchemeOfferMapper.update(schSchemeOffer, where);
	}

	public Integer updateById(Integer userId, SchSchemeOffer schSchemeOffer, Integer schSchemeOfferId)
			throws BusinessException {
		schSchemeOffer.setUpdateTime(new Date());
		schSchemeOffer.setUpdateUser(userId);
		return this.schSchemeOfferMapper.updateById(schSchemeOffer, schSchemeOfferId);
	}

	public Integer updateActive(Integer userId, SchSchemeOffer schSchemeOffer, SchSchemeOffer where)
			throws BusinessException {
		schSchemeOffer.setUpdateTime(new Date());
		schSchemeOffer.setUpdateUser(userId);
		return this.schSchemeOfferMapper.updateActive(schSchemeOffer, where);
	}

	public Integer updateActiveById(Integer userId, SchSchemeOffer schSchemeOffer, Integer schSchemeOfferId)
			throws BusinessException {
		schSchemeOffer.setUpdateTime(new Date());
		schSchemeOffer.setUpdateUser(userId);
		return this.schSchemeOfferMapper.updateActiveById(schSchemeOffer, schSchemeOfferId);
	}

	public List<SchSchemeOffer> select(Integer userId, SchSchemeOffer schSchemeOffer) throws BusinessException {
		return this.schSchemeOfferMapper.select(schSchemeOffer);
	}

	public SchSchemeOffer selectById(Integer userId, Integer schSchemeOfferId) throws BusinessException {
		return this.schSchemeOfferMapper.selectById(schSchemeOfferId);
	}

	public Integer delete(Integer userId, SchSchemeOffer where) throws BusinessException {
		return this.schSchemeOfferMapper.delete(where);
	}

	public Integer deleteById(Integer userId, Integer schSchemeOfferId) throws BusinessException {
		return this.schSchemeOfferMapper.deleteById(schSchemeOfferId);
	}
}
