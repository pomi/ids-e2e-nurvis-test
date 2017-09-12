import com.thomascook.Config;
import com.thomascook.toscaExtrasAdapter.response.OTAPkgExtrasInfoRS;
import com.thomascook.utils.Holder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RunWith(Cucumber.class)
//@CucumberOptions(tags = {"@Tosca"},
//        monochrome = true,
//        features = "src/test/cucumber/",
//        format = {"pretty",
//                "html:cucumber-html-reports",
//                "json:cucumber-html-reports/cucumber.json"},
//        glue = "com.thomascook.ids.e2e")
public class RunCucumberTest {

    private static final Logger logger = LoggerFactory.getLogger(RunCucumberTest.class);

    @BeforeClass
    public static void setUp() {
//        Config.initConfig();
//        logger.info(Config.getConfig().toString());
    }

    @Test
    public void vovov(){
        logger.info(Config.get().getMsdBaseUrl());
        logger.info(Config.get().getSolrUk());
        logger.info(Config.get().toString());
//        Holder.setToscaExtrasResponse(new OTAPkgExtrasInfoRS());
//        logger.error(Holder.getToscaExtrasResponse().toString());
//        Holder.getProperties().put("dkdkd", "aaaauuuuiiii");
        logger.warn((String) Holder.getProperties().get("dkdkd"));
    }
}
