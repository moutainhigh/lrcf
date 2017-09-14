package com.lrcf.yhb.media.service;

import com.lrcf.yhb.common.enums.CommonTypeEnums;
import com.lrcf.yhb.common.util.DateUtil;
import com.lrcf.yhb.common.vo.NewsVo;
import com.lrcf.yhb.dao.mapper.ArticleDetailDao;
import com.lrcf.yhb.dao.mapper.BaseNewsDao;
import com.lrcf.yhb.media.api.NewsBulletinService;
import com.lrcf.yhb.pojo.ArticleDetail;
import com.lrcf.yhb.pojo.BaseNews;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
* @ClassName: NewsBulletinService.java
* @Description: 新闻公告同意接口
*
* @version: v1.0.0
* @author: wangxf
* @date: 2017年5月10日 下午1:02:04 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年5月10日     wangxf           v1.0.0               修改原因
 */
@Service("newsBulletinService")
public class NewsBulletinServiceImpl implements NewsBulletinService {
	
	@Autowired
	ArticleDetailDao articleDetailDao;
	@Autowired
	BaseNewsDao baseNewsDao;
	
	/**
	 * 
	* @Function: NewsBulletinServiceImpl.java
	* @Description: 根据类型获取相应的数据信息， 1:新闻、2：公告、3：温馨提示
	*
	* @param: Byte newsType 文章类型: 1,新闻;2,公告;3.温馨提示
	* @param: Integer state 文章类型状态: 1：未删除   0：已删除
	* @param: String condition 查询的额外条件 （可以为空）
	* @return： List<ArticleDetail>
	* @throws： 
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月10日 下午12:52:55 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月10日     wangxf           v1.0.0               修改原因
	 */
	public List<ArticleDetail> getNewsBulletinsInfo(Byte newsType, Integer state, String condition){
		Map params = new HashMap();
		// 文章类型
		if( null != newsType && newsType != 0 ){
			params.put("type", newsType);
		}
		// 是否删除
		if( null != state ){
			params.put("state", state);
		}
		
		// 默认以发布时间从大到小排序
		if( StringUtils.isNotBlank(condition) ){
			params.put("condition", condition);
		}

		return articleDetailDao.selectNewsByTypeAndOrder(params);
	}
	
	/**
	 * 
	* @Function: NewsBulletinController.java
	* @Description: 为首页新闻列表信息获取生成出参:8 条数据
	*
	* @param: 
	* @return： 
	* @throws： 
	*
	* @version: v1.0.0
	* @author: wangxf
	* @date: 2017年5月10日 下午3:37:26 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年5月10日     wangxf           v1.0.0               修改原因
	 */
	public Map<String, List<Map<String, Object>>> createReturnMap( List<ArticleDetail> articleDetailList ){
		
		if( null == articleDetailList || articleDetailList.size() < 1 ){
			return null;
		}
		
		Map<String, List<Map<String, Object>>> returnList = new HashMap<String, List<Map<String, Object>>>();
				
		// 新闻列表
		List<Map<String, Object>> newsList = new ArrayList<Map<String, Object>>();
		// 新闻信息集合
		Map<String, Object> newsMap = null;
		ArticleDetail articleDetail = null;
		
		for( int i=0 ; i < articleDetailList.size() ; i++ ){
			
			newsMap = new HashMap<String, Object>();
			articleDetail = articleDetailList.get(i);
			// 是内联 in 外联 out
			String type = CommonTypeEnums.NEWS_TYPE_IN.getCodeValue();
			
			// 判断是否为视频类新闻   
			if( StringUtils.isNotBlank( articleDetail.getVideoAddress() ) ){
				type = CommonTypeEnums.NEWS_TYPE_OUT.getCodeValue();
			} 
			
			if( articleDetailList.size() - i == 2 ){
				// 文字新闻
				returnList.put("textList", newsList);
				newsList = new ArrayList<Map<String, Object>>();
			}
			
			// 获取时间
			String time = DateUtil.getDateMonth(articleDetail.getCreateTime())
						  + "."
						  + DateUtil.getDateDay(articleDetail.getCreateTime());
			newsMap.put("type", type);
			newsMap.put("id", articleDetail.getId());
			newsMap.put("img", StringUtils.isBlank(articleDetail.getImgAddress()) ? "" : articleDetail.getImgAddress());
			newsMap.put("title", StringUtils.isBlank(articleDetail.getTitle()) ? "" : articleDetail.getTitle());
			newsMap.put("link", StringUtils.isBlank(articleDetail.getVideoAddress()) ? "" : articleDetail.getVideoAddress());
			newsMap.put("time", time);
			
			newsList.add(newsMap);
		}
		
		// 图片新闻
		returnList.put("picList", newsList);
		
		return returnList;
	}

	/**
	 * @param id
	 * @Function: NewsBulletinController.java
	 * @Description: 获取新闻详情相关信息
	 * @param: id
	 * @return： Map<String, Object>
	 * @throws：
	 * @version: v1.0.0
	 * @author: Krx
	 * @date: 2017年5月10日 下午3:37:26
	 */
	@Override
	public Map<String, Object> getNewsContentDetail(Integer id,String type) {
		Map<String, Object> param = new HashMap();
		if (id == null) {
			return null;
		}
		param.put("Id", id);
		param.put("type",type);
		List<ArticleDetail> articleDetailList = articleDetailDao.selectNewsDetail(param);
		param.clear();

		Map<String, Object> provious = new HashMap<String, Object>();
		Map<String, Object> next = new HashMap<String, Object>();
		for (ArticleDetail articleDetail : articleDetailList) {
			if (articleDetail.getId().equals(id)) {
				param.put("content", articleDetail.getContext());
				param.put("time", articleDetail.getCreateTime());
				param.put("origin","余惠宝");
				param.put("title",articleDetail.getTitle());
			}

			if(articleDetail.getId() < id){
				provious.put("title", articleDetail.getTitle());
				provious.put("id", articleDetail.getId());
			}

			if(articleDetail.getId() > id){
				next.put("title", articleDetail.getTitle());
				next.put("id", articleDetail.getId());
			}
		}
		param.put("previous", provious == null ? "" : provious);
		param.put("next", next == null ? "" : next);
		return param;
	}

	/**
	 * @param type
	 * @Function: NewsBulletinController.java
	 * @Description: 获取新闻或公告数据总数
	 * @param: type
	 * @return： Integer
	 * @throws：
	 * @version: v1.0.0
	 * @author: Krx
	 * @date: 2017年5月10日 下午3:37:26
	 */
	@Override
	public Integer getNoticeOrNewsCount(Integer type) {
		return articleDetailDao.getNoticeOrNewsCount(type);
	}

	/**
	 * @param param
	 * @Function: NewsBulletinController.java
	 * @Description: 获取新闻或公告列表
	 * @param: type
	 * @return： Integer
	 * @throws：
	 * @version: v1.0.0
	 * @author: Krx
	 * @date: 2017年5月10日 下午3:37:26
	 */
	@Override
	public List<NewsVo> getNoticeOrNewsList(Map<String, Object> param) {
		//获取页数
		Integer page = Integer.parseInt(param.get("current").toString());
		//每页显示多少记录数
		Integer size = Integer.parseInt(param.get("size").toString());
		//类型
		Integer type = Integer.parseInt(param.get("type").toString());
		//重新计算页数
		param.remove("current");

		param.put("current",(page - 1) * size);

		List<ArticleDetail> articleDetailList = articleDetailDao.getNewsOrNoticeList(param);

		List<NewsVo> newsOrNoticeVos = new ArrayList<>();
		NewsVo vo = null;
		if(type.equals(1)) {
			for (ArticleDetail articleDetail : articleDetailList) {
				vo = new NewsVo();

				vo.setTime(DateUtil.parseToDateTimeStr(articleDetail.getTime()));
				vo.setTitle(articleDetail.getTitle());
				vo.setImg(articleDetail.getImg());
				vo.setSummary(articleDetail.getSummary());
				vo.setId(articleDetail.getId());

				newsOrNoticeVos.add(vo);
			}
		}else{
			for (ArticleDetail articleDetails : articleDetailList) {
				vo = new NewsVo();

				vo.setTime(DateUtil.parseToDateTimeStr(articleDetails.getTime()));
				vo.setTitle(articleDetails.getTitle());
				vo.setId(articleDetails.getId());

				newsOrNoticeVos.add(vo);
			}
		}

		return newsOrNoticeVos;
	}

	/***
	 * 获取首页滚动公告
	 * @return
	 */
	@Override
	public BaseNews getIndexNotice() {
		return baseNewsDao.getIndexNotice();
	}
}
