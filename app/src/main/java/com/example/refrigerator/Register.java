package com.example.refrigerator;

/**
 * 회원가입을 하는 클래스.
 */
public class Register extends UserInfo{
    /**
     * 생성자
     * @param name 유저 이름
     * @param id 유저 id
     * @param pwd 유저 pwd
     * @param userMode 유저 권한
     */
    public Register(String name, String id, String pwd, Integer userMode){
        super(name,id,pwd,userMode);
    }

    /**
     * 회원가입
     * DB에 정보를 저장한다.
     * @param db
     * @return true 임의값.
     */
    public boolean doRegister(DB db){
        db.addUserInfo(this);
        return true;
    }
}
