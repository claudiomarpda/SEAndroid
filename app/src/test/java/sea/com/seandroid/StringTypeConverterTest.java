package sea.com.seandroid;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import sea.com.seandroid.util.StringTypeConverter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class StringTypeConverterTest {

    private List<String> list;

    @Before
    public void setup() {
        list = Arrays.asList("One", "Two", "Three");
    }

    @Test
    public void convertStringListToStringShouldSucceed() {
        String s = StringTypeConverter.stringListToString(list);
        List<String> l = StringTypeConverter.stringToStringList(s);
        assertNotNull(l);
        assertEquals(list.get(0), l.get(0));
    }

}
