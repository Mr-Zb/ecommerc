package com.fun.le.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fun.le.entities.SchSchemeOffer;
@Mapper
public interface SchSchemeOfferMapper
{
  Integer insert(@Param("schSchemeOffer") SchSchemeOffer paramSchSchemeOffer);

  Integer insertBatch(@Param("schSchemeOffers") List<SchSchemeOffer> paramList);

  Integer update(@Param("schSchemeOffer") SchSchemeOffer paramSchSchemeOffer1, @Param("where") SchSchemeOffer paramSchSchemeOffer2);

  Integer updateById(@Param("schSchemeOffer") SchSchemeOffer paramSchSchemeOffer, @Param("schSchemeOfferId") Integer paramInteger);

  Integer updateActive(@Param("schSchemeOffer") SchSchemeOffer paramSchSchemeOffer1, @Param("where") SchSchemeOffer paramSchSchemeOffer2);

  Integer updateActiveById(@Param("schSchemeOffer") SchSchemeOffer paramSchSchemeOffer, @Param("schSchemeOfferId") Integer paramInteger);

  List<SchSchemeOffer> select(@Param("schSchemeOffer") SchSchemeOffer paramSchSchemeOffer);

  SchSchemeOffer selectById(@Param("schSchemeOfferId") Integer paramInteger);

  Integer delete(@Param("where") SchSchemeOffer paramSchSchemeOffer);

  Integer deleteById(@Param("schSchemeOfferId") Integer paramInteger);
}

