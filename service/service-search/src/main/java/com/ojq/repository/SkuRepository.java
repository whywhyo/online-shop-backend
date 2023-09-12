package com.ojq.repository;


import com.ojq.search.SkuEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

//泛型第一部分是ES中数据的实体类，第二部分是主键类型
//这些接口中的方法会根据方法的命名约定和参数来生成Elasticsearch查询语句，具体实现会在Spring Data Elasticsearch自动生成的代理类中完成，并将结果映射为相应的Java对象。
public interface SkuRepository extends ElasticsearchRepository<SkuEs,Long> {

    //获取爆款商品
    Page<SkuEs> findByOrderByHotScoreDesc(Pageable pageable);

    //// 判断keyword是否为空，如果为空 ，根据仓库id + 分类id查询
    Page<SkuEs> findByCategoryIdAndWareId(Long categoryId, Long wareId, Pageable pageable);

    ///如果keyword不为空根据仓库id + keyword进行查询
    Page<SkuEs> findByKeywordAndWareId(String keyword, Long wareId, Pageable pageable);
    //List<SkuEs> findByOrderByHotScoreDesc();
}
