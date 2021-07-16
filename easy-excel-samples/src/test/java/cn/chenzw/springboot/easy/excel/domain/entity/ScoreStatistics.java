package cn.chenzw.springboot.easy.excel.domain.entity;


/**
 * 分数原始表
 * @author fizh
 */
public class ScoreStatistics {
    private String kpiId; // 指标编码
    private String kpiName; // 指标名称
    private String statMonth; // 统计月份
    private String regionCode; // 区域编码
    private String regionName; // 区域名称
    private String textNum; // 次数
    private String numerator; // 分子
    private String denominator; // 分母
    private String rate; // 比率
    private Long fileId;

    private String evaluationType;

    private String evaluationTypeText;

    private String pKpi;

    private String pKpiText;

    public String getKpiId() {
        return kpiId;
    }

    public void setKpiId(String kpiId) {
        this.kpiId = kpiId;
    }

    public String getKpiName() {
        return kpiName;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public String getStatMonth() {
        return statMonth;
    }

    public void setStatMonth(String statMonth) {
        this.statMonth = statMonth;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getTextNum() {
        return textNum;
    }

    public void setTextNum(String textNum) {
        this.textNum = textNum;
    }

   public String getNumerator() {
        return numerator;
    }

    public void setNumerator(String numerator) {
        this.numerator = numerator;
    }

    public String getDenominator() {
        return denominator;
    }

    public void setDenominator(String denominator) {
        this.denominator = denominator;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public String getpKpi() {
        return pKpi;
    }

    public void setpKpi(String pKpi) {
        this.pKpi = pKpi;
    }

    public String getEvaluationTypeText() {
        return evaluationTypeText;
    }

    public void setEvaluationTypeText(String evaluationTypeText) {
        this.evaluationTypeText = evaluationTypeText;
    }

    public String getpKpiText() {
        return pKpiText;
    }

    public void setpKpiText(String pKpiText) {
        this.pKpiText = pKpiText;
    }
}
