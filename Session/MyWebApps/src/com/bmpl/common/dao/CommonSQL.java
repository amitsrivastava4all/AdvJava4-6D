package com.bmpl.common.dao;

public interface CommonSQL {
  public static final String USER_SQL= "select userid,password, username,"
  		+ "role_master.name as rolename,role_master.descr as roledescr, "
  		+ "right_master.name,right_master.descr, right_master.screenname from"
  		+ " user_master,role_master,user_role_mapping urmap,right_master,"
  		+ " role_right_mapping rrmap where userid=? and password=? "
  		+ "and user_master.status='Y' and role_master.roleid=urmap.roleid "
        +"  and user_master.uid = urmap.uid and"
        + " right_master.rightid = rrmap.rightid and "
        + "role_master.roleid=rrmap.roleid";
}
