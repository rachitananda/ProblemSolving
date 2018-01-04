package com.problem.solving;

public abstract class BaseProblem {
	
	public BaseProblem() {
		System.out.println(getClass().asSubclass(this.getClass()));
	}
	public abstract void execute();


}
