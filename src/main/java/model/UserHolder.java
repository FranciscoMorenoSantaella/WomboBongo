package model;

import DAOImp.UsuariosDAOImp;

public class UserHolder {
	 private UsuariosDAOImp us;
	  private final static UserHolder INSTANCE = new UserHolder();

	  private UserHolder() {
	  }

	  public static UserHolder getInstance() {
	    return INSTANCE;
	  }

	  public void setUserDAO(UsuariosDAOImp u) {
	    this.us = u;
	  }

	  public UsuariosDAOImp getUser() {
	    return this.us;

	  }
}
