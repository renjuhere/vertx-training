package com.ibm.fp.interfaces.lambda.labs;

@FunctionalInterface
interface Resolve<T> {
	void execute(T payload);
}

@FunctionalInterface
interface Reject<T> {
	void execute(T payload);
}

class User {
	String username;
	String password;

	User(String user, String pwd) {
		this.username = user;
		this.password = pwd;
	}
	
	public String getUser() {
		return this.username;
	}
}

class Login {
	
	User user;
	
	Login(User user){
		this.user = user;
	}
	
	public void validate(Resolve<User> resolve, Reject<User> reject) {

		if (user.username.equals("user") && user.password.equals("pwd")) {
			resolve.execute(user);
		} else {
			reject.execute(user);
		}
	}
}

public class RunLogin {
	public static void main(String[] args) {

		User user = new User("user", "pwd");
		
		Login login = new Login(user);
		
		Resolve<User> resolve = (userObj) -> {
			System.out.println("Login success for User " + userObj.getUser());
		};

		Reject<User> reject = (userObj) -> {
			System.out.println("Login failed for User " + userObj.getUser());
		};
		
		login.validate(resolve, reject);		
	}
}
