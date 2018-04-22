package sea.com.seandroid;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import sea.com.seandroid.data.model.Knowledge;
import sea.com.seandroid.util.KnowledgeTypeConverter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class KnowledgeTypeConverterTest {

    private List<Knowledge> knowledgeList;

    @Before
    public void setup() {
        knowledgeList = Arrays.asList(
                new Knowledge("k01", "Title ", "Knowledge description"),
                new Knowledge("k02", "Title", "Knowledge description")
        );
    }

    @Test
    public void convertKnowledgeListToStringShouldSucceed() {
        String s = KnowledgeTypeConverter.knowledgeListToString(knowledgeList);
        List<Knowledge> l = KnowledgeTypeConverter.stringToKnowledgeList(s);
        assertNotNull(l);
        assertEquals(knowledgeList.get(0).getId(), l.get(0).getId());
    }
}
