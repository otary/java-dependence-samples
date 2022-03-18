package cn.chenzw.dependence.hanlp.samples;

import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(JUnit4.class)
public class HanlpTests {

    private static final Segment N_SHORT_SEGMENT = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
    private static final Segment DIJKSTRA_SEGMENT = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);


    private static String standard(String text) {
        StringBuilder result = new StringBuilder();
        StandardTokenizer.segment(text).forEach(term -> result.append(term.word).append(" "));
        return result.toString();
    }

    private static String nlp(String text) {
        StringBuilder result = new StringBuilder();
        NLPTokenizer.segment(text).forEach(term -> result.append(term.word).append(" "));
        return result.toString();
    }

    private static String index(String text) {
        StringBuilder result = new StringBuilder();
        IndexTokenizer.segment(text).forEach(term -> result.append(term.word).append(" "));
        return result.toString();
    }

    private static String speed(String text) {
        StringBuilder result = new StringBuilder();
        SpeedTokenizer.segment(text).forEach(term -> result.append(term.word).append(" "));
        return result.toString();
    }

    private static String nShort(String text) {
        StringBuilder result = new StringBuilder();
        N_SHORT_SEGMENT.seg(text).forEach(term -> result.append(term.word).append(" "));
        return result.toString();
    }

    private static String shortest(String text) {
        StringBuilder result = new StringBuilder();
        DIJKSTRA_SEGMENT.seg(text).forEach(term -> result.append(term.word).append(" "));
        return result.toString();
    }

    private static String article = "昨天看了我初中喜欢的人在空间发的一篇关于怀念初中的短篇小说吧，记录了他对一些记忆深刻的人的评价，而我也看到了我明明一直清楚，却不肯打心底接受的真相，他喜欢另外一个人，过往那么多的蛛丝马迹，那么多明明一件事就能看出他喜欢的人是她的真相，可我却是宁愿找借口自欺欺人，而今他给出坦白答案，他是放下了，才说出来，我是不是也该放下了，直到今日才明白我一个人自以为刻骨铭心的回忆，他也许早就忘怀，他的短篇小说故事中我没有丝言片语，也许若干年后他回想起来的只是我的名字，我只是个戏子，在他的故事中流着自己的泪，一个于他青春年华中不曾使他掀起过一丝波澜的模糊影子，而他不知道也永远不会知道，我的故事里他出现的很多，占了很多篇幅，我把他写进我的故事，因为他路过我心上，他踏着万千星河而来，又乘舟奔赴远方，我与春风皆过客，你携秋水揽星河。如今看来万般故事不过情伤，易水人去，明月如霜。\n" +
            "\n" +
            "　　他是无意穿堂风，却偏偏孤据引山洪。我是垂眉摆渡翁，却独独偏爱哝。\n" +
            "\n" +
            "　　忽然想起那年夏日毕业之际，我送他的藏头巧妙情诗，还有在QQ的匿名坦白说，还有我第一次鼓起勇气隐晦的告白，毕业后我想着也许在我们笑着说再见时候深知再见遥遥无期，我想过叫他一起来学习预习新课，如今想想对我而言珍贵如斯，因为整整初中三年我都喜欢他，从始至终，从一开始和他一个组，就喜欢他。可是我也心里早已隐隐知道他喜欢的是另外一个人，我怕喜欢被他知道，也怕他不知道，又怕他装作不知道，总是假装不在意他，却总是留意他的消息，其实也是只要他没有说出来证实那个我知道他喜欢另外一个人的猜想，我就还抱着一丝期待，才没办法停止喜欢。这世上最安慰人的童话是，你挖空心思暗恋的人，他也挖空心思暗恋你，可惜这只是童话。\n" +
            "\n" +
            "　　我记得我无数次点开对话框，却只好失望的再关掉。我好多时候都想着万一他真的喜欢是她，我应该狠下心割舍这份感情，毕竟我不想太黯然神伤，我总是假装不在意远离他，不是因为讨厌陌生，而是太喜欢，又怕表现的明显，明知道没有什么可能不想陷入的更深。有那么一些瞬间，我假装不在意的擦肩而过，恰好离他很近，几分毫之差，却像是我们之间隔了银河的距离。走不进他的世界，却不想退出，现在想想初中三年除了开始在一个小组过，就没有再怎么交集过多少，毕业后反倒可以频繁的交集，我很珍惜，也行对他而言不过尔尔，充其量我只能算是他一个普通朋友。\n" +
            "\n" +
            "　　犹记得那次初三模考后不好，本来就难受从未那么差过，可是他在安慰另外一个人，我就更难过。多少次狠下心不想喜欢，却是告终。\n" +
            "\n" +
            "　　比如毕业后，我开着玩笑跟他要生日礼物，终究是一纸空话，而我也知道也许他是不想给也就罢了，毕竟我什么都算不上吧，还有我那次想叫他去看电影，看最好的我们，我是有目的，听说电影的最后彩蛋是告白带来这里一起看电影的人是为了对他告白，可惜他没去，我和我一个很好的闺蜜去了电影院。\n" +
            "\n" +
            "　　其实毕业后，我有过暗示，他懂了，懂了后是沉默，我早该明白的，沉默就是答案，躲闪就是答案，不过是留一个情面给我，互相都不要太过难堪，他也不知道，我很多说说日志写着是希望他能看到的，虽然有些不是我的原创，却带着我的心声，他不曾懂过。也不需要去懂了，从始至终感动的只有我自己。海底月捞不起，心上人不可及，向来心是看客心，奈何人是局中人。\n" +
            "\n" +
            "　　这世间最难不过徒手摘月，喜欢而不得。\n" +
            "\n" +
            "　　但我也想明白了，当我不能将一个人彻底忘却，就好好珍藏，封存在某个不易察觉的角落，午夜阑珊的时候悄悄想去。生不逢时，喜欢不逢人，所得之处皆是命数。白茶清欢无别事，我在等风也等你，苦酒折留今相离，无风无月也无你。\n" +
            "\n" +
            "　　当年我说的凤囚凰那首诗也许他早已忘记，有美人兮，见之不忘，一日不见兮，思之如狂。凤飞遨翔兮，四海求凰，无奈佳人兮，不在东墙。将琴代语兮，聊写衷肠，愿言配德兮，携手相将。何时见许兮，慰我旁徨，不得于飞兮，使我沦亡，使我沦亡。本想暗示他我喜欢过他，终是没有说出口下阙。\n" +
            "\n" +
            "　　蝴蝶很美，终究飞不过沧海，某些性质上我和他一样，都是内心远没有看起来的风平浪静，实则是波涛起伏，曾想过愿我如星君如月，夜夜流光相皎洁。\n" +
            "\n" +
            "　　所谓执念，不过求而不得，不过难以割舍，不想错过，可终究情深是我，缘浅是我们，落花有意，流水无情，竟是付诸东流，若是如此，就这样吧，从此山水不相逢，愿若干年后的我们是最好的我们，蝴蝶很美，终究飞不过沧海，生生的两端，我们彼此站成岸。何来人间一惊鸿，不过人间一俗人。从此相忘江湖，若许不相识，也愿我遇到比你更好的人，说了那么多轻松多了，写下这些也是为了忘记放下他，虽然以前想过有时候放不下是最好的放下，无论他是否看得到，就这样吧，至此纪念我初中的喜欢，你是年少的欢喜，但也是过去时。我也要努力学习，考的比他更好。";

    @Test
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("标准分词", standard(article));
        map.put("NLP分词", nlp(article));
        map.put("索引分词", index(article));
        map.put("N-最短路径分词", nShort(article));
        map.put("最短路径分词", shortest(article));
        map.put("极速词典分词", speed(article));


        log.info("=> {}", map);
    }
}
