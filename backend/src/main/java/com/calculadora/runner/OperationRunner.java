package com.calculadora.runner;

import com.calculadora.Operation;

public class OperationRunner {
	private Operation op;

	public Operation getOp() {
		return op;
	}

	public void setOp(Operation op) {
		this.op = op;
	}
	
	public double soma() {
		return this.op.getA() + this.getOp().getB();
	}
	
	public double subtracao() {
		return this.op.getA() - this.getOp().getB();
	}
	
	public double multiplicacao() {
		return this.op.getA() * this.getOp().getB();
	}
	
	public double divisao() {
		return (double)((double)this.op.getA() / (double)this.getOp().getB());
	}
}
