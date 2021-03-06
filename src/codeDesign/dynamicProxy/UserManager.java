package codeDesign.dynamicProxy;

/**
 * 用户控制接口
 */
public interface UserManager {
    public void addUser(String userId, String userName);
    public void modifyUser(String userId, String userName);
    public void delUser(String userId);
    public String findUser(String userId);
}
