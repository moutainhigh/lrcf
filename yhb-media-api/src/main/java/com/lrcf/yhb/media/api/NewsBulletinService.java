package com.lrcf.yhb.media.api;


import com.lrcf.yhb.common.vo.NewsVo;
import com.lrcf.yhb.pojo.ArticleDetail;
import com.lrcf.yhb.pojo.BaseNews;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: NewsBulletinService.java
 * @Description: 新闻公告同意接口
 * @version: v1.0.0
 * @author: wangxf
 * @date: 2017年5月10日 下午1:02:04
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2017年5月10日     wangxf           v1.0.0               修改原因
 */
public interface NewsBulletinService {

	/**
	 * @Function: NewsBulletinServiceImpl.java
	 * @Description: 根据类型获取相应的数据信息， 1:新闻、2：公告、3：温馨提示
	 * @param: Byte newsType 文章类型: 1,新闻;2,公告;3.温馨提示
	 * @param: Integer state 文章类型状态: 1：未删除   0：已删除
	 * @param: String condition 查询的额外条件 （可以为空）
	 * @return： List<ArticleDetail>
	 * @throws：
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月10日 下午12:52:55
	 * <p>
	 * Modification History:
	 * Date         Author         Version            Description
	 * ---------------------------------------------------------*
	 * 2017年5月10日     wangxf           v1.0.0               修改原因
	 */
	List<ArticleDetail> getNewsBulletinsInfo(Byte newsType, Integer state, String condition);

	/**
	 * @Function: NewsBulletinController.java
	 * @Description: 为首页新闻列表信息获取生成出参:8 条数据
	 * @param: List<ArticleDetail> articleDetailList
	 * @return： Map<String, List<Map<String, Object>>>
	 * @throws：
	 * @version: v1.0.0
	 * @author: wangxf
	 * @date: 2017年5月10日 下午3:37:26
	 * <p>
	 * Modification History:
	 * Date         Author          Version            Description
	 * ---------------------------------------------------------*
	 * 2017年5月10日     wangxf           v1.0.0               修改原因
	 */
	Map<String, List<Map<String, Object>>> createReturnMap(List<ArticleDetail> articleDetailList);


	/**
	 * @Function: NewsBulletinController.java
	 * @Description: 获取新闻详情相关信息
	 * @param: id
	 * @return： Map<String, Object>
	 * @throws：
	 * @version: v1.0.0
	 * @author: Krx
	 * @date: 2017年5月10日 下午3:37:26
	 */
	Map<String, Object> getNewsContentDetail(Integer id, String type);

	/**
	 * @Function: NewsBulletinController.java
	 * @Description: 获取新闻或公告数据总数
	 * @param: type
	 * @return： Integer
	 * @throws：
	 * @version: v1.0.0
	 * @author: Krx
	 * @date: 2017年5月10日 下午3:37:26
	 */
	Integer getNoticeOrNewsCount(Integer type);

	/**
	 * @Function: NewsBulletinController.java
	 * @Description: 获取新闻或公告列表
	 * @param: type
	 * @return： Integer
	 * @throws：
	 * @version: v1.0.0
	 * @author: Krx
	 * @date: 2017年5月10日 下午3:37:26
	 */
	List<NewsVo> getNoticeOrNewsList(Map<String, Object> param);


	/***
	 * 获取首页滚动公告
	 * @return
	 */
	BaseNews getIndexNotice();
}