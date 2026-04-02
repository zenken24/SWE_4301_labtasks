package service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UserService {

    @WebMethod
    String createUser(String username, int id, String password);

    @WebMethod
    String getUser(int id);

    @WebMethod
    String updateUser(int id, String username, String password);

    @WebMethod
    String deleteUser(int id);
}