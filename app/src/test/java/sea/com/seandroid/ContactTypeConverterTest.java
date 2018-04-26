package sea.com.seandroid;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import sea.com.seandroid.data.model.Contact;
import sea.com.seandroid.util.ContactTypeConverter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class ContactTypeConverterTest {

    private List<Contact> list;

    @Before
    public void setup() {
        list = Arrays.asList(
                new Contact("c01"),
                new Contact("c02", Contact.Status.FRIEND)
        );
    }

    @Test
    public void convertKnowledgeListToStringShouldSucceed() {
        String s = ContactTypeConverter.objectListToString(list);
        List<Contact> l = ContactTypeConverter.stringToObjectList(s);
        assertNotNull(l);
        assertEquals(list.get(0).getContactId(), l.get(0).getContactId());
    }
}
