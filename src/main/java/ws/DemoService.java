package ws;

import data.AMessages;
import data.Messages;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;


@WebService
public class DemoService implements IDemo {

    @EJB
    data.Messages messages;


    @Override
    @WebMethod
    @WebResult(name = "addResult")
    public boolean add(@WebParam(name = "user") String user,
                       @WebParam(name = "message") String message) {

        if (user != null && message != null) {

            return messages.addMessage(user, message);
        }else {
            return false;
        }
    }

    @Override
    @WebMethod
    @WebResult(name = "getMessageResult")
    public String getMessage(@WebParam(name = "user") String user,
                             @WebParam(name = "index") int index) {

        if (user != null) {

            return messages.getMessage(user, index);
        }else {
            return null;
        }
    }

    @Override
    @WebMethod
    @WebResult(name = "getAllMessageResult")
    public List<String> getAllMessage(@WebParam(name = "user") String user) {

        if (user != null) {

            return messages.getMessageList(user);
        }else {
            return null;
        }
    }
}
