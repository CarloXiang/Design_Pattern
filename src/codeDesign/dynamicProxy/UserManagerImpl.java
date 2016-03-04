package codeDesign.dynamicProxy;


/**
 * 用户管理真正的实现类
 */
public class UserManagerImpl implements UserManager {

    /**
     * 添加用户
     * @param userId
     * @param userName
     */
    @Override
    public void addUser(String userId, String userName) {
        System.out.printf("正在添加用户，用户为：" + userId + userName + "......");
    }

    @Override
    public void modifyUser(String userId, String userName) {
        System.out.printf("modifyUser,userId="+userId);
    }

    /**
     * 删除用户
     * @param userId
     */
    @Override
    public void delUser(String userId) {
        System.out.printf("delUser,userId="+userId);
    }

    /**
     * 查找用户
     * @param userId
     * @return
     */
    @Override
    public String findUser(String userId) {
        System.out.printf("findUser,userId="+userId);
        return userId;
    }
}
