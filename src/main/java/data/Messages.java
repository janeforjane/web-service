package data;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Singleton
@LocalBean
public class Messages extends AMessages {

//    private Map<String, List<String>> messages;

    @Override
    public String getMessage(String user, int index) throws InvalidParameterException {

        for (Map.Entry<String, List<String>> entry : messages.entrySet()) {

            String key = entry.getKey();
            if (key.equals(user)) {

                List<String> list = entry.getValue();
                int listSize = list.size();

                if (listSize > index) {
                    String s = list.get(index);
                    return s;
                }
            }
        }
        return null;
    }

    @Override
    public boolean addMessage(String user, String message) {

        if (user != null && message != null) {

            if (messages.containsKey(user)) {
                List<String> list = messages.get(user);
                list.add(message);
                return true;

            } else {

                List<String> list = new ArrayList<String>();
                list.add(message);
                messages.put(user, list);

                return true;
            }
        }else {
            return false;
        }
    }

    @Override
    public List<String> getMessageList(String user) {

        for (Map.Entry<String, List<String>> entry : messages.entrySet()) {

            String key = entry.getKey();

            if (key.equals(user)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
