package cn.chenzw.dependence.maven.model;

import lombok.extern.slf4j.Slf4j;
import org.apache.maven.model.Model;
import org.apache.maven.model.Repository;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@RunWith(JUnit4.class)
public class MavenModelTests {

    @Test
    public void test() throws XmlPullParserException, IOException {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("pom.xml");
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(is);
        List<Repository> list = model.getRepositories();
        log.info("repository => {}", list);
    }
}
