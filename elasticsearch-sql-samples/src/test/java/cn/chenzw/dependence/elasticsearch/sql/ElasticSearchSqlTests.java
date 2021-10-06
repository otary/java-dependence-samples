package cn.chenzw.dependence.elasticsearch.sql;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.iamazy.elasticsearch.dsl.sql.ElasticSql2DslParser;
import io.github.iamazy.elasticsearch.dsl.sql.model.ElasticSqlParseResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Slf4j
@RunWith(JUnit4.class)
public class ElasticSearchSqlTests {

    @Test
    public void testParser() {
        ElasticSql2DslParser elasticSql2DslParser = new ElasticSql2DslParser();
        ElasticSqlParseResult result = elasticSql2DslParser.parse("select name, id, shi from users where id = 1");

        log.info(" => {}", result.toPrettyDsl(result.getSearchRequest()));
        log.info("表名 => {}", result.getIndices());
    }

    @Test
    public void testUpadate() {
        ElasticSql2DslParser elasticSql2DslParser = new ElasticSql2DslParser();
        ElasticSqlParseResult result = elasticSql2DslParser.parse("UPDATE users set age = 10 where id =1");

        log.info(" => {}", result.getSearchRequest());
      //  log.info("表名 => {}", result.getIndices());
    }
}
