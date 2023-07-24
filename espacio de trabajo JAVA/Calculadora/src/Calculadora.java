
public class Calculadora {

	
	private double operandOne;
	private double operandTwo;
	private double total; 
	private String operator;
	
	public void performOperator() {
		if (operator == "+") {
			this.total = operandOne + operandTwo;
		} else if(operator == "-") {
			this.total = operandOne - operandTwo;
		}else {
			System.out.println("el operador es invalido, por favor, ingrese + para realizar una suma o - para realizar una resta.");
		}
	}

	public double getTotal() {
		System.out.println("resultado: " + total);
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
