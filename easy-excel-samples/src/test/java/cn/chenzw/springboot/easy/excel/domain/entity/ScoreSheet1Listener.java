package cn.chenzw.springboot.easy.excel.domain.entity;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelAnalysisException;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class ScoreSheet1Listener extends AnalysisEventListener<ScoreSheet1Template> {

    private Pattern monthPattern = Pattern.compile("(?<month>\\d+)月份");

    private String month;

    private List<ScoreStatistics> scoreStatistics;

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        String head = headMap.get(1);
        Matcher matcher = monthPattern.matcher(head);
        if (!matcher.find()) {
            throw new ExcelAnalysisException("获取不到头部月份");
        }
        this.month = matcher.group("month");

        log.info("解析到一条头数据:{}", headMap);
    }

    @Override
    public void invoke(ScoreSheet1Template scoreSheet1Template, AnalysisContext analysisContext) {
        if (analysisContext.readSheetHolder().getRowIndex() > 3) {

            log.info("Sheet{}第{}行 => {}", analysisContext.readSheetHolder().getSheetNo(),
                    analysisContext.readSheetHolder().getRowIndex(),
                    scoreSheet1Template);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
