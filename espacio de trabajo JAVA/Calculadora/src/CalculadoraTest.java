
public class CalculadoraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calculoUno = new Calculadora();
		
			calculoUno.setOperandOne(12.5);
			calculoUno.setOperator("-");
			calculoUno.setOperandTwo(5.2);
			calculoUno.performOperator();
			calculoUno.getTotal();
			
}
}