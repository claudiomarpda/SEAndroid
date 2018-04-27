package sea.com.seandroid;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import sea.com.seandroid.data.model.ContactRequest;
import sea.com.seandroid.util.converter.ContactRequestTypeConverter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ContactRequestTypeConverterTest {

    private List<ContactRequest> list;

    @Before
    public void setup() {
        list = Arrays.asList(
                new ContactRequest("id01", "c01", "c02"),
                new ContactRequest("id02", "c03", "c04")
        );
    }

    @Test
    public void convertKnowledgeListToStringShouldSucceed() {
        String s = ContactRequestTypeConverter.objectListToString(list);
        List<ContactRequest> l = ContactRequestTypeConverter.stringToObjectList(s);
        assertNotNull(l);
        assertEquals(list.get(0).getFromUserId(), l.get(0).getFromUserId());
        assertEquals(list.get(1).getFromUserId(), l.get(1).getFromUserId());
    }
    
}
