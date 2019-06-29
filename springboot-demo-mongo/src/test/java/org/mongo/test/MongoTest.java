package org.mongo.test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongo.demo.Application;
import org.mongo.demo.dto.ApiLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AccumulatorOperators.Sum;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MongoTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void findTest() throws ParseException {
		Date begin = DateUtils.parseDate("2018-01-01", "yyyy-MM-dd");
		Date end = DateUtils.parseDate("2018-09-01", "yyyy-MM-dd");
		Query query = new Query(Criteria.where("createDate").gte(begin).lt(end).and("sysNo").is("MQY")).limit(2);
		query.with(Sort.by("createDate").descending());
		List<ApiLogs> list = mongoTemplate.find(query, ApiLogs.class, "demo");
		list.iterator().forEachRemaining(log -> {
			System.out.println(JSON.toJSONString(log, true));
		});
	}

	@Test
	public void groupTest() {
		GroupBy groupBy = new GroupBy("goodType").initialDocument("{count:0}").reduceFunction("function(doc, out){out.count++}")
				.finalizeFunction("function(out){return out;}");
		GroupByResults<ApiLogs> result = mongoTemplate.group(Criteria.where("goodsId").is("GKXZ-22222"), "apiLogs", groupBy, ApiLogs.class);
		System.out.println(JSON.toJSONString(result.getRawResults(), true));
	}

	// 单个字段分组
	@Test
	public void aggregationTest() {
		Criteria criteria = Criteria.where("goodsId").is("GKXZ-22222");
		Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(criteria), Aggregation.group("goodType").count().as("count"),
				Aggregation.project("goodType", "count").and("goodType").previousOperation());
		AggregationResults<Document> aggregationResults = mongoTemplate.aggregate(aggregation, "apiLogs", Document.class);
		aggregationResults.iterator().forEachRemaining(doc -> {
			System.out.println(JSON.toJSONString(doc, true));
		});
	}

	// 多个字段分组
	@Test
	public void aggregationTest2() {
		Criteria criteria = Criteria.where("goodsId").is("GKXZ-22222");
		Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(criteria), Aggregation.group("goodType", "goodsId").count().as("count"));
		AggregationResults<Document> aggregationResults = mongoTemplate.aggregate(aggregation, "apiLogs", Document.class);
		aggregationResults.iterator().forEachRemaining(doc -> {
			System.out.println(JSON.toJSONString(doc, true));
		});
	}

	// 统计某个字段之和
	@Test
	public void aggregationTest4() {
		Criteria criteria = Criteria.where("sysNo").is("MQY");
		Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(criteria), Aggregation.group("null").sum(Sum.sumOf("maxNum")).as("total"));
		AggregationResults<Document> aggregationResults = mongoTemplate.aggregate(aggregation, "apiLogs", Document.class);
		aggregationResults.iterator().forEachRemaining(doc -> {
			System.out.println(JSON.toJSONString(doc, true));
		});
	}

	// 统计某个字段之和
	@Test
	public void findAndModify() {

	}
}
